package elements;



import org.junit.Test;

import elements.Aventurier;
import elements.Orientation;
import test.AbstractTest;

import static org.junit.Assert.*;

public class AventurierTest extends AbstractTest{
	
	@Test
	public void GivenNord_WhenDroite_ThenEst(){
		
		Aventurier aventurier = new Aventurier("John",1,1, Orientation.NORD);
		aventurier.rotationDroite();
		assertEquals(Orientation.EST,aventurier.getOrientation() );
	}
	
	//... TODO
	
	@Test
	public void GivenNord_WhenGauche_ThenOuest(){
		Aventurier aventurier = new Aventurier("John",1,1, Orientation.NORD);
		aventurier.rotationGauche();
		assertEquals(Orientation.OUEST, aventurier.getOrientation() );
	}
	//... TODO
	
	@Test
	public void Given11AndEst_WhenAvance_Then21(){
		int expectedPosX = 2;
		int expectedPosY = 1;
		
		Aventurier aventurier = new Aventurier("John",1,1, Orientation.EST);
		aventurier.avance();
		assertEquals(expectedPosX, aventurier.getPositionX());
		assertEquals(expectedPosY, aventurier.getPositionY());		
	}
	
	@Test
	public void Given11AndSud_WhenAvance_Then12(){
		int expectedPosX = 1;
		int expectedPosY = 2;
		
		Aventurier aventurier = new Aventurier("John",1,1, Orientation.SUD);
		aventurier.avance();
		assertEquals(expectedPosX, aventurier.getPositionX());
		assertEquals(expectedPosY, aventurier.getPositionY());		
	}
	
	
	@Test
	public void Given21AndOuest_WhenAvance_Then11(){
		int expectedPosX = 1;
		int expectedPosY = 1;
		
		Aventurier aventurier = new Aventurier("John",2,1, Orientation.OUEST);
		aventurier.avance();
		assertEquals(expectedPosX, aventurier.getPositionX());
		assertEquals(expectedPosY, aventurier.getPositionY());		
	}
	
	@Test
	public void Given12AndNord_WhenAvance_Then11(){
		int expectedPosX = 1;
		int expectedPosY = 1;
		
		Aventurier aventurier = new Aventurier("John",1,2, Orientation.NORD);
		aventurier.avance();
		assertEquals(expectedPosX, aventurier.getPositionX());
		assertEquals(expectedPosY, aventurier.getPositionY());		
	}
	
	
	
}
