package net.avacati.lib.mvc.actionresults;

import net.avacati.lib.mvc.MyResponse;
import net.avacati.lib.mvc.OkResponse;
import net.avacati.lib.mvc.Route;

import java.util.function.Consumer;

public interface ActionResult {
    MyResponse createResult(Route route);
}
