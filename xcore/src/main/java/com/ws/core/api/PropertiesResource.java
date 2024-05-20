package com.ws.core.api;

import com.ws.core.models.Properties;
import com.ws.core.services.PropertiesService;
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


@Path( "properties" )
public class PropertiesResource {

	
    @Inject
    PropertiesService propertiesService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( Properties properties )
    {

        return Response.ok( propertiesService.persist( properties ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( Properties properties )
    {

        return Response.ok( propertiesService.update( properties ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( propertiesService.delete( id ) ).build();

    }


    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        List< Properties > properties = ( List< Properties > )new Samples().getData()
                                                                     .get( "properties" );

        properties.forEach( property -> {
            // propertiesService.persist( property );
        } );

        return Response.ok().entity( propertiesService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( propertiesService.fetch( id ) ).build();

    }
	
}
