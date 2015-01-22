package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.HerramientaExplotacionDatos;

public class HerramientaExplotacionDatosDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static HerramientaExplotacionDatosDAO instancia;

    public static HerramientaExplotacionDatosDAO getInstancia() {
        if (instancia == null) {
            instancia = new HerramientaExplotacionDatosDAO();
        }
        return instancia;
    }
    
    public ArrayList<HerramientaExplotacionDatos> obtenerHerramientaExplotacionDatos() throws Exception {
        ArrayList<HerramientaExplotacionDatos> lista = new ArrayList<HerramientaExplotacionDatos>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_herramienta_explotacion_datos()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	HerramientaExplotacionDatos objeto = new HerramientaExplotacionDatos();
                objeto.setIdHerramientaExplotacionDatos(rs.getInt("ID_HERRAMIENTA_EXPLOTACION_DATOS"));
                objeto.setDescripcionHerramientaExplotacionDatos(rs.getString("DESCRIPCION_HERRAMIENTA_EXPLOTACION_DATOS"));
         
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
