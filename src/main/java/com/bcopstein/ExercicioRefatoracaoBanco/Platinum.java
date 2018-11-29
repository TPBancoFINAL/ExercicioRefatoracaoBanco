package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


import javax.sound.sampled.Line;

public class Platinum implements StateConta {
	private Validacao v =  Validacao.InstanceOf();

	private static Platinum p = null;    
	private Platinum() {
	}	
	public static Platinum InstanceOf() {
		if (p == null) {
			return new Platinum();
		}
		return p;
	}

	@Override
	public int getStatus() {
		return 2;
	}

	@Override
	public String getStrStatus() {
		return "Platinum";
	}

	@Override
	public double getLimRetiradaDiaria() {
		return 500000.0;
	}
	@Override
	public double retirada(double saldo, double val) {
		if (saldo - val > 0.0)saldo = saldo - val;		
		return saldo;
	}
	@Override
	public double deposito(double saldo, double val) {
		return saldo + (val*1.025);
	}
	public StateConta upgrade(double saldoAnterior,double saldo) {
		if(saldoAnterior != saldo) {
			if (saldo < 100.000) return Gold.InstanceOf();
		}
		return Platinum.InstanceOf();
	}
	@Override
	public boolean valida(double valor, List<Double> retirada) {
		double sum = retirada.stream()
			    .mapToDouble(a -> a)
			    .sum();
		return v.valida(valor, sum ,500000.0 );
		
		
	}

}
