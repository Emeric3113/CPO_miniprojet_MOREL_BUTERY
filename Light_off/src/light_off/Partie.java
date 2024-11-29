/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light_off;

import java.util.Scanner;


/**
 *
 * @author emeri
 */
public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;

    public Partie(int nbLignes, int nbColonnes) {
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
        this.nbCoups = 0;
    }

    // Méthode pour initialiser la partie avec un mélange de cellules
    public void initialiserPartie(int nbToursMelange) {
        this.grille.melangerMatriceAleatoirement(nbToursMelange);
    }

    // Lancer la partie, permettant au joueur de jouer
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans Lights Off !");
        System.out.println("Éteignez toutes les cellules en modifiant uniquement les cellules adjacentes.\n");

        while (!grille.cellulesToutesEteintes()) {
            System.out.println("État actuel de la grille :");
            grille.afficherGrille(); // Affichage de la grille

            System.out.print("Choisissez une cellule (ex: 1,2 pour ligne 1 colonne 2) : ");
            String[] choix = scanner.nextLine().split(",");
            if (choix.length != 2) {
                System.out.println("Entrée invalide. Réessayez.");
                continue;
            }

            try {
                int ligne = Integer.parseInt(choix[0].trim());
                int colonne = Integer.parseInt(choix[1].trim());

                if (ligne < 0 || ligne >= grille.getNbLignes() || colonne < 0 || colonne >= grille.getNbColonnes()) {
                    System.out.println("Coordonnées hors limites. Réessayez.");
                    continue;
                }

                // Appliquer la règle : changer les cellules adjacentes
                grille.activerCellulesAdjacentes(ligne, colonne);
                nbCoups++;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Utilisez des nombres pour les coordonnées. Réessayez.");
                continue;
            }

            if (grille.cellulesToutesEteintes()) {
                System.out.println("\nBravo ! Vous avez gagné en " + nbCoups + " coups !");
                break;
            }
        }

        scanner.close();
    }
}