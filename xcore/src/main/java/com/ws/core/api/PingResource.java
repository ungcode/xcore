package com.ws.core.api;

import com.ws.core.models.Tuser;
import com.ws.core.services.PingService;
import com.ws.core.services.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ping")
public class PingResource {

	
	@Inject 
	PingService pingService;

	@Inject
	UserService userService;
	 
	@GET
	@Path("/{address}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response message(@PathParam ("address") String address) {
	
		String password = "abc123xyz";
		Tuser user = new Tuser();
		user.setEmail("user1@gmail.com");
		user.setName("user1");
		user.setPhone("1234333");

		//userService.persist(user, password);

		return Response.ok().entity(pingService.doPing(address)).build();
	}

}
