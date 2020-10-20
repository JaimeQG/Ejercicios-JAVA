package com.ipartek.apps;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Perro;

public class AppPerrera {

	// Variables globales

	static Scanner sc = null;
	static ArrayList<Perro> lista = new ArrayList<Perro>();
	static String opcion = "";

	public static void main(String[] args) {

		System.out.println("*************************  APP   PERRERA   ***********");
		sc = new Scanner(System.in);

		inicializarDatos();

		pintarMenu();

		// TODO cambiar "1","2","3" etc por constantes
		switch (opcion) {
		case "1":
			listar();
			break;
		case "2":
			crear();
			break;
		case "3":
			baja();
			break;
		case "4":
			modificar();
			break;
		case "5":
			System.out.println("Adios ...");
			break;
		default:
			break;
		}

		System.out.println(("************************ ADIOS, nos vemos pronto  ***********"));

		sc.close();
	}

	private static void listar() {
		for (Perro perro : lista) {
			// TODO dar formato para mostrar solo nombre y raza
			System.out.println("Nombre: " + perro.getNombre() + " - Raza: " + perro.getRaza());
		}
	}

	private static void crear() {
		String nombre = "";
		String raza = "";

		System.out.println("Introduzca nombre del perro: ");
		nombre = sc.nextLine();

		System.out.println("Introduzca raza del perro: ");
		raza = sc.nextLine();

		Perro p = new Perro();
		p.setNombre(nombre);
		p.setRaza(raza);

		// insertar valores en el ArrayList
		lista.add(p);

	}

	private static void baja() {

		// Mostramos un listado con los nombres de los perros
		listar();

		// Pedimos que introduzca el nombre del perro
		System.out.println("Introduce el perro que quires borrar");
		String nombre = sc.nextLine();

		//
		for (Perro perro : lista) {
			String nombrePerro = perro.getNombre();

			if (nombrePerro.equalsIgnoreCase(nombre)) {
				lista.remove(perro);
				break;
			}
		} // End for

	}

	private static void modificar() {
		// Mostramos un listado con los nombres de los perros
		listar();

		// Pedimos que introduzca el nombre del perro
		System.out.println("Introduce el perro que quieres modificar");
		String nombre = sc.nextLine();

		Perro p = new Perro(nombre);

		// Pedimos que valor quiere modificar
		System.out.println("");
		System.out.println("**************************");
		System.out.println(" 1.- Nombre");
		System.out.println(" 2.- Raza");
		System.out.println("**************************");
		System.out.println("");

		System.out.println("\n Selecciona una opción del menú:");

		String opcionModificacion = "";
		opcionModificacion = sc.nextLine();

		switch (opcionModificacion) {
		case "1":
			// Modificamos el nombre
			String nuevoNombre = sc.nextLine();
			p.setNombre(nuevoNombre);
			break;

		default:
			break;
		}

		//
		for (Perro perro : lista) {
			String nombrePerro = perro.getNombre();

			if (nombrePerro.equalsIgnoreCase(nombre)) {
				lista.remove(perro);
				break;
			}
		} // End for

	}

	/**
	 * Inicializar el ArrayList para simular que existen perror. <br>
	 * En un futuro nos conectaremos a una BBDD
	 */
	private static void inicializarDatos() {
		// TODO Auto-generated method stub
		lista.add(new Perro("Bubba"));
		lista.add(new Perro("Laika"));
		lista.add(new Perro("Rintintin"));
		lista.add(new Perro("goffy"));
	}

	/**
	 * Se encarga de pintar las opciones dem menu.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void pintarMenu() {
		System.out.println("**************************");
		System.out.println(" 1.- Listar todos los perros");
		System.out.println(" 2.- Crear un perro");
		System.out.println(" 3.- Dar de baja un perro");
		System.out.println(" 4.- Modificar un perro");
		System.out.println(" 5.- Salir");
		System.out.println("**************************");

		System.out.println("\n Selecciona una opción del menú:");

		// TODO gestionar errores
		boolean isError = true;

		do {
			try {
				opcion = sc.nextLine();

				// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
				System.out.println("Tu opcion es: " + opcion);
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				// e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (isError);

	}// main

}// class
