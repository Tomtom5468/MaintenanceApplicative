package anniversaire;

import anniversaire.Nom;
import event.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Anniversaire extends Event {
    private Nom nom;

    public Anniversaire(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String nom) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.nom = new Nom(nom);
    }

    @Override
    public String description() {
        return "Anniversaire de " + nom.getNom();
    }

    @Override
    public boolean isBefore(LocalDateTime debut, LocalDateTime fin) {
        return !this.dateDebut.getDateDebut().isBefore(debut) && !this.dateDebut.getDateDebut().isAfter(fin);
    }
}
