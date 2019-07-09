package com.schoolapp.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.schoolapp.bean.Alerts;
import com.schoolapp.util.DBUtil;

@Path("/alerts")
public class AlertService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllAlerts(@QueryParam("deviceId") String deviceId) {
		List<Alerts> notifications = DBUtil.getInstance().retrieveAllAlerts(deviceId);
		return Response.status(200).entity(notifications).build();
	
	}
}


