import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Programme de comptage de mots dans un fichier texte.
 *
 * Ce programme lit un fichier texte ligne par ligne à l'aide d'un Scanner,
 * sépare chaque ligne en mots en utilisant l'espace comme délimiteur,
 * puis affiche le nombre total de mots contenus dans le fichier.
 *
 * @author Sall Mamadou
 */
public class NombreDeMots {

    /**
     * Point d'entrée du programme.
     * Demande à l'utilisateur le chemin du fichier à analyser,
     * puis compte et affiche le nombre total de mots.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        // Créer un Scanner pour lire l'entrée utilisateur (clavier)
        Scanner clavier = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   PROGRAMME DE COMPTAGE DE MOTS");
        System.out.println("===========================================");
        System.out.println();

        // Demander le chemin du fichier à l'utilisateur
        System.out.print("Entrez le chemin du fichier a analyser : ");
        String cheminFichier = clavier.nextLine();

        // Appeler la méthode de comptage et afficher le résultat
        int totalMots = compterMots(cheminFichier);

        // Vérifier que le comptage s'est bien passé (retourne -1 en cas d'erreur)
        if (totalMots != -1) {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.printf("Nombre total de mots dans le fichier : %d%n", totalMots);
            System.out.println("-------------------------------------------");
        }

        // Fermer le scanner clavier
        clavier.close();
    }

    /**
     * Compte le nombre de mots dans un fichier texte.
     *
     * La méthode ouvre le fichier avec un Scanner (File Scanner),
     * lit chaque ligne, la sépare en mots avec l'espace comme délimiteur,
     * et additionne le nombre de mots de chaque ligne.
     *
     * @param cheminFichier le chemin vers le fichier à analyser
     * @return le nombre total de mots, ou -1 en cas d'erreur
     */
    public static int compterMots(String cheminFichier) {

        // Variable pour stocker le nombre total de mots
        int nombreTotalDeMots = 0;

        // Variable pour compter le nombre de lignes lues
        int nombreDeLignes = 0;

        try {
            // Créer un objet File à partir du chemin fourni
            File fichier = new File(cheminFichier);

            // Créer un Scanner pour lire le contenu du fichier (File Scanner)
            Scanner lecteurFichier = new Scanner(fichier);

            System.out.println();
            System.out.println("Lecture du fichier : " + fichier.getAbsolutePath());
            System.out.println("Analyse en cours...");
            System.out.println();

            // Boucle : lire chaque ligne du fichier tant qu'il y en a
            while (lecteurFichier.hasNextLine()) {

                // Lire la ligne courante dans une chaîne de caractères (String)
                String ligne = lecteurFichier.nextLine();

                // Incrémenter le compteur de lignes
                nombreDeLignes++;

                // Ignorer les lignes vides (elles ne contiennent pas de mots)
                if (ligne.trim().isEmpty()) {
                    System.out.printf("  Ligne %d : (vide)%n", nombreDeLignes);
                    continue;
                }

                // Séparer la chaîne en utilisant l'espace comme délimiteur
                // La méthode split("\\s+") sépare sur un ou plusieurs espaces
                String[] mots = ligne.trim().split("\\s+");

                // Compter le nombre de mots dans cette ligne
                // en utilisant la longueur du tableau créé après la séparation
                int motsDansLigne = mots.length;

                // Afficher le détail pour chaque ligne
                System.out.printf("  Ligne %d : %d mot(s)%n", nombreDeLignes, motsDansLigne);

                // Additionner les mots de cette ligne au total
                nombreTotalDeMots += motsDansLigne;
            }

            // Fermer le lecteur de fichier
            lecteurFichier.close();

            System.out.println();
            System.out.printf("Total de lignes lues : %d%n", nombreDeLignes);

        } catch (FileNotFoundException e) {
            // Gestion de l'erreur si le fichier n'est pas trouvé
            System.out.println();
            System.out.println("ERREUR : Le fichier '" + cheminFichier + "' est introuvable.");
            System.out.println("Veuillez verifier le chemin et reessayer.");
            return -1;
        }

        // Retourner le nombre total de mots
        return nombreTotalDeMots;
    }
}
