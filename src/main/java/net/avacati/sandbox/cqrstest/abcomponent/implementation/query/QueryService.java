package net.avacati.sandbox.cqrstest.abcomponent.implementation.query;

import net.avacati.sandbox.cqrstest.abcomponent.implementation.AEventListener;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.BEventListener;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.EventBus;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewAEvent;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewBEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryService implements AEventListener, BEventListener {
    private List<ABResult> data;
    private Map<Integer, String> aNames;

    public QueryService(EventBus bus) {
        bus.addAEventListener(this);
        bus.addBEventListener(this);

        this.data = new ArrayList<ABResult>();
        this.aNames = new HashMap<Integer, String>();
    }

    public List<ABResult> Query() {
        return this.data
                .stream()
                .collect(Collectors.toList());
    }

    public void handle(NewAEvent event) {
        this.aNames.put(event.id, event.name);
    }

    public void handle(NewBEvent event) {
        this.data.add(new ABResult(this.aNames.get(event.aId), event.name, event.i));
    }
}
