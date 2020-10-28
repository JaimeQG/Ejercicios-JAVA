package com.ipartek.ejercicios.listas;

import java.util.ArrayList;
import java.util.Random;

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
	private static final String CARTA_AS = "as";
	private static int CARTA_VALOR_AS = 1;

	private static final String CARTA_SOTA = "sota";
	private static final String CARTA_CABALLO = "caballo";
	private static final String CARTA_REY = "rey";

	private static final String PALOS_BARAJA[] = { "Oros", "Copas", "Espadas", "Bastos" };
	private static final String VALOR_CARTA[] = { "as", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey" };

	static final ArrayList<Carta> baraja = new ArrayList<Carta>();

	public static void main(String[] args) {

		// Damos de alta las cartas en el ArrayList de cartas
		for (int i = 0; i < PALOS_BARAJA.length; i++) {

			for (int j = 0; j < VALOR_CARTA.length; j++) {

				Carta c = new Carta(PALOS_BARAJA[i], VALOR_CARTA[j]);
				baraja.add(c);
			}
		}

		// Listado de las Cartas despues de crear la baraja
		System.out.println("***  LISTADO DE CARTAS   ***");

		for (Carta c : baraja) {

			System.out.printf("%s de %s %n", c.getValor(), c.getPalo());
		}

		// Mezclamos las cartas
		Random rnd = new Random();

		for (int i = 0; i < baraja.size(); i++) {
			int azar = rnd.nextInt(baraja.size());
			// eliminar por indice
			Carta c = baraja.remove(azar);
			// insertar en el arrayList la carta borrada
			baraja.add(c);
		}

		// Mezclamos las cartas
		// Collections.shuffle(baraja);

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
