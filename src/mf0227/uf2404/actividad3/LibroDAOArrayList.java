package mf0227.uf2404.actividad3;

import java.util.ArrayList;

public class LibroDAOArrayList implements ILibreria {

	private int indice = 0;
	private boolean flag = false;

	private ArrayList<LibroPrueba> lista = new ArrayList<LibroPrueba>();
	private static LibroDAOArrayList INSTANCE = null;

	public static synchronized LibroDAOArrayList getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroDAOArrayList();
		}

		return INSTANCE;
	}

	public LibroDAOArrayList() {
		super();
		lista.add(new LibroPrueba(1, "Bubba", 500));
		lista.add(new LibroPrueba(2, "Laika", 400));
		lista.add(new LibroPrueba(3, "Rintintin", 450));
		lista.add(new LibroPrueba(4, "goofy", 1000));
		indice = 5;
	}

	@Override
	public ArrayList<LibroPrueba> listar() {

		return lista;
	}

	@Override
	public LibroPrueba recuperar(int id) {

		LibroPrueba l = null;

		for (LibroPrueba libro : lista) {
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
	public LibroPrueba crear(LibroPrueba l) throws Exception {

		l.setId(indice);
		lista.add(l);
		indice++;

		return l;
	}

	@Override
	public LibroPrueba modificar(LibroPrueba l) throws Exception {

		int id = l.getId();

		LibroPrueba lBuscar = recuperar(id);
		if (lBuscar == null) {
			throw new Exception("No existe el libro con id=" + id);
		}

		String nombre = l.getNombre();
		for (LibroPrueba libro : lista) {
			if (nombre.equals(libro.getNombre()) && id != libro.getId()) {
				throw new Exception("El nombre ya existe" + nombre);
			}
		}

		int posicionArray = 0;
		for (LibroPrueba libro : lista) {
			int indice = libro.getId();

			if (indice == id) {
				break;
			}
			posicionArray++;
		} // End for

		eliminar(id);
		lista.add(posicionArray, l);

		return l;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		// TODO hacer un for y buscar por id y eliminar de la posicion encontrada

		LibroPrueba lBuscar = recuperar(id);
		if (lBuscar == null) {
			throw new Exception("No existe el libro con id=" + id);
		} else {
			lista.remove(lBuscar);
			flag = true;
		}

		// for (Libro libro : lista) {
		// int indice = libro.getId();

		// if (indice == id) {
		// lista.remove(libro);
		// flag = true;
		// break;
		// }
		// } // End for

		return flag;

	}

}
