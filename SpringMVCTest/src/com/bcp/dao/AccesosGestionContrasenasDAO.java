package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosGestionContrasenas;



public class AccesosGestionContrasenasDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosGestionContrasenasDAO instancia;

    public static AccesosGestionContrasenasDAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosGestionContrasenasDAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosGestionContrasenas> obtenerAccesosGestionContrasenas() throws Exception {
        ArrayList<AccesosGestionContrasenas> lista = new ArrayList<AccesosGestionContrasenas>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesos_gestion_contrasenas()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosGestionContrasenas objeto = new AccesosGestionContrasenas();
                objeto.setIdAccesosGestionContrasenas(rs.getInt("ID_ACCESOS_GESTION_CONTRASENAS"));
                objeto.setDescripcionAccesosGestionContrasenas(rs.getString("DESCRIPCION_ACCESOS_GESTION_CONTRASENAS"));
         
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
