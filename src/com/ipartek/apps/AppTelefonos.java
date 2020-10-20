package com.ipartek.apps;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Telefono;

public class AppTelefonos {

	// Variables globales
	static final String LISTAR_TELEFONOS = "1";
	static final String CREAR_TELEFONO = "2";
	static final String BAJA_TELEFONO = "3";
	static final String MODIFICAR_TELEFONO = "4";
	static final String SALIR = "5";

	static Scanner sc = null;
	static ArrayList<Telefono> lista = new ArrayList<Telefono>();
	static String opcion = "";

	public static void main(String[] args) {

		System.out.println("*************  APP   TELEFONOS  *************");
		sc = new Scanner(System.in);

		inicializarDatos();

		pintarMenu();

		// Acciones segun la opcion elegida
		switch (opcion) {
		case LISTAR_TELEFONOS:
			listarTelefono();
			break;

		case CREAR_TELEFONO:
			crearTelefono();
			break;

		case BAJA_TELEFONO:
			bajaTelefono();
			break;

		case MODIFICAR_TELEFONO:
			modificarTelefono();
			break;

		case SALIR:
			System.out.println("Adios ...");
			break;

		default:
			break;
		}

		System.out.println(("************************ ADIOS, nos vemos pronto  ***********"));

		sc.close();
	}// main

	private static void listarTelefono() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("++++  LISTADO  DE  TELEFONOS  ++++");
		System.out.println("----------------------------------");

		for (Telefono telefono : lista) {

			System.out.println(telefono.getNombre() + " - S.O.: " + telefono.getSistemaOperativo());
		}
		System.out.println("");
	}

	private static void crearTelefono() {

		String nombre = "";
		String sistemaOperativo = "";

		// Pedimos nombre Telefono
		System.out.println("Introduzca nombre del teléfono: ");
		nombre = sc.nextLine();

		// Pedimos Sistema Operativo Telefono
		System.out.println("Introduzca Sistema Operativo: ");
		sistemaOperativo = sc.nextLine();

		// Construimos objeto Telefono con los datos introducidos por pantalla
		Telefono telefono = new Telefono();
		telefono.setNombre(nombre);
		telefono.setSistemaOperativo(sistemaOperativo);

		// insertar valores en el ArrayList
		lista.add(telefono);

	}

	private static void bajaTelefono() {

		// Mostramos un listado con los nombres de los Telefonos
		listarTelefono();

		// Pedimos que introduzca el nombre del perro
		System.out.println("Introduce el perro que quires borrar");
		String nombre = sc.nextLine();

		//
		for (Telefono telefono : lista) {
			String nombreTelefono = telefono.getNombre();

			if (nombreTelefono.equalsIgnoreCase(nombre)) {
				lista.remove(telefono);
				break;
			}
		} // End for

		listarTelefono();
	}

	private static void modificarTelefono() {

		// Mostramos un listado con los nombres de los Telefonos
		listarTelefono();

		// Pedimos que introduzca el nombre del telefono a modificar
		System.out.println("\n Introduce el Telefono que quieres modificar:");
		String nombreAnterior = sc.nextLine();

		System.out.println("\n Introduzca nuevo nombre del telefono:");
		String nuevoNombre = sc.nextLine();

		int posicionLista = 0;

		for (Telefono telefono : lista) {
			String nombreTelefono = telefono.getNombre();

			if (nombreTelefono.equalsIgnoreCase(nombreAnterior)) {

				// reemplazar el nombre del Telefono en el objeto telefono
				telefono.setNombre(nuevoNombre);

				// reemplazar objeto telefono en la lista
				lista.set(posicionLista, telefono);

				break;
			}
			posicionLista++;
		} // End for

		listarTelefono();

		// Pedimos que valor quiere modificar
		System.out.println("");
		System.out.println("**************************");
		System.out.println(" 1.- Nombre");
		System.out.println(" 2.- Sistema Operativo");
		System.out.println("**************************");
		System.out.println("");

		System.out.println("\n Selecciona una opción del menú:");

		String opcionModificacion = "";
		opcionModificacion = sc.nextLine();

		switch (opcionModificacion) {
		case "1":
			// Modificamos el nombre Telefono
			System.out.println("Introduzca nuevo nombre del telefono:");
			// String nuevoNombre = sc.nextLine();
			// telefono.setNombre(nuevoNombre);

			listarTelefono();
			break;

		default:
			break;
		}

	}

	/**
	 * Inicializar el ArrayList para simular que existen perror. <br>
	 * En un futuro nos conectaremos a una BBDD
	 */
	private static void inicializarDatos() {
		// TODO Auto-generated method stub
		lista.add(new Telefono("One Plus Nord", "Android 10", (float) 6.44));
		lista.add(new Telefono("iPhone 11", "iOS 14", (float) 6.44));
		lista.add(new Telefono("NOKIA 5110", "Symbian OS", (float) 2.33));
		lista.add(new Telefono("Samsumng Galaxy Note", "Android 9", (float) 6.3));
	}

	/**
	 * Se encarga de pintar las opciones dem menu.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void pintarMenu() {

		// TODO gestionar errores
		int a = 0;
		boolean isError = true;

		System.out.println("*******************************");
		System.out.println(" 1.- Listar todos los Teléfonos");
		System.out.println(" 2.- Crear un Teléfono");
		System.out.println(" 3.- Dar de baja un Teléfono");
		System.out.println(" 4.- Modificar un Teléfono");
		System.out.println(" 5.- Salir");
		System.out.println("*******************************");

		System.out.println("\n Selecciona una opción del menú:");

		do {
			try {
				opcion = sc.nextLine();

				a = Integer.parseInt(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo unca se ejecutaran
				System.out.println("Tu opcion es: " + opcion);
				isError = false;
			} catch (NumberFormatException e) {
				System.out.println("Introducir números del 1 al 5");
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				// e.printStackTrace();
				System.out.println("*** error, no es un numero valido");
			}
		} while (isError);
	}

}// class
