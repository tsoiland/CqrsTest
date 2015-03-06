package net.avacati.sandbox.cqrstest.crudcomponent;

import java.util.ArrayList;
import java.util.List;

public class CrudPublicBus {
    private List<ProhibitedNumberListener> prohibitedNumbersListeners;

    public CrudPublicBus() {
        this.prohibitedNumbersListeners = new ArrayList<>();
    }

    public void AddProhibitedNumberListener(ProhibitedNumberListener listener) {
        this.prohibitedNumbersListeners.add(listener);
    }

    public void Raise(ProhibitNumberEvent event) {
        this.prohibitedNumbersListeners.forEach(l -> l.handle(event));
    }

    public void Raise(AllowNumberEvent event) {
        this.prohibitedNumbersListeners.forEach(l -> l.handle(event));
    }
}
