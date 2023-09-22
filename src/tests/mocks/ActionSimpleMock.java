package tests.mocks;

import res.Cours;
import res.actions.ActionSimple;

public class ActionSimpleMock {
    public ActionSimple getActionSimpleSample() {
        ActionSimple actionSimple = new ActionSimple("Action Total");

        Cours cours = new Cours(2.5f, 2023, 12);
        actionSimple.enregistrerCours(cours);

        return actionSimple;
    }
}
