package action;

import event.Id;
import metier.CalendarManager;

import java.util.Scanner;
import java.util.UUID;

public class ActionSupprimerEvent extends Action {
    public ActionSupprimerEvent(CalendarManager calendar, Scanner scanner, String utilisateur) {
        super(calendar, scanner, utilisateur);
    }

    @Override
    public void executer() {
        System.out.print("ID de l’événement à supprimer : ");
        String id = scanner.nextLine();
        UUID uuid = UUID.fromString(id);
        boolean success = calendar.supprimerEventParId(new Id(uuid));
        if (success) {
            System.out.println("Événement supprimé !");
        } else {
            System.out.println("Aucun événement trouvé avec cet ID.");
        }
    }
}
