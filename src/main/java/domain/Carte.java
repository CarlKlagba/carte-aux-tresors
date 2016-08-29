package domain;

import java.util.List;

/**
 * Created by Travail on 29/08/2016.
 */
public class Carte {
    /**
     * Le terrain sur le quel évolue les aventuriers
     * Plain = 0
     * Trésor > 0
     * Montagne < 0
     * */
    int [][] terrain;

    /**
     * La liste des aventuriers
     */
    List<Aventurier> aventuriers; //faire une map avec en key le nom??

    public Carte(int [][] terrain, List<Aventurier> aventuriers){
        this.terrain = terrain;
        this.aventuriers = aventuriers;
    }
}
