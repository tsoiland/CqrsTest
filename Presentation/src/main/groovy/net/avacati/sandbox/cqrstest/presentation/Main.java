package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.MvcServerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        new MvcServerFactory()
            .createMvcServer(new ActionList(), new ControllerFactoryImpl())
            .StartServer();
    }
}
