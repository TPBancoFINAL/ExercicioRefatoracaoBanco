package com.bcopstein.ExercicioRefatoracaoBanco;

public class LogicaOperacoes {
	private static LogicaOperacoes instance;
	private Operacoes op = Operacoes.InstanceOf();
	private Contas contas = Contas.InstanceOf();
	
	private LogicaOperacoes(){}
	public static LogicaOperacoes InstanceOf(){
    	if(instance == null) instance = new LogicaOperacoes();
    	return instance;
    }	

}
