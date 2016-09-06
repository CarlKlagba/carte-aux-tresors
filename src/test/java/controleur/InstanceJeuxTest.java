package controleur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import initialiseur.Initialiseur;
import org.junit.Test;

import elements.Aventurier;
import elements.Carte;
import elements.Orientation;
import test.AbstractTest;

import static org.junit.Assert.*;

public class InstanceJeuxTest extends AbstractTest{
	
	@Test
	public void GivenJohn11E_WhenAvanceIntoPlain_ThenJohn21E(){
		Aventurier aventurier = new Aventurier("John", 1, 1, Orientation.EST,null);
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
		Aventurier aventurier = new Aventurier("John", 1, 1, Orientation.EST,null);
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
		Aventurier aventurier = new Aventurier("John", 2, 2, Orientation.EST,null);
		Carte carte = new Carte(terrain3x3Montagne21());
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		InstanceJeux instanceJeux = new InstanceJeux(carte, aventuriers);		
		
		
		instanceJeux.avance("John");
		
		
		assertEquals(2, instanceJeux.getAventuriers().get("John").getPositionX());
		assertEquals(2, instanceJeux.getAventuriers().get("John").getPositionY());
		assertEquals(Orientation.EST, instanceJeux.getAventuriers().get("John").getOrientation());
	}

	@Test
	public void GivenJohn11E_WhenAvanceTresor_ThenJohn21E(){
		Aventurier aventurier = new Aventurier("John", 1, 1, Orientation.EST, null);
		Carte carte = new Carte(terrain3x3Tresor());
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);

		InstanceJeux instanceJeux = new InstanceJeux(carte, aventuriers);


		instanceJeux.avance("John");


		assertEquals(2, instanceJeux.getAventuriers().get("John").getPositionX());
		assertEquals(1, instanceJeux.getAventuriers().get("John").getPositionY());
		assertEquals(Orientation.EST, instanceJeux.getAventuriers().get("John").getOrientation());
	}


	@Test
	public void GivenJohn21E_AndTresor3_21_WhenRamasse_ThenJohnTresor3(){
		Aventurier aventurier = new Aventurier("John", 2, 1, Orientation.EST,null);
		Carte carte = new Carte(terrain3x3Tresor());
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);

		InstanceJeux instanceJeux = new InstanceJeux(carte, aventuriers);


		instanceJeux.ramasse("John");


		assertEquals(3, instanceJeux.getAventuriers().get("John").getNumTresor());
		assertEquals(0, carte.getTerrain()[2][1]);
	}

	@Test
	public void runTest(){
		InstanceJeux ij = Initialiseur.initialise("carteSimple.txt", "johnAndJames.txt");

		ij.run();

		Aventurier john = ij.getAventuriers().get("John");
		Aventurier james = ij.getAventuriers().get("James");

		assertEquals("Le trésor n'a pas été ramassé",0,ij.getCarte().getTerrain()[0][3]);

		assertEquals("Position en X de John n'est correcte",1, john.getPositionX());
		assertEquals("Position en Y de John n'est correcte",2, john.getPositionY());
		assertEquals("Le nombre de trésor de John n'est correcte",0, john.getNumTresor());

		assertEquals("Position en X de James n'est correcte", 0, james.getPositionX());
		assertEquals("Position en Y de James n'est correcte", 4, james.getPositionY());
		assertEquals("Le nombre de trésor de James n'est correcte", 3, james.getNumTresor());
	}
}
