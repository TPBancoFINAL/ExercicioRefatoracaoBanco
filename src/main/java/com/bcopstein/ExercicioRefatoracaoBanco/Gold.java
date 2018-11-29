package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.List;

public class Gold implements StateConta {
	private static Gold g = null;  
	private Validacao v =  Validacao.InstanceOf();
	private Gold() {
	}	
	public static Gold InstanceOf() {
		if (g == null) {
			return new Gold();
		}
		return g;
	}
	

	@Override
	public int getStatus() {
		return 1;
	}

	@Override
	public String getStrStatus() {
		return "Gold";
	}

	@Override
	public double getLimRetiradaDiaria() {
		return 50000.0;
	}
	@Override
	public double retirada(double saldo, double val) {
		if (saldo - val > 0.0)saldo = saldo - val;		
		return saldo;
	}
	@Override
	public StateConta upgrade(double saldoAnterior,double saldo) {
		if(saldoAnterior != saldo) {
			if (saldo > 200000)return Platinum.InstanceOf();
			if (saldo < 25000) return Silver.InstanceOf();
		}
		return Gold.InstanceOf();
	}

	@Override
	public double deposito(double saldo, double val) {
		return saldo + (val*1.01);
	}

	public boolean valida(double valor,List<Double> retirada) {
		double sum = retirada.stream()
			    .mapToDouble(a -> a)
			    .sum();
		return v.valida(valor, sum ,100000.0 );
	}

}
