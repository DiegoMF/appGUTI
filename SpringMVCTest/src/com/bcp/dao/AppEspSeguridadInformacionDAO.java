package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspSeguridadInformacion;



public class AppEspSeguridadInformacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspSeguridadInformacionDAO instancia;

    public static AppEspSeguridadInformacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspSeguridadInformacionDAO();
        }
        return instancia;
    }
    
    public AppEspSeguridadInformacion obtenerSeguridadInformacionPorAplicacion(AppEspSeguridadInformacion info) throws Exception {
    	AppEspSeguridadInformacion objeto = new AppEspSeguridadInformacion();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_seguridad_informacion_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setEvaluacionSeguridadInformatica(rs.getString("EVALUACION_SEGURIDAD_INFORMATICA"));
            	objeto.setSeguridadNivelExposicion(rs.getString("SEGURIDAD_NIVEL_EXPOSICION"));
        
         
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
}
