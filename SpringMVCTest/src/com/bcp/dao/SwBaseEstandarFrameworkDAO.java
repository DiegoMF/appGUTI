package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SwBaseEstandarFramework;


public class SwBaseEstandarFrameworkDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SwBaseEstandarFrameworkDAO instancia;

    public static SwBaseEstandarFrameworkDAO getInstancia() {
        if (instancia == null) {
            instancia = new SwBaseEstandarFrameworkDAO();
        }
        return instancia;
    }
    
    public ArrayList<SwBaseEstandarFramework> obtenerSwBaseEstandarFramework() throws Exception {
        ArrayList<SwBaseEstandarFramework> lista = new ArrayList<SwBaseEstandarFramework>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_sw_base_estandar_framework()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SwBaseEstandarFramework objeto = new SwBaseEstandarFramework();
                objeto.setIdSwBaseEstandarFramework(rs.getInt("ID_SW_BASE_ESTANDAR_FRAMEWORK"));
                objeto.setDescripcionSwBaseEstandarFramework(rs.getString("DESCRIPCION_SW_BASE_ESTANDAR_FRAMEWORK"));
         
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
