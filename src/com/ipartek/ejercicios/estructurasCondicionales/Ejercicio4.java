package com.ipartek.ejercicios.estructurasCondicionales;

import java.util.Scanner;

/**
 * Mostrar al usuario el siguiente menú: <br>
 * Por favor escoja una opción:
 * <ul>
 * <li>A: calcular área de un triangulo</li>
 * <li>B: calcular el área de un cuadrado</li>
 * <li>C: calcular el área de un circulo</li>
 * <li>D: calcular el área de un pentágono</li>
 * </ul>
 * Realizad las operaciones adecuadas indicadas en cada categoría. En caso de
 * que no se escoja una opción adecuada, se mostrara un mensaje de error. No
 * deberá realizarse este menú en bucle
 * 
 * @author: Jaime Quintana
 * @version: 1.0
 *
 */
public class Ejercicio4 {
	public static void main(String[] args) {

		System.out.println("Ongi Etorri");
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca una opción:");
		System.out.println("A.	Calcular el área de un triángulo");
		System.out.println("B.	Calcular el área de un cuadrado");
		System.out.println("C.	Calcular el área de un círculo");
		System.out.println("D.	Calcular el área de un pentágono");

		// Recogemos la opción que el usuario introduce por pantalla
		String opcion;
		opcion = sc.nextLine();

		// Comprobamos la respuesta introducida en pantalla
		switch (opcion.toUpperCase()) {
		case "A":
			System.out.println("Has seleccionado la opcion A: área de un triángulo");
			System.out.println("La fórmula es (Base x Alura) / 2");
			/*
			 * System.out.println("Introduzca base: ");
			 * System.out.println("Introduzca altura: ");
			 * System.out.println("Área triángulo = " + base*altura/2);
			 */
			break;
		case "B":
			System.out.println("Has seleccionado la opcion B: área de un cuadrado");
			/*
			 * System.out.println("Introduzca lado: ");
			 * System.out.println("Área cuadrado = " + lado*lado);
			 */
			break;
		case "C":
			System.out.println("Has seleccionado la opcion C: área de un círculo");
			/*
			 * System.out.println("Introduzca radio: "); float pi = 3.1416
			 * System.out.println("Área círculo = " + pi*radio**2);
			 */
			break;
		case "D":
			System.out.println("Has seleccionado la opcion D: área de un pentágono");
			// TODO área pentágono
			break;
		default:
			System.out.println("Solo letras de la A a la D");
		}// switch

		sc.close();

	}// main
}// class
