package com.ipartek.ejercicios.interfaces.app.clases;

import com.ipartek.ejercicios.interfaces.app.interfaces.IVehiculo;

public class Patinete implements IVehiculo {

	// Atributos, deben ser siempre privados
	private int velocidadActual;
	private boolean estaArrancado;

	// Constructor
	public Patinete() {
		super();
		this.velocidadActual = 0;
		this.estaArrancado = false;
	}

	public Patinete(int velocidadActual, boolean estaArrancado) {
		super();
		this.velocidadActual = velocidadActual;
		this.estaArrancado = estaArrancado;
	}

	// Getters y Setters
	public int getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public boolean isEstaArrancado() {
		return estaArrancado;
	}

	public void setEstaArrancado(boolean estaArrancado) {
		this.estaArrancado = estaArrancado;
	}

	// toString()
	@Override
	public String toString() {
		return "Patinete [velocidadActual=" + velocidadActual + ", estaArrancado=" + estaArrancado + "]";
	}

	@Override
	public void Arrancar() {

		Patinete p = new Patinete();

		if (p.isEstaArrancado() == false) {
			p.setEstaArrancado(true);
		}

	}

	@Override
	public void Acelerar(int incrementoVel) {

		Patinete p = new Patinete();

		if (p.isEstaArrancado() == true) {
			if ((p.getVelocidadActual() + incrementoVel) < VEL_MAX_PATINETE) {
				int velocidadActual = p.getVelocidadActual() + incrementoVel;
				p.setVelocidadActual(velocidadActual);
			}
		}

	}

	@Override
	public void Frenar(int decrementoVel) {
		Patinete p = new Patinete();

		if (p.isEstaArrancado() == true) {
			if ((p.getVelocidadActual() - decrementoVel) > 0) {
				int velocidadActual = p.getVelocidadActual() - -decrementoVel;
				p.setVelocidadActual(velocidadActual);
			}
		}
	}

	@Override
	public void Apagar() {
		Patinete p = new Patinete();

		if (p.isEstaArrancado() == true) {
			p.setEstaArrancado(false);
		}

	}

}
