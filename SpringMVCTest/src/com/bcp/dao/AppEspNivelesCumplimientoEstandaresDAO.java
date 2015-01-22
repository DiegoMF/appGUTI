package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bcp.modelo.AppEspNivelesCumplimientoEstandares;

public class AppEspNivelesCumplimientoEstandaresDAO {
		private Connection cnn = null;
	    private ResultSet rs = null;
	    private static AppEspNivelesCumplimientoEstandaresDAO instancia;

	    public static AppEspNivelesCumplimientoEstandaresDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new AppEspNivelesCumplimientoEstandaresDAO();
	        }
	        return instancia;
	    }
	    
	    public AppEspNivelesCumplimientoEstandares obtenerNivelCumplimientoEstandares(AppEspNivelesCumplimientoEstandares info) throws Exception {
	    	AppEspNivelesCumplimientoEstandares objeto = new AppEspNivelesCumplimientoEstandares();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs= cnn.prepareCall("call app_esp_niveles_cumplimiento_estandares_CALCULAR_NIVEL(?,?)");
	            
	            cs.setInt(1, info.getIdAplicacionEspecializada());
	            cs.setInt(2, info.getIdVersion());
	            
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	
	            	//objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
	            //	objeto.setIdVersion(rs.getInt("ID_VERSION"));
	            	objeto.setDescripcionEstandarSistemaOperativo(rs.getString("DES_SISTEMA_OPERATIVO"));
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
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return objeto;
	    }
	
}
