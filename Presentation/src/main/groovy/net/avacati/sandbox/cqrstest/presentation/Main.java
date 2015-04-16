package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.Action;
import net.avacati.lib.mvc.MvcServerFactory;
import net.avacati.sandbox.cqrstest.abcomponent.ABFacadeFactory;
import net.avacati.sandbox.cqrstest.abcomponent.IABFacade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        // Setup backend
        IABFacade facade = new ABFacadeFactory().create();

        // Setup frontend
        ABController abController = new ABController(facade);

        // Create route setup
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(abController.index);
        actions.add(abController.adda);
        actions.add(abController.addapost);
        actions.add(abController.addb);
        actions.add(abController.addbpost);

        // Start server
        new MvcServerFactory()
            .createMvcServer(actions)
            .StartServer();
    }
}
