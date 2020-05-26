/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seguridad;

import com.auth0.jwt.exceptions.JWTVerificationException;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Enrique
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter{
private static final String AUTHENTICATION_SCHEME = "tiendaOnline";
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
       String authorizationHeader
                = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
       try {
            if (!validateToken(authorizationHeader)) {
                abortWithUnauthorized(requestContext);
            }
        } catch (JWTVerificationException e) {
            abortWithUnauthorized(requestContext);
        }
    }
    
     private boolean validateToken(String token) throws JWTVerificationException {
        TokenProvider tokenProvider = new TokenProvider();
        return tokenProvider.decode(token);
    }
     
      private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE,
                                AUTHENTICATION_SCHEME + " realm=\"" + AUTHENTICATION_SCHEME + "\"")
                        .build());
    }
}
