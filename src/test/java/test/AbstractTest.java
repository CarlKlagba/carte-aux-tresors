package test;

import static elements.enumeration.Action.AVANCE;
import static elements.enumeration.Action.ATTENDRE;
import static elements.enumeration.Action.GAUCHE;
import static elements.enumeration.Action.DROITE;

import elements.Aventurier;
import elements.Carte;
import elements.Case;
import elements.Montagne;
import elements.Position;
import elements.Tresor;
import elements.enumeration.Action;
import elements.enumeration.Orientation;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractTest {
    protected HashMap<Position, Case> mapTresorsMontages(){
        List<Case> list = new ArrayList<Case>();
        list.add(new Montagne(new Position(5,3)));
        list.add(new Tresor(new Position(4,2),1));
        list.add(new Tresor(new Position(1,4),3));
        
        
        HashMap<Position, Case> mapCase = Util.listCaseToMapCase(list);
        return mapCase;
    }
    
    protected Carte getCarteSimple(){
    	return new Carte(mapTresorsMontages(), new Position(6,5));
    }
    
    protected HashMap<String, Aventurier> getListAventurier(){
    	List<Aventurier> aventuriers = new ArrayList<Aventurier>();
    	
    	List<Action>listAction1 = 
    			Arrays.asList(new Action[]{AVANCE, AVANCE, DROITE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
    	Aventurier a1 = new Aventurier("John",new Position(1,1), Orientation.EST, listAction1 );
    	
    	List<Action>listAction2 = 
    			Arrays.asList(new Action[]{AVANCE, AVANCE, AVANCE, GAUCHE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
    	Aventurier a2 = new Aventurier("James", new Position(4,3), Orientation.OUEST, listAction2 );
    	
    	aventuriers.add(a1);
    	aventuriers.add(a2);
    	
    	return Util.listAventurierToMapAventurier(aventuriers);
    }
}
