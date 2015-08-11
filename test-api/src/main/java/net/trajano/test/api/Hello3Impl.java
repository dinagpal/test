/**
 * 
 */
package net.trajano.test.api;

/**
 * @author Archimedes Trajano
 */
public class Hello3Impl implements Hello3 {

    /* (non-Javadoc)
     * @see net.trajano.test.api.Hello3#echo(java.lang.String)
     */
    @Override
    public String echo(String e) {

        System.out.println(e);
        return e;
    }

}
