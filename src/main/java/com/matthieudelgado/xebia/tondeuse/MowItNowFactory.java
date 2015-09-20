package com.matthieudelgado.xebia.tondeuse;

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
