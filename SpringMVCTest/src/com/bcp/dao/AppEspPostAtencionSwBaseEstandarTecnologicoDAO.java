package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspPostAtencionSwBaseEstandarTecnologico;

public class AppEspPostAtencionSwBaseEstandarTecnologicoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspPostAtencionSwBaseEstandarTecnologicoDAO instancia;

    public static AppEspPostAtencionSwBaseEstandarTecnologicoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspPostAtencionSwBaseEstandarTecnologicoDAO();
        }
        return instancia;
    }
    
    public AppEspPostAtencionSwBaseEstandarTecnologico obtenerCaracteristicasParticularesPorAplicacion(AppEspPostAtencionSwBaseEstandarTecnologico info) throws Exception {
    	AppEspPostAtencionSwBaseEstandarTecnologico objeto = new AppEspPostAtencionSwBaseEstandarTecnologico();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_post_atencion_sw_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setIdSwBaseEstandarSistemaOperativo(rs.getInt("ID_SW_BASE_ESTANDAR_SISTEMA_OPERATIVO"));
            	objeto.setSwBaseSistemaOperativoOtros(rs.getString("SW_BASE_SISTEMA_OPERATIVO_OTROS"));
            	objeto.setIdSwBaseEstandarHeramientaProgramacion(rs.getInt("ID_SW_BASE_ESTANDAR_HERRAMIENTA_PROGRAMACION"));
                objeto.setSwBaseHerramientaProgramacionOtros(rs.getString("SW_BASE_HERRAMIENTA_PROGRAMACION_OTROS"));
                objeto.setIdSwBaseEstandarLenguajeProgramacion(rs.getInt("ID_SW_BASE_ESTANDAR_LENGUAJE_PROGRAMACION"));
                objeto.setSwBaseLenguajeProgramacionOtros(rs.getString("SW_BASE_LENGUAJE_PROGRAMACION_OTROS"));
                objeto.setIdSwBaseEstandarGestorBD(rs.getInt("ID_SW_BASE_ESTANDAR_GESTOR_BD"));
                objeto.setSwBaseGestorBDOtros(rs.getString("SW_BASE_GESTOR_BD_OTROS"));
                objeto.setIdSwBaseEstandarFramework(rs.getInt("ID_SW_BASE_ESTANDAR_FRAMEWORK"));
                objeto.setSwBaseFrameworkOtros(rs.getString("SW_BASE_FRAMEWORK_OTROS"));
                objeto.setSwBaseObservacionesAdicionales(rs.getString("SW_BASE_OBSERVACIONES_ADICIONALES"));
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

}
