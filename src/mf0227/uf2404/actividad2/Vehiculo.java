package mf0227.uf2404.actividad2;

public class Vehiculo implements IConducible {

	// Atributos, deben ser siempre privados
	private String color;
	private String matricula;

	// Constructor
	public Vehiculo() {
		super();
		this.color = "blanco";
		this.matricula = "0000AAA";
	}

	public Vehiculo(String color, String matricula) {
		this();
		this.color = color;
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [color=" + color + ", matricula=" + matricula + "]";
	}

	@Override
	public void arrancar() {
		System.out.println("Arrancamos ....");

	}

	@Override
	public void apagar() throws Exception {
		System.out.println("Paramos y apagamos el motor ...");

	}

}
