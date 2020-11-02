package com.ipartek.apps;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.modelo.PerroDAOSqlite;
import com.ipartek.pojo.Perro;

public class AppPerrera {

	// Opciones menu principal
	static final private String OP_LISTAR = "1";
	static final private String OP_CREAR = "2";
	static final private String OP_BAJA = "3";
	static final private String OP_MODIFICAR = "4";
	static final private String OP_SALIR = "S";

	static Scanner sc = null;
	// static private PerroDAOArrayList modelo = new PerroDAOArrayList();
	// static private PerroDao modelo = new PerroDAOSqlite();
	static private PerroDAOSqlite modelo = new PerroDAOSqlite();
	static ArrayList<Perro> lista = new ArrayList<Perro>();
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
		PerroDAOSqlite dao = new PerroDAOSqlite();
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

		System.out.println("�Est� vacunado? [Si/No]");
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

		// validamos que introduzca un id de perro correcto
		boolean flag = true;
		boolean isError = true;
		int id = 0;
		Perro pEliminar = null;

		do {
			do {
				try {
					System.out.println("Introduce el ID del perro que quires borrar");
					id = Integer.parseInt(sc.nextLine());

					// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
					isError = false;
				} catch (Exception e) {
					// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
					// e.printStackTrace();
					System.out.println("**error, no es un peso valido. Escribe un numero");
				}
			} while (isError);

			PerroDAOSqlite dao = new PerroDAOSqlite();
			pEliminar = dao.recuperar(id);

			// pEliminar = modelo.recuperar(id);
			if (pEliminar == null) {
				System.out.println("*Lo sentimos pero no existe ese perro");
			} else {
				flag = false;
			}

		} while (flag);

		// Pedimos confirmaci�n sobre el borrado del perro de la BBDD
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

		System.out.println("\n Selecciona una opci�n del men�:");

		String opcionModificacion = "";
		opcionModificacion = sc.nextLine();

		switch (opcionModificacion) {
		case "1":
			// Modificamos el nombre
			String nuevoNombre = sc.nextLine();
			p.setNombre(nuevoNombre);

			System.out.println();
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

		// Inicializamos el ArrayList con 4 perros
		lista.add(new Perro("Bubba"));
		lista.add(new Perro("Laika"));
		lista.add(new Perro("Rintintin"));
		lista.add(new Perro("goffy"));

		// Este DAO se encarga de realizara la operaciones de CRUD contra la bbdd
		PerroDAOSqlite dao = new PerroDAOSqlite();

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

		System.out.println("\n Selecciona una opci�n del men�:");

		opcion = sc.nextLine();
	}

}// class
