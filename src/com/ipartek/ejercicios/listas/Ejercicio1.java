package com.ipartek.ejercicios.listas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crear una lista de nombres de alumnos, donde se guardaran con strings.<br>
 * Insertar diez nombres de alumnos en la lista<br>
 * Mostrar los diez nombres recorriendo la lista con un foreach
 * 
 * @author Jaime Quintana
 * @version 1.0
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		// Son dinamicos y pueden crecer
		ArrayList<String> listaAlumnos = new ArrayList<String>();

		String nombre = "";
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce el nombre [" + (i + 1) + "]:");
			nombre = sc.nextLine();
			listaAlumnos.add(nombre);
		}

		sc.close(); // Cerramos el Scanner

		for (String alumno : listaAlumnos) {
			System.out.println(alumno);
		}

	}// main

}// class
