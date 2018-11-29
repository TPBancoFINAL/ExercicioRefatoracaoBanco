package com.bcopstein.ExercicioRefatoracaoBanco;

public class Validacao {
	private static Validacao instance;
	
	private Validacao() {}
	
	public static Validacao InstanceOf(){
		if(instance == null) instance = new Validacao();
		return instance;
	}
	
}
