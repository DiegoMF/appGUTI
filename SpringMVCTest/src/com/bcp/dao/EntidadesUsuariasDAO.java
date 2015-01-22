package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.EntidadesUsuarias;



public class EntidadesUsuariasDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static EntidadesUsuariasDAO instancia;

    public static EntidadesUsuariasDAO getInstancia() {
        if (instancia == null) {
            instancia = new EntidadesUsuariasDAO();
        }
        return instancia;
    }
    
    public ArrayList<EntidadesUsuarias> obtenerEntidadesUsuarias() throws Exception {
        ArrayList<EntidadesUsuarias> lista = new ArrayList<EntidadesUsuarias>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_entidades_usuarias()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	EntidadesUsuarias objeto = new EntidadesUsuarias();
                objeto.setIdEntidadesUsuarias(rs.getInt("ID_ENTIDADES_USUARIAS"));
                objeto.setDescripcionEntidadesUsuarias(rs.getString("DESCRIPCION_ENTIDADES_USUARIAS"));
         
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
