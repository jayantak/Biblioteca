package biblioteca.library.menuOptions;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ContinueTest {

    @Test
    public void shouldReturnTrue() {
        Continue aContinue = new Continue();
        assertTrue(aContinue.run());
    }
}