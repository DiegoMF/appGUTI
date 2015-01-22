package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

import com.bcp.modelo.AppEspEstructuraOrganizacional;

public class AppEspEstructuraOrganizacionalDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspEstructuraOrganizacionalDAO instancia;

    public static AppEspEstructuraOrganizacionalDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspEstructuraOrganizacionalDAO();
        }
        return instancia;
    }
    
    public AppEspEstructuraOrganizacional obtenerEstructuraPorAplicacion(AppEspEstructuraOrganizacional info) throws Exception {
    	AppEspEstructuraOrganizacional objeto = new AppEspEstructuraOrganizacional();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_estructura_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	
            
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
                objeto.setCodigoAplicacionEspecializada(rs.getString("CODIGO_APLICACION_ESPECIALIZADA"));
                objeto.setCodigoFNA(rs.getString("CODIGO_FNA"));
              	objeto.setIdArea(rs.getInt("ID_AREA"));
              	objeto.setIdDivision(rs.getInt("ID_DIVISION"));
              	objeto.setIdGerenciaCentral(rs.getInt("ID_GERENCIA_CENTRAL"));
              	objeto.setIdUnidad(rs.getInt("ID_UNIDAD"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
    
    public ArrayList<AppEspEstructuraOrganizacional> listar() throws Exception {
    	ArrayList<AppEspEstructuraOrganizacional> lista = new ArrayList<AppEspEstructuraOrganizacional>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_estructura_por_aplicacion()");
                       
            rs = cs.executeQuery();
            while (rs.next()) {
            	           	
            	AppEspEstructuraOrganizacional objeto = new AppEspEstructuraOrganizacional();
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
                objeto.setCodigoAplicacionEspecializada(rs.getString("CODIGO_APLICACION_ESPECIALIZADA"));
                objeto.setCodigoFNA(rs.getString("CODIGO_FNA"));
              	objeto.setIdArea(rs.getInt("ID_AREA"));
              	objeto.setIdDivision(rs.getInt("ID_DIVISION"));
              	objeto.setIdGerenciaCentral(rs.getInt("ID_GERENCIA_CENTRAL"));
              	objeto.setIdUnidad(rs.getInt("ID_UNIDAD"));
                lista.add(objeto);
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }
	

	
    
    public void ingresar(AppEspEstructuraOrganizacional objeto) throws Exception {
        //int id = 0;
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call app_esp_estructura_organizacional_INSERT(?,?,?,?,?,?,?)");        
            cs.setInt(1, objeto.getIdAplicacionEspecializada());
            cs.setInt(2, objeto.getIdGerenciaCentral());
            cs.setInt(3, objeto.getIdDivision());
            cs.setInt(4, objeto.getIdArea());
            cs.setInt(5, objeto.getIdUnidad());
            cs.setString(6, objeto.getCodigoFNA());
            cs.setString(7, objeto.getCodigoAplicacionEspecializada());
            cs.execute();
            
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
    
}
