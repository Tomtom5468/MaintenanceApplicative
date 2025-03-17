package affichage;

import java.util.Scanner;

public class Compte {
    public static void seConnecter(Scanner scanner, String[] utilisateurs, String[] motsDePasses) {
        System.out.print("Nom d'utilisateur: ");
        String utilisateur = scanner.nextLine();

        if (utilisateur.equals("Roger")) {
            String motDePasse = scanner.nextLine();
            if (!motDePasse.equals("Chat")) {
                utilisateur = null;
            }
        } else {
            if (utilisateur.equals("Pierre")) {
                String motDePasse = scanner.nextLine();
                if (!motDePasse.equals("KiRouhl")) {
                    utilisateur = null;
                }
            } else {
                System.out.print("Mot de passe: ");
                String motDePasse = scanner.nextLine();

                for (int i = 0; i < nbUtilisateurs; i = i + 1) {
                    if (utilisateurs[i].equals(utilisateur) && motsDePasses[i].equals(motDePasse)) {
                        utilisateur = utilisateurs[i];
                    }
                }
            }
        }
    }
}
