package rdv;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RendezVousTest {

    @Test
    public void testDescription() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 10, 30);
        RendezVous rdv = new RendezVous("Dentiste", "Alice", date, 30);

        String expected = "RDV : Dentiste à " + date.toString();
        assertEquals(expected, rdv.description());
    }

    @Test
    public void testIsBeforeInRange() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 10, 30);
        RendezVous rdv = new RendezVous("Dentiste", "Alice", date, 30);

        assertTrue(rdv.isBefore(date.minusDays(1), date.plusDays(1)));
    }

    @Test
    public void testIsBeforeOutOfRange() {
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 10, 30);
        RendezVous rdv = new RendezVous("Dentiste", "Alice", date, 30);

        assertFalse(rdv.isBefore(date.plusDays(1), date.plusDays(2)));
    }
}
