package net.avacati.sandbox.cqrstest.abcomponent.implementation;

public class NewBEvent {
    public String name;
    public int i;
    public int aId;

    public NewBEvent(int aId, String name, int i) {
        this.aId = aId;
        this.name = name;
        this.i = i;
    }
}
