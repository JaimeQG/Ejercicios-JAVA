package com.ipartek.ejercicios.listas;

import java.util.ArrayList;
import java.util.Collections;

import com.ipartek.pojo.Carta;

/**
 * Crear una lista que contenga las cuarenta cartas de una baraja. Para crear
 * dicha lista se creara una clase de tipo carta, que tendrá un número entero
 * para el valor de la carta, así como un string con el palo de la baraja
 * (copas, espadas, oros, bastos).<br>
 * Crear la baraja con las cartas ordenadas por palos, y luego por números.<br>
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
	static final String VALOR_CARTA[] = { "as", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey" };

	static final ArrayList<Carta> baraja = new ArrayList<Carta>();

	public static void main(String[] args) {

		// Damos de alta las cartas en el ArrayList de cartas
		for (int i = 0; i < PALOS_BARAJA.length; i++) {

			for (int j = 0; j < VALOR_CARTA.length; j++) {

				Carta c = new Carta(PALOS_BARAJA[i], VALOR_CARTA[j]);

				// c.setPalo(PALOS_BARAJA[i]);
				// c.setValor(VALOR_CARTA[j]);
				// System.out.println(c);
				baraja.add(c);
			}
		}

		System.out.println("***  LISTADO DE CARTAS   ***");
		// Listado de las Cartas despues de crear la baraja
		for (Carta c : baraja) {

			System.out.printf("%s de %s %n", c.getValor(), c.getPalo());
			// System.out.println(c);
		}

		// Mezclamos las cartas
		Collections.shuffle(baraja);

		System.out.println("");
		System.out.println("***  LISTADO DE DESPUES DE BARAJAR   ***");
		// Listado de las Cartas despues de barajar la baraja
		for (Carta c : baraja) {
			System.out.printf("%s de %s %n", c.getValor(), c.getPalo());
			// System.out.println(c);
		}

		System.out.println("------------------------------------------------");
		System.out.printf(" Total %s Cartas en el mazo \n", baraja.size());
		System.out.println("------------------------------------------------");
	}

}
