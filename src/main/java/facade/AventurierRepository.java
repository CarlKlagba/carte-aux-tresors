package facade;

import java.util.HashMap;

import elements.Aventurier;
import elements.Carte;
import exception.InitialisationException;

public interface AventurierRepository {
	
	/**
	 * Initialise une map d'aventuriers � partir d'une ressource
	 * @param ressource
	 * @return
	 */
	public HashMap<String, Aventurier> get(Ressource ressource, Carte carte)throws InitialisationException;
}
