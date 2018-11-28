package com.bcopstein.ExercicioRefatoracaoBancoDriverTeste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.bcopstein.ExercicioRefatoracaoBanco.Conta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTeste {
	
	@Test
	public void testaDepositoSilver() {
		Conta c = new Conta(100,"Usuario1",10,0);
		double resp = c.getSaldo() + 50;
		c.deposito(50);
		assertEquals(c.getSaldo(),resp);
	}
	
	@Test
	public void testaDepositoGold() {
		Conta c = new Conta(100,"Usuario1",10,1);
		double resp = c.getSaldo() + 70*1.01;
		c.deposito(70);
		assertEquals(c.getSaldo(),resp);
	}
	
	@Test
	public void testaDepositoPlatinum() {
		Conta c = new Conta(100,"Usuario1",10,2);
		double resp = c.getSaldo() + 70*1.025;
		c.deposito(70);
		assertEquals(c.getSaldo(),resp);
	}
}
