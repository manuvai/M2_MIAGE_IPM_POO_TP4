package tests.mocks;

import res.Cours;
import res.actions.ActionComposee;
import res.actions.ActionSimple;
import res.actions.Pourcentage;

public class ActionComposeeMock {
    public ActionComposee getActionComposeeSample() {
        ActionComposee actionComposee = new ActionComposee("Action Composee Energies");

        actionComposee.enregistrerComposition(getActionEdf(), new Pourcentage(0.6f));
        actionComposee.enregistrerComposition(getActionTotal(), new Pourcentage(0.4f));

        return actionComposee;
    }

    private ActionSimple getActionEdf() {
        ActionSimple actionSimple = new ActionSimple("Action EDF");

        Cours cours = new Cours(200, 2023, 1);

        actionSimple.enregistrerCours(cours);

        return actionSimple;
    }

    private ActionSimple getActionTotal() {
        ActionSimple actionSimple = new ActionSimple("Action Total");

        Cours cours = new Cours(500, 2023, 1);

        actionSimple.enregistrerCours(cours);

        return actionSimple;
    }
}
