package action;

import metier.CalendarManager;

import java.util.Scanner;

public class ActionDeconnexion extends Action {
    public ActionDeconnexion(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        System.out.println("Déconnexion effectuée.");
    }
}
