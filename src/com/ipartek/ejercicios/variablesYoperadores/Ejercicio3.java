package com.ipartek.ejercicios.variablesYoperadores;

/**
 * Realizar un programa que tenga 2 variables enteras, dividendo y divisor.
 * Meterle valores enteros y positivos. Realizar la operación división y mostrar
 * el resultado en pantalla.<br>
 * Repetir el mismo código con estas variaciones: entero y real, real y entero,
 * real y real.<br>
 * Por ultimo, intentar dividir en los cuatro casos anteriores entre 0 y mostrar
 * el resultado en pantalla.
 * 
 * @author Jaime Quintana
 * @version 1.0
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		int intdividendo = 10;
		int intdivisor = 5;

		float fdividendo = 10f;
		float fdivisor = (float) 5.1;

		// int/int
		System.out.println("El resultado de la división int/int es: " + intdividendo / intdivisor);

		// int/real
		System.out.println("El resultado de la división int/real es: " + intdividendo / fdivisor);

		// real/int
		System.out.println("El resultado de la división real/int es: " + fdividendo / intdivisor);

		// real/real
		System.out.println("El resultado de la división real/real es: " + fdividendo / fdivisor);

		// Division entre 0
		System.out.println("El resultado de la división int/real es: " + intdividendo / 0);

		// Division entre 0
		/*
		 * System.out.println("El resultado de la división int/int es: " +
		 * intdividendo/0);
		 * System.out.println("El resultado de la división int/real es: " +
		 * intdividendo/0);
		 * System.out.println("El resultado de la división real/int es: " +
		 * fdividendo/0);
		 * System.out.println("El resultado de la división real/real es: " +
		 * fdividendo/0);
		 */
	}
}
