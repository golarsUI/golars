package com.golars.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import com.golars.bean.Folder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Custom_Attachments__c;
import com.sforce.soap.enterprise.sobject.Regulatory_Record__c;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class GolarsUtil {
	private static Properties salesforceProperties = new Properties();
	static EnterpriseConnection connection;

	public static Folder getChildren(Folder currentNode, List<Folder> folderList) {
		for (Folder pair : folderList) {
			String parentid = currentNode.getParentid().equalsIgnoreCase("Null") ? currentNode.getId() + ""
					: currentNode.getParentid() + currentNode.getId() + "";
			if (pair.getParentid().equals(parentid)) {
				currentNode.getChildren().add(pair);
				if (pair.getParentid() != null) {
					getChildren(pair, folderList);
				}

			}

		}
		return currentNode;

	}

	public static String checkFIDExists(String documentProperties, boolean facilityRelated, String regulatoryType) {
						
		String fid = null;
		if (!facilityRelated) {
			fid = new Gson().fromJson(documentProperties, JsonObject.class).get("fid") != null
					? new Gson().fromJson(documentProperties, JsonObject.class).get("fid").toString() : null;
			if (fid == null || fid.equalsIgnoreCase("\"\""))
				return null;
			
			String result =null;
			if(regulatoryType!=null && regulatoryType.equalsIgnoreCase("Account"))
				result = DBUtil.getInstance().checkFidExistsInAccount(fid);
			else if(regulatoryType!=null && regulatoryType.equalsIgnoreCase("Lead"))
				result = DBUtil.getInstance().checkFidExistsInLeed(fid);
				
			return result;
		}
		return "ignore";
	}

	private static String getDescription(String documentProperties) {
		String description = new Gson().fromJson(documentProperties, JsonObject.class).get("description") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("description").getAsString() : "";
		return description;
	}
	private static String getUpdateDocumentDate(String documentProperties){
		String docUpdateDate = new Gson().fromJson(documentProperties, JsonObject.class).get("docUpdateDate") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("docUpdateDate").getAsString() : "";
		return docUpdateDate;
	}
	private static String getType(String documentProperties) {
		String type = new Gson().fromJson(documentProperties, JsonObject.class).get("compliaceDocumentType") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("compliaceDocumentType").getAsString() : "";
		return type;
	}
	private static String getDesription(String documentProperties) {
		String description = new Gson().fromJson(documentProperties, JsonObject.class).get("description") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("description").getAsString() : "";
		return description;
	}
	private static String getRequestFrom(String documentProperties) {
		String description = new Gson().fromJson(documentProperties, JsonObject.class).get("requestFrom") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("requestFrom").getAsString() : "g360";
		return description;
	}
	private static String getDocUpdateDate(String documentProperties) {
		String docUpdateDate = new Gson().fromJson(documentProperties, JsonObject.class).get("docUpdateDate") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("docUpdateDate").getAsString() : "";
		return docUpdateDate;
	}
	
	private static String getFid(String documentProperties) {
		String fid = new Gson().fromJson(documentProperties, JsonObject.class).get("fid") != null
				? new Gson().fromJson(documentProperties, JsonObject.class).get("fid").toString() : null;
		return fid;
	}

	public static Folder getCurrentNode(int fId, List<Folder> folderList) {
		for (Folder pair : folderList) {
			if (pair.getId() == fId)
				return pair;
		}
		return null;
	}

	public static SaveResult[] saveDocumentURLINTOSalesForce(String url,String documentProperties,String accountId, String fileName, String regulatoryType, boolean facilityRelated, boolean regulatoryRecord, String stateProgram, String scopeOfWork) {

		try {
			Class<GolarsUtil> cl = GolarsUtil.class;

			salesforceProperties.load(cl.getResourceAsStream("/salesforce.properties"));
		} catch (Exception e1) {
			System.out.println("Email Configuration fiele not found" + e1.getMessage());
		}
		if(getRequestFrom(documentProperties).equalsIgnoreCase("golarsTank"))
			return null;
		final String USERNAME = salesforceProperties.getProperty("salesforceusername");
		final String PASSWORD = salesforceProperties.getProperty("salesforcepassword");
		final String g360URL = salesforceProperties.getProperty("golar360URL");
		Calendar docLastUpdateDate = Calendar.getInstance();
		Calendar docUpdateDate = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		SaveResult[] saveResults = null;
		try {
			ConnectorConfig config = new ConnectorConfig();
			config.setUsername(USERNAME);
			config.setPassword(PASSWORD);
			connection = Connector.newConnection(config);

		try {
			String updatedDate = getUpdateDocumentDate(documentProperties);
			if(updatedDate == null || updatedDate.equalsIgnoreCase(""))
				updatedDate = sdf.format(new Date());
			docLastUpdateDate.setTime(sdf.parse(updatedDate));
			String docUpdateLocalDate = sdf.format(new Date());
			docLastUpdateDate.setTime(sdf.parse(docUpdateLocalDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}// all done
		if(regulatoryRecord){
		
		Regulatory_Record__c[] regulatory_Record = new Regulatory_Record__c[1];
		regulatory_Record[0] = new Regulatory_Record__c();
		regulatory_Record[0].setDocument_Link__c(g360URL + "/" + url);
		regulatory_Record[0].setDocument_Type__c(getType(documentProperties));
		if(regulatoryType!=null && regulatoryType.equalsIgnoreCase("Account"))
			regulatory_Record[0].setFacility__c(accountId);
		else if(regulatoryType!=null && regulatoryType.equalsIgnoreCase("Lead"))
			regulatory_Record[0].setLead__c(accountId);
		regulatory_Record[0].setIs_Active__c(regulatoryRecord);
		regulatory_Record[0].setScope_of_Work__c(scopeOfWork);
		regulatory_Record[0].setState_Program__c(stateProgram);
		regulatory_Record[0].setLast_Update__c(docUpdateDate);
		regulatory_Record[0].setDocument_Date__c(docLastUpdateDate);
		saveResults = connection.create(regulatory_Record);
		}else{
		Custom_Attachments__c[] contact = new Custom_Attachments__c[1];
		contact[0] = new Custom_Attachments__c();
		contact[0].setContact__c(accountId);
		contact[0].setName(fileName);
		contact[0].setType__c(getType(documentProperties));
		contact[0].setSource__c("g360");
		contact[0].setG360_URL__c(g360URL + "/" + url);
		contact[0].setDescription__c(getDescription(documentProperties));
		
		contact[0].setReport_Date__c(docUpdateDate);
		saveResults = connection.create(contact);

		}
			System.out.println(saveResults+"--------saveResults the error length is "+saveResults[0].getErrors().length);
			if (saveResults!=null && saveResults[0]!= null && saveResults[0].getErrors().length > 0) {
				System.out.println(saveResults+"--------The error is "+saveResults[0].getErrors()[0]);
				return saveResults;
			}
		} catch (ConnectionException e) {
			System.out.println("Exception in saveDocumentURLINTOSalesForce--"+e.getMessage());
			return null;
		}
		return null;
		
	}

}