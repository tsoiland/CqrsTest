package net.avacati.lib.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Route {
    private ArrayList<AbstractAction> actions;
    private ControllerFactory controllerFactory;

    public Route(ArrayList<AbstractAction> actions, ControllerFactory controllerFactory) {
        this.actions = actions;
        this.controllerFactory = controllerFactory;
    }

    public MyResponse route(String url, Map<String, String> postdata) throws Throwable {
        return this.actions
                    .stream()
                    .filter(action -> action.url.equals(url))
                    .findAny()
                    .get()
                    .performAction(postdata, controllerFactory)
                    .createResult(this);
    }

    public List<AbstractAction> getMenuActions() {
        return this.actions
                .stream()
                .filter(a -> a.isMenuItem())
                .collect(Collectors.toList());
    }
}
