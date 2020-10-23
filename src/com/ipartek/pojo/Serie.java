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
 * @author ur00
 *
 */
public class Serie {
	// Atributos, deben ser siempre privados
	// La forma de manipularestos atributos es a traves de los getteres y setteres
	private String nombre;
	private int numeroTemporadas;
	private int duracion;
	private String plataforma;

	// Constructores
	/////////////////////////////////
	public Serie() {
		super();
		this.nombre = "Sin nombre";
		this.numeroTemporadas = 0;
		this.duracion = 0;
		this.plataforma = "internet";
	}

	public Serie(String nombre) {
		this();
		this.nombre = nombre;
		this.numeroTemporadas = 0;
		this.duracion = 0;
		this.plataforma = "internet";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
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

}
