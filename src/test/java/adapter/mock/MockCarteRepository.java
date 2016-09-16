package adapter.mock;

import elements.*;
import exception.InitialisationException;
import facade.CarteRepository;
import facade.Ressource;
import util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Travail on 16/09/2016.
 */
public class MockCarteRepository implements CarteRepository{
    @Override
    public Carte get(Ressource ressource) throws InitialisationException {
        List<Case> list = new ArrayList<Case>();
        list.add(new Montagne(new Position(5,3)));
        list.add(new Tresor(new Position(4,2), 1));
        list.add(new Tresor(new Position(1,4), 3));


        HashMap<Position, Case> mapCase = Util.listCaseToMapCase(list);

        return new Carte(mapCase, new Position(6,5));
    }
}
