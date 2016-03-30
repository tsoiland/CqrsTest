package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.jetty.JettyServer;
import net.avacati.lib.mvc.MvcServletFactory;

import javax.servlet.Servlet;

public class Main {
    public static void main(String[] args) throws Exception {
        // Mvc
        final Servlet servlet = MvcServletFactory.createMvcServlet(new ActionList(), new ControllerFactoryImpl());

        // Jetty
        new JettyServer(servlet, 8080).startAndJoin();
    }
}
