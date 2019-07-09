package com.schoolapp.rest;

import java.util.Timer;
import java.util.TimerTask;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.schoolapp.bean.DeviceInformation;
import com.schoolapp.util.DBUtil;

@Path("/deviceInfo")
public class DeviceInfoService {
	static{
		Timer t = new Timer( );
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	System.out.println("Db call-------------");
		    	DBUtil.getInstance().getSettings(false,null);

		    }
		}, 10000,3600000);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveDeviceInfo(@QueryParam("deviceId") String deviceId) {
			DeviceInformation deviceInfo = DBUtil.getInstance().retrieveDeviceInfo(deviceId);
		return Response.status(200).entity(deviceInfo).build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveDeviceInfo(DeviceInformation deviceInfo) {
		DeviceInformation deviceInfoResult = DBUtil.getInstance().saveOrUpdateDeviceInfo(deviceInfo);
		return Response.status(200).entity(deviceInfoResult).build();
	}

	
}