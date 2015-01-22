package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.FrecuenciaOperaciones;


public class FrecuenciaOperacionesDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static FrecuenciaOperacionesDAO instancia;

    public static FrecuenciaOperacionesDAO getInstancia() {
        if (instancia == null) {
            instancia = new FrecuenciaOperacionesDAO();
        }
        return instancia;
    }
    
    public ArrayList<FrecuenciaOperaciones> obtenerFrecuenciaOperaciones() throws Exception {
        ArrayList<FrecuenciaOperaciones> lista = new ArrayList<FrecuenciaOperaciones>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_frecuencia_operaciones()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	FrecuenciaOperaciones objeto = new FrecuenciaOperaciones();
                objeto.setIdFrecuenciaOperaciones(rs.getInt("ID_FRECUENCIA_OPERACIONES"));
                objeto.setDescripcionFrecuenciaOperaciones(rs.getString("DESCRIPCION_FRECUENCIA_OPERACIONES"));
         
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
