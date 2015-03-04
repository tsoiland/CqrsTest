package net.avacati.sandbox.cqrstest.abcomponent;

public interface ABFacade {
    void prohibitNumber(int number);
    void allowNumber(int number);
}
