package com.ws.core.api;

import com.ws.core.models.Product;
import com.ws.core.pagination.Pagination;
import com.ws.core.services.ProductService;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path( "products" )
public class ProductResource {

	
    @Inject
    ProductService productService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( JsonObject product )
    {
        return Response.ok( productService.persist( product ) ).build();
    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Product product )
    {
        return Response.ok( productService.update( product ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( productService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {
        return Response.ok().entity( productService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {
        return Response.ok().entity( productService.fetch( id ) ).build();

    }

    @GET
    @Path( "/{pages}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response pagination( Pagination pagination )
    {
        return Response.ok()
                       .entity( productService.pagination( pagination ) )
                       .build();

    }

	
}
