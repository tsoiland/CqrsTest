package net.avacati.lib.mvc;

import java.util.ArrayList;

public class MvcServerFactory {

    public ServerAb createMvcServer(ArrayList<AbstractAction> actions, ControllerFactory controllerFactory) {
        AppHandler appHandler = new AppHandler(new Route(actions, controllerFactory));
        HandlerProvider handlerProvider = new HandlerProvider(appHandler, "content");
        return new ServerAb(handlerProvider);
    }
}
