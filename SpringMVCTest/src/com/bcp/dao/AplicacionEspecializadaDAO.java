package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.dto.AplicacionEspecializadaDTO;
import com.bcp.modelo.AplicacionEspecializada;

public class AplicacionEspecializadaDAO {
	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AplicacionEspecializadaDAO instancia;

    public static AplicacionEspecializadaDAO getInstancia() {
        if (instancia == null) {
            instancia = new AplicacionEspecializadaDAO();
        }
        return instancia;
    }
    
	public ArrayList<AplicacionEspecializada> obtenerVersiones(AplicacionEspecializada apEspecializada) throws Exception {
        ArrayList<AplicacionEspecializada> lista = new ArrayList<AplicacionEspecializada>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_historico_aplicaciones_por_aplicacion1(?)");
            cs.setInt(1, apEspecializada.getIdAplicacionEspecializada());


            rs = cs.executeQuery();
            int i = 1;
            while (rs.next()) {
            	AplicacionEspecializada objeto = new AplicacionEspecializada();
            	objeto.setNumero(i);
                objeto.setIdAplicacionEspecializada(rs.getInt("ID_APLICACION_ESPECIALIZADA"));
                objeto.setIdVersion(rs.getInt("ID_VERSION"));
                objeto.setFechaCreacionRegistro(rs.getString("FECHA_CREACION_REGISTRO"));
                objeto.setMatriculaUsuario(rs.getString("MATRICULA"));
          
                objeto.setMotivoCreacion(rs.getString("DESCRIPCION_MOTIVO_CREACION_APLICACION"));
                objeto.setEstadoVersion(rs.getString("ESTADO_VERSION"));
                lista.add(objeto);
                System.out.println(objeto.getIdVersion());
                i++;
            }
            
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }

	public ArrayList<AplicacionEspecializada> retornaIDVER(AplicacionEspecializada objeto) throws Exception {
		 ArrayList<AplicacionEspecializada> lista = new ArrayList<AplicacionEspecializada>();
       try {
           cnn = Conexion.getConexion();
           CallableStatement cs = null;
           
           
           cs = cnn.prepareCall("call aplicacion_especializada_UPDATE(?,?,?)");
           
           cs.setInt(1, objeto.getIdAplicacionEspecializada());
          
           cs.setInt(2, objeto.getUsuarioCreacion());
           cs.setInt(3, objeto.getIdMotivoCreacion());
           
           
           rs = cs.executeQuery();
           while (rs.next()) {
           	AplicacionEspecializada valor = new AplicacionEspecializada();
              
           	//valor.setIdAplicacionEspecializada(rs.getInt("ID_APP"));
           	valor.setIdVersion(rs.getInt("ID_VER"));
            lista.add(valor);
           }
   
           cnn.close();
           cs.close();
       } catch (SQLException ex) {
           throw ex;
       }
       return lista;
   }
	
