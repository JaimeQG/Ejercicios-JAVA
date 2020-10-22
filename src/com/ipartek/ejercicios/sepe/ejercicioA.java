package com.ipartek.ejercicios.sepe;

import java.util.Scanner;

/**
 * Realizar un programa en java que realice la siguiente función: Crear un array
 * de 5 notas que almacenara en formato double.<br>
 * Una vez creado dicho array se rellenaran dichos elementos leyéndolo desde el
 * teclado. Una vez creado el contenido, se calculara la media de las notas así
 * como se mostraran las notas más altas y más bajas de dicho array.
 * 
 * @author Jaime Quintana
 * @version 1.0
 *
 */

public class ejercicioA {

	public static void main(String[] args) {

		// Variables
		double[] doubleArrayNotas = new double[5]; // Array notas
		double nota = (double) 0.0;
		double notaMedia = (double) 0.0;
		double notaAlta = Double.MIN_VALUE;
		double notaBaja = Double.MAX_VALUE;

		// Scanner para leer las notas introducidas por teclado
		Scanner sc = new Scanner(System.in);

		int icontador = 0;

		// Introducimos 5 números dentro del array. Repetir hasta que no haya error
		do {

			try {
				System.out.println("Introduce la nota [" + (icontador + 1) + "]");
				nota = Double.parseDouble(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
				doubleArrayNotas[icontador] = nota;
				icontador++;
			} catch (Exception e) {
				// Para ver la traza de la Excepcion, usar e.printStackTrace()
				// e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (icontador < 5);

		// Calculamos la nota media
		for (int i = 0; i < doubleArrayNotas.length; i++) {
			notaMedia = notaMedia + doubleArrayNotas[i];
		} // End for

		notaMedia = notaMedia / doubleArrayNotas.length;

		System.out.println("");

		// Formateamos la salida para 2 decimales
		System.out.println("La nota media de las " + doubleArrayNotas.length + " notas es "
				+ Math.round(notaMedia * 100.0) / 100.0);

		// Calculamos la nota más alta y la más baja
		for (int i = 0; i < doubleArrayNotas.length; i++) {

			// Obtenemos la nota alta
			if (doubleArrayNotas[i] > notaAlta) {
				notaAlta = doubleArrayNotas[i];
			}

			// Obtenemos la nota más baja
			if (doubleArrayNotas[i] < notaBaja) {
				notaBaja = doubleArrayNotas[i];
			}
		} // End for

		System.out.println("La nota más alta de las " + doubleArrayNotas.length + " notas es " + notaAlta);
		System.out.println("La nota más baja de las " + doubleArrayNotas.length + " notas es " + notaBaja);

		sc.close();
	}

}
