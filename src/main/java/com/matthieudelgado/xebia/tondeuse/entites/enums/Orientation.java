package com.matthieudelgado.xebia.tondeuse.entites.enums;

public enum Orientation {
	N(Math.PI /2),
	E(0),
	S(3*Math.PI/2),
	W(Math.PI);
	
	private double trig;
	
	Orientation(double trig){

		this.trig = trig;
	}
	
	public double getTrig(){
		return trig;
	}

	public int getCos(){
		return ((Double) Math.cos(trig)).intValue();
	}
	public int getSin(){
		return ((Double) Math.sin(trig)).intValue();
	}
	
	
	public static Orientation getOrientationByTrig(double trig){
		for(Orientation orientation : values()){
			if(orientation.trig == (trig + 2 * Math.PI) % (2 * Math.PI))
				return orientation;
		}
		System.out.println("trig = "+trig);
		return null;
	}
}
