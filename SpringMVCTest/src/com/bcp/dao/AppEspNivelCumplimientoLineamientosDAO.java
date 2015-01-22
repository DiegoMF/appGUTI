
package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspNivelCumplimientoLineamientos;


public class AppEspNivelCumplimientoLineamientosDAO {
			private Connection cnn = null;
		    private ResultSet rs = null;
		    private static AppEspNivelCumplimientoLineamientosDAO instancia;

		    public static AppEspNivelCumplimientoLineamientosDAO getInstancia() {
		        if (instancia == null) {
		            instancia = new AppEspNivelCumplimientoLineamientosDAO();
		        }
		        return instancia;
		    }
		    
public AppEspNivelCumplimientoLineamientos obtenerNivelCumplimientoLineamientos(AppEspNivelCumplimientoLineamientos info) throws Exception {
		    	AppEspNivelCumplimientoLineamientos objeto = new AppEspNivelCumplimientoLineamientos();
		        try {
		            cnn = Conexion.getConexion();
		            CallableStatement cs = null;
		            cs= cnn.prepareCall("call app_esp_niveles_cumplimiento_lineamientos_CALCULAR_NIVEL(?,?)");
		            
		            cs.setInt(1, info.getIdAplicacionEspecializada());
		            cs.setInt(2, info.getIdVersion());
		            
		            
		            rs = cs.executeQuery();
		            while (rs.next()) {
		            	
		            	//objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
		            //	objeto.setIdVersion(rs.getInt("ID_VERSION"));
		            
		            	objeto.setNivelCumplimientoAccesos(rs.getDouble("PNC_ACCESOS"));
		            	objeto.setNivelCumplimientoAuditoria(rs.getDouble("PNC_AUDITORIA"));
		            	objeto.setNivelCumplimientoContingencia(rs.getDouble("PNC_CONTINGENCIA"));
		            	objeto.setNivelCumplimientoControlCambios(rs.getDouble("PNC_CONTROL_CAMBIOS"));
		            	objeto.setNivelCumplimientoDocumentacion(rs.getDouble("PNC_DOCUMENTACION"));
		            	objeto.setNivelCumplimientoIncidentes(rs.getDouble("PNC_INCIDENTES"));
		            	objeto.setNivelCumplimientoIntegridadConfidencialidad(rs.getDouble("PNC_INTEGRIDAD_CONFIDENCIALIDAD"));
		            	objeto.setNivelCumplimientoRespaldos(rs.getDouble("PNC_RESPALDOS"));
		            	objeto.setNivelCumplimientoTotal(rs.getDouble("PNC_TOTAL"));
		            }
		            cnn.close();
		            cs.close();
		        } catch (SQLException ex) {
		            throw ex;
		        }
		        return objeto;
		    }
		
	}
