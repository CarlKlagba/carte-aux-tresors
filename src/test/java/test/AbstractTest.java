package test;

import elements.Case;
import elements.Montagne;
import elements.Position;
import elements.Tresor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTest {
    protected List<Case> listTresorsMontages(){
        List<Case> result = new ArrayList<Case>();
        result.add(new Montagne(new Position(5,3)));
        result.add(new Tresor(new Position(4,2),1));
        result.add(new Tresor(new Position(1,4),3));

        return result;
    }
}
