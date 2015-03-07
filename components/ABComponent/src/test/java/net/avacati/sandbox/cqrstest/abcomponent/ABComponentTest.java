package net.avacati.sandbox.cqrstest.abcomponent;

import org.junit.Assert;
import org.junit.Test;

public class ABComponentTest {
    @Test
    public void SingleCaseHappyPath() throws NoPrimeNumbersException, EmptyNameException, ProhibitedNumberException {
        // Arrange
        IABFacade sut = new ABFacadeFactory().create();

        // Act
        sut.addA("foo");
        sut.addB("foo", "bar", 4);

        // Assert
        ABResult result = sut.query().stream().findFirst().get();
        Assert.assertEquals("foo", result.a);
        Assert.assertEquals("bar", result.b);
        Assert.assertEquals(4, result.i);
    }

    @Test
    public void MultiCaseHappyPath() throws NoPrimeNumbersException, EmptyNameException, ProhibitedNumberException {
        // Arrange
        IABFacade sut = new ABFacadeFactory().create();

        // Act
        sut.addA("foo");
        sut.addB("foo", "bar", 4);
        sut.addB("foo", "baz", 6);

        sut.addA("foo2");
        sut.addB("foo2", "bar2", 8);
        sut.addB("foo2", "baz2", 9);

        // Assert
        ABResult result = sut.query().get(0);
        Assert.assertEquals("foo", result.a);
        Assert.assertEquals("bar", result.b);
        Assert.assertEquals(4, result.i);

        result = sut.query().get(1);
        Assert.assertEquals("foo", result.a);
        Assert.assertEquals("baz", result.b);
        Assert.assertEquals(6, result.i);

        result = sut.query().get(2);
        Assert.assertEquals("foo2", result.a);
        Assert.assertEquals("bar2", result.b);
        Assert.assertEquals(8, result.i);

        result = sut.query().get(3);
        Assert.assertEquals("foo2", result.a);
        Assert.assertEquals("baz2", result.b);
        Assert.assertEquals(9, result.i);
    }

    @Test(expected=NoPrimeNumbersException.class)
    public void NoPrimeNumbers() throws NoPrimeNumbersException, EmptyNameException, ProhibitedNumberException {
        IABFacade sut = new ABFacadeFactory().create();
        sut.addA("foo");
        sut.addB("foo", "bar", 3);
    }

    @Test(expected=EmptyNameException.class)
    public void NoEmptyANames() throws EmptyNameException {
        IABFacade sut = new ABFacadeFactory().create();
        sut.addA("");
    }
}
