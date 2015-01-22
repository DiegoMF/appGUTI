package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.InfraestructuraAplicacion;



public class InfraestructuraAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static InfraestructuraAplicacionDAO instancia;

    public static InfraestructuraAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new InfraestructuraAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<InfraestructuraAplicacion> obtenerInfraestructuraAplicacion() throws Exception {
        ArrayList<InfraestructuraAplicacion> lista = new ArrayList<InfraestructuraAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_infraestructura_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	InfraestructuraAplicacion objeto = new InfraestructuraAplicacion();
                objeto.setIdInfraestructuraAplicacion(rs.getInt("ID_INFRAESTRUCTURA_APLICACION"));
                objeto.setDescripcionInfraestructuraAplicacion(rs.getString("DESCRIPCION_INFRAESTRUCTURA_APLICACION"));
         
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
