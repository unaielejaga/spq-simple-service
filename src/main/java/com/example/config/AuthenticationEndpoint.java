package com.example.config;

import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.jdo.Credentials;
import com.example.jdo.Distribuidor;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response authenticateUser(Credentials credentials) {
    	
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        try {

            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    	
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Distribuidor> q = pm.newQuery(Distribuidor.class);
		List<Distribuidor> distris = q.executeList();
		pm.close();
		
		boolean loginCorrecto = false;
		
		for(Distribuidor dis : distris) {
			if(dis.getNombre().equals(username)) {
				if(dis.getPassword().equals(password)) {
					loginCorrecto = true;
				}
			}
		}
    	
		if(!loginCorrecto) throw new Exception("Login Incorrecto");
    }

    private String issueToken(String username) {
    	try {
    	    Algorithm algorithm = Algorithm.HMAC256("secret");
    	    long expireTime = (new Date().getTime()) + 150000;
            Date expireDate = new Date(expireTime);
    	    String token = JWT.create()
    	        .withIssuer(username)
    	        .withExpiresAt(expireDate)
    	        .sign(algorithm);
    	    return token;
    	} catch (JWTCreationException exception){
    	    //Invalid Signing configuration / Couldn't convert Claims.
    		return null;
    	}	
    }
}
