package com.matthieudelgado.xebia.tondeuse.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.matthieudelgado.xebia.tondeuse.entites.Terrain;
import com.matthieudelgado.xebia.tondeuse.entites.Tondeuse;
import com.matthieudelgado.xebia.tondeuse.simulateur.Simulateur;


public class MowItNowFileFactory {

	public static Simulateur creerSimutaleur(String ligneTerrain){
		Pattern pattern = Pattern.compile("(\\d+) (\\d+)");
		Matcher matcher = pattern.matcher(ligneTerrain);
		if(matcher.matches()) {
			int longueur = Integer.valueOf(matcher.group(0));
			int largeur = Integer.valueOf(matcher.group(1));
			Simulateur simulateur = new Simulateur();
			Terrain terrain = new Terrain(longueur, largeur);
			simulateur.setTerrain(terrain);
			return simulateur;
		}
		return null;
	}
	
//	public static Tondeuse creerTondeuse(String ligne){
//		return new Tondeuse();
//	}
	
}
