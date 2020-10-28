package com.ipartek.ejercicios.sepe;

public interface IConducible {

	/**
	 * Arrancar: pondrá el atributo estaArrancado a true.<br>
	 * Debe estar apagado para poder arrancarse
	 * 
	 * @param
	 */
	void arrancar();

	/**
	 * Apagar: pondrá el atributo estaArrancado a false, solo si la velocidadActual
	 * es 0
	 * 
	 * @param
	 * @Exception no se puede parar si está en marcha
	 */
	void apagar() throws Exception;
}
