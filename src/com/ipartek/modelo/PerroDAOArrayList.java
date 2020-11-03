package com.ipartek.modelo;

import java.util.ArrayList;

import com.ipartek.pojo.Perro;

public class PerroDAOArrayList implements PerroDao {

	private int indice = 0;
	private boolean flag = false;

	private ArrayList<Perro> lista = new ArrayList<Perro>();
	private static PerroDAOArrayList INSTANCE = null;

	public static synchronized PerroDAOArrayList getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PerroDAOArrayList();
		}

		return INSTANCE;
	}

	public PerroDAOArrayList() {
		super();
		lista.add(new Perro(1, "Bubba"));
		lista.add(new Perro(2, "Laika"));
		lista.add(new Perro(3, "Rintintin"));
		lista.add(new Perro(4, "goofy"));
		indice = 5;
	}

	@Override
	public ArrayList<Perro> listar() {

		/*
		 * if (lista != null && lista.isEmpty()) {
		 * 
		 * lista.add(new Perro("Bubba")); lista.add(new Perro("Laika")); lista.add(new
		 * Perro("Rintintin")); lista.add(new Perro("goofy")); }
		 */

		return lista;
	}

	@Override
	public Perro recuperar(int id) {

		Perro p = null;

		for (Perro perro : lista) {
			int indice = perro.getId();

			if (indice == id) {
				// p = lista.get(id);
				p = perro;
				break;
			}
		} // End for

		return p;
	}

	@Override
	public Perro crear(Perro p) throws Exception {

		p.setId(indice);
		lista.add(p);
		indice++;

		return p;
	}

	@Override
	public Perro modificar(Perro p) throws Exception {
		// TODO hacer un for y buscar por id y cambiarlo
		Perro resultado = null;
		int id = p.getId();

		for (Perro perro : lista) {
			int indice = perro.getId();

			if (indice == id) {
				lista.remove(id);
				lista.add(p);
				flag = true;
				break;
			}
		} // End for

		if (!flag) {
			throw new Exception("*** error: No se encuentra el perro");
		}

		return resultado;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		// TODO hacer un for y buscar por id y eliminar de la posicion encontrada

		if (id <= 0) {
			throw new Exception("*** error: El id no puede ser <=0");
		}

		for (Perro perro : lista) {
			int indice = perro.getId();

			if (indice == id) {
				lista.remove(perro);
				flag = true;
				break;
			}
		} // End for

		if (!flag) {
			throw new Exception("*** error: No se encuentra el perro");
		} else {
			return true;
		}

	}

	public int countDBRows() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Perro modificarCampo(Perro p, String campo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
