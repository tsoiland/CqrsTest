package net.avacati.lib.mvc;

import java.util.ArrayList;

public class MvcServerFactory {

    public ServerAb createMvcServer(ArrayList<Action> actions) {
        AppHandler appHandler = new AppHandler(new Route(actions));
        HandlerProvider handlerProvider = new HandlerProvider(appHandler, "content");
        return new ServerAb(handlerProvider);
    }
}
