package biblioteca.library.menuOptions;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ContinueTest {

    @Test
    public void shouldReturnTrue() {
        Continue aContinue = new Continue();
        assertTrue(aContinue.run());
    }

    @Test
    public void doesNotRequireLogin() {

        Continue aContinue = new Continue();
        assertFalse(aContinue.accessAvailable());
    }
}