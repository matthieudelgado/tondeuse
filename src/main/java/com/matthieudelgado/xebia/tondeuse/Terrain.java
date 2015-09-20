package com.matthieudelgado.xebia.tondeuse;

import java.util.Arrays;

public class Terrain {
	private int longueur;
	private int largeur;	
	private Case[][] cases;

	public Terrain(int longueur, int largeur) {
		super();
		this.longueur = longueur;
		this.largeur = largeur;
		this.cases = new Case[longueur][largeur];
		for(int colonne = 0; colonne < longueur; colonne++)
			Arrays.fill(cases[colonne], Case.COURT);
	}

	public int getLongueur() {
		return longueur;
	}

	public int getLargeur() {
		return largeur;
	}
	
	public boolean estCaseLibre(int x, int y){
		Case _case = cases[x][y];
		return Case.COURT.equals(_case) || Case.LONG.equals(_case);
	}
	
	public boolean placerTondeuse(Tondeuse tondeuse, int x, int y, Orientation orientation){
		if(estCaseLibre(x,y)){
			tondeuse.setX(x);
			tondeuse.setY(y);
			tondeuse.setOrientation(orientation);
			tondeuse.setTerrain(this);
			return true;
		}
		return false;
	}
	


	
}
