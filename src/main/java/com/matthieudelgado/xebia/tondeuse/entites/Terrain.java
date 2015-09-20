package com.matthieudelgado.xebia.tondeuse.entites;

import java.util.Arrays;

import com.matthieudelgado.xebia.tondeuse.entites.enums.Case;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Orientation;

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
			Arrays.fill(cases[colonne], Case.LONG);
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
	
	public boolean installerTondeuse(Tondeuse tondeuse, int x, int y, Orientation orientation){
		if(estCaseLibre(x,y)){
			tondeuse.setX(x);
			tondeuse.setY(y);
			tondeuse.setOrientation(orientation);
			tondeuse.setTerrain(this);
			positionerTondeuse(x, y);
			return true;
		}
		return false;
	}
	
	public void couperCase(int x, int y){
		cases[x][y] = Case.COURT;
	}
	
	public void positionerTondeuse(int x, int y){
		cases[x][y] = Case.TONDEUSE;
	}

	public void dessinerTerrain() {
		System.out.println();
		for(int ligne = largeur -1 ; ligne >= 0; ligne--){
			for(int colonne = 0; colonne < longueur; colonne++)
				System.out.print(cases[colonne][ligne]+" ");
			System.out.println();
		}
		System.out.println();
		System.out.println("     N     ");
		System.out.println("     |     ");
		System.out.println("W --   -- E");
		System.out.println("     |     ");
		System.out.println("     S     ");	
	}

	
}
