package facade;



import elements.Carte;
import exception.InitialisationException;

public interface CarteRepository {
	/**
	 * Initialise une carte à partir d'une ressource
	 * @param ressource
	 * @return
	 */
	public Carte get(Ressource ressource) throws InitialisationException;
}
