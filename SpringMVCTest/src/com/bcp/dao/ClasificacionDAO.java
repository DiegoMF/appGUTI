package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Clasificacion;



public class ClasificacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ClasificacionDAO instancia;

    public static ClasificacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClasificacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<Clasificacion> obtenerClasificacion() throws Exception {
        ArrayList<Clasificacion> lista = new ArrayList<Clasificacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_clasificacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Clasificacion objeto = new Clasificacion();
                objeto.setIdClasificacion(rs.getInt("ID_CLASIFICACION"));
                objeto.setDescripcionClasificacion(rs.getString("DESCRIPCION_CLASIFICACION"));
         
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
