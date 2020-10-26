package com.ipartek.pojo;

public class TelevisionPlana extends Television {

	private String tipoPantalla;

	// Constructor por defecto
	public TelevisionPlana() {
		super();
		this.tipoPantalla = "sin tipo pantalla";
	}

	public TelevisionPlana(String tipoPantalla) {
		this();
		this.tipoPantalla = tipoPantalla;
	}

	public String getTipoPantalla() {
		return tipoPantalla;
	}

	public void setTipoPantalla(String tipoPantalla) {
		this.tipoPantalla = tipoPantalla;
	}

	@Override
	public String toString() {
		return super.toString() + " TelevisorPlasma [tipoPantalla=" + tipoPantalla + "]";
	}

}
