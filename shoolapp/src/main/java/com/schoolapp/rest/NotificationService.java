package com.schoolapp.rest;

import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.schoolapp.bean.Notification;
import com.schoolapp.util.DBUtil;
import com.schoolapp.util.NotificationUtil;

@Path("/notifications")
public class NotificationService {
	public String AUTH_KEY_FCM =null;;
	Properties fcmProperties = new Properties();	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendNotifications(Notification notification) {
		boolean result;
		result = DBUtil.getInstance().sendNotifications(notification);
		if(result){
			
		if(AUTH_KEY_FCM == null){
			fetchFCMroperties();
			if(AUTH_KEY_FCM == null){
				return Response.status(200).entity(false).build();
			}
		}
			List<String> deviceList = DBUtil.getInstance().getDeviceIds(notification,true);
			if(deviceList.size()>0){// android{
				result = 	NotificationUtil.send_FCM_NotificationMulti(deviceList, "token", AUTH_KEY_FCM, notification.getNotificationTitle(),notification.getNotificationMessage(),true);
			if(!result)
				Response.status(200).entity(result).build();
			}
			deviceList = DBUtil.getInstance().getDeviceIds(notification,false);
			if(deviceList.size()>0){// ios
				NotificationUtil.send_FCM_NotificationMulti(deviceList, "token", AUTH_KEY_FCM, notification.getNotificationTitle(),notification.getNotificationMessage(),false);
				if(!result)
					Response.status(200).entity(result).build();
			}
		}
		return Response.status(200).entity(result).build();
	
	}
	
	private void fetchFCMroperties() {
		
		try {
			Class<NotificationService> cl = NotificationService.class;

			fcmProperties.load(cl.getResourceAsStream("/emailconfig.properties"));
			AUTH_KEY_FCM = fcmProperties.getProperty("AUTH_KEY_FCM");
		} catch (Exception e) {
			System.out.println("fetchFCMroperties exception --- " + e.getMessage());
		}
	}
}


