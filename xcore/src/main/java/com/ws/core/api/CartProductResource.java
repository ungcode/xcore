package com.ws.core.api;

import com.ws.core.models.CartProduct;
import com.ws.core.services.CartProductService;
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


@Path( "cartProducts" )
public class CartProductResource {

	
    @Inject
    CartProductService cartProductService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( CartProduct cartItem )
    {

        return Response.ok( cartProductService.persist( cartItem ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( CartProduct cartItem )
    {

        return Response.ok( cartProductService.update( cartItem ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok( cartProductService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( cartProductService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( cartProductService.fetch( id ) ).build();

    }
	
}
