/**
 * 
 */
package net.trajano.test.ejb2;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import net.trajano.test.api.Hello2;

/**
 * @author Archimedes Trajano
 */
@Stateless
public class HelloEjb2 implements Hello2 {

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
