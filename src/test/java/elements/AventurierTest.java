package elements;

import org.junit.Before;
import org.junit.Test;

import elements.enumeration.Action;
import elements.enumeration.Orientation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import test.AbstractTest;

public class AventurierTest extends AbstractTest{
	private Aventurier a;
	@Before
    public void setUp(){
		List<Action> listAction = new ArrayList<>();
		a = new Aventurier("John", new Position(1,1), Orientation.EST, listAction );
    }
	@Test
	public void rotationGaucheTest(){
		a.perform(Action.GAUCHE);
		assertEquals(Orientation.NORD, a.getOrientation());
		a.perform(Action.GAUCHE);
		assertEquals(Orientation.OUEST, a.getOrientation());
		a.perform(Action.GAUCHE);
		assertEquals(Orientation.SUD, a.getOrientation());
		a.perform(Action.GAUCHE);
		assertEquals(Orientation.EST, a.getOrientation());
	}
	
	@Test
	public void rotationDroiteTest(){
		a.perform(Action.DROITE);
		assertEquals(Orientation.SUD, a.getOrientation());
		a.perform(Action.DROITE);
		assertEquals(Orientation.OUEST, a.getOrientation());
		a.perform(Action.DROITE);
		assertEquals(Orientation.NORD, a.getOrientation());
		a.perform(Action.DROITE);
		assertEquals(Orientation.EST, a.getOrientation());
	}
	
	@Test
	public void avanceESTTest(){
		Aventurier aventurier = new Aventurier("John",new Position(1,1), Orientation.EST, null);
		aventurier.perform(Action.AVANCE);
		assertEquals(new Position(2, 1), aventurier.getPosition());
	}
	
	@Test
	public void avanceOUESTTest(){
		Aventurier aventurier = new Aventurier("John",new Position(1,1), Orientation.OUEST, null);
		aventurier.perform(Action.AVANCE);
		assertEquals(new Position(0, 1), aventurier.getPosition());
	}
	
	@Test
	public void avanceNORDTest(){
		Aventurier aventurier = new Aventurier("John",new Position(1,1), Orientation.NORD, null);
		aventurier.perform(Action.AVANCE);
		assertEquals(new Position(1, 0), aventurier.getPosition());
	}
	
	@Test
	public void avanceSUDTest(){
		Aventurier aventurier = new Aventurier("John",new Position(1,1), Orientation.SUD, null);
		aventurier.perform(Action.AVANCE);
		assertEquals(new Position(1, 2), aventurier.getPosition());
	}
	
}
