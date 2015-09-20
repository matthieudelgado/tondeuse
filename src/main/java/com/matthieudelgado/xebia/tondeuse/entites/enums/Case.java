package com.matthieudelgado.xebia.tondeuse.entites.enums;

public enum Case {
	LONG,COURT,TONDEUSE;
	
	public String toString(){
		switch(this){
		case LONG :
			return "L";
		case COURT :
			return "C";
		case TONDEUSE :
			return "T";
		}
		return " ";
	}
}
