package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Area;


public class AreaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AreaDAO instancia;

    public static AreaDAO getInstancia() {
        if (instancia == null) {
            instancia = new AreaDAO();
        }
        return instancia;
    }
    
    public ArrayList<Area> obtenerArea() throws Exception {
        ArrayList<Area> lista = new ArrayList<Area>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_area()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Area objeto = new Area();
                objeto.setIdArea(rs.getInt("ID_AREA"));
                objeto.setDescripcionArea(rs.getString("DESCRIPCION_AREA"));
         
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
