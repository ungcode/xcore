package com.ws.core.api;

import com.ws.core.models.ShippingAddress;
import com.ws.core.services.ShippingAddressService;
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


@Path( "shipping-addresses" )
public class ShippingAddressResource {

	
    @Inject
    ShippingAddressService shippingAddressService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( ShippingAddress shippingAddress )
    {

        return Response.ok( shippingAddressService.persist( shippingAddress ) )
                       .build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( ShippingAddress shippingAddress )
    {

        return Response.ok( shippingAddressService.update( shippingAddress ) )
                       .build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( shippingAddressService.delete( id ) )
                       .build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( shippingAddressService.fetchAll() )
                       .build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( shippingAddressService.fetch( id ) )
                       .build();

    }
	
}
