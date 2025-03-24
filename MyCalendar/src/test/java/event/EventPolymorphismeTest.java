package event;

import org.junit.jupiter.api.Test;
import periodique.Periodique;
import rdv.RendezVous;
import reunion.Reunion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class EventPolymorphismeTest {

    @Test
    public void testDescriptionsPolymorphes() {
        LocalDateTime now = LocalDateTime.now();

        Event rdv = new RendezVous("Docteur", "Alice", now, 30, UUID.randomUUID());
        Event reunion = new Reunion("Projet", "Bob", now, 60, "Salle 1", "Équipe",UUID.randomUUID());
        Event periodique = new Periodique("Méditation", "Claire", now, 20, 2,UUID.randomUUID());

        List<Event> events = List.of(rdv, reunion, periodique);

        for (Event e : events) {
            assertNotNull(e.description());
            assertFalse(e.description().isEmpty());
        }
    }

    @Test
    public void testTriChronologique() {
        LocalDateTime now = LocalDateTime.of(2025, 3, 24, 9, 0);
        Event e1 = new RendezVous("Dentiste", "A", now.plusDays(3), 20, UUID.randomUUID());
        Event e2 = new Reunion("Réunion", "B", now.plusDays(1), 60, "Bureau", "Team",UUID.randomUUID());
        Event e3 = new Periodique("Gym", "C", now.plusDays(2), 45, 7,UUID.randomUUID());

        List<Event> list = new ArrayList<>(List.of(e1, e2, e3));

        list.sort((a, b) -> a.getDateDebut().getDateDebut().compareTo(b.getDateDebut().getDateDebut()));

        assertEquals(e2, list.get(0));
        assertEquals(e3, list.get(1));
        assertEquals(e1, list.get(2));
    }

    @Test
    public void testRechercheDansIntervalle() {
        LocalDateTime ref = LocalDateTime.of(2025, 3, 1, 8, 0);

        Event e1 = new RendezVous("RDV 1", "X", ref.plusDays(1), 30,UUID.randomUUID());
        Event e2 = new Reunion("Réunion 1", "Y", ref.plusDays(5), 60, "Salle", "Dev",UUID.randomUUID());
        Event e3 = new Periodique("Yoga", "Z", ref, 30, 2,UUID.randomUUID());

        List<Event> liste = List.of(e1, e2, e3);
        LocalDateTime debut = ref.plusDays(4);
        LocalDateTime fin = ref.plusDays(6);

        long count = liste.stream().filter(e -> e.isBefore(debut, fin)).count();
        assertEquals(2, count); // Réunion + au moins une occurrence de Yoga
    }
}
