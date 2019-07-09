package com.schoolapp.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.schoolapp.bean.User;
import com.schoolapp.bean.UserResponse;
import com.schoolapp.util.DBUtil;
import com.schoolapp.util.TokenGenerator;

@Path("/login")
public class LoginService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response login(User user) {
		boolean isLoginSuccess = false;
		String username = user.getUsername();
		String password = user.getPassword();
		UserResponse response = new UserResponse();
		if(username == null || password == null){
			response.setLoginsuccess(isLoginSuccess);
			return Response.status(403).entity(response).build();
		}
		User userRes =  DBUtil.getInstance().login(username, password);
		if(userRes == null)
			return Response.status(200).entity(null).build();
		
		if(userRes !=null){// login successful
		response.setLoginsuccess(true);
		response.setAdmin(userRes.isAdmin());
		response.setNewlyCreated(userRes.isNewlyCreated());
		response.setUsername(userRes.getUsername());
		response.setFullName(userRes.getFirstName()+" "+userRes.getLastName());
		response.setToken(new TokenGenerator().generateToken(username));
		}

		return Response.status(200).entity(response).build();

	}

}