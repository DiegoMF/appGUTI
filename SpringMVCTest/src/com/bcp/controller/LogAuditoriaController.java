package com.bcp.controller;

import java.net.InetAddress;
import java.sql.CallableStatement;
import java.sql.SQLException;

import com.bcp.dao.Conexion;
import com.bcp.dao.LogAuditoriaDAO;
import com.bcp.modelo.LogAuditoria;

public class LogAuditoriaController {
	
	public void guardarLogAuditoria(LogAuditoria objeto) throws Exception {
    	

   	 try {
 		LogAuditoriaDAO logAuditoria = new LogAuditoriaDAO();

   		logAuditoria.getInstancia().guardarLogAuditoria(objeto);
    
        } catch (SQLException ex) {
            throw ex;
        }
		
   }
	
	 public String obtenerIP()throws Exception{
 		
		 LogAuditoriaDAO logAuditoria = new LogAuditoriaDAO();
		return logAuditoria.obtenerIP();
 }
	
	
	

}
