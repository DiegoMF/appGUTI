package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Privacidad;

public class PrivacidadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static PrivacidadDAO instancia;

    public static PrivacidadDAO getInstancia() {
        if (instancia == null) {
            instancia = new PrivacidadDAO();
        }
        return instancia;
    }
    
    public ArrayList<Privacidad> obtenerPrivacidad() throws Exception {
        ArrayList<Privacidad> lista = new ArrayList<Privacidad>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_privacidad()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Privacidad objeto = new Privacidad();
                objeto.setIdPrivacidad(rs.getInt("ID_PRIVACIDAD"));
                objeto.setDescripcionPrivacidad(rs.getString("DESCRIPCION_PRIVACIDAD"));
         
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
