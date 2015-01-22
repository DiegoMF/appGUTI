package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bcp.modelo.AppEspFuenteOrigen;

public class AppEspFuenteOrigenDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspFuenteOrigenDAO instancia;

    public static AppEspFuenteOrigenDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspFuenteOrigenDAO();
        }
        return instancia;
    }
    
    public AppEspFuenteOrigen obtenerFuenteOrigenPorAplicacion(AppEspFuenteOrigen info) throws Exception {
    	AppEspFuenteOrigen objeto = new AppEspFuenteOrigen();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_fuente_origen_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setIdFuentePeriodo(rs.getInt("ID_FUENTE_PERIODO"));
            	objeto.setDescripcionFuente(rs.getString("DESCRIPCION_FUENTE"));
         
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
}
