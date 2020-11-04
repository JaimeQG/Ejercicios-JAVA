package com.ipartek.ifcd112.ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Libro;

/**
 * Realizar un programa para gestionar una librería.<br>
 * Un libro se compone de los siguientes campos ( id, nombre y número de páginas
 * ).<zbr> Hay que realizar una interfaz gráfica donde se muestre un menú con
 * las siguientes opciones: Listar todos los libros, dar de baja un libro,
 * modificar un libro y añadir uno nuevo.
 * 
 * @author Jaime Quintana
 * @version 1.0
 */

public class AppLibreria extends AppGestion {

	static final private String NOMBREPOJO = "Libros";

	static Scanner sc = null;

	// cuando usamos un patron singleton, el constructor es privado
	// deberemos usar el metodo getInstance();
	static private ImplLibroDao modelo = ImplLibroDao.getInstance();

	static String opcion = "";

	public static void main(String[] args) {

		boolean salir = false;

		System.out.println("************************************");
		System.out.println("*********  APP   LIBRERIA  *********");
		sc = new Scanner(System.in);

		do {
			pintarMenu(NOMBREPOJO);

			System.out.println("\n Selecciona una opción del menú:");
			opcion = sc.nextLine();

			switch (opcion) {
			case OP_LISTAR:
				listar();
				break;
			case OP_CREAR:
				crear();
				break;
			case OP_ELIMINAR:
				eliminar();
				break;
			case OP_MODIFICAR:
				modifcar();
				break;
			case OP_SALIR:
				salir = true;
				break;
			default:
				break;
			}
		} while (!salir);

		System.out.println(("*****  ADIOS, nos vemos pronto  ******"));

		sc.close();

	}// main

	private static void modifcar() {
		System.out.println("Todavia no está implementado ...");

	}

	/**
	 * Eliminar un Libro por su identificador
	 * 
	 * @param id int identificador
	 * @return true si elimina, false en caso contrario, por ejemplo si no existe el
	 *         id
	 */

	private static void eliminar() {
		// Mostramos un listado con los libros
		listar();

		// variables
		boolean flag = true;
		int id = 0;
		Libro lEliminar = null;

		do {

			try {
				id = validarEnteros("id"); // validamos que el identificador sea un numero
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Obtenemos el libro
			lEliminar = modelo.getById(id); // recuperamos el libro a suprimir dentro del ArrayList

			if (lEliminar == null) {
				System.out.println("*** Lo sentimos pero no existe ese libro");
			} else {
				flag = false;
			}

		} while (flag);

		// Pedimos confirmación sobre el borrado del libro
		// pedir confirmacion de nombre para eliminar
		flag = true;

		do {
			System.out.printf("Por favor escribe [%s] para eliminar o \"s\" para [S]alir\n", lEliminar.getNombre());
			String nombre = sc.nextLine();

			if (OP_SALIR.equalsIgnoreCase(nombre)) {
				break; // salimos del bucle

			} else { // comprobar nombre

				if (lEliminar.getNombre().equalsIgnoreCase(nombre)) {

					if (modelo.delete(id)) { // Si se borra el libro del HashMap
						flag = false;
						System.out.println("-------------------------------------");
						System.out.printf("Hemos dado de baja el libro: %s [%s paginas] \n", lEliminar.getNombre(),
								lEliminar.getNumeroPaginas());
						System.out.println("-------------------------------------");

					} else {
						System.out.println("No existe el libro con id=" + id);
						;
					}

				} else {
					System.out.println("**No coincide el nombre**");
				}
			}

		} while (flag);

	}

	/**
	 * Obtiene todos los libros ordenados Alfabeticamente
	 * 
	 * @return List<Libro>, si no existen libros Lista vacia pero no nula
	 */

	private static void listar() {
		ArrayList<Libro> libros = (ArrayList<Libro>) modelo.getAll();

		System.out.println("-------------------------------------");
		System.out.println("          LISTADO DE LIBROS   ");
		System.out.println("-------------------------------------");

		for (Libro libro : libros) {
			System.out.println(String.format("%2s %-17s ........... [%4s paginas] ", libro.getId(), libro.getNombre(),
					libro.getNumeroPaginas()));
		}

		System.out.println("-------------------------------------");
		System.out.println("TOTAL numero de libros en la lista: " + libros.size());
		System.out.println("-------------------------------------");

	}

	/**
	 * Inserta un nuevo Libro y actuliza su id
	 * 
	 * @param l Libro a crear con id == 0, despues de insertar lo debe actualizar
	 * @return true si lo crea, false si no puede, por ejemplo si ya existe el
	 *         nombre
	 */

	private static void crear() {
		// variables
		int numeroPaginas = 0;
		boolean isError = true;

		// pedimos datos del libro por consola: nombre y numero de paginas
		System.out.println("Introduzca nombre del libro: "); // nombre libro
		String nombre = sc.nextLine();

		try {
			numeroPaginas = validarEnteros("numeroPaginas");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Crear un libro con los atributos introducidos
		Libro lNuevo = new Libro(nombre, numeroPaginas);

		// llamar al modelo para guardar en el HashMap
		isError = true;

		do {

			if (modelo.insert(lNuevo)) {
				System.out.println("-------------------------------------");
				System.out.println("Libro guardado !!!");
				System.out.println(lNuevo);
				System.out.println("-------------------------------------");
				isError = false;
			} else {

				System.out.println(
						"No se ha podido crear el libro, el nombre: " + nombre + " ya existe. Por favor dime otro");
				nombre = sc.nextLine();
				lNuevo.setNombre(nombre);
			}

		} while (isError);

	}

	/**
	 * Valida que los datos introducidos por pantalla son de tipo int
	 * 
	 * @param nombre de la propiedad de tipo entero de la Clase Coche
	 * @return valor de tipo entero
	 */

	private static int validarEnteros(String propiedad) throws Exception {

		boolean isError = true;
		int intEntero = 0;

		// Repetir hasta que no haya error
		do {
			System.out.println("Introduzca el " + propiedad + " del libro: ");
			try {
				intEntero = Integer.parseInt(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				// e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (isError);

		return intEntero;
	}

}
