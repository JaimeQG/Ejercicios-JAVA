package com.ipartek.ejercicios.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import com.ipartek.pojo.Perro;

/**
 * Ejercicio para aprender los metodos basicos de java.util.ArrayList
 * 
 * @autor Jiame
 * @author usuario
 *
 */

public class EjercicioPerros {

	public static void main(String[] args) {

		ArrayList<Perro> perros = new ArrayList<Perro>();

		Perro p = new Perro();
		p.setNombre("Laika");
		p.setRaza("Laika Ruso-Europeo");

		// insertar valores en el ArrayList
		perros.add(p);

		p = new Perro();
		p.setNombre("Goofy");
		p.setVacunado(true);
		perros.add(p);

		p = new Perro();
		p.setNombre("Pluto");
		p.setHistoria("El amigo del ratón Mickey");

		// insertar en una posicion
		perros.add(1, p);

		// recuperar longitud
		perros.size();

		// recuperar un perro
		p = new Perro();
		p = perros.get(0);

		Perro p1 = perros.get(1);

		// eliminar un objeto perro del ArrayList
		// recorremos el array
		for (int i = 0; i < perros.size(); i++) {
			Perro pIteracion = perros.get(i);
			if ("Goofy".equals(pIteracion.getNombre())) {
				perros.remove(i);
				break; // salir del for
			}
		}

		// Perro peliminado = perros.remove(1);

		// Añadir a la clase Perro toString();
		for (Iterator iterator = perros.iterator(); iterator.hasNext();) {
			Perro txutxo = (Perro) iterator.next();
			System.out.println(txutxo);

		} // for

	}// main

}// class
