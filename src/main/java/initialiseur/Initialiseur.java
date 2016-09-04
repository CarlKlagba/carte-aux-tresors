package initialiseur;

import controleur.InstanceJeux;
import elements.Aventurier;
import elements.Carte;
import elements.Orientation;
import exception.InitialisationException;

import sun.invoke.empty.Empty;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Travail on 04/09/2016.
 */
public class Initialiseur {

    public static InstanceJeux initialise(String carteFileName, String aventuriersFileName){
        InstanceJeux instanceJeux = null;

        try {
            Carte carte = initialiseCarte(carteFileName);
            List<Aventurier> aventuriers = initialiseAventuriers(aventuriersFileName, carte);
            instanceJeux = new InstanceJeux(carte,aventuriers);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InitialisationException e) {
            e.printStackTrace();
        }


        return instanceJeux;
    }

    public static Carte initialiseCarte(String carteFileName)
            throws IOException, URISyntaxException, InitialisationException {
       // ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //File file = new File(classLoader.getResource(carteFileName).getFile());
        int[][] terrain;
        Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(carteFileName).toURI()));

        List<String> carteLigne = stream
                .filter(line -> line.startsWith("C"))
                .collect(Collectors.toList());

        if(carteLigne==null || carteLigne.isEmpty()) {
            throw new InitialisationException();// TODO creer une vraie exception
        }

        terrain = initialiseTerrain(carteLigne.get(0));

        stream = Files.lines(Paths.get(ClassLoader.getSystemResource(carteFileName).toURI()));
        List<String> lines = stream
                .collect(Collectors.toList());

        for (String line: lines){
            if(line.startsWith("T")){
                terrain = initialiseTresor(terrain, line);
            }else if(line.startsWith("M")){
                terrain = initialiseMontagne(terrain, line);
            }
        }

        return new Carte(terrain);
    }

    public static List<Aventurier> initialiseAventuriers(String aventuriersFileName, Carte carte)
            throws URISyntaxException, IOException, InitialisationException {
        List<Aventurier> aventuriers = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(aventuriersFileName).toURI()));
        List<String> aLigne = stream
                .filter(line -> !line.startsWith("#")) //commentaire
                .collect(Collectors.toList());

        for (String ligne: aLigne ) {
            aventuriers.add(initialiseAventurier(ligne, carte));
        }
        return aventuriers;
    }

    private static int[][] initialiseTerrain(String line){
        String[] splitLine =line.split(" ");
        int x = Integer.parseInt(splitLine[1]) - 1;
        int y = Integer.parseInt(splitLine[2]) - 1;

        int [][] terrain = new int[x][y];
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                terrain[i][j] = 0;
            }
        }
        return terrain;
    }

    private static int[][] initialiseTresor(int[][] terrain, String line){
        String[] splitLine =line.split(" ");
        String[] splitCoord = splitLine[1].split("-");
        int x = Integer.parseInt(splitCoord[0]) - 1;
        int y = Integer.parseInt(splitCoord[1]) - 1;
        int numTresor =Integer.parseInt(splitLine[2]);

        terrain[x][y] = numTresor;

        return terrain;
    }

    private static int[][] initialiseMontagne(int[][] terrain, String line){
        String[] splitLine =line.split(" ");
        String[] splitCoord = splitLine[1].split("-");
        int x = Integer.parseInt(splitCoord[0]) - 1;
        int y = Integer.parseInt(splitCoord[1]) - 1;

        terrain[x][y] = -1;

        return terrain;
    }

    private static Aventurier initialiseAventurier(String line, Carte carte) throws InitialisationException {
        String[] splitLine = line.split(" ");

        String name = splitLine[0];
        String[] splitCoord = splitLine[1].split("-");
        int x = Integer.parseInt(splitCoord[0]) - 1;
        int y = Integer.parseInt(splitCoord[1]) - 1;

        // l'aventurier ne peux pas commencer sur une montagne
        if(carte.getTerrain()[x][y] < 0){
            throw new InitialisationException();//
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
            throw new InitialisationException();//
        }

        String mouvement = splitLine[3];
        return new Aventurier(name, x, y, orientation, mouvement);
    }
}
