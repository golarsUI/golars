package com.schoolapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class NotificationUtil {
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// Method to send Notifications from server to client end.
	 public final static String AUTH_KEY_FCM = "AAAA5eiYMOg:APA91bEmWufboVTZiTjFGZuwPRVbkdMCBHXD97Jy_WJjm36FPtYPnpZj4Rvnh9gDDHeBh2Q8zIn_PFeOMbFf9axtlua2iF56gMS-9jSklEC9Xslj_JRoiRpACWxeJn96mt1XiBg7zGcL";
	 public final static String
	 DEVICE_ID="cFCqBnHcRU8:APA91bHTvj0iUa5BbfLlAuaSLoGL3GkFui3wWzt3GM0gfBzZCZBjFRoLarezvEubLkVdbNau89Q3MQJDEiEixynHQxuk50XcDgrwLdnxK-ifSxSGIaWVs6Xxjk0bteIiohqIsLhHCqgw";
	public static void main(String[] args) {

		try {
			List<String> putIds2 = new ArrayList<String>();
			putIds2.add(DEVICE_ID);
			// putIds2.add("f7iOlu0IRjo:APA91bEdIK1M5GeZxWrDt9zmqwe4C48qwreRg67npfUm5CemztN4RQknFpZXJBDOO4QgMpYN3yW-DJjAzOIw3RQjc9tFXRSruF2N76OrSWRbki47on64Xr60nOqv-hAEvkrQTbGvaxtX");
			send_FCM_NotificationMulti(putIds2, "token", AUTH_KEY_FCM, "Hi this is Srinivasa","this is sample message",true);
//			send_FCM_Notification();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void send_FCM_Notification() {

		try {
			// Create URL instance.
			URL url = new URL(API_URL_FCM);
			// create connection.
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// set method as POST or GET
			conn.setRequestMethod("POST");
			// pass FCM server key
			conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
			// Specify Message Format
			conn.setRequestProperty("Content-Type", "application/json");
			// Create JSON Object & pass value
			JSONObject infoJson = new JSONObject();

			infoJson.put("title", "Alankit");
			infoJson.put("body", "test Message");

			JSONObject json = new JSONObject();
			json.put("to", DEVICE_ID);
			json.put("notification", infoJson);

			System.out.println("json :" + json.toString());
			System.out.println("infoJson :" + infoJson.toString());
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			if (status != 0) {

				if (status == 200) {
					// SUCCESS message
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					System.out.println("Android Notification Response : " + reader.readLine());
				} else if (status == 401) {
					// client side error
					System.out.println("Notification Response : TokenId : " + AUTH_KEY_FCM + " Error occurred :");
				} else if (status == 501) {
					// server side error
					System.out.println("Notification Response : [ errorCode=ServerError ] TokenId : " + AUTH_KEY_FCM);
				} else if (status == 503) {
					// server side error
					System.out.println(
							"Notification Response : FCM Service is Unavailable  	    		TokenId : " + AUTH_KEY_FCM);
				}
			}
		} catch (MalformedURLException mlfexception) {
			// Prototcal Error
			System.out.println("Error occurred while sending push Notification!.." + mlfexception.getMessage());
		} catch (Exception mlfexception) {
			// URL problem
			System.out.println("Reading URL, Error occurred while sending push 	    		Notification!.."
					+ mlfexception.getMessage());
		}

	}

	public static boolean send_FCM_NotificationMulti(List<String> putIds2, String tokenId, String server_key,String title, String message,boolean isAndroid) {
		try {
		
			// Create URL instance.
			URL url = new URL(API_URL_FCM);
			// create connection.
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// set method as POST or GET
			conn.setRequestMethod("POST");
			// pass FCM server key
			conn.setRequestProperty("Authorization", "key=" + server_key);
			// Specify Message Format
			conn.setRequestProperty("Content-Type", "application/json");
			// Create JSON Object & pass value

			JSONArray regId = null;
			JSONObject objData = null;
			JSONObject data = null;
			objData = new JSONObject();

			regId = new JSONArray();
			for (int i = 0; i < putIds2.size(); i++) {
				regId.put(putIds2.get(i));
			}
			data = new JSONObject();
			
			data.put("title", title);
			
			objData.put("registration_ids", regId);
			
			if(isAndroid){
				objData.put("data", data);
				data.put("message", message);
			}else{
				objData.put("notification", data);	
				data.put("body", message);
			}

			
			System.out.println("json :" + objData.toString());
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

			wr.write(objData.toString());
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			System.out.println("json :" + 				status);
			if (status != 0) {

				if (status == 200) {
					// SUCCESS message
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					System.out.println("Android Notification Response : " + reader.readLine());
					return true;
				} else if (status == 401) {
					// client side error
					System.out.println("Notification Response : TokenId : " + tokenId + "Error occurred :");
					return false;
				} else if (status == 501) {
					// server side error
					System.out.println("Notification Response : [ errorCode=ServerError ] TokenId : " + tokenId);
					return false;
				} else if (status == 503) {
					// server side error
					System.out.println("Notification Response : FCM Service is UnavailableTokenId : " + tokenId);
					return false;
				}
			}
		} catch (MalformedURLException mlfexception) {
			// Prototcal Error
			System.out.println("Error occurred while sending push Notification!.." + mlfexception.getMessage());
		} catch (IOException mlfexception) {
			// URL problem
			System.out.println("Reading URL, Error occurred while sending push 	    		  Notification!.."
					+ mlfexception.getMessage());
		} catch (Exception exception) {
			// General Error or exception.
			System.out.println("Error occurred while sending push Notification!.." + exception.getMessage());
		}
		return false;
	}
}
