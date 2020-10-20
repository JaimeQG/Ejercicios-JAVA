package com.ipartek.ejercicios.estructurasRepetitivas;

/**
 * Realizar el siguiente menú:<br>
 * <br>
 * Introduzca una opción:
 * <ol>
 * <li>A. Calcular el área de un cuadrado</li>
 * <li>B. Calcular el área de un triángulo equilátero</li>
 * <li>C. Calcular el perímetro de un circulo</li>
 * <li>D. Calcular el área de un circulo</li>
 * </ol>
 * Hacer que se repita este menú de manera indefinida
 * 
 * @author usuario
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		boolean salir = false;
		String opcion; // Guardamos la opcion del usuario

		while (!salir) {
			System.out.println("Introduzca una opción:");
			System.out.println("A.	Calcular el área de un cuadrado");
			System.out.println("B.	Calcular el área de un triángulo equilátero");
			System.out.println("C.	Calcular el perímetro de un circulo");
			System.out.println("D.	Calcular el área de un circulo");
			// System.out.println("S. Salir");

			// TODO capturar la opción introducida por el usuario en la variable opcion

			opcion = "A";
			switch (opcion.toUpperCase()) {
			case "A":
				System.out.println("Has seleccionado la opcion A");
				break;
			case "B":
				System.out.println("Has seleccionado la opcion B");
				break;
			case "C":
				System.out.println("Has seleccionado la opcion C");
				break;
			case "D":
				System.out.println("Has seleccionado la opcion D");
				break;
			case "S":
				// salir = true;
				break;
			default:
				System.out.println("Solo letras de la A a la D");
			}// switch
		} // while
	}// main
}// class
