import action.*;
import metier.CalendarManager;

import java.util.*;

public class Main {
    static int nbUtilisateurs = 0;

    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        final String[] userRef = new String[]{null};
        boolean[] continuer = {true};

        String[] utilisateurs = new String[99];
        String[] motsDePasses = new String[99];

        Map<String, String> comptesFixes = Map.of(
                "Roger", "Chat",
                "Pierre", "KiRouhl"
        );

        while (true) {
            while (userRef[0] == null) {
                System.out.println("=== Connexion ===");
                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.print("Choix : ");
                String choixConnexion = scanner.nextLine();

                Map<String, Runnable> actionsConnexion = new HashMap<>();
                actionsConnexion.put("1", () -> connexion(scanner, comptesFixes, utilisateurs, motsDePasses, userRef));
                actionsConnexion.put("2", () -> creationCompte(scanner, utilisateurs, motsDePasses, userRef));

                actionsConnexion.getOrDefault(choixConnexion, () -> System.out.println("Choix invalide.")).run();
            }

            while (continuer[0]) {
                System.out.println("\nBonjour, " + userRef[0]);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Afficher TOUS les événements");
                System.out.println("2 - Afficher les événements d’un MOIS");
                System.out.println("3 - Afficher les événements d’une SEMAINE");
                System.out.println("4 - Afficher les événements d’un JOUR");
                System.out.println("5 - Afficher les événements par période");
                System.out.println("6 - Ajouter un RDV personnel");
                System.out.println("7 - Ajouter une réunion");
                System.out.println("8 - Ajouter un évènement périodique");
                System.out.println("9 - Ajouter un évènement anniversaire");
                System.out.println("10 - Supprimer un évènement");
                System.out.println("11 - Se déconnecter");
                System.out.print("Votre choix : ");
                String choixAction = scanner.nextLine();

                ActionManager actionManager = new ActionManager();
                actionManager.enregistrer("1", () -> new ActionAfficherTousLesEvenements(calendar, scanner, userRef[0]));
                actionManager.enregistrer("2", () -> new ActionAfficherParMois(calendar, scanner, userRef[0]));
                actionManager.enregistrer("3", () -> new ActionAfficherParSemaine(calendar, scanner, userRef[0]));
                actionManager.enregistrer("4", () -> new ActionAfficherParJour(calendar, scanner, userRef[0]));
                actionManager.enregistrer("5", () -> new ActionAfficherPeriode(calendar, scanner, userRef[0]));
                actionManager.enregistrer("6", () -> new ActionAjouterRdv(calendar, scanner, userRef[0]));
                actionManager.enregistrer("7", () -> new ActionAjouterReunion(calendar, scanner, userRef[0]));
                actionManager.enregistrer("8", () -> new ActionAjouterPeriodique(calendar, scanner, userRef[0]));
                actionManager.enregistrer("9", () -> new ActionAjouterAnniversaire(calendar, scanner, userRef[0]));
                actionManager.enregistrer("10", () -> new ActionSupprimerEvent(calendar, scanner, userRef[0]));
                actionManager.enregistrer("11", () -> {
                    new ActionDeconnexion(calendar, scanner, userRef[0]).executer();
                    System.out.println("Voulez-vous continuer ? (oui / non)");
                    continuer[0] = scanner.nextLine().trim().equalsIgnoreCase("oui");
                    userRef[0] = null;
                    return null;
                });

                Optional.ofNullable(actionManager.getAction(choixAction))
                        .ifPresentOrElse(Action::executer,
                                () -> System.out.println("Choix invalide."));
                Optional.ofNullable(userRef[0])
                        .ifPresentOrElse(
                                user -> {},
                                () -> continuer[0] = false
                        );
            }
        }
    }

    private static void connexion(Scanner scanner,
                                  Map<String, String> comptesFixes,
                                  String[] utilisateurs,
                                  String[] motsDePasses,
                                  String[] userRef) {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        Map<String, String> comptes = new HashMap<>(comptesFixes);
        for (int i = 0; i < nbUtilisateurs; i++) {
            comptes.put(utilisateurs[i], motsDePasses[i]);
        }

        userRef[0] = Optional.ofNullable(comptes.get(username))
                .filter(p -> p.equals(password))
                .map(p -> username)
                .orElse(null);
    }

    private static void creationCompte(Scanner scanner,
                                       String[] utilisateurs,
                                       String[] motsDePasses,
                                       String[] userRef) {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        String repeat = scanner.nextLine();

        Map<Boolean, Runnable> actionSelonCorrespondance = Map.of(
                true, () -> {
                    utilisateurs[nbUtilisateurs] = username;
                    motsDePasses[nbUtilisateurs] = password;
                    nbUtilisateurs++;
                    userRef[0] = username;
                },
                false, () -> System.out.println("Les mots de passe ne correspondent pas...")
        );

        actionSelonCorrespondance.get(password.equals(repeat)).run();
    }
}
