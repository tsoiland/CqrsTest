package net.avacati.sandbox.cqrstest.crudcomponent;

public class ProhibitedNumberDto {
    public int number;
    public String Reason;

    public ProhibitedNumberDto(String reason, int number) {
        this.number = number;
        this.Reason = reason;
    }
}
