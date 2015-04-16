package net.avacati.sandbox.cqrstest.presentation;

public class AddBView extends View {
    @Override
    public String render() {
        return """
            <form method="POST" action="/abcontroller/addbpost">
                <label>AName <input type="text" name="aname" /></label>
                <label>BName <input type="text" name="bname" /></label>
                <label>I <input type="text" name="i" /></label>
                <input type="submit" value="Submit" />
            </form>""";
    }
}
