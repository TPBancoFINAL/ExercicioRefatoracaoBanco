package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.Map;
public class Contas{
	private Persistencia persistencia;
	private Map<Integer,Conta> contas;

	public Contas(){
		persistencia = Persistencia.InstanceOf();
        contas = persistencia.loadContas(); 
	}
	public Map<Integer,Conta> getContas(){
		return contas;
	}
}