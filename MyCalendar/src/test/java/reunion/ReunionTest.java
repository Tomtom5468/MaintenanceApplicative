package reunion;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ReunionTest {

    @Test
    public void testDescription() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 14, 0);
        UUID id = UUID.randomUUID();
        Reunion reunion = new Reunion("Sprint", "Bob", date, 60, "Salle 101", "Dev Team", id);

        String expected = "[ID: "+ id +"] : Réunion : Sprint à Salle 101 avec Dev Team";
        assertEquals(expected, reunion.description());
    }

    @Test
    public void testIsBeforeInRange() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 14, 0);
        Reunion reunion = new Reunion("Sprint", "Bob", date, 60, "Salle 101", "Dev Team",UUID.randomUUID());

        assertTrue(reunion.isBefore(date.minusHours(1), date.plusHours(2)));
    }

    @Test
    public void testIsBeforeOutOfRange() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 14, 0);
        Reunion reunion = new Reunion("Sprint", "Bob", date, 60, "Salle 101", "Dev Team",UUID.randomUUID());

        assertFalse(reunion.isBefore(date.plusDays(1), date.plusDays(2)));
    }
}
