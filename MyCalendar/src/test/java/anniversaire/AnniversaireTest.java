package anniversaire;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AnniversaireTest {

    @Test
    public void testDescription() {
        Anniversaire a = new Anniversaire("Anniversaire de Claire","Lui",LocalDateTime.now(), 45,"Claire", UUID.randomUUID());
        assertTrue(a.description().contains("Anniversaire de Claire"));
    }

    @Test
    public void testIsBeforeTrue() {
        LocalDateTime dateDebut = LocalDateTime.now();
        Anniversaire a = new Anniversaire("Anniversaire de Claire","Lui",dateDebut, 45,"Claire", UUID.randomUUID());
        assertTrue(a.isBefore(dateDebut, dateDebut.plusDays(1)));
    }

    @Test
    public void testIsBeforeFalse() {
        LocalDateTime date = LocalDateTime.now();
        Anniversaire a = new Anniversaire("Anniversaire de Claire","Lui",LocalDateTime.now(), 45,"Claire", UUID.randomUUID());
        assertFalse(a.isBefore(date.plusDays(1), date.plusDays(2)));
    }
}