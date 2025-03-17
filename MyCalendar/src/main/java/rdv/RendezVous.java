package rdv;

import lombok.Getter;
import lombok.Setter;
import event.Event;

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

    @Override
    public boolean isBefore(LocalDateTime debut, LocalDateTime fin) {
        return !this.dateDebut.getDateDebut().isBefore(debut) && !this.dateDebut.getDateDebut().isAfter(fin);
    }
}
