package com.ipartek.pojo;

/**
 * La clase coche tendrá los siguientes atributos:<br>
 * <ul>
 * <li>matricula</li>
 * <li>marca</li>
 * <li>modelo</li>
 * <li>color</li>
 * <li>potencia</li>
 * <li>cilindrada</li>
 * </ul>
 * 
 * @author Jaime Quintana
 *
 */

public class Coche {

	// Atributos, deben ser siempre privados
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int potencia;
	private int cilindrada;

	// Constructores
	public Coche() {
		super();
		this.matricula = "0000AAA";
		this.marca = "sin marca";
		this.modelo = "sin modelo";
		this.color = "blanco";
		this.potencia = 0;
		this.cilindrada = 0;
	}

	public Coche(String matricula, String marca, String modelo, String color, int potencia, int cilindrada) {
		this();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.potencia = potencia;
		this.cilindrada = cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", potencia=" + potencia + ", cilindrada=" + cilindrada + "]";
	}

}
