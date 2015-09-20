package com.matthieudelgado.xebia.tondeuse.factory;

import com.matthieudelgado.xebia.tondeuse.Simulateur;
import com.matthieudelgado.xebia.tondeuse.entites.Terrain;
import com.matthieudelgado.xebia.tondeuse.entites.Tondeuse;

public class MowItNowFactory {

	public static Simulateur creerSimutaleur(int longueur, int largeur){
		Simulateur simulateur = new Simulateur();
		Terrain terrain = new Terrain(longueur, largeur);
		simulateur.setTerrain(terrain);
		return simulateur;
	}
	
	public static Tondeuse creerTondeuse(){
		return new Tondeuse();
	}
	
}
