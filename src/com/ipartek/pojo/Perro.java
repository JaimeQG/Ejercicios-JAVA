package com.ipartek.pojo;

public class Perro {

	// Atributos, deben ser siempre privados
	// La forma de manipularestos atributos es a traves de los getteres y setteres
	private int id; // TODO getter setters y contructor toString
	private String nombre;
	private String raza;
	private float peso;
	private boolean isVacunado;
	private String historia;

	// Constructores
	/////////////////////////////////
	public Perro() {
		super();
		this.id = 0;
		this.nombre = "Sin nombre";
		this.raza = "Cruce";
		this.peso = 0f;
		this.isVacunado = false;
		this.historia = "en blanco";
	}

	// Otro constructor sobrecargado

	public Perro(int id, String nombre) {
		this(); // llama al constructor por defecto, pulsar Control + click
		this.id = id;
		this.nombre = nombre;
	}

	public Perro(String nombre) {
		this(); // llama al constructor por defecto, pulsar Control + click
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perro(String nombre, String raza, float peso) {
		this();
		this.nombre = nombre;
		this.raza = raza;
		this.peso = peso;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		if (peso < 0) {
			this.peso = 0;
		} else {
			this.peso = peso;
		}
	}

	public boolean isVacunado() {
		return isVacunado;
	}

	public void setVacunado(boolean isVacunado) {
		this.isVacunado = isVacunado;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", peso=" + peso + ", isVacunado="
				+ isVacunado + ", historia=" + historia + "]";
	}

}
