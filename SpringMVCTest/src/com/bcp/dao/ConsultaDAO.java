package com.bcp.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Consulta;
import com.bcp.modelo.Reporte;



public class ConsultaDAO {

	private Connection cnn = null;
	private ResultSet rs = null;
	private static ConsultaDAO instancia;

	public static ConsultaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ConsultaDAO();
		}
		return instancia;
	}
	
	public ArrayList<Consulta> buscarReporte(Consulta reporte) throws Exception {
		ArrayList<Consulta> lista = new ArrayList<Consulta>();
		int i = 1;
		try {
			System.out.println("llega al buscar reporte");

			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call consulta_reporte_BUSCAR(?,?,?,?)");
			cs.setString(1, reporte.getNombreReporte());
			//cs.setString(1, reporte.getNombreConsulta());
			System.out.println("nombre reporte:" + reporte.getNombreReporte());

			cs.setString(2, reporte.getEstado());
			cs.setString(3, reporte.getFechaCreacion());
			cs.setString(4, reporte.getMatricula());
			
	
			rs = cs.executeQuery();
			while (rs.next()) {
				Consulta objeto = new Consulta();
				objeto.setNumero(i);
				objeto.setIdReporte(rs.getInt("idConsulta"));
				System.out.println("id de reporte:" + objeto.getIdReporte());

				objeto.setNombreReporte(rs.getString("Descripcion"));
				System.out.println("nombre de reporte " + objeto.getNombreReporte());

				objeto.setFechaCreacion(rs.getString("fecha_creacion"));
				objeto.setMatricula(rs.getString("matricula"));
				objeto.setEstado(rs.getString("Activo"));
				
				
				lista.add(objeto);
				i++;
			}

			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}
	
	public Consulta obtenerReportePorId(Consulta info) throws Exception {
		Consulta objeto = new Consulta();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call consulta_obtenerReporte_porId__GET(?)");
            
            cs.setInt(1, info.getIdReporte());            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	objeto.setIdReporte(rs.getInt("idConsulta"));
            	objeto.setNombreReporte(rs.getString("Descripcion"));
            	objeto.setFechaCreacion(rs.getString("fecha_creacion"));
            	objeto.setMatricula(rs.getString("matricula"));
            	objeto.setEstado(rs.getString("Activo"));

            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
}
