package main;
import adapter.file.FileAventurierRepository;
import adapter.file.FileCarteRepository;
import adapter.file.FileRessource;
import adapter.file.FileResultatService;
import elements.Partie;
import exception.InitialisationException;
import facade.AventurierRepository;
import facade.CarteRepository;
import facade.Ressource;
import facade.ResultatService;
import service.PartieService;

import java.util.Scanner;

public class CarteTresors {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le fichier decrivant la carte: ");
		String carteFileName = sc.nextLine();
		System.out.println("Saisir le fichier decrivant les aventuriers: ");
		String aventuriersFileName = sc.nextLine();
		sc.close();

		Ressource fileRessourceCarte = new FileRessource(carteFileName);
		Ressource fileRessourceAventuriers = new FileRessource(aventuriersFileName);

		AventurierRepository aventurierRepository = new FileAventurierRepository();
		CarteRepository carteRepository = new FileCarteRepository();
		ResultatService resultatService = new FileResultatService();

		PartieService partieService = new PartieService(carteRepository, aventurierRepository, resultatService);
		try {
			Partie partie = partieService.creerPartie(fileRessourceCarte, fileRessourceAventuriers);

			partie.run();

			partieService.resultatPartie(partie);

		} catch (InitialisationException e) {
			System.err.println("Erreur d'initialisation");
		}

	}

}
