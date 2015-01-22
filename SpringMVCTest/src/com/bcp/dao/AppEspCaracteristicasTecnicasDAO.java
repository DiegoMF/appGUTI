package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspCaracteristicasTecnicas;


public class AppEspCaracteristicasTecnicasDAO {
	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspCaracteristicasTecnicasDAO instancia;

    public static AppEspCaracteristicasTecnicasDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspCaracteristicasTecnicasDAO();
        }
        return instancia;
    }
    
    public AppEspCaracteristicasTecnicas obtenerCaracteristicasTecnicasPorAplicacion(AppEspCaracteristicasTecnicas info) throws Exception {
    	AppEspCaracteristicasTecnicas objeto = new AppEspCaracteristicasTecnicas();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_caracteristicas_tecnicas_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
                objeto.setIdCategoriaTecnologica(rs.getInt("ID_CATEGORIA_TECNOLOGICA"));
                objeto.setCategoriaTecnologicaOtros(rs.getString("CATEGORIA_TECNOLOGICA_OTROS"));
                objeto.setIdTiposDesarrollo(rs.getInt("ID_TIPO_DESARROLLO"));
                objeto.setIdUbicacionFisica(rs.getInt("ID_UBICACION_FISICA"));
                objeto.setIdAmbienteAppNOIT(rs.getInt("ID_AMBIENTE_APPNOIT"));
                objeto.setAmbienteAppNOITOtros(rs.getString("AMBIENTE_APPNOIT_OTROS"));
                objeto.setNombreUbicacion(rs.getString("NOMBRE_UBICACION"));
                objeto.setIdInfraestructuraAplicacion(rs.getInt("ID_INFRAESTRUCTURA_APLICACION"));
                objeto.setEsSolucionStandAlone(rs.getInt("ES_SOLUCION_STAND_ALONE"));
                objeto.setNroInterfacesConOtrasApp(rs.getInt("NRO_INTERFACES_CON_OTRAS_APP"));
                objeto.setNombresInterfaces(rs.getString("NOMBRES_INTERFACES"));
                objeto.setIdMantenimientoAplicacion(rs.getInt("ID_MANTENIMIENTO_APLICACION"));
                objeto.setMantenimientoNombreProveedor(rs.getString("MANTENIMIENTO_NOMBRE_PROVEEDOR"));
                objeto.setIdSoporteAplicacion(rs.getInt("ID_SOPORTE_APLICACION"));
                objeto.setSoporteNombrePorveedor(rs.getString("SOPORTE_NOMBRE_PROVEEDOR"));
                objeto.setIdAcessosAplicacion(rs.getInt("ID_ACCESOS_APLICACION"));
                objeto.setAccesosNombreProveedor(rs.getString("ACCESOS_NOMBRE_PROVEEDOR"));
                objeto.setNombreServidor(rs.getString("NOMBRE_SERVIDOR"));
                objeto.setUbicacionServidor(rs.getString("UBICACION_SERVIDOR"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
    
/*
	public ArrayList<AppEspCaracteristicasTecnicas> obtenerCaracteristicasTecnicasPorAplicacion(AppEspCaracteristicasTecnicas estructura) throws Exception {
	        ArrayList<AppEspCaracteristicasTecnicas> lista = new ArrayList<AppEspCaracteristicasTecnicas>();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs= cnn.prepareCall("call sp_obtener_caracteristicas_tecnicas_por_aplicacion(?)");
	            
	            cs.setInt(1, estructura.getIdAplicacionEspecializada());
	   
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	AppEspCaracteristicasTecnicas objeto = new AppEspCaracteristicasTecnicas();
	                objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
	                objeto.setIdCategoriaTecnologica(rs.getInt("ID_CATEGORIA_TECNOLOGICA"));
	                objeto.setCategoriaTecnologicaOtros(rs.getString("CATEGORIA_TECNOLOGICA_OTROS"));
	                objeto.setIdTiposDesarrollo(rs.getInt("ID_TIPO_DESARROLLO"));
	                objeto.setIdUbicacionFisica(rs.getInt("ID_UBICACION_FISICA"));
	                objeto.setIdAmbienteAppNOIT(rs.getInt("ID_AMBIENTE_APPNOIT"));
	                objeto.setAmbienteAppNOITOtros(rs.getString("AMBIENTE_APPNOIT_OTROS"));
	                objeto.setNombreUbicacion(rs.getString("NOMBRE_UBICACION"));
	                objeto.setIdInfraestructuraAplicacion(rs.getInt("ID_INFRAESTRUCTURA_APLICACION"));
	                objeto.setEsSolucionStandAlone(rs.getInt("ES_SOLUCION_STAND_ALONE"));
	                objeto.setNroInterfacesConOtrasApp(rs.getInt("NRO_INTERFACES_CON_OTRAS_APP"));
	                objeto.setNombresInterfaces(rs.getString("NOMBRES_INTERFACES"));
	                objeto.setIdMantenimientoAplicacion(rs.getInt("ID_MANTENIMIENTO_APLICACION"));
	                objeto.setMantenimientoNombreProveedor(rs.getString("MANTENIMIENTO_NOMBRE_PROVEEDOR"));
	                objeto.setIdSoporteAplicacion(rs.getInt("ID_SOPORTE_APLICACION"));
	                objeto.setSoporteNombrePorveedor(rs.getString("SOPORTE_NOMBRE_PROVEEDOR"));
	                objeto.setIdAcessosAplicacion(rs.getInt("ID_ACCESOS_APLICACION"));
	                objeto.setAccesosNombreProveedor(rs.getString("ACCESOS_NOMBRE_PROVEEDOR"));
	                objeto.setNombreServidor(rs.getString("NOMBRE_SERVIDOR"));
	                objeto.setUbicacionServidor(rs.getString("UBICACION_SERVIDOR"));
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
