package elements;

import exception.OutOfLimitsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Travail on 15/09/2016.
 */
public class Carte {
    Position limit;
    HashMap<Position, Case> mapCase;

    public Carte(List<Case> listCase, Position limit){
        this.limit = limit;

        this.mapCase = listCase.stream().collect(
                Collectors.toMap(Case::getPosition, Function.identity()) );
    }

    public Case getCase(Position position) throws OutOfLimitsException {
        Position limitInf = new Position(1,1);
        if(position.isGreaterThan(limit)
                || position.isLesserThan(limitInf)){
            throw new OutOfLimitsException();
        }
        return mapCase.get(position);
    }
}
