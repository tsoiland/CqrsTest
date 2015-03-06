package net.avacati.sandbox.cqrstest.abcomponent;

import net.avacati.sandbox.cqrstest.abcomponent.implementation.ABFacadeImpl;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.EventBus;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.command.CommandService;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.query.QueryService;

public class ABFacadeFactory {
    public IABFacade create() {
        EventBus bus = new EventBus();
        return new ABFacadeImpl(new CommandService(bus, bus), new QueryService(bus));
    }
}
