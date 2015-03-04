package net.avacati.sandbox.cqrstest.abcomponent.implementation.command;

public class B {
    private final String bName;
    private final int i;

    public B(String bName, int i) throws NoPrimeNumbersException {
        if(this.isPrime(i))
            throw new NoPrimeNumbersException();

        this.bName = bName;
        this.i = i;
    }

    private boolean isPrime(int i) {
        if(i<2)
            return false;

        for (int j = 2; j < i; j++) {
            if (i%j == 0)
                return false;
        }

        return true;
    }
}
