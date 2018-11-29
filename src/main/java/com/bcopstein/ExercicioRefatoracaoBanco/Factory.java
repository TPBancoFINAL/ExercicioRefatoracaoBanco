package com.bcopstein.ExercicioRefatoracaoBanco;

public class Factory {
	private static Factory f = null;    
	private Factory() {
	}	
	public static Factory InstanceOf() {
		if (f == null) {
			return new Factory();
		}
		return f;
	}
	
	public static StateConta createInstance(int s){
		switch(s) {
			case 0: return Silver.InstanceOf();
			case 1: return Gold.InstanceOf();
			case 2: return Platinum.InstanceOf();
			default: return null;
		}		
	}
	
}
