package net.avacati.sandbox.cqrstest.presentation
import net.avacati.lib.mvc.AbstractAction

public class AddAView extends View {
    private AbstractAction addapost;

    AddAView(AbstractAction addapost) {
        this.addapost = addapost
    }

    @Override
    public String render() {
        return """
            <form method="POST" action="$addapost.url">
                <label>AName <input type="text" name="aname" /></label>
                <input type="submit" value="Submit" />
            </form>""";
    }
}
