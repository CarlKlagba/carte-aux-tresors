package elements;

import java.util.HashMap;

public class Partie {
	HashMap<String, Aventurier> aventuriers;
	Carte carte;
	
	
	public Partie(HashMap<String, Aventurier> aventuriers, Carte carte) {
		super();
		this.aventuriers = aventuriers;
		this.carte = carte;
	}
	
	
}
