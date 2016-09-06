package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import controleur.InstanceJeux;
import initialiseur.Initialiseur;

public class CarteTresors {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le fichier decrivant la carte: ");
		String carteFileName = sc.nextLine();
		System.out.println("Saisir le fichier decrivant les aventuriers: ");
		String aventuriersFileName = sc.nextLine();
		sc.close();
				
		InstanceJeux instanceJeux = Initialiseur.initialise(carteFileName, aventuriersFileName);
		System.out.println("Etat initial : ");
		System.out.println(instanceJeux.toString());
		
		instanceJeux.run();
		System.out.println("Partie finie.");
		Date date = new Date();
		try {
			
			File file = new File("./carte-aux-tresors-"+date.getTime()+".txt");
			
			System.out.println("Ecriture du resultat dans le fichier "+file.getName()+"\n");
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(instanceJeux.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Etat final : ");
		System.out.println(instanceJeux.toString());
	}

}
