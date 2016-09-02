package elements;

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

    

    public Carte(int [][] terrain){
    }

    public void ramasseTresor(int x, int y){
    	if(terrain[x][y]>0)
    		terrain[x][y]--;
    }
    
    
    
    
    
	public int[][] getTerrain() {
		return terrain;
	}

	public void setTerrain(int[][] terrain) {
		this.terrain = terrain;
	}    
    
}
