package com.matthieudelgado.xebia.tondeuse;

import java.util.ArrayList;
import java.util.List;

public class Simulateur {
	private List<Tondeuse> tondeuses;
	private Terrain terrain;
	
	public Simulateur(){
		this.tondeuses = new ArrayList<Tondeuse>();
	}
	
	public void setTerrain(Terrain terrain){
		this.terrain = terrain;
	}
	
	public void ajouterTondeuse(Tondeuse tondeuse, int x, int y, Orientation orientation){
		if(terrain.installerTondeuse(tondeuse, x, y, orientation)){
			tondeuses.add(tondeuse);
		}
	}
	
	public void ordonnerTondeuse(Ordre ordre, int numTondeuse){
		if(numTondeuse<tondeuses.size())
			tondeuses.get(numTondeuse).ordonner(ordre);
	}
	
	public Tondeuse getTondeuse(int numTondeuse){
		return tondeuses.get(numTondeuse);
	}

}
