package com.ipartek.modelo;

import java.util.ArrayList;

import com.ipartek.pojo.Perro;

public class PerroDAOArrayList implements PerroDao {

	private int indice = 5;
	private boolean flag = false;

	private ArrayList<Perro> lista = new ArrayList<Perro>();

	@Override
	public ArrayList<Perro> listar() {

		if (lista != null && lista.isEmpty()) {

			lista.add(new Perro(1, "Bubba"));
			lista.add(new Perro(2, "Laika"));
			lista.add(new Perro(3, "Rintintin"));
			lista.add(new Perro(4, "goffy"));
		}

		return lista;
	}

	@Override
	public Perro recuperar(int id) {
		// TODO Auto-generated method stub
		for (Perro perro : lista) {
			int posicion = perro.getId();

			if (posicion == id) {
				lista.get(id);
				flag = true;
				break;
			}
		} // End for

		return null;
	}

	@Override
	public Perro crear(Perro p) throws Exception {
		// TODO Auto-generated method stub
		int posicion = 0;
		String nombrePerro = "";

		for (Perro perro : lista) {
			posicion = perro.getId(); // posicion = posición dentro del ArrayList<Perro>();
			nombrePerro = perro.getNombre();

			if (posicion == p.getId()) {
				flag = true;
				break;
			}

			if (nombrePerro.equalsIgnoreCase(p.getNombre())) {
				flag = true;
				break;
			}
		} // End for

		if (!flag) {
			throw new Exception("*** error: No se puede dar de alta. El perro " + p.getNombre() + " ya existe");
		}

		lista.add(p);
		return null;
	}

	@Override
	public Perro modificar(Perro p) throws Exception {
		// TODO Auto-generated method stub

		for (Perro perro : lista) {
			int posicion = perro.getId();
			String nombrePerro = perro.getNombre();

			if (nombrePerro.equalsIgnoreCase(p.getNombre())) {
				flag = true;
				break;
			}
		} // End for

		if (!flag) {
			throw new Exception("*** error: No se encuentra el perro");
		}

		lista.set(1, p);
		return null;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		// TODO Auto-generated method stub

		if (id <= 0) {
			throw new Exception("*** error: El id no puede ser <=0");
		}

		for (Perro perro : lista) {
			int posicion = perro.getId();

			if (posicion == id) {
				lista.remove(perro);
				flag = true;
				break;
			}
		} // End for

		if (!flag) {
			throw new Exception("*** error: No se encuentra el perro");
		}

		return false;
	}

}
