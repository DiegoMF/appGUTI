package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.TipoOperacionProceso;

public class TipoOperacionProcesoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static TipoOperacionProcesoDAO instancia;

    public static TipoOperacionProcesoDAO getInstancia() {
        if (instancia == null) {
            instancia = new TipoOperacionProcesoDAO();
        }
        return instancia;
    }
    
    public ArrayList<TipoOperacionProceso> obtenerTipoOperacionProceso() throws Exception {
        ArrayList<TipoOperacionProceso> lista = new ArrayList<TipoOperacionProceso>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_tipo_operacion_proceso()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	TipoOperacionProceso objeto = new TipoOperacionProceso();
                objeto.setIdTipoOperacionProceso(rs.getInt("ID_TIPO_OPERACION_PROCESO"));
                objeto.setDescripcionTipoOperacionProceso(rs.getString("DESCRIPCION_TIPO_OPERACION_PROCESO"));
         
                lista.add(objeto);
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }

}
