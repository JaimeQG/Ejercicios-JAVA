package com.ipartek.pojo.ejercicios;

import com.ipartek.pojo.Persona;

public class Ejercicio4 {

	public static void main(String[] args) {

		Persona p1 = new Persona();
		Persona p2 = new Persona();

		p1.setNombre("pepe");
		p2.setNombre("matusalen");

		try {
			p1.setEdad(56);
			p2.setEdad(999);
		} catch (Exception e) {

		}
	}

}
