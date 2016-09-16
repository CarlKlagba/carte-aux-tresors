package service;

import static org.junit.Assert.*;

import adapter.mock.MockAventurierRepository;
import adapter.mock.MockCarteRepository;
import adapter.mock.MockRessource;
import adapter.mock.MockResultatService;
import elements.Montagne;
import elements.Partie;
import elements.Position;
import elements.Tresor;
import exception.InitialisationException;
import exception.OutOfLimitsException;
import facade.AventurierRepository;
import facade.CarteRepository;
import facade.Ressource;
import facade.ResultatService;
import org.junit.Test;
import test.AbstractTest;

/**
 * Created by Travail on 16/09/2016.
 */
public class PartieServiceTest extends AbstractTest {

    @Test
    public void createPartieTest() throws InitialisationException, OutOfLimitsException {

        Ressource ressourceCarte = new MockRessource();
        Ressource ressourceAventuriers = new MockRessource();

        AventurierRepository aventurierRepository = new MockAventurierRepository();
        CarteRepository carteRepository = new MockCarteRepository();
        ResultatService resultatService = new MockResultatService();

        PartieService partieService = new PartieService(carteRepository,aventurierRepository, resultatService);

        Partie partie = partieService.creerPartie(ressourceCarte, ressourceAventuriers);

        assertNotNull(partie.getAventuriers().get("John"));
        assertNotNull(partie.getAventuriers().get("James"));

        assertTrue(partie.getCarte().getCase(new Position(5,3)) instanceof Montagne);
        assertTrue(partie.getCarte().getCase(new Position(4,2)) instanceof Tresor);
        assertTrue(partie.getCarte().getCase(new Position(1,4)) instanceof Tresor);
    }

}
