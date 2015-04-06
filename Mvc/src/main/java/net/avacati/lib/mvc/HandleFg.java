package net.avacati.lib.mvc;

import net.avacati.lib.mvc.actionresults.ActionResult;

import java.util.Map;

public interface HandleFg {
    ActionResult handle(Map<String,String> postData) throws Throwable;
}

