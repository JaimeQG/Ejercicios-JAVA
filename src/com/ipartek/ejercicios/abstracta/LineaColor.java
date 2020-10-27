package com.ipartek.ejercicios.abstracta;

/**
 * Como es final la clase, termina la posibilidad de herencia
 * 
 * @author Jaime Quintana
 *
 */

public final class LineaColor extends Linea {

	String color;

	@Override
	void dibujar() {
		// TODO Auto-generated method stub
		super.dibujar();
		System.out.println("El color es " + color);
	}

}
