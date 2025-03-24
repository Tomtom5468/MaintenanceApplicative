package periodique;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PeriodiqueTest {

    @Test
    public void testDescription() {
        Periodique p = new Periodique("Sport", "Claire", LocalDateTime.now(), 45, 3, UUID.randomUUID());
        assertTrue(p.description().contains("Sport"));
        assertTrue(p.description().contains("tous les 3 jours"));
    }

    @Test
    public void testIsBeforeTrue() {
        LocalDateTime debut = LocalDateTime.of(2025, 3, 1, 9, 0);
        Periodique p = new Periodique("Yoga", "Claire", debut, 60, 7,UUID.randomUUID());

        // Cherche une occurrence entre le 8 mars et le 20 mars
        assertTrue(p.isBefore(LocalDateTime.of(2025, 3, 8, 0, 0),
                LocalDateTime.of(2025, 3, 20, 0, 0)));
    }

    @Test
    public void testIsBeforeFalse() {
        LocalDateTime debut = LocalDateTime.of(2025, 3, 1, 9, 0);
        Periodique p = new Periodique("Yoga", "Claire", debut, 60, 7,UUID.randomUUID());

        // Fenêtre trop courte pour une occurrence
        assertFalse(p.isBefore(LocalDateTime.of(2025, 3, 2, 0, 0),
                LocalDateTime.of(2025, 3, 6, 0, 0)));
    }
}
