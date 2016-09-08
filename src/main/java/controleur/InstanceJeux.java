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
   private  Map<String, Aventurier> aventuriers;

    /*
     * Le nombre de tours (UN tour = TOUT les aventuriers ont effectué UN
     *  mouvement) a un instant T de la partie
     *  */
    private int nbTours = 0;
    
    
	public InstanceJeux(Carte carte, List<Aventurier> aventuriers){
		this.carte = carte;
		this.aventuriers = new HashMap<String, Aventurier>();
		for (Aventurier a : aventuriers) {
			this.aventuriers.put(a.getNom(), a);
		}
	}

	public void run(){
        this.nbTours = 0;
        Boolean fin = false;
        while (!fin){
            fin = true;
            for (String nom: aventuriers.keySet()){
                try {
                    //Le mouvement de {nom} à effectuer au tour {nbTour}
                    String mouvement = this.aventuriers.get(nom).getMouvements().get(nbTours);
                    bouge(nom, mouvement);
                    fin = fin && false;
                }catch (IndexOutOfBoundsException e){ //il a fait tout ces mouvements
                    fin = fin && true; //si tout les aventuriers on fini, le jeux fini
                }
            }
            nbTours++;
        }
	}

	public void bouge(String nom, String mouvement){
        if(mouvement.equals("A")){
            avance(nom);
        }else if (mouvement.equals("D")){
            rotationDroite(nom);
        }else if (mouvement.equals("G")){
            rotationGauche(nom);
        }else if(mouvement.equals("R")){ //ramasse
            ramasse(nom);
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
			//Si c'est un trésor
            if(carte.getTerrain()[aFutur.getPositionX()][aFutur.getPositionY()] > 0) {
                //On rajoute l'action ramasser R au tour suivant
                aFutur.getMouvements().add(nbTours+1,"R");
            }
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
