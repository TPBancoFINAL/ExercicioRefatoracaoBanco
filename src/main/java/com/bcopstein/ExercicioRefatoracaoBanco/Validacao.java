package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.LinkedList;
import java.util.List;
public class Validacao {
	private static Validacao instance;
	
	private Validacao(){}
	
	public static Validacao InstanceOf(){
		if(instance == null) instance = new Validacao();
		return instance;
	}
	public boolean valida(double valor,Double atual, Double limite){
		if(atual < limite) return true;
		else return false;
	}
	
	
	
}
