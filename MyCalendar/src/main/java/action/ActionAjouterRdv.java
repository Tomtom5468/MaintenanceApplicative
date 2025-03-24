package action;
import metier.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActionAjouterRdv extends Action {
    public ActionAjouterRdv(CalendarManager calendar, Scanner scanner, String utilisateur) {
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

        boolean success = calendar.ajouterEvent("Rendez-vous", titre, utilisateur,
                LocalDateTime.of(annee, mois, jour, heure, minute), duree,
                "", "", 0,"");
        if (success) {
            System.out.println("Événement ajouté.");
        } else {
            System.out.println("Conflit détecté : événement non ajouté.");
        }

        System.out.println("Événement ajouté.");
    }
}
