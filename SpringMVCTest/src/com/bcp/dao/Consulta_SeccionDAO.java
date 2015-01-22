package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Consulta_Seccion;

public class Consulta_SeccionDAO {

	private Connection cnn = null;
	private ResultSet rs = null;
	private static Consulta_SeccionDAO instancia;

	public static Consulta_SeccionDAO getInstancia() {
		if (instancia == null) {
			instancia = new Consulta_SeccionDAO();
		}
		return instancia;
	}

	public ArrayList<Consulta_Seccion> buscar() throws Exception {
		ArrayList<Consulta_Seccion> lista = new ArrayList<Consulta_Seccion>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call Consulta_Seccion_List()");

			rs = cs.executeQuery();
			while (rs.next()) {
				Consulta_Seccion objeto = new Consulta_Seccion();

				objeto.setIdConsulta_Seccion(rs.getInt("idConsulta_Seccion"));
				objeto.setDescripcion(rs.getString("Descripcion"));

				lista.add(objeto);
			}

			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}

}
