package src.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import src.periodique.Periodique;
import src.rdv.RendezVous;
import src.reunion.Reunion;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class EventFabricator {

    public static Event fabricateEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                                       String lieu, String participants, int frequenceJours) {
        switch (type){
            case "Rendez-vous":
                return new RendezVous(title, proprietaire, dateDebut, dureeMinutes);
            case "Periodique":
                return new Periodique(title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
            case "Réunion":
                return new Reunion(title, proprietaire, dateDebut, dureeMinutes, lieu, participants);
            default:
                return null;
        }
    }
}
