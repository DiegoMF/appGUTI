package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.EstadoAplicacion;


public class EstadoAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static EstadoAplicacionDAO instancia;

    public static EstadoAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstadoAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<EstadoAplicacion> obtenerEstadoAplicacion() throws Exception {
        ArrayList<EstadoAplicacion> lista = new ArrayList<EstadoAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_estado_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	EstadoAplicacion objeto = new EstadoAplicacion();
                objeto.setIdEstadoAplicacion(rs.getInt("ID_ESTADO_APLICACION"));
                objeto.setDescripcionEstadoAplicacion(rs.getString("DESCRIPCION_ESTADO_APLICACION"));
         
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
