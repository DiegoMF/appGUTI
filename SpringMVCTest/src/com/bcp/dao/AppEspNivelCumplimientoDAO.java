package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspNivelCumplimiento;
import com.bcp.modelo.dto.AplicacionEspecializadaDTO;

public class AppEspNivelCumplimientoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspNivelCumplimientoDAO instancia;

    public static AppEspNivelCumplimientoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspNivelCumplimientoDAO();
        }
        return instancia;
    }
    
    public AppEspNivelCumplimiento obtenerNivelCumplimiento(AppEspNivelCumplimiento info) throws Exception {
    	AppEspNivelCumplimiento objeto = new AppEspNivelCumplimiento();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call app_esp_niveles_cumplimiento_CALCULAR(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
    		System.out.println("El ID de la aplicación: " + info.getIdAplicacionEspecializada());
    		System.out.println("La versión de la aplicación: " + info.getIdVersion());


            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	//objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            //	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setDescripcionEstandarSistemaOperativo(rs.getString("DES_SISTEMA_OPERATIVO"));
        		System.out.println("descripción estandar sistema operativo: " + objeto.getDescripcionEstandarSistemaOperativo());

            	objeto.setNivelCumplimientoSistemaOperativo(rs.getDouble("PORCENTAJE_SISTEMA_OPERATIVO"));
            	objeto.setPuntuacionSistemaOperativo(rs.getInt("PUNTUACION_SISTEMA_OPERATIVO"));
            	objeto.setCalculoSistemaOperativo(rs.getDouble("CALCULO_SISTEMA_OPERATIVO"));
            	objeto.setDescripcionEstandarHerramientaProgramacion(rs.getString("DES_HERRAMIENTA_PROGRAMACION"));
            	objeto.setNivelCumplimientoHerramientaProgramacion(rs.getDouble("PORCENTAJE_HERRAMIENTA_PROGRAMACION"));
            	objeto.setPuntuacionHerramientaProgramacion(rs.getInt("PUNTUACION_HERRAMIENTA_PROGRAMACION"));
            	objeto.setCalculoHerramientaProgramacion(rs.getDouble("CALCULO_HERRAMIENTA_PROGRAMACION"));
            	objeto.setDescripcionEstandarGestorBD(rs.getString("DES_GESTOR_BD"));
            	objeto.setNivelCumplimientoEstandarGestorBD(rs.getDouble("PORCENTAJE_GESTOR_BD"));
            	objeto.setPuntuacionGestorBD(rs.getInt("PUNTUACION_GESTOR_BD"));
            	objeto.setCalculoGestorBD(rs.getDouble("CALCULO_GESTOR_BD"));
            	objeto.setDescripcionFramework(rs.getString("DES_FRAMEWORK"));
            	objeto.setNivelCumplimientoFramework(rs.getDouble("PORCENTAJE_FRAMEWORK"));
            	objeto.setPuntuacionFramework(rs.getInt("PUNTUACION_FRAMEWORK"));
            	objeto.setCalculoFramework(rs.getDouble("CALCULO_FRAMEWORK"));
            	objeto.setTotal(rs.getDouble("TOTAL"));
            	
            	objeto.setNivelCumplimientoAccesos(rs.getDouble("PNC_ACCESOS"));
            	objeto.setNivelCumplimientoAuditoria(rs.getDouble("PNC_AUDITORIA"));
            	objeto.setNivelCumplimientoContingencia(rs.getDouble("PNC_CONTINGENCIA"));
            	objeto.setNivelCumplimientoControlCambios(rs.getDouble("PNC_CONTROL_CAMBIOS"));
            	objeto.setNivelCumplimientoDocumentacion(rs.getDouble("PNC_DOCUMENTACION"));
            	objeto.setNivelCumplimientoIncidentes(rs.getDouble("PNC_INCIDENTES"));
            	objeto.setNivelCumplimientoIntegridadConfidencialidad(rs.getDouble("PNC_INTEGRIDAD_CONFIDENCIALIDAD"));
            	objeto.setNivelCumplimientoRespaldos(rs.getDouble("PNC_RESPALDOS"));
            	objeto.setNivelCumplimientoTotal(rs.getDouble("PNC_TOTAL"));
            	
            	objeto.setNivelCumplimientoFinal(rs.getDouble("NIVEL_CUMPLIMIENTO_FINAL"));
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
    
    public AppEspNivelCumplimiento obtenerNivelCumplimientoPost(AppEspNivelCumplimiento info) throws Exception {
    	AppEspNivelCumplimiento objeto = new AppEspNivelCumplimiento();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call app_esp_post_atencion_niveles_cumplimiento_CALCULAR(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
    		System.out.println("El ID de la aplicación: " + info.getIdAplicacionEspecializada());
    		System.out.println("La versión de la aplicación: " + info.getIdVersion());


            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	//objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            //	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setDescripcionEstandarSistemaOperativo(rs.getString("DES_SISTEMA_OPERATIVO"));
        		System.out.println("descripción estandar sistema operativo: " + objeto.getDescripcionEstandarSistemaOperativo());

            	objeto.setNivelCumplimientoSistemaOperativo(rs.getDouble("PORCENTAJE_SISTEMA_OPERATIVO"));
            	objeto.setPuntuacionSistemaOperativo(rs.getInt("PUNTUACION_SISTEMA_OPERATIVO"));
            	objeto.setCalculoSistemaOperativo(rs.getDouble("CALCULO_SISTEMA_OPERATIVO"));
            	objeto.setDescripcionEstandarHerramientaProgramacion(rs.getString("DES_HERRAMIENTA_PROGRAMACION"));
            	objeto.setNivelCumplimientoHerramientaProgramacion(rs.getDouble("PORCENTAJE_HERRAMIENTA_PROGRAMACION"));
            	objeto.setPuntuacionHerramientaProgramacion(rs.getInt("PUNTUACION_HERRAMIENTA_PROGRAMACION"));
            	objeto.setCalculoHerramientaProgramacion(rs.getDouble("CALCULO_HERRAMIENTA_PROGRAMACION"));
            	objeto.setDescripcionEstandarGestorBD(rs.getString("DES_GESTOR_BD"));
            	objeto.setNivelCumplimientoEstandarGestorBD(rs.getDouble("PORCENTAJE_GESTOR_BD"));
            	objeto.setPuntuacionGestorBD(rs.getInt("PUNTUACION_GESTOR_BD"));
            	objeto.setCalculoGestorBD(rs.getDouble("CALCULO_GESTOR_BD"));
            	objeto.setDescripcionFramework(rs.getString("DES_FRAMEWORK"));
            	objeto.setNivelCumplimientoFramework(rs.getDouble("PORCENTAJE_FRAMEWORK"));
            	objeto.setPuntuacionFramework(rs.getInt("PUNTUACION_FRAMEWORK"));
            	objeto.setCalculoFramework(rs.getDouble("CALCULO_FRAMEWORK"));
            	objeto.setTotal(rs.getDouble("TOTAL"));
            	
            	objeto.setNivelCumplimientoAccesos(rs.getDouble("PNC_ACCESOS"));
            	objeto.setNivelCumplimientoAuditoria(rs.getDouble("PNC_AUDITORIA"));
            	objeto.setNivelCumplimientoContingencia(rs.getDouble("PNC_CONTINGENCIA"));
            	objeto.setNivelCumplimientoControlCambios(rs.getDouble("PNC_CONTROL_CAMBIOS"));
            	objeto.setNivelCumplimientoDocumentacion(rs.getDouble("PNC_DOCUMENTACION"));
            	objeto.setNivelCumplimientoIncidentes(rs.getDouble("PNC_INCIDENTES"));
            	objeto.setNivelCumplimientoIntegridadConfidencialidad(rs.getDouble("PNC_INTEGRIDAD_CONFIDENCIALIDAD"));
            	objeto.setNivelCumplimientoRespaldos(rs.getDouble("PNC_RESPALDOS"));
            	objeto.setNivelCumplimientoTotal(rs.getDouble("PNC_TOTAL"));
            	
            	objeto.setNivelCumplimientoFinal(rs.getDouble("NIVEL_CUMPLIMIENTO_FINAL"));
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
    
	public int ingresarNivelCumplimiento(AplicacionEspecializadaDTO info) throws Exception {
        int id = 0;
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call app_esp_niveles_cumplimiento_INSERTAR(?,?)");

            cs.setInt(1,info.getIdAplicacionEspecializada());  
            cs.setInt(2,info.getIdVersion());    
		
			
            cs.execute();
          
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return id;
    }
	
	
	public int ingresarNivelCumplimientoPost(AplicacionEspecializadaDTO info) throws Exception {
        int id = 0;
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call app_esp_post_atencion_niveles_cumplimiento_INSERTAR(?,?)");

            cs.setInt(1,info.getIdAplicacionEspecializada());  
            cs.setInt(2,info.getIdVersion());    
		
			
            cs.execute();
          
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return id;
    }
    
}
