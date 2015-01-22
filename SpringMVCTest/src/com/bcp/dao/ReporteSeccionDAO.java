package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.bcp.modelo.ReporteSeccion;

public class ReporteSeccionDAO {
	private Connection cnn = null;
	private ResultSet rs = null;
	private static ReporteSeccionDAO instancia;

	public static ReporteSeccionDAO getInstancia() {
		if (instancia == null) {
			instancia = new ReporteSeccionDAO();
		}
		return instancia;
	}

	public ArrayList<ReporteSeccion> buscar() throws Exception {
		ArrayList<ReporteSeccion> lista = new ArrayList<ReporteSeccion>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call reporteSeccion_LIST()");

			rs = cs.executeQuery();
			while (rs.next()) {
				ReporteSeccion objeto = new ReporteSeccion();
				
				objeto.setIdReporteSeccion(rs.getInt("id_reporte_seccion"));
				objeto.setDescripcion(rs.getString("descripcion"));


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
