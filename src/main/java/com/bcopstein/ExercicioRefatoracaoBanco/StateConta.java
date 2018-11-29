package com.bcopstein.ExercicioRefatoracaoBanco;

public interface StateConta {
	
	public int getStatus();	
	public String getStrStatus();	
	public double getLimRetiradaDiaria();
	public double retirada(double saldo, double val);
	public double deposito(double saldo, double val);
	public StateConta upgrade(double saldoAnterior,double saldo);
}
	
