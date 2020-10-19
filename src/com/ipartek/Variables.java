package com.ipartek;

/**
 * Comentario Javadoc usado para documentar métodos y clases
 * 
 * Ejercicio para aprender a declarar variables java
 * 
 * @author Jaime Quintana
 * @version 1.0
 */

public class Variables {

	public static void main(String[] args) {

		// Comentario de línea
		/*
		 * Comentario Bloque
		 */
		// Las variable se declaran TIPO nombre = valor;
		String nombre = "Jaime";
		int edad = 51;
		float sueldo = 6521f;
		float sueldo2 = (float) 6521.99;
		char sexo = 'x';

		System.out.println("Hola: " + nombre);
		System.out.println("Mi edad es: " + edad);
		System.out.println("Mi sueldo es: " + sueldo + " €");
		System.out.println("Mi sueldo2 es: " + sueldo2 + " €");

		switch (sexo) {
		case 'v':
			System.out.println("Eres un hombre");
			break;
		case 'm':
			System.out.println("Eres una mujer");
		default:
			System.out.println("No sabemos lo que eres");
			break;
		}// switch
	}// main
}// clase
