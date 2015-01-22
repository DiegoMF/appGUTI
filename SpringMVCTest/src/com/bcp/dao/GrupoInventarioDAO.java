package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.GrupoInventario;


public class GrupoInventarioDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static GrupoInventarioDAO instancia;

    public static GrupoInventarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new GrupoInventarioDAO();
        }
        return instancia;
    }
    
    public ArrayList<GrupoInventario> obtenerGrupoInventario() throws Exception {
        ArrayList<GrupoInventario> lista = new ArrayList<GrupoInventario>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_grupo_inventario()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	GrupoInventario objeto = new GrupoInventario();
                objeto.setIdGrupoInventario(rs.getInt("ID_GRUPO_INVENTARIO"));
                objeto.setDescripcionGrupoInventario(rs.getString("DESCRIPCION_GRUPO_INVENTARIO"));
         
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
