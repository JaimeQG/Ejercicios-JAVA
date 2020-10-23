package com.ipartek;

import java.util.Scanner;

/**
 * Los metodos se declaran de la siguiente menra:<br>
 * 
 * <pre>
 * <code>
 * CALIFICADORES DE ACCESO  - RETORNO  -  NOMBRE  (PARAMETROS ) EXCEPCIONES  {<br>
 * 
 * // Codigo fuente 
 * // return es lo que retorna y es obligatorio,a menos que la funcion no retorne nada<strong>void</strong>
 * </pre>
 * 
 * @author usuario
 *
 */

public class MetodosYCalificadores {

	// SOBRECARGA: es cuando un metodo se llama igual, pero tiene diferentes
	// parametros, muy usado en los Constructores

	static void saludar() {
		System.out.println("Hola");
	}

	static void saludar(String nombre) {
		System.out.println("Hola " + nombre);
	}

	static String dimeTuNombre() {
		String resultado = ""; // 1º definir el resultado a retornar en una variable

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre:");
		resultado = sc.nextLine();
		sc.close();
		return resultado;
	}

	static void saludar(String nombre, int numRepeticiones) throws Exception {
		if (numRepeticiones >= 3) {
			throw new Exception(" *** No seas pesado");
		}

		for (int i = 0; i < numRepeticiones; i++) {
			System.out.println(nombre);
		}

	}

	/**
	 * tipico metodo main poara ejecutar codigo en java
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		saludar();
		saludar("Jaime");
		saludar(null);

		String nombre = dimeTuNombre();
		saludar(nombre);

		try {
			saludar(nombre, 4);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
