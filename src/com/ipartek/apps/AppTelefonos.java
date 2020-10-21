package com.ipartek.apps;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Telefono;

public class AppTelefonos {

	// Opciones menu
	static final String OP_LISTAR = "1";
	static final String OP_CREAR = "2";
	static final String OP_ELIMINAR = "3";
	static final String OP_MODIFICAR = "4";
	static final String OP_SALIR = "S";

	// Variables globales
	static Scanner sc = null;
	static ArrayList<Telefono> lista = new ArrayList<Telefono>();
	static String opcion = "";

	public static void main(String[] args) {

		System.out.println("*************  APP   TELEFONOS  *************");
		sc = new Scanner(System.in);

		inicializarDatos();

		do {

			pintarMenu();

			// Acciones segun la opcion elegida
			switch (opcion) {
			case OP_LISTAR:
				listarTelefono();
				break;

			case OP_CREAR:
				crearTelefono();
				break;

			case OP_ELIMINAR:
				bajaTelefono();
				break;

			case OP_MODIFICAR:
				modificarTelefono();
				break;

			// case OP_SALIR:
			// System.out.println("Adios ...");
			// salir = true;
			// break;

			default:
				System.out.println(" ** por favor selecciona una opción valida ** ");
				break;
			}// switch

		} while (!OP_SALIR.equalsIgnoreCase(opcion));

		System.out.println(("************************ ADIOS, nos vemos pronto  ***********"));

		sc.close();
	}// main

	private static void listarTelefono() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("++++  LISTADO  DE  TELEFONOS  ++++");
		System.out.println("----------------------------------");

		// TODO ver como dar una fixed length al string para nombre
		for (Telefono telefono : lista) {
			System.out.println(String.format("%15s [%s] %s GB", telefono.getNombre(), telefono.getSistemaOperativo(),
					telefono.getmemoria()));
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
		System.out.println("Introduce el teléfono que quires borrar:");
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

		final String OP_NOMBRE = "1";
		final String OP_SO = "2";
		final String OP_MEMORIA = "3";
		final String OP_SALIR = "S";

		boolean terminar = true;
		String nuevoNombre = "";
		String nuevoSO = "";

		// Mostramos un listado con los nombres de los Telefonos
		listarTelefono();

		// Pedimos que introduzca el nombre del telefono a modificar
		System.out.println("\n Introduce el Telefono que quieres modificar:");
		String nombreTelefonoModificar = sc.nextLine();

		do {

			pintarMenuModificar();

			switch (opcion) {
			case OP_NOMBRE:
				// Modificamos el nombre Telefono
				System.out.println("Introduzca nuevo nombre del telefono: " + nombreTelefonoModificar);
				nuevoNombre = sc.nextLine();
				break;

			case OP_SO:
				// Modificamos el Sistema Operativo Telefono
				System.out.println("Introduzca nuevo sistema operativo del telefono:" + nombreTelefonoModificar);
				nuevoSO = sc.nextLine();
				break;

			case OP_MEMORIA:
				break;

			case OP_SALIR:
				terminar = false;
				break;

			default:
				System.out.println(" ** por favor selecciona una opción valida ** ");
				break;
			}
		} while (terminar);

		// Modificamos la propiedad seleccionada del Telefono
		for (Telefono telefono : lista) {
			String nombreTelefono = telefono.getNombre();

			if (nombreTelefono.equalsIgnoreCase(nombreTelefonoModificar)) {

				switch (opcion) {
				case OP_NOMBRE:
					// reemplazar el nombre del Telefono en el objeto telefono
					telefono.setNombre(nuevoNombre);

					// reemplazar objeto telefono en la lista
					// No es necesario (es redundante). En memoria apuntan al mismo objeto de la
					// lista
					// lista.set(posicionLista, telefono);

					break;
				case OP_SO:
					telefono.setSistemaOperativo(nuevoSO);
				}// Switch

			} // End for
		}

		listarTelefono();

	}

	private static void pintarMenuModificar() {

		// Pedimos que valor quiere modificar
		System.out.println("");
		System.out.println("**************************");
		System.out.println(" 1.- Nombre");
		System.out.println(" 2.- Sistema Operativo");
		System.out.println(" 3.- Memoria");
		System.out.println(" S.- Salir");
		System.out.println("**************************");
		System.out.println("");

		System.out.println("\n No Selecciona una opción del menú:");

		opcion = sc.nextLine();
	}

	/**
	 * Inicializar el ArrayList para simular que existen telefonos.<br>
	 * En un futuro nos conectaremos a una BBDD
	 */
	private static void inicializarDatos() {

		lista.add(new Telefono("One Plus Nord", "Android 10", (int) 8));
		lista.add(new Telefono("iPhone 11", "iOS 14", (int) 32));
		lista.add(new Telefono("NOKIA 5110", "Symbian OS", (int) 1));
		lista.add(new Telefono("Samsumng Galaxy Note", "Android 9", (int) 16));
	}

	/**
	 * Se encarga de pintar las opciones dem menu.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void pintarMenu() {

		System.out.println("*******************************");
		System.out.println(" 1.- Listar todos los Teléfonos");
		System.out.println(" 2.- Crear un Teléfono");
		System.out.println(" 3.- Dar de baja un Teléfono");
		System.out.println(" 4.- Modificar un Teléfono");
		System.out.println(" S.- Salir");
		System.out.println("*******************************");

		System.out.println("\n Selecciona una opción del menú:");

		opcion = sc.nextLine();

	}

}// class
