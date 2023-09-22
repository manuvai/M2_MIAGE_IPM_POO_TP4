package res.keys;

import res.exceptions.NoStackTraceRuntimeException;

public class Quantite {
    private int quantiteActions = 0;

    public Quantite(int inQuantiteActions) {
        setQuantiteActions(inQuantiteActions);
    }

    public int getQuantiteActions() {
        return quantiteActions;
    }

    public void setQuantiteActions(int quantiteActions) {
        if (quantiteActions < 0) {
            throw new NoStackTraceRuntimeException("La quantité d'actions doit être positif");
        }

        this.quantiteActions = quantiteActions;
    }

    public void increment() {
        setQuantiteActions(getQuantiteActions() + 1);
    }

    public void decrement() {
        setQuantiteActions(getQuantiteActions() - 1);
    }
}
