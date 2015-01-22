package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Dominio;


public class DominioDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static DominioDAO instancia;

    public static DominioDAO getInstancia() {
        if (instancia == null) {
            instancia = new DominioDAO();
        }
        return instancia;
    }
    
    public ArrayList<Dominio> obtenerDominio() throws Exception {
        ArrayList<Dominio> lista = new ArrayList<Dominio>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_dominio()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Dominio objeto = new Dominio();
                objeto.setIdDominio(rs.getInt("ID_DOMINIO"));
                objeto.setDescripcionDominio(rs.getString("DESCRIPCION_DOMINIO"));
         
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
