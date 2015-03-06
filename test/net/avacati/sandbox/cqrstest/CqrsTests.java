package net.avacati.sandbox.cqrstest;

import net.avacati.sandbox.cqrstest.abcomponent.*;
import net.avacati.sandbox.cqrstest.crudcomponent.CrudPublicBus;
import net.avacati.sandbox.cqrstest.crudcomponent.CrudServiceFactory;
import net.avacati.sandbox.cqrstest.crudcomponent.IProhibitionService;
import net.avacati.sandbox.cqrstest.crudcomponent.ProhibitedNumberDto;
import org.junit.Test;

public class CqrsTests {
    @Test(expected=ProhibitedNumberException.class)
    public void a() throws NoPrimeNumbersException, EmptyNameException, ProhibitedNumberException {
        // Arrange ABComponent
        IABFacade abFacade = new ABFacadeFactory().create();

        // Arrange CrudComponent
        CrudServiceFactory factory = new CrudServiceFactory();
        IProhibitionService prohibitionService = factory.create();
        CrudPublicBus crudBus = factory.getCrudPublicBus();

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
        IABFacade abFacade = new ABFacadeFactory().create();

        // Arrange CrudComponent
        CrudServiceFactory factory = new CrudServiceFactory();
        IProhibitionService prohibitionService = factory.create();
        CrudPublicBus crudBus = factory.getCrudPublicBus();

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
