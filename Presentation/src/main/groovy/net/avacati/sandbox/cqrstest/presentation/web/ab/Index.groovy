package net.avacati.sandbox.cqrstest.presentation.web.ab

import net.avacati.sandbox.cqrstest.abcomponent.ABResult
import net.avacati.sandbox.cqrstest.presentation.web.View

import java.util.stream.Collectors

public class Index extends View {
    private List<ABResult> result;

    public Index(List<ABResult> result) {
        this.result = result;
    }

    @Override
    public String render() {
        return """
            <H1>AB Overview</h1>
            <table>
                <tr>
                    <td>AName</td>
                    <td>BName</td>
                    <td>i</td>
                </tr>
                ${this.renderRows(this.result)}
            </table>""";
    }

    private String renderRows(List<ABResult> result) {
        return result
                .stream()
                .map({r -> """
                    <tr>
                        <td>$r.a</td>
                        <td>$r.b</td>
                        <td>$r.i</td>
                    </tr>
                 """})
                .collect(Collectors.joining());
    }
}
