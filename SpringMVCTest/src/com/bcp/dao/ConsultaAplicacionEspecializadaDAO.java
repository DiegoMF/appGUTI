package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.dto.ConsultaGeneralAplicacionesDTO;
//import com.util.ConstantesSQL;

public class ConsultaAplicacionEspecializadaDAO {

	private Connection cnn, cnn1, cnn3 = null;
	private ResultSet rs, rs1, rs3 = null;
	private static ConsultaAplicacionEspecializadaDAO instancia;

	public static ConsultaAplicacionEspecializadaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ConsultaAplicacionEspecializadaDAO();
		}
		return instancia;
	}

	public ArrayList<ConsultaGeneralAplicacionesDTO> obtenerAplicaciones(
			ConsultaGeneralAplicacionesDTO aplicaciones) throws Exception {

		ArrayList<ConsultaGeneralAplicacionesDTO> datos = new ArrayList<ConsultaGeneralAplicacionesDTO>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call aplicacion_especializada_consulta_general(?,?,?,?,?,?,?,?,?)");
			cs.setString(1, aplicaciones.getCodigoAplicacion());
			cs.setString(2, aplicaciones.getNombreAplicacion());
			cs.setInt(3, aplicaciones.getIdEstadoAplicacion());
			cs.setInt(4, aplicaciones.getIdClasificacion());
			cs.setInt(5, aplicaciones.getIdCriticidadFinal());
			String nivelCump = aplicaciones.getNivelCumplimiento() == -1.0 ? ""
					: String.valueOf(aplicaciones.getNivelCumplimiento());
			cs.setString(6, nivelCump);
			cs.setInt(7, aplicaciones.getIdEstadoAtencionRoadmap());
			String nivelCumpPost = aplicaciones.getPostAtencionNivelCumplimiento() == -1.0 ? ""
					: String.valueOf(aplicaciones.getPostAtencionNivelCumplimiento());
			cs.setString(8, nivelCumpPost);
			cs.setString(9, aplicaciones.getProcesoClave());
			rs = cs.executeQuery();

			int i = 1;
			while (rs.next()) {
				ConsultaGeneralAplicacionesDTO dato = new ConsultaGeneralAplicacionesDTO();
				dato.setNumero(i);
				dato.setCodigoAplicacion(rs.getString(1));
				dato.setNombreAplicacion(rs.getString(2));
				dato.setEstadoAplicacion(rs.getString(3));
				dato.setProcesoClave(rs.getString(4));
				dato.setClasificacion(rs.getString(5));
				dato.setCriticidadFinal(rs.getString(6));
				dato.setNivelCumplimiento(rs.getDouble(7));
				dato.setEstadoAtencionRoadmap(rs.getString(8));
				dato.setPostAtencionNivelCumplimiento(rs.getDouble(9));
				dato.setIdAplicacion(rs.getInt(10));
				dato.setIdVersion(rs.getInt(11));
				datos.add(dato);
				i++;
			}
			cnn.close();
			cs.close();
		} catch (SQLException e) {
			throw e;
		}
		return datos;
	}

	
	public ArrayList<ConsultaGeneralAplicacionesDTO> obtenerInventarioAplicaciones() throws Exception {
		System.out.print("obtener inventario   ");

		ArrayList<ConsultaGeneralAplicacionesDTO> listaDatos = new ArrayList<ConsultaGeneralAplicacionesDTO>();
		ArrayList<ConsultaGeneralAplicacionesDTO> listaDatos2 = new ArrayList<ConsultaGeneralAplicacionesDTO>();
		ArrayList<ConsultaGeneralAplicacionesDTO> listaDatosFinal = new ArrayList<ConsultaGeneralAplicacionesDTO>();
		
		try {
			cnn = Conexion.getConexion();
			System.out.print("conexion   ");
			CallableStatement cs = null;

			cs=cnn.prepareCall("call aplicacion_especializada_consulta_general_exportar_1()");
			rs = cs.executeQuery();
			
			int i = 1;
			while (rs.next()) {
				ConsultaGeneralAplicacionesDTO dato = new ConsultaGeneralAplicacionesDTO();
				System.out.println("numero "+ i);
				dato.setNumero(i);
				
				dato.setDesGerenciaCentral(rs.getString(1));
				dato.setDesDivision(rs.getString(2));
				dato.setDesArea(rs.getString(3));
				dato.setDesUnidad(rs.getString(4));
				
				dato.setCodigoFNA(rs.getString(5));
				dato.setCodigoAplicacion(rs.getString(6));
				dato.setNombreAplicacion(rs.getString(7));
				dato.setDescripcionAplicacion(rs.getString(8));
				
				dato.setFuncionalidadesAplicacion(rs.getString(9));
				dato.setEstadoAplicacion(rs.getString(10));
				dato.setTipoOperacionesProcesa(rs.getString(11));
				dato.setFrecuenciaOperacionesProcesa(rs.getString(12));
				
				dato.setCantidadOperaciones(rs.getString(13));
				dato.setFechaCreacionAplicacion(rs.getString(14));
				dato.setMotivoCreacionAplicacion(rs.getString(15));
				dato.setMotivoCreacionAplicacionOtros(rs.getString(16));
				
				
				dato.setNroFuncionalidadesTransacciones(rs.getString(17));
				dato.setNroReportes(rs.getString(18));
				dato.setNroConsultas(rs.getString(19));
				dato.setNroEntidadesExternas(rs.getString(20));
				dato.setNroEntidadesInternas(rs.getString(21));
				dato.setObservacionesGenerales(rs.getString(22));
				
				dato.setCategoriaTecnologica(rs.getString(23));
				dato.setCategoriaTecnologicaOtros(rs.getString(24));
				dato.setTipoDesarrollo(rs.getString(25));
				dato.setUbicacionFisica(rs.getString(26));
				dato.setAmbienteAppNOIT(rs.getString(27));

				
				dato.setAmbienteAppNOITOtros(rs.getString(28));
				dato.setNombreUbicacion(rs.getString(29));
				dato.setDescripcionInfraestructuraAplicacion(rs.getString(30));
				dato.setEsSolucionStandAlone(rs.getString(31));
				dato.setNroInterfacesOtrasApp(rs.getString(32));
				
				dato.setNombresInterfaces(rs.getString(33));
				dato.setDescripcionMantenimientoAplicacion(rs.getString(34));
				dato.setMantenimientoNombreProveedor(rs.getString(35));
				dato.setDescripcionSoporteAplicacion(rs.getString(36));
				dato.setSoporteNombrePorveedor(rs.getString(37));
				dato.setDescripcionAccesosAplicacion(rs.getString(38));
				dato.setAccesosNombreProveedor(rs.getString(39));

				//////
				dato.setNombreServidor(rs.getString(40));
				dato.setUbicacionServidor(rs.getString(41));
				dato.setFrontUserLiderUsuario(rs.getString(42));
				dato.setGestorAplicaciones(rs.getString(43));
				dato.setEspecialistaAplicaciones(rs.getString(44));

				dato.setBrokerSistemas(rs.getString(45));
				dato.setBrokerNegocios(rs.getString(46));
				dato.setAsesorGUTI(rs.getString(47));
				dato.setArquitectoDominio(rs.getString(48));
				dato.setDescripcionEntidadesUsuarias(rs.getString(49));
				
				dato.setDescripcionDominio(rs.getString(50));
				dato.setDescripcionSubDominio(rs.getString(51));
				dato.setNroUnidadesUtilizanAplicacion(rs.getString(52));
				dato.setNombreUnidad1(rs.getString(53));
				dato.setNombreUnidad2(rs.getString(54));
				
				dato.setNombreUnidad3(rs.getString(55));
				dato.setDescripcionCantidadUsuariosAplicacionTotal(rs.getString(56));
				dato.setDescripcionProcesoAuditoria(rs.getString(57));
				dato.setProcesoAuditoriaOtros(rs.getString(58));
				dato.setImpactaProcesoClave(rs.getString(59));
			
				/////
				dato.setDescripcionProcesoClave(rs.getString(60));
				dato.setNombreProcesoClaveOtros(rs.getString(61));
				dato.setDescripcionActividad(rs.getString(62));
				dato.setRelacionCIF(rs.getString(63));
				dato.setDescripcionConfidencialidad(rs.getString(64));
				
				dato.setDescripcionIntegridad(rs.getString(65));
				dato.setDescripcionDisponibilidad(rs.getString(66));
				dato.setDescripcionPrivacidad(rs.getString(67));
				dato.setClasificacionActivosObservacion(rs.getString(68));
				dato.setDescripcionCriticidadFinal(rs.getString(69));
				
				dato.setDescripcionEstadoRevisionAplicacion(rs.getString(70));
				dato.setDescripcionSwBaseEstandarSistemaOperativo(rs.getString(71));
				dato.setSwBaseSistemaOperativoOtros(rs.getString(72));
				dato.setDescripcionSwBaseEstandarHerramientaProgramacion(rs.getString(73));
				dato.setSwBaseHerramientaProgramacionOtros(rs.getString(74));
				
				dato.setDescripcionSwBaseEstandarLenguajeProgramacion(rs.getString(75));
				dato.setSwBaseLenguajeProgramacionOtros(rs.getString(76));
				dato.setDecripcionSwBaseEstandarGestorBD(rs.getString(77));
				dato.setSwBaseGestorBDOtros(rs.getString(78));
				dato.setDescripcionSwBaseEstandarFramework(rs.getString(79));
				
				dato.setSwBaseFrameworkOtros(rs.getString(80));
				dato.setSwBaseObservacionesAdicionales(rs.getString(81));
				dato.setCompatibleWindows7(rs.getString(82));
				dato.setCompatibleIExplorer8(rs.getString(83));
				dato.setCompatiblePTerminal(rs.getString(84));
				
				dato.setSegurinetActiveDirectory(rs.getString(85));
				
				listaDatos.add(dato);
				i++;
			}
			
			cnn.close();
			cs.close();
			
			
			cnn1 = Conexion.getConexion();
			CallableStatement cs1 = null;
			cs1=cnn1.prepareCall("call aplicacion_especializada_consulta_general_exportar_2()");
			rs1 = cs1.executeQuery();
			
		
			int aux=0;
			
			while (rs1.next()) {

				ConsultaGeneralAplicacionesDTO  dato2 = new ConsultaGeneralAplicacionesDTO();
				dato2.setNumero(listaDatos.get(aux).getNumero());
				dato2.setDesGerenciaCentral(listaDatos.get(aux).getDesGerenciaCentral());
				dato2.setDesDivision(listaDatos.get(aux).getDesDivision());
				dato2.setDesArea(listaDatos.get(aux).getDesArea());
				dato2.setDesUnidad(listaDatos.get(aux).getDesUnidad());
				
				dato2.setCodigoFNA(listaDatos.get(aux).getCodigoFNA());
				dato2.setCodigoAplicacion(listaDatos.get(aux).getCodigoAplicacion());
				dato2.setNombreAplicacion(listaDatos.get(aux).getNombreAplicacion());
				dato2.setDescripcionAplicacion(listaDatos.get(aux).getDescripcionAplicacion());
				
				dato2.setFuncionalidadesAplicacion(listaDatos.get(aux).getFuncionalidadesAplicacion());
				dato2.setEstadoAplicacion(listaDatos.get(aux).getEstadoAplicacion());
				dato2.setTipoOperacionesProcesa(listaDatos.get(aux).getTipoOperacionesProcesa());
				dato2.setFrecuenciaOperacionesProcesa(listaDatos.get(aux).getFrecuenciaOperacionesProcesa());
				
				dato2.setCantidadOperaciones(listaDatos.get(aux).getCantidadOperaciones());
				dato2.setFechaCreacionAplicacion(listaDatos.get(aux).getFechaCreacionAplicacion());
				dato2.setMotivoCreacionAplicacion(listaDatos.get(aux).getMotivoCreacionAplicacion());
				dato2.setMotivoCreacionAplicacionOtros(listaDatos.get(aux).getMotivoCreacionAplicacionOtros());
				
				
				dato2.setNroFuncionalidadesTransacciones(listaDatos.get(aux).getNroFuncionalidadesTransacciones());
				dato2.setNroReportes(listaDatos.get(aux).getNroReportes());
				dato2.setNroConsultas(listaDatos.get(aux).getNroConsultas());
				dato2.setNroEntidadesExternas(listaDatos.get(aux).getNroEntidadesExternas());
				dato2.setNroEntidadesInternas(listaDatos.get(aux).getNroEntidadesInternas());
				dato2.setObservacionesGenerales(listaDatos.get(aux).getObservacionesGenerales());
				
				dato2.setCategoriaTecnologica(listaDatos.get(aux).getCategoriaTecnologica());
				dato2.setCategoriaTecnologicaOtros(listaDatos.get(aux).getCategoriaTecnologicaOtros());
				dato2.setTipoDesarrollo(listaDatos.get(aux).getTipoDesarrollo());
				dato2.setUbicacionFisica(listaDatos.get(aux).getUbicacionFisica());
				dato2.setAmbienteAppNOIT(listaDatos.get(aux).getAmbienteAppNOIT());

				
				dato2.setAmbienteAppNOITOtros(listaDatos.get(aux).getAmbienteAppNOITOtros());
				dato2.setNombreUbicacion(listaDatos.get(aux).getNombreUbicacion());
				dato2.setDescripcionInfraestructuraAplicacion(listaDatos.get(aux).getDescripcionInfraestructuraAplicacion());
				dato2.setEsSolucionStandAlone(listaDatos.get(aux).getEsSolucionStandAlone());
				dato2.setNroInterfacesOtrasApp(listaDatos.get(aux).getNroInterfacesOtrasApp());
				
				dato2.setNombresInterfaces(listaDatos.get(aux).getNombresInterfaces());
				dato2.setDescripcionMantenimientoAplicacion(listaDatos.get(aux).getDescripcionMantenimientoAplicacion());
				dato2.setMantenimientoNombreProveedor(listaDatos.get(aux).getMantenimientoNombreProveedor());
				dato2.setDescripcionSoporteAplicacion(listaDatos.get(aux).getDescripcionSoporteAplicacion());
				dato2.setSoporteNombrePorveedor(listaDatos.get(aux).getSoporteNombrePorveedor());
				dato2.setDescripcionAccesosAplicacion(listaDatos.get(aux).getDescripcionAccesosAplicacion());
				dato2.setAccesosNombreProveedor(listaDatos.get(aux).getAccesosNombreProveedor());

				//////
				dato2.setNombreServidor(listaDatos.get(aux).getNombreServidor());
				dato2.setUbicacionServidor(listaDatos.get(aux).getUbicacionServidor());
				dato2.setFrontUserLiderUsuario(listaDatos.get(aux).getFrontUserLiderUsuario());
				dato2.setGestorAplicaciones(listaDatos.get(aux).getGestorAplicaciones());
				dato2.setEspecialistaAplicaciones(listaDatos.get(aux).getEspecialistaAplicaciones());

				dato2.setBrokerSistemas(listaDatos.get(aux).getBrokerSistemas());
				dato2.setBrokerNegocios(listaDatos.get(aux).getBrokerNegocios());
				dato2.setAsesorGUTI(listaDatos.get(aux).getAsesorGUTI());
				dato2.setArquitectoDominio(listaDatos.get(aux).getArquitectoDominio());
				dato2.setDescripcionEntidadesUsuarias(listaDatos.get(aux).getDescripcionEntidadesUsuarias());
				
				dato2.setDescripcionDominio(listaDatos.get(aux).getDescripcionDominio());
				dato2.setDescripcionSubDominio(listaDatos.get(aux).getDescripcionSubDominio());
				dato2.setNroUnidadesUtilizanAplicacion(listaDatos.get(aux).getNroUnidadesUtilizanAplicacion());
				dato2.setNombreUnidad1(listaDatos.get(aux).getNombreUnidad1());
				dato2.setNombreUnidad2(listaDatos.get(aux).getNombreUnidad2());
				
				dato2.setNombreUnidad3(listaDatos.get(aux).getNombreUnidad3());
				dato2.setDescripcionCantidadUsuariosAplicacionTotal(listaDatos.get(aux).getDescripcionCantidadUsuariosAplicacionTotal());
				dato2.setDescripcionProcesoAuditoria(listaDatos.get(aux).getDescripcionProcesoAuditoria());
				dato2.setProcesoAuditoriaOtros(listaDatos.get(aux).getProcesoAuditoriaOtros());
				dato2.setImpactaProcesoClave(listaDatos.get(aux).getImpactaProcesoClave());

				dato2.setDescripcionProcesoClave(listaDatos.get(aux).getDescripcionProcesoClave());
				dato2.setNombreProcesoClaveOtros(listaDatos.get(aux).getNombreProcesoClaveOtros());
				dato2.setDescripcionActividad(listaDatos.get(aux).getDescripcionActividad());
				dato2.setRelacionCIF(listaDatos.get(aux).getRelacionCIF());
				dato2.setDescripcionConfidencialidad(listaDatos.get(aux).getDescripcionConfidencialidad());
				
				dato2.setDescripcionIntegridad(listaDatos.get(aux).getDescripcionIntegridad());
				dato2.setDescripcionDisponibilidad(listaDatos.get(aux).getDescripcionDisponibilidad());
				dato2.setDescripcionPrivacidad(listaDatos.get(aux).getDescripcionPrivacidad());
				dato2.setClasificacionActivosObservacion(listaDatos.get(aux).getClasificacionActivosObservacion());
				dato2.setDescripcionCriticidadFinal(listaDatos.get(aux).getDescripcionCriticidadFinal());
				
				dato2.setDescripcionEstadoRevisionAplicacion(listaDatos.get(aux).getDescripcionEstadoRevisionAplicacion());
				dato2.setDescripcionSwBaseEstandarSistemaOperativo(listaDatos.get(aux).getDescripcionSwBaseEstandarSistemaOperativo());
				dato2.setSwBaseSistemaOperativoOtros(listaDatos.get(aux).getSwBaseSistemaOperativoOtros());
				dato2.setDescripcionSwBaseEstandarHerramientaProgramacion(listaDatos.get(aux).getDescripcionSwBaseEstandarHerramientaProgramacion());
				dato2.setSwBaseHerramientaProgramacionOtros(listaDatos.get(aux).getSwBaseHerramientaProgramacionOtros());
				
				dato2.setDescripcionSwBaseEstandarLenguajeProgramacion(listaDatos.get(aux).getDescripcionSwBaseEstandarLenguajeProgramacion());
				dato2.setSwBaseLenguajeProgramacionOtros(listaDatos.get(aux).getSwBaseLenguajeProgramacionOtros());
				dato2.setDecripcionSwBaseEstandarGestorBD(listaDatos.get(aux).getDecripcionSwBaseEstandarGestorBD());
				dato2.setSwBaseGestorBDOtros(listaDatos.get(aux).getSwBaseGestorBDOtros());
				dato2.setDescripcionSwBaseEstandarFramework(listaDatos.get(aux).getDescripcionSwBaseEstandarFramework());
				
				dato2.setSwBaseFrameworkOtros(listaDatos.get(aux).getSwBaseFrameworkOtros());
				dato2.setSwBaseObservacionesAdicionales(listaDatos.get(aux).getSwBaseObservacionesAdicionales());
				dato2.setCompatibleWindows7(listaDatos.get(aux).getCompatibleWindows7());
				dato2.setCompatibleIExplorer8(listaDatos.get(aux).getCompatibleIExplorer8());
				dato2.setCompatiblePTerminal(listaDatos.get(aux).getCompatiblePTerminal());
				
				dato2.setSegurinetActiveDirectory(listaDatos.get(aux).getSegurinetActiveDirectory());
				
				// Consulta
		
				dato2.setDescripcionAccesosGestionPrivilegiosSistemas(rs1.getString(1));
				System.out.print("lista datos 2 descripcion"+ dato2.getDescripcionAccesosGestionPrivilegiosSistemas());
				
				dato2.setDescripcionAccesosRevisionPrivilegiosUsuarios(rs1.getString(2));
				dato2.setDescripcionAccesosGestionContrasenas(rs1.getString(3));
				dato2.setDescripcionAccesosPoliticaContrasenas(rs1.getString(4));
				dato2.setDescripcionAccesosGestionClaves1(rs1.getString(5));
				
				dato2.setDescripcionAccesosGestionClaves2(rs1.getString(6));
				dato2.setDescripcionAccesosGestionClaves3(rs1.getString(7));
				dato2.setDescripcionAuditoriaRegistroAuditoria(rs1.getString(8));
				dato2.setDescripcionAuditoriaProteccionRegistrosAuditoria(rs1.getString(9));
				dato2.setDescripcionAuditoriaRegistroEventosAdministradores(rs1.getString(10));
				
				dato2.setDescripcionAuditoriaConformidadPoliticas(rs1.getString(11));
				dato2.setDescripcionContingencia(rs1.getString(12));
				dato2.setDescripcionControlCambiosProcedimientosSw(rs1.getString(13));
				dato2.setDescripcionControlCambiosProcedimientoInfraestructura(rs1.getString(14));
				dato2.setDescripcionDocumentacionManejo(rs1.getString(15));
				///
				
				dato2.setDescripcionIncidentesCumplimientoPoliticasAntivirus(rs1.getString(16));
				dato2.setDescripcionIncidentesCumplimientoGestionParches(rs1.getString(17));
				dato2.setDescripcionIncidentesCumplimientoCodigoMalicioso(rs1.getString(18));
				dato2.setDescripcionIntegridadConfidencialidadDatosPrueba(rs1.getString(19));
				dato2.setDescripcionRespaldosGestionRespaldoRecuperacion(rs1.getString(20));
				
				dato2.setNivelCumplimientoEstandaresTecnologico(rs1.getString(21));
				dato2.setNivelCumplimientoEstandaresPorcentaje(rs1.getString(22));
				dato2.setNivelCumplimientoLineamientos(rs1.getString(23));
				dato2.setNivelCumplimientoLineamientosPorcentaje(rs1.getString(24));
				dato2.setNivelCumplimientoTotal(rs1.getString(25));
				dato2.setRoadmapCortoPlazo(rs1.getString(26));
				
				dato2.setRoadmapLargoPlazo(rs1.getString(27));
				dato2.setFechaInicioPlanificado(rs1.getString(28));
				dato2.setFechaCompromiso(rs1.getString(29));
				dato2.setRoadmapEjecutadoActual(rs1.getString(30));
				dato2.setTrackAtencion(rs1.getString(31));
				
				dato2.setDescripcionEstadoAtencionRoadmap(rs1.getString(32));
				dato2.setDescripcionEtapaAtencionRoadmap(rs1.getString(33));
				dato2.setDescripcionPostSwBaseEstandarSistemaOperativo(rs1.getString(34));
				dato2.setPostSwBaseSistemaOperativoOtros(rs1.getString(35));
				dato2.setDecripcionPostSwBaseEstandarHerramientaProgramación(rs1.getString(36));
				
				dato2.setPostSwBaseHerramientaProgramacionOtros(rs1.getString(37));
				dato2.setDescripcionPostSwBaseEstandarLenguajeProgramacion(rs1.getString(38));
				dato2.setPostSwBaseLenguajeProgramacionOtros(rs1.getString(39));
				dato2.setDescripcionPostSwBaseEstandarGestorBD(rs1.getString(40));
				dato2.setPostSwBaseGestorBDOtros(rs1.getString(41));
				
				dato2.setDescripcionPostSwBaseEstandarFramework(rs1.getString(42));
				dato2.setPostSwBaseFrameworkOtros(rs1.getString(43));
				dato2.setPostSwBaseObservacionesAdicionales(rs1.getString(44));
			

				listaDatos2.add(dato2);
			
				aux=aux+1;
			}
			
			cnn1.close();
			cs1.close();
			
			
			cnn3 = Conexion.getConexion();
			CallableStatement cs3 = null;
			cs3=cnn3.prepareCall("call aplicacion_especializada_consulta_general_exportar_3()");
			rs3 = cs3.executeQuery();
			
			aux=0;
			while (rs3.next()) {
				ConsultaGeneralAplicacionesDTO dato3 = new ConsultaGeneralAplicacionesDTO();
				
				dato3.setNumero(listaDatos2.get(aux).getNumero());
				dato3.setDesGerenciaCentral(listaDatos2.get(aux).getDesGerenciaCentral());
				dato3.setDesDivision(listaDatos2.get(aux).getDesDivision());
				dato3.setDesArea(listaDatos2.get(aux).getDesArea());
				dato3.setDesUnidad(listaDatos2.get(aux).getDesUnidad());
				
				dato3.setCodigoFNA(listaDatos2.get(aux).getCodigoFNA());
				dato3.setCodigoAplicacion(listaDatos2.get(aux).getCodigoAplicacion());
				dato3.setNombreAplicacion(listaDatos2.get(aux).getNombreAplicacion());
				dato3.setDescripcionAplicacion(listaDatos2.get(aux).getDescripcionAplicacion());
				
				dato3.setFuncionalidadesAplicacion(listaDatos2.get(aux).getFuncionalidadesAplicacion());
				dato3.setEstadoAplicacion(listaDatos2.get(aux).getEstadoAplicacion());
				dato3.setTipoOperacionesProcesa(listaDatos2.get(aux).getTipoOperacionesProcesa());
				dato3.setFrecuenciaOperacionesProcesa(listaDatos2.get(aux).getFrecuenciaOperacionesProcesa());
				
				dato3.setCantidadOperaciones(listaDatos2.get(aux).getCantidadOperaciones());
				dato3.setFechaCreacionAplicacion(listaDatos2.get(aux).getFechaCreacionAplicacion());
				dato3.setMotivoCreacionAplicacion(listaDatos2.get(aux).getMotivoCreacionAplicacion());
				dato3.setMotivoCreacionAplicacionOtros(listaDatos2.get(aux).getMotivoCreacionAplicacionOtros());
				
				
				dato3.setNroFuncionalidadesTransacciones(listaDatos2.get(aux).getNroFuncionalidadesTransacciones());
				dato3.setNroReportes(listaDatos2.get(aux).getNroReportes());
				dato3.setNroConsultas(listaDatos2.get(aux).getNroConsultas());
				dato3.setNroEntidadesExternas(listaDatos2.get(aux).getNroEntidadesExternas());
				dato3.setNroEntidadesInternas(listaDatos2.get(aux).getNroEntidadesInternas());
				dato3.setObservacionesGenerales(listaDatos2.get(aux).getObservacionesGenerales());
				
				dato3.setCategoriaTecnologica(listaDatos2.get(aux).getCategoriaTecnologica());
				dato3.setCategoriaTecnologicaOtros(listaDatos2.get(aux).getCategoriaTecnologicaOtros());
				dato3.setTipoDesarrollo(listaDatos2.get(aux).getTipoDesarrollo());
				dato3.setUbicacionFisica(listaDatos2.get(aux).getUbicacionFisica());
				dato3.setAmbienteAppNOIT(listaDatos2.get(aux).getAmbienteAppNOIT());

				
				dato3.setAmbienteAppNOITOtros(listaDatos2.get(aux).getAmbienteAppNOITOtros());
				dato3.setNombreUbicacion(listaDatos2.get(aux).getNombreUbicacion());
				dato3.setDescripcionInfraestructuraAplicacion(listaDatos2.get(aux).getDescripcionInfraestructuraAplicacion());
				dato3.setEsSolucionStandAlone(listaDatos2.get(aux).getEsSolucionStandAlone());
				dato3.setNroInterfacesOtrasApp(listaDatos2.get(aux).getNroInterfacesOtrasApp());
				
				dato3.setNombresInterfaces(listaDatos2.get(aux).getNombresInterfaces());
				dato3.setDescripcionMantenimientoAplicacion(listaDatos2.get(aux).getDescripcionMantenimientoAplicacion());
				dato3.setMantenimientoNombreProveedor(listaDatos2.get(aux).getMantenimientoNombreProveedor());
				dato3.setDescripcionSoporteAplicacion(listaDatos2.get(aux).getDescripcionSoporteAplicacion());
				dato3.setSoporteNombrePorveedor(listaDatos2.get(aux).getSoporteNombrePorveedor());
				dato3.setDescripcionAccesosAplicacion(listaDatos2.get(aux).getDescripcionAccesosAplicacion());
				dato3.setAccesosNombreProveedor(listaDatos2.get(aux).getAccesosNombreProveedor());

				//////
				dato3.setNombreServidor(listaDatos2.get(aux).getNombreServidor());
				dato3.setUbicacionServidor(listaDatos2.get(aux).getUbicacionServidor());
				dato3.setFrontUserLiderUsuario(listaDatos2.get(aux).getFrontUserLiderUsuario());
				dato3.setGestorAplicaciones(listaDatos2.get(aux).getGestorAplicaciones());
				dato3.setEspecialistaAplicaciones(listaDatos2.get(aux).getEspecialistaAplicaciones());

				dato3.setBrokerSistemas(listaDatos2.get(aux).getBrokerSistemas());
				dato3.setBrokerNegocios(listaDatos2.get(aux).getBrokerNegocios());
				dato3.setAsesorGUTI(listaDatos2.get(aux).getAsesorGUTI());
				dato3.setArquitectoDominio(listaDatos2.get(aux).getArquitectoDominio());
				dato3.setDescripcionEntidadesUsuarias(listaDatos2.get(aux).getDescripcionEntidadesUsuarias());
				
				dato3.setDescripcionDominio(listaDatos2.get(aux).getDescripcionDominio());
				dato3.setDescripcionSubDominio(listaDatos2.get(aux).getDescripcionSubDominio());
				dato3.setNroUnidadesUtilizanAplicacion(listaDatos2.get(aux).getNroUnidadesUtilizanAplicacion());
				dato3.setNombreUnidad1(listaDatos2.get(aux).getNombreUnidad1());
				dato3.setNombreUnidad2(listaDatos2.get(aux).getNombreUnidad2());
				
				dato3.setNombreUnidad3(listaDatos2.get(aux).getNombreUnidad3());
				dato3.setDescripcionCantidadUsuariosAplicacionTotal(listaDatos2.get(aux).getDescripcionCantidadUsuariosAplicacionTotal());
				dato3.setDescripcionProcesoAuditoria(listaDatos2.get(aux).getDescripcionProcesoAuditoria());
				dato3.setProcesoAuditoriaOtros(listaDatos2.get(aux).getProcesoAuditoriaOtros());
				dato3.setImpactaProcesoClave(listaDatos2.get(aux).getImpactaProcesoClave());

				dato3.setDescripcionProcesoClave(listaDatos2.get(aux).getDescripcionProcesoClave());
				dato3.setNombreProcesoClaveOtros(listaDatos2.get(aux).getNombreProcesoClaveOtros());
				dato3.setDescripcionActividad(listaDatos2.get(aux).getDescripcionActividad());
				dato3.setRelacionCIF(listaDatos2.get(aux).getRelacionCIF());
				dato3.setDescripcionConfidencialidad(listaDatos2.get(aux).getDescripcionConfidencialidad());
				
				dato3.setDescripcionIntegridad(listaDatos2.get(aux).getDescripcionIntegridad());
				dato3.setDescripcionDisponibilidad(listaDatos2.get(aux).getDescripcionDisponibilidad());
				dato3.setDescripcionPrivacidad(listaDatos2.get(aux).getDescripcionPrivacidad());
				dato3.setClasificacionActivosObservacion(listaDatos2.get(aux).getClasificacionActivosObservacion());
				dato3.setDescripcionCriticidadFinal(listaDatos2.get(aux).getDescripcionCriticidadFinal());
				
				dato3.setDescripcionEstadoRevisionAplicacion(listaDatos2.get(aux).getDescripcionEstadoRevisionAplicacion());
				dato3.setDescripcionSwBaseEstandarSistemaOperativo(listaDatos2.get(aux).getDescripcionSwBaseEstandarSistemaOperativo());
				dato3.setSwBaseSistemaOperativoOtros(listaDatos2.get(aux).getSwBaseSistemaOperativoOtros());
				dato3.setDescripcionSwBaseEstandarHerramientaProgramacion(listaDatos2.get(aux).getDescripcionSwBaseEstandarHerramientaProgramacion());
				dato3.setSwBaseHerramientaProgramacionOtros(listaDatos2.get(aux).getSwBaseHerramientaProgramacionOtros());
				
				dato3.setDescripcionSwBaseEstandarLenguajeProgramacion(listaDatos2.get(aux).getDescripcionSwBaseEstandarLenguajeProgramacion());
				dato3.setSwBaseLenguajeProgramacionOtros(listaDatos2.get(aux).getSwBaseLenguajeProgramacionOtros());
				dato3.setDecripcionSwBaseEstandarGestorBD(listaDatos2.get(aux).getDecripcionSwBaseEstandarGestorBD());
				dato3.setSwBaseGestorBDOtros(listaDatos2.get(aux).getSwBaseGestorBDOtros());
				dato3.setDescripcionSwBaseEstandarFramework(listaDatos2.get(aux).getDescripcionSwBaseEstandarFramework());
				
				dato3.setSwBaseFrameworkOtros(listaDatos2.get(aux).getSwBaseFrameworkOtros());
				dato3.setSwBaseObservacionesAdicionales(listaDatos2.get(aux).getSwBaseObservacionesAdicionales());
				dato3.setCompatibleWindows7(listaDatos2.get(aux).getCompatibleWindows7());
				dato3.setCompatibleIExplorer8(listaDatos2.get(aux).getCompatibleIExplorer8());
				dato3.setCompatiblePTerminal(listaDatos2.get(aux).getCompatiblePTerminal());
				
				dato3.setSegurinetActiveDirectory(listaDatos2.get(aux).getSegurinetActiveDirectory());
				
				// Consulta
		
				dato3.setDescripcionAccesosGestionPrivilegiosSistemas(listaDatos2.get(aux).getDescripcionAccesosGestionPrivilegiosSistemas());
				
				
				dato3.setDescripcionAccesosRevisionPrivilegiosUsuarios(listaDatos2.get(aux).getDescripcionAccesosRevisionPrivilegiosUsuarios());
				dato3.setDescripcionAccesosGestionContrasenas(listaDatos2.get(aux).getDescripcionAccesosGestionContrasenas());
				dato3.setDescripcionAccesosPoliticaContrasenas(listaDatos2.get(aux).getDescripcionAccesosPoliticaContrasenas());
				dato3.setDescripcionAccesosGestionClaves1(listaDatos2.get(aux).getDescripcionAccesosGestionClaves1());
				
				dato3.setDescripcionAccesosGestionClaves2(listaDatos2.get(aux).getDescripcionAccesosGestionClaves2());
				dato3.setDescripcionAccesosGestionClaves3(listaDatos2.get(aux).getDescripcionAccesosGestionClaves3());
				dato3.setDescripcionAuditoriaRegistroAuditoria(listaDatos2.get(aux).getDescripcionAuditoriaRegistroAuditoria());
				dato3.setDescripcionAuditoriaProteccionRegistrosAuditoria(listaDatos2.get(aux).getDescripcionAuditoriaProteccionRegistrosAuditoria());
				dato3.setDescripcionAuditoriaRegistroEventosAdministradores(listaDatos2.get(aux).getDescripcionAuditoriaRegistroEventosAdministradores());
				
				dato3.setDescripcionAuditoriaConformidadPoliticas(listaDatos2.get(aux).getDescripcionAuditoriaConformidadPoliticas());
				dato3.setDescripcionContingencia(listaDatos2.get(aux).getDescripcionContingencia());
				dato3.setDescripcionControlCambiosProcedimientosSw(listaDatos2.get(aux).getDescripcionControlCambiosProcedimientosSw());
				dato3.setDescripcionControlCambiosProcedimientoInfraestructura(listaDatos2.get(aux).getDescripcionControlCambiosProcedimientoInfraestructura());
				dato3.setDescripcionDocumentacionManejo(listaDatos2.get(aux).getDescripcionDocumentacionManejo());
				///
				
				dato3.setDescripcionIncidentesCumplimientoPoliticasAntivirus(listaDatos2.get(aux).getDescripcionIncidentesCumplimientoPoliticasAntivirus());
				dato3.setDescripcionIncidentesCumplimientoGestionParches(listaDatos2.get(aux).getDescripcionIncidentesCumplimientoGestionParches());
				dato3.setDescripcionIncidentesCumplimientoCodigoMalicioso(listaDatos2.get(aux).getDescripcionIncidentesCumplimientoCodigoMalicioso());
				dato3.setDescripcionIntegridadConfidencialidadDatosPrueba(listaDatos2.get(aux).getDescripcionIntegridadConfidencialidadDatosPrueba());
				dato3.setDescripcionRespaldosGestionRespaldoRecuperacion(listaDatos2.get(aux).getDescripcionRespaldosGestionRespaldoRecuperacion());
				
				dato3.setNivelCumplimientoEstandaresTecnologico(listaDatos2.get(aux).getNivelCumplimientoEstandaresTecnologico());
				dato3.setNivelCumplimientoEstandaresPorcentaje(listaDatos2.get(aux).getNivelCumplimientoEstandaresPorcentaje());
				dato3.setNivelCumplimientoLineamientos(listaDatos2.get(aux).getNivelCumplimientoLineamientos());
				dato3.setNivelCumplimientoLineamientosPorcentaje(listaDatos2.get(aux).getNivelCumplimientoLineamientosPorcentaje());
				dato3.setNivelCumplimientoTotal(listaDatos2.get(aux).getNivelCumplimientoTotal());
				dato3.setRoadmapCortoPlazo(listaDatos2.get(aux).getRoadmapCortoPlazo());
				
				dato3.setRoadmapLargoPlazo(listaDatos2.get(aux).getRoadmapLargoPlazo());
				dato3.setFechaInicioPlanificado(listaDatos2.get(aux).getFechaInicioPlanificado());
				dato3.setFechaCompromiso(listaDatos2.get(aux).getFechaCompromiso());
				dato3.setRoadmapEjecutadoActual(listaDatos2.get(aux).getRoadmapEjecutadoActual());
				dato3.setTrackAtencion(listaDatos2.get(aux).getTrackAtencion());
				
				dato3.setDescripcionEstadoAtencionRoadmap(listaDatos2.get(aux).getDescripcionEstadoAtencionRoadmap());
				dato3.setDescripcionEtapaAtencionRoadmap(listaDatos2.get(aux).getDescripcionEtapaAtencionRoadmap());
				dato3.setDescripcionPostSwBaseEstandarSistemaOperativo(listaDatos2.get(aux).getDescripcionPostSwBaseEstandarSistemaOperativo());
				dato3.setPostSwBaseSistemaOperativoOtros(listaDatos2.get(aux).getPostSwBaseSistemaOperativoOtros());
				dato3.setDecripcionPostSwBaseEstandarHerramientaProgramación(listaDatos2.get(aux).getDecripcionPostSwBaseEstandarHerramientaProgramación());
				
				dato3.setPostSwBaseHerramientaProgramacionOtros(listaDatos2.get(aux).getPostSwBaseHerramientaProgramacionOtros());
				dato3.setDescripcionPostSwBaseEstandarLenguajeProgramacion(listaDatos2.get(aux).getDescripcionPostSwBaseEstandarLenguajeProgramacion());
				dato3.setPostSwBaseLenguajeProgramacionOtros(listaDatos2.get(aux).getPostSwBaseLenguajeProgramacionOtros());
				dato3.setDescripcionPostSwBaseEstandarGestorBD(listaDatos2.get(aux).getDescripcionPostSwBaseEstandarGestorBD());
				dato3.setPostSwBaseGestorBDOtros(listaDatos2.get(aux).getPostSwBaseGestorBDOtros());
				
				dato3.setDescripcionPostSwBaseEstandarFramework(listaDatos2.get(aux).getDescripcionPostSwBaseEstandarFramework());
				dato3.setPostSwBaseFrameworkOtros(listaDatos2.get(aux).getPostSwBaseFrameworkOtros());
				dato3.setPostSwBaseObservacionesAdicionales(listaDatos2.get(aux).getPostSwBaseObservacionesAdicionales());
				
				///
				dato3.setPostDescripcionAccesosGestionPrivilegiosSistemas(rs3.getString(1));
				dato3.setPostDescripcionAccesosRevisionPrivileggiosUsuarios(rs3.getString(2));
				dato3.setPostDescripcionAccesosGestionContrasenas(rs3.getString(3));
				dato3.setPostDescripcionAccesosPoliticaContrasenas(rs3.getString(4));
				dato3.setPostDescripcionAccesosGestionClaves1(rs3.getString(5));
				
				dato3.setPostDescripcionAccesosGestionClaves2(rs3.getString(6));
				dato3.setPostDescripcionAccesosGestionClaves3(rs3.getString(7));
				dato3.setPostDescripcionAuditoriaRegistroAuditoria(rs3.getString(8));
				dato3.setPostDescripcionAuditoriaProteccionRegistrosAuditoria(rs3.getString(9));
				dato3.setPostDescripcionAuditoriaRegistroEventosAdministradores(rs3.getString(10));
				
				dato3.setPostDescripcionAuditoriaConformidadPolitias(rs3.getString(11));
				dato3.setPostDescripcionContingencia(rs3.getString(12));
				dato3.setPostDescripcionControlCambiosProcedimientosSw(rs3.getString(13));
				dato3.setPostDescripcionControlCambiosProcedimientosInfraestructura(rs3.getString(14));
				dato3.setPostDescripcionDocumentacionManejo(rs3.getString(15));
				///
				
				dato3.setPostDescripcionIncidentesCumplimientoPoliticaAntivirus(rs3.getString(16));
				dato3.setPostDescripcionIncidentesCumplimientoGestionParches(rs3.getString(17));
				dato3.setPostDescripcionIncidentesCumplimientodCodigoMalicioso(rs3.getString(18));
				dato3.setPostDescripcionIntegridadConfidencialidadDatosPrueba(rs3.getString(19));
				dato3.setPostDescripcionRespaldosGestionRespaldoRecuperacion(rs3.getString(20));
				
				dato3.setPostNivelCumplimientoEstandaresTecnologico(rs3.getString(21));
				dato3.setPostNivelCumplimientoEstandaresPorcentaje(rs3.getString(22));
				dato3.setPostNivelCumplimientoLineamientos(rs3.getString(23));
				dato3.setPostNivelCumplimientoLineamientosPorcentaje(rs3.getString(24));
				dato3.setPostNivelCumplimientoTotal(rs3.getString(25));
				dato3.setNombre_datamart(rs3.getString(26));
				
				dato3.setFrecuencia(rs3.getString(27));
				dato3.setCantidadTablas(rs3.getString(28));
				dato3.setCantidadTablasDescriptivas(rs3.getString(29));
				dato3.setCantidadTablasHechos(rs3.getString(30));
				dato3.setDescripcionHerramientaExplotacionDatos(rs3.getString(31));
				
				dato3.setHerramientaExplotacionDatosOtros(rs3.getString(32));
				dato3.setCantidadReportes(rs3.getString(33));
				dato3.setCantidadUsuarios(rs3.getString(34));
				dato3.setCantidadEspacioTablespace(rs3.getString(35));
				dato3.setEvaluacionSeguridadInformacion(rs3.getString(36));
				
				dato3.setSeguridadNivelExposicion(rs3.getString(37));
				
				
			

			
				listaDatosFinal.add(dato3);
				aux=aux+1;
			}
			
			cnn1.close();
			cs1.close();
			
			
		} catch (SQLException e) {
			throw e;
		}
		return listaDatosFinal;
	}
	
	

}
