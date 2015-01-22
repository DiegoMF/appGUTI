package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.DocumentacionManejo;


public class DocumentacionManejoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static DocumentacionManejoDAO instancia;

    public static DocumentacionManejoDAO getInstancia() {
        if (instancia == null) {
            instancia = new DocumentacionManejoDAO();
        }
        return instancia;
    }
    
    public ArrayList<DocumentacionManejo> obtenerDocumentacionManejo() throws Exception {
        ArrayList<DocumentacionManejo> lista = new ArrayList<DocumentacionManejo>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_documentacion_manejo()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	DocumentacionManejo objeto = new DocumentacionManejo();
                objeto.setIdDocumentacionManejo(rs.getInt("ID_DOCUMENTACION_MANEJO"));
                objeto.setDescripcionDocumentacionManejo(rs.getString("DESCRIPCION_DOCUMENTACION_MANEJO"));
         
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
