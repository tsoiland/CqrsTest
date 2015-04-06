package net.avacati.lib.mvc;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorResponse extends MyResponse {
    public final String message;

    public ErrorResponse(Throwable throwable) {
        this.status = 500;
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        throwable.printStackTrace(writer);
        this.message = throwable.toString() + "<br/>"
        + sw.toString();
    }
}
