package com.ipartek.apps;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.modelo.PerroDAOArrayList;
import com.ipartek.modelo.PerroDAOSqlite;
import com.ipartek.modelo.PerroDao;
import com.ipartek.pojo.Perro;

public class AppPerrera {

	// Opciones menu principal
	static final private String OP_LISTAR = "1";
	static final private String OP_CREAR = "2";
	static final private String OP_BAJA = "3";
	static final private String OP_MODIFICAR = "4";
	static final private String OP_SALIR = "S";

	// Opciones menu Modificar
	static final private String OP_NOMBRE = "1";
	static final private String OP_RAZA = "2";

	static Scanner sc = null;
	// static private PerroDAOArrayList modelo = new PerroDAOArrayList();

	// static private PerroDAOSqlite modelo = new PerroDAOSqlite();
	// cuando usamos un patron singleton, el constructor es privado
	// static private PerroDao modelo = new PerroDAOSqlite();
	// deberemos usar el metodo getInstance();
	// static private PerroDao modelo = PerroDAOSqlite.getInstance();
	static private PerroDao modelo = PerroDAOArrayList.getInstance();

	static String opcion = "";

	public static void main(String[] args) {

		boolean salir = false;

		System.out.println("*************************  APP   PERRERA   ***********");
		sc = new Scanner(System.in);

		inicializarDatos();

		do {
			pintarMenu();

			switch (opcion) {
			case OP_LISTAR:
				listar();
				break;
			case OP_CREAR:
				crear();
				break;
			case OP_BAJA:
				baja();
				break;
			case OP_MODIFICAR:
				modificar();
				break;
			case OP_SALIR:
				System.out.println("Adios ...");
				salir = true;
				break;
			default:
				break;
			}
		} while (!salir);

		System.out.println(("************************ ADIOS, nos vemos pronto  ***********"));

		sc.close();
	}

	private static void listar() {

		// TODO ver como dar una fixed lenght al String para nombre
		ArrayList<Perro> perros = modelo.listar();
		for (Perro perro : perros) {
			System.out.println(String.format("%3s %9s [%11s] %4s Kg %13s %s", perro.getId(), perro.getNombre(),
					perro.getRaza(), Math.round(perro.getPeso() * 100.0) / 100.0,
					(perro.isVacunado()) ? "vacunado" : "*sin Vacunar*", perro.getHistoria()));
		}

		// Este DAO se encarga de realizara la operaciones de CRUD contra la bbdd
		// PerroDAOSqlite dao = new PerroDAOSqlite();
		PerroDAOSqlite dao = PerroDAOSqlite.getInstance();
		System.out.println("-------------------------------------");
		System.out.println("TOTAL numero de perros en la BBDD: " + dao.countDBRows());
		System.out.println("-------------------------------------");
	}

