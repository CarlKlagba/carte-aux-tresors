package adapter.mock;

import static elements.enumeration.Action.AVANCE;
import static elements.enumeration.Action.ATTENDRE;
import static elements.enumeration.Action.GAUCHE;
import static elements.enumeration.Action.DROITE;

import elements.Aventurier;
import elements.Carte;
import elements.Position;
import elements.enumeration.Action;
import elements.enumeration.Orientation;
import exception.InitialisationException;
import facade.AventurierRepository;
import facade.Ressource;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Travail on 16/09/2016.
 */
public class MockAventurierRepository implements AventurierRepository{
    @Override
    public HashMap<String, Aventurier> get(Ressource ressource, Carte carte) throws InitialisationException {
        List<Aventurier> aventuriers = new ArrayList<Aventurier>();

        List<Action>listAction1 =
                Arrays.asList(new Action[]{AVANCE, AVANCE, DROITE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
        Aventurier a1 = new Aventurier("John",new Position(1,1), Orientation.EST, listAction1 );

        List<Action> listAction2 =
                Arrays.asList(new Action[]{AVANCE, AVANCE, AVANCE, GAUCHE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
        Aventurier a2 = new Aventurier("James", new Position(4,3), Orientation.OUEST, listAction2 );

        aventuriers.add(a1);
        aventuriers.add(a2);

        return Util.listAventurierToMapAventurier(aventuriers);
    }
}
