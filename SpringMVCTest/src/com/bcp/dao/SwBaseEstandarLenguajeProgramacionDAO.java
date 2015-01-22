package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SwBaseEstandarLenguajeProgramacion;



public class SwBaseEstandarLenguajeProgramacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SwBaseEstandarLenguajeProgramacionDAO instancia;

    public static SwBaseEstandarLenguajeProgramacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new SwBaseEstandarLenguajeProgramacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<SwBaseEstandarLenguajeProgramacion> obtenerSwBaseEstandarLenguaje() throws Exception {
        ArrayList<SwBaseEstandarLenguajeProgramacion> lista = new ArrayList<SwBaseEstandarLenguajeProgramacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_sw_base_estandar_lenguaje_programacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SwBaseEstandarLenguajeProgramacion objeto = new SwBaseEstandarLenguajeProgramacion();
                objeto.setIdSwBaseEstandarLenguajeProgramacion(rs.getInt("ID_SW_BASE_ESTANDAR_LENGUAJE_PROGRAMACION"));
                objeto.setDescripcionSwBaseEstandarLenguajeProgramacion(rs.getString("DESCRIPCION_SW_BASE_ESTANDAR_LENGUAJE_PROGRAMACION"));
         
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
