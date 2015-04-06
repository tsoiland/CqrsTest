package net.avacati.lib.mvc;

public class Action {
    public String url;
    public HandleFg handle;
    public String menu;

    public Action(String url, HandleFg handle) {
        this.url = url;
        this.handle = handle;
    }

    public Action(String url, HandleFg handle, String menu) {
        this.url = url;
        this.handle = handle;
        this.menu = menu;
    }

    public boolean isMenuItem() {
        return this.menu != null;
    }
}
