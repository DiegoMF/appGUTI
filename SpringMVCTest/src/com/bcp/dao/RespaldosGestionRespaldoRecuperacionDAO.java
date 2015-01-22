package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.RespaldosGestionRespaldoRecuperacion;


public class RespaldosGestionRespaldoRecuperacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static RespaldosGestionRespaldoRecuperacionDAO instancia;

    public static RespaldosGestionRespaldoRecuperacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new RespaldosGestionRespaldoRecuperacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<RespaldosGestionRespaldoRecuperacion> obtenerRespaldosGestionRespaldoRecuperacion() throws Exception {
        ArrayList<RespaldosGestionRespaldoRecuperacion> lista = new ArrayList<RespaldosGestionRespaldoRecuperacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_respaldos_gestion_respaldo_recuperacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	RespaldosGestionRespaldoRecuperacion objeto = new RespaldosGestionRespaldoRecuperacion();
                objeto.setIdRespaldosGestionRespaldoRecuperacion(rs.getInt("ID_RESPALDOS_GESTION_RESPALDO_RECUPERACION"));
                objeto.setDescripcionRespaldosGestionRespaldoRecuperacion(rs.getString("DESCRIPCION_RESPALDOS_GESTION_RESPALDO_RECUPERACION"));
         
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
