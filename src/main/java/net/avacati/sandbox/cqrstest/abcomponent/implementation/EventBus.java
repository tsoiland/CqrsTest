package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import java.util.ArrayList;
import java.util.List;

public class EventBus implements NewAEventListener, NewBEventListener {
    private List<NewAEventListener> aListeners;
    private List<NewBEventListener> bListeners;

    public EventBus() {
        this.aListeners = new ArrayList<>();
        this.bListeners = new ArrayList<>();
    }

    public void addAEventListener(NewAEventListener listener){
        this.aListeners.add(listener);
    }

    public void addBEventListener(NewBEventListener listener){
        this.bListeners.add(listener);
    }

    public void handle(NewAEvent event) {
        this.aListeners.stream().forEach(l -> l.handle(event));
    }

    public void handle(NewBEvent event) {
        this.bListeners.stream().forEach(l -> l.handle(event));
    }
}
