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
    private boolean etat; // True = allumée, False = éteinte

    public CelluleLumineuse() {
        this.etat = false; // Par défaut, la cellule est éteinte
    }

    // Inverse l'état de la cellule (allumée <-> éteinte)
    public void activerCellule() {
        this.etat = !this.etat;
    }

    // Vérifie si la cellule est éteinte
    public boolean estEteinte() {
        return !this.etat;
    }

    @Override
    public String toString() {
        return this.etat ? "X" : "O"; // Affiche "X" si allumée, "O" si éteinte
    }
}
