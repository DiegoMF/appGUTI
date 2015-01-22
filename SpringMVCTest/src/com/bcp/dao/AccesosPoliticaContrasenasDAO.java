package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosPoliticaContrasenas;

public class AccesosPoliticaContrasenasDAO {

private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosPoliticaContrasenasDAO instancia;

    public static AccesosPoliticaContrasenasDAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosPoliticaContrasenasDAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosPoliticaContrasenas> obtenerAccesosPoliticasContrasenas() throws Exception {
        ArrayList<AccesosPoliticaContrasenas> lista = new ArrayList<AccesosPoliticaContrasenas>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesos_politicas_contrasenas()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosPoliticaContrasenas objeto = new AccesosPoliticaContrasenas();
                objeto.setIdAccesosPoliticaContrasenas(rs.getInt("ID_ACCESOS_POLITICA_CONTRASENAS"));
                objeto.setDescripcionAccesosPoliticaContrasenas(rs.getString("DESCRIPCION_ACCESOS_POLITICA_CONTRASENAS"));
         
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
