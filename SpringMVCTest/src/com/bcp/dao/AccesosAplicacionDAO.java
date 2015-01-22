package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosAplicacion;

public class AccesosAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosAplicacionDAO instancia;

    public static AccesosAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosAplicacion> obtenerAccesosAplicacion() throws Exception {
        ArrayList<AccesosAplicacion> lista = new ArrayList<AccesosAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesos_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosAplicacion objeto = new AccesosAplicacion();
                objeto.setIdAccesosAplicacion(rs.getInt("ID_ACCESOS_APLICACION"));
                objeto.setDescripcionAccesosAplicacion(rs.getString("DESCRIPCION_ACCESOS_APLICACION"));
         
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
