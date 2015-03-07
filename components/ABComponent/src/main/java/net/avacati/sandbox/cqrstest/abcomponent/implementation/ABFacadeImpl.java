package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import net.avacati.sandbox.cqrstest.abcomponent.*;

import java.util.List;

public class ABFacadeImpl implements IABFacade {
    private ICommandService commandService;
    private IQueryService queryService;

    public ABFacadeImpl(ICommandService commandService, IQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @Override
    public void addA(String name) throws EmptyNameException {
        this.commandService.addA(name);
    }

    @Override
    public void addB(String aName, String bName, int i) throws NoPrimeNumbersException, ProhibitedNumberException {
        this.commandService.addB(aName, bName, i);
    }

    @Override
    public List<ABResult> query() {
        return this.queryService.query();
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
