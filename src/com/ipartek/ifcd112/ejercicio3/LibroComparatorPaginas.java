package com.ipartek.ifcd112.ejercicio3;

import java.util.Comparator;

import com.ipartek.pojo.Libro;

public class LibroComparatorPaginas implements Comparator<Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		return o1.getNumeroPaginas() - o2.getNumeroPaginas();
	}

}
