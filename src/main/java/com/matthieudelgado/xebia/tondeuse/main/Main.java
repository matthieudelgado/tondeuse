package com.matthieudelgado.xebia.tondeuse.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.matthieudelgado.xebia.tondeuse.entites.Tondeuse;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Ordre;
import com.matthieudelgado.xebia.tondeuse.exceptions.FichierMalFormeException;
import com.matthieudelgado.xebia.tondeuse.factory.MowItNowFactory;
import com.matthieudelgado.xebia.tondeuse.simulateur.Simulateur;

public class Main {

	public static void main(String[] args) {

		try (Stream<Path> stream = Files.find(
				Paths.get("src/main/resources/com/matthieudelgado/xebia"), 1, 
				(path, attr) -> String.valueOf(path).endsWith(".test"))) {
			stream.forEach(path -> simulerFichier(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void simulerFichier(Path path){
		System.out.println("Début de la lecture du fichier : "+path.toAbsolutePath().toString());
		try{
			List<String> lignes = Files.readAllLines(path);
			List<Tondeuse> tondeuses = new ArrayList<>();
			if(lignes.size() >= 3){
				String ligneTerrain = lignes.get(0);
				Simulateur simulateur = MowItNowFactory.creerSimutaleur(ligneTerrain);
				if(simulateur == null){
					throw new FichierMalFormeException("Format attendu pour un terrain : '\\d+ \\d+'");
				}
				int ligneCourante = 1;
				while( lignes.size() > ligneCourante + 1){
					Tondeuse tondeuse = MowItNowFactory.creerTondeuse(lignes.get(ligneCourante));
					if(tondeuse == null){
						throw new FichierMalFormeException("Format attendu pour une tondeuse : '\\d+ \\d+ (N|S|E|O)'");
					}
					simulateur.ajouterTondeuse(tondeuse);
					List<Ordre> ordres = MowItNowFactory.creerOrdres(lignes.get(ligneCourante+1));
					if(ordres == null){
						throw new FichierMalFormeException("Format attendu pour des ordres : '(G|D|A)+'");
					}
					tondeuse.setOrdres(ordres);
					tondeuses.add(tondeuse);
					ligneCourante+=2;
				}
				tondeuses.forEach(t -> t.demarrer());
			}

	    } catch (IOException | FichierMalFormeException e) {
			e.printStackTrace();
		}
	}


}
