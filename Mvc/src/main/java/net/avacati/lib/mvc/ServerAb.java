package net.avacati.lib.mvc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;


public class ServerAb {
    private Servlet servlet;

    public ServerAb(Servlet servlet) {
        this.servlet = servlet;
    }

    public void StartServer() throws Exception {
        // Create server
        Server server = new Server(8080);

        // Register servlet
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(servlet), "/");
        server.setHandler(handler);

        // Start
        server.start();
        server.join();
    }

}
