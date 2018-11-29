 package com.bcopstein.ExercicioRefatoracaoBanco;
public class Conta {
	private Factory f = Factory.InstanceOf();
	
	public final int SILVER = 0;
	public final int GOLD = 1;
	public final int PLATINUM = 2;
	
	private int numero;
	private String correntista;
	private double saldo;
	private StateConta status;

	public StateConta st(){
		return status;
	}
	
	public Conta(int umNumero, String umNome) {
		numero = umNumero;
		correntista = umNome;
		saldo = 0.0;
		status = Silver.InstanceOf();	
		//status = SILVER;
	}
	
	public Conta(int umNumero, String umNome,double umSaldo, int umStatus) {
		numero = umNumero;
		correntista = umNome;
		saldo = umSaldo;		
		status = Factory.createInstance(umStatus);
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public String getCorrentista() {
		return correntista;
	}
	
	public int getStatus() {
		return status.getStatus();
	}
	
	public String getStrStatus() {
		return status.getStrStatus();
	}
	
	public double getLimRetiradaDiaria() {
		return status.getLimRetiradaDiaria();
	}
	/*@
	 @requires(status == SILVER)
	 @requires valor <  10000 && valor < 0;
	 @ensures getSaldo() == \old (getSaldo()) + valor;
	 @also
	 @requires(status == GOLD)
	 @requires valor < 100000 && valor < 0;
	 @ensures getSaldo() == \old (getSaldo()) + valor;
	 @also
	 @requires(status == PLATINUM)
	 @requires valor <  500000 && valor < 0;
	 @ensures getSaldo() == \old (getSaldo()) + valor;
	 @*/
	public void deposito(double valor) {
		double saldoAnterior = saldo;
		saldo = status.deposito(saldo, valor);
		status = status.upgrade(saldoAnterior, saldo);
	}
	/*@
	 @requires(status == SILVER)
	 @requires valor <  10000 && valor < 0;
	 @ensures getSaldo() == \old (getSaldo()) - valor;
	 @also
	 @requires(status == GOLD)
	 @requires valor < 100000 && valor < 0;
	 @ensures getSaldo() == \old (getSaldo()) - valor;
	 @also
	 @requires(status == PLATINUM)
	 @requires valor <  500000 && valor < 0;
	 @ensures getSaldo() == \old (getSaldo()) - valor;
	 @*/
	public void retirada(double valor) {
		double saldoAnterior = saldo;
		saldo = status.retirada(saldo, valor);
		status = status.upgrade(saldoAnterior, saldo);
			}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", correntista=" + correntista + ", saldo=" + saldo + ", status=" + status.getStrStatus()
				+ "]";
	}
}
