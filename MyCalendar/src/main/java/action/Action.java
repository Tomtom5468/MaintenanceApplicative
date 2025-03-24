package action;

import metier.CalendarManager;

import java.util.Scanner;

public abstract class Action {
    protected CalendarManager calendar;
    protected Scanner scanner;
    protected String utilisateur;

    public Action(CalendarManager calendar, Scanner scanner, String utilisateur) {
        this.calendar = calendar;
        this.scanner = scanner;
        this.utilisateur = utilisateur;
    }

    public abstract void executer();
}
