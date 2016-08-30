package elements;

/**
 * Created by Travail on 29/08/2016.
 */
public class Aventurier {
    String nom;
    int positionX;
    int positionY;
    Orientation orientation;

    public Aventurier(String nom, int positionX, int positionY, Orientation orientation) {
        this.nom =nom;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
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
    
    
}