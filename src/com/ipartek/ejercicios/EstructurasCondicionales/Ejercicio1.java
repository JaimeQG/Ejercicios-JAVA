package com.ipartek.ejercicios.EstructurasCondicionales;

/**
 * Realizar un programa que realice la siguiente funcionalidad<br>
 * Se crearan 5 variables enteras con los nombres <strong>a, b, c, d y
 * e</strong> con los valores <strong>6, 8, 0, 8 y 9</strong>
 * <ul>
 * <li>Comparar las variables a y c, indicar por consola cual es mayor</li>
 * <li>Indicar cual de las variables es la que tiene menor valor y la de mayor
 * valor</li>
 * <li>Compara las variables b y d y comprueba si son iguales</li>
 * <li>Comprobar si se puede realizar la división de a/c si no se puede realizar
 * indicarlo, en caso contrario realizar la división</li>
 * </ul>
 * 
 * @author Jaime
 *
 */
public class Ejercicio1 {
	public static void main(String[] args) {

		int a = 6;
		int b = 8;
		int c = 0;
		int d = 8;
		int e = 9;
		int mayor = 0;

		// Comparar las variables a y c, indicar por consola cual es mayor
		if (a > c) {
			System.out.println(a + " es mayor que " + c);
		} else {
			System.out.println(c + " es mayor que " + a);
		}

		// Indicar cual de las variables es la que tiene menor valor y la de mayor valor
		if (a > mayor) {
			mayor = a;
		}
		if (b > mayor) {
			mayor = b;
		}
		if (c > mayor) {
			mayor = c;
		}
		if (d > mayor) {
			mayor = d;
		} else {
			mayor = e;
		}

		System.out.println("El número mayor es: " + mayor);

		// Compara las variables b y d y comprueba si son iguales
		if (b == d) {
			System.out.println(b + " es igual que " + d);
		} else {
			System.out.println(b + " es distinto que " + d);
		}

		// Comprobar si se puede realizar la división de a/c si no se puede realizar
		// indicarlo, en caso contrario realizar la división
		if (c > 0) {
			System.out.println("Division: " + a / c);
		} else {
			System.out.println("No se puede hacer la división");
		}
	}
}
