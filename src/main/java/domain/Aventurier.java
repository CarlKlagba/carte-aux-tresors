package domain;

/**
 * Created by Travail on 29/08/2016.
 */
public class Aventurier {
    String nom;
    int positionX;
    int positionY;
    Orientation orientation;

    public Aventurier(String nom, int positionX, int positionY, Orientation orientation) {
        this.nom =nom;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }
}