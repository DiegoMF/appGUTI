package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.MantenimientoAplicacion;

public class MantenimientoAplicacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static MantenimientoAplicacionDAO instancia;

    public static MantenimientoAplicacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new MantenimientoAplicacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<MantenimientoAplicacion> obtenerMantenimientoAplicacion() throws Exception {
        ArrayList<MantenimientoAplicacion> lista = new ArrayList<MantenimientoAplicacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_mantenimiento_aplicacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	MantenimientoAplicacion objeto = new MantenimientoAplicacion();
                objeto.setIdMantenimientoAplicacion(rs.getInt("ID_MANTENIMIENTO_APLICACION"));
                objeto.setDescripcionMantenimientoAplicacion(rs.getString("DESCRIPCION_MANTENIMIENTO_APLICACION"));
         
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
