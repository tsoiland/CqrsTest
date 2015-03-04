package net.avacati.sandbox.cqrstest.abcomponent.implementation.command;

import net.avacati.sandbox.cqrstest.abcomponent.implementation.EventBus;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewAEvent;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewBEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandService {
    private Map<String, A> aRepository;
    private int nextId;
    private EventBus bus;
    private List<Integer> prohibitNumbers;

    public CommandService(EventBus bus) {
        this.bus = bus;
        this.aRepository = new HashMap<String, A>();
        this.prohibitNumbers = new ArrayList<>();
    }

    public void AddA(String name) throws EmptyNameException {
        A a = new A(this.nextId++, name);
        this.aRepository.put(name, a);

        this.bus.raise(new NewAEvent(a.getId(), a.getName()));
    }

    public void AddB(String aName, String bName, int i) throws NoPrimeNumbersException {
        A a = this.aRepository.get(aName);
        a.AddB(bName, i);

        this.bus.raise(new NewBEvent(a.getId(), bName, i));
    }

    public void prohibitNumber(int number) {
        this.prohibitNumbers.add(number);
    }

    public void allowNumber(int number) {
        this.prohibitNumbers.remove(number);
    }
}
