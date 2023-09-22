package res.actions;

import res.Cours;
import res.exceptions.InvalidEntryException;
import res.exceptions.StockPriceAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActionSimple extends Action {
    private List<Cours> coursList = new ArrayList<>();

    public ActionSimple(String inLibelle) {
        super(inLibelle);
    }

    public void enregistrerCours(Cours cours) {
        if (Objects.isNull(cours)) {
            throw new InvalidEntryException();
        }

        if (coursList.stream()
                .anyMatch(coursFilter -> coursFilter.getAnnee() == cours.getAnnee()
                        && coursFilter.getNumeroJour() == cours.getNumeroJour())
        ) {
            throw new StockPriceAlreadyRegisteredException();
        }

        coursList.add(cours);
    }

    @Override
    public float getValue(int inAnnee, int inNumeroJour) {
        Cours cours = coursList.stream()
                .filter(coursFilter -> coursFilter.getAnnee() == inAnnee
                        && coursFilter.getNumeroJour() == inNumeroJour)
                .findFirst()
                .orElse(null);

        return Objects.isNull(cours)
                ? 0
                : cours.getValeur();
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
