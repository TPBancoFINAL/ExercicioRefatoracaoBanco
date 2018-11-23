package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.GregorianCalendar;
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
	public void add(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, int statusConta,
			double valorOperacao, int tipoOperacao) {
		 Operacao op = new Operacao(dia,mes,ano,hora,minuto,segundo,numeroConta,statusConta,valorOperacao,tipoOperacao);
		 operacoes.add(op);
	}
	
}