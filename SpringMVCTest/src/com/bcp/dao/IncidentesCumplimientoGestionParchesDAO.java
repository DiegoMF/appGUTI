package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.IncidentesCumplimientoGestionParches;


public class IncidentesCumplimientoGestionParchesDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static IncidentesCumplimientoGestionParchesDAO instancia;

    public static IncidentesCumplimientoGestionParchesDAO getInstancia() {
        if (instancia == null) {
            instancia = new IncidentesCumplimientoGestionParchesDAO();
        }
        return instancia;
    }
    
    public ArrayList<IncidentesCumplimientoGestionParches> obtenerGestionParches() throws Exception {
        ArrayList<IncidentesCumplimientoGestionParches> lista = new ArrayList<IncidentesCumplimientoGestionParches>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_incidentes_cumplimiento_gestion_parches()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	IncidentesCumplimientoGestionParches objeto = new IncidentesCumplimientoGestionParches();
                objeto.setIdIncidentesCumplimientoGestionParches(rs.getInt("ID_INCIDENTES_CUMPLIMIENTO_GESTION_PARCHES"));
                objeto.setDescripcionIncidentesCumplimientoGestionParches(rs.getString("DESCRIPCION_INCIDENTES_CUMPLIMIENTO_GESTION_PARCHES"));
         
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
