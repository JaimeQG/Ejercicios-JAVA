package com.ipartek.pojo;

/**
 * Cuando extendemos una Clase, heredamos todos sus métodos y atributos
 * 
 * @author Jaime
 *
 */
public class Profesor extends Persona {

	private String asignatura;

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

}