	public ArrayList<AplicacionEspecializada> retornaID(AplicacionEspecializada objeto) throws Exception {
		 ArrayList<AplicacionEspecializada> lista = new ArrayList<AplicacionEspecializada>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            
            
            cs = cnn.prepareCall("call aplicacion_especializada_INSERT(?,?)");
            
           
            cs.setInt(1, objeto.getUsuarioCreacion());
            cs.setInt(2, objeto.getIdMotivoCreacion());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AplicacionEspecializada valor = new AplicacionEspecializada();
               
            	valor.setIdAplicacionEspecializada(rs.getInt("ID_APP"));
            	valor.setIdVersion(rs.getInt("ID_VER"));
                lista.add(valor);
            }
    
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }
	
	public int ingresarAplicacionEspecializada(AplicacionEspecializadaDTO objeto) throws Exception {
        int id = 0;
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call aplicacion_especializada_INSERT_GENERAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            cs.setInt(1,objeto.getIdAplicacionEspecializada());  
            cs.setInt(2,objeto.getIdVersion());    
            
            /**ESTRUCTURA ORGANIZACIONAL**/
            cs.setString(3,objeto.getCodigoAplicacionEspecializada());
			cs.setString(4,objeto.getCodigoFNA());
			cs.setInt(5,objeto.getIdArea());
			cs.setInt(6,objeto.getIdDivision());
			cs.setInt(7,objeto.getIdGerenciaCentral());
			cs.setInt(8,objeto.getIdUnidad());
			
			/**INFORMACION GENERAL**/
			cs.setString(9,objeto.getNombreAplicacionNOIT());
			cs.setString(10,objeto.getDescripcionAplicacion());
			cs.setString(11,objeto.getFuncionalidadesAplicacion());
			cs.setString(12,objeto.getFechaCreacionAplicacion());
			cs.setInt(13,objeto.getIdEstadoAplicacion());
			cs.setInt(14,objeto.getIdTipoOperacionProceso());
			cs.setInt(15,objeto.getIdFrecuenciaOperaciones());
			cs.setInt(16,objeto.getIdCantidadOperaciones());
			cs.setInt(17,objeto.getNroEntidadesInternas());
			cs.setInt(18,objeto.getIdMotivoCreacionAplicacion());
			cs.setString(19,objeto.getMotivoCreacionAplicacionOtros());
			cs.setInt(20,objeto.getNroFuncionalidadesTransacciones());
			cs.setInt(21,objeto.getNroReportes());
			cs.setInt(22,objeto.getNroConsultas());
			cs.setInt(23,objeto.getNroEntidadesExternas());
			cs.setString(24,objeto.getObservacionesGenerales());
			
			/**FUNCIONALIDAD**/
			cs.setString(25,objeto.getFuncionalidad());
			cs.setString(26,objeto.getDatosEntrada());
			cs.setString(27,objeto.getProceso());
			cs.setString(28,objeto.getSalida());
			
			/**DOMINIO**/
			cs.setString(29,objeto.getFrontUserLiderUsuario());
			cs.setString(30,objeto.getGestorAplicaciones());
			cs.setString(31,objeto.getEspecialistaAplicaciones());
			cs.setString(32,objeto.getBrokerSistemas());
			cs.setString(33,objeto.getBrokerNegocios());
			cs.setString(34,objeto.getAsesorGUTI());
			cs.setString(35,objeto.getArquitectoDominio());
			cs.setInt(36,objeto.getIdEntidadesUsuarias());
			cs.setInt(37,objeto.getIdDominio());
			cs.setInt(38,objeto.getNroUnidadesUtilizanAplicacion());
			cs.setInt(39,objeto.getIdCantidadUsuariosAplicacionTotal());
			System.out.println("SUBDOMINIO " + objeto.getIdSubDominio());
			cs.setInt(40,objeto.getIdSubDominio());
			cs.setString(41,objeto.getNombreUnidad1());
			cs.setString(42,objeto.getNombreUnidad2());
			cs.setString(43,objeto.getNombreUnidad3());
			cs.setInt(44,objeto.getIdProcesoAuditoria());
			cs.setString(45,objeto.getProcesoAuditoriaOtros());
			cs.setInt(46,objeto.getIdImpactaProcesoClave());
			//cs.setString(47,objeto.getIdProcesoClave());
			cs.setInt(47, objeto.getIdDomProcesoClave());
			System.out.print("ID_PROCESO_CLAVE:   " + objeto.getIdDomProcesoClave());
			cs.setString(48,objeto.getNombreProcesoClaveOtros());
			
			cs.setInt(49,objeto.getActividadDominio());
			cs.setString(50,objeto.getRelacionConCIF());
			
			/**CLASIFICACION DE ACTIVOS**/
			cs.setInt(51,objeto.getIdConfidencialidad());
			cs.setInt(52,objeto.getIdIntegridad());
			cs.setInt(53,objeto.getIdDisponibilidad());
			cs.setInt(54,objeto.getIdPrivacidad());
			cs.setInt(55,objeto.getIdClasificacion());
			cs.setString(56,objeto.getClasificacionActivosObservacion());
			cs.setInt(57,objeto.getIdCriticidadFinal());
			cs.setInt(58,objeto.getIdEstadoRevisionAplicaciones());
			
			/**CARACTERISTICASTECNICAS**/
			cs.setInt(59, objeto.getIdCategoriaTecnologica());
			//cs.setString(59,objeto.getCategoriaTecnologica());
			cs.setString(60,objeto.getCategoriaTecnologicaOtros());
			cs.setInt(61,objeto.getIdTiposDesarrollo());
			cs.setInt(62,objeto.getIdUbicacionFisica());
			cs.setInt(63,objeto.getIdAmbienteAppNOIT());
			cs.setString(64,objeto.getAmbienteAppNOITOtros());
			cs.setString(65,objeto.getNombreUbicacion());
			cs.setInt(66,objeto.getIdInfraestructuraAplicacion());
			cs.setInt(67,objeto.getEsSolucionStandAlone());
			cs.setInt(68,objeto.getNroInterfacesConOtrasApp());
			cs.setString(69,objeto.getNombresInterfaces());
			cs.setInt(70,objeto.getIdMantenimientoAplicacion());
			cs.setString(71,objeto.getMantenimientoNombreProveedor());
			cs.setInt(72,objeto.getIdSoporteAplicacion());
			cs.setString(73,objeto.getSoporteNombrePorveedor());
			cs.setInt(74,objeto.getIdAcessosAplicacion());
			cs.setString(75,objeto.getAccesosNombreProveedor());
			cs.setString(76,objeto.getNombreServidor());
			cs.setString(77,objeto.getUbicacionServidor());
			
			/**DATAMART**/
			cs.setString(78,objeto.getNombreDatamart());
			cs.setInt(79,objeto.getCantidadTablas());
			cs.setInt(80,objeto.getCantidadTablasDescriptivas());
			cs.setInt(81,objeto.getCantidadTablasHechos());
			cs.setInt(82,objeto.getIdHerramientaExplotacionDatos());
			cs.setString(83,objeto.getHerramientaExplotacionDatosOtros());
			cs.setInt(84,objeto.getCantidadReportes());
			cs.setInt(85,objeto.getCantidadUsuarios());
			cs.setString(86,objeto.getFrecuencia());
			cs.setString(87,objeto.getCantidadEspacioTablespace());
			
			/**IMPACTOS**/
			cs.setString(88,objeto.getImpactoFinanciero());
			cs.setString(89,objeto.getRentabilidad());
			cs.setString(90,objeto.getImpactoImagen());
			cs.setString(91,objeto.getImpactoClientes());
			cs.setString(92,objeto.getImpactoOperativo());
			cs.setString(93,objeto.getImpactoLegal());
			cs.setInt(94,objeto.getIdProcesoAuditoriaI());
			cs.setInt(95,objeto.getIdTocaProcesoClave());
			//cs.setString(96,objeto.getIndicarProcesoClave());
			cs.setInt(96, objeto.getIdImpProcesoClave());
			cs.setString(97,objeto.getOtrosProcesoClave());
			cs.setInt(98,objeto.getActividadImpacto());
			cs.setString(99,objeto.getCategoriaTecnologica());
			cs.setString(100,objeto.getNivel_criticidad());
			
			/**ROADMAP**/
			cs.setString(101,objeto.getRoadmapCortoPlazo());
			cs.setString(102,objeto.getRoadmapLargoPlazo());
			cs.setInt(103,objeto.getIdEstadoAtencionRoadmap());
			
			cs.setString(104,objeto.getFechaInicioPlanificado());
			cs.setString(105,objeto.getFechaCompromiso());
			cs.setString(106,objeto.getRoadmapEjecutadoActual());
						
			/**PREATENCION**/
			cs.setInt(107,objeto.getIdSwBaseEstandarSistemaOperativoPRE());
			cs.setString(108,objeto.getSwBaseSistemaOperativoOtrosPRE());
			cs.setInt(109,objeto.getIdSwBaseEstandarHeramientaProgramacionPRE());
			cs.setString(110,objeto.getSwBaseHerramientaProgramacionOtrosPRE());
			cs.setInt(111,objeto.getIdSwBaseEstandarLenguajeProgramacionPRE());
			cs.setString(112,objeto.getSwBaseLenguajeProgramacionOtrosPRE());
			cs.setInt(113,objeto.getIdSwBaseEstandarGestorBDPRE());
			cs.setString(114,objeto.getSwBaseGestorBDOtrosPRE());
			cs.setInt(115,objeto.getIdSwBaseEstandarFrameworkPRE());
			cs.setString(116,objeto.getSwBaseFrameworkOtrosPRE());
			cs.setString(117,objeto.getSwBaseObservacionesAdicionalesPRE());
			
			cs.setInt(118,objeto.getIdAccesosGestionPrivilegiosSistemasPRE());
			cs.setInt(119,objeto.getIdAccesosRevisionPrivilegiosUsuariosPRE());
			cs.setInt(120,objeto.getIdAccesosGestionContrasenasPRE());
			cs.setInt(121,objeto.getIdAccesosPoliticaContrasenasPRE());
			cs.setInt(122,objeto.getIdAccesosGestionClaves1PRE());
			cs.setInt(123,objeto.getIdAccesosGestionClaves2PRE());
			cs.setInt(124,objeto.getIdAccesosGestionClaves3PRE());
			cs.setInt(125,objeto.getIdAuditoriaRegistroAuditoriaPRE());
			cs.setInt(126,objeto.getIdAuditoriaProteccionRegistrosAuditoriaPRE());
			cs.setInt(127,objeto.getIdAuditoriaRegistroEventosAdministradoresPRE());
			cs.setInt(128,objeto.getIdAuditoriaConformidadPoliticasPRE());
			cs.setInt(129,objeto.getIdContingenciaPRE());
			cs.setInt(130,objeto.getIdControlCambiosProcedimientosSwPRE());
			cs.setInt(131,objeto.getIdControlCambiosProcedimientosInfraestructuraPRE());
			cs.setInt(132,objeto.getIdDocumentacionManejoPRE());
			cs.setInt(133,objeto.getIdIncidentesCumplimientoPoliticasAntivirusPRE());
			cs.setInt(134,objeto.getIdIncidentesCumplimientoGestionParchesPRE());
			cs.setInt(135,objeto.getIdIncidentesCumplimientoCodigoMaliciosoPRE());
			cs.setInt(136,objeto.getIdIntegridadConfidencialidadDatosPruebaPRE());
			cs.setInt(137,objeto.getIdRespaldosGestionRespaldoRecuperacionPRE());
			
			/**POSTATENCION**/
			
			cs.setInt(138,objeto.getIdSwBaseEstandarSistemaOperativoPOST());
			cs.setString(139,objeto.getSwBaseSistemaOperativoOtrosPOST());
			cs.setInt(140,objeto.getIdSwBaseEstandarHeramientaProgramacionPOST());
			cs.setString(141,objeto.getSwBaseHerramientaProgramacionOtrosPOST());
			cs.setInt(142,objeto.getIdSwBaseEstandarLenguajeProgramacionPOST());
			cs.setString(143,objeto.getSwBaseLenguajeProgramacionOtrosPOST());
			cs.setInt(144,objeto.getIdSwBaseEstandarGestorBDPOST());
			cs.setString(145,objeto.getSwBaseGestorBDOtrosPOST());
			cs.setInt(146,objeto.getIdSwBaseEstandarFrameworkPOST());/****/
			cs.setString(147,objeto.getSwBaseFrameworkOtrosPOST());
			cs.setString(148,objeto.getSwBaseObservacionesAdicionalesPOST());
			
			cs.setInt(149,objeto.getIdAccesosGestionPrivilegiosSistemasPOST());
			cs.setInt(150,objeto.getIdAccesosRevisionPrivilegiosUsuariosPOST());
			cs.setInt(151,objeto.getIdAccesosGestionContrasenasPOST());
			cs.setInt(152,objeto.getIdAccesosPoliticaContrasenasPOST());
			cs.setInt(153,objeto.getIdAccesosGestionClaves1POST());
			cs.setInt(154,objeto.getIdAccesosGestionClaves2POST());
			cs.setInt(155,objeto.getIdAccesosGestionClaves3POST());
			cs.setInt(156,objeto.getIdAuditoriaRegistroAuditoriaPOST());
			cs.setInt(157,objeto.getIdAuditoriaProteccionRegistrosAuditoriaPOST());
			cs.setInt(158,objeto.getIdAuditoriaRegistroEventosAdministradoresPOST());
			cs.setInt(159,objeto.getIdAuditoriaConformidadPoliticasPOST());
			cs.setInt(160,objeto.getIdContingenciaPOST());
			cs.setInt(161,objeto.getIdControlCambiosProcedimientosSwPOST());
			cs.setInt(162,objeto.getIdControlCambiosProcedimientosInfraestructuraPOST());
			cs.setInt(163,objeto.getIdDocumentacionManejoPOST());
			cs.setInt(164,objeto.getIdIncidentesCumplimientoPoliticasAntivirusPOST());
			cs.setInt(165,objeto.getIdIncidentesCumplimientoGestionParchesPOST());
			cs.setInt(166,objeto.getIdIncidentesCumplimientoCodigoMaliciosoPOST());
			cs.setInt(167,objeto.getIdIntegridadConfidencialidadDatosPruebaPOST());
			cs.setInt(168,objeto.getIdRespaldosGestionRespaldoRecuperacionPOST());
			
			/**INFORMACIONADICIONAL**/

			cs.setString(169,objeto.getEvaluacionSeguridadInformatica());
			cs.setString(170,objeto.getSeguridadNivelExposicion());

			cs.setInt(171,objeto.getIdEscenarioLogueo());
			cs.setInt(172,objeto.getIdImpactoProteccionDatos());
			cs.setInt(173,objeto.getIdImpactoProteccionDatosLevantamientoInformacion());
			
			
			cs.setInt(174,objeto.getIdFuentePeriodo());
			cs.setString(175,objeto.getDescripcionFuente());
			
            cs.execute();
          
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return id;
    }

	public void eliminar(AplicacionEspecializada objeto) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call aplicacion_especializada_DELETE(?)");
	            cs.setInt(1, objeto.getIdAplicacionEspecializada());
	            
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
}
