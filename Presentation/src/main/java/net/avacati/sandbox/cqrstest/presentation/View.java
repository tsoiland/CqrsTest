package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.OkResponse;
import net.avacati.lib.mvc.Route;
import net.avacati.lib.mvc.actionresults.ViewResult;

public abstract class View extends ViewResult {
    @Override
    public OkResponse perform(Route route) {
        OkResponse response = super.perform(route);
        response.data = new Layout(this, new Menu(route.getMenuActions())).render();
        return response;
    }
}

