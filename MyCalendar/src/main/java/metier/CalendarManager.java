package metier;

import event.Event;
import event.EventFabricator;
import event.Id;
import periodique.Periodique;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public boolean ajouterEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                             String lieu, String participants, int frequenceJours, String nom) {
        Event e = EventFabricator.fabricateEvent(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours,nom);

        for (Event existant : events.getEvents()) {
            if (conflit(e, existant)) {
                return false;
            }
        }

        events.ajouterEvent(e);
        return true;
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return events.getEvents().stream()
                .filter(e -> e.isBefore(debut, fin))
                .collect(Collectors.toList());
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.getDateDebut().plusMinutes(e1.dureeMinutes.getDureeMinutes());
        LocalDateTime fin2 = e2.dateDebut.getDateDebut().plusMinutes(e2.dureeMinutes.getDureeMinutes());

        return !(e1 instanceof Periodique || e2 instanceof Periodique) &&
                e1.dateDebut.getDateDebut().isBefore(fin2) &&
                fin1.isAfter(e2.dateDebut.getDateDebut());
    }

    public void afficherEvenements() {
        List<Event> liste = events.getEvents();
        if (liste == null || liste.isEmpty()) {
            System.out.println("Aucun événement à afficher.");
            return;
        }

        for (Event e : liste) {
            System.out.println(e.description());
        }
    }

    public boolean supprimerEventParId(Id eventId) {
        return events.getEvents().removeIf(e -> e.getId().equals(eventId));
    }

}