package com.ipartek;

import com.ipartek.pojo.Serie;

public class ProbarInterfaz {

	public static void main(String[] args) throws Exception {

		Utilidades util = new Utilidades();
		try {
			String nombre = util.pedirNombre();
			System.out.println(nombre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Fin del programa");
	}

	Serie serie = new Serie();

}
