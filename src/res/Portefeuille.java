package res;

import res.actions.Action;
import res.exceptions.NoStackTraceRuntimeException;
import res.keys.Quantite;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Portefeuille {
    private Map<Action, Quantite> actions = new HashMap<>();

    public void acheterAction(Action action) {
        if (Objects.isNull(action)) {
            throw new NoStackTraceRuntimeException("Vous devez spécifier une action pour cette transaction");
        }

        actions.computeIfAbsent(action, actionkey -> actions.put(actionkey, new Quantite(0)));

        actions.get(action).increment();
    }

    public void vendreAction(Action action) {
        if (Objects.isNull(action)) {
            throw new NoStackTraceRuntimeException("Vous devez spécifier une action pour cette transaction");
        }

        if (!actions.containsKey(action) || actions.get(action).getQuantiteActions() == 0) {
            throw new NoStackTraceRuntimeException("La portefeuille n'a pas d'action " + action.getLibelle());
        }

        actions.get(action).decrement();
    }

    public float getValueAction(String nomAction, int annee, int numeroJour) {
        Action action = Objects.isNull(nomAction)
                ? null
                : actions.keySet()
                        .stream()
                        .filter(actionElement -> actionElement.getLibelle().equals(nomAction))
                        .findFirst()
                        .orElse(null);

        return Objects.isNull(action)
                ? 0
                : action.getValue(annee, numeroJour);
    }

    public float getValue(int annee, int numeroJour) {
        float valeur = 0;

        for (Map.Entry<Action, Quantite> entry : actions.entrySet()) {
            Action action = entry.getKey();
            valeur += action.getValue(annee, numeroJour) * entry.getValue().getQuantiteActions();
        }

        return valeur;
    }
}
