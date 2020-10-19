package com.ipartek.pojo;

public class Persona {

	static final int EDAD_MINIMA = 0;
	static final int EDAD_MAXIMA = 120;

	private String nombre;
	private int edad;

	// Constructores
	/////////////////////////////////
	public Persona() {
		super();
		this.nombre = "Sin nombre";
		this.edad = 0;
	}

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
			// TODO como aplicar formato String
			// throw new Exception((new String("La edad no es correcta. Valores permitidos
			// %s %s", EDAD_MINIMA, EDAD_MAXIMA));
			throw new Exception("La edad no es correcta.");
		} else {
			this.edad = edad;
		}
	}

}
