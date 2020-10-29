package mf0227.uf2404.actividad2;

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

public class Coche extends Vehiculo {

	// Atributos, deben ser siempre privados
	private String marca;
	private String modelo;
	private int potencia;
	private int cilindrada;

	// Constructores
	public Coche() {
		super("blanco", "0000AAA");
		this.marca = "sin marca";
		this.modelo = "sin modelo";
		this.potencia = 0;
		this.cilindrada = 0;
	}

	public Coche(String color, String matricula, String marca, String modelo, int potencia, int cilindrada) {
		super(color, matricula);
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.cilindrada = cilindrada;
	}

	// getters y setters
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
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + " CV, cilindrada="
				+ cilindrada + " cm3, Color=" + super.getColor() + ", Matricula=" + super.getMatricula() + "]";
	}

}
