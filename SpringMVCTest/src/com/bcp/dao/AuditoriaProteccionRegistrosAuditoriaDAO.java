package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AuditoriaProteccionRegistrosAuditoria;

public class AuditoriaProteccionRegistrosAuditoriaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AuditoriaProteccionRegistrosAuditoriaDAO instancia;

    public static AuditoriaProteccionRegistrosAuditoriaDAO getInstancia() {
        if (instancia == null) {
            instancia = new AuditoriaProteccionRegistrosAuditoriaDAO();
        }
        return instancia;
    }
    
    public ArrayList<AuditoriaProteccionRegistrosAuditoria> obtenerProteccionRegistroAuditoria() throws Exception {
        ArrayList<AuditoriaProteccionRegistrosAuditoria> lista = new ArrayList<AuditoriaProteccionRegistrosAuditoria>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_proteccion_registros_auditoria()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AuditoriaProteccionRegistrosAuditoria objeto = new AuditoriaProteccionRegistrosAuditoria();
                objeto.setIdAuditoriaProteccionRegistrosAuditoria(rs.getInt("ID_AUDITORIA_PROTECCION_REGISTROS_AUDITORIA"));
                objeto.setDescripcionAuditoriaProteccionRegistrosAuditoria(rs.getString("DESCRIPCION_AUDITORIA_PROTECCION_REGISTROS_AUDITORIA"));
         
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