	private static void crear() {

		// pedimos datos por consola
		System.out.println("Introduzca nombre del perro: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca raza del perro (si no la sabes es 'cruce'): ");
		String raza = sc.nextLine(); // si no introducimos la raza la deja vacia y deberia ser 'cruce'
										// se valida en el setter de raza
		// Pedir el peso del perro, repetir hasta que no haya error
		boolean isError = true;
		float peso = 0f;

		do {
			try {
				System.out.println("Peso en Kg:");
				peso = Float.parseFloat(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				// e.printStackTrace();
				System.out.println("**error, no es un peso valido. Escribe un numero y usa puntos en vz de  comas");
			}
		} while (isError);

		System.out.println("¿Está vacunado? [Si/No]");
		boolean isVacunado = ("s".equalsIgnoreCase(sc.nextLine())) ? true : false;

		System.out.println("Cuentame su historia (no es obligatorio)");
		String historia = sc.nextLine();

		// Crear un perro y setear valores
		Perro pNuevo = new Perro(nombre, raza, peso);
		pNuevo.setVacunado(isVacunado);
		pNuevo.setHistoria(historia);

		// llamar al modelo para guardar en la bbdd
		isError = true;

		do {
			try {
				modelo.crear(pNuevo);
				System.out.println("Perro guardado");
				System.out.println(pNuevo);
				isError = false;
			} catch (Exception e) {
				System.out.println(
						"No se ha podido crear el perro, el nombre: " + nombre + " ya existe. Por favor dime otro");
				nombre = sc.nextLine();
				pNuevo.setNombre(nombre);
				// e.printStackTrace();
			}
		} while (isError);

	}

	private static void baja() {

		// Mostramos un listado con los perros
		listar();

		// variables
		boolean flag = true;
		boolean isError = true;
		int id = 0;
		Perro pEliminar = null;

		do {
			do {
				try {
					System.out.println("Introduce el ID del perro que quieres borrar");
					id = Integer.parseInt(sc.nextLine());

					// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
					isError = false;
				} catch (Exception e) {
					// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
					// e.printStackTrace();
					System.out.println("**error, no es un peso valido. Escribe un numero");
				}
			} while (isError);

			// PerroDAOSqlite dao = new PerroDAOSqlite();
			// PerroDAOSqlite dao = PerroDAOSqlite.getInstance();
			// pEliminar = dao.recuperar(id);

			pEliminar = modelo.recuperar(id);

			// pEliminar = modelo.recuperar(id);
			if (pEliminar == null) {
				System.out.println("*Lo sentimos pero no existe ese perro");
			} else {
				flag = false;
			}

		} while (flag);

		// Pedimos confirmación sobre el borrado del perro de la BBDD
		// pedir confirmacion de nombre para eliminar
		flag = true;

		do {
			System.out.printf("Por favor escribe [%s] para eliminar o \"s\" para [S]alir\n", pEliminar.getNombre());
			String nombre = sc.nextLine();

			if (OP_SALIR.equalsIgnoreCase(nombre)) {
				break; // salimos del bucle

			} else { // comprobar nombre

				if (pEliminar.getNombre().equalsIgnoreCase(nombre)) {

					try {
						modelo.eliminar(id);
						flag = false;
						System.out.println("Hemos dado de baja al perro");

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("**No coincide el nombre**");
				}
			}

		} while (flag);

	}

	private static void modificar() {
		// Mostramos un listado con los nombres de los perros
		listar();

		// variables
		boolean flag = true;
		boolean isError = true;
		int id = 0;
		Perro pModificar = null;

		do {
			do {
				try {
					System.out.println("Introduce el ID del perro que quieres modificar");
					id = Integer.parseInt(sc.nextLine());

					// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
					isError = false;
				} catch (Exception e) {
					// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
					// e.printStackTrace();
					System.out.println("**error, no es un peso valido. Escribe un numero");
				}
			} while (isError);

			// PerroDAOSqlite dao = new PerroDAOSqlite();
			// PerroDAOSqlite dao = PerroDAOSqlite.getInstance();
			// pModificar = dao.recuperar(id);

			pModificar = modelo.recuperar(id);

			// pEliminar = modelo.recuperar(id);
			if (pModificar == null) {
				System.out.println("*Lo sentimos pero no existe ese perro");
			} else {
				flag = false;
			}

		} while (flag);

		// Pedimos que introduzca el nombre del perro
		// System.out.println("Introduce el perro que quieres modificar");

		System.out.println(String.format("%3s %9s [%11s] %4s Kg %13s %s", pModificar.getId(), pModificar.getNombre(),
				pModificar.getRaza(), Math.round(pModificar.getPeso() * 100.0) / 100.0,
				(pModificar.isVacunado()) ? "vacunado" : "*sin Vacunar*", pModificar.getHistoria()));

		// Pedimos que valor quiere modificar
		System.out.println("");
		System.out.println("-------------------");
		System.out.println("---   Modicar   ---");
		System.out.println("-------------------");
		System.out.println(" 1.- Nombre");
		System.out.println(" 2.- Raza");
		System.out.println("");
		System.out.println(" S.- Salir");
		System.out.println("-------------------");
		System.out.println("");

		System.out.println("\n Selecciona una opción del menú:");

		String opcionModif = "";
		opcionModif = sc.nextLine();

		switch (opcionModif) {
		case OP_NOMBRE:
			// Modificamos el nombre
			System.out.println("Introduce nuevo nombre del perro:");
			String nuevoNombre = sc.nextLine();

			try {
				pModificar.setNombre(nuevoNombre);
				((PerroDAOSqlite) modelo).modificarCampo(pModificar, "nombre");
				System.out.println("Nombre Perro modificado");
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case OP_RAZA:
			// Modificamos la raza
			System.out.println("Introduce nueva raza del perro:");
			String nuevaRaza = sc.nextLine();

			try {
				pModificar.setRaza(nuevaRaza);
				((PerroDAOSqlite) modelo).modificarCampo(pModificar, "raza");
				System.out.println("Raza Perro modificada");
			} catch (Exception e) {
				e.printStackTrace();
			}
		case OP_SALIR:
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

		// Inicializamos el ArrayList con 4 perros
		/*
		 * try { modelo.crear(new Perro(1, "Bubba")); modelo.crear(new Perro(2,
		 * "Laika")); modelo.crear(new Perro(3, "Rintintin")); modelo.crear(new Perro(4,
		 * "goffy")); } catch (Exception e) { e.printStackTrace(); }
		 */

		// Este DAO se encarga de realizara la operaciones de CRUD contra la bbdd
		// PerroDAOSqlite dao = new PerroDAOSqlite();
		PerroDAOSqlite dao = PerroDAOSqlite.getInstance();

		int intNumero = dao.getLastId() + 1;
		System.out.println("dao.getLastId() + 1 " + intNumero);
		String nombrePerro = "Perro" + intNumero;
		Float pesoPerro = 34.5f / (float) intNumero;

		boolean vacunaPerro = false;
		String razaPerro = "pedigri";

		if (intNumero % 2 == 0) {
			vacunaPerro = true;
		} else {
			vacunaPerro = false;
		}

		Perro pNuevo = new Perro(nombrePerro, razaPerro, pesoPerro);
		pNuevo.setVacunado(vacunaPerro);
		pNuevo.setHistoria("La historia de " + nombrePerro + " ...");

		try {
			dao.crear(pNuevo); // insert
		} catch (Exception e) {
			System.out.printf("** el nombre del perro %s ya existe \n", pNuevo.getNombre());
		}

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
		System.out.println(" S.- Salir");
		System.out.println("**************************");

		System.out.println("\n Selecciona una opción del menú:");

		opcion = sc.nextLine();
	}

}// class
