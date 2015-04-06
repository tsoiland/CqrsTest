package net.avacati.lib.mvc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Route {
    private List<Action> actions;

    public Route(List<Action> actions) {
        this.actions = actions;
    }

    public MyResponse route(String url, Map<String, String> postdata) throws Throwable {
        HandleFg handleFg = this.actions
                        .stream()
                        .filter(a -> a.url.equals(url))
                        .findAny()
                        .get()
                        .handle;

        return handleFg
                .handle(postdata)
                .perform(this);
    }

    public List<Action> getMenuActions() {
        return this.actions
                .stream()
                .filter(a -> a.isMenuItem())
                .collect(Collectors.toList());
    }
}
