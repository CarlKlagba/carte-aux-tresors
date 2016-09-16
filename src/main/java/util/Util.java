package util;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import elements.Aventurier;
import elements.Case;
import elements.Position;
import elements.enumeration.Action;

public class Util {
	public static HashMap<Position, Case> listCaseToMapCase(List<Case> list) {
		return (HashMap<Position, Case>) list
			.stream()
			.collect(Collectors.toMap(Case::getPosition, Function.identity()));
	}
	
	public static HashMap<String, Aventurier> listAventurierToMapAventurier(List<Aventurier> list) {
		return (HashMap<String, Aventurier>) list
			.stream()
			.collect(Collectors.toMap(Aventurier::getNom, Function.identity()));
	}
	
	public static Action stringToAction(String stringAction){
		switch(stringAction){
		case "A":
			return Action.AVANCE;
		case "D":
			return Action.DROITE;
		case "G":
			return Action.GAUCHE;
		default:
			return Action.ATTENDRE;
		}
	}
}
