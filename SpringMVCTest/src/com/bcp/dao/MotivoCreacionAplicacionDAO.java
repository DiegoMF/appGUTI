package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MotivoCreacionAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static MotivoCreacionAplicacionDAO instancia;

    public static MotivoCreacionAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new MotivoCreacionAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<MotivoCreacionAplicacion> obtenerMotivoCreacionAplicacion() throws Exception {
        ArrayList<MotivoCreacionAplicacion> lista = new ArrayList<MotivoCreacionAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_motivo_creacion_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	MotivoCreacionAplicacion objeto = new MotivoCreacionAplicacion();
                objeto.setIdMotivoCreacionAplicacion(rs.getInt("ID_MOTIVO_CREACION_APLICACION"));
                objeto.setDescripcionMotivoCreacionAplicacion(rs.getString("DESCRIPCION_MOTIVO_CREACION_APLICACION"));
         
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
