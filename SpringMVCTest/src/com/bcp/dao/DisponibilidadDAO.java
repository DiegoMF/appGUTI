package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Disponibilidad;

public class DisponibilidadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static DisponibilidadDAO instancia;

    public static DisponibilidadDAO getInstancia() {
        if (instancia == null) {
            instancia = new DisponibilidadDAO();
        }
        return instancia;
    }
    
    public ArrayList<Disponibilidad> obtenerDisponibilidad() throws Exception {
        ArrayList<Disponibilidad> lista = new ArrayList<Disponibilidad>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_disponibilidad()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Disponibilidad objeto = new Disponibilidad();
                objeto.setIdDisponibilidad(rs.getInt("ID_DISPONIBILIDAD"));
                objeto.setDescripcionDisponibilidad(rs.getString("DESCRIPCION_DISPONIBILIDAD"));
         
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
