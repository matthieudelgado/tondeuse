package com.matthieudelgado.xebia.tondeuse;

public class Tondeuse {
	private int x;
	private int y;
	private Orientation orientation;
	private Terrain terrain;
	
	public void setTerrain(Terrain terrain){
		this.terrain = terrain; 
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	protected void ordonner(Ordre ordre){
		switch(ordre){
		case A : 
			avancer();
			break;
		case G:
			orientation = Orientation.getOrientationByValue(orientation.getValeur() -1);
			break;
		case D:
			orientation = Orientation.getOrientationByValue(orientation.getValeur() +1);
			break;
			
		}
	}
	
	private void avancer(){
		switch(orientation){
		case N :
			deplacer(0,1);
			break;
		case E:
			deplacer(1,0);
			break;
		case S:
			deplacer(0,-1);
			break;
		case W:
			deplacer(-1,0);
			break;
		}
	}
	
	private void deplacer(int deltaX, int deltaY){
		x = Integer.min(terrain.getLargeur() -1, Integer.max(x + deltaX, 0));
		y = Integer.min(terrain.getLongueur() -1, Integer.max(y + deltaY, 0));
	}
	
}
