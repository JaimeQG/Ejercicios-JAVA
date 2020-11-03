package mf0227.uf2404.actividad3;

/**
 * La clase Libro tendrá los siguientes atributos:<br>
 * <ul>
 * <li>id</li>
 * <li>nombre</li>
 * <li>numero de páginas</li>
 * </ul>
 * 
 * @author Jaime Quintana
 *
 */

public class Libro {

	// Atributos, deben ser siempre privados
	private int id;
	private String nombre;
	private int numeroPaginas;

	public Libro() {
		super();
		this.id = 1;
		this.nombre = "Sin nombre";
		this.numeroPaginas = 0;
	}

	public Libro(int id, String nombre, int numeroPaginas) {
		super();
		this.id = id;
		this.setNombre(nombre);
		this.setNumeroPaginas(numeroPaginas);
	}

	public Libro(String nombre, int numeroPaginas) {
		super();
		this.setNombre(nombre);
		this.setNumeroPaginas(numeroPaginas);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", numeroPaginas=" + numeroPaginas + "]";
	}

}
