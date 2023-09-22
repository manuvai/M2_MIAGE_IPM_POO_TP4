package tests.res;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.actions.ActionComposee;
import res.actions.ActionSimple;
import tests.mocks.ActionComposeeMock;

public class ActionComposeeTest {

    private ActionComposeeMock actionComposeeMock = new ActionComposeeMock();
    @Test
    public void getValue_CoursInexistant_Ko() {
        ActionComposee composee = new ActionComposee("Action composee vide");

        Assertions.assertEquals(0, composee.getValue(2023, 1));
    }

    @Test
    public void getValue_Ok() {
        ActionComposee actionComposee = actionComposeeMock.getActionComposeeSample();

        Assertions.assertEquals(320, actionComposee.getValue(2023, 1));
    }
}
