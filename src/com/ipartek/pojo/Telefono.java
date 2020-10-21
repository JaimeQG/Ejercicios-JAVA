package com.ipartek.pojo;

public class Telefono {

	// Atributos, deben ser siempre privados
	// La forma de manipularestos atributos es a traves de los getteres y setteres
	private String nombre;
	private String sistemaOperativo;
	private int memoria;
	private boolean is5G;
	private String descripcion;

	// Constructores
	/////////////////////////////////
	public Telefono() {
		super();
		this.nombre = "Sin nombre";
		this.sistemaOperativo = "Sin nombre";
		this.memoria = 0;
		this.is5G = false;
		this.descripcion = "en blanco";
	}

	// Otro constructor sobrecargado

	public Telefono(String nombre) {
		this(); // llama al constructor por defecto, pulsar Control + click
		this.nombre = nombre;
	}

	public Telefono(String nombre, String sistemaOperativo, int memoria) {
		this();
		this.nombre = nombre;
		this.sistemaOperativo = sistemaOperativo;
		this.memoria = memoria;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public float getmemoria() {
		return memoria;
	}

	public void memoria(int memoria) {
		if (memoria < 0) {
			this.memoria = 0;
		} else {
			this.memoria = memoria;
		}

	}

	public boolean isIs5G() {
		return is5G;
	}

	public void setIs5G(boolean is5g) {
		is5G = is5g;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// toString();
	@Override
	public String toString() {
		return "Telefono [nombre=" + nombre + ", sistemaOperativo=" + sistemaOperativo + ", memoria=" + memoria
				+ ", is5G=" + is5G + ", descripcion=" + descripcion + "]";
	}

}