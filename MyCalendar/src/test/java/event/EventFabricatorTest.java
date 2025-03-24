package event;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class EventFabricatorTest {

    @Test
    public void testFabricateRendezVous() {
        LocalDateTime now = LocalDateTime.now();
        Event event = EventFabricator.fabricateEvent(
                "Rendez-vous", "Dentiste", "Alice", now, 30, null, null, 0,"");

        assertNotNull(event);
        assertEquals("Dentiste", event.getTitle().getNom());
        assertEquals("Alice", event.getProprietaire().getProprietaire());
        assertEquals(now, event.getDateDebut().getDateDebut());
        assertEquals(30, event.getDureeMinutes().getDureeMinutes());
    }

    @Test
    public void testFabricatePeriodique() {
        LocalDateTime now = LocalDateTime.now();
        Event event = EventFabricator.fabricateEvent(
                "Periodique", "Yoga", "Bob", now, 60, null, null, 7,"");

        assertNotNull(event);
        assertEquals("Yoga", event.getTitle().getNom());
        assertEquals("Bob", event.getProprietaire().getProprietaire());
        assertEquals(60, event.getDureeMinutes().getDureeMinutes());
    }

    @Test
    public void testFabricateReunion() {
        LocalDateTime now = LocalDateTime.now();
        Event event = EventFabricator.fabricateEvent(
                "Réunion", "Sprint Planning", "Carla", now, 90, "Salle A", "Dev Team", 0,"");

        assertNotNull(event);
        assertEquals("Sprint Planning", event.getTitle().getNom());
        assertEquals("Carla", event.getProprietaire().getProprietaire());
    }

    @Test
    public void testFabricateInvalidType() {
        Event event = EventFabricator.fabricateEvent(
                "Inconnu", "Titre", "Nom", LocalDateTime.now(), 10, null, null, 0,"");
        assertNull(event);
    }

    @Test
    public void testTitleGetterSetter() {
        Title title = new Title("Test");
        assertEquals("Test", title.getNom());

        title.setNom("Nouveau");
        assertEquals("Nouveau", title.getNom());
    }

    @Test
    public void testProprietaireGetterSetter() {
        Proprietaire prop = new Proprietaire("Jean");
        assertEquals("Jean", prop.getProprietaire());

        prop.setProprietaire("Paul");
        assertEquals("Paul", prop.getProprietaire());
    }

    @Test
    public void testDateDebutGetterSetter() {
        LocalDateTime date = LocalDateTime.of(2025, 1, 1, 12, 0);
        DateDebut debut = new DateDebut(date);
        assertEquals(date, debut.getDateDebut());

        LocalDateTime newDate = date.plusDays(1);
        debut.setDateDebut(newDate);
        assertEquals(newDate, debut.getDateDebut());
    }

    @Test
    public void testDureeMinutesGetterSetter() {
        DureeMinutes duree = new DureeMinutes(45);
        assertEquals(45, duree.getDureeMinutes());

        duree.setDureeMinutes(60);
        assertEquals(60, duree.getDureeMinutes());
    }
}
