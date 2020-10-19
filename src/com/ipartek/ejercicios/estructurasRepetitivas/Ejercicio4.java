package com.ipartek.ejercicios.estructurasRepetitivas;

/**
 * Realizar la modificaci�n pertinente al ejercicio 4 para que una vez que el
 * usuario haya escogido una de las opciones y muestre la operaci�n, desea
 * continuar? Si escoje la opci�n si volver� a mostrar el men�, si escoge no,
 * saldr� de la ejecuci�n del programa
 * 
 * @author usuario
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		boolean salir = false;
		String opcion; // Guardamos la opcion del usuario

		while (!salir) {
			System.out.println("Introduzca una opci�n:");
			System.out.println("A.	Calcular el �rea de un cuadrado");
			System.out.println("B.	Calcular el �rea de un tri�ngulo equil�tero");
			System.out.println("C.	Calcular el per�metro de un circulo");
			System.out.println("D.	Calcular el �rea de un circulo");
			System.out.println("S.  Salir");

			// TODO capturar la opci�n introducida por el usuario en la variable opcion

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
