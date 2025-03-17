package src.metier;

import src.event.Event;
import src.event.EventFabricator;
import src.periodique.Periodique;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void ajouterEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                             String lieu, String participants, int frequenceJours) {
        Event e = EventFabricator.fabricateEvent(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
        events.ajouterEvent(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events.getEvents()) {
            if (e instanceof Periodique) {
                Periodique p = (Periodique) e;
                LocalDateTime temp = e.dateDebut.getDateDebut();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(p.getFrequenceJours().getFrequenceJours());
                }
            } else if (!e.dateDebut.getDateDebut().isBefore(debut) && !e.dateDebut.getDateDebut().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.getDateDebut().plusMinutes(e1.dureeMinutes.getDureeMinutes());
        LocalDateTime fin2 = e2.dateDebut.getDateDebut().plusMinutes(e2.dureeMinutes.getDureeMinutes());

        if (e1 instanceof Periodique || e2 instanceof Periodique) {
            return false; // Simplification abusive
        }

        if (e1.dateDebut.getDateDebut().isBefore(fin2) && fin1.isAfter(e2.dateDebut.getDateDebut())) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }
}