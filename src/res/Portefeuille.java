package res;

import res.actions.Action;
import res.exceptions.NoStackTraceRuntimeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Portefeuille {
    private Map<Action, Integer> actions = new HashMap<>();

    public void acheterAction(Action action) {
        if (Objects.isNull(action)) {
            throw new NoStackTraceRuntimeException("Vous devez spécifier une action pour cette transaction");
        }

        actions.computeIfAbsent(action, actionkey -> actions.put(actionkey, 0));
        actions.put(action, actions.get(action) + 1);
    }

    public void vendreAction(Action action) {
        if (Objects.isNull(action)) {
            throw new NoStackTraceRuntimeException("Vous devez spécifier une action pour cette transaction");
        }

        if (!actions.containsKey(action) || actions.get(action) == 0) {
            throw new NoStackTraceRuntimeException("La portefeuille n'a pas d'action " + action.getLibelle());
        }

        actions.put(action, actions.get(action) - 1);
    }

    public float getValue(int annee, int numeroJour) {
        float valeur = 0;

        for (Map.Entry<Action, Integer> entry : actions.entrySet()) {
            Action action = entry.getKey();
            valeur += action.getValue(annee, numeroJour) * entry.getValue();
        }

        return valeur;
    }
}
