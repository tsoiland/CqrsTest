package net.avacati.sandbox.cqrstest.presentation;

import net.avacati.lib.mvc.Action;
import net.avacati.lib.mvc.actionresults.ActionResult;
import net.avacati.lib.mvc.actionresults.Redirect;
import net.avacati.lib.mvc.actionresults.ViewResult;
import net.avacati.sandbox.cqrstest.abcomponent.*;

import java.util.List;
import java.util.Map;

public class ABController {
    private IABFacade abFacade;

    public Action index = new Action("/abcontroller/index", this::index, "Index");
    public Action adda = new Action("/abcontroller/adda", this::addA, "Add A");
    public Action addapost = new Action("/abcontroller/addapost", this::addAPost);
    public Action addb = new Action("/abcontroller/addb", this::addB, "Add B");
    public Action addbpost = new Action("/abcontroller/addbpost", this::addBPost);

    public ABController(IABFacade abFacade) {
        this.abFacade = abFacade;
    }

    public ViewResult index(Map<String,String> postData){
        List<ABResult> result = this.abFacade.query();
        return new Index(result);
    }

    public ViewResult addA(Map<String,String> postData) {
        return new AddAView();
    }

    public ActionResult addAPost(Map<String,String> postData) throws EmptyNameException {
        this.abFacade.addA(postData.get("aname"));
        return new Redirect(this.addb);
    }

    public ViewResult addB(Map<String,String> postData) {
        return new AddBView();
    }

    public ActionResult addBPost(Map<String,String> postData) throws EmptyNameException, NoPrimeNumbersException, ProhibitedNumberException {
        String aName = postData.get("aname");
        String bName = postData.get("bname");
        int i = Integer.parseInt(postData.get("i"));
        this.abFacade.addB(aName, bName, i);
        return new Redirect(this.index);
    }
}
