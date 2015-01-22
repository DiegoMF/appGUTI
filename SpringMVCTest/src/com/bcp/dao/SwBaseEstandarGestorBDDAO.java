package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SwBaseEstandarGestorBD;



public class SwBaseEstandarGestorBDDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SwBaseEstandarGestorBDDAO instancia;

    public static SwBaseEstandarGestorBDDAO getInstancia() {
        if (instancia == null) {
            instancia = new SwBaseEstandarGestorBDDAO();
        }
        return instancia;
    }
    
    public ArrayList<SwBaseEstandarGestorBD> obtenerSwBaseEstandarGestorBD() throws Exception {
        ArrayList<SwBaseEstandarGestorBD> lista = new ArrayList<SwBaseEstandarGestorBD>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_sw_base_estandar_gestor_bd()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SwBaseEstandarGestorBD objeto = new SwBaseEstandarGestorBD();
                objeto.setIdSwBaseEstandarGestorBD(rs.getInt("ID_SW_BASE_ESTANDAR_GESTOR_BD"));
                objeto.setDescripcionSwBaseEstandarGestorBD(rs.getString("DESCRIPCION_SW_BASE_ESTANDAR_GESTOR_BD"));
         
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
