package net.avacati.sandbox.cqrstest;

public interface ProhibitedNumberListener {
    void handle(ProhibitNumberEvent event);
    void handle(AllowNumberEvent event);
}
