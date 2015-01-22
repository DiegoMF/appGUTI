package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.CategoriaTecnologica;


public class CategoriaTecnologicaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static CategoriaTecnologicaDAO instancia;

    public static CategoriaTecnologicaDAO getInstancia() {
        if (instancia == null) {
            instancia = new CategoriaTecnologicaDAO();
        }
        return instancia;
    }
    
    public ArrayList<CategoriaTecnologica> obtenerCategoriaTecnologica() throws Exception {
        ArrayList<CategoriaTecnologica> lista = new ArrayList<CategoriaTecnologica>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_categoria_tecnologica()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	CategoriaTecnologica objeto = new CategoriaTecnologica();
                objeto.setIdCategoriaTecnologica(rs.getInt("ID_CATEGORIA_TECNOLOGICA"));
                objeto.setDescripcionCategoriaTecnologica(rs.getString("DESCRIPCION_CATEGORIA_TECNOLOGICA"));
         
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
