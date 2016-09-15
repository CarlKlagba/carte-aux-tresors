package elements;

import exception.OutOfLimitsException;
import exception.UnauthorizedActionException;

import java.util.HashMap;

/**
 * Created by Travail on 15/09/2016.
 */
public class Carte {
    private final Position limit;
    HashMap<Position, Case> mapCase;

    public Carte(HashMap<Position, Case> mapCase, Position limit){
        this.limit = limit;
        this.mapCase = mapCase;
    }

    public Case getCase(Position position) throws OutOfLimitsException {
        Position limitInf = new Position(1,1);
        if(position.isGreaterThan(limit)
                || position.isLesserThan(limitInf)){
            throw new OutOfLimitsException();
        }
        return mapCase.get(position);
    }
    
    public int ramasse(Position position) 
    		throws OutOfLimitsException, UnauthorizedActionException {
    	Case c = this.getCase(position);
    	if(c != null && c instanceof Tresor){
    		return ((Tresor)c).ramasse();
    	}
    	
    	throw new UnauthorizedActionException();
    }
}
