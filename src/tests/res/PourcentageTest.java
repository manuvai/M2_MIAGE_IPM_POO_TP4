package tests.res;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.keys.Pourcentage;
import res.exceptions.NoStackTraceRuntimeException;

public class PourcentageTest {

    @Test(expected = NoStackTraceRuntimeException.class)
    public void setPourcentage_pourcentageNegative_Ko() {
        new Pourcentage(-1);
    }

    @Test(expected = NoStackTraceRuntimeException.class)
    public void setPourcentage_pourcentageOverOne_Ko() {
        new Pourcentage(1.1f);
    }

    @Test
    public void setPourcentage_Ok() {
        Assertions.assertDoesNotThrow(() -> new Pourcentage(0.5f));
    }
}
