package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AuditoriaConformidadPoliticas;

public class AuditoriaConformidadPoliticasDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AuditoriaConformidadPoliticasDAO instancia;

    public static AuditoriaConformidadPoliticasDAO getInstancia() {
        if (instancia == null) {
            instancia = new AuditoriaConformidadPoliticasDAO();
        }
        return instancia;
    }
    
    public ArrayList<AuditoriaConformidadPoliticas> obtenerAuditoriaConformidadPoliticas() throws Exception {
        ArrayList<AuditoriaConformidadPoliticas> lista = new ArrayList<AuditoriaConformidadPoliticas>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_auditoria_conformidad_politicas()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AuditoriaConformidadPoliticas objeto = new AuditoriaConformidadPoliticas();
                objeto.setIdAuditoriaConformidadPoliticas(rs.getInt("ID_AUDITORIA_CONFORMIDAD_POLITICAS"));
                objeto.setDescripcionAuditoriaConformidadPoliticas(rs.getString("DESCRIPCION_AUDITORIA_CONFORMIDAD_POLITICAS"));
         
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
