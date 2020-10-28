package com.ipartek.ejercicios.interfaces.app.interfaces;

public interface IVehiculo {

	public static final int VEL_MAX_COCHE = 150;
	static final int VEL_MAX_BICI = 50;
	final int VEL_MAX_PATINETE = 80;

	/**
	 * Arrancar: pondrá el atributo estaArrancado a true.<br>
	 * Debe estar apagado para poder arrancarse
	 * 
	 * @param
	 */
	void Arrancar();

	/**
	 * Acelerar: incrementara la velocidad actual con el valor que se le pasa por
	 * parámetro sin sobrepasar el limite máximo de velocidad. Solo acelerara si el
	 * patinete esta encendido
	 * 
	 * @param int incrementoVel
	 */
	void Acelerar(int incrementoVel);

	/**
	 * Frenar: decrementara la velocidad actual con el valor que se le pasa por
	 * parámetro sin llegar a bajar de 0. Solo frenara si el patinete esta encendido
	 * 
	 * @param int decrementoVel
	 */
	void Frenar(int decrementoVel);

	/**
	 * Apagar: pondrá el atributo estaArrancado a false, solo si la velocidadActual
	 * es 0
	 * 
	 * @param
	 */
	void Apagar();

}
