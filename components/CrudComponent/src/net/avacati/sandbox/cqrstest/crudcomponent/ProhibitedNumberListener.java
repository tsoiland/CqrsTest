package net.avacati.sandbox.cqrstest.crudcomponent;

public interface ProhibitedNumberListener {
    void handle(ProhibitNumberEvent event);
    void handle(AllowNumberEvent event);
}
