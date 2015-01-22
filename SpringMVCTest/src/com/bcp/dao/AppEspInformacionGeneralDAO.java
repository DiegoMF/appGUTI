package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bcp.modelo.AppEspInformacionGeneral;

public class AppEspInformacionGeneralDAO {
	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspInformacionGeneralDAO instancia;

    public static AppEspInformacionGeneralDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspInformacionGeneralDAO();
        }
        return instancia;
    }
    
    public AppEspInformacionGeneral obtenerInformacionGeneralPorAplicacion(AppEspInformacionGeneral info) throws Exception {
    	AppEspInformacionGeneral objeto = new AppEspInformacionGeneral();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_informacion_general_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setNombreAplicacionNOIT(rs.getString("NOMBRE_APLICACION_NOIT"));
            	objeto.setDescripcionAplicacion(rs.getString("DESCRICION_APLICACION"));
                objeto.setFuncionalidadesAplicacion(rs.getString("FUNCIONALIDADES_APLICACION"));
                objeto.setIdEstadoAplicacion(rs.getInt("ID_ESTADO_APLICACION"));
                objeto.setIdTipoOperacionProceso(rs.getInt("ID_TIPO_OPERACION_PROCESO"));
                objeto.setIdFrecuenciaOperaciones(rs.getInt("ID_FRECUENCIA_OPERACIONES"));
                objeto.setIdCantidadOperaciones(rs.getInt("ID_CANTIDAD_OPERACIONES"));
                objeto.setFechaCreacionAplicacion(rs.getString("FECHA_CREACION_APLICACION"));
                objeto.setIdMotivoCreacionAplicacion(rs.getInt("ID_MOTIVO_CREACION_APLICACION"));
                objeto.setMotivoCreacionAplicacionOtros(rs.getString("MOTIVO_CREACION_APLICACION_OTROS"));
                objeto.setNroFuncionalidadesTransacciones(rs.getInt("NRO_FUNCIONALIDADES_TRANSACCIONES"));
                objeto.setNroReportes(rs.getInt("NRO_REPORTES"));
                objeto.setNroConsultas(rs.getInt("NRO_CONSULTAS"));
                objeto.setNroEntidadesExternas(rs.getInt("NRO_ENTIDADES_EXTERNAS"));
                objeto.setNroEntidadesInternas(rs.getInt("NRO_ENTIDADES_INTERNAS"));
                objeto.setObservacionesGenerales(rs.getString("OBSERVACIONES_GENERALES"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
    
    
	
/*
	public ArrayList<AppEspInformacionGeneral> obtenerInformacionGeneralPorAplicacion(AppEspInformacionGeneral info) throws Exception {
	        ArrayList<AppEspInformacionGeneral> lista = new ArrayList<AppEspInformacionGeneral>();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs= cnn.prepareCall("call sp_obtener_informacion_general_por_aplicacion(?)");
	            
	            cs.setInt(1, info.getIdAplicacionEspecializada());
	   
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	AppEspInformacionGeneral objeto = new AppEspInformacionGeneral();
	            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
	            	objeto.setNombreAplicacionNOIT(rs.getString("NOMBRE_APLICACION_NOIT"));
	            	objeto.setDescripcionAplicacion(rs.getString("DESCRICION_APLICACION"));
	                objeto.setFuncionalidadesAplicacion(rs.getString("FUNCIONALIDADES_APLICACION"));
	                objeto.setIdEstadoAplicacion(rs.getInt("ID_ESTADO_APLICACION"));
	                objeto.setIdTipoOperacionProceso(rs.getInt("ID_TIPO_OPERACION_PROCESO"));
	                objeto.setIdFrecuenciaOperaciones(rs.getInt("ID_FRECUENCIA_OPERACIONES"));
	                objeto.setIdCantidadOperaciones(rs.getInt("ID_CANTIDAD_OPERACIONES"));
	                objeto.setFechaCreacionAplicacion(rs.getString("FECHA_CREACION_APLICACION"));
	                objeto.setIdMotivoCreacionAplicacion(rs.getInt("ID_MOTIVO_CREACION_APLICACION"));
	                objeto.setMotivoCreacionAplicacionOtros(rs.getString("MOTIVO_CREACION_APLICACION_OTROS"));
	                objeto.setNroFuncionalidadesTransacciones(rs.getInt("NRO_FUNCIONALIDADES_TRANSACCIONES"));
	                objeto.setNroReportes(rs.getInt("NRO_REPORTES"));
	                objeto.setNroConsultas(rs.getInt("NRO_CONSULTAS"));
	                objeto.setNroEntidadesExternas(rs.getInt("NRO_ENTIDADES_EXTERNAS"));
	                objeto.setNroEntidadesInternas(rs.getInt("NRO_ENTIDADES_INTERNAS"));
	                objeto.setObservacionesGenerales(rs.getString("OBSERVACIONES_GENERALES"));
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
