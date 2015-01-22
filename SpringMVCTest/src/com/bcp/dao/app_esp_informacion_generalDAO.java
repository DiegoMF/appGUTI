/*package com.bcp.dao;

import com.bcp.modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.usuario;

public class app_esp_informacion_generalDAO {
	 private Connection cnn = null;
	    private ResultSet rs = null;
	    private static app_esp_informacion_generalDAO instancia;

	    public static app_esp_informacion_generalDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new app_esp_informacion_generalDAO();
	        }
	        return instancia;
	    }
	    
	    
	    
	    public void ingresar(app_esp_informacion_general objeto) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call app_esp_informacion_general_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            cs.setString(1, objeto.getNOMBRE_APLICACION_NOIT());
	            cs.setString(2, objeto.getDESCRICION_APLICACION());
	            cs.setString(3, objeto.getFUNCIONALIDADES_APLICACION());
	            cs.setInt(4, objeto.getID_ESTADO_APLICACION());
	            cs.setInt(5, objeto.getID_TIPO_OPERACION_PROCESO());
	            cs.setInt(6, objeto.getID_FRECUENCIA_OPERACIONES());
	            cs.setInt(7, objeto.getID_CANTIDAD_OPERACIONES());
	            cs.setString(8, objeto.getFECHA_CREACION_APLICACION());
	            cs.setInt(9, objeto.getID_MOTIVO_CREACION_APLICACION());
	            cs.setString(10, objeto.getMOTIVO_CREACION_APLICACION_OTROS());
	            cs.setInt(11, objeto.getNRO_FUNCIONALIDADES_TRANSACCIONES());
	            cs.setInt(12, objeto.getNRO_REPORTES());
	            cs.setInt(13, objeto.getNRO_CONSULTAS());
	            cs.setInt(14, objeto.getNRO_ENTIDADES_EXTERNAS());
	            cs.setInt(15, objeto.getNRO_ENTIDADES_INTERNAS());
	            cs.setString(16, objeto.getOBSERVACIONES_GENERALES());
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	    
	    
	    
	    
	    
}*/
