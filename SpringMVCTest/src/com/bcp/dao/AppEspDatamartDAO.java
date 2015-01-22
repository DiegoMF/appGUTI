package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspDatamart;

public class AppEspDatamartDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspDatamartDAO instancia;

    public static AppEspDatamartDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspDatamartDAO();
        }
        return instancia;
    }
    
	

	/*public ArrayList<AppEspDatamart> obtenerDatamartPorAplicacion(AppEspDatamart info) throws Exception {
	        ArrayList<AppEspDatamart> lista = new ArrayList<AppEspDatamart>();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs= cnn.prepareCall("call sp_obtener_datamart(?)");
	            
	            cs.setInt(1, info.getIdAplicacionEspecializada());
	   
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	AppEspDatamart objeto = new AppEspDatamart();
	            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
	            	objeto.setNombreDatamart(rs.getString("NOMBRE_DATAMART"));
	            	objeto.setFrecuencia(rs.getString("FRECUENCIA"));
	            	objeto.setCantidadTablas(rs.getInt("CANTIDAD_TABLAS_DESCRIPTIVAS"));
	            	objeto.setCantidadTablasDescriptivas(rs.getInt("CANTIDAD_TABLAS_DESCRIPTIVAS"));
	            	objeto.setCantidadTablasHechos(rs.getInt("CANTIDAD_TABLAS_HECHOS"));
	            	objeto.setIdHerramientaExplotacionDatos(rs.getInt("ID_HERRAMIENTA_EXPLOTACION_DATOS"));
	            	objeto.setHerramientaExplotacionDatosOtros(rs.getString("HERRAMIENTA_EXPLOTACION_DATOS_OTROS"));
	            	objeto.setCantidadReportes(rs.getInt("CANTIDAD_REPORTES"));
	            	objeto.setCantidadUsuarios(rs.getInt("CANTIDAD_USUARIOS"));
	            	objeto.setCantidadEspacioTablespace(rs.getString("CANTIDAD_ESPACIO_TABLESPACE"));
	                lista.add(objeto);
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return lista;
	    }*/
    
    
    public AppEspDatamart obtenerDatamartPorAplicacion(AppEspDatamart info) throws Exception {
        AppEspDatamart objeto = new AppEspDatamart();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_datamart_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
   
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setNombreDatamart(rs.getString("NOMBRE_DATAMART"));
            	objeto.setFrecuencia(rs.getString("FRECUENCIA"));
            	objeto.setCantidadTablas(rs.getInt("CANTIDAD_TABLAS"));
            	objeto.setCantidadTablasDescriptivas(rs.getInt("CANTIDAD_TABLAS_DESCRIPTIVAS"));
            	objeto.setCantidadTablasHechos(rs.getInt("CANTIDAD_TABLAS_HECHOS"));
            	objeto.setIdHerramientaExplotacionDatos(rs.getInt("ID_HERRAMIENTA_EXPLOTACION_DATOS"));
            	objeto.setHerramientaExplotacionDatosOtros(rs.getString("HERRAMIENTA_EXPLOTACION_DATOS_OTROS"));
            	objeto.setCantidadReportes(rs.getInt("CANTIDAD_REPORTES"));
            	objeto.setCantidadUsuarios(rs.getInt("CANTIDAD_USUARIOS"));
            	objeto.setCantidadEspacioTablespace(rs.getString("CANTIDAD_ESPACIO_TABLESPACE"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

}
