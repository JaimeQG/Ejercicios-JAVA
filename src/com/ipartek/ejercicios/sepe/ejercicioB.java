package com.ipartek.ejercicios.sepe;

import java.util.Scanner;

/**
 * Crear un proyecto en modo consola que nos muestre un menú de 3 opciones<br>
 * <ul>
 * <li>Calcular la letra del dni</li>
 * <li>Calcular medida de cm a pulgadas</li>
 * <li>Salir</li> <br>
 * Hacer que dicho menú se ejecute en bucle hasta que se pulse salir, y si el
 * usuario escoge cada una de las funciones, que permita introducir los datos
 * correspondientes por teclado para poder dar el resultado
 * 
 * @author Jaime
 *
 */
public class ejercicioB {

	// Opciones menu principal
	static final private String OP_DNI = "1";
	static final private String OP_CALCULAR = "2";
	static final private String OP_SALIR = "S";

	// Variables globales
	static private Scanner sc = null;
	static private String opcion = "";

	// Constantes globales
	static final char LETRAS_DNI[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
			'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	static final double PULGADA = 0.39370079;

	public static void main(String[] args) {

		boolean salir = false;

		System.out.println("*************  EJERCICIO B  *************");
		sc = new Scanner(System.in);

		do {

			pintarMenu();

			// Acciones segun la opcion elegida
			switch (opcion) {
			case OP_DNI:
				opcionDni();
				break;

			case OP_CALCULAR:
				calcularmedida();
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

	}

	private static void opcionDni() {

		System.out.println("\n Dime los 8 numeros de tu dni:");
		String dniNumeros = sc.nextLine();

		try {
			String dniCompleto = calcularLetraDni(dniNumeros);
			System.out.println("Tu DNI copleto es: " + dniCompleto);

		} catch (Exception e) {
			System.out.println(" *** Lo sentimos pero tu DNI [" + dniNumeros + "] no es valido. " + e.getMessage());
		}

	}

	/**
	 * Calcula la medida en pulgadas
	 */

	private static void calcularmedida() {

		double medidaCms = (double) 0.0;
		boolean isError = true;
		double medidaPulgada = (double) 0.0;

		// Pedir la medida, repetir hasta que no haya error
		do {
			System.out.println("\n Introduzca la medida a convertir en centímetros: ");
			try {
				medidaCms = Double.parseDouble(sc.nextLine());

				// si la linea de arriba lanza excepcion, estas de abajo nunca se ejecutaran
				isError = false;
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				// e.printStackTrace();
				System.out.println("**error, no es un numero valido");
			}
		} while (isError);

		// Calculamos la medida en pulgadas
		medidaPulgada = medidaCms * PULGADA;

		// Formateamos la salida para 2 decimales
		System.out.println(medidaCms + " centímetros son " + Math.round(medidaPulgada * 100.0) / 100.0 + " pulgadas");

	}

	/**
	 * Sacar por pantalla el menú con las opciones
	 */

	private static void pintarMenu() {

		System.out.println("*******************************");
		System.out.println(" 1.- Calcular la letra del DNI");
		System.out.println(" 2.- Calcular medida de cm a pulgadas");
		System.out.println(" S.- Salir");
		System.out.println("*******************************");

		System.out.println("\n Selecciona una opción del menú:");

		opcion = sc.nextLine();

	}

	/**
	 * Calcula la letra del DNI
	 * 
	 * @param numeros String son los 8 numeros del DNI
	 * @return dni completo con los numeros + letra
	 * @throws Exception si no pasamos como parametros 8 numeros
	 */

	private static String calcularLetraDni(String numeros) throws Exception {

		if (numeros == null) {
			throw new Exception("No puede ser null");
		}

		if (numeros.length() != 8) {
			throw new Exception("Los numeros de un dni son 8");
		}

		char letra;

		// Obtenemos la letra dentro del array letras en la posición del resto al
		// dividir entre 23
		int posicion = Integer.parseInt(numeros) % 23;
		letra = LETRAS_DNI[posicion];

		return numeros + letra;
	}

}
