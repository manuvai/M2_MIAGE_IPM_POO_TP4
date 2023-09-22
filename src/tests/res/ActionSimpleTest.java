package tests.res;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.Cours;
import res.actions.ActionSimple;
import res.exceptions.InvalidEntryException;
import res.exceptions.StockPriceAlreadyRegisteredException;
import tests.mocks.ActionSimpleMock;

public class ActionSimpleTest {

    private ActionSimpleMock actionSimpleMock = new ActionSimpleMock();

    @Test(expected = InvalidEntryException.class)
    public void enregistrerCours_CoursNull_Ko() {

        ActionSimple actionSimple = new ActionSimple("Action EDF");
        actionSimple.enregistrerCours(null);
    }

    @Test(expected = StockPriceAlreadyRegisteredException.class)
    public void enregistrerCours_CoursAlreadyExistant_Ko() {

        ActionSimple actionSimple = actionSimpleMock.getActionSimpleSample();
        actionSimple.enregistrerCours(new Cours(1.5f, 2023, 12));

    }

    @Test
    public void enregistrerCours_Ok() {
        ActionSimple actionSimple = actionSimpleMock.getActionSimpleSample();
        Assertions.assertDoesNotThrow(() ->
                actionSimple.enregistrerCours(new Cours(1.5f, 2023, 15)));
    }

    @Test
    public void getValue_CoursInexistant_Ko() {
        ActionSimple actionSimple = new ActionSimple("Action Vide de cours");

        Assertions.assertEquals(0, actionSimple.getValue(2023, 23));
    }

    @Test
    public void getValue_Ok() {
        ActionSimple actionSimple = actionSimpleMock.getActionSimpleSample();

        Assertions.assertEquals(2.5f, actionSimple.getValue(2023, 12));

    }
}
