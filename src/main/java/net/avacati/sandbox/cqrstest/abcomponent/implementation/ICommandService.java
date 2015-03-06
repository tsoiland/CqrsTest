package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import net.avacati.sandbox.cqrstest.abcomponent.EmptyNameException;
import net.avacati.sandbox.cqrstest.abcomponent.NoPrimeNumbersException;
import net.avacati.sandbox.cqrstest.abcomponent.ProhibitedNumberException;

public interface ICommandService {
    void addA(String name) throws EmptyNameException;
    void addB(String aName, String bName, int i) throws NoPrimeNumbersException, ProhibitedNumberException;
    void prohibitNumber(int number);
    void allowNumber(int number);
}
