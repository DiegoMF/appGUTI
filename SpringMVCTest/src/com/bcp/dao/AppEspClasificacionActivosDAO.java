package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspClasificacionActivos;

public class AppEspClasificacionActivosDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspClasificacionActivosDAO instancia;

    public static AppEspClasificacionActivosDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspClasificacionActivosDAO();
        }
        return instancia;
    }
    
    public AppEspClasificacionActivos obtenerClasificacionActivosPorAplicacion(AppEspClasificacionActivos info) throws Exception {
    	AppEspClasificacionActivos objeto = new AppEspClasificacionActivos();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_clasificacion_activos_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setConfidencialidadIdConfidencialidad(rs.getInt("confidencialidad_ID_CONFIDENCIALIDAD"));
            	objeto.setIntegridadIdIntegridad(rs.getInt("integridad_ID_INTEGRIDAD"));
            	objeto.setDisponibilidadIdDisponibilidad(rs.getInt("disponibilidad_ID_DISPONIBILIDAD"));
            	objeto.setPrivacidadIdPrivacidad(rs.getInt("privacidad_ID_PRIVACIDAD"));
            	objeto.setClasificacionIdClasificacion(rs.getInt("clasificacion_ID_CLASIFICACION"));
            	objeto.setClasificacionActivosObservacion(rs.getString("CLASIFICACION_ACTIVOS_OBSERVACION"));
            	objeto.setIdCriticidadFinal(rs.getInt("ID_CRITICIDAD_FINAL"));
            	objeto.setIdEstadoRevisionAplicacion(rs.getInt("ID_ESTADO_REVISION_APLICACION"));
            
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
}
