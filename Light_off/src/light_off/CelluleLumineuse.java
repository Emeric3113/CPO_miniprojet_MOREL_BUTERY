/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light_off;

/**
 *
 * @author emeri
 */
public class CelluleLumineuse {
    // Attribut pour représenter l'état de la cellule (true = allumée, false = éteinte)
    private boolean etat;

    public CelluleLumineuse() {
        this.etat = false; // Initialisation à éteinte
    }

    /**
     * Active la cellule lumineuse en inversant son état.
     * Si elle est allumée, elle devient éteinte, et vice versa.
     */
    public void activerCellule() {
        this.etat = !this.etat; // Inversion de l'état
    }

    /**
     * Éteint la cellule lumineuse en mettant son état à éteint (false).
     * Si elle est déjà éteinte, cette méthode n'a aucun effet.
     */
    public void eteindreCellule() {
        this.etat = false; // Met l'état à éteint
    }

    /**
     * Vérifie si la cellule lumineuse est éteinte.
     * @return true si la cellule est éteinte, false si elle est allumée.
     */
    public boolean estEteint() {
        return !this.etat;
    }

    /**
     * Renvoie l'état actuel de la cellule lumineuse.
     * @return true si la cellule est allumée, false si elle est éteinte.
     */
    public boolean getEtat() {
        return this.etat;
    }

    /**
     * Retourne une représentation textuelle de la cellule lumineuse.
     * @return "X" si la cellule est allumée, "O" si elle est éteinte.
     */
    @Override
    public String toString() {
        return this.etat ? "X" : "O";
    }
}
