package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.UbicacionFisica;

public class UbicacionFisicaDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static UbicacionFisicaDAO instancia;

    public static UbicacionFisicaDAO getInstancia() {
        if (instancia == null) {
            instancia = new UbicacionFisicaDAO();
        }
        return instancia;
    }
    
    public ArrayList<UbicacionFisica> obtenerUbicacionFisica() throws Exception {
        ArrayList<UbicacionFisica> lista = new ArrayList<UbicacionFisica>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_ubicacion_fisica()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	UbicacionFisica objeto = new UbicacionFisica();
                objeto.setIdUbicacionFisica(rs.getInt("ID_UBICACION_FISICA"));
                objeto.setDescripcionUbicacionFisica(rs.getString("DESCRIPCION_UBICACION_FISICA"));
         
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
