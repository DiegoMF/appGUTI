package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspImpacto;

public class AppEspImpactoDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspImpactoDAO instancia;

    public static AppEspImpactoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspImpactoDAO();
        }
        return instancia;
    }
    
    public AppEspImpacto obtenerImpactoPorAplicacion(AppEspImpacto info) throws Exception {
    	AppEspImpacto objeto = new AppEspImpacto();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_impacto_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setImpactoFinanciero(rs.getString("IMPACTO_FINANCIERO"));
            	objeto.setRentabilidad(rs.getString("RENTABILIDAD"));
            	objeto.setImpactoImagen(rs.getString("IMPACTO_IMAGEN"));
            	objeto.setImpactoClientes(rs.getString("IMPACTO_CLIENTES"));
            	objeto.setImpactoOperativo(rs.getString("IMPACTO_OPERATIVO"));
            	objeto.setImpactoLegal(rs.getString("IMPACTO_LEGAL"));
            	objeto.setIdProcesoAuditoriaI(rs.getInt("ID_PROCESO_AUDITORIA"));
            	objeto.setTocaProcesoClave(rs.getInt("TOCA_PROCESO_CLAVE"));
            	objeto.setIndicarProcesoClave(rs.getInt("INDICAR_PROCESO_CLAVE"));
            	objeto.setOtrosProcesoClave(rs.getString("OTROS_PROCESO_CLAVE"));
            	objeto.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
            	objeto.setCategoriaTecnologica(rs.getString("CATEGORIA_TECNOLOGICA"));
            	objeto.setNivel_criticidad(rs.getString("NIVEL_CRITICIDAD"));

            	
          
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

}
