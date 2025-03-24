package action;

import metier.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActionAjouterReunion extends Action {
    public ActionAjouterReunion(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());
        System.out.print("Lieu : ");
        String lieu = scanner.nextLine();

        String participants = utilisateur;
        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equalsIgnoreCase("oui")) {
            System.out.print("Participant à ajouter : ");
            participants += ", " + scanner.nextLine();
            System.out.println("Ajouter un autre ? (oui / non)");
        }

        calendar.ajouterEvent("Réunion", titre, utilisateur,
                LocalDateTime.of(annee, mois, jour, heure, minute),
                duree, lieu, participants, 0);

        System.out.println("Réunion ajoutée !");
    }
}
