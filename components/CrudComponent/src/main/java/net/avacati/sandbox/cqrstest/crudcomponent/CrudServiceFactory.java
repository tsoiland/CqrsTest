package net.avacati.sandbox.cqrstest.crudcomponent;

import net.avacati.sandbox.cqrstest.crudcomponent.implementation.ProhibitionService;

public class CrudServiceFactory {
    private CrudPublicBus crudPublicBus;

    public IProhibitionService create(){
        this.crudPublicBus = new CrudPublicBus();
        return new ProhibitionService(this.crudPublicBus);
    }

    public CrudPublicBus getCrudPublicBus(){
        return this.crudPublicBus;
    }
}
