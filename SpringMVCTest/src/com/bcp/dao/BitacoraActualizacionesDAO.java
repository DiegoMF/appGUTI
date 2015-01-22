package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.BitacoraActualizaciones;


public class BitacoraActualizacionesDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static BitacoraActualizacionesDAO instancia;

    public static BitacoraActualizacionesDAO getInstancia() {
        if (instancia == null) {
            instancia = new BitacoraActualizacionesDAO();
        }
        return instancia;
    }
    
    public BitacoraActualizaciones obtenerBitacoraActualizacionesPorAplicacion(BitacoraActualizaciones info) throws Exception {
    	BitacoraActualizaciones objeto = new BitacoraActualizaciones();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_bitacora_actualizaciones_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setFechaActualizacion(rs.getString("FECHA_ACTUALIZACION"));
            	objeto.setIdGrupoInventario(rs.getInt("ID_GRUPO_INVENTARIO"));
            	objeto.setIdCampoInventario(rs.getInt("ID_CAMPO_INVENTARIO"));
            	objeto.setDetalleActualizacion(rs.getString("DETALLE_ACTUALIZACION"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
}
