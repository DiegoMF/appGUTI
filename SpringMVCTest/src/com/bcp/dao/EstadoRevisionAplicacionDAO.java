package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.EstadoRevisionAplicacion;




public class EstadoRevisionAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static EstadoRevisionAplicacionDAO instancia;

    public static EstadoRevisionAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstadoRevisionAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<EstadoRevisionAplicacion> obtenerEstadoRevisionAplicacion() throws Exception {
        ArrayList<EstadoRevisionAplicacion> lista = new ArrayList<EstadoRevisionAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_estado_revision_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	EstadoRevisionAplicacion objeto = new EstadoRevisionAplicacion();
                objeto.setIdEstadoRevisionAplicacion(rs.getInt("ID_ESTADO_REVISION_APLICACION"));
                objeto.setDescripcionEstadoRevisionAplicacion(rs.getString("DESCRIPCION_ESTADO_REVISION_APLICACION"));
         
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


