package com.ipartek.pojo;

/**
 * Un futbolita (jugador de fútbol) consta de los siguientes atributos:
 * 
 * <ul>
 * <li>nombre</li>
 * <li>dorsal</li>
 * </ul>
 * 
 * @author Jaime
 *
 */

public class Jugador {

	// Atributos
	private String nombre;
	private int dorsal;

	// Constructores
	/////////////////////////////////
	// Constructor por defecto (se llaman igual que la clase)
	public Jugador() {
		super();
		this.nombre = "Sin nombre";
		this.dorsal = 1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", dorsal=" + dorsal + "]";
	}

}
