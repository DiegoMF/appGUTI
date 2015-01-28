
package com.bcp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.appengine.api.utils.SystemProperty;

public class Conexion {

	public static Connection getConexion() throws Exception {
		Connection con = null;
		/*
		 * conexio en la Nube String usuario = "root"; String clave = "123456";
		 * String url = "jdbc:mysql://127.0.0.1:3306/dbtest";
		 */

		/* conexion local */
		String usuario = "admin";
		String clave = "admin";
		String url = "jdbc:mysql://127.0.0.1:3306/dbtest";

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			// Load the class that provides the new "jdbc:google:mysql://"
			// prefix.
			usuario = "root";
			clave = "";
			Class.forName("com.mysql.jdbc.GoogleDriver");
			url = "jdbc:google:mysql://everisgaetest:portafolio/BDPortafolio?useUnicode=true&characterEncoding=UTF-8";

		} else {

			Class.forName("com.mysql.jdbc.Driver");
			// url = "jdbc:mysql://localhost:3306/bdportafolio1";

			url = "jdbc:mysql://7.227.104.201:8282/bdportafolio";

		}

		con = DriverManager.getConnection(url, usuario, clave);

		return con;

	}
}
