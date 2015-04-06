package net.avacati.sandbox.cqrstest.presentation;

public class AddAView extends View {
    @Override
    public String render() {
        return
                "<form method='POST' action='/abcontroller/addapost'>" +
                    "<label>AName <input type='text' name='aname' /></label>" +
                    "<input type='submit' value='Submit' />" +
                "</form>";
    }
}
