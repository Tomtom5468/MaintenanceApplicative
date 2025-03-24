package action;

import event.Event;
import metier.CalendarManager;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ActionAfficherParSemaine extends Action {
    public ActionAfficherParSemaine(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.now()
                .withYear(annee)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime fin = debut.plusDays(7).minusSeconds(1);

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
