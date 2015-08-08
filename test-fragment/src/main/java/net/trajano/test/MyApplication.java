/**
 * 
 */
package net.trajano.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Archimedes Trajano
 */
@ApplicationPath("/V1")
public class MyApplication extends Application {

    /* (non-Javadoc)
     * @see javax.ws.rs.core.Application#getClasses()
     */
    @Override
    public Set<Class<?>> getClasses() {

        return new HashSet<Class<?>>(Arrays.asList(Resource.class));
    }
}
