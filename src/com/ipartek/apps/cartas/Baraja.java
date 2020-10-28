package com.ipartek.apps.cartas;

import java.util.ArrayList;

public abstract class Baraja {

	private ArrayList<Carta2> mazo;

	public Baraja() {
		super();
		this.mazo = new ArrayList<Carta2>();
	}

	public ArrayList<Carta2> getMazo() {
		return mazo;
	}

	public void setMazo(ArrayList<Carta2> mazo) {
		this.mazo = mazo;
	}

	/**
	 * Crear todas las cartes necesarias de la Baraja Hija
	 */
	abstract void crear();

	/**
	 * Muestra por consola todas las cartas del mazo
	 */
	void mostrar() {

		for (Carta2 c : getMazo()) {

			System.out.printf("%s de %s %n", c.getNumero().getNombre(), c.getPalo().getNombre());

		}
		System.out.println("------------------------------------------------");
		System.out.printf(" Total %s Cartas en le mazo \n", getMazo().size());
		System.out.println("------------------------------------------------");

	}

	void ordenarPalo() {
		// TODO con sysos
	}

	void ordenarNumero() {
		// TODO con sysos
	}

	void barajar() {
		// TODO con sysos
	}

}
