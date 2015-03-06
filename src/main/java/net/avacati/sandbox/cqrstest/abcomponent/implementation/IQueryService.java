package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import net.avacati.sandbox.cqrstest.abcomponent.ABResult;

import java.util.List;

/**
 * Created by tsoiland on 06.03.2015.
 */
public interface IQueryService {
    List<ABResult> query();
}
