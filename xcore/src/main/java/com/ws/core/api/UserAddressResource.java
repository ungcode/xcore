package com.ws.core.api;

import com.ws.core.models.UserAddress;
import com.ws.core.services.UserAddressService;
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


@Path( "userAddress" )
public class UserAddressResource {

	
    @Inject
    UserAddressService userAddressService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( UserAddress userAddress )
    {

        return Response.ok( userAddressService.persist( userAddress ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( UserAddress userAddress )
    {

        return Response.ok( userAddressService.update( userAddress ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok( userAddressService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( userAddressService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( userAddressService.fetch( id ) ).build();

    }
	
}
