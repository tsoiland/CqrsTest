package net.avacati.sandbox.cqrstest.presentation

import net.avacati.lib.mvc.AbstractAction
import net.avacati.lib.mvc.actionresults.ViewResult

import java.util.stream.Collectors;

public class Menu extends ViewResult {
    private List<AbstractAction> menuActions;

    public Menu(List<AbstractAction> menuActions) {
        this.menuActions = menuActions;
    }

    @Override
    public String render() {
        return """
            <ul>
                ${this.menuActions
                    .stream()
                    .map({a ->
                        """<li><a href="$a.url">$a.menu</a></li>"""})
                    .collect(Collectors.joining())}
            </ul>""";
    }
}
