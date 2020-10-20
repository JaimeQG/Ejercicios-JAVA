package com.ipartek.ejercicios.excepciones;

import java.util.Scanner;

/**
 * Implemente un programa que lea un n�mero �a� y otro n�mero �b� y luego
 * calcule �a/b�. Pruebe a introducir b=0 y ver que hace el programa con la
 * divisi�n por cero.<br>
 * Pruebe a introducir b=�Carlos� para ver c�mo se comporta el programa. A�ada
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
			System.out.println("Introduzca un m�mero");
			a = Integer.parseInt(sc.nextLine());

			System.out.println("Introduzca un m�mero");
			b = Integer.parseInt(sc.nextLine());

			division = a / b;
			// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
			System.out.println("El resultado a/b es: " + division);

		} catch (ArithmeticException e) {
			System.out.println("Divisi�n entre 0");
		} catch (NumberFormatException e) {
			System.out.println("Introducir n�meros");
		} catch (Exception e) {
			// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
			e.printStackTrace();
			System.out.println("Error gen�rico");
		}

		sc.close();
		System.out.println("cerramos escaner, agur");

	}// main
}// class
