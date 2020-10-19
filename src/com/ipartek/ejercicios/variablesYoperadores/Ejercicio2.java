package com.ipartek.ejercicios.variablesYoperadores;

/**
 * Realizar una pequeña calculadora. Para ello se crearan 10 variables de
 * distintos tipos numéricos. Una vez creadas dichas variables y asignadas desde
 * código valores (se recomienda valores entre -10 y 10) realizar las siguientes
 * operaciones:<br>
 * <ul>
 * <li>La suma de todos los números</li>
 * <li>La resta de todos los números</li>
 * <li>La media de todos los números</li>
 * </ul>
 * 
 * @author Jaime
 * @version 1.0
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		// Números enteros
		byte mybit = -10;
		short myshort = 10;
		int myint1 = 10;
		int myint2 = 5;
		long mylong1 = -10;
		long mylong2 = 10;

		// Números punto flotante
		double myfloat1 = 10.00;
		double myfloat2 = 5.00;
		double mydouble1 = -10.00;
		double mydouble2 = -5.00;

		double mysuma, myresta, mymedia;

		mysuma = mybit + myshort + myint1 + myint2 + mylong1 + mylong2 + myfloat1 + myfloat2 + mydouble1 + mydouble2;
		myresta = -mybit - myshort - myint1 - myint2 - mylong1 - mylong2 - myfloat1 - myfloat2 - mydouble1 - mydouble2;
		mymedia = mysuma / 10;

		System.out.println("La suma de los 10 números es: " + mysuma);
		System.out.println("La resta de los 10 números es: " + myresta);
		System.out.println("La media de los 10 números es: " + mymedia);

		int temperaturaSemana[] = { 14, 16, 19, 23, 20, 21, 18 };
		String diasSemana[] = { "L", "M", "X", "J", "V", "S", "D" };
		float sumatorioSemana = 0;

		for (int i = 0; i < temperaturaSemana.length; i++) {
			System.out.println(diasSemana[i] + " hace " + temperaturaSemana[i] + " grados");
			sumatorioSemana += temperaturaSemana[i];
		} // for
		double mediaSemana = sumatorioSemana / temperaturaSemana.length;
		System.out.printf("La media de temperatura de la %s es \n %.2f ", "SEMANA", mediaSemana);
	}// main
}// class
