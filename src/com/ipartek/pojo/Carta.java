package com.ipartek.pojo;

/**
 * Una Carta consta de los siguientes atributos:
 * 
 * <ul>
 * <li>valor de la carta (de tipo int)</li>
 * <li>palo de la baraja (copas, espadas, oros, bastos) (de tipo String)</li>
 * </ul>
 * 
 * @author Jaime
 *
 */

public class Carta {

	// Atributos
	private int valor;
	private String palo;

	// Constructor
	public Carta() {
		super();
		this.valor = 1;
		this.palo = "Sin nombre";
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	@Override
	public String toString() {
		return "Carta [valor=" + valor + ", palo=" + palo + "]";
	}

}
