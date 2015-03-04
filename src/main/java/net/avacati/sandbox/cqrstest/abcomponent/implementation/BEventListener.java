package net.avacati.sandbox.cqrstest.abcomponent.implementation;

public interface BEventListener {
    void handle(NewBEvent event);
}
