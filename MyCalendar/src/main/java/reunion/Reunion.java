package reunion;

import event.Id;
import lombok.Getter;
import lombok.Setter;
import event.Event;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Reunion extends Event {
    private Lieu lieu;
    private Participants participants;

    public Reunion(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, UUID id) {
        super(title, proprietaire, dateDebut, dureeMinutes,id);
        this.lieu = new Lieu(lieu);
        this.participants = new Participants(participants);
    }

    @Override
    public String description(){
        return "[ID: " + id.getId() + "] : Réunion : " + title.getNom() + " à " + lieu.getLieu() + " avec " + participants.getParticipants();
    }

    @Override
    public boolean isBefore(LocalDateTime debut, LocalDateTime fin) {
        return !this.dateDebut.getDateDebut().isBefore(debut) && !this.dateDebut.getDateDebut().isAfter(fin);
    }
}
