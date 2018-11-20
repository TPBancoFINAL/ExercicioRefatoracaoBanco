package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.List;
public class Operacoes{
	private static Operacoes instance;
	private Persistencia persistencia = Persistencia.InstanceOf();
	private List<Operacao> operacoes = persistencia.loadOperacoes();
	
	private Operacoes(){}
    public static Operacoes InstanceOf(){
    	if(instance == null) instance = new Operacoes();
    	return instance;
    }
	public List<Operacao> getOperacoes(){
		return operacoes;
	}
	
	
}