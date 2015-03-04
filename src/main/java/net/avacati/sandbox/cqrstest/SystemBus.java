package net.avacati.sandbox.cqrstest;

import java.util.ArrayList;
import java.util.List;

public class SystemBus {
    private List<ProhibitedNumberListener> prohibitedNumbersListeners;

    public SystemBus() {
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
