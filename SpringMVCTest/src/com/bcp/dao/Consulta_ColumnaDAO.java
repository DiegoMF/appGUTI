package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Consulta;
import com.bcp.modelo.Consulta_Columna;


public class Consulta_ColumnaDAO {
	private Connection cnn = null;
	private ResultSet rs = null;
	private static Consulta_ColumnaDAO instancia;

	public static Consulta_ColumnaDAO getInstancia() {
		if (instancia == null) {
			instancia = new Consulta_ColumnaDAO();
		}
		return instancia;
	}

	public ArrayList<Consulta_Columna> buscar(int idConsulta_Seccion) throws Exception {
		ArrayList<Consulta_Columna> lista = new ArrayList<Consulta_Columna>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call Consulta_Columna_ListBY_Consulta_Seccion(?)");
			cs.setInt(1, idConsulta_Seccion);
			rs = cs.executeQuery();
			while (rs.next()) {
				Consulta_Columna objeto = new Consulta_Columna();

				objeto.setIdConsulta_Columna(rs.getInt("idConsulta_Columna"));
				objeto.setIdConsulta_Seccion(rs.getInt("idConsulta_Seccion"));
				objeto.setDescripcion(rs.getString("Descripcion"));
				objeto.setForaneo(rs.getBoolean("Foraneo"));
				objeto.setTabla(rs.getString("Tabla"));
				objeto.setTablaSeccion(rs.getString("TablaSeccion"));
				objeto.setColumnaForanea(rs.getString("ColumnaForanea"));
				objeto.setDescripcionForanea(rs.getString("DescripcionForanea"));
				objeto.setDescripcionResultado(rs.getString("DescripcionResultado"));
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
            cs = cnn.prepareCall("call consulta_INSERT(?,?,?,?)");
            cs.setString(1, consulta.getNombreConsulta());
            cs.setByte(2, consulta.getPredeterminado());
            cs.setString(3, consulta.getEstado() );
            cs.setString(4, consulta.getMatricula());
            
            
       
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

	
	public int modificarConsultaReporte(Consulta consulta) throws Exception{
		int id = 0;
        try {
        	
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call consulta_reporte_UPDATE(?,?,?,?,?,?)");
            cs.setInt(1, consulta.getIdReporte());


            cs.setString(2, consulta.getNombreReporte());
            cs.setString(3, consulta.getEstado());
            cs.setString(4, consulta.getFechaCreacion());
            cs.setString(5, consulta.getMatricula());
            cs.setBoolean(6, consulta.getTipo());
       
            rs = cs.executeQuery();
            while (rs.next()) {
            	id = rs.getInt("_ID_CONSULTA");                
            }
            
           
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return id;
		
	}
	
	
	public int ingresarConsultaReporte(Consulta consulta) throws Exception {
		int id = 0;
        try {
        	
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call consulta_reporte_INSERT(?,?,?,?,?)");
            cs.setString(1, consulta.getNombreReporte());
            cs.setString(2, consulta.getEstado());
            cs.setString(3, consulta.getFechaCreacion());
            cs.setString(4, consulta.getMatricula());
            cs.setBoolean(5, consulta.getTipo());
       
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
	            ArrayList<String> listaColumnas = new ArrayList<String>();
	    		listaColumnas = consulta.getColumnaDestino();
	            
	    		for (int i = 0; i < listaColumnas.size(); i++) {

	    			cs.setInt(1, consulta.getIdConsulta());
	    			cs.setInt(2, Integer.parseInt(listaColumnas.get(i)));  			
	    			cs.execute();
	    		}
	    	
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
            
            ArrayList<String> listaFiltros = new ArrayList<String>();
    		listaFiltros = consulta.getFiltroDestino();
    		

    		for (int i = 0; i < listaFiltros.size(); i++) {

    			cs.setInt(1, consulta.getIdConsulta());
    			cs.setInt(2, Integer.parseInt(listaFiltros.get(i)));
    			    			
    			cs.execute();
    		}

            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
