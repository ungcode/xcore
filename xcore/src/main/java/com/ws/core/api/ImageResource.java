package com.ws.core.api;

import com.ws.core.models.Image;
import com.ws.core.services.ImageService;
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


@Path( "images" )
public class ImageResource {

    @Inject
    ImageService imageService;

    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( Image image )
    {

        return Response.ok( imageService.persist( image ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Image image )
    {

        return Response.ok( imageService.update( image ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( imageService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        Samples samples = new Samples();

        System.out.println( "begin running..." );

        List< Image > images = ( List< Image > )samples.getData()
                                                       .get( "images" );

        System.out.println( "images: "
                            + images.toString() );

        images.forEach( image -> {

            // imageService.persist( image );
        } );

        System.out.println( "end running..." );

        return Response.ok().entity( imageService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( imageService.fetch( id ) ).build();

    }
	
}
