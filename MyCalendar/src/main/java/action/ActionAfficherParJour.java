package action;

import event.Event;
import metier.CalendarManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ActionAfficherParJour extends Action {
    public ActionAfficherParJour(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.of(annee, mois, jour, 0, 0);
        LocalDateTime fin = debut.plusDays(1).minusSeconds(1);

        List<Event> events = calendar.eventsDansPeriode(debut, fin);
        afficherListe(events);
    }

    private void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé.");
        } else {
            evenements.forEach(e -> System.out.println("- " + e.description()));
        }
    }
}
