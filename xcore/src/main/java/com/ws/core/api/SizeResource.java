package com.ws.core.api;

import com.ws.core.models.Size;
import com.ws.core.services.SizeService;
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


@Path( "sizes" )
public class SizeResource {

	
    @Inject
    SizeService sizeService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( Size size )
    {

        return Response.ok( sizeService.persist( size ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Size size )
    {

        return Response.ok( sizeService.update( size ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( sizeService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( sizeService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( sizeService.fetch( id ) ).build();

    }
	
}
