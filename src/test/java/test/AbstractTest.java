package test;

import elements.Aventurier;

public abstract class AbstractTest {
	
	
	protected  int[][] terrain2x2RamasseTresor(){
		int [][] terrain = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				terrain[i][j] = 0;
			}
		}
		
		terrain[1][1] = 3;
		
		return terrain;
	}

	protected  int[][] terrain3x3(){
		int [][] terrain = new int[3][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				terrain[i][j] = 0;
			}
		}

		return terrain;
	}

	protected  int[][] terrain3x3Montagne21(){
		int [][] terrain = new int[3][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				terrain[i][j] = 0;
			}
		}
		
		terrain[2][1] = -1;
		
		return terrain;
	}

	protected  int[][] terrain3x3Tresor(){
		int [][] terrain = terrain3x3();
		terrain[2][1] = 3;
		return terrain;
	}
}
