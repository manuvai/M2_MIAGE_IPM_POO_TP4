package res;

import res.exceptions.InvalidEntryException;

public class Cours {
    private float valeur;
    private int annee;
    private int numeroJour;

    public Cours(float inValeur, int inAnnee, int inNumeroJour) {
        setValeur(inValeur);
        setAnnee(inAnnee);
        setNumeroJour(inNumeroJour);
    }

    public float getValeur() {
        return valeur;
    }

    public int getAnnee() {
        return annee;
    }

    public int getNumeroJour() {
        return numeroJour;
    }

    private void setNumeroJour(int inNumeroJour) {
        if (inNumeroJour < 1 || inNumeroJour > 365) {
            throw new InvalidEntryException();
        }
        numeroJour = inNumeroJour;
    }

    private void setAnnee(int inAnnee) {
        annee = inAnnee;
    }

    private void setValeur(float inValeur) {
        if (inValeur < 0) {
            throw new InvalidEntryException();
        }
        valeur = inValeur;
    }
}
