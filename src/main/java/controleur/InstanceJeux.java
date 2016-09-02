package controleur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import elements.Aventurier;
import elements.Carte;
/*
 * Va creer la carte
 * et va executer les actions du jeux
 * en s'assurant que toutes les actions
 * respecte des contraintes
 */
public class InstanceJeux {
	
	private Carte carte;
	
	/**
     * La liste des aventuriers
     */
   private  Map<String, Aventurier> aventuriers; //faire une map avec en key le nom??
    
    
	public InstanceJeux(Carte carte, List<Aventurier> aventuriers){
		this.carte = carte;
		this.aventuriers = new HashMap<String, Aventurier>();
		for (Aventurier a : aventuriers) {
			this.aventuriers.put(a.getNom(), a);
		}
	}
	
	
	public void avance(String nom){
		Aventurier a = aventuriers.get(nom);
		
		Aventurier aFutur;
	
	}


	
	
	
	public Carte getCarte() {
		return carte;
	}


	public void setCarte(Carte carte) {
		this.carte = carte;
	}


	public Map<String, Aventurier> getAventuriers() {
		return aventuriers;
	}


	public void setAventuriers(Map<String, Aventurier> aventuriers) {
		this.aventuriers = aventuriers;
	}
	
	
	
}
