package GomoKu.PlateauJeu2D;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Classe abstraite de définition d'un plateau de jeu en 2D
 *
 * @author Antoine CARON
 */
public abstract class Plateau {

    private int longueur;
    private int largeur;
    private int[][] etatPlateau;
    private ArrayDeque<Coup> historique;

    /**
     * Getter de la longueur du plateau
     *
     * @return Longueur du plateau
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * Getter de la largeur du plateau
     *
     * @return Largeur du plateau
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Getter de l'historique
     *
     * @return historique du jeu
     */
    public ArrayDeque<Coup> getHistorique() {
        return historique;
    }

    /**
     * Deep copy de l'historique du plateau de jeu actuel
     *
     * @return Liste de coups provenant de l'historique de jeu
     */
    public ArrayList<Coup> getSituation() {
        ArrayList<Coup> histo = new ArrayList<>(this.getHistorique().clone());
        return histo;
    }

    /**
     * Constructeur vide
     */
    public Plateau() {
    }

    /**
     * Constructeur de Plateau
     *
     * @param longueur : longueur de la grille
     * @param largeur : largeur de la grille
     */
    public Plateau(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.etatPlateau = new int[longueur][largeur];
        this.historique = new ArrayDeque<Coup>() {
        };
    }

    /**
     * Initialisation de la grille de jeu (etatPlateau) à partir d'une file de
     * coups
     *
     * @param liste_coup File de coup à joueur pour l'initialisation du plateau
     * @throws ExceptionPlateauJeu2D
     */
    public void initialiser(ArrayDeque<Coup> liste_coup) throws ExceptionPlateauJeu2D {
        for (Coup c : liste_coup) {
            this.jouer(c);
        }
    }

    /**
     * Place un coup passé en paramètre dans la grille de jeu etatPlateau
     *
     * @param coup Coup à jouer dans la grille de jeu
     */
    public void jouer(Coup coup) {
        try {
            etatPlateau[coup.getPos().getX()][coup.getPos().getY()] = coup.getId();
            historique.add(coup);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Plateau.jouer en dehors du plateau");
        }
    }

    /**
     * A partir de l'historique, donne toutes les position où le joueur
     * d'identifiant id a joué
     *
     * @param id identifiant du joueur
     * @return Liste de positions où le joueur à joué
     */
    public ArrayList<Position> etatId(int id) {
        ArrayList<Position> l = new ArrayList<Position>();
        for (Coup c : historique) {
            if (c.getId() == id) {
                l.add(new Position(c.getPos().getX(), c.getPos().getY()));
            }

        }
        return l;
    }

    /**
     * Fonction de conversion de l'état du plateau de jeu (tableau) en une
     * chaine de caractères affichable
     *
     * @param complet True, affiche les infos complètes du plateau. False,
     * affiche seulement l'état du plateau (la grille)
     * @return Chaine de caractères
     */
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

    /**
     * Annulation d'un coup en le retirant du plateau (sur la grlle et dans
     * l'historique)
     */
    public void annuler() {
        Coup c = this.historique.getLast();
        etatPlateau[c.getPos().getX()][c.getPos().getY()] = 0;
        this.historique.removeLast();
    }

    public int getIdPosition(Position p) throws ExceptionPlateauJeu2D {
        try {
            return etatPlateau[p.getX()][p.getY()];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw (new ExceptionPlateauJeu2D("Tentative d'accès à une case en dehors du tableau"));
        }
    }

    /**
     * Récupère l'identifiant du dernier joueur à avoir joué. Si personne n'a
     * encore joué, renvoie 0.
     *
     * @return ID du dernier jouer à avoir joué, 0 si personne n'a encore joué
     */
    public int getDernierId() {
        int id = 0;
        try {
            id = this.historique.getLast().getId();
        } catch (NoSuchElementException ex) {
            System.out.println("getDernierId() --> Personne n'a encore joué");
            return id;
        }
        return id;
    }

    /**
     * Récupère toutes les positions où le joueur d'identifiant id a joué
     *
     * @param id Identifiant du joueur
     * @return Liste de positions où a joué le joueur
     */
    public ArrayList<Position> getPositionsParId(int id) {
        ArrayList<Position> posPossibles = new ArrayList<Position>();
        for (int i = 0; i < longueur; ++i) {
            for (int j = 0; j < largeur; ++j) {
                Position p = new Position(i, j);
                try {
                    if (id == getIdPosition(p)) {
                        posPossibles.add(p);
                    }
                } catch (ExceptionPlateauJeu2D ex) {
                    System.out.println("getPositionParID --> Position en dehors de la grille.");
                }
            }
        }
        return posPossibles;
    }

    /**
     * Vérification si la grille est totalement remplie.
     *
     * @return True si la grille est totalement remplie, False sinon.
     */
    public boolean isFull() {
        for (int i = 0; i < longueur; ++i) {
            for (int j = 0; j < largeur; ++j) {
                try {
                    if (this.getIdPosition(new Position(i, j)) == 0) {
                        return false;
                    }
                } catch (ExceptionPlateauJeu2D ex) {
                    System.out.println("isFull --> Position en dehors de la grille.");
                }
            }
        }
        return true;
    }

    /**
     * Vérification de la présence de n coups alignés sur la même colonne où le
     * coup a été posé par le joueur d'identifiant id. True si c'est le cas.
     * False sinon.
     *
     * @param pos Position où a été joué le coup
     * @param id Identifiant du joueur pour vérifier la condition de victoire
     * pour ce joueur
     * @param n nombre de coups
     * @return True si n coups alignés sur la même colonne, False sinon.
     * @throws ExceptionPlateauJeu2D
     */
    public abstract boolean checkColonneId(Position pos, int id, int n);

    /**
     * Vérification de la présence de n coups alignés sur la même ligne où le
     * coup a été posé par le joueur d'identifiant id. True si c'est le cas.
     * False sinon.
     *
     * @param pos Position où a été joué le coup
     * @param id ID du joueur pour vérifier la condition de victoire pour ce
     * joueur
     * @param n nombre de coups
     * @return True si n coups alignés sur la même ligne, False sinon.
     * @throws ExceptionPlateauJeu2D
     */
    public abstract boolean checkLigneId(Position pos, int id, int n);
}
