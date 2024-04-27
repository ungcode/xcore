package com.ws.core.api;

import com.ws.core.models.CartItem;
import com.ws.core.services.CartItemService;
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


@Path( "cartItem" )
public class CartItemResource {

	
    @Inject
    CartItemService cartItemService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( CartItem cartItem )
    {

        return Response.ok( cartItemService.persist( cartItem ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( CartItem cartItem )
    {

        return Response.ok( cartItemService.update( cartItem ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok( cartItemService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( cartItemService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( cartItemService.fetch( id ) ).build();

    }
	
}
