package com.ipartek.ejercicios.sepe;

public interface IConducible {

	/**
	 * Arrancar: pondr� el atributo estaArrancado a true.<br>
	 * Debe estar apagado para poder arrancarse
	 * 
	 * @param
	 */
	void arrancar();

	/**
	 * Apagar: pondr� el atributo estaArrancado a false, solo si la velocidadActual
	 * es 0
	 * 
	 * @param
	 * @Exception no se puede parar si est� en marcha
	 */
	void apagar() throws Exception;
}
