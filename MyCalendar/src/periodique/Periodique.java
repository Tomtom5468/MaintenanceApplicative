package src.periodique;

import lombok.Getter;
import lombok.Setter;
import src.event.Event;

import java.time.LocalDateTime;

@Getter
@Setter
public class Periodique extends Event {
    private FrequenceJours frequenceJours;
    public Periodique(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,int frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = new FrequenceJours(frequenceJours);
    }

    @Override
    public String description(){
        return "Événement périodique : " + title.getNom() + " tous les " + frequenceJours.getFrequenceJours() + " jours";
    }
}
