package com.ipartek.pojo.ejercicios;

import java.util.ArrayList;

import com.ipartek.pojo.Persona;

/**
 * Crea una clase Persona con los atributos nombre y edad. <br>
 * En el método setEdad lanzar una excepción si la edad introducida es menor que
 * 0 o mayor que 120. Realiza un programa que al comienzo cree una lista de
 * personas haciendo uso del constructor vacío, y lea los datos por teclado y
 * los asigne a los objetos creados. Solo introducirá las personas en la lista
 * si están en el rango de edad indicado, comprobándolo mediante el uso de
 * excepciones. <br>
 * Ejemplo: probar a crear las siguientes personas:
 * <ol>
 * <li>“pepe” con 56 años</li>
 * <li>“matusalem” con 999 años</li>
 * </ol>
 * 
 * @autor Jaime
 * @version 1.0
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		ArrayList<Persona> personas = new ArrayList<Persona>();

		try {
			// Persona 1
			Persona p1 = new Persona();
			p1.setEdad(56);
			p1.setNombre("pepe");

			personas.add(p1);

			// Persona 2
			Persona p2 = new Persona();
			p2.setNombre("matusalen");
			p2.setEdad(999); // CUIDADO !! Lanza una Exception y va directo al Catch. No ejecuta las línea
								// de abajo
			personas.add(p2);

		} catch (Exception e) {
			System.out.println((e.getMessage()));

		} finally {

			// foreach para iterar sobre el ArrayList<Perona>
			for (Persona p : personas) {
				System.out.println(p);
			}
		}

		// llamamos al metodo toString()
		// System.out.println(p1);
		// System.out.println(p1.toString());

		// System.out.println(p2);

	}// main
}// class
