package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SoporteAplicacion;

public class SoporteAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SoporteAplicacionDAO instancia;

    public static SoporteAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new SoporteAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<SoporteAplicacion> obtenerSoporteAplicacion() throws Exception {
        ArrayList<SoporteAplicacion> lista = new ArrayList<SoporteAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_soporte_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SoporteAplicacion objeto = new SoporteAplicacion();
                objeto.setIdSoporteAplicacion(rs.getInt("ID_SOPORTE_APLICACION"));
                objeto.setDescripcionSoporteAplicacion(rs.getString("DESCRIPCION_SOPORTE_APLICACION"));
         
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
