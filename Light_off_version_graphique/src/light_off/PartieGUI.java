/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package light_off;

/**
 *
 * @author emeri
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartieGUI extends javax.swing.JFrame {
    private Partie partie;
    private JFrame frame;
    private JPanel panel;
    private JButton[][] buttons;
    private JLabel compteurCoups;
    /**
     * Creates new form PartieGUI
     */
    public PartieGUI() {
        initComponents();
        partie = new Partie(5, 5); // Crée une grille 5x5
        partie.initialiserPartie(10); // Mélange aléatoire

        frame = new JFrame("Lights Off");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));

        buttons = new JButton[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton(partie.getGrille().getEtatCellule(i, j) ? "X" : "O");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                buttons[i][j].setBackground(partie.getGrille().getEtatCellule(i, j) ? Color.YELLOW : Color.GRAY);
                final int ligne = i;
                final int colonne = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleClick(ligne, colonne);
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

        compteurCoups = new JLabel("Coups : 0");
        frame.add(compteurCoups, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        
        // Ajouter une zone pour les boutons en bas
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3)); // Deux boutons côte à côte
        
        // Bouton pour revenir à l'acceil
        JButton boutonAccueil = new JButton("Accueil");
        boutonAccueil.setFont(new Font("Arial", Font.PLAIN, 16));
        boutonAccueil.addActionListener(e -> {
    // Créer une nouvelle instance de la classe Menu
    Menu menu = new Menu();
    menu.setVisible(true); // Affiche la fenêtre Menu
    ((JFrame) SwingUtilities.getWindowAncestor(boutonAccueil)).dispose(); // Ferme la fenêtre actuelle
});
        bottomPanel.add(boutonAccueil);
        
        // Bouton pour commencer
        JButton boutonRejouer = new JButton("Rejouer");
        boutonRejouer.setFont(new Font("Arial", Font.PLAIN, 16));
        boutonRejouer.addActionListener(e -> recommencerPartie());
        bottomPanel.add(boutonRejouer);
        
        // Bouton pour quitter le jeu
        JButton boutonQuitter = new JButton("Quitter le jeu");
        boutonQuitter.setFont(new Font("Arial", Font.PLAIN, 16));
        boutonQuitter.addActionListener(e -> System.exit(0)); // Ferme totalement l'application
        bottomPanel.add(boutonQuitter);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }

    private void handleClick(int ligne, int colonne) {
        // Applique les changements de cellules adjacentes
        partie.jouerCoup(ligne, colonne);
        refreshGrid();
        
        if (partie.getGrille().cellulesToutesAllumee()) {
            compteurCoups.setText("Bravo ! Vous avez allumé toutes les lumières en " + partie.getNbCoups() + " coups.");
            desactiverBoutons(); // Désactive les boutons une fois la partie gagnée
        } else if (partie.getGrille().cellulesToutesEteintes()) {
            compteurCoups.setText("Bravo ! Vous avez éteint toutes les lumières en " + partie.getNbCoups() + " coups.");
            desactiverBoutons(); // Désactive les boutons une fois la partie gagnée
        } else {
            compteurCoups.setText("Coups : " + partie.getNbCoups());
        }
    }
    
    private void desactiverBoutons() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setEnabled(false); // Désactive chaque bouton
            }
        }
    }

    private void recommencerPartie() {
        // Réinitialiser la partie
        partie = new Partie(5, 5);
        partie.initialiserPartie(10);

        // Réinitialiser l'affichage
        compteurCoups.setText("Coups : 0");
        refreshGrid();
    }

    private void refreshGrid() {
        // Met à jour les boutons de la grille
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText(partie.getGrille().getEtatCellule(i, j) ? "X" : "O");
                buttons[i][j].setBackground(partie.getGrille().getEtatCellule(i, j) ? Color.YELLOW : Color.GRAY);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
