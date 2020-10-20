package com.ipartek.ejercicios.excepciones;

import java.util.Scanner;

/**
 * Implemente un programa que lea un número ‘a’ y otro número ‘b’ y luego
 * calcule “a/b”. Pruebe a introducir b=0 y ver que hace el programa con la
 * división por cero.<br>
 * Pruebe a introducir b=”Carlos” para ver cómo se comporta el programa. Añada
 * excepciones para recoger estas excepciones y avisar del problema al usuario
 * 
 * @author Jaime
 * @version 1.0
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int a = 0;
		int b = 0;
		int division;

		System.out.println("Ongi Etorri");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Introduzca un múmero");
			a = Integer.parseInt(sc.nextLine());

			System.out.println("Introduzca un múmero");
			b = Integer.parseInt(sc.nextLine());

			division = a / b;
			// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
			System.out.println("El resultado a/b es: " + division);

		} catch (ArithmeticException e) {
			System.out.println("División entre 0");
		} catch (NumberFormatException e) {
			System.out.println("Introducir números");
		} catch (Exception e) {
			// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
			e.printStackTrace();
			System.out.println("Error genérico");
		}

		sc.close();
		System.out.println("cerramos escaner, agur");

	}// main
}// class
