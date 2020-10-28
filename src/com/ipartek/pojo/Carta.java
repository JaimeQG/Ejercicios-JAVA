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
	private String valor;
	private String palo;

	// Constructor
	public Carta() {
		super();
		this.valor = "sin valor";
		this.palo = "Sin nombre";
	}

	public Carta(String palo, String valor) {
		super();
		this.valor = valor;
		this.palo = palo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
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
