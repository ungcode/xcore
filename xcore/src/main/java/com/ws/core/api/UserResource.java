package com.ws.core.api;

import com.ws.core.models.Tuser;
import com.ws.core.services.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
public class UserResource {

	@Inject
	UserService userService;
	@POST
	@Produces(MediaType.APPLICATION_JSON)	
	public Response create(Tuser user) {
        return Response.ok( userService.persist( user ) ).build();
	}
	@PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Tuser user )
    {

        return Response.ok( userService.update( user ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( @PathParam( "id" ) Long id )
    {

        return Response.ok( userService.delete( id ) ).build();

    }
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok( userService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok( userService.fetch( id ) ).build();

    }

}
