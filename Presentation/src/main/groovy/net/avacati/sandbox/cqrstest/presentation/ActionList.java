package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.AbstractAction;
import java.util.ArrayList;

public class ActionList extends ArrayList<AbstractAction> {
    public ActionList() {
        SetupABControllerActions();
    }

    private void SetupABControllerActions() {
        this.add(ABController.index);
        this.add(ABController.adda);
        this.add(ABController.addapost);
        this.add(ABController.addb);
        this.add(ABController.addbpost);
    }
}
