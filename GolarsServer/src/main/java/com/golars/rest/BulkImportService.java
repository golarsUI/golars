package com.golars.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.golars.bean.Folder;
import com.golars.bean.User;
import com.golars.mail.MailUtil;
import com.golars.util.DBUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;

@Path("/bulkimport")
public class BulkImportService {
	String fileName = null;

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadExcelFile(@FormDataParam("fileUpload") FormDataBodyPart body,
			@FormDataParam("userName") final String userName) {
		for (BodyPart part : body.getParent().getBodyParts()) {

			InputStream is = part.getEntityAs(InputStream.class);
			ContentDisposition meta = part.getContentDisposition();
			if (meta.getFileName() != null) {
				try {
					fileName = meta.getFileName();
					byte[] theString = IOUtils.toByteArray(is);
					FileOutputStream out = new FileOutputStream(new File(fileName));
					out.write(theString);
					out.close();
				} catch (IOException e) {
					System.out.println("unable to execute Bulk import  exception is :" + e);
				}
			}

		}
		FileInputStream file;
		try {
			file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int totalURLCount = 0;
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			int totalcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i < sheet.getLastRowNum() - sheet.getFirstRowNum(); i++) {
				Cell cell = sheet.getRow(i).getCell(sheet.getRow(0).getLastCellNum() - 1);
				if (!getCellValue(cell).equalsIgnoreCase(""))
					totalURLCount++;
			}

			if (totalcount != totalURLCount)
				return Response.status(200).entity(10).build();
		} catch (Exception e) {
			return Response.status(200).entity(-1).build();
		}
		Thread bulkThread = new Thread() {
			public void run() {
				startImportingDocuments(userName, fileName);
			}
		};
		bulkThread.start();

