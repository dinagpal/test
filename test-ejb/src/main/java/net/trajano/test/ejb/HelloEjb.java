/**
 * 
 */
package net.trajano.test.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import net.trajano.test.api.Hello;

/**
 * @author Archimedes Trajano
 */
@Stateless
public class HelloEjb implements Hello {

    @PostConstruct
    public void init() {

        System.out.println("init " + this);
    }

    @Override
    public String echo(String e) {

        System.out.println(e);
        return e;
    }
}
