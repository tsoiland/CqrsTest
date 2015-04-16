package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.Action;
import net.avacati.lib.mvc.actionresults.ViewResult;

import java.util.List;
import java.util.stream.Collectors;

public class Menu extends ViewResult {
    private List<Action> menuActions;

    public Menu(List<Action> menuActions) {
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
