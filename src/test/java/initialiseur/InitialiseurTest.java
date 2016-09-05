package initialiseur;

import elements.Aventurier;
import elements.Orientation;
import exception.InitialisationException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import elements.Carte;
import test.AbstractTest;

/**
 * Created by Travail on 04/09/2016.
 */
public class InitialiseurTest extends AbstractTest{
/*
    @Test(expected = IOException.class)
    public void initialiseCarteTest_IOExeception() throws IOException, URISyntaxException, InitialisationException {
        Initialiseur.initialiseCarte("absenteFile.notHere");
    }
*/
    @Test
    public void initialiseCarteTest_carteSimple() throws IOException, URISyntaxException, InitialisationException {
        Carte carte = Initialiseur.initialiseCarte("carteSimple.txt");

        //Limites
        assertEquals("la taille du terrain en X n'est pas correcte",
                    6, carte.getTerrain().length);
        assertEquals("la taille du terrain en Y n'est pas correcte",
                    5, carte.getTerrain()[0].length);
        //Trésors
        assertEquals("Le trésor n'a pas été initialisé correctement",
                    1, carte.getTerrain()[3][1]);
        assertEquals("Le trésor n'a pas été initialisé correctement",
                    3, carte.getTerrain()[0][3]);
        //Montagnes
            assertEquals("La montagne n'a pas été initialisée correctement",
                    -1, carte.getTerrain()[4][2]);
    }

    @Test
    public void initialiseAventuriersTest_1Aventurier() throws IOException, URISyntaxException, InitialisationException {
        List<Aventurier> aventuriers = Initialiseur.initialiseAventuriers("john.txt",new Carte(terrain3x3()));
        Aventurier john = aventuriers.get(0);


        assertEquals("Le nom n'a pas été initialisé correctement",
                "John", john.getNom());

        assertEquals("La position en X n'a pas été initialisée correctement",
                0, john.getPositionX());

        assertEquals("La position en Y n'a pas été initialisée correctement",
                0, john.getPositionY());

        assertEquals("L'orientation n'a pas été initialisée correctement",
                Orientation.EST, john.getOrientation());

        assertEquals("La liste des mouvement n'a pas été initialisée correctement",
                "AADADAGA", john.getMouvements());
    }

    @Test
    public void initialiseAventuriersTest_2Aventuriers() throws IOException, URISyntaxException, InitialisationException {
        List<Aventurier> aventuriers = Initialiseur.initialiseAventuriers("johnAndJames.txt",new Carte(terrain(5,5)));
        Aventurier john = aventuriers.get(0);
        Aventurier james = aventuriers.get(1);

        assertEquals("Le nom n'a pas été initialisé correctement",
                "John", john.getNom());
        assertEquals("La position en X n'a pas été initialisée correctement",
                0, john.getPositionX());
        assertEquals("La position en Y n'a pas été initialisée correctement",
                0, john.getPositionY());
        assertEquals("L'orientation n'a pas été initialisée correctement",
                Orientation.EST, john.getOrientation());
        assertEquals("La liste des mouvement n'a pas été initialisée correctement",
                "AADADAGA", john.getMouvements());

        assertEquals("Le nom n'a pas été initialisé correctement",
                "James", james.getNom());
        assertEquals("La position en X n'a pas été initialisée correctement",
                3, james.getPositionX());
        assertEquals("La position en Y n'a pas été initialisée correctement",
                2, james.getPositionY());
        assertEquals("L'orientation n'a pas été initialisée correctement",
                Orientation.OUEST, james.getOrientation());
        assertEquals("La liste des mouvement n'a pas été initialisée correctement",
                "AAAGADAGA", james.getMouvements());
    }
}
