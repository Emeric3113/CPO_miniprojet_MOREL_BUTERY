/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package light_off;

/**
 *
 * @author emeri
 */
public class Light_off {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Partie partie = new Partie(5, 5); // Grille 5x5 par défaut
        partie.initialiserPartie(10); // Mélange avec 10 activations aléatoires
        partie.lancerPartie(); // Démarrer la partie
    }
}
