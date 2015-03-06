package net.avacati.sandbox.cqrstest.crudcomponent.implementation;

import net.avacati.sandbox.cqrstest.crudcomponent.*;

import java.util.HashMap;
import java.util.Map;

public class ProhibitionService implements IProhibitionService {
    private Map<Integer, ProhibitedNumberDto> prohibitedNumberRepository;
    private int nextId;
    private CrudPublicBus bus;

    public ProhibitionService(CrudPublicBus bus) {
        this.bus = bus;
        this.prohibitedNumberRepository = new HashMap<Integer, ProhibitedNumberDto>();
    }

    @Override
    public int Add(ProhibitedNumberDto dto) {
        int id = this.nextId++;
        this.prohibitedNumberRepository.put(id, dto);
        this.bus.Raise(new ProhibitNumberEvent(dto.number));
        return id;
    }

    @Override
    public void Edit(int id, ProhibitedNumberDto dto) {
        int oldNumber = this.prohibitedNumberRepository.get(id).number;
        if(dto.number != oldNumber) {
            this.bus.Raise(new ProhibitNumberEvent(dto.number));
            this.bus.Raise(new AllowNumberEvent(oldNumber));
        }

        this.prohibitedNumberRepository.remove(id);
        this.prohibitedNumberRepository.put(id, dto);
    }

    @Override
    public void Delete(int id) {
        this.prohibitedNumberRepository.remove(id);
        this.bus.Raise(new AllowNumberEvent(id));
    }

    @Override
    public ProhibitedNumberDto Get(int id){
        return this.prohibitedNumberRepository.get(id);
    }
}
