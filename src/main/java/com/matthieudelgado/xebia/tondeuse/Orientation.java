package com.matthieudelgado.xebia.tondeuse;

public enum Orientation {
	N(0),
	E(1),
	S(2),
	W(3);
	
	private int valeur;
	
	Orientation(int valeur){
		this.valeur = valeur;
	}
	
	public int getValeur(){
		return valeur;
	}
	
	public static Orientation getOrientationByValue(int value){
		for(Orientation orientation : values()){
			if(orientation.valeur == (value + 4) % 4)
				return orientation;
		}
		return null;
	}
}
