package com.bcp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.GerenciaCentral;


public class GerenciaCentralDAO {
	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static GerenciaCentralDAO instancia;

    public static GerenciaCentralDAO getInstancia() {
        if (instancia == null) {
            instancia = new GerenciaCentralDAO();
        }
        return instancia;
    }
    
    public ArrayList<GerenciaCentral> obtenerGerenciaCentral() throws Exception {
        ArrayList<GerenciaCentral> lista = new ArrayList<GerenciaCentral>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_gerencia_central()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
                GerenciaCentral objeto = new GerenciaCentral();
                objeto.setIdGerenciaCentral(rs.getInt("ID_GERENCIA_CENTRAL"));
                objeto.setDescripcionGerenciaCentral(rs.getString("DESCRIPCION_GERENCIA_CENTRAL"));
         
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
