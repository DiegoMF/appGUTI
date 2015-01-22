package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspFuncionalidad;



public class AppEspFuncionalidadDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspFuncionalidadDAO instancia;

    public static AppEspFuncionalidadDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspFuncionalidadDAO();
        }
        return instancia;
    }
    
	

	
	
	public AppEspFuncionalidad obtenerFuncionalidadPorAplicacion(AppEspFuncionalidad info) throws Exception {
		AppEspFuncionalidad objeto = new AppEspFuncionalidad();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_funcionalidad_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
                objeto.setFuncionalidad(rs.getString("FUNCIONALIDAD"));
                objeto.setDatosEntrada(rs.getString("DATOS_ENTRADA"));
                objeto.setProceso(rs.getString("PROCESO"));
                objeto.setSalida(rs.getString("SALIDA"));
              
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

}
