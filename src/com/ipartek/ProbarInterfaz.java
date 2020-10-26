package com.ipartek;

import com.ipartek.pojo.Serie;

public class ProbarInterfaz {

	public static void main(String[] args) throws Exception {

		Utilidades util = new Utilidades();
		// decomentar para probar los metodos
		/*
		 * try { String nombre = util.pedirNombre(); System.out.println(nombre); } catch
		 * (Exception e) { System.out.println(e.getMessage()); }
		 */
		Serie s = util.pedirDatosPorConsola();
		System.out.println("Tu serie es " + s);

		System.out.println("Fin del programa");

	}// main

}// class
