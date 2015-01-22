package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.IncidentesCumplimientoCodigoMalicioso;

public class IncidentesCumplimientoCodigoMaliciosoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static IncidentesCumplimientoCodigoMaliciosoDAO instancia;

    public static IncidentesCumplimientoCodigoMaliciosoDAO getInstancia() {
        if (instancia == null) {
            instancia = new IncidentesCumplimientoCodigoMaliciosoDAO();
        }
        return instancia;
    }
    
    public ArrayList<IncidentesCumplimientoCodigoMalicioso> obtenerIncidentesCumplimientoCodigoMalicioso() throws Exception {
        ArrayList<IncidentesCumplimientoCodigoMalicioso> lista = new ArrayList<IncidentesCumplimientoCodigoMalicioso>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_incidentes_cumplimiento_codigo_malicioso()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	IncidentesCumplimientoCodigoMalicioso objeto = new IncidentesCumplimientoCodigoMalicioso();
                objeto.setIdIncidentesCumplimientoCodigoMalicioso(rs.getInt("ID_INCIDENTES_CUMPLIMIENTO_CODIGO_MALICIOSO"));
                objeto.setDescripcionIncidentesCumplimientoCodigoMalicioso(rs.getString("DESCRIPCION_INCIDENTES_CUMPLIMIENTO_CODIGO_MALICIOSO"));
         
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
