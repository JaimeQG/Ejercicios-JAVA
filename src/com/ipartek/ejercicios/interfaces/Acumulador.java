package com.ipartek.ejercicios.interfaces;

public class Acumulador implements IModificaion {

	private int valor;

	public Acumulador(int i) {
		this.valor = i;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Acumulador [valor=" + valor + "]";
	}

	public int daValor() {
		return this.valor;
	}

	public void incremento(int a) {
		this.valor += a;
	}

}
