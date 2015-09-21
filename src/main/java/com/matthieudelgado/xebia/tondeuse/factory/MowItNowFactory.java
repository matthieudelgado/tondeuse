package com.matthieudelgado.xebia.tondeuse.factory;

import com.matthieudelgado.xebia.tondeuse.entites.Terrain;
import com.matthieudelgado.xebia.tondeuse.entites.Tondeuse;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Orientation;
import com.matthieudelgado.xebia.tondeuse.simulateur.Simulateur;

public class MowItNowFactory {

	public static Simulateur creerSimutaleur(int longueur, int largeur){
		Simulateur simulateur = new Simulateur();
		Terrain terrain = new Terrain(longueur, largeur);
		simulateur.setTerrain(terrain);
		return simulateur;
	}
	
	public static Tondeuse creerTondeuse(int x, int y, Orientation orientation){
		return new Tondeuse(x, y, orientation);
	}
	
}
