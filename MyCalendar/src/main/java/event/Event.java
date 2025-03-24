package event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public abstract class Event {
    public Id id;
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeMinutes dureeMinutes;

    public Event(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, UUID id) {
        this.title = new Title(title);
        this.proprietaire = new Proprietaire(proprietaire);
        this.dateDebut = new DateDebut(dateDebut);
        this.dureeMinutes = new DureeMinutes(dureeMinutes);
        this.id = new Id(id);
    }

    public abstract String description();

    public abstract boolean isBefore(LocalDateTime debut, LocalDateTime fin);
}
