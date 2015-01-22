package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspInformacionPlanRoadmap;

public class AppEspInformacionPlanRoadmapDAO {
	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspInformacionPlanRoadmapDAO instancia;

    public static AppEspInformacionPlanRoadmapDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspInformacionPlanRoadmapDAO();
        }
        return instancia;
    }
    
    public AppEspInformacionPlanRoadmap obtenerInformacionPlanRoadmapPorAplicacion(AppEspInformacionPlanRoadmap info) throws Exception {
    	AppEspInformacionPlanRoadmap objeto = new AppEspInformacionPlanRoadmap();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_informacion_plan_roadmap_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
                objeto.setRoadmapCortoPlazo(rs.getString("ROADMAP_COTRO_PLAZO"));
                objeto.setRoadmapLargoPlazo(rs.getString("ROADMAP_LARGO_PLAZO"));
                objeto.setIdEstadoAtencionRoadmap(rs.getInt("ID_ESTADO_ATENCION_ROADMAP"));
                objeto.setIdEtapaAtencionRoadmap(rs.getInt("ID_ETAPA_ATENCION_ROADMAP"));
                objeto.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
                objeto.setFechaInicioPlanificado(rs.getString("FECHA_INICIO_PLANIFICADO"));
                objeto.setRoadmapEjecutadoActual(rs.getString("ROADMAP_EJECUTADO_ACTUAL"));
                objeto.setTrackAtencion(rs.getString("TRACK_ATENCION"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

    /*
	public ArrayList<AppEspInformacionPlanRoadmap> obtenerInformacionPlanRoadmapPorAplicacion(AppEspInformacionPlanRoadmap estructura) throws Exception {
	        ArrayList<AppEspInformacionPlanRoadmap> lista = new ArrayList<AppEspInformacionPlanRoadmap>();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs= cnn.prepareCall("call sp_obtener_informacion_plan_roadmap(?)");
	            
	            cs.setInt(1, estructura.getIdAplicacionEspecializada());
	   
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	AppEspInformacionPlanRoadmap objeto = new AppEspInformacionPlanRoadmap();
	                objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
	                objeto.setRoadmapCortoPlazo(rs.getString("ROADMAP_COTRO_PLAZO"));
	                objeto.setRoadmapLargoPlazo(rs.getString("ROADMAP_LARGO_PLAZO"));
	                objeto.setIdEstadoAtencionRoadmap(rs.getInt("ID_ESTADO_ATENCION_ROADMAP"));
	                objeto.setIdEtapaAtencionRoadmap(rs.getInt("ID_ETAPA_ATENCION_ROADMAP"));
	                objeto.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
	                objeto.setFechaInicioPlanificado(rs.getString("FECHA_INICIO_PLANIFICADO"));
	                objeto.setRoadmapEjecutadoActual(rs.getString("ROADMAP_EJECUTADO_ACTUAL"));
	                objeto.setTrackAtencion(rs.getString("TRACK_ATENCION"));
	                lista.add(objeto);
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return lista;
	    }
*/
}
