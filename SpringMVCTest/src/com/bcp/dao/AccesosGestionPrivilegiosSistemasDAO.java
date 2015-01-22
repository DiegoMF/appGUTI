package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosGestionPrivilegiosSistemas;


public class AccesosGestionPrivilegiosSistemasDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosGestionPrivilegiosSistemasDAO instancia;

    public static AccesosGestionPrivilegiosSistemasDAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosGestionPrivilegiosSistemasDAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosGestionPrivilegiosSistemas> obtenerAccesosGestionPrivilegiosSistemas() throws Exception {
        ArrayList<AccesosGestionPrivilegiosSistemas> lista = new ArrayList<AccesosGestionPrivilegiosSistemas>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtenerAccesosGestionPrivilegiosSistemas()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosGestionPrivilegiosSistemas objeto = new AccesosGestionPrivilegiosSistemas();
                objeto.setIdAccesosGestionPrivilegiosSistemas(rs.getInt("ID_ACCESOS_GESTION_PRIVILEGIOS_SISTEMAS"));
                objeto.setDescripcionAccesosGestionPrivilegiosSistemas(rs.getString("DESCRIPCION_ACCESOS_GESTION_PRIVILEGIOS_SISTEMAS"));
         
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
