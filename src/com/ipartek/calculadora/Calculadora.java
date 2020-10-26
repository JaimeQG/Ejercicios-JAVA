package com.ipartek.calculadora;

public class Calculadora {

	public static int suma(int a, int b) {
		return a + b;
	}

	public static int resta(int a, int b) {
		return a - b;
	}

	public static void main(String args[]) {

		int a = 3;
		int b = 2;

		int res = suma(a, b);
		int esperado = 5;
		System.out.println("3 + 2 = " + res);
	}

}
