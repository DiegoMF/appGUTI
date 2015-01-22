package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SwBaseEstandarHerramientaProgramacion;



public class SwBaseEstandarHerramientaProgramacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SwBaseEstandarHerramientaProgramacionDAO instancia;

    public static SwBaseEstandarHerramientaProgramacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new SwBaseEstandarHerramientaProgramacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<SwBaseEstandarHerramientaProgramacion> obtenerSwBaseHerramienta() throws Exception {
        ArrayList<SwBaseEstandarHerramientaProgramacion> lista = new ArrayList<SwBaseEstandarHerramientaProgramacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_sw_base_estandar_herramienta_programacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SwBaseEstandarHerramientaProgramacion objeto = new SwBaseEstandarHerramientaProgramacion();
                objeto.setIdSwBaseEstandarHerramientaProgramacion(rs.getInt("ID_SW_BASE_ESTANDAR_HERRAMIENTA_PROGRAMACION"));
                objeto.setDescripcionSwBaseEstandarHerramientaProgramacion(rs.getString("DESCRIPCION_SW_BASE_ESTANDAR_HERRAMIENTA_PROGRAMACION"));
         
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
