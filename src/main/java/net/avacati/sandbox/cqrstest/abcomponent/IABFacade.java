package net.avacati.sandbox.cqrstest.abcomponent;

import java.util.List;

public interface IABFacade {
    void addA(String name) throws EmptyNameException;
    void addB(String aName, String bName, int i) throws NoPrimeNumbersException, ProhibitedNumberException;
    List<ABResult> query();
    void prohibitNumber(int number);
    void allowNumber(int number);
}
