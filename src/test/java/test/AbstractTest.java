package test;

import elements.Aventurier;

public abstract class AbstractTest {

	protected  int[][] terrain(int x, int y){
		int [][] terrain = new int[x][y];
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				terrain[i][j] = 0;
			}
		}
		return terrain;
	}
	protected  int[][] terrain2x2RamasseTresor(){
		int [][] terrain = terrain(2,2);
		terrain[1][1] = 3;
		return terrain;
	}

	protected  int[][] terrain3x3(){
		int [][] terrain = terrain(3,3);
		return terrain;
	}

	protected  int[][] terrain3x3Montagne21(){
		int [][] terrain = terrain(3,3);
		terrain[2][1] = -1;
		return terrain;
	}

	protected  int[][] terrain3x3Tresor(){
		int [][] terrain = terrain(3,3);
		terrain[2][1] = 3;
		return terrain;
	}
}
