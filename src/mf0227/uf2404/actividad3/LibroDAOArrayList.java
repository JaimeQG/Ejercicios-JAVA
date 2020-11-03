package mf0227.uf2404.actividad3;

import java.util.ArrayList;

public class LibroDAOArrayList implements ILibreria {

	private int indice = 0;
	private boolean flag = false;

	private ArrayList<Libro> lista = new ArrayList<Libro>();
	private static LibroDAOArrayList INSTANCE = null;

	public static synchronized LibroDAOArrayList getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroDAOArrayList();
		}

		return INSTANCE;
	}

	public LibroDAOArrayList() {
		super();
		lista.add(new Libro(1, "Bubba", 500));
		lista.add(new Libro(2, "Laika", 400));
		lista.add(new Libro(3, "Rintintin", 450));
		lista.add(new Libro(4, "goofy", 1000));
		indice = 5;
	}

	@Override
	public ArrayList<Libro> listar() {

		return lista;
	}

	@Override
	public Libro recuperar(int id) {

		Libro l = null;

		for (Libro libro : lista) {
			int indice = libro.getId();

			if (indice == id) {
				// p = lista.get(id);
				l = libro;
				break;
			}
		} // End for

		return l;
	}

	@Override
	public Libro crear(Libro l) throws Exception {

		l.setId(indice);
		lista.add(l);
		indice++;

		return l;
	}

	@Override
	public Libro modificar(Libro l) throws Exception {

		int id = l.getId();

		Libro lBuscar = recuperar(id);
		if (lBuscar == null) {
			throw new Exception("No existe el libro con id=" + id);
		}

		String nombre = l.getNombre();
		for (Libro libro : lista) {
			if (nombre.equals(libro.getNombre()) && id != libro.getId()) {
				throw new Exception("El nombre ya existe" + nombre);
			}
		}

		int posicionArray = 0;
		for (Libro libro : lista) {
			int indice = libro.getId();

			if (indice == id) {
				break;
			}
			posicionArray++;
		} // End for

		eliminar(id);
		lista.add(posicionArray, l);
		// lista.add(l);

		return l;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		// TODO hacer un for y buscar por id y eliminar de la posicion encontrada

		if (id <= 0) {
			throw new Exception("*** error: El id no puede ser <=0");
		}

		for (Libro libro : lista) {
			int indice = libro.getId();

			if (indice == id) {
				lista.remove(libro);
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

}
