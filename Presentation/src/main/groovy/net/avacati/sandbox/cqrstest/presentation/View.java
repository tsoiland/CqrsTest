package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.Route;
import net.avacati.lib.mvc.actionresults.ViewResult;

public abstract class View extends ViewResult {
    @Override
    public String wrapRender(Route route) {
        return new Layout(this, new Menu(route.getMenuActions())).render();
    }
}

