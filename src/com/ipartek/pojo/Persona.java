package com.ipartek.pojo;

public class Persona {

	// Constantes
	public static final int EDAD_MINIMA = 0;
	public static final int EDAD_MAXIMA = 120;

	// Atributos
	private String nombre;
	private int edad;

	// Constructores
	/////////////////////////////////
	// Constructor por defecto (se llaman igual que la clase)
	public Persona() {
		super();
		this.nombre = "Sin nombre";
		this.edad = EDAD_MINIMA;
	}

	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception {
		if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {

			throw new Exception(String.format("*** ERROR: El rango de edad debe ser %s %s", EDAD_MINIMA, EDAD_MAXIMA));
		} else {
			this.edad = edad;
		}
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
