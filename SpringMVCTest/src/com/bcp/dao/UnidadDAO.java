package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Unidad;


public class UnidadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static UnidadDAO instancia;

    public static UnidadDAO getInstancia() {
        if (instancia == null) {
            instancia = new UnidadDAO();
        }
        return instancia;
    }
    
    public ArrayList<Unidad> obtenerUnidad() throws Exception {
        ArrayList<Unidad> lista = new ArrayList<Unidad>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_unidad()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Unidad objeto = new Unidad();
                objeto.setIdUnidad(rs.getInt("ID_UNIDAD"));
                objeto.setDescripcionUnidad(rs.getString("DESCRIPCION_UNIDAD"));
         
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
