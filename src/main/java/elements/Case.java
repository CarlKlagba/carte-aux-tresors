package elements;

public abstract class Case {
	
	private Position position;
	
	public Case(Position position){
		this.position = position;
	}

	public Position getPosition(){
		return position;
	}
}
