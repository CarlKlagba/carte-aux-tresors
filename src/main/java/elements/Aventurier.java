package elements;

import java.util.List;

import elements.enumeration.Action;
import elements.enumeration.Orientation;

public class Aventurier {
	private final String nom;
	private Position position;
	private Orientation orientation;
	private List<Action> listAction;
	
	private int nbTresor=0;
	
	public Aventurier(String nom, Position position, Orientation orientation, List<Action> listAction) {
		super();
		this.nom=nom;
		this.position = position;
		this.orientation = orientation;
		this.listAction = listAction;
	}

	public void perform(Action action){
		action.perform(this);
	}
	
	public void perform(int indexAction){
		perform(listAction.get(indexAction));
	}
	
	public void ramasse(int tresor){
		nbTresor += tresor;
	}
	
	
	
	public List<Action> getListAction() {
		return listAction;
	}

	public void setListAction(List<Action> listAction) {
		this.listAction = listAction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}


	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public String getNom() {
		return nom;
	}

	public int getNbTresor() {
		return nbTresor;
	}
	
	
	
}
