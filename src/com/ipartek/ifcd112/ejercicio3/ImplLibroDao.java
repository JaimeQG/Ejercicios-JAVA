package com.ipartek.ifcd112.ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.ipartek.pojo.Libro;

public class ImplLibroDao implements LibroDao {

	private static HashMap<Integer, Libro> hmLibros;
	private static ImplLibroDao INSTANCE = null;
	private static int indice = 0;

	public ImplLibroDao() {
		super();
		hmLibros = new HashMap<Integer, Libro>();
		hmLibros.put(1, new Libro(1, "El Quijote", 499));
		hmLibros.put(2, new Libro(2, "Hamlet", 399));
		hmLibros.put(3, new Libro(3, "El principito", 299));
		hmLibros.put(4, new Libro(4, "Crimen y castigo", 999));
		indice = 5;
	}

	public static synchronized ImplLibroDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ImplLibroDao();
		}
		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() {
		ArrayList<Libro> libros = new ArrayList<Libro>(hmLibros.values());

		// ordenacion por defecto que hemos definido en el Libro implements Comparable
		Collections.sort(libros);

		// ordenacion por paginas que hemos creado una nueva Clase que implements
		// Comparator<Libro>
		// libros.sort(new LibroComparatorPaginas());

		return libros;
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

		return (hmLibros.remove(id) == null) ? false : true;

		/*
		 * boolean flag = true;
		 * 
		 * // Buscamos el libro por id Libro lBuscar = getById(id);
		 * 
		 * if (lBuscar == null) { flag = false; // throw new //
		 * Exception("No existe el libro con id=" + id); } else { hmLibros.remove(id);
		 * flag = true; }
		 * 
		 * return flag;
		 */
	}

	@Override
	public boolean insert(Libro l) {

		boolean resultado = false;
		boolean encontrado = false;
		String nombreLibro = l.getNombre();

		// Buscar si existe el nombre en el HashMap, recorriendo uno a uno todos los
		// libros
		for (Iterator<Libro> iterator = hmLibros.values().iterator(); iterator.hasNext();) {
			// for (Iterator<Integer> iterator = hmLibros.keySet().iterator();
			// iterator.hasNext();) {

			// int key = (Integer) iterator.next();
			// Libro value = hmLibros.get(key);
			Libro libroIteracion = iterator.next();
			nombreLibro = libroIteracion.getNombre();
			// if (value.getNombre().equalsIgnoreCase(l.getNombre())) {
			if (nombreLibro.equalsIgnoreCase(l.getNombre())) {
				encontrado = true;
				break;
			}
		}

		// si no existe, insertarlo y actualizar id
		if (!encontrado) {
			l.setId(indice); // setear el id en el objeto
			hmLibros.put(indice, l); // guardar Libro en el HashMap
			indice++; // actualizar indice para la siguiente inserción
			resultado = true;
		}

		return resultado;
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
