package net.avacati.sandbox.cqrstest.crudcomponent;

public interface IProhibitionService {
    int Add(ProhibitedNumberDto dto);

    void Edit(int id, ProhibitedNumberDto dto);

    void Delete(int id);

    ProhibitedNumberDto Get(int id);
}
