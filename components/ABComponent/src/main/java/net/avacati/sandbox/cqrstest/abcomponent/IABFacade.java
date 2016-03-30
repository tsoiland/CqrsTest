package net.avacati.sandbox.cqrstest.abcomponent;

import java.util.Collection;
import java.util.List;

public interface IABFacade {
    void addA(String name);
    void addB(String aName, String bName, int i);
    List<ABResult> query();
    void prohibitNumber(int number);
    void allowNumber(int number);
    Collection<String> getAllA();
}
