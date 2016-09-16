package adapter.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import elements.Carte;
import elements.Case;
import elements.Montagne;
import elements.Position;
import elements.Tresor;
import exception.InitialisationException;
import facade.CarteRepository;
import facade.Ressource;

public class FileCarteRepository extends FileRepository implements CarteRepository{
	
	@Override
	public Carte get(Ressource ressource) throws InitialisationException {
		
		if (ressource instanceof FileRessource) {
			FileRessource fileRessource = (FileRessource) ressource;
			String carteFileName = fileRessource.getFileName();
			Stream<String> stream = filePathToStream(carteFileName);
			
			List<String> carteLigne = stream
	                .filter(line -> line.startsWith("C"))
	                .collect(Collectors.toList());
			
			if(carteLigne==null || carteLigne.isEmpty()) {
	            throw new InitialisationException();
	        }
			
			String line = carteLigne.get(0);
	        Position limit =initialiseLimite(line);
	        
	        List<String> lines = stream
	                .collect(Collectors.toList());
	        stream.close();
	        
	        HashMap<Position, Case> mapCase = initialiseMapCase(lines);
	        
			return new Carte(mapCase, limit);
		}
		throw new InitialisationException();
	}
	
	private  Position initialiseLimite(String line){
        String[] splitLine =line.split(" ");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
 
        return new Position(x, y);
    }
	
	private  HashMap<Position, Case> initialiseMapCase(List<String> lines){
		HashMap<Position, Case> mapCase = new HashMap<Position, Case>();
		
		for (String line: lines){
            if(line.startsWith("T")){
                initialiseTresor(line, mapCase);
            }else if(line.startsWith("M")){
            	initialiseMontagne(line, mapCase);
            }
        }
 
        return mapCase;
    }
	
	private void initialiseTresor(String line, HashMap<Position, Case> mapCase){
		String[] splitLine =line.split(" ");
        String[] splitCoord = splitLine[1].split("-");
        int x = Integer.parseInt(splitCoord[0]);
        int y = Integer.parseInt(splitCoord[1]);
        int numTresor =Integer.parseInt(splitLine[2]);
        
        Position position = new Position(x, y);
        Tresor tresor = new Tresor(position, numTresor);
        
        mapCase.put(position, tresor);
	}
	
	private void initialiseMontagne(String line, HashMap<Position, Case> mapCase){
		String[] splitLine =line.split(" ");
        String[] splitCoord = splitLine[1].split("-");
        int x = Integer.parseInt(splitCoord[0]);
        int y = Integer.parseInt(splitCoord[1]);
        
        Position position = new Position(x, y);
        Montagne montagne = new Montagne(position);
        
        mapCase.put(position, montagne);
	} 
	
}
