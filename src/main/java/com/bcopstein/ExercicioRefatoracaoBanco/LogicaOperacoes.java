package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.List;
import java.util.Map;

public class LogicaOperacoes {
	private Conta contaAtual;
	private static LogicaOperacoes instance;
	private Operacoes op = Operacoes.InstanceOf();
	private Contas contas = Contas.InstanceOf();
	
	private LogicaOperacoes(){}
	
	public static LogicaOperacoes InstanceOf(){
    	if(instance == null) instance = new LogicaOperacoes();
    	return instance;
    }
	public boolean ContaAtual(Integer nro){
		contaAtual = contas.getConta(nro);
		if(contaAtual != null) return true;
		else return false;
	}
	
	public List<Operacao> getOperacoes() {
		return op.getOperacoes();
	}
	public Map<Integer,Conta> getContas(){
		return contas.getContas();
	}
 	public Conta getNroconta(Integer nro) {
 		return contas.getConta(nro);
 	}
 	public Integer getNumeroConta() {
 		return contas.getNumero(contaAtual); 		
 	}
 	public int getStatusConta() {
 		return contas.getStatus(contaAtual);
 	}
 	
 	public String getCorrentistaConta() {
 		return contas.getCorentista(contaAtual);
 	}
 	public String getStrStatusConta() {
 		return contas.getCorentista(contaAtual);
 	}
 	
 	public double getLimRetiradaDiariaConta() {
 		return contas.getLimRetiradaDiaria(contaAtual); 		
 	}
 	public double getSaldoConta() {
 		return contas.getSaldo(contaAtual);
 	}
 	public void retirada(Double val) {
 		contas.retirada(contaAtual, val);
 	}
 	public void deposito(Double val) {
 		contas.deposito(contaAtual, val);
 	}
 	
 	public void addOperacao(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, int statusConta,
			double valorOperacao, int tipoOperacao){
 		op.add(dia,mes,ano,hora,minuto,segundo,numeroConta,statusConta,valorOperacao,tipoOperacao);
 		
 	}
 	
}
