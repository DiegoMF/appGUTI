package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AuditoriaRegistroEventosAdministradores;

public class AuditoriaRegistroEventosAdministradoresDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AuditoriaRegistroEventosAdministradoresDAO instancia;

    public static AuditoriaRegistroEventosAdministradoresDAO getInstancia() {
        if (instancia == null) {
            instancia = new AuditoriaRegistroEventosAdministradoresDAO();
        }
        return instancia;
    }
    
    public ArrayList<AuditoriaRegistroEventosAdministradores> obtenerRegistroEventos() throws Exception {
        ArrayList<AuditoriaRegistroEventosAdministradores> lista = new ArrayList<AuditoriaRegistroEventosAdministradores>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_registro_eventos_administradores()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AuditoriaRegistroEventosAdministradores objeto = new AuditoriaRegistroEventosAdministradores();
                objeto.setIdAuditoriaRegistroEventosAdministradores(rs.getInt("ID_AUDITORIA_REGISTRO_EVENTOS_ADMINISTRADORES"));
                objeto.setDescripcionAuditoriaRegistroEventosAdministradores(rs.getString("DESCRIPCION_AUDITORIA_REGISTRO_EVENTOS_ADMINISTRADORES"));
         
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
