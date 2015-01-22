package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.ProcesoAuditoria;



public class ProcesoAuditoriaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ProcesoAuditoriaDAO instancia;

    public static ProcesoAuditoriaDAO getInstancia() {
        if (instancia == null) {
            instancia = new ProcesoAuditoriaDAO();
        }
        return instancia;
    }
    
    public ArrayList<ProcesoAuditoria> obtenerProcesoAuditoria() throws Exception {
        ArrayList<ProcesoAuditoria> lista = new ArrayList<ProcesoAuditoria>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_proceso_auditoria()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ProcesoAuditoria objeto = new ProcesoAuditoria();
                objeto.setIdProcesoAuditoria(rs.getInt("ID_PROCESO_AUDITORIA"));
                objeto.setDescripcionProcesoAuditoria(rs.getString("DESCRIPCION_PROCESO_AUDITORIA"));
         
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
