package com.ipartek.ejercicios.estructurasCondicionales;

import java.util.Scanner;

/**
 * Realiza un programa que pida un numero por consola. En caso de que el numero
 * sea mayor que 50, o menor que 0, indicar que el numero introducido no es
 * valido
 *
 * @author: Jaime
 * @version: 1.0
 */
public class Ejercicio2 {

	static final int EDAD_MINIMA = 0;
	static final int EDAD_MAXIMA = 150;
	static final int MAXIMO_ERRORES = 3;

	public static void main(String[] args) {
		/*
		 * // TODO declarar variables constantes int intnumero = 0; Scanner sc = new
		 * Scanner(System.in); // System.out.println("Introduzca un número entero: ");
		 * // intnumero = Integer.parseInt(sc.nextLine());
		 * 
		 * boolean boolsalir = false; int i = 0;
		 * 
		 * while (!boolsalir) { System.out.println("Introduzca un número entero: ");
		 * intnumero = Integer.parseInt(sc.nextLine());
		 * 
		 * if (intnumero > 50 || intnumero < 0) {
		 * System.out.println("El número introducido no es correcto"); i++; if (i >= 3)
		 * { System.out.println("Llevas ya más de " + i +
		 * " intentos ... No es tan difícil !!!"); } // if } else { boolsalir = true; }
		 * // if } // while
		 */
		System.out.println("Ongi Etorri");
		Scanner sc = new Scanner(System.in);
		int edad;
		int contador = 0;

		do {

			// gestionar contador
			if (contador >= MAXIMO_ERRORES) {
				System.out.printf("POR FAVOR lee bien: Escribe tu edad de %s a %s maximo:", EDAD_MINIMA, EDAD_MAXIMA);
			} else {
				System.out.printf("Escribe tu edad de %s a %s maximo:", EDAD_MINIMA, EDAD_MAXIMA);
			}
			// pedir dato por consola
			edad = Integer.parseInt(sc.nextLine());
			contador++;

		} while (!(edad >= EDAD_MINIMA && edad <= EDAD_MAXIMA));

		System.out.println("Gracias tu edad es " + edad);
		sc.close();

	}// main
}// class
