package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import net.avacati.sandbox.cqrstest.abcomponent.ABFacade;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.command.CommandService;

public class ABFacadeImpl implements ABFacade {
    private CommandService commandService;

    public ABFacadeImpl(CommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public void prohibitNumber(int number) {
        this.commandService.prohibitNumber(number);
    }

    @Override
    public void allowNumber(int number) {
        this.commandService.allowNumber(number);
    }
}
