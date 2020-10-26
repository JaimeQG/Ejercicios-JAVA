package com.ipartek.ejercicios.listas;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Jugador;

/**
 * Crear una lista de jugadores de futbol. En dicha lista se guardaran objetos
 * de la clase Jugador, que tendrá los atributos nombre, de tipo Sting y dorsal
 * de tipo int.<br>
 * Solicitar los datos de los jugadores por teclado, y una vez introducido el
 * primero, se insertara en la lista y se preguntara si se desea introducir otro
 * más, para lo cual el usuario escribirá S o N. En caso afirmativo se volverá a
 * pedir otro más, hasta que el usuario escriba N
 * 
 * @author Jaime Quintana
 * @version 1.0
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

		String nombreJugador = "";
		int dorsalJugador = 0;
		String respuesta = "";

		Scanner sc = new Scanner(System.in);

		// Nombre del jugador
		System.out.println("Nombre del jugador:");
		nombreJugador = sc.nextLine();

		// Dorsal del jugador
		System.out.println("Dorsal del jugador:");
		try {
			dorsalJugador = Integer.parseInt(sc.nextLine());

		} catch (Exception e) {
			// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
			e.printStackTrace();
			System.out.println("Error genérico");
		}

		// Objeto de la clase jugador
		Jugador jugador = new Jugador();
		jugador.setNombre(nombreJugador);
		jugador.setDorsal(dorsalJugador);

		// Insertamos jugador en la lista
		listaJugadores.add(jugador);

		System.out.println("¿Quieres introducir un nuevo jugador?");
		System.out.println("Si (S) / No (N)");
		respuesta = sc.nextLine();

		do {
			System.out.println("Respuesta: " + respuesta);
		} while (respuesta == "S");

		sc.close();
	}

}
