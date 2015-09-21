package com.matthieudelgado.xebia.tondeuse.simulateur;

import java.util.ArrayList;
import java.util.List;

import com.matthieudelgado.xebia.tondeuse.entites.Terrain;
import com.matthieudelgado.xebia.tondeuse.entites.Tondeuse;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Ordre;
import com.matthieudelgado.xebia.tondeuse.entites.enums.Orientation;

public class Simulateur {
	private List<Tondeuse> tondeuses;
	private Terrain terrain;
	
	public Simulateur(){
		this.tondeuses = new ArrayList<Tondeuse>();
	}
	
	public void setTerrain(Terrain terrain){
		this.terrain = terrain;
	}
	
	public void ajouterTondeuse(Tondeuse tondeuse){
		if(terrain.installerTondeuse(tondeuse)){
			tondeuses.add(tondeuse);
		} else {
			tondeuses.add(null);
		}
	}
	
	public Tondeuse getTondeuse(int numTondeuse){
		return tondeuses.get(numTondeuse);
	}
	
	public void dessinerTerrain(){
		terrain.dessinerTerrain();
	}

	public void afficherPositionTondeuses() {
		int numTondeuse = 1;
		for(Tondeuse tondeuse : tondeuses){
			System.out.println("Position de la tondeuse n "+numTondeuse+" : "+tondeuse+"\n");
			numTondeuse++;
		}
		
	}

	public void setOrdres(int numTondeuse, List<Ordre> ordres) {
		Tondeuse tondeuse = getTondeuse(numTondeuse);
		if(tondeuse != null)
			tondeuse.setOrdres(ordres);
	}

	public void demarrerTondeuse(int numTondeuse) {
		Tondeuse tondeuse = getTondeuse(numTondeuse);
		if(tondeuse != null)
			tondeuse.demarrer();
	}

}
