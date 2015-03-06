package net.avacati.sandbox.cqrstest.abcomponent.implementation.query;

import net.avacati.sandbox.cqrstest.abcomponent.ABResult;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.EventBus;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.IQueryService;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewAEvent;
import net.avacati.sandbox.cqrstest.abcomponent.implementation.NewBEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryService implements IQueryService {
    private List<ABResult> data;
    private Map<Integer, String> aNames;

    public QueryService(EventBus bus) {
        bus.addAEventListener(this::handle);
        bus.addBEventListener(this::handle);

        this.data = new ArrayList<>();
        this.aNames = new HashMap<>();
    }

    @Override
    public List<ABResult> query() {
        return this.data
                .stream()
                .collect(Collectors.toList());
    }

    private void handle(NewAEvent event) {
        this.aNames.put(event.id, event.name);
    }

    private void handle(NewBEvent event) {
        this.data.add(new ABResult(this.aNames.get(event.aId), event.name, event.i));
    }
}
