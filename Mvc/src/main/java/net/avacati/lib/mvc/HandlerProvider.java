package net.avacati.lib.mvc;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class HandlerProvider {
    private Handler appHandler;
    private String contentPath;

    public HandlerProvider(AppHandler appHandler, String contentPath){
        this.appHandler = appHandler;
        this.contentPath = contentPath;
    }

    public Handler[] createHandlers() {
        Handler fs = this.createFileSystemhandler();
        Handler context = this.contextualizeHandler(fs, "/content");
        Handler context2 = this.contextualizeHandler(new RedirectTestHandler(), "/test");
        return new Handler[] { context, context2, this.appHandler};
    }

    private Handler createFileSystemhandler() {
        ResourceHandler handler = new ResourceHandler();

        handler.setDirectoriesListed(true);
        handler.setResourceBase(this.contentPath);

        return handler;
    }

    private Handler contextualizeHandler(Handler handler, String path) {
        ContextHandler contextHandler = new ContextHandler();

        contextHandler.setContextPath(path);
        contextHandler.setHandler(handler);

        return contextHandler;
    }
}
