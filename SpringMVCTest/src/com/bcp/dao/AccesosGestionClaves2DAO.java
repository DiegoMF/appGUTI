package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosGestionClaves2;

public class AccesosGestionClaves2DAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosGestionClaves2DAO instancia;

    public static AccesosGestionClaves2DAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosGestionClaves2DAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosGestionClaves2> obtenerAccesosGestionClaves2() throws Exception {
        ArrayList<AccesosGestionClaves2> lista = new ArrayList<AccesosGestionClaves2>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesos_gestion_claves2()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosGestionClaves2 objeto = new AccesosGestionClaves2();
                objeto.setIdAccesosGestionClaves2(rs.getInt("ID_ACCESOS_GESTION_CLAVES_2"));
                objeto.setDescripcionAccesosGestionClaves2(rs.getString("DESCRIPCION_ACCESOS_GESTION_CLAVES_2"));
         
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
