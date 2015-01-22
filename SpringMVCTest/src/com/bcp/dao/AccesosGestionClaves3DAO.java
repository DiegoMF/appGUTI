package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosGestionClaves3;

public class AccesosGestionClaves3DAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosGestionClaves3DAO instancia;

    public static AccesosGestionClaves3DAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosGestionClaves3DAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosGestionClaves3> obtenerAccesosGestionClaves3() throws Exception {
        ArrayList<AccesosGestionClaves3> lista = new ArrayList<AccesosGestionClaves3>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesos_gestion_claves3()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosGestionClaves3 objeto = new AccesosGestionClaves3();
                objeto.setIdAccesosGestionClaves3(rs.getInt("ID_ACCESOS_GESTION_CLAVES_3"));
                objeto.setDescripcionAccesosGestionClaves3(rs.getString("DESCRIPCION_ACCESOS_GESTION_CLAVES_3"));
         
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
