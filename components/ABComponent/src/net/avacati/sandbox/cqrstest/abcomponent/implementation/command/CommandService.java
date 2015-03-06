package net.avacati.sandbox.cqrstest.abcomponent.implementation.command;

import net.avacati.sandbox.cqrstest.abcomponent.ProhibitedNumberException;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewAEventListener;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewBEventListener;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewAEvent;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewBEvent;
import net.avacati.sandbox.cqrstest.abcomponent.EmptyNameException;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.ICommandService;
import net.avacati.sandbox.cqrstest.abcomponent.NoPrimeNumbersException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandService implements ICommandService {
    private Map<String, A> aRepository;
    private int nextId;
    private List<Integer> prohibitNumbers;
    private NewAEventListener newAEventListener;
    private NewBEventListener newBEventListener;

    public CommandService(NewAEventListener newAEventListener, NewBEventListener newBEventListener) {
        this.newAEventListener = newAEventListener;
        this.newBEventListener = newBEventListener;
        this.aRepository = new HashMap<>();
        this.prohibitNumbers = new ArrayList<>();
    }

    @Override
    public void addA(String name) throws EmptyNameException {
        A a = new A(this.nextId++, name);
        this.aRepository.put(name, a);

        NewAEvent event = new NewAEvent(a.getId(), a.getName());
        this.newAEventListener.handle(event);
    }

    @Override
    public void addB(String aName, String bName, int i) throws NoPrimeNumbersException, ProhibitedNumberException {
        A a = this.aRepository.get(aName);
        if(this.prohibitNumbers.contains(i)){
            throw new ProhibitedNumberException();
        }
        a.AddB(bName, i);

        NewBEvent event = new NewBEvent(a.getId(), bName, i);
        this.newBEventListener.handle(event);
    }

    @Override
    public void prohibitNumber(int number) {
        this.prohibitNumbers.add(number);
    }

    @Override
    public void allowNumber(int number) {
        this.prohibitNumbers.remove(number);
    }
}