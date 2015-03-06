package net.avacati.sandbox.cqrstest.crudcomponent;

import net.avacati.sandbox.cqrstest.crudcomponent.ProhibitedNumberDto;

/**
 * Created by tsoiland on 06.03.2015.
 */
public interface IProhibitionService {
    int Add(ProhibitedNumberDto dto);

    void Edit(int id, ProhibitedNumberDto dto);

    void Delete(int id);

    ProhibitedNumberDto Get(int id);
}
