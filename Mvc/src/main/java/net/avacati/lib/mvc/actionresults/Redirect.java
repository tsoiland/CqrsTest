package net.avacati.lib.mvc.actionresults;

import net.avacati.lib.mvc.*;

public class Redirect implements ActionResult {
    private AbstractAction action;

    public Redirect(AbstractAction action) {
        this.action = action;
    }

    @Override
    public MyResponse createResult(Route route) {
        RedirectResponse response = new RedirectResponse();
        response.status = 301;
        response.url = this.action.url;
        return response;
    }
}
