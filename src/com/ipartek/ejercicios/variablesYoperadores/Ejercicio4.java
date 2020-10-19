package com.ipartek.ejercicios.variablesYoperadores;

/**
 * Realizar un programa que realice la siguiente operación: crear tres variables
 * de tipo Byte, llamadas num1, num2, resultado. Asignar los valores 255 y 223.
 * Sumarlas y guardarlo en resultado.<br>
 * Comprueba si el resultado da 478. Si no lo da, buscar una solución al
 * problema para solucionarlo.
 * 
 * @author Jaime Quintana
 * @version 1.0
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);

		byte num1 = -1;
		int num1entero = (num1 & 0xFF); // 255
		byte num2 = -33;
		int num2entero = (num2 & 0xFF); // 223
		/*
		 * byte num1 = (byte) 255; byte num2 = (byte) 223; byte resultado = (byte) (num1
		 * + num2);
		 */
		// System.out.println("Suma: " + resultado);
	}
}