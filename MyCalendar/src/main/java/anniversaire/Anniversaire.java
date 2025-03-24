package anniversaire;

import anniversaire.Nom;
import event.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Anniversaire extends Event {
    private Nom nom;

    public Anniversaire(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String nom, UUID id) {
        super(title, proprietaire, dateDebut, dureeMinutes,id);
        this.nom = new Nom(nom);
    }

    @Override
    public String description() {
        return "[ID: " + id.getId() + "] : Anniversaire de " + nom.getNom();
    }

    @Override
    public boolean isBefore(LocalDateTime debut, LocalDateTime fin) {
        return !this.dateDebut.getDateDebut().isBefore(debut) && !this.dateDebut.getDateDebut().isAfter(fin);
    }
}
