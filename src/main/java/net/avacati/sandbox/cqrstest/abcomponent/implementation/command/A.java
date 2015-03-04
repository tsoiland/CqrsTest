package net.avacati.sandbox.cqrstest.abcomponent.implementation.command;

import java.util.ArrayList;
import java.util.List;

public class A {
    private String name;
    private List<B> bList;
    private int id;

    public A(int id, String name) throws EmptyNameException {
        if(name.length() == 0)
            throw new EmptyNameException();
        this.id = id;
        this.name = name;
        this.bList = new ArrayList<B>();
    }

    public void AddB(String bName, int i) throws NoPrimeNumbersException {
        B b = new B(bName, i);
        this.bList.add(b);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
