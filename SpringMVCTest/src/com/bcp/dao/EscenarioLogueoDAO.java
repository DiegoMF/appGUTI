package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.EscenarioLogueo;

public class EscenarioLogueoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static EscenarioLogueoDAO instancia;

    public static EscenarioLogueoDAO getInstancia() {
        if (instancia == null) {
            instancia = new EscenarioLogueoDAO();
        }
        return instancia;
    }
    
    public ArrayList<EscenarioLogueo> obtenerEscenario() throws Exception {
        ArrayList<EscenarioLogueo> lista = new ArrayList<EscenarioLogueo>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_escenario_logueo()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	EscenarioLogueo objeto = new EscenarioLogueo();
                objeto.setIdEscenarioLogueo(rs.getInt("ID_ESCENARIO_LOGUEO"));
                objeto.setDescripcionEscenarioLogueo(rs.getString("DESCRIPCION_ESCENARIO_LOGUEO"));
         
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
