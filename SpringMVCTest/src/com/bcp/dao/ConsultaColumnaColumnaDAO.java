package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Consulta;
import com.bcp.modelo.ConsultaColumnaColumna;

public class ConsultaColumnaColumnaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ConsultaColumnaColumnaDAO instancia;

    public static ConsultaColumnaColumnaDAO getInstancia() {
        if (instancia == null) {
            instancia = new ConsultaColumnaColumnaDAO();
        }
        return instancia;
    }
    
    public ArrayList<ConsultaColumnaColumna> obtenerAgrupacionporIdReporte(Consulta info) throws Exception {
    	ArrayList<ConsultaColumnaColumna> lista = new ArrayList<ConsultaColumnaColumna>();
		//ReporteFiltro objeto = new ReporteFiltro();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call consulta_reporteAgrupacion_porIdReporte_GET(?)");
            
            cs.setInt(1, info.getIdReporte());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ConsultaColumnaColumna objeto = new ConsultaColumnaColumna();
            	objeto.setNombreColumna(rs.getString("descripcion"));
            	objeto.setIdConsultaColumnaColumna(rs.getInt("idConsulta_Columna_Columna"));
              
            	lista.add(objeto);
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }
	public ArrayList<ConsultaColumnaColumna> obtener(int idConsulta) throws Exception {
		ArrayList<ConsultaColumnaColumna> lista = new ArrayList<ConsultaColumnaColumna>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call Consulta_Columna_Columna_GET_BY_Consulta(?)");
			cs.setInt(1, idConsulta);
			rs = cs.executeQuery();
			while (rs.next()) {
				ConsultaColumnaColumna objeto = new ConsultaColumnaColumna();

				objeto.setIdConsultaColumnaColumna(rs.getInt("idConsulta_Columna_Columna"));
				objeto.setIdConsultaColumna(rs.getInt("idConsulta_columna"));
				objeto.setIdConsulta(rs.getInt("idConsulta"));
				objeto.setDescripcion(rs.getString("Descripcion"));
				objeto.setTabla(rs.getString("tabla"));
				objeto.setForaneo(rs.getBoolean("foraneo"));
				objeto.setTablaSeccion(rs.getString("TablaSeccion"));
				objeto.setColumnaForanea(rs.getString("ColumnaForanea"));
				objeto.setDescripcionForanea(rs.getString("DescripcionForanea"));
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
