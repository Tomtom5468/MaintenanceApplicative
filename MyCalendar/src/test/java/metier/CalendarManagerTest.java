package metier;

import event.Event;
import event.EventFabricator;
import event.Id;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    @Test
    public void testAjoutEtAffichage() {
        CalendarManager manager = new CalendarManager();
        manager.ajouterEvent("Rendez-vous", "Test", "Jean", LocalDateTime.now(), 15, null, null, 0,"");

        List<Event> events = manager.events.getEvents();
        assertEquals(1, events.size());
        assertEquals("Jean", events.get(0).getProprietaire().getProprietaire());
    }

    @Test
    public void testEventsDansPeriode() {
        CalendarManager manager = new CalendarManager();
        LocalDateTime date = LocalDateTime.of(2025, 3, 24, 9, 0);
        manager.ajouterEvent("Rendez-vous", "Dentiste", "Anna", date, 20, null, null, 0,"");

        List<Event> list = manager.eventsDansPeriode(date.minusDays(1), date.plusDays(1));
        assertEquals(1, list.size());
    }

    @Test
    public void testConflitFalse() {
        CalendarManager manager = new CalendarManager();
        LocalDateTime d1 = LocalDateTime.of(2025, 3, 24, 9, 0);
        LocalDateTime d2 = LocalDateTime.of(2025, 3, 24, 10, 0);

        manager.ajouterEvent("Rendez-vous", "RDV1", "A", d1, 30, null, null, 0,"");
        manager.ajouterEvent("Rendez-vous", "RDV2", "B", d2, 30, null, null, 0,"");

        List<Event> e = manager.events.getEvents();
        assertFalse(manager.conflit(e.get(0), e.get(1)));
    }

    @Test
    public void testConflitTrue() {
        CalendarManager manager = new CalendarManager();
        LocalDateTime d1 = LocalDateTime.of(2025, 3, 24, 9, 0);
        LocalDateTime d2 = LocalDateTime.of(2025, 3, 24, 9, 15);

        manager.ajouterEvent("Rendez-vous", "RDV1", "A", d1, 30, null, null, 0,"");
        manager.ajouterEvent("Rendez-vous", "RDV2", "B", d2, 30, null, null, 0,"");

        List<Event> e = manager.events.getEvents();
        assertEquals(1, e.size());
    }

    @Test
    public void testEvenementsDansPeriode() {
        CalendarManager calendar = new CalendarManager();

        calendar.ajouterEvent("Rendez-vous", "Dentiste", "Alice", LocalDateTime.of(2025, 3, 24, 9, 0), 30, null, null, 0,"");
        calendar.ajouterEvent("Periodique", "Conférence", "Alice", LocalDateTime.of(2025, 3, 25, 9, 0), 60, null, null, 0,"");
        calendar.ajouterEvent("Rendez-vous", "Dentiste", "Alice", LocalDateTime.of(2005, 3, 26, 9, 0), 30, null, null, 0,"");

        LocalDateTime debut = LocalDateTime.of(2025, 3, 20, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 3, 30, 0, 0);
        List<Event> evenements = calendar.eventsDansPeriode(debut, fin);

        assertEquals(2, evenements.size());
    }

    @Test
    public void testSupprimerEventParId() {
        CalendarManager calendar = new CalendarManager();

        // Créer un événement avec ID
        Event e = EventFabricator.fabricateEvent("Rendez-vous", "Test", "Alice",
                LocalDateTime.of(2025, 4, 1, 10, 0), 60, "", "", 0, "");
        Id id = new Id(UUID.randomUUID());
        e.setId(id);

        // Ajouter manuellement dans la liste
        calendar.events.ajouterEvent(e);
        assertEquals(1, calendar.events.getEvents().size());

        // Supprimer
        boolean resultat = calendar.supprimerEventParId(id);

        // Vérifications
        assertTrue(resultat, "L’événement aurait dû être supprimé.");
        assertEquals(0, calendar.events.getEvents().size(), "La liste doit être vide.");
    }

    @Test
    public void testSupprimerEventAvecMauvaisId() {
        CalendarManager calendar = new CalendarManager();

        // Créer un événement avec ID
        Event e = EventFabricator.fabricateEvent("Réunion", "Projet", "Bob",
                LocalDateTime.of(2025, 5, 2, 14, 0), 90, "", "", 0, "");
        e.setId(new Id(UUID.randomUUID()));

        calendar.events.ajouterEvent(e);
        assertEquals(1, calendar.events.getEvents().size());

        // Tentative de suppression avec un mauvais ID
        boolean resultat = calendar.supprimerEventParId(new Id(UUID.randomUUID()));

        assertFalse(resultat, "Aucun événement ne doit être supprimé.");
        assertEquals(1, calendar.events.getEvents().size(), "L'événement doit toujours être présent.");
    }
}
