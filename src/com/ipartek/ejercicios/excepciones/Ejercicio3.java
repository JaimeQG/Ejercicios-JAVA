package com.ipartek.ejercicios.excepciones;

import java.util.Scanner;

import com.ipartek.Utilidades;

public class Ejercicio3 {

	public static void main(String[] args) {

		int posicion = 0;
		boolean isError = true;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un texto");
		String texto = sc.nextLine();

		// Introducir un número que no sea mayor que la longitud del texto
		do {
			System.out.println("Introduzca un múmero");
			try {
				posicion = Integer.parseInt(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
				System.out.println("Tu numero es: " + posicion);
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (isError);

		try {
			String resultado = Utilidades.calcularPosicionString(texto, posicion);
			System.out.println("Resultado: " + resultado);

		} catch (Exception e) {
			System.out.println("Algo no ha ido bien " + e.getMessage());
		}

		sc.close();
	}

}
