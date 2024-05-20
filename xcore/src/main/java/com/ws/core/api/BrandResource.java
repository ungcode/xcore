package com.ws.core.api;

import com.ws.core.models.Brand;
import com.ws.core.services.BrandService;
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


@Path( "brands" )
public class BrandResource {

	
    @Inject
    BrandService brandService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( Brand brand )
    {

        return Response.ok( brandService.persist( brand ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Brand brand )
    {

        return Response.ok( brandService.update( brand ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( brandService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( brandService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {
        return Response.ok().entity( brandService.fetch( id ) ).build();

    }
	
}
