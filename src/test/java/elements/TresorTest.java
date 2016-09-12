package elements;

import org.junit.Test;

public class TresorTest {
	
	@Test
	public void ramasseTest(){
		Tresor tresor = new Tresor(new Position(1, 2), 3);
		tresor.ramasse();
	}
}
