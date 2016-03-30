package net.avacati.sandbox.cqrstest.presentation.web.ab;

import net.avacati.lib.mvc.AbstractAction;
import net.avacati.lib.mvc.Action;
import net.avacati.lib.mvc.ParameterAction;
import net.avacati.lib.mvc.actionresults.ActionResult;
import net.avacati.lib.mvc.actionresults.Redirect;
import net.avacati.lib.mvc.actionresults.ViewResult;
import net.avacati.sandbox.cqrstest.abcomponent.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ABController {
    private IABFacade abFacade;

    public ABController(IABFacade abFacade) {
        this.abFacade = abFacade;
    }

    /**
     * Index of ABresults.
     */
    public static AbstractAction index = new Action<>("/abcontroller/index", ABController::index, "Index", ABController.class);
    public ViewResult index(){
        List<ABResult> result = this.abFacade.query();
        return new Index(result);
    }

    /**
     * Add A. Form and Post
     */
    public static AbstractAction adda = new Action<>("/abcontroller/adda", ABController::addA, "Add A", ABController.class);
    public ViewResult addA() {
        return new AddAView(addapost);
    }

    public static AbstractAction addapost = new ParameterAction<ABController>("/abcontroller/addapost", ABController::addAPost, ABController.class);
    public ActionResult addAPost(Map<String,String> params) {
        this.abFacade.addA(params.get("aname"));
        return new Redirect(addb);
    }

    /**
     * Add B. Form and Post.
     */
    public static AbstractAction addb = new Action<>("/abcontroller/addb", ABController::addB, "Add B", ABController.class);
    public ViewResult addB() {
        Collection<String> aNames = this.abFacade.getAllA();
        return new AddBView(addbpost, aNames);
    }

    public static AbstractAction addbpost = new ParameterAction<ABController>("/abcontroller/addbpost", ABController::addBPost, ABController.class);
    public ActionResult addBPost(Map<String,String> params) {
        String aName = params.get("aname");
        String bName = params.get("bname");
        int i = Integer.parseInt(params.get("i"));
        this.abFacade.addB(aName, bName, i);
        return new Redirect(index);
    }
}
