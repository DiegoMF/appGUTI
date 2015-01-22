package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Division;

public class DivisionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static DivisionDAO instancia;

    public static DivisionDAO getInstancia() {
        if (instancia == null) {
            instancia = new DivisionDAO();
        }
        return instancia;
    }
    
    public ArrayList<Division> obtenerDivision() throws Exception {
        ArrayList<Division> lista = new ArrayList<Division>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_division()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	Division objeto = new Division();
                objeto.setIdDivision(rs.getInt("ID_DIVISION"));
                objeto.setDescripcionDivision(rs.getString("DESCRIPCION_DIVISION"));
         
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
