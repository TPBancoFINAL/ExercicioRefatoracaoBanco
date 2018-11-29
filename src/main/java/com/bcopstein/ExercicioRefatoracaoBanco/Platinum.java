package com.bcopstein.ExercicioRefatoracaoBanco;

public class Platinum implements StateConta {
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

}
