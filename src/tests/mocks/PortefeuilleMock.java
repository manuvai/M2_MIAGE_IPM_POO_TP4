package tests.mocks;

import res.Cours;
import res.Portefeuille;
import res.actions.Action;
import res.actions.ActionComposee;
import res.actions.ActionSimple;
import res.keys.Pourcentage;

public class PortefeuilleMock {


    public Portefeuille getPortefeuilleSample() {
        Portefeuille portefeuille = new Portefeuille();
        portefeuille.acheterAction(getActionSample());

        return portefeuille;
    }

    public Action getActionSample() {

        return new ActionSimple("Total");
    }

    public Portefeuille getPortefeuilleWithOnlyActionSimple() {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.acheterAction(getActionTotal());
        portefeuille.acheterAction(getActionTotal());
        portefeuille.acheterAction(getActionTotal());
        portefeuille.acheterAction(getActionEdf());
        portefeuille.acheterAction(getActionCatsEyes());

        return portefeuille;
    }

    private ActionSimple getActionCatsEyes() {
        ActionSimple actionSimple = new ActionSimple("CatsEyes");
        actionSimple.enregistrerCours(new Cours(100, 2023, 1));
        return actionSimple;

    }

    private ActionSimple getActionEdf() {
        ActionSimple actionSimple = new ActionSimple("Edf");
        actionSimple.enregistrerCours(new Cours(200, 2023, 1));
        return actionSimple;
    }

    private ActionSimple getActionTotal() {
        ActionSimple actionSimple = new ActionSimple("Total");
        actionSimple.enregistrerCours(new Cours(300, 2023, 1));
        return actionSimple;
    }

    private ActionSimple getActionLv() {
        ActionSimple actionSimple = new ActionSimple("Louis Vuitton");
        actionSimple.enregistrerCours(new Cours(300, 2023, 1));
        return actionSimple;
    }

    private ActionSimple getActionHugo() {
        ActionSimple actionSimple = new ActionSimple("Hugo Boss");
        actionSimple.enregistrerCours(new Cours(400, 2023, 1));
        return actionSimple;
    }

    private ActionSimple getActionGucci() {
        ActionSimple actionSimple = new ActionSimple("Gucci");
        actionSimple.enregistrerCours(new Cours(300, 2023, 1));
        return actionSimple;
    }

    public Portefeuille getPortefeuilleWithOnlyActionComposee() {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionEnergies());

        return portefeuille;
    }

    private ActionComposee getActionEnergies() {
        ActionComposee actionComposee = new ActionComposee("Energies");

        actionComposee.enregistrerComposition(getActionEdf(), new Pourcentage(0.4f));
        actionComposee.enregistrerComposition(getActionTotal(), new Pourcentage(0.6f));

        return actionComposee;
    }

    private ActionComposee getActionLvmh() {
        ActionComposee actionComposee = new ActionComposee("Lvmh");

        actionComposee.enregistrerComposition(getActionLv(), new Pourcentage(0.4f));
        actionComposee.enregistrerComposition(getActionHugo(), new Pourcentage(0.4f));
        actionComposee.enregistrerComposition(getActionGucci(), new Pourcentage(0.2f));


        return actionComposee;
    }

    public Portefeuille getPortefeuilleWithMixedActions() {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionEdf());
        portefeuille.acheterAction(getActionCatsEyes());
        portefeuille.acheterAction(getActionCatsEyes());

        return portefeuille;
    }
}
