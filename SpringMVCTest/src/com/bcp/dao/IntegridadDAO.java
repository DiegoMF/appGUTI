package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Integridad;


public class IntegridadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static IntegridadDAO instancia;

    public static IntegridadDAO getInstancia() {
        if (instancia == null) {
            instancia = new IntegridadDAO();
        }
        return instancia;
    }
    
    public ArrayList<Integridad> obtenerIntegridad() throws Exception {
        ArrayList<Integridad> lista = new ArrayList<Integridad>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_integridad()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Integridad objeto = new Integridad();
                objeto.setIdIntegridad(rs.getInt("ID_INTEGRIDAD"));
                objeto.setDescripcionIntegridad(rs.getString("DESCRIPCION_INTEGRIDAD"));
         
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
