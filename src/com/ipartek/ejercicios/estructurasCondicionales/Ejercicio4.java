package com.ipartek.ejercicios.estructurasCondicionales;

import java.util.Scanner;

/**
 * Mostrar al usuario el siguiente men�: <br>
 * Por favor escoja una opci�n:
 * <ul>
 * <li>A: calcular �rea de un triangulo</li>
 * <li>B: calcular el �rea de un cuadrado</li>
 * <li>C: calcular el �rea de un circulo</li>
 * <li>D: calcular el �rea de un pent�gono</li>
 * </ul>
 * Realizad las operaciones adecuadas indicadas en cada categor�a. En caso de
 * que no se escoja una opci�n adecuada, se mostrara un mensaje de error. No
 * deber� realizarse este men� en bucle
 * 
 * @author: Jaime Quintana
 * @version: 1.0
 *
 */
public class Ejercicio4 {
	public static void main(String[] args) {

		System.out.println("Ongi Etorri");
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca una opci�n:");
		System.out.println("A.	Calcular el �rea de un tri�ngulo");
		System.out.println("B.	Calcular el �rea de un cuadrado");
		System.out.println("C.	Calcular el �rea de un c�rculo");
		System.out.println("D.	Calcular el �rea de un pent�gono");

		// Recogemos la opci�n que el usuario introduce por pantalla
		String opcion;
		opcion = sc.nextLine();

		// Comprobamos la respuesta introducida en pantalla
		switch (opcion.toUpperCase()) {
		case "A":
			System.out.println("Has seleccionado la opcion A: �rea de un tri�ngulo");
			System.out.println("La f�rmula es (Base x Alura) / 2");
			/*
			 * System.out.println("Introduzca base: ");
			 * System.out.println("Introduzca altura: ");
			 * System.out.println("�rea tri�ngulo = " + base*altura/2);
			 */
			break;
		case "B":
			System.out.println("Has seleccionado la opcion B: �rea de un cuadrado");
			/*
			 * System.out.println("Introduzca lado: ");
			 * System.out.println("�rea cuadrado = " + lado*lado);
			 */
			break;
		case "C":
			System.out.println("Has seleccionado la opcion C: �rea de un c�rculo");
			/*
			 * System.out.println("Introduzca radio: "); float pi = 3.1416
			 * System.out.println("�rea c�rculo = " + pi*radio**2);
			 */
			break;
		case "D":
			System.out.println("Has seleccionado la opcion D: �rea de un pent�gono");
			// TODO �rea pent�gono
			break;
		default:
			System.out.println("Solo letras de la A a la D");
		}// switch

		sc.close();

	}// main
}// class
