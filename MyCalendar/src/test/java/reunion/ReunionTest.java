package reunion;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReunionTest {

    @Test
    public void testDescription() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 14, 0);
        Reunion reunion = new Reunion("Sprint", "Bob", date, 60, "Salle 101", "Dev Team");

        String expected = "Réunion : Sprint à Salle 101 avec Dev Team";
        assertEquals(expected, reunion.description());
    }

    @Test
    public void testIsBeforeInRange() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 14, 0);
        Reunion reunion = new Reunion("Sprint", "Bob", date, 60, "Salle 101", "Dev Team");

        assertTrue(reunion.isBefore(date.minusHours(1), date.plusHours(2)));
    }

    @Test
    public void testIsBeforeOutOfRange() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 14, 0);
        Reunion reunion = new Reunion("Sprint", "Bob", date, 60, "Salle 101", "Dev Team");

        assertFalse(reunion.isBefore(date.plusDays(1), date.plusDays(2)));
    }
}
