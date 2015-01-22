package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.ControlCambiosProcedimientosSw;

public class ControlCambiosProcedimientosSwDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ControlCambiosProcedimientosSwDAO instancia;

    public static ControlCambiosProcedimientosSwDAO getInstancia() {
        if (instancia == null) {
            instancia = new ControlCambiosProcedimientosSwDAO();
        }
        return instancia;
    }
    
    public ArrayList<ControlCambiosProcedimientosSw> obtenerControlCambios() throws Exception {
        ArrayList<ControlCambiosProcedimientosSw> lista = new ArrayList<ControlCambiosProcedimientosSw>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_control_cambios_procedimientos_sw()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ControlCambiosProcedimientosSw objeto = new ControlCambiosProcedimientosSw();
                objeto.setIdControlCambiosProcedimientosSw(rs.getInt("ID_CONTROL_CAMBIOS_PROCEDIMIENTOS_SW"));
                objeto.setDescripcionControlCambiosProcedimientosSw(rs.getString("DESCRIPCION_CONTROL_CAMBIOS_PROCEDIMIENTOS_SW"));
         
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
