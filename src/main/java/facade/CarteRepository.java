package facade;



import elements.Carte;

public interface CarteRepository {
	/**
	 * Initialise une carte � partir d'une ressource
	 * @param ressource
	 * @return
	 */
	public Carte get(Ressource ressource);
}
