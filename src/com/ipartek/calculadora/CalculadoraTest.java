package com.ipartek.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	public void testSuma() {
		int resultado = Calculadora.suma(2, 3);
		int esperado = 5;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testResta() {
		int resultado = Calculadora.resta(3, 2);
		int esperado = 1;
		assertEquals(esperado, resultado);
	}

}
