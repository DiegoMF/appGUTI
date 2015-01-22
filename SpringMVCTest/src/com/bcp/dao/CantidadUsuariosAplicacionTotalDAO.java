package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.CantidadUsuariosAplicacionTotal;

public class CantidadUsuariosAplicacionTotalDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static CantidadUsuariosAplicacionTotalDAO instancia;

    public static CantidadUsuariosAplicacionTotalDAO getInstancia() {
        if (instancia == null) {
            instancia = new CantidadUsuariosAplicacionTotalDAO();
        }
        return instancia;
    }
    
    public ArrayList<CantidadUsuariosAplicacionTotal> obtenerCantidad() throws Exception {
        ArrayList<CantidadUsuariosAplicacionTotal> lista = new ArrayList<CantidadUsuariosAplicacionTotal>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_cantidad_usuario_total()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	CantidadUsuariosAplicacionTotal objeto = new CantidadUsuariosAplicacionTotal();
                objeto.setIdCantidadUsuariosAplicacionTotal(rs.getInt("ID_CANTIDAD_USUARIOS_APLICACION_TOTAL"));
                objeto.setDescripcionCantidadUsuariosAplicacionTotal(rs.getString("DESCRIPCION_CANTIDAD_USUARIOS_APLICACION_TOTAL"));
         
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
