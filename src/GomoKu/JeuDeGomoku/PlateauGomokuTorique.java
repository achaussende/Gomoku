/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.Position;

/**
 * 
 * @author Antoine
 */
public class PlateauGomokuTorique extends PlateauGomoku {

    public PlateauGomokuTorique() {
    }

    public PlateauGomokuTorique(int longueur, int largeur) {
        super(longueur, largeur);
    }
    
    @Override
    public boolean checkColonneId(Position pos, int id, int n) throws ExceptionPlateauJeu2D{
        int m = 0;
        int y = pos.getY();
        for (int i = 0; i < this.getLargeur(); i++) {
            for(int j=0;j<n;j++){
                int indice;
                if(i+j>this.getLargeur()-1){
                    indice=i+j-(this.getLargeur()-1);
                }else{
                    indice=i+j;
                }
                if (id == getIdPosition(new Position(indice, y))) {
                m++;
                if (m >= n) {
                    return true;
                }
            } else {
                m = 0;
            }
            } 
        }
        return false;
    } 
    public boolean checkLigneId(Position pos, int id, int n) throws ExceptionPlateauJeu2D{
        int m = 0;
        int x = pos.getX();
        int indiceStop = this.getLongueur()- n;
        for (int i = 0; i < this.getLongueur(); i++) {
            for(int j=0;j<n;j++){
                int indice;
                if(i+j>this.getLongueur()-1){
                    indice=i+j-(this.getLongueur()-1);
                }else{
                    indice=i+j;
                }
                if (id == getIdPosition(new Position(x, indice))) {
                m++;
                if (m >= n) {
                    return true;
                }
            } else {
                m = 0;
            }
            } 
        }
        return false;
    }
}