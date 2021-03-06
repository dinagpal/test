/**
 * 
 */
package net.trajano.test;

import java.util.Arrays;
import java.util.HashSet;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author
 */
@Path(".well-known/openid-configuration")
@Stateless
public class Resource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        OpenIdProviderConfiguration entity = new OpenIdProviderConfiguration();
        entity.setScopesSupported(new HashSet<>(Arrays.asList(Scope.OPENID, Scope.ADDRESS)));
        return Response.ok(entity).build();
    }
}
