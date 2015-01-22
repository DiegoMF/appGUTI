package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.CampoInventario;


public class CampoInventarioDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static CampoInventarioDAO instancia;

    public static CampoInventarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new CampoInventarioDAO();
        }
        return instancia;
    }
    
    public ArrayList<CampoInventario> obtenerCampoInventario() throws Exception {
        ArrayList<CampoInventario> lista = new ArrayList<CampoInventario>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_campo_inventario()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	CampoInventario objeto = new CampoInventario();
                objeto.setIdCampoInventario(rs.getInt("ID_CAMPO_INVENTARIO"));
                objeto.setDescripcionCampoInventario(rs.getString("DESCRIPCION_CAMPO_INVENTARIO"));
         
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
