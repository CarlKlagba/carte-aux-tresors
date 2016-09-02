package elements;

import static org.junit.Assert.*;
import org.junit.Test;

import test.AbstractTest;

public class CarteTest extends AbstractTest {

	
	@Test
	public void Initialisation_Cart(){
		
	}
	
	@Test
	public void Given3Tresors_WhenRamasseTresor1_Then2(){
		
		Carte carte = new Carte(terrain2x2RamasseTresor());
		
		carte.ramasseTresor(1, 1);
		
		int actualNumberTresor = carte.getTerrain()[1][1];
		
		assertEquals( 2, actualNumberTresor );
	}
	
	@Test
	public void Given3Tresors_WhenRamasseTresor4_Then0(){
		Carte carte = new Carte(terrain2x2RamasseTresor());
		
		carte.ramasseTresor(1, 1);
		carte.ramasseTresor(1, 1);
		carte.ramasseTresor(1, 1);
		carte.ramasseTresor(1, 1);
		
		int actualNumberTresor = carte.getTerrain()[1][1];
		
		assertEquals( 0, actualNumberTresor );
	}
	

}
