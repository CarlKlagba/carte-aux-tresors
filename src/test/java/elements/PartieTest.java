package elements;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import elements.enumeration.Action;
import elements.enumeration.Orientation;
import exception.OutOfLimitsException;
import test.AbstractTest;
import util.Util;

public class PartieTest extends AbstractTest {
	Partie partie;
	
//	@Before
//	public void setUp(){
//		HashMap<String, Aventurier> listAventurier = getListAventurier();
//		Carte carte = getCarteSimple();
//		partie = new Partie(listAventurier,carte);
//	}
	
	@Test
	public void GivenJohn11E_WhenAvanceIntoPlain_ThenJohn21E(){
		Aventurier aventurier = new Aventurier("John", new Position(1, 1), Orientation.EST,null);
		Carte carte = getCarteSimple();
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		Partie partie = new Partie(Util.listAventurierToMapAventurier(aventuriers), carte );		
		
		
		partie.perform(Action.AVANCE, "John");
		
		assertEquals(new Position(2, 1), partie.getAventuriers().get("John").getPosition());
		assertEquals(Orientation.EST, partie.getAventuriers().get("John").getOrientation());
	}
	
	@Test
	public void GivenJohn43E_WhenAvanceIntoMontagne_ThenJohn43E(){
		Aventurier aventurier = new Aventurier("John", new Position(4, 3), Orientation.EST,null);
		Carte carte = getCarteSimple();
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		Partie partie = new Partie(Util.listAventurierToMapAventurier(aventuriers), carte );		
		
		
		partie.perform(Action.AVANCE, "John");
		
		
		assertEquals(new Position(4, 3), partie.getAventuriers().get("John").getPosition());
		assertEquals(Orientation.EST, partie.getAventuriers().get("John").getOrientation());
	}
	
	@Test
	public void GivenJohn63E_WhenAvanceOutofBound_ThenJohn63E(){
		Aventurier aventurier = new Aventurier("John", new Position(6, 3), Orientation.EST,null);
		Carte carte = getCarteSimple();
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		Partie partie = new Partie(Util.listAventurierToMapAventurier(aventuriers), carte );		
		
		
		partie.perform(Action.AVANCE, "John");
		
		
		assertEquals(new Position(6, 3), partie.getAventuriers().get("John").getPosition());
		assertEquals(Orientation.EST, partie.getAventuriers().get("John").getOrientation());
	}
	
	@Test
	public void GivenJohn32E_WhenAvanceTresor_ThenJohn42E(){
		Aventurier aventurier = new Aventurier("John", new Position(1, 3), Orientation.SUD,null);
		Carte carte = getCarteSimple();
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		Partie partie = new Partie(Util.listAventurierToMapAventurier(aventuriers), carte );		
		
		
		partie.perform(Action.AVANCE, "John");
		
		
		assertEquals(new Position(1, 4), partie.getAventuriers().get("John").getPosition());
		assertEquals(Orientation.SUD, partie.getAventuriers().get("John").getOrientation());
	}
	
	@Test
	public void runTest() throws OutOfLimitsException{
		Aventurier aventurier = getAventurier();
		Carte carte = getCarteSimple();
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		Partie partie = new Partie(Util.listAventurierToMapAventurier(aventuriers), carte);
		
		partie.run();
		
		Tresor tresor = ((Tresor) partie.getCarte().getCase(new Position(4, 2)));
		Aventurier john = partie.getAventuriers().get("John");
	
		assertEquals("Position de John n'est correcte", new Position(2, 3), john.getPosition());
		assertEquals("Le trésor n'a pas été ramassé", 0, tresor.getNbTresor());
		assertEquals("Le nombre de trésor de John n'est correcte", 0, john.getNbTresor());
	}
}
