package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AuditoriaRegistroAuditoria;


public class AuditoriaRegistroAuditoriaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AuditoriaRegistroAuditoriaDAO instancia;

    public static AuditoriaRegistroAuditoriaDAO getInstancia() {
        if (instancia == null) {
            instancia = new AuditoriaRegistroAuditoriaDAO();
        }
        return instancia;
    }
    
    public ArrayList<AuditoriaRegistroAuditoria> obtenerRegistroAuditoria() throws Exception {
        ArrayList<AuditoriaRegistroAuditoria> lista = new ArrayList<AuditoriaRegistroAuditoria>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_registro_auditoria()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AuditoriaRegistroAuditoria objeto = new AuditoriaRegistroAuditoria();
                objeto.setIdAuditoriaRegistroAuditoria(rs.getInt("ID_AUDITORIA_REGISTRO_AUDITORIA"));
                objeto.setDescripcionAuditoriaRegistroAuditoria(rs.getString("DESCRIPCION_AUDITORIA_REGISTRO_AUDITORIA"));
         
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
