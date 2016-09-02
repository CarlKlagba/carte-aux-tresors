package controleur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.Aventurier;
import elements.Carte;
import elements.Orientation;
import test.AbstractTest;

import static org.junit.Assert.*;

public class InstanceJeuxTest extends AbstractTest{
	
	@Test
	public void GivenJohn11E_WhenAvanceIntoPlain_ThenJohn21E(){
		Aventurier aventurier = new Aventurier("John", 1, 1, Orientation.EST);
		Carte carte = new Carte(terrain3x3());
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		InstanceJeux instanceJeux = new InstanceJeux(carte, aventuriers);		
		
		
		instanceJeux.avance("John");
		
		
		assertEquals(2, instanceJeux.getAventuriers().get("John").getPositionX());
		assertEquals(1, instanceJeux.getAventuriers().get("John").getPositionY());
		assertEquals(Orientation.EST, instanceJeux.getAventuriers().get("John").getOrientation());
	}
	
	@Test
	public void GivenJohn11E_WhenAvanceIntoMontagne_ThenJohn11E(){
		Aventurier aventurier = new Aventurier("John", 1, 1, Orientation.EST);
		Carte carte = new Carte(terrain3x3Montagne21());
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		InstanceJeux instanceJeux = new InstanceJeux(carte, aventuriers);		
		
		
		instanceJeux.avance("John");
		
		
		assertEquals(1, instanceJeux.getAventuriers().get("John").getPositionX());
		assertEquals(1, instanceJeux.getAventuriers().get("John").getPositionY());
		assertEquals(Orientation.EST, instanceJeux.getAventuriers().get("John").getOrientation());
	}
	
	@Test
	public void GivenJohn22E_WhenAvanceOutofBound_ThenJohn22E(){
		Aventurier aventurier = new Aventurier("John", 2, 2, Orientation.EST);
		Carte carte = new Carte(terrain3x3Montagne21());
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		InstanceJeux instanceJeux = new InstanceJeux(carte, aventuriers);		
		
		
		instanceJeux.avance("John");
		
		
		assertEquals(2, instanceJeux.getAventuriers().get("John").getPositionX());
		assertEquals(2, instanceJeux.getAventuriers().get("John").getPositionY());
		assertEquals(Orientation.EST, instanceJeux.getAventuriers().get("John").getOrientation());
	}
	
}
