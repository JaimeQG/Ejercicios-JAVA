package com.ipartek;

import com.ipartek.pojo.Serie;

/**
 * Interfaz para obligar a implementar una serie de metodos.
 * 
 * @author ur00
 *
 */
public interface IFunciones {

	public static final int LOTERIA_EUROMILLON = 1;
	final int LOTERIA_QUINIELA = 2;
	static int LOTERIA_BONOLOTO = 3;
	int LOTERIA_NACIONAL = 4;

	/**
	 * pedir nombre por Scanner
	 * 
	 * @throws si el nombre es menor de una letra o contiene numeros
	 * @return nombre escrito
	 */
	public abstract String pedirNombre() throws Exception;

	/**
	 * imprime los numeros de la Loteria<br>
	 * 
	 * @param tipoLoteria int Tenemos definidas las siguientes constantes:
	 * 
	 *                    <pre>
	 *                    final int LOTERIA_EUROMILLON = 1;
	 *                    final int LOTERIA_QUINIELA = 2;
	 *                    final int LOTERIA_BONOLOTO = 3;
	 *                    </pre>
	 * 
	 * @throws si el tipoLoteria no existe
	 */
	void imprimirNumeroLoteria(int tipoLoteria) throws Exception;

	/**
	 * calcula las vueltas
	 * 
	 * @param dineroEntregado float
	 * @param precioProducto  float
	 * @return float son las vueltas
	 * @throws Exception si precioProducto > dineroEntregado
	 */
	float calcularVueltas(float dineroEntregado, float precioProducto) throws Exception;

	/**
	 * Pedimos todos los datos de una serie por consola
	 * 
	 * @return Serie
	 */
	Serie pedirDatosPorConsola();
}