package tests.res;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.Portefeuille;
import res.actions.Action;
import res.actions.ActionSimple;
import res.exceptions.NoStackTraceRuntimeException;
import tests.mocks.PortefeuilleMock;

public class PortefeuilleTest {

    PortefeuilleMock portefeuilleMock = new PortefeuilleMock();

    @Test(expected = NoStackTraceRuntimeException.class)
    public void acheterAction_ActionNull_Ko() {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.acheterAction(null);

    }

    @Test
    public void acheterAction_Ok() {
        Portefeuille portefeuille = new Portefeuille();

        Assertions.assertDoesNotThrow(() -> portefeuille.acheterAction(new ActionSimple("Total")));
    }

    @Test(expected = NoStackTraceRuntimeException.class)
    public void vendreAction_ActionNull_Ko() {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.vendreAction(null);
    }

    @Test(expected = NoStackTraceRuntimeException.class)
    public void vendreAction_ActionNotContainedInPortefeuille_Ko() {
        // GIVEN
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleSample();
        Action actionEdf = new ActionSimple("EDF");

        // THEN
       portefeuille.vendreAction(actionEdf);
    }

    @Test
    public void vendreAction_Ok() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleSample();
        Action actionTotal = new ActionSimple("Total");

        Assertions.assertDoesNotThrow(() ->portefeuille.vendreAction(actionTotal));

    }

    @Test
    public void getValue_NoneCours_Ko() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleSample();

        Assertions.assertEquals(0, portefeuille.getValue(2020, 1));
    }

    @Test
    public void getValue_OnlyActionSimple_Ok() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleWithOnlyActionSimple();

        Assertions.assertEquals(1200, portefeuille.getValue(2023, 1));
    }

    @Test
    public void getValue_OnlyActionComposee_Ok() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleWithOnlyActionComposee();

        Assertions.assertEquals(1280, portefeuille.getValue(2023, 1));

    }

    @Test
    public void getValue_MixedActions_Ok() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleWithMixedActions();

        Assertions.assertEquals(1080, portefeuille.getValue(2023, 1));

    }

    @Test
    public void getValueAction_NomActionNull_Ko() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleSample();

        Assertions.assertEquals(0, portefeuille.getValueAction(null, 2020, 1));
    }

    @Test
    public void getValueAction_ActionNonPossedee_Ko() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleSample();

        Assertions.assertEquals(0, portefeuille.getValueAction("Action bidon", 2020, 1));

    }

    @Test
    public void getValueAction_ActionPossedee_Ok() {
        Portefeuille portefeuille = portefeuilleMock.getPortefeuilleWithMixedActions();

        Assertions.assertEquals(340, portefeuille.getValueAction("Lvmh", 2023, 1));

    }

}
