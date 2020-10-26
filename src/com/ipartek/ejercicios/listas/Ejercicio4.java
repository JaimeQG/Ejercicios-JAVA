package com.ipartek.ejercicios.listas;

import java.util.ArrayList;

import com.ipartek.pojo.Carta;

/**
 * Crear una lista que contenga las cuarenta cartas de una baraja. Para crear
 * dicha lista se creara una clase de tipo carta, que tendr� un n�mero entero
 * para el valor de la carta, as� como un string con el palo de la baraja
 * (copas, espadas, oros, bastos).<br>
 * Crear la baraja con las cartas ordenadas por palos, y luego por n�meros.<br>
 * Barajar dicha baraja y mostrar las cartas.
 * 
 * 
 * @author Jaime Quintana
 * @version 1.0
 *
 */

public class Ejercicio4 {

	// Constantes globales
	static final String PALOS_BARAJA[] = { "Oros", "Copas", "Espadas", "Bastos" };
	static final int VALOR_CARTA[] = { 1, 2, 3, 4, 5, 6, 7, 10, 11, 12 };

	static final ArrayList<Carta> baraja = new ArrayList<Carta>();

	public static void main(String[] args) {

		// Damos de alta las cartas en el ArrayList de cartas
		for (int i = 0; i < PALOS_BARAJA.length; i++) {

			for (int j = 0; j < VALOR_CARTA.length; j++) {
				Carta c = new Carta();

				c.setPalo(PALOS_BARAJA[i]);
				c.setValor(VALOR_CARTA[j]);
				// System.out.println(c);
				baraja.add(c);
			}
		}

		// Listado de las Cartas despues de crear la baraja
		for (Carta c : baraja) {
			System.out.println(c);
		}

	}

}