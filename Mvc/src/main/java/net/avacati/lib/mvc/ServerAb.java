package net.avacati.lib.mvc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;

public class ServerAb {
    private HandlerProvider handlerProvider;

    public ServerAb(HandlerProvider handlers) {
        this.handlerProvider = handlers;
    }

    public void StartServer() throws Exception {
        // Create server
        Server server = new Server(8080);

        // Register handlerProvider
        HandlerList list = new HandlerList();
        list.setHandlers(this.handlerProvider.createHandlers());
        server.setHandler(list);

        // Start
        server.start();
        server.join();
    }

}
