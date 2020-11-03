package mf0227.uf2404.actividad3;

import java.util.ArrayList;

import com.ipartek.modelo.Singleton;

public interface ILibreria extends Singleton {

	/**
	 * lista de pojos
	 * 
	 * @return todos los pojos, si no existe ninguno ArrayList
	 *         <P>
	 *         vacio no null
	 */
	ArrayList<Libro> listar();

	/**
	 * Recupera el detalle de un pojo
	 * 
	 * @param id identificador
	 * @return pojo con sus datos o null si no encuentra por su id
	 */
	Libro recuperar(int id);

	/**
	 * Crea un nuevo pojo y cuando es guardado se le asigan una nueva id
	 * 
	 * @param p pojo con los datos a guardar
	 * @throws Exception si el nombre del pojo ya existe
	 * @return pojo con su id actualizado
	 */
	Libro crear(Libro l) throws Exception;

	/**
	 * Modifica un pojo
	 * 
	 * @param p pojo con los datos nuevos
	 * @return pojo modificado
	 * @throws Exception si no encuentra el pojo, o el nombre ya existe
	 */
	Libro modificar(Libro l) throws Exception;

	/**
	 * Elimina el pojo gracias a su identificador
	 * 
	 * @param id identificador
	 * @throws Exception
	 * @return true si elimina, false en caso contrario
	 */
	boolean eliminar(int id) throws Exception;

}
