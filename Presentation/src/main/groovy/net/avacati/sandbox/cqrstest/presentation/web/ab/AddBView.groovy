package net.avacati.sandbox.cqrstest.presentation.web.ab
import net.avacati.lib.mvc.AbstractAction
import net.avacati.sandbox.cqrstest.presentation.web.View

public class AddBView extends View {
    private AbstractAction addbpost;
    private Collection<String> aNames

    AddBView(AbstractAction addbpost, Collection<String> aNames) {
        this.aNames = aNames
        this.addbpost = addbpost
    }

    @Override
    public String render() {
        return """
            <form method="POST" action="$addbpost.url">
                <label>AName ${renderSelectList()}</label>
                <label>BName <input type="text" name="bname" /></label>
                <label>I <input type="text" name="i" /></label>
                <input type="submit" value="Submit" />
            </form>""";
    }

    public String renderSelectList() {
        return """
            <select name="aname">
                ${aNames.collect({name -> """<option value="$name">$name</option>"""})}
            </select>""";
    }
}
