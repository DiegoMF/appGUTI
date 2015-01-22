package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Contingencia;

public class ContingenciaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ContingenciaDAO instancia;

    public static ContingenciaDAO getInstancia() {
        if (instancia == null) {
            instancia = new ContingenciaDAO();
        }
        return instancia;
    }
    
    public ArrayList<Contingencia> obtenerContingencia() throws Exception {
        ArrayList<Contingencia> lista = new ArrayList<Contingencia>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_contingencia()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Contingencia objeto = new Contingencia();
                objeto.setIdContingencia(rs.getInt("ID_CONTINGENCIA"));
                objeto.setDescripcionContingencia(rs.getString("DESCRIPCION_CONTINGENCIA"));
         
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
