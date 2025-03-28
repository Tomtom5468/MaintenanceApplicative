package event;

import anniversaire.Anniversaire;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import periodique.Periodique;
import rdv.RendezVous;
import reunion.Reunion;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class EventFabricator {

    public static Event fabricateEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                                       String lieu, String participants, int frequenceJours, String nom) {
        switch (type){
            case "Rendez-vous":
                return new RendezVous(title, proprietaire, dateDebut, dureeMinutes, UUID.randomUUID());
            case "Periodique":
                return new Periodique(title, proprietaire, dateDebut, dureeMinutes, frequenceJours,UUID.randomUUID());
            case "Réunion":
                return new Reunion(title, proprietaire, dateDebut, dureeMinutes, lieu, participants,UUID.randomUUID());
            case "Anniversaire":
                return new Anniversaire(title, proprietaire, dateDebut, dureeMinutes,nom,UUID.randomUUID());
            default:
                return null;
        }
    }
}
