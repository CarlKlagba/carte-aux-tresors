package elements;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import elements.Aventurier;
import elements.Orientation;

@RunWith(Parameterized.class)
public class AventurierRotationTest {
	
	@Parameterized.Parameters
    public static Collection<Object[]> rotationDoite() {
        return Arrays.asList(new Object[][] {
                 { Orientation.NORD, Orientation.EST }, { Orientation.EST, Orientation.SUD },
                 { Orientation.SUD, Orientation.OUEST }, { Orientation.OUEST, Orientation.NORD } 
           });
    }
	
//	@Test
//	 @Parameters( name = "provideFourOfAKind")
	public void GivenNord_WhenDroite_ThenEst(){
		Aventurier aventurier = new Aventurier("John",1,1, Orientation.NORD);
	}
	
}
