package com.ws.core.api;

import com.ws.core.models.UserReview;
import com.ws.core.services.UserReviewService;
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


@Path( "userReview" )
public class UserReviewResource {

	
    @Inject
    UserReviewService userReviewService;


    @POST
    @Produces( MediaType.APPLICATION_JSON )
    public Response persist( UserReview userReview )
    {

        return Response.ok( userReviewService.persist( userReview ) ).build();

    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    public Response update( UserReview userReview )
    {

        return Response.ok( userReviewService.update( userReview ) ).build();

    }

    @DELETE
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response delete( @PathParam( "id" ) Long id )
    {

        return Response.ok( userReviewService.delete( id ) ).build();

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetchAll()
    {

        return Response.ok().entity( userReviewService.fetchAll() ).build();

    }

    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response fetch( @PathParam( "id" ) Long id )
    {

        return Response.ok().entity( userReviewService.fetch( id ) ).build();

    }
	
}
