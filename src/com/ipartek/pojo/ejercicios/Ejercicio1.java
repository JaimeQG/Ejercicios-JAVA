package com.ipartek.pojo.ejercicios;

import com.ipartek.pojo.Perro;

/**
 * La historia de los 8 perros mas famosos.<br>
 * Crear 8 perros con su constructor por defecto y setear el nombre e
 * historia.<br>
 * 
 * @see <a href=
 *      "https://blog.patasbox.com/los-8-perros-mas-fomos-de-la-historia/">
 *      Enlace Web perros famosos </a>
 * 
 * @author Jaime
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		Perro c1 = new Perro();
		Perro c2 = new Perro("Pulgas");
		Perro c3 = new Perro("Goofy", "bichon", 6);

		Perro snoppy = new Perro();
		snoppy.setNombre("Snoppy");
		snoppy.setPeso(-13);

		Perro p2 = new Perro();
		p2.setNombre("Laika");
		p2.setPeso(-56);

		System.out.println(snoppy.getNombre() + " " + snoppy.getPeso());
		System.out.println(p2.getNombre() + " " + p2.getPeso());

		String[] nombresPerro = { "Laika", "Hachiko", "Balto", "Rin tin tin", "Stubby", "Pancho", "Greyfriars Bobby",
				"Smoky" };

		String[] historiaPerro = { "Historia Laika ...", "Historia Hachiko ...", "H Balto", "Rin tin tin", "Stubby",
				"Historia de Pancho ...", "H Greyfriars Bobby ...", "H Smoky ..." };

		Perro p = new Perro();

		System.out.println("Historia de los perros más famosos");

		for (int i = 0; i < nombresPerro.length; i++) {
			System.out.println("----------------------------------");
			p.setNombre(nombresPerro[i]);
			System.out.println(p.getNombre());

			p.setHistoria(historiaPerro[i]);
			System.out.println(p.getHistoria());
		}
	}
}
