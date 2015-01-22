package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspDominio;

public class AppEspDominioDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspDominioDAO instancia;

    public static AppEspDominioDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspDominioDAO();
        }
        return instancia;
    }
    
    public AppEspDominio obtenerDominioPorAplicacion(AppEspDominio info) throws Exception {
        AppEspDominio objeto = new AppEspDominio();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_dominio_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setFrontUserLiderUsuario(rs.getString("FRONT_USER_LIDER_USUARIO"));
            	objeto.setGestorAplicaciones(rs.getString("GESTOR_APLICACIONES"));
            	objeto.setEspecialistaAplicaciones(rs.getString("ESPECIALISTA_APLICACIONES"));
            	objeto.setBrokerSistemas(rs.getString("BROKER_SISTEMAS"));
            	objeto.setBrokerNegocios(rs.getString("BROKER_NEGOCIOS"));
            	objeto.setAsesorGUTI(rs.getString("ASESOR_GUTI"));
            	objeto.setArquitectoDominio(rs.getString("ARQUITECTO_DOMINIO"));
            	objeto.setIdEntidadesUsuarias(rs.getInt("ID_ENTIDADES_USUARIAS"));
            	objeto.setIdDominio(rs.getInt("ID_DOMINIO"));
            	objeto.setIdSubDominio(rs.getInt("ID_SUB_DOMINIO"));
            	objeto.setNroUnidadesUtilizanAplicacion(rs.getInt("NRO_UNIDADES_UTILIZAN_APLICACION"));
            	objeto.setNombreUnidad1(rs.getString("NOMBRE_UNIDAD_1"));
            	objeto.setNombreUnidad2(rs.getString("NOMBRE_UNIDAD_2"));
            	objeto.setNombreUnidad3(rs.getString("NOMBRE_UNIDAD_3"));
            	objeto.setIdCantidadUsuariosAplicacionTotal(rs.getInt("ID_CANTIDAD_USUARIOS_APLICACION_TOTAL"));
            	objeto.setIdProcesoAuditoria(rs.getInt("ID_PROCESO_AUDITORIA"));
            	objeto.setProcesoAuditoriaOtros(rs.getString("PROCESO_AUDITORIA_OTROS"));
            	objeto.setImpactaProcesoClave(rs.getInt("IMPACTA_PROCESO_CLAVE"));
            	objeto.setIdProcesoClave(rs.getInt("ID_PROCESO_CLAVE"));
            	objeto.setNombreProcesoClaveOtros(rs.getString("NOMBRE_PROCESO_CLAVE_OTROS"));
            	objeto.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
            	objeto.setRelacionConCIF(rs.getString("RELACION_CON_CIF"));
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

}
