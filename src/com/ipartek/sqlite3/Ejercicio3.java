package com.ipartek.sqlite3;

import java.util.Scanner;

import com.ipartek.modelo.PerroDAOSqlite;
import com.ipartek.pojo.Perro;

public class Ejercicio3 {

	static private Scanner sc = null;

	public static void main(String[] args) throws Exception {

		// Este DAO se encarga de realizara la operaciones de CRUD contra la bbdd
		PerroDAOSqlite dao = new PerroDAOSqlite();

		System.out.println(dao.getLastId());
		String nombrePerro = "Perro" + (dao.getLastId() + 1);
		Float pesoPerro = 34.5f / (float) (dao.getLastId() + 1);

		Perro pNuevo = new Perro(nombrePerro, "callejero", pesoPerro, true, "la historia de " + nombrePerro + " ...");
		try {
			dao.crear(pNuevo); // insert
		} catch (Exception e) {
			System.out.printf("** el nombre del perro %s ya existe \n", pNuevo.getNombre());
		}

		try {
			dao.eliminar(dao.getLastId() / 2); // eliminar
		} catch (Exception e) {
			// System.out.println("** el perro no existe");
			System.out.println(e.getMessage());
		}

		for (Perro p : dao.listar()) {
			System.out.println(p);
		}

		System.out.println("Selecciona id perro a recuperar:");
		sc = new Scanner(System.in);

		try {
			int indice = Integer.parseInt(sc.nextLine());
			// System.out.println(dao.recuperar(indice));

			if (dao.recuperar(indice) == null) {
				System.out.println("No existe el perro: " + indice);
			} else {
				System.out.println(dao.recuperar(indice));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();

		System.out.println("terminamos");

	}

}