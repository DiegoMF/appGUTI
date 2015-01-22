package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.EstadoAtencionRoadmap;


public class EstadoAtencionRoadmapDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static EstadoAtencionRoadmapDAO instancia;

    public static EstadoAtencionRoadmapDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstadoAtencionRoadmapDAO();
        }
        return instancia;
    }
    
    public ArrayList<EstadoAtencionRoadmap> obtenerEstadoAtencionRoadmap() throws Exception {
        ArrayList<EstadoAtencionRoadmap> lista = new ArrayList<EstadoAtencionRoadmap>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_estado_atencion_roadmap()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	EstadoAtencionRoadmap objeto = new EstadoAtencionRoadmap();
                objeto.setIdEstadoAtencionRoadmap(rs.getInt("ID_ESTADO_ATENCION_ROADMAP"));
                objeto.setDescripcionEstadoAtencionRoadmap(rs.getString("DESCRIPCION_ESTADO_ATENCION_ROADMAP"));
         
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
