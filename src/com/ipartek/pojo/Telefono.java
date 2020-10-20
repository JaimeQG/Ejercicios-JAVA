package com.ipartek.pojo;

public class Telefono {

	// Atributos, deben ser siempre privados
	// La forma de manipularestos atributos es a traves de los getteres y setteres
	private String nombre;
	private String sistemaOperativo;
	private float screenSize;
	private boolean is5G;
	private String descripcion;

	// Constructores
	/////////////////////////////////
	public Telefono() {
		super();
		this.nombre = "Sin nombre";
		this.sistemaOperativo = "Sin nombre";
		this.screenSize = 0f;
		this.is5G = false;
		this.descripcion = "en blanco";
	}

	// Otro constructor sobrecargado

	public Telefono(String nombre) {
		this(); // llama al constructor por defecto, pulsar Control + click
		this.nombre = nombre;
	}

	public Telefono(String nombre, String sistemaOperativo, float screenSize) {
		this();
		this.nombre = nombre;
		this.sistemaOperativo = sistemaOperativo;
		this.screenSize = screenSize;
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

	public float getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(float screenSize) {
		if (screenSize < 0) {
			this.screenSize = 0;
		} else {
			this.screenSize = screenSize;
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
		return "Telefono [nombre=" + nombre + ", sistemaOperativo=" + sistemaOperativo + ", screenSize=" + screenSize
				+ ", is5G=" + is5G + ", descripcion=" + descripcion + "]";
	}

}