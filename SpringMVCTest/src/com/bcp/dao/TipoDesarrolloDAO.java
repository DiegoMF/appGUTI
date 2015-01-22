package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.TipoDesarrollo;


public class TipoDesarrolloDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static TipoDesarrolloDAO instancia;

    public static TipoDesarrolloDAO getInstancia() {
        if (instancia == null) {
            instancia = new TipoDesarrolloDAO();
        }
        return instancia;
    }
    
    public ArrayList<TipoDesarrollo> obtenerTipoDesarrollo() throws Exception {
        ArrayList<TipoDesarrollo> lista = new ArrayList<TipoDesarrollo>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_tipo_desarrollo()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	TipoDesarrollo objeto = new TipoDesarrollo();
                objeto.setIdTipoDesarrollo(rs.getInt("ID_TIPO_DESARROLLO"));
                objeto.setDescripcionTipoDesarrollo(rs.getString("DESCRIPCION_TIPO_DESARROLLO"));
         
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
