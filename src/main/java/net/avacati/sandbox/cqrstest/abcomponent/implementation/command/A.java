package net.avacati.sandbox.cqrstest.abcomponent.implementation.command;

import net.avacati.sandbox.cqrstest.abcomponent.EmptyNameException;
import net.avacati.sandbox.cqrstest.abcomponent.NoPrimeNumbersException;

import java.util.ArrayList;
import java.util.List;

class A {
    private String name;
    private List<B> bList;
    private int id;

    A(int id, String name) throws EmptyNameException {
        if(name.length() == 0)
            throw new EmptyNameException();
        this.id = id;
        this.name = name;
        this.bList = new ArrayList<B>();
    }

    void AddB(String bName, int i) throws NoPrimeNumbersException {
        B b = new B(bName, i);
        this.bList.add(b);
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
