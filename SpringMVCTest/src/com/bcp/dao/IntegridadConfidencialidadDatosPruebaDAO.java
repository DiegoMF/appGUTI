package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.IntegridadConfidencialidadDatosPrueba;

public class IntegridadConfidencialidadDatosPruebaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static IntegridadConfidencialidadDatosPruebaDAO instancia;

    public static IntegridadConfidencialidadDatosPruebaDAO getInstancia() {
        if (instancia == null) {
            instancia = new IntegridadConfidencialidadDatosPruebaDAO();
        }
        return instancia;
    }
    
    public ArrayList<IntegridadConfidencialidadDatosPrueba> obtenerIntegridadConfidencialidadDatosPrueba() throws Exception {
        ArrayList<IntegridadConfidencialidadDatosPrueba> lista = new ArrayList<IntegridadConfidencialidadDatosPrueba>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_integridad_confidencialidad_datos_prueba()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	IntegridadConfidencialidadDatosPrueba objeto = new IntegridadConfidencialidadDatosPrueba();
                objeto.setIdIntegridadConfidencialidadDatosPrueba(rs.getInt("ID_INTEGRIDAD_CONFIDENCIALIDAD_DATOS_PRUEBA"));
                objeto.setDescripcionIntegridadConfidencialidadDatosPrueba(rs.getString("DESCRIPCION_INTEGRIDAD_CONFIDENCIALIDAD_DATOS_PRUEBA"));
         
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
