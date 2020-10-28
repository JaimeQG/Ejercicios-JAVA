package com.ipartek.ejercicios.interfaces.app.principal;

import com.ipartek.ejercicios.interfaces.app.clases.Patinete;

public class Principal {

	public static void main(String[] args) {

		Patinete patinete = new Patinete(0, false);

		patinete.Arrancar();

		patinete.Acelerar(40);

		patinete.Acelerar(50);

	}

}
