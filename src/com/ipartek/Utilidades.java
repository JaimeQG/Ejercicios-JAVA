package com.ipartek;

public class Utilidades {

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

}
// class
