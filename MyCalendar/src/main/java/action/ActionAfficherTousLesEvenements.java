package action;

import metier.CalendarManager;

import java.util.Scanner;

public class ActionAfficherTousLesEvenements extends Action {
    public ActionAfficherTousLesEvenements(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        calendar.afficherEvenements();
    }
}
