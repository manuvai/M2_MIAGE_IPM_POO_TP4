package res.keys;

import res.exceptions.NoStackTraceRuntimeException;

public class Pourcentage {
    private float portion;

    public Pourcentage(float inPourcentage) {
        setPortion(inPourcentage);
    }

    public float getPortion() {
        return portion;
    }

    public void setPortion(float portion) {
        if (portion < 0 || portion > 1) {
            throw new NoStackTraceRuntimeException("Pourcentage must be between 0 and 1");
        }

        this.portion = portion;
    }
}
