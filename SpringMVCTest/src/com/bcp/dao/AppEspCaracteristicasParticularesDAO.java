package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspCaracteristicasParticulares;

public class AppEspCaracteristicasParticularesDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspCaracteristicasParticularesDAO instancia;

    public static AppEspCaracteristicasParticularesDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspCaracteristicasParticularesDAO();
        }
        return instancia;
    }
    
    public AppEspCaracteristicasParticulares obtenerCaracteristicasParticularesPorAplicacion(AppEspCaracteristicasParticulares info) throws Exception {
    	AppEspCaracteristicasParticulares objeto = new AppEspCaracteristicasParticulares();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_caracteristicas_particulares_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setIdEscenarioLogueo(rs.getInt("ID_ESCENARIO_LOGUEO"));
            	objeto.setIdImpactoProteccionDatos(rs.getInt("ID_IMPACTO_PROTECCION_DATOS_LEVANTAMIENTO_INFORMACION"));
            	objeto.setIdImpactoProteccionDatosLevantamientoInformacion(rs.getInt("ID_IMPACTO_PROTECCION_DATOS_LEVANTAMIENTO_INFORMACION"));
            	objeto.setSysImSt(rs.getString("SYS_IM_ST"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
}
