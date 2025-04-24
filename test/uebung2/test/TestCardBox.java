package uebung2.test;

import main.uebung2.box.CardBox;
import main.uebung2.box.CardBoxException;
import main.uebung2.persons.DeveloperCard;
import main.uebung2.persons.EnduserCard;
import main.uebung2.persons.PersonCard;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCardBox {
    CardBox test;

    @BeforeEach
    void init() {
        test = new CardBox();
    }

    @Test
    void test() {
        PersonCard p1 = new DeveloperCard("Hans", "Meier", true);
        PersonCard p2 = new EnduserCard("Peter", "Lustig", false);

        try {
            test.addPersonCard(p1);
            test.addPersonCard(p2);
            assertEquals("Person mit der ID 1 wurde gelöscht!", test.deletePerson(1));
            assertThrows(CardBoxException.class, () -> test.addPersonCard(p2));
            assertEquals(1, test.size());
            assertTrue(test.checkIfExists(p2));

        } catch (CardBoxException ignored) {}

    }
}
