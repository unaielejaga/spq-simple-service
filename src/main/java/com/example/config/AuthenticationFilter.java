package com.example.config;

import java.io.IOException;
import java.security.Principal;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import jakarta.annotation.Priority;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the HTTP Authorization header from the request
        String authorizationHeader =
            requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {

            // Validate the token
           final String username = validateToken(token);
           
           requestContext.setSecurityContext(new SecurityContext() {

               @Override
               public Principal getUserPrincipal() {

                   return new Principal() {

                       @Override
                       public String getName() {
                           return username;
                       }
                   };
               }

   			@Override
   			public boolean isUserInRole(String role) {
   				// TODO Auto-generated method stub
   				return false;
   			}

   			@Override
   			public boolean isSecure() {
   				// TODO Auto-generated method stub
   				return false;
   			}

   			@Override
   			public String getAuthenticationScheme() {
   				// TODO Auto-generated method stub
   				return null;
   			}
           });

        } catch (Exception e) {
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private String validateToken(String token) throws Exception {
        // Check if it was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
    	    Algorithm algorithm = Algorithm.HMAC256("secret");
    	    
    	    DecodedJWT decode = JWT.decode(token);
    	    System.out.println(decode.getExpiresAt());
    	    
	    	JWTVerifier verifier = JWT.require(algorithm)
	    			.withIssuer(decode.getIssuer())
	    			.acceptExpiresAt(60)
	    			.build();
	    	DecodedJWT decodedJWT = verifier.verify(token);
	    	return decodedJWT.getIssuer();
    	
    }

}