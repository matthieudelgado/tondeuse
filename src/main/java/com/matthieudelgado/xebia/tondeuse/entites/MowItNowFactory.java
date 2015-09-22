package com.matthieudelgado.xebia.tondeuse.entites;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.matthieudelgado.xebia.tondeuse.entites.enums.Ordre;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Orientation;
import com.matthieudelgado.xebia.tondeuse.simulateur.Ordonnanceur;

public class MowItNowFactory {

	public static Ordonnanceur creerSimutaleur(int longueur, int largeur){
		Ordonnanceur simulateur = new Ordonnanceur();
		Terrain terrain = new Terrain(longueur, largeur);
		simulateur.setTerrain(terrain);
		return simulateur;
	}
	
	public static Ordonnanceur creerSimutaleur(String ligneTerrain){
		Pattern pattern = Pattern.compile("(\\d+) (\\d+)");
		Matcher matcher = pattern.matcher(ligneTerrain);
		if(matcher.matches()) {
			int longueur = Integer.valueOf(matcher.group(1));
			int largeur = Integer.valueOf(matcher.group(2));
			Ordonnanceur simulateur = new Ordonnanceur();
			Terrain terrain = new Terrain(longueur, largeur);
			simulateur.setTerrain(terrain);
			return simulateur;
		}
		return null;
	}
	
	public static Tondeuse creerTondeuse(int x, int y, Orientation orientation){
		return new Tondeuse(x, y, orientation);
	}
	
	public static Tondeuse creerTondeuse(String ligneTondeuse){
		Pattern pattern = Pattern.compile("^(\\d+) (\\d+) (N|S|E|O)$");
		Matcher matcher = pattern.matcher(ligneTondeuse);
		if(matcher.matches()) {
			int x = Integer.valueOf(matcher.group(1));
			int y = Integer.valueOf(matcher.group(2));
			Orientation orientation = Orientation.valueOf(matcher.group(3));
			return new Tondeuse(x, y, orientation);
		
		}
		return null;
	}

	public static List<Ordre> creerOrdres(String ordres) {
		if( ordres != null){
			return ordres.chars()
					.mapToObj(i -> (char)i)
					.filter(c -> c.toString().matches("(G|D|A)"))
					.map(character -> Ordre.valueOf(character.toString()))
					.collect(Collectors.toCollection(ArrayList::new));
		}
		return null;
	}
}
