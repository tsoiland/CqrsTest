package net.avacati.sandbox.cqrstest;

import net.avacati.sandbox.cqrstest.abcomponent.IABFacade;
import net.avacati.sandbox.cqrstest.crudcomponent.AllowNumberEvent;
import net.avacati.sandbox.cqrstest.crudcomponent.CrudPublicBus;
import net.avacati.sandbox.cqrstest.crudcomponent.ProhibitNumberEvent;
import net.avacati.sandbox.cqrstest.crudcomponent.ProhibitedNumberListener;

public class IntegrationPoint{
    private IABFacade IABFacade;

    public IntegrationPoint(IABFacade iabFacade, CrudPublicBus crudPublicBus) {
        IABFacade = iabFacade;

        crudPublicBus.AddProhibitedNumberListener(new ProhibitedNumberListener() {
            @Override
            public void handle(ProhibitNumberEvent event) {
                IntegrationPoint.this.IABFacade.prohibitNumber(event.number);
            }

            @Override
            public void handle(AllowNumberEvent event) {
                IntegrationPoint.this.IABFacade.allowNumber(event.number);
            }
        });
    }
}
