package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.IncidentesCumplimientoPoliticasAntivirus;

public class IncidentesCumplimientoPoliticasAntivirusDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static IncidentesCumplimientoPoliticasAntivirusDAO instancia;

    public static IncidentesCumplimientoPoliticasAntivirusDAO getInstancia() {
        if (instancia == null) {
            instancia = new IncidentesCumplimientoPoliticasAntivirusDAO();
        }
        return instancia;
    }
    
    public ArrayList<IncidentesCumplimientoPoliticasAntivirus> obtenerIncidentesCumplimientoPoliticasA() throws Exception {
        ArrayList<IncidentesCumplimientoPoliticasAntivirus> lista = new ArrayList<IncidentesCumplimientoPoliticasAntivirus>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_incidentes_cumplimiento_politicas_antivirus()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	IncidentesCumplimientoPoliticasAntivirus objeto = new IncidentesCumplimientoPoliticasAntivirus();
                objeto.setIdIncidentesCumplimientoPoliticasAntivirus(rs.getInt("ID_INCIDENTES_CUMPLIMIENTO_POLITICAS_ANTIVIRUS"));
                objeto.setDescripcionIncidentesCumplimientoPoliticasAntivirus(rs.getString("DESCRIPCION_INCIDENTES_CUMPLIMIENTO_POLITICAS_ANTIVIRUS"));
         
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
