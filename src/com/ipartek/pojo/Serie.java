package com.ipartek.pojo;

/**
 * Una serie de TV consta de los siguientes atributos:
 * 
 * <ul>
 * <li>Nombre</li>
 * <li>numTemporadas</li>
 * <li>duracion (minutos)</li>
 * <li>plataforma(netflix,plex,hbo,moviestar,...)</li>
 * </ul>
 * 
 * El constructor debere pasarse siempre el nombre de forma obligatoria.. El
 * resto de campos se iniciaalzan a 0 y la plataforma especificar "internet"
 * 
 * @author Jaime
 *
 */
public class Serie {
	// Atributos, deben ser siempre privados
	// La forma de manipularestos atributos es a traves de los getteres y setteres
	private String nombre;
	private int numTemporadas;
	private int duracion;
	private String plataforma;

	// Constructores
	/////////////////////////////////

	public Serie(String nombre) {
		super(); // llamamos al constructor del padre que es java.lang.Object
		this.nombre = nombre;
		this.numTemporadas = 0;
		this.duracion = 0; // minutos
		this.plataforma = "internet";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroTemporadas() {
		return numTemporadas;
	}

	public void setNumeroTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	@Override // Sobreescribir
	public String toString() {
		return "Serie [nombre=" + nombre + ", numeroTemporadas=" + numTemporadas + ", duracion=" + duracion
				+ ", plataforma=" + plataforma + "]";
	}

}
