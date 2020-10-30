package com.ipartek.sqlite3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.pojo.Perro;

public class Ejercicio2 {

	public static void main(String[] args) throws SQLException {

		ArrayList<Perro> perros = new ArrayList<Perro>();

		// Connection conn =
		// DriverManager.getConnection("jdbc:sqlite:C:/sqlite/concesionario.db");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:ddbb/perrera.db");

		String sql = "SELECT * FROM perro ORDER BY nombre;";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			// System.out.println(rs.getInt("id") + rs.getString("nombre"));
			Perro p = new Perro();
			p.setId(rs.getInt("id"));
			p.setNombre(rs.getString("nombre"));
			p.setRaza(rs.getString("raza"));
			p.setPeso(rs.getFloat("peso"));
			p.setVacunado(rs.getBoolean("vacunado"));
			p.setHistoria(rs.getString("historia"));

			perros.add(p);
		}

		for (Perro perro : perros) {
			System.out.println(perro);
		}

		System.out.println("terminamos");

	}

}
