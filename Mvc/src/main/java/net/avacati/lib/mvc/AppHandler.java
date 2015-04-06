package net.avacati.lib.mvc;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AppHandler extends AbstractHandler {
    private Route route;

    public AppHandler(Route route) {
        this.route = route;
    }

    public void handle(String url, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        baseRequest.setHandled(true);
        String post = this.ReadBigStringIn(request.getReader());

        Map<String,String> postdata = post.isEmpty() ? new HashMap<>() :
                Arrays.stream(post.split("&"))
                .map(p -> p.split("="))
                .collect(Collectors.toMap(
                            k -> k[0],
                            k->k[1]));

        MyResponse myResponse = null;
        try {
            myResponse = this.route.route(url, postdata);
        } catch (Throwable throwable) {
            myResponse = new ErrorResponse(throwable);
        }

        switch (myResponse.status){
            case 301:
                response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
                response.setHeader("location", ((RedirectResponse)myResponse).url);
                break;
            case 200:
                response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
                response.getWriter().println(((OkResponse)myResponse).data);
                break;
            case 500:
                response.setStatus(myResponse.status);
                response.getWriter().println(((ErrorResponse)myResponse).message);
                break;
        }
    }

    public String ReadBigStringIn(BufferedReader buffIn) throws IOException {
        StringBuilder everything = new StringBuilder();
        String line;
        while( (line = buffIn.readLine()) != null) {
            everything.append(line);
        }
        return everything.toString();
    }
}

