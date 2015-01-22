package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.CriticidadFinal;


public class CriticidadFinalDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static CriticidadFinalDAO instancia;

    public static CriticidadFinalDAO getInstancia() {
        if (instancia == null) {
            instancia = new CriticidadFinalDAO();
        }
        return instancia;
    }
    
    public ArrayList<CriticidadFinal> obtenerCriticidadFinal() throws Exception {
        ArrayList<CriticidadFinal> lista = new ArrayList<CriticidadFinal>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_criticidad_final()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	CriticidadFinal objeto = new CriticidadFinal();
                objeto.setIdCriticidadFinal(rs.getInt("ID_CRITICIDAD_FINAL"));
                objeto.setDescripcionCriticidadFinal(rs.getString("DESCRIPCION_CRITICIDAD_FINAL"));
         
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
