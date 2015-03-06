package net.avacati.sandbox.cqrstest.abcomponent.implementation;

import net.avacati.sandbox.cqrstest.abcomponent.ABResult;

import java.util.List;

public interface IQueryService {
    List<ABResult> query();
}
