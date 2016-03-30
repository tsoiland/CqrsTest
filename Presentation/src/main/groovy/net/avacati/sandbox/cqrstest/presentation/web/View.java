package net.avacati.sandbox.cqrstest.presentation.web;

import net.avacati.lib.mvc.AbstractAction;
import net.avacati.lib.mvc.actionresults.ViewResult;

import java.util.List;

public abstract class View extends ViewResult {
    @Override
    public String wrapRender(List<AbstractAction> menuActions) {
        return new Layout(this, new Menu(menuActions)).render();
    }
}

