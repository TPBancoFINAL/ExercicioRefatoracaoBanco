package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.List;

public class Silver implements StateConta {
	private Validacao v =  Validacao.InstanceOf();

	private static Silver s = null;    
	private Silver() {
	}	
	public static Silver InstanceOf() {
		if (s == null) {
			return new Silver();
		}
		return s;
	}
	

	@Override
	public int getStatus() {
		return 0;
	}

	@Override
	public String getStrStatus() {
		return "Silver";
	}

	@Override
	public double getLimRetiradaDiaria() {
		// TODO Auto-generated method stub
		return 5000.0;
	}
	@Override
	public double retirada(double saldo, double val) {
		if (saldo - val > 0.0)saldo = saldo - val;
		return saldo;
	}
	@Override
	public double deposito(double saldo, double val) {
		return saldo + val;
	}
	public StateConta upgrade(double saldoAnterior,double saldo) {
		if (saldo >= 50000) return Gold.InstanceOf();
		return Silver.InstanceOf();
	}
	public boolean valida(double valor,List<Double> retirada ) {
		double sum = retirada.stream()
			    .mapToDouble(a -> a)
			    .sum();
		return v.valida(valor, sum ,10000.0 );
	}

}