		return Response.status(200).entity(0).build();
	}

	public void startImportingDocuments(String userName, String fileName) {
		int totalcount = 0;
		int insertCount = 0;
		String hostAddress = "http://golars360.com/";
		String urlMappintFile = "c:/golarsProd/bulkimport/urlmapping.xlsx";
		List<JsonObject> beanList = new ArrayList<JsonObject>();
		try {

			Properties configProperties = new Properties();
			try {
				Class<MailUtil> cl = MailUtil.class;

				configProperties.load(cl.getResourceAsStream("/emailconfig.properties"));
				hostAddress = configProperties.get("baseURL") + "";
				urlMappintFile = configProperties.get("urlMappintFile") + "";
			} catch (Exception e1) {
				System.out.println("configuration properties not founrd" + e1.getMessage());
			}
			FileInputStream file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			totalcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			// Iterate through each rows one by one

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				try {
					Row row = rowIterator.next();
					// For each row, iterate through all the columns
					JsonObject bean = new JsonObject();
					Cell cell = row.getCell(0);
					java.util.Date dateValue = null;
					if (cell != null)
						dateValue = cell.getDateCellValue();
					if (dateValue != null) {
						Date date = new Date(dateValue.getTime());
						bean.addProperty("docUpdateDate",
								(date.getMonth() + 1) + "/" + date.getDate() + "/" + (date.getYear() + 1900));
					}
					cell = row.getCell(1);
					if (cell != null)
						bean.addProperty("fecilityName", getCellValue(cell));
					dateValue = null;
					cell = row.getCell(2);
					if (cell != null)
						dateValue = cell.getDateCellValue();
					if (dateValue != null) {
						Date date = new Date(dateValue.getTime());
						bean.addProperty("docDate",
								(date.getMonth() + 1) + "/" + date.getDate() + "/" + (date.getYear() + 1900));
					}
					cell = row.getCell(3);
					if (cell != null)
						bean.addProperty("fid", getCellValue(cell) + "");
					cell = row.getCell(4);
					if (cell != null)
						bean.addProperty("stateProgram", getCellValue(cell));
					cell = row.getCell(5);
					if (cell != null)
						bean.addProperty("docTypes", getCellValue(cell));
					cell = row.getCell(6);
					if (cell != null)
						bean.addProperty("scopeOfWork", getCellValue(cell));
					cell = row.getCell(7);
					String path = null;
					if (cell != null)
						path = getCellValue(cell);
					cell = row.getCell(8);
					String remoteURL = null;
					if (cell != null)
						remoteURL = getCellValue(cell);
					if (remoteURL == null)
						break;
					String url = null;
					try {
						bean.addProperty("remoteURL", remoteURL);
						if (remoteURL.indexOf("fileName=") >= 0)
							url = remoteURL.substring(remoteURL.indexOf("fileName=") + "fileName=".length());
						else {
							url = gen() + "";
							if (remoteURL.endsWith(".pdf"))
								url += ".pdf";

						}
					} catch (Exception e) {
						url = gen() + "";
					}
					url = url.trim();
					bean.addProperty("url", url);
					cell = row.getCell(9);
					if (cell != null)
						bean.addProperty("id", getCellValue(cell));

					cell = row.getCell(10);
					if (cell != null)
						bean.addProperty("isActive", getCellValue(cell));

					URL xyz = new URL(remoteURL);
					URLConnection xyzcon = xyz.openConnection();
					bean.addProperty("username", userName);
					Folder folder = DBUtil.getInstance().getFolder(path);
					InputStream in = xyzcon.getInputStream();
					DBUtil.getInstance().saveDocument(in, url, new Gson().toJson(bean), folder);
					insertCount++;
					System.out.println(insertCount + " Files(s) imported of " + totalcount);
					System.out.println("File imported is " + url + " into " + path + " ");
					bean.addProperty("newURL", hostAddress + "golars/rest/import/" + folder.getId() + "/" + url);
					beanList.add(bean);
				} catch (Exception e) {
					System.out.println("Skip file import " + e.getMessage());
				}

			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeEntriesIntoFile(urlMappintFile, beanList);
		;

		System.out.println("Imported documents succesfully. " + totalcount + " documents Imported");
		User user = DBUtil.getInstance().getUser(userName);
		new MailUtil().bulkImportEmail(user, totalcount);
	}

	private String getCellValue(Cell cell) {
		if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue() + "";
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
			return cell.getBooleanCellValue() + "";
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return cell.getNumericCellValue() + "";
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
			return "";
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
			return "";
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
			return " ";
		}
		return " ";
	}

	private void writeEntriesIntoFile(String urlMappintFile, List<JsonObject> beanList) {
		String excelFilePath = urlMappintFile;

		try {
			String filename = excelFilePath + "mapping_" + new Date().getDate() + "_" + new Date().getMonth() + "_"
					+ new Date().getYear() + "_" + new Date().getHours() + "_" + new Date().getMinutes() + "_"
					+ new Date().getSeconds() + ".xlsx";
			File file = new File(filename);
			if (!file.exists())
				file.createNewFile();
			// FileInputStream inputStream = new FileInputStream(file);
			// Workbook workbook = WorkbookFactory.create(inputStream);

			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Mappings");
			Object[] bookHeader = { "Date Document Updated", "Facility Name", "Document Date", "FID", "State Program",
					"Document Type", "Scope of Work", "Is Active", "ID", "Old URL", "New URL", };

			// Object[][] bookData = {
			// { remoteURL, localURL},
			// };
			Row headerRow = sheet.createRow(0);
			// Create cells
			for (int i = 0; i < bookHeader.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue((String) bookHeader[i]);
			}
			String[] columnArray = new String[] { "docUpdateDate", "fecilityName", "docDate", "fid", "stateProgram",
					"docTypes", "scopeOfWork", "isActive", "id", "remoteURL", "newURL" };

			for (JsonObject rowObject : beanList) {
				int rowCount = sheet.getLastRowNum();
				Row row = sheet.createRow(++rowCount);
				for (int i = 0; i < columnArray.length; i++) {
					Cell cell = row.createCell(i);
					if (rowObject.get(columnArray[i]) != null) {
						cell.setCellValue(rowObject.get(columnArray[i]).getAsString());
					}

				}

			}

			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();

		} catch (IOException | EncryptedDocumentException ex) {
			System.out.println("unable to write to excel path " + urlMappintFile + " ----    " + ex.getMessage());
		}
	}

	public int gen() {
		Random r = new Random(System.currentTimeMillis());
		return 100000 + r.nextInt(200000);
	}
}