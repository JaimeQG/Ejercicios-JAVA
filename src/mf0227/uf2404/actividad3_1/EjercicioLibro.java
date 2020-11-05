package mf0227.uf2404.actividad3_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Realizar un programa para gestionar una librería. <br>
 * Un libro se compone de los siguientes campos ( id, nombre y número de páginas
 * ).<br>
 * Hay que realizar una interfaz gráfica donde se muestre un menú con las
 * siguientes opciones: Listar todos los libros, dar de baja un libro, modificar
 * un libro y añadir uno nuevo.
 * 
 * @author Jaime Quintana
 * @version 1.0
 * 
 */

public class EjercicioLibro {

	// Opciones menu principal
	static final private String OP_LISTAR = "1";
	static final private String OP_CREAR = "2";
	static final private String OP_SUPRIMIR = "3";
	static final private String OP_MODIFICAR = "4";
	static final private String OP_SALIR = "S";

	static Scanner sc = null;
	// cuando usamos un patron singleton, el constructor es privado
	// deberemos usar el metodo getInstance();
	static private LibroDAOArrayList modelo = LibroDAOArrayList.getInstance();

	static String opcion = "";

	public static void main(String[] args) {
		boolean salir = false;

		System.out.println("****************************************");
		System.out.println("***********  APP   LIBRERIA  ***********");
		sc = new Scanner(System.in);

		do {
			pintarMenu();

			switch (opcion) {
			case OP_LISTAR:
				listar();
				break;
			case OP_CREAR:
				crear();
				break;
			case OP_SUPRIMIR:
				suprimir();
				break;
			case OP_MODIFICAR:
				modificar();
				break;
			case OP_SALIR:
				salir = true;
				break;
			default:
				break;
			}
		} while (!salir);

		System.out.println(("******  ADIOS, nos vemos pronto  *******"));

		sc.close();
	}

