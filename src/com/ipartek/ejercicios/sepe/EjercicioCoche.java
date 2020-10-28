package com.ipartek.ejercicios.sepe;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Coche;

/**
 * Realizar un programa que nos cree una lista de coches, para ello deberá
 * almacenarse dentro de esta lista los objetos de tipo coche que crearemos<br>
 * La clase coche tendrá los siguientes atributos: matricula, marca, modelo,
 * color, potencia, cilindrada Para rellenar la lista se creara un menú que nos
 * solicitara introducir los datos por teclado, y una vez leídos todos, se
 * guardaran en un objeto que se añadirá a la lista y nos pedirá que indiquemos
 * si queremos introducir un vehículo más o no.<br>
 * Una vez que no queramos introducir más coches, nos mostrara todo el contenido
 * en pantalla<br>
 * Realizar el ejercicio en base a las reglas de programación orientada a
 * objetos
 * 
 * 
 * @author Jaime Quintana
 *
 */

public class EjercicioCoche {

	// Opciones menu principal
	static final private String OP_ADD = "1";
	static final private String OP_LISTAR = "2";
	static final private String OP_SALIR = "S";

	// Variables globales
	static private Scanner sc = null;
	static private String opcion = "";

	static final ArrayList<Coche> lista = new ArrayList<Coche>();

	public static void main(String[] args) {

		boolean salir = false;

		System.out.println("*************  EJERCICIO COCHES  *************");
		sc = new Scanner(System.in);

		do {
			pintarMenu();

			// Acciones segun la opcion elegida
			switch (opcion) {
			case OP_ADD:
				addCoche();
				break;

			case OP_LISTAR:
				listarCoches();
				break;

			case OP_SALIR:
				System.out.println("***********  ADIOS, nos vemos pronto  ***********");
				salir = true;
				break;

			default:
				System.out.println(" ** por favor selecciona una opción valida ** ");
				System.out.println("");
				break;
			}// switch

		} while (!salir);

		sc.close();

	}// main

	/**
	 * Añadir coche al ArrayList de Objetos Coche
	 * 
	 * @param
	 */

	private static void addCoche() {

		String matricula = "";
		String marca = "";
		String modelo = "";
		String color = "";
		int potencia = 0;
		int cilindrada = 0;

		// Datos del coche
		/////////////////////

		// Matricula del coche
		System.out.println("Introduzca matricula del coche: ");
		matricula = sc.nextLine();

		// Marca del coche
		System.out.println("Introduzca marca del coche: ");
		marca = sc.nextLine();

		// Modelo del coche
		System.out.println("Introduzca modelo del coche: ");
		modelo = sc.nextLine();

		// Modelo del color
		System.out.println("Introduzca color del coche: ");
		color = sc.nextLine();

		// Potencia del coche
		potencia = validarEnteros("potencia");

		// Cilindrada del coche
		cilindrada = validarEnteros("cilindrada");

		// Construimos coche
		Coche coche = new Coche();
		coche.setMatricula(matricula);
		coche.setMarca(marca);
		coche.setModelo(modelo);
		coche.setColor(color);
		coche.setPotencia(potencia);
		coche.setCilindrada(cilindrada);

		// insertar valores en el ArrayList
		lista.add(coche);

	}

	/**
	 * Validad que los datos introducidos por pantalla son de tipo int
	 * 
	 * @param nombre de la propiedad de tipo entero de la Clase Coche
	 * @return valor de tipo entero
	 */

	private static int validarEnteros(String propiedad) {

		boolean isError = true;
		int intEntero = 0;

		do {
			System.out.println("Introduzca la " + propiedad + " del coche: ");
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

	/**
	 * Sacar por pantalla los objetos coche del ArrayList
	 * 
	 * @param
	 */

	private static void listarCoches() {

		System.out.println("");
		System.out.println("-------------------------------");
		System.out.println("++++  LISTADO  DE  COCHES  ++++");
		System.out.println("-------------------------------");

		for (Coche coche : lista) {
			// System.out.println(String.format("%1s [%s] %s ", coche.getMarca(),
			// telefono.getSistemaOperativo(),
			// telefono.getmemoria()));
			System.out.println(coche);
		}

		System.out.println("----------------------------------------------");
		System.out.printf(" Total %s Coches \n", lista.size());
		System.out.println("----------------------------------------------");

	}

	/**
	 * Sacar por pantalla el menu con las opciones disponibles:
	 * <ul>
	 * <li>1.- Añadir cochez</li>
	 * <li>2.- Listar coches</li>
	 * <li>S.- Salir</li>
	 * </ul>
	 * 
	 * @param
	 */

	private static void pintarMenu() {

		System.out.println("*******************************");
		System.out.println(" 1.- Añadir coche");
		System.out.println(" 2.- Listar coches");
		System.out.println(" S.- Salir");
		System.out.println("*******************************");

		System.out.println("\n Selecciona una opción del menú:");

		opcion = sc.nextLine();

	}

}// class
