package com.ipartek;

import java.util.Scanner;

import com.ipartek.pojo.Serie;

public class Utilidades implements IFunciones {

	static final char LETRAS_DNI[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
			'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	/**
	 * Calcula la letra del DNI
	 * 
	 * @param numeros String son los 8 numeros del DNI
	 * @return dni completo con los numeros + letra
	 * @throws Exception si no pasamos como parametros 8 numeros
	 */
	static public String calcularLetraDni(String numeros) throws Exception {

		if (numeros == null) {
			throw new Exception("No puede ser null");
		}

		if (numeros.length() != 8) {
			throw new Exception("Los numeros de un dni son 8");
		}

		char letra;

		try {
			// Obtenemos la letra dentro del array letras en la posición del resto al
			// dividir entre 23
			int posicion = Integer.parseInt(numeros) % 23;
			letra = LETRAS_DNI[posicion];
		} catch (Exception e) {
			throw new Exception("No es un número correcto " + numeros);
		}

		return numeros + letra;
	}// calcularLetraDni

	static public String calcularPosicionString(String texto, int posicion) throws Exception {
		if (texto == null) {
			throw new Exception("El texto no puede ser null");
		}

		if (posicion == 0) {
			throw new Exception("La posición de texto no puede ser la 0");
		}

		if (posicion > texto.length()) {
			throw new Exception("La posicion no puede ser mayor que la longitud del texto");
		}

		char ch;

		try {
			ch = texto.charAt(posicion - 1);

		} catch (Exception e) {
			throw new Exception("No es un número correcto ");
		}

		String cadena = Character.toString(ch);
		return cadena;
	}

	@Override
	public String pedirNombre() throws Exception {
		// @throws si el nombre es menor de una letra o contiene numeros
		String nombre = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre:");
		nombre = sc.nextLine();
		sc.close();

		if (nombre.length() <= 1) {
			throw new Exception("*** error: Longitud del nombre incorrecto");
		}

		for (int i = 0; i < nombre.length(); i++) {
			char letra = nombre.charAt(i);
			boolean isNumber = Character.isDigit(letra);
			if (isNumber) {
				throw new Exception("*** error: No es un nombre correcto. Contiene números " + nombre);
			}
		}

		/*
		 * try { Integer.parseInt(nombre);
		 * 
		 * } catch (NumberFormatException e) { throw new
		 * Exception("*** error: No es un nombre correcto. Contiene números " + nombre);
		 * }
		 */

		return nombre;
	}

	@Override
	public void imprimirNumeroLoteria(int tipoLoteria) throws Exception {
		// @throws si el tipoLoteria no existe
		switch (tipoLoteria) {
		case LOTERIA_EUROMILLON:
			System.out.println("EUROMILLÓN");
			break;
		case LOTERIA_QUINIELA:
			System.out.println("QUINIELA");
			break;
		case LOTERIA_BONOLOTO:
			System.out.println("BONOLOTO");
			break;

		default:
			throw new Exception("*** error: Lotería no existe");
		}

	}

	@Override
	public float calcularVueltas(float dineroEntregado, float precioProducto) throws Exception {
		// Exception si precioProducto > dineroEntregado
		float vueltas = (float) 0.0;

		if (precioProducto > dineroEntregado) {
			throw new Exception("*** error: El precio del producto " + precioProducto
					+ " es mayor que el precio entregado " + dineroEntregado);
		}

		vueltas = dineroEntregado - precioProducto;
		return vueltas;
	}

	@Override
	public Serie pedirDatosPorConsola() {
		Serie serie = new Serie("");

		String nombreSerie = "";
		String nombrePlataforma = "";
		int numTemporadas;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre de la serie:");
		nombreSerie = sc.nextLine();
		serie.setPlataforma(nombreSerie);

		System.out.println("Número de temporadas:");
		numTemporadas = Integer.parseInt(sc.nextLine());
		serie.setNumeroTemporadas(numTemporadas);

		System.out.println("Nombre de la plataforma:");
		nombrePlataforma = sc.nextLine();
		serie.setPlataforma(nombrePlataforma);

		sc.close();
		return serie;
		// return null;
	}
}// class
