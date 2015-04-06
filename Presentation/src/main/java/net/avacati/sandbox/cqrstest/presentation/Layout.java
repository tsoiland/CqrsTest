package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.actionresults.ViewResult;

public class Layout extends ViewResult {
    private ViewResult view;
    private ViewResult menu;

    public Layout(ViewResult view, ViewResult menu) {
        this.view = view;
        this.menu = menu;
    }

    @Override
    public String render() {
        return "" +
                "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "   <title>Cqrstest application</title>" +
                "   <meta http-equiv='Content-Type' content='text/html;charset=utf-8' />" +
                "   <link rel='stylesheet' type='text/css' href='/content/style.css' />" +
                "   <script type='text/javascript' src='/content/script.js'></script>" +
                "</head>" +
                "<body>" +
                "   <div id='menu'>" +
                        this.menu.render() +
                "   </div>" +
                "   <div id='container'>" +
                        this.view.render() +
                "   </div>" +
                "</body>" +
                "</html>";
    }
}
