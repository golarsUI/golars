package com.schoolapp.rest;

import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.schoolapp.bean.Settings;
import com.schoolapp.bean.User;
import com.schoolapp.util.DBUtil;

@Path("/settings")
public class SettingsService {
	public String AUTH_KEY_FCM =null;;
	Properties fcmProperties = new Properties();	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveSettings(Settings[] settings) {
		boolean result;
		result = DBUtil.getInstance().saveSettings(settings);

		return Response.status(200).entity(result).build();
	
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getSettings() {
		List<User> settingsList = DBUtil.getInstance().getSettings(false,null);
		return Response.status(201).entity(new Gson().toJson(settingsList) ).build();
	
	}
}


