package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosGestionClaves1;

public class AccesosGestionClaves1DAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosGestionClaves1DAO instancia;

    public static AccesosGestionClaves1DAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosGestionClaves1DAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosGestionClaves1> obtenerAccesosGestionClaves1() throws Exception {
        ArrayList<AccesosGestionClaves1> lista = new ArrayList<AccesosGestionClaves1>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesos_gestion_claves1()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosGestionClaves1 objeto = new AccesosGestionClaves1();
                objeto.setIdAccesosGestionClaves1(rs.getInt("ID_ACCESOS_GESTION_CLAVES_1"));
                objeto.setDescripcionAccesosGestionClaves1(rs.getString("DESCRIPCION_ACCESOS_GESTION_CLAVES_1"));
         
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
