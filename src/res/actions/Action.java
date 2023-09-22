package res.actions;

import java.util.Objects;

public abstract class Action {

    protected String libelle;

    protected Action(String inLibelle) {
        libelle = inLibelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public abstract float getValue(int inAnnee, int inNumeroJour);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;
        Action action = (Action) o;
        return Objects.equals(libelle, action.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }
}
