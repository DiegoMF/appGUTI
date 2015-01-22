package com.bcp.dao;

import java.net.InetAddress;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.LogAuditoria;

public class LogAuditoriaDAO {
	private Connection cnn = null;
//    private ResultSet rs = null;
    private static LogAuditoriaDAO instancia;

    public static LogAuditoriaDAO getInstancia() {
        if (instancia == null) {
            instancia = new LogAuditoriaDAO();
        }
        return instancia;
    }
    
    public void guardarLogAuditoria(LogAuditoria objeto) throws Exception {
    	
    	 try {
             cnn = Conexion.getConexion();
             CallableStatement cs = null;
             cs = cnn.prepareCall("call log_auditoria_insert(?,?,?,?,?,?,?,?)");
             
             cs.setString(1, objeto.getPagina());
             System.out.println("mostrar pagina:= "+ objeto.getPagina());
             cs.setString(2, objeto.getObjeto());
             System.out.println("mostrar objeto:= "+ objeto.getObjeto());
             cs.setString(3, objeto.getTraza_error());
             System.out.println("mostrar traza:= "+ objeto.getTraza_error());
             cs.setString(4, objeto.getTipo());
             System.out.println("mostrar tipo:= "+ objeto.getTipo());
             cs.setString(5, objeto.getIp());
             System.out.println("mostrar ip:= "+ objeto.getIp());
             cs.setString(6, objeto.getUsuario());
             System.out.println("mostrar usuario:= "+ objeto.getUsuario());
             cs.setString(7, objeto.getFecha());
             System.out.println("mostrar fecha:= "+ objeto.getFecha());
             cs.setString(8, objeto.getHora());
             System.out.println("mostrar hora:= "+ objeto.getHora());
             //cs.setString(9, objeto.getHora());

             cs.execute();
             
             cnn.close();
             cs.close();
         } catch (SQLException ex) {
             throw ex;
         }
 		
    }
    
    public String obtenerIP()throws Exception{
    		String ip;
    //	try{
    	
    		InetAddress miIp=  InetAddress.getLocalHost();	
    		//IP= String.valueOf(miIp.getHostAddress());
    		ip= miIp.getHostAddress().toString();
    		System.out.println("Ip de mi sistema:= "+ ip);
    	
   /* } catch ( ex) {
        throw ex;
    }*/
    	
		return ip;
    }

}
