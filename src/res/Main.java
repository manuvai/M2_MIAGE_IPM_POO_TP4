package res;

import res.actions.Action;
import res.actions.ActionComposee;
import res.actions.ActionSimple;
import res.keys.Pourcentage;

public class Main {
    public static void main(String[] args) {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionLvmh());
        portefeuille.acheterAction(getActionCatsEyes());
        portefeuille.acheterAction(getActionEnergies());
        portefeuille.acheterAction(getActionEnergies());
        portefeuille.acheterAction(getActionEnergies());
        portefeuille.acheterAction(getActionEnergies());

        System.out.println("Alors, j'ai " + portefeuille.getValue(2023, 1) + "€");

        System.out.println("J'ai besoin de liquidité ! je vend une action Lvmh");
        portefeuille.vendreAction(getActionLvmh());

        System.out.println("Il me reste encore " + portefeuille.getValue(2023, 1) + "€");

        System.out.println("Wow, cela fait beaucoup d'un coup, mais combien valent mes actions Lvmh ?");
        System.out.println("Une action Lvmh vaut " + portefeuille.getValueAction("Lvmh", 2023, 1) + " €");
    }

    private static ActionSimple getActionCatsEyes() {
        ActionSimple actionSimple = new ActionSimple("CatsEyes");
        actionSimple.enregistrerCours(new Cours(100, 2023, 1));
        return actionSimple;
    }

    private static ActionSimple getActionEdf() {
        ActionSimple actionSimple = new ActionSimple("Edf");
        actionSimple.enregistrerCours(new Cours(200, 2023, 1));
        return actionSimple;
    }

    private static ActionSimple getActionTotal() {
        ActionSimple actionSimple = new ActionSimple("Total");
        actionSimple.enregistrerCours(new Cours(300, 2023, 1));
        return actionSimple;
    }

    private static ActionSimple getActionLv() {
        ActionSimple actionSimple = new ActionSimple("Louis Vuitton");
        actionSimple.enregistrerCours(new Cours(300, 2023, 1));
        return actionSimple;
    }

    private static ActionSimple getActionHugo() {
        ActionSimple actionSimple = new ActionSimple("Hugo Boss");
        actionSimple.enregistrerCours(new Cours(400, 2023, 1));
        return actionSimple;
    }

    private static ActionSimple getActionGucci() {
        ActionSimple actionSimple = new ActionSimple("Gucci");
        actionSimple.enregistrerCours(new Cours(300, 2023, 1));
        return actionSimple;
    }

    private static ActionComposee getActionEnergies() {
        ActionComposee actionComposee = new ActionComposee("Energies");

        actionComposee.enregistrerComposition(getActionEdf(), new Pourcentage(0.4f));
        actionComposee.enregistrerComposition(getActionTotal(), new Pourcentage(0.6f));

        return actionComposee;
    }

    private static ActionComposee getActionLvmh() {
        ActionComposee actionComposee = new ActionComposee("Lvmh");

        actionComposee.enregistrerComposition(getActionLv(), new Pourcentage(0.4f));
        actionComposee.enregistrerComposition(getActionHugo(), new Pourcentage(0.4f));
        actionComposee.enregistrerComposition(getActionGucci(), new Pourcentage(0.2f));


        return actionComposee;
    }
}
