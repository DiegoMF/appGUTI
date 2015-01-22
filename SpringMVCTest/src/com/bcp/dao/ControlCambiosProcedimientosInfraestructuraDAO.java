package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.ControlCambiosProcedimientosInfraestructura;


public class ControlCambiosProcedimientosInfraestructuraDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ControlCambiosProcedimientosInfraestructuraDAO instancia;

    public static ControlCambiosProcedimientosInfraestructuraDAO getInstancia() {
        if (instancia == null) {
            instancia = new ControlCambiosProcedimientosInfraestructuraDAO();
        }
        return instancia;
    }
    
    public ArrayList<ControlCambiosProcedimientosInfraestructura> obtenerControlCambiosProcedimientosInfraestructura() throws Exception {
        ArrayList<ControlCambiosProcedimientosInfraestructura> lista = new ArrayList<ControlCambiosProcedimientosInfraestructura>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_control_cambios_procedimientos_infraestructura()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ControlCambiosProcedimientosInfraestructura objeto = new ControlCambiosProcedimientosInfraestructura();
                objeto.setIdControlCambiosProcedimientosInfraestructura(rs.getInt("ID_CONTROL_CAMBIOS_PROCEDIMIENTOS_INFRAESTRUCTURA"));
                objeto.setDescripcionControlCambiosProcedimientosInfraestructura(rs.getString("DESCRIPCION_CONTROL_CAMBIOS_PROCEDIMIENTOS_INFRAESTRUCTURA"));
         
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
