package action;

import event.Event;
import metier.CalendarManager;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ActionAfficherPeriode extends Action {
    public ActionAfficherPeriode(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        System.out.print("Année de début (AAAA) : ");
        int anneeDebut = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois de début (1-12) : ");
        int moisDebut = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour de début (1-31) : ");
        int jourDebut = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure de début (0-23) : ");
        int heureDebut = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute de début (0-59) : ");
        int minuteDebut = Integer.parseInt(scanner.nextLine());

        System.out.print("Année de fin (AAAA) : ");
        int anneeFin = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois de fin (1-12) : ");
        int moisFin = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour de fin (1-31) : ");
        int jourFin = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure de fin (0-23) : ");
        int heureFin = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute de fin (0-59) : ");
        int minuteFin = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.of(anneeDebut, moisDebut, jourDebut, heureDebut, minuteDebut);
        LocalDateTime fin = LocalDateTime.of(anneeFin, moisFin, jourFin, heureFin, minuteFin);

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
