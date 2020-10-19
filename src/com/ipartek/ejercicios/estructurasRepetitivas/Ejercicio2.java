package com.ipartek.ejercicios.estructurasRepetitivas;
/** 
 * Mostrar con bucles for anidados las tablas de multiplicar del 0 al 10
 * @author Jaime Quintana
 */
public class Ejercicio2 {
	public static void main(String[] args) {
		int i,j;
		for (i=0;i<=10;i++) {
			System.out.println("Tabla del número " + i);
			for (j=1;j<=10;j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}
	}
}
