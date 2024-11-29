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

    public void initialiserPartie(int nbToursMelange) {
        this.grille.melangerMatriceAleatoirement(nbToursMelange);
    }
    
}