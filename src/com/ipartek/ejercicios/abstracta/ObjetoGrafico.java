package com.ipartek.ejercicios.abstracta;

public abstract class ObjetoGrafico {

	// posicion x e y del objeto grafico
	int x;
	int y;

	/**
	 * Todos los objetos graficos que hereden se moveran igual
	 * 
	 * @param x nueva posicion x
	 * @param y nueva posicion y
	 */

	void mover(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Todavia no se como lo van a hacer mis hijos, pero les voy a obligar Por eso
	 * declaramos abstract la clase y el metodo
	 */
	abstract void dibujar();
}
