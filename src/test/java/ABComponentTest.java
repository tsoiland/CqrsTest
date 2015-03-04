import net.avacati.sandbox.cqrstest.abcomponent.implementation.EventBus;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.command.CommandService;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.command.EmptyNameException;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.command.NoPrimeNumbersException;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.query.ABResult;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.query.QueryService;
import org.junit.Assert;
import org.junit.Test;

public class ABComponentTest {
    @Test
    public void SingleCaseHappyPath() throws NoPrimeNumbersException, EmptyNameException {
        // Arrange
        EventBus bus = new EventBus();
        CommandService commandService = new CommandService(bus);
        QueryService queryService = new QueryService(bus);

        // Act
        commandService.AddA("foo");
        commandService.AddB("foo", "bar", 4);

        // Assert
        ABResult result = queryService.Query().stream().findFirst().get();
        Assert.assertEquals("foo", result.a);
        Assert.assertEquals("bar", result.b);
        Assert.assertEquals(4, result.i);
    }

    @Test
    public void MultiCaseHappyPath() throws NoPrimeNumbersException, EmptyNameException {
        // Arrange
        EventBus bus = new EventBus();
        CommandService commandService = new CommandService(bus);
        QueryService queryService = new QueryService(bus);

        // Act
        commandService.AddA("foo");
        commandService.AddB("foo", "bar", 4);
        commandService.AddB("foo", "baz", 6);

        commandService.AddA("foo2");
        commandService.AddB("foo2", "bar2", 8);
        commandService.AddB("foo2", "baz2", 9);

        // Assert
        ABResult result = queryService.Query().get(0);
        Assert.assertEquals("foo", result.a);
        Assert.assertEquals("bar", result.b);
        Assert.assertEquals(4, result.i);

        result = queryService.Query().get(1);
        Assert.assertEquals("foo", result.a);
        Assert.assertEquals("baz", result.b);
        Assert.assertEquals(6, result.i);

        result = queryService.Query().get(2);
        Assert.assertEquals("foo2", result.a);
        Assert.assertEquals("bar2", result.b);
        Assert.assertEquals(8, result.i);

        result = queryService.Query().get(3);
        Assert.assertEquals("foo2", result.a);
        Assert.assertEquals("baz2", result.b);
        Assert.assertEquals(9, result.i);
    }

    @Test(expected=NoPrimeNumbersException.class)
    public void NoPrimeNumbers() throws NoPrimeNumbersException, EmptyNameException {
        CommandService commandService = new CommandService(new EventBus());
        commandService.AddA("foo");
        commandService.AddB("foo", "bar", 3);
    }

    @Test(expected=EmptyNameException.class)
    public void NoEmptyANames() throws EmptyNameException {
        CommandService commandService = new CommandService(new EventBus());
        commandService.AddA("");
    }
}
