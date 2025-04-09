package uebung1.test;

import main.uebung1.businesslogic.HexNumberTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestHexNumberTransformer {

    HexNumberTransformer test = null;

    @BeforeEach
    void init() {
        test = new HexNumberTransformer();
    }

    @Test
    void TestHexNumbers() {
        try {
            assertEquals("0", test.transformNumber(0));
            assertEquals("a", test.transformNumber(10));
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}


