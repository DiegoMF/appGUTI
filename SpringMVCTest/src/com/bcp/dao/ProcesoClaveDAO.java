package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.ProcesoClave;

public class ProcesoClaveDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ProcesoClaveDAO instancia;

    public static ProcesoClaveDAO getInstancia() {
        if (instancia == null) {
            instancia = new ProcesoClaveDAO();
        }
        return instancia;
    }
    
    public ArrayList<ProcesoClave> obtenerProcesoClave() throws Exception {
        ArrayList<ProcesoClave> lista = new ArrayList<ProcesoClave>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_proceso_clave()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ProcesoClave objeto = new ProcesoClave();
                objeto.setIdProcesoClave(rs.getInt("ID_PROCESO_CLAVE"));
                objeto.setDescripcionProcesoClave(rs.getString("DESCRIPCION_PROCESO_CLAVE"));
         
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
