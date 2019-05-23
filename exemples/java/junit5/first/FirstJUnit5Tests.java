import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class FirstJUnit5Tests {

    @Test
    @DisplayName("Test myFirstTest() réussi")
    void myFirstTest() {
        assertEquals(5, 1 + 1);
    }

}

