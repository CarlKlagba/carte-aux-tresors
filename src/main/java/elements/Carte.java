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
    private int [][] terrain;

	private int limitX;
	private int limitY;

    public Carte(int [][] terrain){
    	this.terrain = terrain;

		this.limitX = terrain.length;
		this.limitY = terrain[0].length;
	}

	public Carte(int [][] terrain, int limitX, int limitY){
		this.terrain = terrain;

		this.limitX = limitX;
		this.limitY = limitY;
	}

    public int ramasseTresor(int x, int y){
		int numTresor = terrain[x][y];
    	terrain[x][y]=0;
		return numTresor;
    }
    
    
    
    @Override
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < terrain.length; i++) {
    		for (int j = 0; j < terrain[i].length; j++) {
    			if(terrain[i][j]<0){ //montagne
    				sb.append("M ")
    					.append(i+1).append("-").append(j+1)
    					.append("\n");
    			}else if(terrain[i][j]>0){ //Tresor
    				sb.append("T ")
	    				.append(i+1).append("-").append(j+1)
						.append(" ").append(terrain[i][j])
						.append("\n");
    			}
    		}
		}
    	return sb.toString();
    }
    
	public int[][] getTerrain() {
		return terrain;
	}

	public void setTerrain(int[][] terrain) {
		this.terrain = terrain;
	}

	public int getLimitY() {
		return limitY;
	}

	public void setLimitY(int limitY) {
		this.limitY = limitY;
	}

	public int getLimitX() {
		return limitX;
	}

	public void setLimitX(int limitX) {
		this.limitX = limitX;
	}
}
