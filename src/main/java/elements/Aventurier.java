package elements;

import java.util.List;

/**
 * Created by Travail on 29/08/2016.
 */
public class Aventurier implements Cloneable{
    String nom;
    int positionX;
    int positionY;
	int numTresor;
    Orientation orientation;
	List<String> mouvements;



	public Aventurier(String nom, int positionX, int positionY, Orientation orientation,  List<String> mouvements) {
        this.nom = nom;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
		this.numTresor = 0;
		this.mouvements = mouvements;
	}

	public static Aventurier newInstance(Aventurier aventurier){
		Aventurier a = 	new Aventurier(aventurier.getNom(), aventurier.getPositionX(),
			aventurier.getPositionY(),aventurier.getOrientation(), aventurier.getMouvements());
		a.setNumTresor(aventurier.getNumTresor());

		return a;
	}

	public void ramasseTresor(int numTresor){
		this.numTresor += numTresor;
	}

    public void avance(){
    	switch (orientation){
			case OUEST:
				positionX--;
				break;
			case EST:
				positionX++;
				break;
			case NORD:
				positionY--;
				break;
			case SUD:
				positionY++;
				break;
			default:
    	}
    }
    
    public void rotationGauche(){
    	//tester avec un modulo
    	switch (orientation){
    		case OUEST:
    			orientation=Orientation.SUD;
    			break;
    		case EST:
    			orientation=Orientation.NORD;
    			break;
    		case NORD:
    			orientation=Orientation.OUEST;
    			break;
    		case SUD:
    			orientation=Orientation.EST;
    			break;
    		default:
    	}
    }
    
    public void rotationDroite(){
    	switch (orientation){
    		case OUEST:
    			orientation=Orientation.NORD;
    			break;
    		case EST:
    			orientation=Orientation.SUD;
    			break;
    		case NORD:
    			orientation=Orientation.EST;
    			break;
    		case SUD:
    			orientation=Orientation.OUEST;
    			break;
    		default:  	
    	}
    }
    
    
    
    @Override
    public String toString(){
    	return this.nom + " " + (this.positionX+1) + "-" + (this.positionY+1) + " " 
    			+ this.orientation.name() + " Tresors: "+numTresor;
    }
    
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getNumTresor() { return numTresor;}

	public void setNumTresor(int numTresor) { this.numTresor = numTresor; }

    public List<String> getMouvements() { return mouvements; }

    public void setMouvements(List<String> mouvements) { this.mouvements = mouvements; }
}