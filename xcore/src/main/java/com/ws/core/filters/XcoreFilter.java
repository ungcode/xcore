package com.ws.core.filters;

import com.ws.core.util.XcoreLogger;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.ext.Provider;

@Provider
@PreMatching
public class XcoreFilter implements ContainerRequestFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext) {

			final String TAG = "XcoreFilter.filter";

        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        String token = parseAuthToken(authHeader);

				XcoreLogger.debug(TAG, TAG + "in action");
        if (!isValid(token)) {

            //throw new NotAuthorizedException("Bearer error=\"invalid_token\"");
        }

        String methodOverride = requestContext.getHeaderString("X-Http-Method-Override");
        if (methodOverride != null && !methodOverride.isBlank()) {
            requestContext.setMethod(methodOverride);
        }
    }

		// to do
    private String parseAuthToken(String httpHeader) {
        if (httpHeader == null || httpHeader.isEmpty()) 
        {
					// throw new NotAuthorizedException("Bearer");
        }
        return httpHeader;
    }

    private boolean isValid(String token) {
        return token != null && !token.isBlank();
    }

}