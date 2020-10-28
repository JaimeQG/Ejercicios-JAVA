package com.ipartek;

import java.util.Scanner;

import com.ipartek.pojo.Serie;

public class ImplementacionFunciones implements IFunciones {

	public static void main(String[] args) {

	}

	@Override
	public String pedirNombre() throws Exception {

		String nombre = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre:");
		nombre = sc.nextLine();
		sc.close();

		if (nombre.length() <= 1) {
			throw new Exception("*** error: Longitud del nombre incorrecto");
		}

		try {
			Integer.parseInt(nombre);

		} catch (NumberFormatException e) {
			throw new Exception("*** error: No es un nombre correcto. Contiene números " + nombre);
		}

		return nombre;
	}

	@Override
	public void imprimirNumeroLoteria(int tipoLoteria) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public float calcularVueltas(float dineroEntregado, float precioProducto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Serie pedirDatosPorConsola() {
		// TODO Auto-generated method stub
		return null;
	}

}