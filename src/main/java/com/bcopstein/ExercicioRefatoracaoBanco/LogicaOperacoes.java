package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LogicaOperacoes {
	private List<Double> retiradaDiaria = new LinkedList<Double>();
	private List<Double> depositoDiaria = new LinkedList<Double>();

	private Conta contaAtual;
	private static LogicaOperacoes instance;
	private Operacoes op = Operacoes.InstanceOf();
	private Contas contas = Contas.InstanceOf();
	private Persistencia persis = Persistencia.InstanceOf();
	
	private LogicaOperacoes(){
			persis.loadContas();
			persis.loadOperacoes();
	}
	
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
 		retiradaDiaria.add(val);
 	}
 	public void deposito(Double val) {
 		contas.deposito(contaAtual, val);
 		depositoDiaria.add(val);
 	}
 	
 	public void addOperacao(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, int statusConta,
			double valorOperacao, int tipoOperacao){
 		op.add(dia,mes,ano,hora,minuto,segundo,numeroConta,statusConta,valorOperacao,tipoOperacao);
 		
 	}
 	public void saveContas() {
        persis.saveContas(getContas().values());
 	}
 	public void saveOperacoes() {
 		persis.saveOperacoes(getOperacoes());
 	}
 	
 	public double saldoMedio(int intMes) {
 		double saldo = 0;
		for(Operacao op: getOperacoes()) {
			if(op.getMes() == intMes) {
				if(op.getTipoOperacao() == 0) {
					saldo -= op.getValorOperacao();
					}
				else {
					saldo += op.getValorOperacao();
				}
			}
		}
		return saldo;
 	}
 	
 	
}
