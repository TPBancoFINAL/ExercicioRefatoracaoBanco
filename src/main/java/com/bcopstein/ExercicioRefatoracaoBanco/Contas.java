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
	public Conta getConta(Integer nro) {
		return contas.get(nro);
	}
	public Integer getNumero(Conta conta) {
		return conta.getNumero();
	}
	public String getCorentista(Conta conta) {
		return conta.getCorrentista();
	}
	public String getStrStatus(Conta conta) {
		return conta.getStrStatus();
	}
	public int getStatus(Conta conta) {
		return conta.getStatus();
	}
	public double getLimRetiradaDiaria(Conta conta) {
		return conta.getLimRetiradaDiaria();
	}
	public double getSaldo(Conta conta) {
		return conta.getSaldo();
	}
	public void retirada(Conta conta, Double n) {
		conta.retirada(n);
	}
	public void deposito(Conta conta, Double n) {
		conta.deposito(n);
	}
	
	
}