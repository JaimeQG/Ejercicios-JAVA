package com.ipartek.ejercicios.herencia;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.pojo.Electrodomestico;
import com.ipartek.pojo.Television;
import com.ipartek.pojo.TelevisionPlana;

/**
 * Realizar las siguientes jerarquías de herencia: tendremos una clase padre que
 * se llamara Electrodoméstico. Dicha clase contara con los atributos nombre y
 * precio. Se realizaran todos los constructores, métodos get y set
 * necesarios<br>
 * Una vez creada dicha clase, se creara una serie de clases hijas. La primera
 * será la clase televisor. Dicha clase contara con el atributo pulgadas, así
 * como con todos los constructores y métodos necesarios para rellenar sus
 * atributos, incluidos los del padre<br>
 * También se creara una clase televisionPlana, que heredara de televisión,
 * tendrá el atributo string tipo de pantalla ( tft, plasma,..) y constructores,
 * métodos get y set para rellenar los datos de los objetos que se creen,
 * incluyendo todos los atributos de los objetos de las clases padres de las que
 * heredan<br>
 * <p>
 * Una vez creado esta jerarquía de herencia, realizar un programa que nos pida
 * insertar televisiones planas dentro de un array de electrodomésticos. Dicho
 * array constara de 5 electodomesticos, pero lo rellenaremos con objetos de
 * tipo televisiónPlana.
 * </p>
 * 
 * @author Jaime Quintana
 *
 */

public class EjercicioElectrodomesticos {

	static private ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>();
	final static int NUM_ELECTRODOMESTICO = 5;

	public static void main(String[] args) {

		String nombreTV = "";
		int pulgadasTV = 0;
		String tipoPantalla = "";

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < NUM_ELECTRODOMESTICO; i++) {

			TelevisionPlana tp = new TelevisionPlana();

			// Marca de la TV
			System.out.println("Introduce la marca de la TV[" + (i + 1) + "]:");
			nombreTV = sc.nextLine();
			tp.setNombre(nombreTV);

			// Pulgadas de la TV
			try {
				System.out.println("Introduce las pulgadas de la TV[" + (i + 1) + "]:");
				pulgadasTV = Integer.parseInt(sc.nextLine());
				tp.setPulgadas(pulgadasTV);
			} catch (Exception e) {
				// si quereis ver la traza de la Excepcion, usar e.printStackTrace()
				e.printStackTrace();
				System.out.println("Error genérico");
			}

			// Tipo de Pantalla
			System.out.println("Introduce el tipo de pantalla de la TV[" + (i + 1) + "]:");
			tipoPantalla = sc.nextLine();
			tp.setTipoPantalla(tipoPantalla);

			// Añadimos la TV en el ArrayList de electrodomesticos
			lista.add(tp);

		} // End for

		// Añadimos otro tipo de electrodomesticos a la lista
		Electrodomestico elec1 = new Electrodomestico();
		elec1.setNombre("BALAY");
		elec1.setPrecio(300);

		lista.add(elec1);

		Television tele = new Television();
		tele.setNombre("ZENITH");
		tele.setPrecio(400);
		tele.setPulgadas(30);

		lista.add(tele);

		TelevisionPlana tele2 = new TelevisionPlana();
		tele2.setNombre("LG enorme");
		tele2.setPrecio(600);
		tele2.setPulgadas(100);
		tele2.setTipoPantalla("OLED");

		lista.add(tele2);

		for (Electrodomestico elec : lista) {

			// En vez de usar syso, castear y mostrar datos con getters
			// Cuando tenemos dentro del ArrayList objetos de distinto tipo
			// System.out.println(elec.toString());

			// CUIDADDO con la Exception, hay que preguntar siempre con instanceof,
			// descomentar la línea de abajo y probar
			// TelevisionPlana ttt = (TelevisionPlana)elec;

			if (elec instanceof Electrodomestico) {
				System.out.printf("Nombre: % s \n", elec.getNombre());
				System.out.printf("Precio % s \n", elec.getPrecio());

				// podemos castear usando (Television) y asi nos permite acceder al los metodos
				// de esa clase
				// ((Television) elec).getPulgadas();
			}

			if (elec instanceof Television) {
				Television tv = (Television) elec;
				System.out.printf("Pulgadas: %s \n", tv.getPulgadas());
			}

			if (elec instanceof TelevisionPlana) {

				// tambien podemos castear y asignarlo a una variable nueva
				TelevisionPlana tvp = (TelevisionPlana) elec;
				System.out.printf("Tipo pantalla %s", tvp.getTipoPantalla());
				tvp.getTipoPantalla();
			}

			System.out.println("--------------------------------------------");

		} // for

		System.out.println("** FIN PROGRAMA **");

		sc.close();

	}// main

}// class
