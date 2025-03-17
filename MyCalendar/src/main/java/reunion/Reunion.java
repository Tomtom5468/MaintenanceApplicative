package reunion;

import lombok.Getter;
import lombok.Setter;
import event.Event;

import java.time.LocalDateTime;

@Getter
@Setter
public class Reunion extends Event {
    private Lieu lieu;
    private Participants participants;

    public Reunion(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = new Lieu(lieu);
        this.participants = new Participants(participants);
    }

    @Override
    public String description(){
        return "Réunion : " + title.getNom() + " à " + lieu.getLieu() + " avec " + participants.getParticipants();
    }
}
