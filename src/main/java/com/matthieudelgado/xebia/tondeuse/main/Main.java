package com.matthieudelgado.xebia.tondeuse.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import com.matthieudelgado.xebia.tondeuse.exceptions.FichierMalFormeException;
import com.matthieudelgado.xebia.tondeuse.factory.MowItNowFileFactory;
import com.matthieudelgado.xebia.tondeuse.simulateur.Simulateur;

public class Main {

	public static void main(String[] args) {

		try (Stream<Path> stream = Files.find(
				Paths.get("src/test/resources/com/matthieudelgado/xebia/stories"), 1, 
				(path, attr) -> String.valueOf(path).endsWith(".story"))) {
			stream.forEach(path -> lireFichier(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void lireFichier(Path path){
		System.out.println("Début de la lecture du fichier : "+path.toAbsolutePath().toString());
		try{
			List<String> lignes = Files.readAllLines(path);
			if(lignes.size() >= 3){
				String ligneTerrain = lignes.get(0);
				Simulateur simulateur = MowItNowFileFactory.creerSimutaleur(ligneTerrain);
				if(simulateur == null){
					throw new FichierMalFormeException("La premiere ligne du fichier "
														+path.getFileName().toString()
														+" doit décrire le terrain. Format attendu '\\d+ \\d+'");
				}
				int ligneCourante = 1;
				while( lignes.size() > ligneCourante + 1){
					
				}
			}

	    } catch (IOException | FichierMalFormeException e) {
			e.printStackTrace();
		}
	}


}
