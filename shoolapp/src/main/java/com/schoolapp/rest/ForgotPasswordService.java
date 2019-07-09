package com.schoolapp.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.schoolapp.bean.User;
import com.schoolapp.mail.MailUtil;
import com.schoolapp.util.DBUtil;

@Path("/forgotpassword")
public class ForgotPasswordService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(String inputString) {
		// String email = new Gson().fromJson(emailAddress,
		// JsonObject.class).get("email").toString();
		String inputArray[] = inputString.split("&&@@#@");
		boolean result = false;
		User userobj = DBUtil.getInstance().checkUserPresent(inputArray[0]);

		if (userobj != null) {
			new MailUtil().sendforgotPasswordEmail(userobj.getEmailAddress(), userobj.getUsername(), inputArray[1]);
			result = true;
		}
		return Response.status(201).entity(result).build();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8022560668279505764L;

	// Method to send Notifications from server to client end.
	public final static String AUTH_KEY_FCM = "AAAA5eiYMOg:APA91bFkA2uGTXDceto0jVoo_5ktZmUDmfxUpR-Iq4dLU8JKE6e7dVaFoM03fGVQkzyIo3oTSgysh4IjQROTlw8TTRO8_zdS8Ts218cIehVcA4Wffv9oGXIAheci3O7B1jgpGCt3s-IR";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	public final static String DEVICE_ID = "f7iOlu0IRjo:APA91bEdIK1M5GeZxWrDt9zmqwe4C48qwreRg67npfUm5CemztN4RQknFpZXJBDOO4QgMpYN3yW-DJjAzOIw3RQjc9tFXRSruF2N76OrSWRbki47on64Xr60nOqv-hAEvkrQTbGvaxtX";

	// public final static String
	// DEVICE_ID="fO0XLqSzAfM:APA91bFLJLjQJciKvu7j9mfIQKmkwCSOBf2EGNz71opXsnU9aoq_i5bpn7qC1fZSD7UN3bAM-Xbu5T2zkNhtIV7fMMXEQGy1zPuEmF38lsFGUKIefHRsrt6ZASW7ncsZrcMUPme0SsK7";
	public static void main(String[] args) {
		String DeviceIdKey = DEVICE_ID;
		String authKey = AUTH_KEY_FCM;
		String FMCurl = API_URL_FCM;

		try {
			List<String> putIds2 = new ArrayList<String>();
			putIds2.add(DEVICE_ID);
			String type= "ios";
			send_FCM_NotificationMulti(putIds2,"token", AUTH_KEY_FCM, "Hi this is Srinivasa","Schoolapp",type);
			putIds2.clear();
			type= "android";
			putIds2.add("dfvRwbX8Xv0:APA91bFEFpZlk7Uc1jVa3YyO8VqXNpq8SAbpBmtP0t3e2m0rK2Ng0TB_mpL5PNu2eBGRmIAdwq5yqicDInuaQRgtgd9P7wcgofCOoBCAAj1mqquVRyVTWjM99J2_YwGY9_t7vV8gtFLO");
			putIds2.add("fyxUit-CAyE:APA91bHadLlyBGxW16EC5k--DgMqag5UhoxkH66OywkgnAV2ptaQyS8Yo4VkYX0ea69jnA5hW8xiwShxNrkx9tQQ-u5MbvoYYFGAilOsjgwTkrvgTEkIm90xrn9FPX58gMJZOoEfJOzL");
			send_FCM_NotificationMulti(putIds2,"token", AUTH_KEY_FCM, "Hi this is Srinivasa","Schoolapp",type);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void send_FCM_Notification(String tokenId, String server_key, String message) {

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
			JSONObject infoJson = new JSONObject();

			infoJson.put("title", "Alankit");
			infoJson.put("body", message);

			JSONObject json = new JSONObject();
			json.put("to", tokenId.trim());
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
					System.out.println("Notification Response : TokenId : " + tokenId + " Error occurred :");
				} else if (status == 501) {
					// server side error
					System.out.println("Notification Response : [ errorCode=ServerError ] TokenId : " + tokenId);
				} else if (status == 503) {
					// server side error
					System.out.println(
							"Notification Response : FCM Service is Unavailable  	    		TokenId : " + tokenId);
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

	static void send_FCM_NotificationMulti(List<String> putIds2, String tokenId, String server_key, String message,String title,String type) {
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
			if(type.equalsIgnoreCase("ios")){
				objData.put("notification", data);	
				data.put("body", message);
				}
			
			if(type.equalsIgnoreCase("android")){
				objData.put("data", data);
				data.put("message", message);
			}

			
			System.out.println("json :" + objData.toString());
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

			wr.write(objData.toString());
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
					System.out.println("Notification Response : TokenId : " + tokenId + "Error occurred :");
				} else if (status == 501) {
					// server side error
					System.out.println("Notification Response : [ errorCode=ServerError ] TokenId : " + tokenId);
				} else if (status == 503) {
					// server side error
					System.out.println("Notification Response : FCM Service is UnavailableTokenId : " + tokenId);
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
	}
}