	/**
	 * Se encarga de pintar las opciones del menu.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void pintarMenu() {
		System.out.println("****************************************");
		System.out.println(" [1].- Listar todos los libros");
		System.out.println(" [2].- Crear un libro");
		System.out.println(" [3].- Dar de baja un libro");
		System.out.println(" [4].- Modificar un libro");
		System.out.println(" [S].- Salir");
		System.out.println("****************************************");

		System.out.println("\n Selecciona una opción del menú:");

		opcion = sc.nextLine();
	}

	/**
	 * Se encarga de sacar por pantalla el listado de libros.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void listar() {

		ArrayList<LibroPrueba> libros = modelo.listar();

		System.out.println("-------------------------------------");
		System.out.println("          LISTADO DE LIBROS   ");
		System.out.println("-------------------------------------");

		for (LibroPrueba libro : libros) {
			System.out.println(String.format("%2s %-15s ........... [%4s paginas] ", libro.getId(), libro.getNombre(),
					libro.getNumeroPaginas()));
		}

		System.out.println("-------------------------------------");
		System.out.println("TOTAL numero de libros en la lista: " + libros.size());
		System.out.println("-------------------------------------");

	}

	/**
	 * Se encarga de crear un objeto libro y añadirlo al
	 * ArrayList{@code <libro>}.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void crear() {
		// variables
		int numeroPaginas = 0;
		boolean isError = true;

		// pedimos datos por consola
		System.out.println("Introduzca nombre del libro: "); // nombre libro
		String nombre = sc.nextLine();

		try {
			numeroPaginas = validarEnteros("numeroPaginas");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Crear un libro y setear valores
		LibroPrueba lNuevo = new LibroPrueba(nombre, numeroPaginas);

		// llamar al modelo para guardar en la bbdd
		isError = true;

		do {
			try {
				modelo.crear(lNuevo);
				System.out.println("-------------------------------------");
				System.out.println("Libro guardado");
				System.out.println(lNuevo);
				System.out.println("-------------------------------------");
				isError = false;
			} catch (Exception e) {
				System.out.println(
						"No se ha podido crear el libro, el nombre: " + nombre + " ya existe. Por favor dime otro");
				nombre = sc.nextLine();
				lNuevo.setNombre(nombre);
				// e.printStackTrace();
			}
		} while (isError);
	}

	/**
	 * Se encarga de suprimir un objeto libro del ArrayList{@code <libro>}.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void suprimir() {
		// Mostramos un listado con los libros
		listar();

		// variables
		boolean flag = true;
		boolean isError = true;
		int id = 0;
		LibroPrueba lEliminar = null;

		do {
			do {
				try {
					System.out.println("Introduce el ID del libro que quieres borrar");
					id = Integer.parseInt(sc.nextLine());

					// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
					isError = false;
				} catch (Exception e) {
					// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
					// e.printStackTrace();
					System.out.println("**error, no es un numero valido. Escribe un numero");
				}
			} while (isError);

			lEliminar = modelo.recuperar(id); // recuperamos el libro a suprimir dentro del ArrayList

			if (lEliminar == null) {
				System.out.println("*** Lo sentimos pero no existe ese libro");
			} else {
				flag = false;
			}

		} while (flag);

		// Pedimos confirmación sobre el borrado del libro del ArrayList
		// pedir confirmacion de nombre para eliminar
		flag = true;

		do {
			System.out.printf("Por favor escribe [%s] para eliminar o \"s\" para [S]alir\n", lEliminar.getNombre());
			String nombre = sc.nextLine();

			if (OP_SALIR.equalsIgnoreCase(nombre)) {
				break; // salimos del bucle

			} else { // comprobar nombre

				if (lEliminar.getNombre().equalsIgnoreCase(nombre)) {

					try {
						modelo.eliminar(id);
						flag = false;
						System.out.println("-------------------------------------");
						System.out.printf("Hemos dado de baja el libro: %s [%s paginas] \n", lEliminar.getNombre(),
								lEliminar.getNumeroPaginas());
						System.out.println("-------------------------------------");

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("**No coincide el nombre**");
				}
			}

		} while (flag);

	}

	/**
	 * Se encarga de modificar un objeto libro del ArrayList{@code <libro>}.<br>
	 * No aparece {@code @return} porque no retorna nada {@code void}
	 */
	private static void modificar() {

		int numeroPaginas = 0;

		// Mostramos por pantalla el listado de libros
		listar();

		System.out.println("Dime el ID del libro a modificar");
		int id = Integer.parseInt(sc.nextLine());
		LibroPrueba libro = modelo.recuperar(id);

		if (libro == null) {
			System.out.println("*** Lo sentimos pero no existe el libro con id " + id);
		} else {

			// pedir datos
			System.out.println("Escribe el nuevo campo si quieres cambiar o enter para dejarlo como estaba");

			System.out.printf("nombre[%s] \n", libro.getNombre()); // nombre del libro
			String nombre = sc.nextLine();

			try {
				System.out.printf("numero paginas[%s] \n", libro.getNumeroPaginas());
				numeroPaginas = validarEnteros("numeroPaginas"); // numero de paginas
			} catch (Exception e) {
				e.printStackTrace();
			}

			// crear nuevo perro con los datos
			LibroPrueba lModificar = new LibroPrueba();
			lModificar.setId(libro.getId()); // id
			lModificar.setNombre(("".equals(nombre)) ? libro.getNombre() : nombre); // nombre
			lModificar.setNumeroPaginas(
					numeroPaginas == libro.getNumeroPaginas() ? libro.getNumeroPaginas() : numeroPaginas);

			// llamar al modelo
			try {
				modelo.modificar(lModificar);
				System.out.println("-------------------------------------");
				System.out.printf("Hemos modifidado el libro: %s [%s paginas] \n", lModificar.getNombre(),
						lModificar.getNumeroPaginas());
				System.out.println("-------------------------------------");

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
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
