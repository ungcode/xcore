package com.ws.core.api;

import com.ws.core.models.Category;
import com.ws.core.services.CategoryService;
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


@Path( "categories" )
public class CategoryResource {

	
    @Inject
    CategoryService categoryService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( Category category )
    {

        return Response.ok().entity( categoryService.persist( category ) )
                       .build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Category category )
    {

        return Response.ok().entity( categoryService.update( category ) )
                       .build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( categoryService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {


        return Response.ok().entity( categoryService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( categoryService.fetch( id ) ).build();

    }
	
}
