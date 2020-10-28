package com.ipartek.ejercicios.interfaces.app.principal;

import com.ipartek.ejercicios.interfaces.app.clases.Patinete;

public class Principal {

	public static void main(String[] args) {

		Patinete patinete = new Patinete(0, false);

		patinete.Arrancar();

		patinete.Acelerar(40);
		System.out.println(patinete.getVelocidadActual());

		patinete.Acelerar(50);

		System.out.println(patinete.getVelocidadActual());

	}

}
