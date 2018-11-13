package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.List;
public class Operacoes{
	private Persistencia persistencia;
	private List<Operacao> operacoes;
	
	public Operacoes(){
		persistencia = Persistencia.InstanceOf();
		operacoes = persistencia.loadOperacoes();			
	}
	public List<Operacao> getOperacoes() {
		return operacoes;
	}
	
	
}