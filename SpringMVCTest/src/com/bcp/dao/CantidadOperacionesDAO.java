package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.CantidadOperaciones;



public class CantidadOperacionesDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static CantidadOperacionesDAO instancia;

    public static CantidadOperacionesDAO getInstancia() {
        if (instancia == null) {
            instancia = new CantidadOperacionesDAO();
        }
        return instancia;
    }
    
    public ArrayList<CantidadOperaciones> obtenerCantidadOperaciones() throws Exception {
        ArrayList<CantidadOperaciones> lista = new ArrayList<CantidadOperaciones>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_cantidad_operaciones()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	CantidadOperaciones objeto = new CantidadOperaciones();
                objeto.setIdCantidadOperaciones(rs.getInt("ID_CANTIDAD_OPERACIONES"));
                objeto.setDescripcionCantidadOperaciones(rs.getString("DESCRIPCION_CANTIDAD_OPERACIONES"));
         
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
