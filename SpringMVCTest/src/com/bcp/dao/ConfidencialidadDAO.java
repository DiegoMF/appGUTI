package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Confidencialidad;


public class ConfidencialidadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ConfidencialidadDAO instancia;

    public static ConfidencialidadDAO getInstancia() {
        if (instancia == null) {
            instancia = new ConfidencialidadDAO();
        }
        return instancia;
    }
    
    public ArrayList<Confidencialidad> obtenerConfidencialidad() throws Exception {
        ArrayList<Confidencialidad> lista = new ArrayList<Confidencialidad>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_confidencialidad()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Confidencialidad objeto = new Confidencialidad();
                objeto.setIdConfidencialidad(rs.getInt("ID_CONFIDENCIALIDAD"));
                objeto.setDecripcionConfidencialidad(rs.getString("DESCRIPCION_CONFIDENCIALIDAD"));
         
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
