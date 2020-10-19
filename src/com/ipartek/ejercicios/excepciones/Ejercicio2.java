package com.ipartek.ejercicios.excepciones;

import java.util.Scanner;

/**
 * Realice un programa que nos solicite por teclado dos números, y leerlos
 * usando la clase Scanner mediante la función nextLine().<br>
 * Transformar ambos strings a números enteros usando la siguiente sentencia
 * Integer.parseInt(numeroLeido). Agrupar el código entre un bloque try catch y
 * procesar para que no se produzca una interrupción y finalización del programa
 * si alguno de los números leídos no puede convertirse, retomando el control en
 * el punto del fallo, hasta que se solucione
 * 
 * @author Jaime
 * @version 1.0
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		int a = 0;
		int b = 0;

		boolean isError = true;

		System.out.println("Ongi Etorri");
		Scanner sc = new Scanner(System.in);

		// Número a, repetir hasta que no haya error
		do {
			System.out.println("Introduzca un múmero");
			try {
				a = Integer.parseInt(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
				System.out.println("Tu numero es: " + a);
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (isError);

		// Número b, repetir hasta que no haya error
		isError = true;
		do {
			System.out.println("Introduzca un múmero");
			try {
				b = Integer.parseInt(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
				System.out.println("Tu numero es: " + b);
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (isError);

		System.out.println("Resultado a/b=" + (a / b));

		sc.close();
		System.out.printf("Tus números son: %s %s", a, b);

	}// main
}// class
