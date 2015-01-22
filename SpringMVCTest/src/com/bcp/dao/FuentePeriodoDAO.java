package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.FuentePeriodo;


public class FuentePeriodoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static FuentePeriodoDAO instancia;

    public static FuentePeriodoDAO getInstancia() {
        if (instancia == null) {
            instancia = new FuentePeriodoDAO();
        }
        return instancia;
    }
    
    public ArrayList<FuentePeriodo> obtenerFuentePeriodo() throws Exception {
        ArrayList<FuentePeriodo> lista = new ArrayList<FuentePeriodo>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_fuente_periodo()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	FuentePeriodo objeto = new FuentePeriodo();
                objeto.setIdFuentePeriodo(rs.getInt("ID_FUENTE_PERIODO"));
                objeto.setDescripcionFuentePeriodo(rs.getString("DESCRIPCION_FUENTE_PERIODO"));
         
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
