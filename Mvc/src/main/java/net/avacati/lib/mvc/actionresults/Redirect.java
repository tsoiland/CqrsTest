package net.avacati.lib.mvc.actionresults;

import net.avacati.lib.mvc.*;

public class Redirect implements ActionResult {
    private Action action;

    public Redirect(Action action) {
        this.action = action;
    }

    @Override
    public MyResponse perform(Route route) {
        RedirectResponse response = new RedirectResponse();
        response.status = 301;
        response.url = this.action.url;
        return response;
    }
}
