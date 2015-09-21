package com.matthieudelgado.xebia.tondeuse.entites;

import java.util.List;

import com.matthieudelgado.xebia.tondeuse.entites.enums.Ordre;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Orientation;

public class Tondeuse {
	private int x;
	private int y;
	private Orientation orientation;
	private Terrain terrain;
	private List<Ordre> ordres;
	
	public Tondeuse(int x, int y, Orientation orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public void demarrer() {
		if(this.terrain != null){
			ordres.forEach(ordre -> ordonner(ordre));
			System.out.println("Trajet terminée. Position finale : "+this);
		} else {
			System.out.println("Je n'ai pas été ajouté au terrain : "+this);
		}
	}
	
	private void ordonner(Ordre ordre){
		switch(ordre){
		case A : 
			deplacer( orientation.getCos(),orientation.getSin());
			break;
		default :
			tourner(ordre);
		}
	}
	
	private void tourner(Ordre ordre){
		int coef = ordre.equals(Ordre.G) ? 1 : -1;
		orientation = Orientation.getOrientationByTrig(orientation.getTrig() + coef * (Math.PI /2 ));
	}
	
	private void deplacer(int deltaX, int deltaY){
		int xTmp = Integer.min(terrain.getLongueur() -1, Integer.max(x + deltaX, 0));
		int yTmp = Integer.min(terrain.getLargeur() -1, Integer.max(y + deltaY, 0));
		
		terrain.couperCase(x, y);
		if(terrain.estCaseLibre(xTmp, yTmp)){
			x = xTmp;
			y = yTmp;
		}
		terrain.positionerTondeuse(x, y);
	}
	
	public String toString(){
		return "("+x+", "+y+", "+orientation.name()+")";
	}
	
	public void setTerrain(Terrain terrain){
		this.terrain = terrain; 
	}
	
	public void setOrdres(List<Ordre> ordres) {
		this.ordres = ordres;
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


	
}
