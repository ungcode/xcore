package com.ws.core.api;

import com.ws.core.models.ProductItem;
import com.ws.core.services.ProductItemService;
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


@Path( "productItem" )
public class ProductItemResource {

	
    @Inject
    ProductItemService productItemService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( ProductItem productItem )
    {

        return Response.ok( productItemService.persist( productItem ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( ProductItem productItem )
    {

        return Response.ok( productItemService.update( productItem ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( productItemService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( productItemService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( productItemService.fetch( id ) ).build();

    }
	
}