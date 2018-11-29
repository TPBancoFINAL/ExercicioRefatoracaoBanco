package com.bcopstein.ExercicioRefatoracaoBanco;
public class Operacao {
	public final int CREDITO = 0;
	public final int DEBITO = 1;
    /*@
	@instance invariant getDia() > 0 && getDia() <= 31;
	@instance invariant getMes() > 0 && getMes() <= 12;
	@instance invariant getAno() > 0;
	@instance invariant geHora() > 0 && getHora() <= 24;
	@instance invariant getMinuto() > 0 && getMinuto() <= 60;
	@instance invariant getSegundo() > 0 && getSegundo() <= 60;
	@instance invariant getNumeroConta() >= 0;
	@instance invariant getStatusConta() <= 0 && getStatusConta <=2;
	@instance invariant getTipoOperacao() == 0 || getTipoOperacao() == 1;

	@*/
	
	private int dia;
    private int mes;
    private int ano;
    private int hora;
    private int minuto;
    private int segundo;
    private int numeroConta;
    private int statusConta;
    private double valorOperacao;
    private int tipoOperacao;
    
    
    
	public Operacao(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, int statusConta,
			double valorOperacao, int tipoOperacao) {
			super();
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
			this.hora = hora;
			this.minuto = minuto;
			this.segundo = segundo;
			this.numeroConta = numeroConta;
			this.statusConta = statusConta;
			this.valorOperacao = valorOperacao;
			this.tipoOperacao = tipoOperacao;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public int getStatusConta() {
		return statusConta;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public int getTipoOperacao() {
		return tipoOperacao;
	}
    
	@Override
	public String toString() {
		String tipo = "<C>";
		if (tipoOperacao == 1) {
			tipo = "<D>"; 
		}
		String line = dia+"/"+mes+"/"+ano+" "+
	                  hora+":"+minuto+":"+segundo+" "+
				      numeroConta+" "+
	                  statusConta +" "+
				      tipo+" "+
	                  valorOperacao;
		return(line);
	}
}
