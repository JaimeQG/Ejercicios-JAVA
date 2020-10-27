package com.ipartek.ejercicios.herencia;

import java.util.ArrayList;

import com.ipartek.pojo.Electrodomestico;
import com.ipartek.pojo.Television;
import com.ipartek.pojo.TelevisionPlana;

/**
 * Realizar el mismo ejercicio que en EjecicioElectrodomesticos, pero esta vez
 * hay que crear nuevos constructores para poder crear instancias con todos los
 * atributos.<br>
 * por ejemplo: <br>
 * 
 * <pre>
 *   
 *      TelevisionPlana tv = new TelevisionPlana("tele", 300, .., ..  );
 * </pre>
 * 
 * @see EjecicioElectrodomesticos
 * @author Jaime Quintana
 *
 */

public class EjercicioElectrodomesticos2 {

	static private ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>();

	public static void main(String[] args) {
		// Añadimos otro tipo de electrodomesticos a la lista
		Electrodomestico elec1 = new Electrodomestico("BALAY", (float) 499.99);

		// elec1.setNombre("BALAY");
		// elec1.setPrecio(300);

		lista.add(elec1);
		lista.add(new Electrodomestico("BOSCH", (float) 599.99));

		Television tele = new Television();
		tele.setNombre("ZENITH");
		tele.setPrecio(400);
		tele.setPulgadas(30);

		lista.add(tele);
		lista.add(new Television("SONY", (float) 999.99, 30));

		TelevisionPlana tv = new TelevisionPlana("LG", (float) 1100.99, 65, "OLED");
		lista.add(tv);
		lista.add(new TelevisionPlana("LG", (float) 1100.99, 65, "OLED"));

		for (Electrodomestico electrodomestico : lista) {
			System.out.println(electrodomestico);
		}

		// System.out.println(lista);

	}

}
