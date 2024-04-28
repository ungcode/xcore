package com.ws.core.api;

import com.ws.core.models.UserPayment;
import com.ws.core.services.UserPaymentService;
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


@Path( "userPayment" )
public class UserPaymentResource {

	
    @Inject
    UserPaymentService userPaymentService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( UserPayment userPayment )
    {

        return Response.ok( userPaymentService.persist( userPayment ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( UserPayment userPayment )
    {

        return Response.ok( userPaymentService.update( userPayment ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok( userPaymentService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( userPaymentService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( userPaymentService.fetch( id ) ).build();

    }
	
}
