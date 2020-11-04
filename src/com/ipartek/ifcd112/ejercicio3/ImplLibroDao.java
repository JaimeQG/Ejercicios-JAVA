package com.ipartek.ifcd112.ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.ipartek.pojo.Libro;

public class ImplLibroDao implements LibroDao {

	private HashMap<Integer, Libro> hmLibros;

	private int indice = 1;

	private static ImplLibroDao INSTANCE = null;

	public static synchronized ImplLibroDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ImplLibroDao();
		}

		return INSTANCE;
	}

	public ImplLibroDao() {
		super();
		hmLibros = new HashMap<Integer, Libro>();
		hmLibros.put(1, new Libro(1, "El Quijote", 499));
		hmLibros.put(2, new Libro(2, "Hamlet", 399));
		hmLibros.put(3, new Libro(3, "El principito", 299));
		hmLibros.put(4, new Libro(4, "Crimen y castigo", 999));
		indice = 5;
	}

	@Override
	public List<Libro> getAll() {
		return new ArrayList<Libro>(hmLibros.values());
	}

	@Override
	public Libro getById(int id) {

		Libro l = null;

		for (Iterator<Integer> iterator = hmLibros.keySet().iterator(); iterator.hasNext();) {

			int key = (Integer) iterator.next();
			Libro value = hmLibros.get(key);

			if (value.getId() == id) {
				l = value;
				break;
			}
		}

		return l;

	}

	@Override
	public boolean delete(int id) {

		boolean flag = true;

		// Buscamos el libro por id
		Libro lBuscar = getById(id);

		if (lBuscar == null) {
			flag = false;
			// throw new Exception("No existe el libro con id=" + id);
		} else {
			hmLibros.remove(id);
			flag = true;
		}

		return flag;

	}

	@Override
	public boolean insert(Libro l) {

		boolean flag = true;

		for (Iterator<Integer> iterator = hmLibros.keySet().iterator(); iterator.hasNext();) {

			int key = (Integer) iterator.next();
			Libro value = hmLibros.get(key);

			if (value.getNombre().equals(l.getNombre())) {
				flag = false;
				break;
			}
		}

		if (flag) {
			l.setId(indice);
			hmLibros.put(indice, l);
			indice++;
		}

		return flag;
	}

	@Override
	public boolean update(Libro l) {

		boolean flag = true;
		boolean encontrado = true;

		int id = l.getId();

		Libro lBuscar = getById(id);
		if (lBuscar == null) {
			flag = false;
			encontrado = false;
			// throw new Exception("No existe el libro con id=" + id);
		}

		if (!encontrado) {

			for (Iterator<Integer> iterator = hmLibros.keySet().iterator(); iterator.hasNext();) {

				int key = (Integer) iterator.next();
				Libro value = hmLibros.get(key);

				String nombre = value.getNombre();

				if (nombre.equals(value.getNombre()) && id != value.getId()) {
					flag = false;
					// throw new Exception("El nombre ya existe" + nombre);
					break;
				}
			}

		}

		if (!flag) {
			delete(id);
			hmLibros.put(id, l);
		}

		return flag;
	}
}
