package src.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public abstract class Event {
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeMinutes dureeMinutes;

    public Event(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        this.title = new Title(title);
        this.proprietaire = new Proprietaire(proprietaire);
        this.dateDebut = new DateDebut(dateDebut);
        this.dureeMinutes = new DureeMinutes(dureeMinutes);
    }

    public abstract String description();
}
