package adapter.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import elements.Aventurier;
import elements.Carte;
import elements.Case;
import elements.Montagne;
import elements.Position;
import elements.enumeration.Action;
import elements.enumeration.Orientation;
import exception.InitialisationException;
import exception.OutOfLimitsException;
import facade.AventurierRepository;
import facade.Ressource;
import util.Util;

public class FileAventurierRepository extends FileRepository implements AventurierRepository {

	@Override
	public HashMap<String, Aventurier> get(Ressource ressource, Carte carte) throws InitialisationException {
		if (ressource instanceof FileRessource) {
			String aventuriersFileName = ((FileRessource) ressource).getFileName();
			
			List<Aventurier> aventuriers = new ArrayList<>();
	        Stream<String> stream = filePathToStream(aventuriersFileName);
	        List<String> aLigne = stream
	                .filter(line -> !line.startsWith("#")) //commentaire
	                .collect(Collectors.toList());
	        stream.close();
	        for (String ligne: aLigne ) {
	            aventuriers.add(initialiseAventurier(ligne, carte));
	        }
			return Util.listAventurierToMapAventurier(aventuriers);
		}
		throw new InitialisationException();
	}
	
	
	private Aventurier initialiseAventurier(String line, Carte carte) throws InitialisationException {
        String[] splitLine = line.split(" ");

        String name = splitLine[0];
        String[] splitCoord = splitLine[1].split("-");
        int x = Integer.parseInt(splitCoord[0]);
        int y = Integer.parseInt(splitCoord[1]);
        
        Position position = new Position(x, y);
        
        // l'aventurier ne peux pas commencer sur une montagne
        try {
			Case xCase = carte.getCase(position);
			if(xCase != null && xCase instanceof Montagne){
				throw new InitialisationException();
			}
		} catch (OutOfLimitsException e) {
			throw new InitialisationException();
		}

        Orientation orientation;
        String o = splitLine[2];
        if(o.equals("E")){
            orientation = Orientation.EST;
        }else if(o.equals("N")){
            orientation = Orientation.NORD;
        }else if(o.equals("S")){
            orientation = Orientation.SUD;
        }else if(o.equals("O")){
            orientation = Orientation.OUEST;
        }else{
            throw new InitialisationException();
        }

        List<String> stringAction = new ArrayList(Arrays.asList(splitLine[3].split("")));
        List<Action> actions = initialiseActions(stringAction);
        return new Aventurier(name, position, orientation, actions);
    }
	
	private List<Action> initialiseActions(List<String> stringAction){
		List<Action> actions = (List<Action>) stringAction.stream()
				.map(Util::stringToAction);
		return actions;
	}
	
}
