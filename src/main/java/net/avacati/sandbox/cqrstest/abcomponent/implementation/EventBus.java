package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private List<AEventListener> aListeners;
    private List<BEventListener> bListeners;

    public EventBus() {
        this.aListeners = new ArrayList<AEventListener>();
        this.bListeners = new ArrayList<BEventListener>();
    }

    public void addAEventListener(AEventListener listener){
        this.aListeners.add(listener);
    }

    public void addBEventListener(BEventListener listener){
        this.bListeners.add(listener);
    }

    public void raise(NewAEvent event) {
        this.aListeners.stream().forEach(l -> l.handle(event));
    }

    public void raise(NewBEvent event) {
        this.bListeners.stream().forEach(l -> l.handle(event));
    }
}
