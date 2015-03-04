package net.avacati.sandbox.cqrstest;

import net.avacati.sandbox.cqrstest.abcomponent.ABFacade;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.EventBus;

public class ProhibitedNumberHandler implements ProhibitedNumberListener {
    private ABFacade abFacade;

    @Override
    public void handle(ProhibitNumberEvent event) {
        this.abFacade.prohibitNumber(event.number);
    }

    @Override
    public void handle(AllowNumberEvent event) {
        this.abFacade.allowNumber(event.number);
    }
}
