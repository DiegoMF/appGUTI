package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Consulta;
import com.bcp.modelo.Consulta_Columna;
import com.bcp.modelo.ReporteColumna;

public class ReporteColumnaDAO {
	private Connection cnn = null;
	private ResultSet rs = null;
	private static ReporteColumnaDAO instancia;

	public static ReporteColumnaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ReporteColumnaDAO();
		}
		return instancia;
	}

	public ArrayList<ReporteColumna> buscar(int idReporteSeccion) throws Exception {
		ArrayList<ReporteColumna> lista = new ArrayList<ReporteColumna>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call reporteColumna_por_reporteSeccion_LISTAR(?)");
			cs.setInt(1, idReporteSeccion);
			
			rs = cs.executeQuery();
			while (rs.next()) {
				ReporteColumna objeto = new ReporteColumna();
				
				objeto.setIdReporteColumna(rs.getInt("id_reporte_columna"));
				objeto.setDescripcion(rs.getString("descripcion"));
				//objeto.setTabla(rs.getString(""));
				//objeto.setForaneo(rs.getBoolean(""));
				//objeto.setIdReporteSeccion(rs.getInt(""));
				
				
				lista.add(objeto);
			}

			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}
	

	

	public ArrayList<Consulta> buscarConsulta(Consulta consulta) throws Exception {
		ArrayList<Consulta> lista = new ArrayList<Consulta>();
		int i = 1;
		try {
			
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call consulta_BUSCAR(?,?)");
			cs.setString(1, consulta.getNombreConsulta());
			cs.setString(2, consulta.getEstado());
			
			rs = cs.executeQuery();
			while (rs.next()) {
				Consulta objeto = new Consulta();
				objeto.setNumero(i);
				objeto.setIdConsulta(rs.getInt("idConsulta"));
				objeto.setNombreConsulta(rs.getString("Descripcion"));
				objeto.setStrPredeterminado(rs.getString("Predeterminado"));
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
	
	public int ingresarConsulta(Consulta consulta) throws Exception {
		int id = 0;
        try {
        	
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call consulta_INSERT(?,?,?)");
            cs.setString(1, consulta.getNombreConsulta());
            cs.setByte(2, consulta.getPredeterminado());
            cs.setString(3, consulta.getEstado() );
            
       
            rs = cs.executeQuery();
            while (rs.next()) {
            	id = rs.getInt("ID_CONSULTA");                
            }
            
           
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return id;
    }
	public void ingresarColumna(Consulta consulta) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call consulta_columna_INSERT(?,?)");
	            cs.setInt(1, consulta.getIdConsulta());
	            cs.setInt(2, consulta.getIdConsultaColumna());   
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	public void ingresarFiltro(Consulta consulta) throws Exception {
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call consulta_filtro_INSERT(?,?)");
            cs.setInt(1, consulta.getIdConsulta());
            cs.setInt(2, consulta.getIdConsultaFiltro());
       
            cs.execute();
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
