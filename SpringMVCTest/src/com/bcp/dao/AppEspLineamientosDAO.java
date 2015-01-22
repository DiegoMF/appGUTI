package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcp.modelo.AppEspLineamientos;


public class AppEspLineamientosDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspLineamientosDAO instancia;

    public static AppEspLineamientosDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspLineamientosDAO();
        }
        return instancia;
    }
    
    public AppEspLineamientos obtenerPreAtencionLineamientosPorAplicacion(AppEspLineamientos info) throws Exception {
    	AppEspLineamientos objeto = new AppEspLineamientos();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_lineamientos_por_aplicacion(?,?)");
            
            cs.setInt(1, info.getIdAplicacionEspecializada());
            cs.setInt(2, info.getIdVersion());
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
            	objeto.setIdVersion(rs.getInt("ID_VERSION"));
            	objeto.setIdAccesosGestionPrivilegiosSistemas(rs.getInt("ID_ACCESOS_GESTION_PRIVILEGIOS_SISTEMAS"));
            	objeto.setIdAccesosRevisionPrivilegiosUsuarios(rs.getInt("ID_ACCESOS_REVISION_PRIVILEGIOS_USUARIOS"));
            	objeto.setIdAccesosGestionContrasenas(rs.getInt("ID_ACCESOS_GESTION_CONTRASENAS"));
            	objeto.setIdAccesosPoliticaContrasenas(rs.getInt("ID_ACCESOS_POLITICA_CONTRASENAS"));
            	objeto.setIdAccesosGestionClaves1(rs.getInt("ID_ACCESOS_GESTION_CLAVES_1"));
            	objeto.setIdAccesosGestionClaves2(rs.getInt("ID_ACCESOS_GESTION_CLAVES_2"));
            	objeto.setIdAccesosGestionClaves3(rs.getInt("ID_ACCESOS_GESTION_CLAVES_3"));
            	objeto.setIdAuditoriaRegistroAuditoria(rs.getInt("ID_AUDITORIA_REGISTRO_AUDITORIA"));
            	objeto.setIdAuditoriaProteccionRegistrosAuditoria(rs.getInt("ID_AUDITORIA_PROTECCION_REGISTROS_AUDITORIA"));
            	objeto.setIdAuditoriaRegistroEventosAdministradores(rs.getInt("ID_AUDITORIA_REGISTRO_EVENTOS_ADMINISTRADORES"));
            	objeto.setIdAuditoriaConformidadPoliticas(rs.getInt("ID_AUDITORIA_CONFORMIDAD_POLITICAS"));
            	objeto.setIdContingencia(rs.getInt("ID_CONTINGENCIA"));
            	objeto.setIdControlCambiosProcedimientosSw(rs.getInt("ID_CONTROL_CAMBIOS_PROCEDIMIENTOS_SW"));
            	objeto.setIdControlCambiosProcedimientosInfraestructura(rs.getInt("ID_CONTROL_CAMBIOS_PROCEDIMIENTOS_INFRAESTRUCTURA"));
            	objeto.setIdDocumentacionManejo(rs.getInt("ID_DOCUMENTACION_MANEJO"));
            	objeto.setIdIncidentesCumplimientoPoliticasAntivirus(rs.getInt("ID_INCIDENTES_CUMPLIMIENTO_POLITICAS_ANTIVIRUS"));
            	objeto.setIdIncidentesCumplimientoGestionParches(rs.getInt("ID_INCIDENTES_CUMPLIMIENTO_GESTION_PARCHES"));
            	objeto.setIdIncidentesCumplimientoCodigoMalicioso(rs.getInt("ID_INCIDENTES_CUMPLIMIENTO_CODIGO_MALICIOSO"));
            	objeto.setIdIntegridadConfidencialidadDatosPrueba(rs.getInt("ID_INTEGRIDAD_CONFIDENCIALIDAD_DATOS_PRUEBA"));
            	objeto.setIdRespaldosGestionRespaldoRecuperacion(rs.getInt("ID_RESPALDOS_GESTION_RESPALDO_RECUPERACION"));
            	
            	
                
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }

}
