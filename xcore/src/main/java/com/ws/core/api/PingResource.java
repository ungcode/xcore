package com.ws.core.api;

import com.ws.core.services.PingService;

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

	@GET
	@Path("/{address}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response message(@PathParam ("address") String address) {
	 
		return Response.ok().entity(pingService.doPing(address)).build();
	}

}
