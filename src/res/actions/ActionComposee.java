package res.actions;

import java.util.HashMap;
import java.util.Map;

public class ActionComposee extends Action {
    private Map<ActionSimple, Pourcentage> composition = new HashMap<>();

    public ActionComposee(String inLibelle) {
        super(inLibelle);
    }

    public void enregistrerComposition(ActionSimple actionSimple, Pourcentage pourcentage) {
        composition.put(actionSimple, pourcentage);
    }

    @Override
    public float getValue(int inAnnee, int inNumeroJour) {
        float valeur = 0;

        for (Map.Entry<ActionSimple, Pourcentage> entry : composition.entrySet()) {
            ActionSimple actionSimple = entry.getKey();
            Pourcentage pourcentage = entry.getValue();

            valeur += pourcentage.getPortion() * actionSimple.getValue(inAnnee, inNumeroJour);
        }

        return valeur;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
