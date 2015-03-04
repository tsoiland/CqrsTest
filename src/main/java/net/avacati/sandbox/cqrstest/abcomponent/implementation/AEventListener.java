package net.avacati.sandbox.cqrstest.abcomponent.implementation;

public interface AEventListener {
    void handle(NewAEvent event);
}
