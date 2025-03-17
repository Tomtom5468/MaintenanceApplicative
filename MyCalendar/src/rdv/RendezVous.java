package src.rdv;

import lombok.Getter;
import lombok.Setter;
import src.event.Event;

import java.time.LocalDateTime;

@Getter
@Setter
public class RendezVous extends Event {
    public RendezVous(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String description() {
        return "RDV : " + title.getNom() + " à " + dateDebut.getDateDebut().toString();
    }
}
