package controleur;

import java.util.*;

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

	/*commencer par faire un algo naif en faisant déplacer
	* les joueurs les uns apres les autres
	* sans conflit entre eux
	* */
	public void run(){
		for (String nom : aventuriers.keySet()){
			Aventurier a = aventuriers.get(nom);
			bouge(nom, a.getMouvements());
		}
	}

	public void bouge(String nom, String mouvements){
		List<String> listMouv = new ArrayList(Arrays.asList(mouvements.split("")));
		for (String mouv: listMouv) {
			if(mouv.equals("A")){
				avance(nom);
			}else if (mouv.equals("D")){
				rotationDroite(nom);
			}else if (mouv.equals("G")){
				rotationGauche(nom);
			}
		}
	}

	public void rotationDroite(String nom){
		aventuriers.get(nom).rotationDroite();
	}

	public void rotationGauche(String nom){
		aventuriers.get(nom).rotationGauche();
	}

	public void ramasse(String nom){
		Aventurier a = aventuriers.get(nom);
		a.ramasseTresor(carte.ramasseTresor(a.getPositionX(), a.getPositionY()));
	}

	public void avance(String nom){
		Aventurier a = aventuriers.get(nom);
		Aventurier aFutur = Aventurier.newInstance(a);
		aFutur.avance();

		// Out of Bound
		if(aFutur.getPositionX()<0
				|| aFutur.getPositionY()<0
				|| aFutur.getPositionX()>=this.carte.getLimitX()
				|| aFutur.getPositionY()>=this.carte.getLimitY()){
			return;
		}

		//Une plaine ou un trésor
		if(carte.getTerrain()[aFutur.getPositionX()][aFutur.getPositionY()] >= 0){
			int tresors = carte.ramasseTresor(aFutur.getPositionX(),aFutur.getPositionY());
			aFutur.ramasseTresor(tresors);
			aventuriers.put(nom, aFutur);
		}
	}

	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.carte).append("\n");
		for (String nom : aventuriers.keySet()) {
			sb.append(aventuriers.get(nom)).append("\n");
		}
		return sb.toString();
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


	public void debugPrint(){

	}
	
	
}
