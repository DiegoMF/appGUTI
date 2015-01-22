package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Actividad;

public class ActividadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ActividadDAO instancia;

    public static ActividadDAO getInstancia() {
        if (instancia == null) {
            instancia = new ActividadDAO();
        }
        return instancia;
    }
    
    public ArrayList<Actividad> obtenerActividad() throws Exception {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_actividad()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Actividad objeto = new Actividad();
                objeto.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
                objeto.setIdProcesoClave(rs.getInt("ID_PROCESO_CLAVE"));
                objeto.setDescripcionActividad(rs.getString("DESCRIPCION_ACTIVIDAD"));
         
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
