package com.ipartek.ejercicios.estructurasCondicionales;

/**
 * Pedir por teclado al usuario que introduzca una distancia en cm Una vez
 * introducida, se solicitará que escoja a que unidad se van a convertir,
 * introduciendo la opción por teclado
 * <ul>
 * <li>A: convertir a metros</li>
 * <li>B: convertir a pulgadas</li>
 * <li>C: convertir a pies</li>
 * <li>D: convertir a yardas</li>
 * </ul>
 * 
 * @author: Jaime
 * @version: 1.0
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO captura datos en cm
		float distancia = 57.6f;

		// Calculamos distancias en: metros, pulgadas, pies y yardas
		float metros = distancia / 100;
		double pulgadas = distancia * 0.39370079;
		double pies = distancia * 0.0328084;
		double yardas = distancia * 0.01093613;

		// Sacamos valores por pantalla
		System.out.println("Distancia en metros: " + metros);
		System.out.println("Distancia en pulgadas: " + pulgadas);
		System.out.println("Distancia en pies: " + pies);
		System.out.println("Distancia en yardas: " + yardas);
	}// main
}// class
