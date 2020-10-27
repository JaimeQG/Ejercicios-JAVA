package com.ipartek.pojo;

public class Television extends Electrodomestico {

	private int pulgadas;

	// Constructor por defecto
	public Television() {
		super();
		pulgadas = 0;
	}

	public Television(int pulgadas) {
		super();
		this.pulgadas = pulgadas;
	}

	public Television(String nombre, float precio, int pulgadas) {
		super(nombre, precio);
		this.pulgadas = pulgadas;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	@Override
	public String toString() {
		return "Television [pulgadas=" + pulgadas + ", getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio()
				+ "]";
	}

}
