package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.ControllerFactory;
import net.avacati.sandbox.cqrstest.abcomponent.ABFacadeFactory;
import net.avacati.sandbox.cqrstest.abcomponent.IABFacade;
import net.avacati.sandbox.cqrstest.presentation.web.ab.*;

public class ControllerFactoryImpl implements ControllerFactory {
    private final ABController abController;

    public ControllerFactoryImpl() {
        // Setup backend
        IABFacade facade = new ABFacadeFactory().create();

        // Setup frontend
        this.abController = new ABController(facade);
    }

    @Override
    public <C> C createController(Class<C> controllerClass) {
        if(controllerClass.equals(ABController.class)){
            return (C) this.abController;
        }

        throw new RuntimeException("Controllerfactory cannot instantiate " + controllerClass);
    }
}
