package com.ipartek.ejercicios.estructurasRepetitivas;

/**
 * Realizar un programa que pida por teclado las notas de un alumno. Dichas
 * notas se guardar�n en formato entero, en un array de 8 posiciones,
 * totales.<br>
 * Se solicitar� la nota del alumno, y se guardar� en el array. Una vez
 * introducida se preguntar� si se desean introducir m�s notas. Si la respuesta
 * es si, se continuara metiendo notas en el array<br>
 * Tener cuidado, solo se podr�n meter 8 notas. No se deber� dejar meter una
 * novena
 * 
 * @author Jaime Quintana
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		int[] notas = new int[7];
		boolean salir = false;
		int i = 1;
		String respuesta;

		while (!salir) {
			System.out.println("Introduza la nota " + i + " del alumno");
			// TODO capturar valor de la nota
			if (i <= 7) {
				// notas[i]= nota;
				// i += 1;
				System.out.println("�Quiere introducir m�s notas (S/N?");
				// TODO capturar respuesta
				switch (respuesta.toUpperCase()) {
				case "S":
					break;
				case "N":
					salir = true;
					break;
				default:
					System.out.println("�Quiere introducir m�s notas (S/N?");
				}// switch
			} else {
				System.out.println("El n�mero m�ximo de notas son 8");
				salir = true;
			}
		} // while

	} // main

} // class
