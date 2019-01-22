package com.teluguassociation.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.teluguassociation.util.MailUtil;

@Path("/submitForm")
public class SubmitForm {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFacilitiesAndCompanies() {
		System.out.println("get");
		return Response.status(200).entity(true).build();

	}
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Response postForms(MultivaluedMap<String, String> form) {
		
		new MailUtil().sendEmail(form);
		return Response.status(200).entity("Details submitted succesfully.  <a href=\"javascript:history.back()\">Click here to Go Back</a>").build();

	}
	
	
}