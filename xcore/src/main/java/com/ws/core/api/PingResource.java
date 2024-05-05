package com.ws.core.api;

import com.ws.core.models.Category;
import com.ws.core.services.CategoryService;
import com.ws.core.services.PingService;
import com.ws.core.util.Test;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ping")
public class PingResource {

	
	@Inject 
	PingService pingService;

    @Inject
    CategoryService categoryService;

	@GET
	@Path("/{address}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response message(@PathParam ("address") String address) {

        Category category = Test.createCategory();

        CategoryService persistService = categoryService.persist( category );
        return Response.ok().entity( persistService ).build();
	 
        // return Response.ok().entity(pingService.doPing(address)).build();
	}

}
