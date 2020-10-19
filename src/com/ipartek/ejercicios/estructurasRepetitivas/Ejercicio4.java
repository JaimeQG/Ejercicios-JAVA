package com.ipartek.ejercicios.estructurasRepetitivas;

/**
 * Realizar la modificación pertinente al ejercicio 4 para que una vez que el
 * usuario haya escogido una de las opciones y muestre la operación, desea
 * continuar? Si escoje la opción si volverá a mostrar el menú, si escoge no,
 * saldrá de la ejecución del programa
 * 
 * @author usuario
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		boolean salir = false;
		String opcion; // Guardamos la opcion del usuario

		while (!salir) {
			System.out.println("Introduzca una opción:");
			System.out.println("A.	Calcular el área de un cuadrado");
			System.out.println("B.	Calcular el área de un triángulo equilátero");
			System.out.println("C.	Calcular el perímetro de un circulo");
			System.out.println("D.	Calcular el área de un circulo");
			System.out.println("S.  Salir");

			// TODO capturar la opción introducida por el usuario en la variable opcion

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
				salir = true;
				break;
			default:
				System.out.println("Solo letras de la A a la D");
			}// switch
		} // while

	}// main

}// class
