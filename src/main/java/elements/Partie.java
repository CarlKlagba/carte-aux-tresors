package elements;

import java.util.HashMap;

import elements.enumeration.Action;

public class Partie {
	private HashMap<String, Aventurier> aventuriers;
	private Carte carte;
	
	private int nbTours = 0;
	
	
	public Partie(HashMap<String, Aventurier> aventuriers, Carte carte) {
		super();
		this.aventuriers = aventuriers;
		this.carte = carte;
	}
	
	public void perform(Action action, String nom){
		Aventurier a = aventuriers.get(nom);
		if(action.check(a, carte)){
			a.perform(action);
		}
	}
	
	public void run(){
        this.nbTours = 0;
        Boolean fin = false;
        while (!fin){
            fin = true;
            for (String nom: aventuriers.keySet()){
            	try {
            		Action action = aventuriers.get(nom).getListAction().get(nbTours);
	            	perform(action, nom);
	            	fin = fin && false;
            	}catch (IndexOutOfBoundsException e){ 
                  fin = fin && true;
            	}
            }
            nbTours++;
        }
	}
	
	
	
	
	
	
	public HashMap<String, Aventurier> getAventuriers() {
		return aventuriers;
	}


	public Carte getCarte() {
		return carte;
	}
	
}
