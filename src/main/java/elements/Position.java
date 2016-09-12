package elements;

public class Position {
	private final int x;
	private final int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

//	@Override
//	public boolean equals(Object object){
//		boolean result = false;
//		if(object == null || object.getClass() != getClass()){
//			result = false;
//		}else{
//			Position p = (Position) object;
//			if(this.x == p.getX()
//				&& this.y == p.getY()) {
//				result = true;
//			}
//		}
//		return result;
//	}
	

	
	
	
	
	public int getX() {
		return x;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getY() {
		return y;
	}

	
}
