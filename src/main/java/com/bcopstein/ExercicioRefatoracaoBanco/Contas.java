package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.Map;
public class Contas{
	private static Contas instance;
	private Persistencia persistencia = Persistencia.InstanceOf();
	private Map<Integer,Conta> contas = persistencia.loadContas();
	
	private Contas(){}
    public static Contas InstanceOf(){
    	if(instance == null) instance = new Contas();
    	return instance;
    }
	public Map<Integer,Conta> getContas(){
		return contas;
	}
}