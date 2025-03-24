package periodique;

import lombok.Getter;
import lombok.Setter;
import event.Event;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter

public class Periodique extends Event {
    private FrequenceJours frequenceJours;
    public Periodique(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours, UUID id) {
        super(title, proprietaire, dateDebut, dureeMinutes,id);
        this.frequenceJours = new FrequenceJours(frequenceJours);
    }

    @Override
    public String description(){
        return "[ID: " + id.getId() + "] : Événement périodique : " + title.getNom() + " tous les " + frequenceJours.getFrequenceJours() + " jours";
    }

    @Override
    public boolean isBefore (LocalDateTime debut, LocalDateTime fin) {
        LocalDateTime temp = this.dateDebut.getDateDebut();
        while (temp.isBefore(fin)) {
            if (!temp.isBefore(debut)) {
                return true;
            }
            temp = temp.plusDays(frequenceJours.getFrequenceJours());
        }
        return false;
    }
}
