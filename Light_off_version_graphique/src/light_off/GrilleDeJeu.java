/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light_off;

import java.util.Random;

/**
 *
 * @author emeri
 */

// GrilleDeJeu.java
import java.util.Random;

public class GrilleDeJeu {
    // Paramètres de la fenêtre
    private CelluleLumineuse[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;

    public GrilleDeJeu(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();
        for (int t = 0; t < nbTours; t++) {
            int ligne = random.nextInt(nbLignes);
            int colonne = random.nextInt(nbColonnes);
            activerCellulesAdjacentes(ligne, colonne);
        }
    }

    public void activerCellulesAdjacentes(int ligne, int colonne) {
        if (ligne > 0) matriceCellules[ligne - 1][colonne].activerCellule(); // Haut
        if (ligne < nbLignes - 1) matriceCellules[ligne + 1][colonne].activerCellule(); // Bas
        if (colonne > 0) matriceCellules[ligne][colonne - 1].activerCellule(); // Gauche
        if (colonne < nbColonnes - 1) matriceCellules[ligne][colonne + 1].activerCellule(); // Droite
        matriceCellules[ligne][colonne].activerCellule();
    }

    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteinte()) {
                    return false;
                }
            }
        }
        return true;
    }
        public boolean cellulesToutesAllumee() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].estEteinte()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getEtatCellule(int ligne, int colonne) {
        return !matriceCellules[ligne][colonne].estEteinte();
    }
    

    public void afficherGrille() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                System.out.print(matriceCellules[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Méthodes pour obtenir les dimensions de la grille
    public int getNbLignes() {
        return this.nbLignes;
    }

    public int getNbColonnes() {
        return this.nbColonnes;
    }
}
