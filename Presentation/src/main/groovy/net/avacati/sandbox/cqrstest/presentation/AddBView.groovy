package net.avacati.sandbox.cqrstest.presentation
import net.avacati.lib.mvc.AbstractAction

public class AddBView extends View {
    private AbstractAction addbpost;

    AddBView(AbstractAction addbpost) {
        this.addbpost = addbpost
    }

    @Override
    public String render() {
        return """
            <form method="POST" action="$addbpost.url">
                <label>AName <input type="text" name="aname" /></label>
                <label>BName <input type="text" name="bname" /></label>
                <label>I <input type="text" name="i" /></label>
                <input type="submit" value="Submit" />
            </form>""";
    }
}
