package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SubDominio;

public class SubDominioDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SubDominioDAO instancia;

    public static SubDominioDAO getInstancia() {
        if (instancia == null) {
            instancia = new SubDominioDAO();
        }
        return instancia;
    }
    
    public ArrayList<SubDominio> obtenerSubDominio() throws Exception {
        ArrayList<SubDominio> lista = new ArrayList<SubDominio>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_sub_dominio()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SubDominio objeto = new SubDominio();
            	objeto.setIdSubDominio(rs.getInt("ID_SUB_DOMINIO"));
            	objeto.setIdDominio(rs.getInt("ID_DOMINIO"));
            	objeto.setDescripcionSubDominio(rs.getString("DESCRIPCION_SUB_DOMINIO"));
                lista.add(objeto);
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }
    
    public ArrayList<SubDominio> obtenerSubDominioPorDominio(int iddominio) throws Exception {
        ArrayList<SubDominio> lista = new ArrayList<SubDominio>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sub_dominio_GET_BY_dominio(?)");
            cs.setInt(1, iddominio);
            rs = cs.executeQuery();
            while (rs.next()) {
            	SubDominio objeto = new SubDominio();
            	objeto.setIdSubDominio(rs.getInt("ID_SUB_DOMINIO"));
            	objeto.setIdDominio(rs.getInt("ID_DOMINIO"));
            	objeto.setDescripcionSubDominio(rs.getString("DESCRIPCION_SUB_DOMINIO"));
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
