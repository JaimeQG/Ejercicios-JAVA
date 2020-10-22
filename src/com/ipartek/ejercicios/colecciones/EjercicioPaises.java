package com.ipartek.ejercicios.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Ejercicio para aprender los metodos basicos de java.util.ArrayList
 * 
 * @author Jiame
 * @author usuario
 *
 */

public class EjercicioPaises {

	public static void main(String[] args) {

		// Son dinamicos y pueden crecer
		ArrayList<String> paises = new ArrayList<String>();

		// insertar
		paises.add("Brasil");
		paises.add("España");
		paises.add("Andorra");
		paises.add("Barakaldo");
		paises.add("Guinea Bisau");
		paises.add("Barakaldo");
		paises.add("Barakaldo");
		paises.add("Barakaldo");

		// insertar en una posicion
		paises.add(1, "Francia");

		// reemplazar
		paises.set(1, "EH");

		// eliminar por indice
		paises.remove(1);

		// eliminar por Objeto (elimina solamente el primero)
		paises.remove("Barakaldo");

		// recuperar un pais
		String s = paises.get(0);

		// recuperar longitud
		paises.size();

		// posicion de un objeto dentro de un array
		int posicion = paises.indexOf("Andorra");

		// recorrer para mostrar con Iterator
		for (Iterator iterator = paises.iterator(); iterator.hasNext();) {
			String pais = (String) iterator.next();
			System.out.println(pais);

		}

	}// main

}// class
