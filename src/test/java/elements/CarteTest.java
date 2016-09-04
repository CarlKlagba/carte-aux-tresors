package elements;

import static org.junit.Assert.*;
import org.junit.Test;

import test.AbstractTest;

public class CarteTest extends AbstractTest {
	@Test
	public void Given3Tresors_WhenRamasseTresor_Then3(){
		
		Carte carte = new Carte(terrain2x2RamasseTresor());
		
		int actualNumberTresor = carte.ramasseTresor(1, 1);
		
		int plain = carte.getTerrain()[1][1];
		
		assertEquals( 3, actualNumberTresor );
		assertEquals(0, plain);
	}
	
	@Test
	public void Given0Tresors_WhenRamasseTresor_Then0(){
		Carte carte = new Carte(terrain3x3());

		int actualNumberTresor = carte.ramasseTresor(1, 1);
		
		assertEquals( 0, actualNumberTresor );
	}
}
