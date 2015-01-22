package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.SwBaseEstandarSistemaOperativo;



public class SwBaseEstandarSistemaOperativoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static SwBaseEstandarSistemaOperativoDAO instancia;

    public static SwBaseEstandarSistemaOperativoDAO getInstancia() {
        if (instancia == null) {
            instancia = new SwBaseEstandarSistemaOperativoDAO();
        }
        return instancia;
    }
    
    public ArrayList<SwBaseEstandarSistemaOperativo> obtenerSwBaseEstandar() throws Exception {
        ArrayList<SwBaseEstandarSistemaOperativo> lista = new ArrayList<SwBaseEstandarSistemaOperativo>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_sw_base_sistema_operativo()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	SwBaseEstandarSistemaOperativo objeto = new SwBaseEstandarSistemaOperativo();
                objeto.setIdSwBaseEstandarSistemaOperativo(rs.getInt("ID_SW_BASE_ESTANDAR_SISTEMA_OPERATIVO"));
                objeto.setDescripcionSwBaseEstandarSistemaOperativo(rs.getString("DESCRIPCION_SW_BASE_ESTANDAR_SISTEMA_OPERATIVO"));
         
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
