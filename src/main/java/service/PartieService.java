package service;

import java.util.HashMap;

import elements.Aventurier;
import elements.Carte;
import elements.Partie;
import facade.AventurierRepository;
import facade.CarteRepository;
import facade.Ressource;
import facade.ResultatService;

public class PartieService {
	CarteRepository carteRepository;
	AventurierRepository aventurierRepository;
	ResultatService resultatService;
	
	public PartieService(CarteRepository carteRepository, AventurierRepository aventurierRepository,
			ResultatService resultatService) {
		this.carteRepository = carteRepository;
		this.aventurierRepository = aventurierRepository;
		this.resultatService = resultatService;
	}
	
	public Partie creerPartie(Ressource ressourceCarte, Ressource ressourceAventurier){
		Carte carte = carteRepository.get(ressourceCarte);
		HashMap<String, Aventurier> aventuriers = aventurierRepository.get(ressourceAventurier);
		
		return new Partie(aventuriers, carte);
	}
	
	public void resultatPartie(Partie partie){
		resultatService.saveResultat(partie);
	}
}
