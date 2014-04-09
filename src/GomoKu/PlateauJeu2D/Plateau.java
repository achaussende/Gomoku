package GomoKu.PlateauJeu2D;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author p1101362
 */
public class Plateau {

    private int longueur;
    private int largeur;
    private int[][] etatPlateau;
    private ArrayDeque<Coup> historique;

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public Plateau() {
    }

    public Plateau(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.etatPlateau = new int[longueur][largeur];
        this.historique = new ArrayDeque<Coup>() {
        };
    }

    public void initialiser(ArrayDeque<Coup> liste_coup) throws ExceptionPlateauJeu2D {
        for (Coup c : liste_coup) {
            this.jouer(c);
        }
    }

    public void jouer(Coup coup) {
        try {
            etatPlateau[coup.getPos().getX()][coup.getPos().getX()] = coup.getId();
            historique.add(coup);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Plateau.jouer en dehors du plateau");
        }
    }

    public ArrayList<Position> etatId(int id) {
        ArrayList<Position> l = new ArrayList<Position>();
        for (Coup c : historique) {
            if (c.getId() == id) {
                l.add(new Position(c.getPos().getX(), c.getPos().getY()));
            }

        }
        return l;
    }

    public String toString(boolean complet) {
        StringBuilder sb = new StringBuilder();
        sb.append("Plateau : \n");
        if (complet) {
            sb.append("Longueur = ");
            sb.append(longueur);
            sb.append("\nLargeur = ");
            sb.append(largeur);
            sb.append("\nEtat du plateau :\n");
        }
        for (int i = 0; i < longueur; i++) {
            sb.append("[ ");
            for (int j = 0; j < largeur; j++) {
                sb.append(etatPlateau[i][j]);
                sb.append(" ");

            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public void annuler() {
        this.historique.remove();
    }

    public int getIdPosition(Position p) throws ExceptionPlateauJeu2D {
        try {
            return etatPlateau[p.getX()][p.getY()];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw (new ExceptionPlateauJeu2D("Tentative d'accès à une case en dehors du tableau"));
        }
    }

    public int getDernierId() {
        return this.historique.getLast().getId();
    }
}
