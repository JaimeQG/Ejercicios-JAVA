package mf0227.uf2404.actividad3;

import java.util.Comparator;

public class LibroComparatorPaginasSolucion implements Comparator<LibroSolucion> {

	@Override
	public int compare(LibroSolucion o1, LibroSolucion o2) {
		return o1.getPaginas() - o2.getPaginas();
	}

}
