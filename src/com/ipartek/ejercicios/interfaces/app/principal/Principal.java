package com.ipartek.ejercicios.interfaces.app.principal;

import com.ipartek.ejercicios.interfaces.app.clases.Patinete;

public class Principal {

	public static void main(String[] args) {

		Patinete p = new Patinete();

		p.arrancar();
		System.out.println(p.isEstaArrancado());

		p.acelerar(40);
		System.out.println(p.getVelocidadActual());

		p.acelerar(50);
		System.out.println(p.getVelocidadActual());

		p.acelerar(50);
		System.out.println(p.getVelocidadActual());

		p.frenar(50);
		System.out.println(p.getVelocidadActual());

		try {
			p.apagar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
