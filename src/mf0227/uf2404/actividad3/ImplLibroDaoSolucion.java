package mf0227.uf2404.actividad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplLibroDaoSolucion implements LibroDaoSolucion {

	private static HashMap<Integer, LibroSolucion> hmLibros;
	private static ImplLibroDaoSolucion INSTANCE = null;
	private static int indice = 0;

	private ImplLibroDaoSolucion() {
		super();
		hmLibros = new HashMap<Integer, LibroSolucion>();
		hmLibros.put(1, new LibroSolucion(1, "Obanboak", 678));
		hmLibros.put(2, new LibroSolucion(2, "Gizona berea bakardadean", 234));
		hmLibros.put(3, new LibroSolucion(3, "Behi euskaldun baten memoriak", 541));
		indice = 4;
	}

	public static synchronized ImplLibroDaoSolucion getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ImplLibroDaoSolucion();
		}
		return INSTANCE;
	}

	@Override
	public List<LibroSolucion> getAll() {
		ArrayList<LibroSolucion> libros = new ArrayList<LibroSolucion>(hmLibros.values());

		// ordenacion por defecto que hemos definido en el Libro implements Comparable
		// Collections.sort(libros);

		// ordenacion por paginas que hemos creado una nueva Clase que implements
		// Comparator<Libro>
		libros.sort(new LibroComparatorPaginasSolucion());
		return libros;
	}

	@Override
	public LibroSolucion getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(LibroSolucion l) {
		// TODO Auto-generated method stub
		return false;
	}

}