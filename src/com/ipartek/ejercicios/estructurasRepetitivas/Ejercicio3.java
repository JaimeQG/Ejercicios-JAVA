package com.ipartek.ejercicios.estructurasRepetitivas;

/**
 * Realizar el siguiente men�:<br>
 * <br>
 * Introduzca una opci�n:
 * <ol>
 * <li>A. Calcular el �rea de un cuadrado</li>
 * <li>B. Calcular el �rea de un tri�ngulo equil�tero</li>
 * <li>C. Calcular el per�metro de un circulo</li>
 * <li>D. Calcular el �rea de un circulo</li>
 * </ol>
 * Hacer que se repita este men� de manera indefinida
 * 
 * @author usuario
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		boolean salir = false;
		String opcion; // Guardamos la opcion del usuario

		while (!salir) {
			System.out.println("Introduzca una opci�n:");
			System.out.println("A.	Calcular el �rea de un cuadrado");
			System.out.println("B.	Calcular el �rea de un tri�ngulo equil�tero");
			System.out.println("C.	Calcular el per�metro de un circulo");
			System.out.println("D.	Calcular el �rea de un circulo");
			// System.out.println("S. Salir");

			// TODO capturar la opci�n introducida por el usuario en la variable opcion

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
