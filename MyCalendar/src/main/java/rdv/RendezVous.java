package rdv;

import lombok.Getter;
import lombok.Setter;
import event.Event;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class RendezVous extends Event {
    public RendezVous(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, UUID id) {
        super(title, proprietaire, dateDebut, dureeMinutes,id);
    }

    @Override
    public String description() {
        return "[ID: " + id.getId() + "] : RDV : " + title.getNom() + " à " + dateDebut.getDateDebut().toString();
    }

    @Override
    public boolean isBefore(LocalDateTime debut, LocalDateTime fin) {
        return !this.dateDebut.getDateDebut().isBefore(debut) && !this.dateDebut.getDateDebut().isAfter(fin);
    }
}
