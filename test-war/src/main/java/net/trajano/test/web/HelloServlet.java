/**
 * 
 */
package net.trajano.test.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import net.trajano.test.api.Hello;
import net.trajano.test.api.Hello2;

/**
 * @author Archimedes Trajano
 */
@Stateless
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1299139508649691557L;

    @EJB
    Hello hello;

    @EJB
    Hello2 hello2;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req,
        HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType(MediaType.TEXT_PLAIN);
        resp.getWriter().println("Hello=" + hello);
        resp.getWriter().println("Hello2=" + hello2);
    }
}
