package com.ws.core.api;

import com.ws.core.models.Product;
import com.ws.core.pagination.Pagination;
import com.ws.core.services.ProductService;
import com.ws.core.util.Samples;
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
import java.util.List;
import java.util.Map;


@Path( "products" )
public class ProductResource {

	
    @Inject
    ProductService productItemService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( Product productItem )
    {

        return Response.ok( productItemService.persist( productItem ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Product productItem )
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

        Samples sample = new Samples();
        Map< String, Object > data = sample.getData();
        List< Product > products = ( List< Product > )data.get( "products" );
        products.forEach( product -> {

            // productItemService.persist( product );
        } );
        return Response.ok().entity( productItemService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {


        return Response.ok().entity( productItemService.fetch( id ) ).build();

    }

    @GET
    @Path( "/{pages}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response pagination( Pagination pagination )
    {


        return Response.ok()
                       .entity( productItemService.pagination( pagination ) )
                       .build();

    }

	
}
