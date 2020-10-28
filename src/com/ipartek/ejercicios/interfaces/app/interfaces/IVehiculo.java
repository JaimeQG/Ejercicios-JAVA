package com.ipartek.ejercicios.interfaces.app.interfaces;

public interface IVehiculo {

	public static final int VEL_MAX_COCHE = 150;
	static final int VEL_MAX_BICI = 50;
	final int VEL_MAX_PATINETE = 80;

	/**
	 * Arrancar: pondr� el atributo estaArrancado a true.<br>
	 * Debe estar apagado para poder arrancarse
	 * 
	 * @param
	 */
	void arrancar();

	/**
	 * Acelerar: incrementara la velocidad actual con el valor que se le pasa por
	 * par�metro sin sobrepasar el limite m�ximo de velocidad. Solo acelerara si el
	 * patinete esta encendido
	 * 
	 * @param int incrementoVel
	 */
	void acelerar(int incrementoVel);

	/**
	 * Frenar: decrementara la velocidad actual con el valor que se le pasa por
	 * par�metro sin llegar a bajar de 0. Solo frenara si el patinete esta encendido
	 * 
	 * @param int decrementoVel
	 */
	void frenar(int decrementoVel);

	/**
	 * Apagar: pondr� el atributo estaArrancado a false, solo si la velocidadActual
	 * es 0
	 * 
	 * @param
	 * @Exception no se puede parar si est� en marcha
	 */
	void apagar() throws Exception;

}
