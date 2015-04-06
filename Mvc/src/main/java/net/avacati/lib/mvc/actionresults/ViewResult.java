package net.avacati.lib.mvc.actionresults;

import net.avacati.lib.mvc.OkResponse;
import net.avacati.lib.mvc.Route;

public abstract class ViewResult implements ActionResult {
    @Override
    public OkResponse perform(Route route) {
        OkResponse response = new OkResponse();
        response.data = this.render();
        response.status = 200;
        return response;
    }

    public abstract String render();
}

