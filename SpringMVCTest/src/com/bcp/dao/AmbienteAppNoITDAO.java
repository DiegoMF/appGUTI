package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AmbienteAppNoIT;



public class AmbienteAppNoITDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AmbienteAppNoITDAO instancia;

    public static AmbienteAppNoITDAO getInstancia() {
        if (instancia == null) {
            instancia = new AmbienteAppNoITDAO();
        }
        return instancia;
    }
    
    public ArrayList<AmbienteAppNoIT> obtenerAmbienteAppNoIT() throws Exception {
        ArrayList<AmbienteAppNoIT> lista = new ArrayList<AmbienteAppNoIT>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_ambiente_appNoIT()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AmbienteAppNoIT objeto = new AmbienteAppNoIT();
                objeto.setIdAmbienteAppNoIT(rs.getInt("ID_AMBIENTE_APPNOIT"));
                objeto.setDescripcionAmbienteAppNoIT(rs.getString("DESCRIPCION_AMBIENTE_APPNOIT"));
         
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
