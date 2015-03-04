package net.avacati.sandbox.cqrstest.crudcomponent;

import net.avacati.sandbox.cqrstest.AllowNumberEvent;
import net.avacati.sandbox.cqrstest.ProhibitNumberEvent;
import net.avacati.sandbox.cqrstest.SystemBus;

import java.util.HashMap;
import java.util.Map;

public class ProhibitionService {
    private Map<Integer, ProhibitedNumber> prohibitedNumberRepository;
    private int nextId;
    private SystemBus bus;

    public ProhibitionService(SystemBus bus) {
        this.bus = bus;
        this.prohibitedNumberRepository = new HashMap<Integer, ProhibitedNumber>();
    }

    public void Add(ProhibitedNumber dto) {
        this.prohibitedNumberRepository.put(this.nextId++, dto);
        this.bus.Raise(new ProhibitNumberEvent(dto.number));
    }

    public void Edit(int id, ProhibitedNumber dto) {
        int oldNumber = this.prohibitedNumberRepository.get(id).number;
        if(dto.number != oldNumber) {
            this.bus.Raise(new ProhibitNumberEvent(dto.number));
            this.bus.Raise(new AllowNumberEvent(oldNumber));
        }

        this.prohibitedNumberRepository.remove(id);
        this.prohibitedNumberRepository.put(id, dto);
    }

    public void Delete(int id) {
        this.prohibitedNumberRepository.remove(id);
        this.bus.Raise(new AllowNumberEvent(id));
    }

    public ProhibitedNumber Get(int id){
        return this.prohibitedNumberRepository.get(id);
    }
}
