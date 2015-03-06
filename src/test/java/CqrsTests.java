import net.avacati.sandbox.cqrstest.IntegrationPoint;
import net.avacati.sandbox.cqrstest.abcomponent.EmptyNameException;
import net.avacati.sandbox.cqrstest.abcomponent.IABFacade;
import net.avacati.sandbox.cqrstest.abcomponent.NoPrimeNumbersException;
import net.avacati.sandbox.cqrstest.abcomponent.ProhibitedNumberException;
import net.avacati.sandbox.cqrstest.crudcomponent.AllowNumberEvent;
import net.avacati.sandbox.cqrstest.crudcomponent.CrudPublicBus;
import net.avacati.sandbox.cqrstest.crudcomponent.IProhibitionService;
import net.avacati.sandbox.cqrstest.crudcomponent.ProhibitedNumberDto;
import net.avacati.sandbox.cqrstest.crudcomponent.implementation.ProhibitionService;
import org.junit.Test;

public class CqrsTests {
    @Test(expected=ProhibitedNumberException.class)
    public void a() throws NoPrimeNumbersException, EmptyNameException, ProhibitedNumberException {
        // Arrange ABComponent
        IABFacade abFacade = ABComponentTest.getFacade();

        // Arrange CrudComponent
        CrudPublicBus crudBus = new CrudPublicBus();
        IProhibitionService prohibitionService = new ProhibitionService(crudBus);

        // Arrange integration
        new IntegrationPoint(abFacade, crudBus);

        // Arrange data
        prohibitionService.Add(new ProhibitedNumberDto("foo", 4));
        abFacade.addA("A");

        // Act
        abFacade.addB("A", "B", 4);
    }

    @Test
    public void b() throws NoPrimeNumbersException, EmptyNameException, ProhibitedNumberException {
        // Arrange ABComponent
        IABFacade abFacade = ABComponentTest.getFacade();

        // Arrange CrudComponent
        CrudPublicBus crudBus = new CrudPublicBus();
        IProhibitionService prohibitionService = new ProhibitionService(crudBus);

        // Arrange integration
        new IntegrationPoint(abFacade, crudBus);

        // Arrange data
        int id = prohibitionService.Add(new ProhibitedNumberDto("foo", 4));
        prohibitionService.Delete(id);

        abFacade.addA("A");

        // Act
        abFacade.addB("A", "B", 4);
    }
}
