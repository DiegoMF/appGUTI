
package com.bcp.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.dao.AccesosAplicacionDAO;
import com.bcp.dao.AccesosGestionClaves1DAO;
import com.bcp.dao.AccesosGestionClaves2DAO;
import com.bcp.dao.AccesosGestionClaves3DAO;
import com.bcp.dao.AccesosGestionContrasenasDAO;
import com.bcp.dao.AccesosGestionPrivilegiosSistemasDAO;
import com.bcp.dao.AccesosPoliticaContrasenasDAO;
import com.bcp.dao.AccesosRevisionPrivilegiosUsuariosDAO;
import com.bcp.dao.AmbienteAppNoITDAO;
import com.bcp.dao.AplicacionEspecializadaDAO;
import com.bcp.dao.AppEspImpactoDAO;
import com.bcp.dao.AppEspNivelCumplimientoDAO;
import com.bcp.dao.AppEspNivelCumplimientoLineamientosDAO;
import com.bcp.dao.AppEspNivelesCumplimientoEstandaresDAO;
import com.bcp.dao.ConsultaAplicacionEspecializadaDAO;
import com.bcp.dao.AppEspCaracteristicasParticularesDAO;
import com.bcp.dao.AppEspCaracteristicasTecnicasDAO;
import com.bcp.dao.AppEspClasificacionActivosDAO;
import com.bcp.dao.AppEspDatamartDAO;
import com.bcp.dao.AppEspDominioDAO;
import com.bcp.dao.AppEspEstructuraOrganizacionalDAO;
import com.bcp.dao.AppEspFuenteOrigenDAO;
import com.bcp.dao.AppEspFuncionalidadDAO;
import com.bcp.dao.AppEspInformacionGeneralDAO;
import com.bcp.dao.AppEspInformacionPlanRoadmapDAO;
import com.bcp.dao.AppEspLineamientosDAO;
import com.bcp.dao.AppEspPostAtencionLineamientosDAO;
import com.bcp.dao.AppEspPostAtencionSwBaseEstandarTecnologicoDAO;
import com.bcp.dao.AppEspSeguridadInformacionDAO;
import com.bcp.dao.AppEspSwBaseEstandarTecnologicoDAO;
import com.bcp.dao.AreaDAO;
import com.bcp.dao.AuditoriaConformidadPoliticasDAO;
import com.bcp.dao.AuditoriaProteccionRegistrosAuditoriaDAO;
import com.bcp.dao.AuditoriaRegistroAuditoriaDAO;
import com.bcp.dao.AuditoriaRegistroEventosAdministradoresDAO;
import com.bcp.dao.BitacoraActualizacionesDAO;
import com.bcp.dao.CampoInventarioDAO;
import com.bcp.dao.CantidadOperacionesDAO;
import com.bcp.dao.CantidadUsuariosAplicacionTotalDAO;
import com.bcp.dao.CategoriaTecnologicaDAO;
import com.bcp.dao.ClasificacionDAO;
import com.bcp.dao.ConfidencialidadDAO;
import com.bcp.dao.ContingenciaDAO;
import com.bcp.dao.ControlCambiosProcedimientosInfraestructuraDAO;
import com.bcp.dao.ControlCambiosProcedimientosSwDAO;
import com.bcp.dao.CriticidadFinalDAO;
import com.bcp.dao.DisponibilidadDAO;
import com.bcp.dao.DivisionDAO;
import com.bcp.dao.DocumentacionManejoDAO;
import com.bcp.dao.DominioDAO;
import com.bcp.dao.EntidadesUsuariasDAO;
import com.bcp.dao.EscenarioLogueoDAO;
import com.bcp.dao.EstadoAplicacionDAO;
import com.bcp.dao.EstadoAtencionRoadmapDAO;
import com.bcp.dao.FrecuenciaOperacionesDAO;
import com.bcp.dao.FuentePeriodoDAO;
import com.bcp.dao.GerenciaCentralDAO;
import com.bcp.dao.GrupoInventarioDAO;
import com.bcp.dao.HerramientaExplotacionDatosDAO;
import com.bcp.dao.ImpactoProteccionDatosDAO;
import com.bcp.dao.ImpactoProteccionDatosLevantamientoInformacionDAO;
import com.bcp.dao.IncidentesCumplimientoCodigoMaliciosoDAO;
import com.bcp.dao.IncidentesCumplimientoGestionParchesDAO;
import com.bcp.dao.IncidentesCumplimientoPoliticasAntivirusDAO;
import com.bcp.dao.InfraestructuraAplicacionDAO;
import com.bcp.dao.IntegridadConfidencialidadDatosPruebaDAO;
import com.bcp.dao.IntegridadDAO;
import com.bcp.dao.MantenimientoAplicacionDAO;
import com.bcp.dao.MotivoCreacionAplicacion;
import com.bcp.dao.MotivoCreacionAplicacionDAO;
import com.bcp.dao.PrivacidadDAO;
import com.bcp.dao.ProcesoAuditoriaDAO;
import com.bcp.dao.ProcesoClaveDAO;
import com.bcp.dao.RespaldosGestionRespaldoRecuperacionDAO;
import com.bcp.dao.SoporteAplicacionDAO;
import com.bcp.dao.SwBaseEstandarFrameworkDAO;
import com.bcp.dao.SwBaseEstandarGestorBDDAO;
import com.bcp.dao.SwBaseEstandarHerramientaProgramacionDAO;
import com.bcp.dao.SwBaseEstandarLenguajeProgramacionDAO;
import com.bcp.dao.SwBaseEstandarSistemaOperativoDAO;
import com.bcp.dao.TipoDesarrolloDAO;
import com.bcp.dao.TipoOperacionProcesoDAO;
import com.bcp.dao.UbicacionFisicaDAO;
import com.bcp.dao.UnidadDAO;
import com.bcp.dao.usuarioDAO;
import com.bcp.dao.SubDominioDAO;
import com.bcp.dao.ActividadDAO;
import com.bcp.dao.EstadoRevisionAplicacionDAO;
import com.bcp.modelo.AppEspNivelCumplimiento;
import com.bcp.modelo.AppEspNivelCumplimientoLineamientos;
import com.bcp.modelo.AppEspNivelesCumplimientoEstandares;
import com.bcp.modelo.LogAuditoria;
import com.bcp.modelo.usuario;
import com.bcp.modelo.AccesosAplicacion;
import com.bcp.modelo.AccesosGestionClaves1;
import com.bcp.modelo.AccesosGestionClaves2;
import com.bcp.modelo.AccesosGestionClaves3;
import com.bcp.modelo.AccesosGestionContrasenas;
import com.bcp.modelo.AccesosGestionPrivilegiosSistemas;
import com.bcp.modelo.AccesosPoliticaContrasenas;
import com.bcp.modelo.AccesosRevisionPrivilegiosUsuarios;
import com.bcp.modelo.AmbienteAppNoIT;
import com.bcp.modelo.AplicacionEspecializada;
import com.bcp.modelo.AppEspCaracteristicasParticulares;
import com.bcp.modelo.AppEspCaracteristicasTecnicas;
import com.bcp.modelo.AppEspClasificacionActivos;
import com.bcp.modelo.AppEspDatamart;
import com.bcp.modelo.AppEspDominio;
import com.bcp.modelo.AppEspEstructuraOrganizacional;
import com.bcp.modelo.AppEspFuenteOrigen;
import com.bcp.modelo.AppEspFuncionalidad;
import com.bcp.modelo.AppEspImpacto;
import com.bcp.modelo.AppEspInformacionGeneral;
import com.bcp.modelo.AppEspInformacionPlanRoadmap;
import com.bcp.modelo.AppEspLineamientos;
import com.bcp.modelo.AppEspPostAtencionLineamientos;
import com.bcp.modelo.AppEspPostAtencionSwBaseEstandarTecnologico;
import com.bcp.modelo.AppEspSeguridadInformacion;
import com.bcp.modelo.AppEspSwBaseEstandarTecnologico;
import com.bcp.modelo.Area;
import com.bcp.modelo.AuditoriaConformidadPoliticas;
import com.bcp.modelo.AuditoriaProteccionRegistrosAuditoria;
import com.bcp.modelo.AuditoriaRegistroAuditoria;
import com.bcp.modelo.AuditoriaRegistroEventosAdministradores;
import com.bcp.modelo.BitacoraActualizaciones;
import com.bcp.modelo.CampoInventario;
import com.bcp.modelo.CantidadOperaciones;
import com.bcp.modelo.CantidadUsuariosAplicacionTotal;
import com.bcp.modelo.CategoriaTecnologica;
import com.bcp.modelo.Clasificacion;
import com.bcp.modelo.Confidencialidad;
import com.bcp.modelo.Contingencia;
import com.bcp.modelo.ControlCambiosProcedimientosInfraestructura;
import com.bcp.modelo.ControlCambiosProcedimientosSw;
import com.bcp.modelo.CriticidadFinal;
import com.bcp.modelo.Disponibilidad;
import com.bcp.modelo.Division;
import com.bcp.modelo.DocumentacionManejo;
import com.bcp.modelo.Dominio;
import com.bcp.modelo.EntidadesUsuarias;
import com.bcp.modelo.EscenarioLogueo;
import com.bcp.modelo.EstadoAplicacion;
import com.bcp.modelo.EstadoAtencionRoadmap;
import com.bcp.modelo.FrecuenciaOperaciones;
import com.bcp.modelo.FuentePeriodo;
import com.bcp.modelo.GerenciaCentral;
import com.bcp.modelo.GrupoInventario;
import com.bcp.modelo.HerramientaExplotacionDatos;
import com.bcp.modelo.ImpactoProteccionDatos;
import com.bcp.modelo.ImpactoProteccionDatosLevantamientoInformacion;
import com.bcp.modelo.IncidentesCumplimientoCodigoMalicioso;
import com.bcp.modelo.IncidentesCumplimientoGestionParches;
import com.bcp.modelo.IncidentesCumplimientoPoliticasAntivirus;
import com.bcp.modelo.InfraestructuraAplicacion;
import com.bcp.modelo.Integridad;
import com.bcp.modelo.IntegridadConfidencialidadDatosPrueba;
import com.bcp.modelo.MantenimientoAplicacion;
import com.bcp.modelo.Privacidad;
import com.bcp.modelo.ProcesoAuditoria;
import com.bcp.modelo.ProcesoClave;
import com.bcp.modelo.RespaldosGestionRespaldoRecuperacion;
import com.bcp.modelo.SoporteAplicacion;
import com.bcp.modelo.SwBaseEstandarFramework;
import com.bcp.modelo.SwBaseEstandarGestorBD;
import com.bcp.modelo.SwBaseEstandarHerramientaProgramacion;
import com.bcp.modelo.SwBaseEstandarLenguajeProgramacion;
import com.bcp.modelo.SwBaseEstandarSistemaOperativo;
import com.bcp.modelo.TipoDesarrollo;
import com.bcp.modelo.TipoOperacionProceso;
import com.bcp.modelo.UbicacionFisica;
import com.bcp.modelo.Unidad;
import com.bcp.modelo.SubDominio;
import com.bcp.modelo.Actividad;
import com.bcp.modelo.EstadoRevisionAplicacion;
import com.bcp.modelo.dto.AplicacionEspecializadaDTO;
import com.bcp.modelo.dto.ConsultaGeneralAplicacionesDTO;

@Controller
@RequestMapping("/aplicacionEspecializada")
public class AplicacionesEspecializadasController {

	String message;

	// Nuevo

	AppEspImpacto impacto = new AppEspImpacto();
	ArrayList<CriticidadFinal> criticidadfinal;
	ArrayList<ProcesoClave> impactoProcesoClave;
	ArrayList<Actividad> impactoActividad;
	ArrayList<Actividad> dominioActividad;

	//

	ArrayList<SubDominio> subdominio;
	ArrayList<Actividad> actividad;
	ArrayList<EstadoRevisionAplicacion> estadoRevision;

	ArrayList<Clasificacion> fclasificacion;
	ArrayList<EstadoAplicacion> festado;
	ArrayList<EstadoAtencionRoadmap> festadoatencion;
	ArrayList<CriticidadFinal> fcriticidadfinal;

	ArrayList<AplicacionEspecializada> historicoAplicaciones = new ArrayList<>();

	ArrayList<ConsultaGeneralAplicacionesDTO> listaAplicaciones = new ArrayList<>();
	ArrayList<EstadoAtencionRoadmap> generalEstadoAR = new ArrayList<>();

	// **** Pestaña Información General ****

	// Sección Estructura Organizacional
	AppEspEstructuraOrganizacional lista = new AppEspEstructuraOrganizacional();
	ArrayList<GerenciaCentral> gerencia;
	ArrayList<Unidad> unidad;
	ArrayList<Division> division;
	ArrayList<Area> area;

	ArrayList<usuario> listausuario = new ArrayList<>();
	usuario userID = new usuario();

	public final usuario getUser() {
		return userID;
	}

	public final void setUser(usuario user) {
		this.userID = user;
	}

	// Sección Información General
	// ArrayList<AppEspInformacionGeneral> listaInfo = new ArrayList<>();
	AppEspInformacionGeneral listaInfo = new AppEspInformacionGeneral();
	ArrayList<EstadoAplicacion> estadoAplicacion;
	ArrayList<CantidadOperaciones> cantidadOperaciones;
	ArrayList<TipoOperacionProceso> tipoOperacionProceso;
	ArrayList<FrecuenciaOperaciones> frecuenciaOperaciones;
	ArrayList<MotivoCreacionAplicacion> motivoCreacionAplicacion;

	// Sección Funcionalidad
	AppEspFuncionalidad funcionalidad = new AppEspFuncionalidad();

	// Sección Dominio
	AppEspDominio dominio = new AppEspDominio();
	ArrayList<Dominio> cdominio;
	ArrayList<EntidadesUsuarias> entidadesUsuarias;
	ArrayList<ProcesoAuditoria> procesoAuditoria;
	ArrayList<ProcesoClave> procesoClave;
	ArrayList<CantidadUsuariosAplicacionTotal> cuap;

	// Clasificación de Activos
	AppEspClasificacionActivos clasifActivos = new AppEspClasificacionActivos();
	ArrayList<Confidencialidad> confidencialidad;
	ArrayList<Integridad> integridad;
	ArrayList<Disponibilidad> disponibilidad;
	ArrayList<Privacidad> privacidad;
	ArrayList<Clasificacion> clasificacion;

	// **** Pestaña Información Técnica e Impacto ****

	// Sección Características Técnicas
	// ArrayList<AppEspCaracteristicasTecnicas> listaCaracteristicas = new
	// ArrayList<>();
	AppEspCaracteristicasTecnicas listaCaracteristicas = new AppEspCaracteristicasTecnicas();
	ArrayList<CategoriaTecnologica> categoriaTecnologica;
	ArrayList<TipoDesarrollo> tipoDesarrollo;
	ArrayList<UbicacionFisica> ubicacionFisica;
	ArrayList<AmbienteAppNoIT> ambiente;
	ArrayList<InfraestructuraAplicacion> infraestructuraAplicacion;
	ArrayList<MantenimientoAplicacion> mantenimientoAplicacion;
	ArrayList<SoporteAplicacion> soporteAplicacion;
	ArrayList<AccesosAplicacion> accesosAplicacion;

	// Sección Datamart
	AppEspDatamart listaDatamart = new AppEspDatamart();
	ArrayList<HerramientaExplotacionDatos> herramienta;
	
	
	//Sección Impacto
	ArrayList<ProcesoAuditoria> procesoAuditoriaI;
	ArrayList<ProcesoClave> procesoClaveI;
	
	// **** Pestaña Información de Roadmap ****
	AppEspInformacionPlanRoadmap listaInformacionPlanRoadmap = new AppEspInformacionPlanRoadmap();
	ArrayList<EstadoAtencionRoadmap> estadoAtencionRoadmap;

	// *** Pestaña Información Pre Atención
	// pre Atencion - Sw Base
	AppEspSwBaseEstandarTecnologico preswBaseEstandarTecnologico = new AppEspSwBaseEstandarTecnologico();
	ArrayList<SwBaseEstandarSistemaOperativo> presistemaOperativo;
	ArrayList<SwBaseEstandarGestorBD> pregestorBD;
	ArrayList<SwBaseEstandarHerramientaProgramacion> preherramientaProgramacion;
	ArrayList<SwBaseEstandarLenguajeProgramacion> prelenguajeProgramacion;
	ArrayList<SwBaseEstandarFramework> preframework;

	// Pre Atención Lineamiento
	AppEspLineamientos preLineamientos = new AppEspLineamientos();
	ArrayList<AccesosGestionPrivilegiosSistemas> preagps;
	ArrayList<AccesosRevisionPrivilegiosUsuarios> prearpu;
	ArrayList<AccesosGestionContrasenas> preagc;
	ArrayList<AccesosPoliticaContrasenas> preapc;
	ArrayList<AccesosGestionClaves1> preagc1;
	ArrayList<AccesosGestionClaves2> preagc2;
	ArrayList<AccesosGestionClaves3> preagc3;

	ArrayList<AuditoriaRegistroAuditoria> preregistroAuditoria;
	ArrayList<AuditoriaRegistroEventosAdministradores> preregistroEventos;
	ArrayList<AuditoriaProteccionRegistrosAuditoria> preproteccionRegistros;
	ArrayList<AuditoriaConformidadPoliticas> preconformidadPoliticas;
	ArrayList<Contingencia> precontingencia;
	ArrayList<ControlCambiosProcedimientosInfraestructura> preprocedimientoInfraestructura;
	ArrayList<ControlCambiosProcedimientosSw> preprocedimientosSw;
	ArrayList<DocumentacionManejo> predocumentacionManejo;
	ArrayList<IncidentesCumplimientoCodigoMalicioso> precumplimientoCodigoMalicioso;
	ArrayList<IncidentesCumplimientoGestionParches> pregestionParches;
	ArrayList<IncidentesCumplimientoPoliticasAntivirus> prepoliticasAntivirus;
	ArrayList<IntegridadConfidencialidadDatosPrueba> predatosPrueba;
	ArrayList<RespaldosGestionRespaldoRecuperacion> prerespaldoRecuperacion;

	// *** Pestaña Información Post Atención
	// Post Atencion - Sw Base
	AppEspPostAtencionSwBaseEstandarTecnologico swBaseEstandarTecnologico = new AppEspPostAtencionSwBaseEstandarTecnologico();
	ArrayList<SwBaseEstandarSistemaOperativo> sistemaOperativo;
	ArrayList<SwBaseEstandarGestorBD> gestorBD;
	ArrayList<SwBaseEstandarHerramientaProgramacion> herramientaProgramacion;
	ArrayList<SwBaseEstandarLenguajeProgramacion> lenguajeProgramacion;
	ArrayList<SwBaseEstandarFramework> framework;

	// Post Atención Lineamiento
	AppEspPostAtencionLineamientos postLineamientos = new AppEspPostAtencionLineamientos();
	ArrayList<AccesosGestionPrivilegiosSistemas> agps;
	ArrayList<AccesosRevisionPrivilegiosUsuarios> arpu;
	ArrayList<AccesosGestionContrasenas> agc;
	ArrayList<AccesosPoliticaContrasenas> apc;
	ArrayList<AccesosGestionClaves1> agc1;
	ArrayList<AccesosGestionClaves2> agc2;
	ArrayList<AccesosGestionClaves3> agc3;

	ArrayList<AuditoriaRegistroAuditoria> registroAuditoria;
	ArrayList<AuditoriaRegistroEventosAdministradores> registroEventos;
	ArrayList<AuditoriaProteccionRegistrosAuditoria> proteccionRegistros;
	ArrayList<AuditoriaConformidadPoliticas> conformidadPoliticas;
	ArrayList<Contingencia> contingencia;
	ArrayList<ControlCambiosProcedimientosInfraestructura> procedimientoInfraestructura;
	ArrayList<ControlCambiosProcedimientosSw> procedimientosSw;
	ArrayList<DocumentacionManejo> documentacionManejo;
	ArrayList<IncidentesCumplimientoCodigoMalicioso> cumplimientoCodigoMalicioso;
	ArrayList<IncidentesCumplimientoGestionParches> gestionParches;
	ArrayList<IncidentesCumplimientoPoliticasAntivirus> politicasAntivirus;
	ArrayList<IntegridadConfidencialidadDatosPrueba> datosPrueba;
	ArrayList<RespaldosGestionRespaldoRecuperacion> respaldoRecuperacion;

	// *** Pestaña Información Adicional
	AppEspSeguridadInformacion seguridadInformacion = new AppEspSeguridadInformacion();
	// Seccion Caracteristicas Particulares
	AppEspCaracteristicasParticulares caracteristicasParticulares = new AppEspCaracteristicasParticulares();
	ArrayList<EscenarioLogueo> escenarioLogueo;
	ArrayList<ImpactoProteccionDatos> impactoProteccion;
	ArrayList<ImpactoProteccionDatosLevantamientoInformacion> impactoLevantamiento;
	// Seccion Fuente Origen
	AppEspFuenteOrigen fuenteOrigen = new AppEspFuenteOrigen();
	ArrayList<FuentePeriodo> fuentePeriodo;
	// Sección Histórico
	BitacoraActualizaciones bitacoraActualizaciones = new BitacoraActualizaciones();
	ArrayList<CampoInventario> campoInventario;
	ArrayList<GrupoInventario> grupoInventario;
	
	AppEspNivelesCumplimientoEstandares nivelEstandar = new AppEspNivelesCumplimientoEstandares();
	AppEspNivelCumplimientoLineamientos nivelLineamiento = new AppEspNivelCumplimientoLineamientos();
	
	AppEspNivelCumplimiento nivelCumplimiento = new AppEspNivelCumplimiento();
	AppEspNivelCumplimiento nivelCumplimientoP = new AppEspNivelCumplimiento();

	public ArrayList<ConsultaGeneralAplicacionesDTO> getListausuario() {
		return listaAplicaciones;
	}

	public void setListausuario(
			ArrayList<ConsultaGeneralAplicacionesDTO> listaAplicaciones) {
		this.listaAplicaciones = listaAplicaciones;
	}

	@RequestMapping(value = { "/filtrosConsulta" }, method = RequestMethod.POST)
	public ModelAndView getFiltros(ModelMap mod) throws Exception {

		fclasificacion = new ArrayList<>();
		fclasificacion = ClasificacionDAO.getInstancia().obtenerClasificacion();

		festado = new ArrayList<>();
		festado = EstadoAplicacionDAO.getInstancia().obtenerEstadoAplicacion();

		festadoatencion = new ArrayList<>();
		festadoatencion = EstadoAtencionRoadmapDAO.getInstancia()
				.obtenerEstadoAtencionRoadmap();

		fcriticidadfinal = new ArrayList<>();
		fcriticidadfinal = CriticidadFinalDAO.getInstancia()
				.obtenerCriticidadFinal();

		ModelAndView model = new ModelAndView("consultaGeneral");
		model.addObject("fclasificacion", fclasificacion);
		model.addObject("festado", festado);
		model.addObject("festadoatencion", festadoatencion);
		model.addObject("fcriticidadfinal", fcriticidadfinal);

		return model;

	}

	@RequestMapping(value = { "/load" }, method = RequestMethod.GET)
	public ModelAndView load(ModelMap mod) throws Exception {

		ModelAndView model = new ModelAndView("insertarAplicacionesEspecializadas");

		// Estructura Organizacional
		gerencia = new ArrayList<>();
		gerencia = GerenciaCentralDAO.getInstancia().obtenerGerenciaCentral();
		unidad = new ArrayList<>();
		unidad = UnidadDAO.getInstancia().obtenerUnidad();
		division = new ArrayList<>();
		division = DivisionDAO.getInstancia().obtenerDivision();
		area = new ArrayList<>();
		area = AreaDAO.getInstancia().obtenerArea();

		model.addObject("gerencia", gerencia);
		model.addObject("unidad", unidad);
		model.addObject("division", division);
		model.addObject("area", area);

		// Información General
		estadoAplicacion = new ArrayList<>();
		estadoAplicacion = EstadoAplicacionDAO.getInstancia()
				.obtenerEstadoAplicacion();
		tipoOperacionProceso = new ArrayList<>();
		tipoOperacionProceso = TipoOperacionProcesoDAO.getInstancia()
				.obtenerTipoOperacionProceso();
		frecuenciaOperaciones = new ArrayList<>();
		frecuenciaOperaciones = FrecuenciaOperacionesDAO.getInstancia()
				.obtenerFrecuenciaOperaciones();
		cantidadOperaciones = new ArrayList<>();
		cantidadOperaciones = CantidadOperacionesDAO.getInstancia()
				.obtenerCantidadOperaciones();
		motivoCreacionAplicacion = new ArrayList<>();
		motivoCreacionAplicacion = MotivoCreacionAplicacionDAO.getInstancia()
				.obtenerMotivoCreacionAplicacion();

		model.addObject("estadoAplicacion", estadoAplicacion);
		model.addObject("tipoOperacionProceso", tipoOperacionProceso);
		model.addObject("frecuenciaOperaciones", frecuenciaOperaciones);
		model.addObject("cantidadOperaciones", cantidadOperaciones);
		model.addObject("motivoCreacionAplicacion", motivoCreacionAplicacion);

		// Dominio
		cdominio = new ArrayList<>();
		cdominio = DominioDAO.getInstancia().obtenerDominio();
		subdominio = new ArrayList<>();
		subdominio = SubDominioDAO.getInstancia().obtenerSubDominio();
		entidadesUsuarias = new ArrayList<>();
		entidadesUsuarias = EntidadesUsuariasDAO.getInstancia()
				.obtenerEntidadesUsuarias();
		cuap = new ArrayList<>();
		cuap = CantidadUsuariosAplicacionTotalDAO.getInstancia()
				.obtenerCantidad();
		procesoAuditoria = new ArrayList<>();
		procesoAuditoria = ProcesoAuditoriaDAO.getInstancia().obtenerProcesoAuditoria();
		procesoClave = new ArrayList<>();
		procesoClave = ProcesoClaveDAO.getInstancia().obtenerProcesoClave();
		dominioActividad = new ArrayList<>();
		dominioActividad = ActividadDAO.getInstancia().obtenerActividad();

		model.addObject("cdominio", cdominio);
		model.addObject("subdominio", subdominio);
		model.addObject("entidadesUsuarias", entidadesUsuarias);
		model.addObject("cuap", cuap);
		model.addObject("procesoAuditoria", procesoAuditoria);
		model.addObject("procesoClave", procesoClave);
		model.addObject("dominioActividad", dominioActividad);

		// Clasificación de activos
		confidencialidad = new ArrayList<>();
		confidencialidad = ConfidencialidadDAO.getInstancia()
				.obtenerConfidencialidad();
		integridad = new ArrayList<>();
		integridad = IntegridadDAO.getInstancia().obtenerIntegridad();
		disponibilidad = new ArrayList<>();
		disponibilidad = DisponibilidadDAO.getInstancia()
				.obtenerDisponibilidad();
		privacidad = new ArrayList<>();
		privacidad = PrivacidadDAO.getInstancia().obtenerPrivacidad();
		clasificacion = new ArrayList<>();
		clasificacion = ClasificacionDAO.getInstancia().obtenerClasificacion();
		criticidadfinal = new ArrayList<>();
		criticidadfinal = CriticidadFinalDAO.getInstancia()
				.obtenerCriticidadFinal();
		estadoRevision = new ArrayList<>();
		estadoRevision = EstadoRevisionAplicacionDAO.getInstancia()
				.obtenerEstadoRevisionAplicacion();

		model.addObject("confidencialidad", confidencialidad);
		model.addObject("integridad", integridad);
		model.addObject("disponibilidad", disponibilidad);
		model.addObject("privacidad", privacidad);
		model.addObject("clasificacion", clasificacion);
		model.addObject("criticidadfinal", criticidadfinal);
		model.addObject("estadoRevision", estadoRevision);

		// Cateoria Tecnologica
		categoriaTecnologica = new ArrayList<>();
		categoriaTecnologica = CategoriaTecnologicaDAO.getInstancia()
				.obtenerCategoriaTecnologica();
		tipoDesarrollo = new ArrayList<>();
		tipoDesarrollo = TipoDesarrolloDAO.getInstancia()
				.obtenerTipoDesarrollo();
		ubicacionFisica = new ArrayList<>();
		ubicacionFisica = UbicacionFisicaDAO.getInstancia()
				.obtenerUbicacionFisica();
		ambiente = new ArrayList<>();
		ambiente = AmbienteAppNoITDAO.getInstancia().obtenerAmbienteAppNoIT();
		infraestructuraAplicacion = new ArrayList<>();
		infraestructuraAplicacion = InfraestructuraAplicacionDAO.getInstancia()
				.obtenerInfraestructuraAplicacion();
		mantenimientoAplicacion = new ArrayList<>();
		mantenimientoAplicacion = MantenimientoAplicacionDAO.getInstancia()
				.obtenerMantenimientoAplicacion();
		soporteAplicacion = new ArrayList<>();
		soporteAplicacion = SoporteAplicacionDAO.getInstancia()
				.obtenerSoporteAplicacion();
		accesosAplicacion = new ArrayList<>();
		accesosAplicacion = AccesosAplicacionDAO.getInstancia()
				.obtenerAccesosAplicacion();

		model.addObject("categoriaTecnologica", categoriaTecnologica);
		model.addObject("tipoDesarrollo", tipoDesarrollo);
		model.addObject("ubicacionFisica", ubicacionFisica);
		model.addObject("ambiente", ambiente);
		model.addObject("infraestructuraAplicacion", infraestructuraAplicacion);
		model.addObject("mantenimientoAplicacion", mantenimientoAplicacion);
		model.addObject("soporteAplicacion", soporteAplicacion);
		model.addObject("accesosAplicacion", accesosAplicacion);

		// Datamart
		herramienta = new ArrayList<>();
		herramienta = HerramientaExplotacionDatosDAO.getInstancia()
				.obtenerHerramientaExplotacionDatos();

		model.addObject("herramienta", herramienta);

		// Impactos
		
		procesoAuditoriaI = new ArrayList<>();
		procesoAuditoriaI = ProcesoAuditoriaDAO.getInstancia().obtenerProcesoAuditoria();
		
		impactoProcesoClave = new ArrayList<>();
		impactoProcesoClave = ProcesoClaveDAO.getInstancia().obtenerProcesoClave();
		impactoActividad = new ArrayList<>();
		impactoActividad = ActividadDAO.getInstancia().obtenerActividad();
		model.addObject("procesoAuditoriaI", procesoAuditoriaI);
		model.addObject("impactoProcesoClave", impactoProcesoClave);
		model.addObject("impactoActividad", impactoActividad);

		// **** Pestaña Información Roadmap

		estadoAtencionRoadmap = new ArrayList<>();
		estadoAtencionRoadmap = EstadoAtencionRoadmapDAO.getInstancia()
				.obtenerEstadoAtencionRoadmap();

		model.addObject("estadoAtencionRoadmap", estadoAtencionRoadmap);

		// *** Pestaña Información Pre Atención
		// Pre Atención Software Base

		presistemaOperativo = new ArrayList<>();
		presistemaOperativo = SwBaseEstandarSistemaOperativoDAO.getInstancia()
				.obtenerSwBaseEstandar();
		pregestorBD = new ArrayList<>();
		pregestorBD = SwBaseEstandarGestorBDDAO.getInstancia()
				.obtenerSwBaseEstandarGestorBD();
		preherramientaProgramacion = new ArrayList<>();
		preherramientaProgramacion = SwBaseEstandarHerramientaProgramacionDAO
				.getInstancia().obtenerSwBaseHerramienta();
		prelenguajeProgramacion = new ArrayList<>();
		prelenguajeProgramacion = SwBaseEstandarLenguajeProgramacionDAO
				.getInstancia().obtenerSwBaseEstandarLenguaje();
		preframework = new ArrayList<>();
		preframework = SwBaseEstandarFrameworkDAO.getInstancia()
				.obtenerSwBaseEstandarFramework();

		model.addObject("presistemaOperativo", presistemaOperativo);
		model.addObject("pregestorBD", pregestorBD);
		model.addObject("preherramientaProgramacion",
				preherramientaProgramacion);
		model.addObject("prelenguajeProgramacion", prelenguajeProgramacion);
		model.addObject("preframework", preframework);

		// Pre atencion Lineamientos (obtención de ID)
		// listas desplegables - post atención lineamientos
		preagps = new ArrayList<>();
		preagps = AccesosGestionPrivilegiosSistemasDAO.getInstancia()
				.obtenerAccesosGestionPrivilegiosSistemas();
		prearpu = new ArrayList<>();
		prearpu = AccesosRevisionPrivilegiosUsuariosDAO.getInstancia()
				.obtenerAccesosRevisionPrivilegiosUsuarios();
		preagc = new ArrayList<>();
		preagc = AccesosGestionContrasenasDAO.getInstancia()
				.obtenerAccesosGestionContrasenas();
		preapc = new ArrayList<>();
		preapc = AccesosPoliticaContrasenasDAO.getInstancia()
				.obtenerAccesosPoliticasContrasenas();
		preagc1 = new ArrayList<>();
		preagc1 = AccesosGestionClaves1DAO.getInstancia()
				.obtenerAccesosGestionClaves1();
		preagc2 = new ArrayList<>();
		preagc2 = AccesosGestionClaves2DAO.getInstancia()
				.obtenerAccesosGestionClaves2();
		preagc3 = new ArrayList<>();
		preagc3 = AccesosGestionClaves3DAO.getInstancia()
				.obtenerAccesosGestionClaves3();

		preregistroAuditoria = new ArrayList<>();
		preregistroAuditoria = AuditoriaRegistroAuditoriaDAO.getInstancia()
				.obtenerRegistroAuditoria();
		preregistroEventos = new ArrayList<>();
		preregistroEventos = AuditoriaRegistroEventosAdministradoresDAO
				.getInstancia().obtenerRegistroEventos();
		preproteccionRegistros = new ArrayList<>();
		preproteccionRegistros = AuditoriaProteccionRegistrosAuditoriaDAO
				.getInstancia().obtenerProteccionRegistroAuditoria();
		preconformidadPoliticas = new ArrayList<>();
		preconformidadPoliticas = AuditoriaConformidadPoliticasDAO
				.getInstancia().obtenerAuditoriaConformidadPoliticas();
		precontingencia = new ArrayList<>();
		precontingencia = ContingenciaDAO.getInstancia().obtenerContingencia();
		preprocedimientoInfraestructura = new ArrayList<>();
		preprocedimientoInfraestructura = ControlCambiosProcedimientosInfraestructuraDAO
				.getInstancia()
				.obtenerControlCambiosProcedimientosInfraestructura();
		preprocedimientosSw = new ArrayList<>();
		preprocedimientosSw = ControlCambiosProcedimientosSwDAO.getInstancia()
				.obtenerControlCambios();
		predocumentacionManejo = new ArrayList<>();
		predocumentacionManejo = DocumentacionManejoDAO.getInstancia()
				.obtenerDocumentacionManejo();
		precumplimientoCodigoMalicioso = new ArrayList<>();
		precumplimientoCodigoMalicioso = IncidentesCumplimientoCodigoMaliciosoDAO
				.getInstancia().obtenerIncidentesCumplimientoCodigoMalicioso();
		pregestionParches = new ArrayList<>();
		pregestionParches = IncidentesCumplimientoGestionParchesDAO
				.getInstancia().obtenerGestionParches();
		prepoliticasAntivirus = new ArrayList<>();
		prepoliticasAntivirus = IncidentesCumplimientoPoliticasAntivirusDAO
				.getInstancia().obtenerIncidentesCumplimientoPoliticasA();
		predatosPrueba = new ArrayList<>();
		predatosPrueba = IntegridadConfidencialidadDatosPruebaDAO
				.getInstancia().obtenerIntegridadConfidencialidadDatosPrueba();
		prerespaldoRecuperacion = new ArrayList<>();
		prerespaldoRecuperacion = RespaldosGestionRespaldoRecuperacionDAO
				.getInstancia().obtenerRespaldosGestionRespaldoRecuperacion();

		model.addObject("preagps", preagps);
		model.addObject("prearpu", prearpu);
		model.addObject("preagc", preagc);
		model.addObject("preapc", preapc);
		model.addObject("preagc1", preagc1);
		model.addObject("preagc2", preagc2);
		model.addObject("preagc3", preagc3);
		model.addObject("preregistroAuditoria", preregistroAuditoria);
		model.addObject("preregistroEventos", preregistroEventos);
		model.addObject("preproteccionRegistros", preproteccionRegistros);
		model.addObject("preconformidadPoliticas", preconformidadPoliticas);
		model.addObject("precontingencia", precontingencia);
		model.addObject("preprocedimientoInfraestructura",
				preprocedimientoInfraestructura);
		model.addObject("preprocedimientosSw", preprocedimientosSw);
		model.addObject("predocumentacionManejo", predocumentacionManejo);
		model.addObject("precumplimientoCodigoMalicioso",
				precumplimientoCodigoMalicioso);
		model.addObject("pregestionParches", pregestionParches);
		model.addObject("prepoliticasAntivirus", prepoliticasAntivirus);
		model.addObject("predatosPrueba", predatosPrueba);
		model.addObject("prerespaldoRecuperacion", prerespaldoRecuperacion);

		// Información Post Atención
		// Post Atención Software Base

		sistemaOperativo = new ArrayList<>();
		sistemaOperativo = SwBaseEstandarSistemaOperativoDAO.getInstancia()
				.obtenerSwBaseEstandar();
		gestorBD = new ArrayList<>();
		gestorBD = SwBaseEstandarGestorBDDAO.getInstancia()
				.obtenerSwBaseEstandarGestorBD();
		herramientaProgramacion = new ArrayList<>();
		herramientaProgramacion = SwBaseEstandarHerramientaProgramacionDAO
				.getInstancia().obtenerSwBaseHerramienta();
		lenguajeProgramacion = new ArrayList<>();
		lenguajeProgramacion = SwBaseEstandarLenguajeProgramacionDAO
				.getInstancia().obtenerSwBaseEstandarLenguaje();
		framework = new ArrayList<>();
		framework = SwBaseEstandarFrameworkDAO.getInstancia()
				.obtenerSwBaseEstandarFramework();

		model.addObject("sistemaOperativo", sistemaOperativo);
		model.addObject("gestorBD", gestorBD);
		model.addObject("herramientaProgramacion", herramientaProgramacion);
		model.addObject("lenguajeProgramacion", lenguajeProgramacion);
		model.addObject("framework", framework);

		// Post atencion Lineamientos (obtención de ID)
		// listas desplegables - post atención lineamientos
		agps = new ArrayList<>();
		agps = AccesosGestionPrivilegiosSistemasDAO.getInstancia()
				.obtenerAccesosGestionPrivilegiosSistemas();
		arpu = new ArrayList<>();
		arpu = AccesosRevisionPrivilegiosUsuariosDAO.getInstancia()
				.obtenerAccesosRevisionPrivilegiosUsuarios();
		agc = new ArrayList<>();
		agc = AccesosGestionContrasenasDAO.getInstancia()
				.obtenerAccesosGestionContrasenas();
		apc = new ArrayList<>();
		apc = AccesosPoliticaContrasenasDAO.getInstancia()
				.obtenerAccesosPoliticasContrasenas();
		agc1 = new ArrayList<>();
		agc1 = AccesosGestionClaves1DAO.getInstancia()
				.obtenerAccesosGestionClaves1();
		agc2 = new ArrayList<>();
		agc2 = AccesosGestionClaves2DAO.getInstancia()
				.obtenerAccesosGestionClaves2();
		agc3 = new ArrayList<>();
		agc3 = AccesosGestionClaves3DAO.getInstancia()
				.obtenerAccesosGestionClaves3();

		registroAuditoria = new ArrayList<>();
		registroAuditoria = AuditoriaRegistroAuditoriaDAO.getInstancia()
				.obtenerRegistroAuditoria();
		registroEventos = new ArrayList<>();
		registroEventos = AuditoriaRegistroEventosAdministradoresDAO
				.getInstancia().obtenerRegistroEventos();
		proteccionRegistros = new ArrayList<>();
		proteccionRegistros = AuditoriaProteccionRegistrosAuditoriaDAO
				.getInstancia().obtenerProteccionRegistroAuditoria();
		conformidadPoliticas = new ArrayList<>();
		conformidadPoliticas = AuditoriaConformidadPoliticasDAO.getInstancia()
				.obtenerAuditoriaConformidadPoliticas();
		contingencia = new ArrayList<>();
		contingencia = ContingenciaDAO.getInstancia().obtenerContingencia();
		procedimientoInfraestructura = new ArrayList<>();
		procedimientoInfraestructura = ControlCambiosProcedimientosInfraestructuraDAO
				.getInstancia()
				.obtenerControlCambiosProcedimientosInfraestructura();
		procedimientosSw = new ArrayList<>();
		procedimientosSw = ControlCambiosProcedimientosSwDAO.getInstancia()
				.obtenerControlCambios();
		documentacionManejo = new ArrayList<>();
		documentacionManejo = DocumentacionManejoDAO.getInstancia()
				.obtenerDocumentacionManejo();
		cumplimientoCodigoMalicioso = new ArrayList<>();
		cumplimientoCodigoMalicioso = IncidentesCumplimientoCodigoMaliciosoDAO
				.getInstancia().obtenerIncidentesCumplimientoCodigoMalicioso();
		gestionParches = new ArrayList<>();
		gestionParches = IncidentesCumplimientoGestionParchesDAO.getInstancia()
				.obtenerGestionParches();
		politicasAntivirus = new ArrayList<>();
		politicasAntivirus = IncidentesCumplimientoPoliticasAntivirusDAO
				.getInstancia().obtenerIncidentesCumplimientoPoliticasA();
		datosPrueba = new ArrayList<>();
		datosPrueba = IntegridadConfidencialidadDatosPruebaDAO.getInstancia()
				.obtenerIntegridadConfidencialidadDatosPrueba();
		respaldoRecuperacion = new ArrayList<>();
		respaldoRecuperacion = RespaldosGestionRespaldoRecuperacionDAO
				.getInstancia().obtenerRespaldosGestionRespaldoRecuperacion();

		model.addObject("agps", agps);
		model.addObject("arpu", arpu);
		model.addObject("agc", agc);
		model.addObject("apc", apc);
		model.addObject("agc1", agc1);
		model.addObject("agc2", agc2);
		model.addObject("agc3", agc3);
		model.addObject("registroAuditoria", registroAuditoria);
		model.addObject("registroEventos", registroEventos);
		model.addObject("proteccionRegistros", proteccionRegistros);
		model.addObject("conformidadPoliticas", conformidadPoliticas);
		model.addObject("contingencia", contingencia);
		model.addObject("procedimientoInfraestructura",
				procedimientoInfraestructura);
		model.addObject("procedimientosSw", procedimientosSw);
		model.addObject("documentacionManejo", documentacionManejo);
		model.addObject("cumplimientoCodigoMalicioso",
				cumplimientoCodigoMalicioso);
		model.addObject("gestionParches", gestionParches);
		model.addObject("politicasAntivirus", politicasAntivirus);
		model.addObject("datosPrueba", datosPrueba);
		model.addObject("respaldoRecuperacion", respaldoRecuperacion);

		// Pestaña Información Adicional

		escenarioLogueo = new ArrayList<>();
		escenarioLogueo = EscenarioLogueoDAO.getInstancia().obtenerEscenario();
		impactoProteccion = new ArrayList<>();
		impactoProteccion = ImpactoProteccionDatosDAO.getInstancia()
				.obtenerImpacto();
		impactoLevantamiento = new ArrayList<>();
		impactoLevantamiento = ImpactoProteccionDatosLevantamientoInformacionDAO
				.getInstancia().obtenerImpactoLevantamiento();

		fuentePeriodo = new ArrayList<>();
		fuentePeriodo = FuentePeriodoDAO.getInstancia().obtenerFuentePeriodo();

		campoInventario = new ArrayList<>();
		campoInventario = CampoInventarioDAO.getInstancia()
				.obtenerCampoInventario();
		grupoInventario = new ArrayList<>();
		grupoInventario = GrupoInventarioDAO.getInstancia()
				.obtenerGrupoInventario();

		model.addObject("fuentePeriodo", fuentePeriodo);
		model.addObject("bitacoraActualizaciones", bitacoraActualizaciones);
		model.addObject("campoInventario", campoInventario);
		model.addObject("grupoInventario", grupoInventario);

		model.addObject("escenarioLogueo", escenarioLogueo);
		model.addObject("impactoProteccion", impactoProteccion);
		model.addObject("impactoLevantamiento", impactoLevantamiento);

		System.out.println("llegaaaaa");
		return model;

	}

	@RequestMapping(value = { "/buscar" }, method = RequestMethod.POST)
	public ModelAndView getAplicaciones(HttpServletRequest request, ModelMap mod)
			throws Exception {

		listaAplicaciones = new ArrayList<>();
	

		ConsultaGeneralAplicacionesDTO aplicaciones = new ConsultaGeneralAplicacionesDTO();
		aplicaciones.setCodigoAplicacion(request.getParameter("codigoAplicacion"));
	

		aplicaciones.setNombreAplicacion(request.getParameter("nombreAplicacion"));
	

		aplicaciones.setIdEstadoAplicacion(Integer.parseInt(request.getParameter("estadoAplicacion")));
	

		aplicaciones.setIdClasificacion(Integer.parseInt(request.getParameter("clasificacion")));
		

		aplicaciones.setIdCriticidadFinal(Integer.parseInt(request.getParameter("criticidadFinal")));
	
if(request.getParameter("nivelCumplimiento") =="")
{aplicaciones.setNivelCumplimiento(0.0);}
else
{aplicaciones.setNivelCumplimiento(Double.parseDouble(request.getParameter("nivelCumplimiento")));}
		

		

		aplicaciones.setIdEstadoAtencionRoadmap(Integer.parseInt(request.getParameter("estadoRoadmap")));

		if(request.getParameter("postAtencionNivelCumplimiento")=="")
		{aplicaciones.setPostAtencionNivelCumplimiento(0.0);}
		else
		{aplicaciones.setPostAtencionNivelCumplimiento(Double.parseDouble(request.getParameter("postAtencionNivelCumplimiento")));}
		
	

		aplicaciones.setProcesoClave(request.getParameter("procesoClave"));
		

		listaAplicaciones = ConsultaAplicacionEspecializadaDAO.getInstancia().obtenerAplicaciones(aplicaciones);
		
		if(listaAplicaciones.size() ==0)
		{
		message = "No se encontraron datos.";
		ModelAndView model = new ModelAndView("Auxiliar/ListaConsultaGeneral");
		model.addObject("mensajeInfo", message);
		return model;
		}
		else
		{
			ModelAndView model = new ModelAndView("Auxiliar/ListaConsultaGeneral");
			model.addObject("listaAplicaciones", listaAplicaciones);
			return model;
		}
		

	}

	@RequestMapping(value="/verDetalle&ID_APLICACION_ESPECIALIZADA={ID_APLICACION_ESPECIALIZADA}&ID_VERSION={ID_VERSION}", method = RequestMethod.GET)
	public ModelAndView  verDetalle(@PathVariable int ID_APLICACION_ESPECIALIZADA,@PathVariable int ID_VERSION, ModelMap mod) throws Exception {
		
		ModelAndView model = new ModelAndView("detalleAplicacionesEspecializadas");
		
		
		//Estructura Organizacional
		gerencia = new ArrayList<>();
		gerencia = GerenciaCentralDAO.getInstancia().obtenerGerenciaCentral();
		unidad = new ArrayList<>();
		unidad = UnidadDAO.getInstancia().obtenerUnidad();
		division = new ArrayList<>();
		division = DivisionDAO.getInstancia().obtenerDivision();
		area = new ArrayList<>();
		area = AreaDAO.getInstancia().obtenerArea();
		
		
		model.addObject("gerencia",gerencia);
		model.addObject("unidad",unidad);
		model.addObject("division",division);
		model.addObject("area",area);
		
		
		//Información General
		estadoAplicacion = new ArrayList<>();
		estadoAplicacion = EstadoAplicacionDAO.getInstancia().obtenerEstadoAplicacion();
		tipoOperacionProceso = new ArrayList<>();
		tipoOperacionProceso = TipoOperacionProcesoDAO.getInstancia().obtenerTipoOperacionProceso();
		frecuenciaOperaciones = new ArrayList<>();
		frecuenciaOperaciones = FrecuenciaOperacionesDAO.getInstancia().obtenerFrecuenciaOperaciones();
		cantidadOperaciones = new ArrayList<>();
		cantidadOperaciones = CantidadOperacionesDAO.getInstancia().obtenerCantidadOperaciones();
		motivoCreacionAplicacion = new ArrayList<>();
		motivoCreacionAplicacion = MotivoCreacionAplicacionDAO.getInstancia().obtenerMotivoCreacionAplicacion();
		
		model.addObject("estadoAplicacion",estadoAplicacion);
		model.addObject("tipoOperacionProceso",tipoOperacionProceso);
		model.addObject("frecuenciaOperaciones",frecuenciaOperaciones);
		model.addObject("cantidadOperaciones",cantidadOperaciones);
		model.addObject("motivoCreacionAplicacion",motivoCreacionAplicacion);

		
		//Dominio
		cdominio = new ArrayList<>();
		cdominio = DominioDAO.getInstancia().obtenerDominio();
		subdominio= new ArrayList<>();
		subdominio= SubDominioDAO.getInstancia().obtenerSubDominio();
		entidadesUsuarias = new ArrayList<>();
		entidadesUsuarias = EntidadesUsuariasDAO.getInstancia().obtenerEntidadesUsuarias();
		cuap = new ArrayList<>();
		cuap = CantidadUsuariosAplicacionTotalDAO.getInstancia().obtenerCantidad();
		procesoAuditoria = new ArrayList<>();
		procesoAuditoria = ProcesoAuditoriaDAO.getInstancia().obtenerProcesoAuditoria();
		procesoClave = new ArrayList<>();
		procesoClave = ProcesoClaveDAO.getInstancia().obtenerProcesoClave();
		dominioActividad= new ArrayList<>();
		dominioActividad= ActividadDAO.getInstancia().obtenerActividad();
		
		model.addObject("cdominio", cdominio);
		model.addObject("subdominio", subdominio);
		model.addObject("entidadesUsuarias", entidadesUsuarias);
		model.addObject("cuap", cuap);
		model.addObject("procesoAuditoria", procesoAuditoria);
		model.addObject("procesoClave", procesoClave);
		model.addObject("dominioActividad", dominioActividad);
		
		//Clasificación de activos
		confidencialidad = new ArrayList<>();
		confidencialidad = ConfidencialidadDAO.getInstancia().obtenerConfidencialidad();
		integridad = new ArrayList<>();
		integridad = IntegridadDAO.getInstancia().obtenerIntegridad();
		disponibilidad = new ArrayList<>();
		disponibilidad = DisponibilidadDAO.getInstancia().obtenerDisponibilidad();
		privacidad = new ArrayList<>();
		privacidad = PrivacidadDAO.getInstancia().obtenerPrivacidad();
		clasificacion = new ArrayList<>();
		clasificacion = ClasificacionDAO.getInstancia().obtenerClasificacion();
		criticidadfinal = new ArrayList<>();
		criticidadfinal = CriticidadFinalDAO.getInstancia().obtenerCriticidadFinal();
		estadoRevision= new ArrayList<>();
		estadoRevision= EstadoRevisionAplicacionDAO.getInstancia().obtenerEstadoRevisionAplicacion();

		
		model.addObject("confidencialidad", confidencialidad);
		model.addObject("integridad", integridad);
		model.addObject("disponibilidad", disponibilidad);
		model.addObject("privacidad", privacidad);
		model.addObject("clasificacion", clasificacion);
		model.addObject("criticidadfinal",criticidadfinal);
		model.addObject("estadoRevision", estadoRevision);

		
		//Cateoria Tecnologica
		categoriaTecnologica = new ArrayList<>();
		categoriaTecnologica = CategoriaTecnologicaDAO.getInstancia().obtenerCategoriaTecnologica();
		tipoDesarrollo = new ArrayList<>();
		tipoDesarrollo = TipoDesarrolloDAO.getInstancia().obtenerTipoDesarrollo();
		ubicacionFisica = new ArrayList<>();
		ubicacionFisica = UbicacionFisicaDAO.getInstancia().obtenerUbicacionFisica();
		ambiente = new ArrayList<>();
		ambiente = AmbienteAppNoITDAO.getInstancia().obtenerAmbienteAppNoIT();
		infraestructuraAplicacion = new ArrayList<>();
		infraestructuraAplicacion = InfraestructuraAplicacionDAO.getInstancia().obtenerInfraestructuraAplicacion();
		mantenimientoAplicacion = new ArrayList<>();
		mantenimientoAplicacion = MantenimientoAplicacionDAO.getInstancia().obtenerMantenimientoAplicacion();
		soporteAplicacion = new ArrayList<>();
		soporteAplicacion = SoporteAplicacionDAO.getInstancia().obtenerSoporteAplicacion();
		accesosAplicacion = new ArrayList<>();
		accesosAplicacion = AccesosAplicacionDAO.getInstancia().obtenerAccesosAplicacion();

		
		model.addObject("categoriaTecnologica", categoriaTecnologica);
		model.addObject("tipoDesarrollo", tipoDesarrollo);
		model.addObject("ubicacionFisica", ubicacionFisica);
		model.addObject("ambiente", ambiente);
		model.addObject("infraestructuraAplicacion", infraestructuraAplicacion);
		model.addObject("mantenimientoAplicacion", mantenimientoAplicacion);
		model.addObject("soporteAplicacion", soporteAplicacion);
		model.addObject("accesosAplicacion", accesosAplicacion);
		
		
		//Datamart
		herramienta= new ArrayList<>();
		herramienta = HerramientaExplotacionDatosDAO.getInstancia().obtenerHerramientaExplotacionDatos();
		
		model.addObject("herramienta", herramienta);
		
		//Impactos
		procesoAuditoriaI = new ArrayList<>();
		procesoAuditoriaI = ProcesoAuditoriaDAO.getInstancia().obtenerProcesoAuditoria();
		impactoProcesoClave= new ArrayList<>();
		impactoProcesoClave = ProcesoClaveDAO.getInstancia().obtenerProcesoClave();	
		impactoActividad= new ArrayList<>();
		impactoActividad= ActividadDAO.getInstancia().obtenerActividad();
		
		model.addObject("impactoProcesoClave",impactoProcesoClave);
		model.addObject("impactoActividad",impactoActividad);
		model.addObject("procesoAuditoriaI", procesoAuditoriaI);
		
		//**** Pestaña Información Roadmap
	
		
		
		estadoAtencionRoadmap= new ArrayList<>();
		estadoAtencionRoadmap = EstadoAtencionRoadmapDAO.getInstancia().obtenerEstadoAtencionRoadmap();

		
		model.addObject("estadoAtencionRoadmap", estadoAtencionRoadmap);

		//*** Pestaña Información Pre Atención
		//Pre Atención Software Base
		
		
		presistemaOperativo = new ArrayList<>();
		presistemaOperativo = SwBaseEstandarSistemaOperativoDAO.getInstancia().obtenerSwBaseEstandar();
		pregestorBD = new ArrayList<>();
		pregestorBD = SwBaseEstandarGestorBDDAO.getInstancia().obtenerSwBaseEstandarGestorBD();
		preherramientaProgramacion = new ArrayList<>();
		preherramientaProgramacion = SwBaseEstandarHerramientaProgramacionDAO.getInstancia().obtenerSwBaseHerramienta();
		prelenguajeProgramacion = new ArrayList<>();
		prelenguajeProgramacion = SwBaseEstandarLenguajeProgramacionDAO.getInstancia().obtenerSwBaseEstandarLenguaje();
		preframework = new ArrayList<>();
		preframework = SwBaseEstandarFrameworkDAO.getInstancia().obtenerSwBaseEstandarFramework();
		
		
		model.addObject("presistemaOperativo",presistemaOperativo);
		model.addObject("pregestorBD",pregestorBD);
		model.addObject("preherramientaProgramacion",preherramientaProgramacion);
		model.addObject("prelenguajeProgramacion",prelenguajeProgramacion);
		model.addObject("preframework",preframework);
		
		
		//Pre atencion Lineamientos (obtención de ID)
		//listas desplegables - post atención lineamientos
		preagps = new ArrayList<>();
		preagps = AccesosGestionPrivilegiosSistemasDAO.getInstancia().obtenerAccesosGestionPrivilegiosSistemas();
		prearpu = new ArrayList<>();
		prearpu = AccesosRevisionPrivilegiosUsuariosDAO.getInstancia().obtenerAccesosRevisionPrivilegiosUsuarios();
		preagc = new ArrayList<>();
		preagc = AccesosGestionContrasenasDAO.getInstancia().obtenerAccesosGestionContrasenas();
		preapc = new ArrayList<>();
		preapc = AccesosPoliticaContrasenasDAO.getInstancia().obtenerAccesosPoliticasContrasenas();
		preagc1 = new ArrayList<>();
		preagc1 = AccesosGestionClaves1DAO.getInstancia().obtenerAccesosGestionClaves1();
		preagc2= new ArrayList<>();
		preagc2 = AccesosGestionClaves2DAO.getInstancia().obtenerAccesosGestionClaves2();
		preagc3 = new ArrayList<>();
		preagc3 = AccesosGestionClaves3DAO.getInstancia().obtenerAccesosGestionClaves3();
		
		preregistroAuditoria = new ArrayList<>();
		preregistroAuditoria = AuditoriaRegistroAuditoriaDAO.getInstancia().obtenerRegistroAuditoria();
		preregistroEventos = new ArrayList<>();
		preregistroEventos = AuditoriaRegistroEventosAdministradoresDAO.getInstancia().obtenerRegistroEventos();
		preproteccionRegistros = new ArrayList<>();
		preproteccionRegistros = AuditoriaProteccionRegistrosAuditoriaDAO.getInstancia().obtenerProteccionRegistroAuditoria();
		preconformidadPoliticas = new ArrayList<>();
		preconformidadPoliticas = AuditoriaConformidadPoliticasDAO.getInstancia().obtenerAuditoriaConformidadPoliticas();
		precontingencia = new ArrayList<>();
		precontingencia = ContingenciaDAO.getInstancia().obtenerContingencia();
		preprocedimientoInfraestructura = new ArrayList<>();
		preprocedimientoInfraestructura = ControlCambiosProcedimientosInfraestructuraDAO.getInstancia().obtenerControlCambiosProcedimientosInfraestructura();
		preprocedimientosSw = new ArrayList<>();
		preprocedimientosSw = ControlCambiosProcedimientosSwDAO.getInstancia().obtenerControlCambios();
		predocumentacionManejo = new ArrayList<>();
		predocumentacionManejo = DocumentacionManejoDAO.getInstancia().obtenerDocumentacionManejo();
		precumplimientoCodigoMalicioso = new ArrayList<>();
		precumplimientoCodigoMalicioso = IncidentesCumplimientoCodigoMaliciosoDAO.getInstancia().obtenerIncidentesCumplimientoCodigoMalicioso();
		pregestionParches = new ArrayList<>();
		pregestionParches = IncidentesCumplimientoGestionParchesDAO.getInstancia().obtenerGestionParches();
		prepoliticasAntivirus = new ArrayList<>();
		prepoliticasAntivirus = IncidentesCumplimientoPoliticasAntivirusDAO.getInstancia().obtenerIncidentesCumplimientoPoliticasA();
		predatosPrueba = new ArrayList<>();
		predatosPrueba = IntegridadConfidencialidadDatosPruebaDAO.getInstancia().obtenerIntegridadConfidencialidadDatosPrueba();
		prerespaldoRecuperacion = new ArrayList<>();
		prerespaldoRecuperacion = RespaldosGestionRespaldoRecuperacionDAO.getInstancia().obtenerRespaldosGestionRespaldoRecuperacion();
		
		
	
		
		
		model.addObject("preagps",preagps);
		model.addObject("prearpu",prearpu);
		model.addObject("preagc",preagc);
		model.addObject("preapc",preapc);
		model.addObject("preagc1",preagc1);
		model.addObject("preagc2",preagc2);
		model.addObject("preagc3",preagc3);
		model.addObject("preregistroAuditoria",preregistroAuditoria);
		model.addObject("preregistroEventos",preregistroEventos);
		model.addObject("preproteccionRegistros",preproteccionRegistros);
		model.addObject("preconformidadPoliticas",preconformidadPoliticas);
		model.addObject("precontingencia",precontingencia);
		model.addObject("preprocedimientoInfraestructura",preprocedimientoInfraestructura);
		model.addObject("preprocedimientosSw",preprocedimientosSw);
		model.addObject("predocumentacionManejo",predocumentacionManejo);
		model.addObject("precumplimientoCodigoMalicioso",precumplimientoCodigoMalicioso);
		model.addObject("pregestionParches",pregestionParches);
		model.addObject("prepoliticasAntivirus",prepoliticasAntivirus);
		model.addObject("predatosPrueba",predatosPrueba);
		model.addObject("prerespaldoRecuperacion",prerespaldoRecuperacion);
	
		
		//Información Post Atención
		//Post Atención Software Base
		
		
		
		sistemaOperativo = new ArrayList<>();
		sistemaOperativo = SwBaseEstandarSistemaOperativoDAO.getInstancia().obtenerSwBaseEstandar();
		gestorBD = new ArrayList<>();
		gestorBD = SwBaseEstandarGestorBDDAO.getInstancia().obtenerSwBaseEstandarGestorBD();
		herramientaProgramacion = new ArrayList<>();
		herramientaProgramacion = SwBaseEstandarHerramientaProgramacionDAO.getInstancia().obtenerSwBaseHerramienta();
		lenguajeProgramacion = new ArrayList<>();
		lenguajeProgramacion = SwBaseEstandarLenguajeProgramacionDAO.getInstancia().obtenerSwBaseEstandarLenguaje();
		framework = new ArrayList<>();
		framework = SwBaseEstandarFrameworkDAO.getInstancia().obtenerSwBaseEstandarFramework();
		
		
		model.addObject("sistemaOperativo",sistemaOperativo);
		model.addObject("gestorBD",gestorBD);
		model.addObject("herramientaProgramacion",herramientaProgramacion);
		model.addObject("lenguajeProgramacion",lenguajeProgramacion);
		model.addObject("framework",framework);
		
		
		//Post atencion Lineamientos (obtención de ID)
		//listas desplegables - post atención lineamientos
		agps = new ArrayList<>();
		agps = AccesosGestionPrivilegiosSistemasDAO.getInstancia().obtenerAccesosGestionPrivilegiosSistemas();
		arpu = new ArrayList<>();
		arpu = AccesosRevisionPrivilegiosUsuariosDAO.getInstancia().obtenerAccesosRevisionPrivilegiosUsuarios();
		agc = new ArrayList<>();
		agc = AccesosGestionContrasenasDAO.getInstancia().obtenerAccesosGestionContrasenas();
		apc = new ArrayList<>();
		apc = AccesosPoliticaContrasenasDAO.getInstancia().obtenerAccesosPoliticasContrasenas();
		agc1 = new ArrayList<>();
		agc1 = AccesosGestionClaves1DAO.getInstancia().obtenerAccesosGestionClaves1();
		agc2= new ArrayList<>();
		agc2 = AccesosGestionClaves2DAO.getInstancia().obtenerAccesosGestionClaves2();
		agc3 = new ArrayList<>();
		agc3 = AccesosGestionClaves3DAO.getInstancia().obtenerAccesosGestionClaves3();
		
		registroAuditoria = new ArrayList<>();
		registroAuditoria = AuditoriaRegistroAuditoriaDAO.getInstancia().obtenerRegistroAuditoria();
		registroEventos = new ArrayList<>();
		registroEventos = AuditoriaRegistroEventosAdministradoresDAO.getInstancia().obtenerRegistroEventos();
		proteccionRegistros = new ArrayList<>();
		proteccionRegistros = AuditoriaProteccionRegistrosAuditoriaDAO.getInstancia().obtenerProteccionRegistroAuditoria();
		conformidadPoliticas = new ArrayList<>();
		conformidadPoliticas = AuditoriaConformidadPoliticasDAO.getInstancia().obtenerAuditoriaConformidadPoliticas();
		contingencia = new ArrayList<>();
		contingencia = ContingenciaDAO.getInstancia().obtenerContingencia();
		procedimientoInfraestructura = new ArrayList<>();
		procedimientoInfraestructura = ControlCambiosProcedimientosInfraestructuraDAO.getInstancia().obtenerControlCambiosProcedimientosInfraestructura();
		procedimientosSw = new ArrayList<>();
		procedimientosSw = ControlCambiosProcedimientosSwDAO.getInstancia().obtenerControlCambios();
		documentacionManejo = new ArrayList<>();
		documentacionManejo = DocumentacionManejoDAO.getInstancia().obtenerDocumentacionManejo();
		cumplimientoCodigoMalicioso = new ArrayList<>();
		cumplimientoCodigoMalicioso = IncidentesCumplimientoCodigoMaliciosoDAO.getInstancia().obtenerIncidentesCumplimientoCodigoMalicioso();
		gestionParches = new ArrayList<>();
		gestionParches = IncidentesCumplimientoGestionParchesDAO.getInstancia().obtenerGestionParches();
		politicasAntivirus = new ArrayList<>();
		politicasAntivirus = IncidentesCumplimientoPoliticasAntivirusDAO.getInstancia().obtenerIncidentesCumplimientoPoliticasA();
		datosPrueba = new ArrayList<>();
		datosPrueba = IntegridadConfidencialidadDatosPruebaDAO.getInstancia().obtenerIntegridadConfidencialidadDatosPrueba();
		respaldoRecuperacion = new ArrayList<>();
		respaldoRecuperacion = RespaldosGestionRespaldoRecuperacionDAO.getInstancia().obtenerRespaldosGestionRespaldoRecuperacion();
		
		
	
		
	
		model.addObject("agps",agps);
		model.addObject("arpu",arpu);
		model.addObject("agc",agc);
		model.addObject("apc",apc);
		model.addObject("agc1",agc1);
		model.addObject("agc2",agc2);
		model.addObject("agc3",agc3);
		model.addObject("registroAuditoria",registroAuditoria);
		model.addObject("registroEventos",registroEventos);
		model.addObject("proteccionRegistros",proteccionRegistros);
		model.addObject("conformidadPoliticas",conformidadPoliticas);
		model.addObject("contingencia",contingencia);
		model.addObject("procedimientoInfraestructura",procedimientoInfraestructura);
		model.addObject("procedimientosSw",procedimientosSw);
		model.addObject("documentacionManejo",documentacionManejo);
		model.addObject("cumplimientoCodigoMalicioso",cumplimientoCodigoMalicioso);
		model.addObject("gestionParches",gestionParches);
		model.addObject("politicasAntivirus",politicasAntivirus);
		model.addObject("datosPrueba",datosPrueba);
		model.addObject("respaldoRecuperacion",respaldoRecuperacion);
		
		
		//Pestaña Información Adicional


	
		escenarioLogueo = new ArrayList<>();
		escenarioLogueo = EscenarioLogueoDAO.getInstancia().obtenerEscenario();
		impactoProteccion = new ArrayList<>();
		impactoProteccion = ImpactoProteccionDatosDAO.getInstancia().obtenerImpacto();
		impactoLevantamiento = new ArrayList<>();
		impactoLevantamiento = ImpactoProteccionDatosLevantamientoInformacionDAO.getInstancia().obtenerImpactoLevantamiento();
		
		
		
		
		fuentePeriodo = new ArrayList<>();
		fuentePeriodo = FuentePeriodoDAO.getInstancia().obtenerFuentePeriodo();
		
		
		
		campoInventario = new ArrayList<>();
		campoInventario = CampoInventarioDAO.getInstancia().obtenerCampoInventario();
		grupoInventario = new ArrayList<>();
		grupoInventario = GrupoInventarioDAO.getInstancia().obtenerGrupoInventario();
		
		
		
		
		
		model.addObject("fuentePeriodo",fuentePeriodo);
		model.addObject("bitacoraActualizaciones",bitacoraActualizaciones);
		model.addObject("campoInventario",campoInventario);
		model.addObject("grupoInventario",grupoInventario);

		
		model.addObject("escenarioLogueo",escenarioLogueo);
		model.addObject("impactoProteccion",impactoProteccion);
		model.addObject("impactoLevantamiento",impactoLevantamiento);
		
		
		
		
		
		
		
		
		
		
		
		
		historicoAplicaciones= new ArrayList<>();
		AplicacionEspecializada app= new AplicacionEspecializada();
		app.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		
		historicoAplicaciones = AplicacionEspecializadaDAO.getInstancia().obtenerVersiones(app);
		model.addObject("historicoAplicaciones", historicoAplicaciones);
	
		//**** Pestaña Información General
		
		//Sección Estructura Organizacional
		lista = new AppEspEstructuraOrganizacional();
		AppEspEstructuraOrganizacional miEs= new AppEspEstructuraOrganizacional();
		miEs.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miEs.setIdVersion(ID_VERSION);
		lista= AppEspEstructuraOrganizacionalDAO.getInstancia().obtenerEstructuraPorAplicacion(miEs);

		
		
		model.addObject("lista", lista);
		

		
		//Sección Información General
		listaInfo = new AppEspInformacionGeneral();
		AppEspInformacionGeneral info = new AppEspInformacionGeneral();
		info.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		info.setIdVersion(ID_VERSION);
		listaInfo = AppEspInformacionGeneralDAO.getInstancia().obtenerInformacionGeneralPorAplicacion(info);

		
		
		
		model.addObject("listaInfo",listaInfo);
		

		//Sección Dominio
		dominio = new AppEspDominio();
		AppEspDominio miDominio= new AppEspDominio();
		miDominio.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miDominio.setIdVersion(ID_VERSION);
		dominio= AppEspDominioDAO.getInstancia().obtenerDominioPorAplicacion(miDominio);
		
		
		
		model.addObject("dominio", dominio);
		
		
		
		//Clasificación de activos
	
		
		clasifActivos = new AppEspClasificacionActivos();
		AppEspClasificacionActivos miClasificacionActivos= new AppEspClasificacionActivos();
		miClasificacionActivos.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miClasificacionActivos.setIdVersion(ID_VERSION);
		clasifActivos= AppEspClasificacionActivosDAO.getInstancia().obtenerClasificacionActivosPorAplicacion(miClasificacionActivos);
		
		
		
		
		model.addObject("clasifActivos", clasifActivos);
		
		
		
		
		//**** Pestaña Información Técnica e Impacto
		
		//Sección Catacterísticas Técnicas
		listaCaracteristicas= new AppEspCaracteristicasTecnicas();
		AppEspCaracteristicasTecnicas carac= new AppEspCaracteristicasTecnicas();
		carac.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		carac.setIdVersion(ID_VERSION);
		listaCaracteristicas= AppEspCaracteristicasTecnicasDAO.getInstancia().obtenerCaracteristicasTecnicasPorAplicacion(carac);
		
	
		model.addObject("listaCaracteristicas", listaCaracteristicas);
		
		
		//Sección Datamart
		listaDatamart = new AppEspDatamart();
		AppEspDatamart datamart= new AppEspDatamart();
		datamart.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		datamart.setIdVersion(ID_VERSION);
		listaDatamart= AppEspDatamartDAO.getInstancia().obtenerDatamartPorAplicacion(datamart);
		
		
		
		
		model.addObject("listaDatamart", listaDatamart);
		
		
		//**** Pestaña Información Roadmap
	
		
		listaInformacionPlanRoadmap= new AppEspInformacionPlanRoadmap();
		AppEspInformacionPlanRoadmap infoRoadmap= new AppEspInformacionPlanRoadmap();
		infoRoadmap.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		infoRoadmap.setIdVersion(ID_VERSION);
		listaInformacionPlanRoadmap= AppEspInformacionPlanRoadmapDAO.getInstancia().obtenerInformacionPlanRoadmapPorAplicacion(infoRoadmap);
		
		

		model.addObject("listaInformacionPlanRoadmap", listaInformacionPlanRoadmap);
		

		
		//
		
		
		
		funcionalidad  = new AppEspFuncionalidad();
		AppEspFuncionalidad miFuncionalidad= new AppEspFuncionalidad();
		miFuncionalidad.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miFuncionalidad.setIdVersion(ID_VERSION);
		funcionalidad= AppEspFuncionalidadDAO.getInstancia().obtenerFuncionalidadPorAplicacion(miFuncionalidad);
		
		
		model.addObject("funcionalidad",funcionalidad);
		
		seguridadInformacion  = new AppEspSeguridadInformacion();
		AppEspSeguridadInformacion miSeguridad= new AppEspSeguridadInformacion();
		miSeguridad.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miSeguridad.setIdVersion(ID_VERSION);
		seguridadInformacion= AppEspSeguridadInformacionDAO.getInstancia().obtenerSeguridadInformacionPorAplicacion(miSeguridad);
		
		
		//*** Pestaña Información Pre Atención
		//Pre Atención Software Base
		
		
		preswBaseEstandarTecnologico  = new AppEspSwBaseEstandarTecnologico();
		AppEspSwBaseEstandarTecnologico mipreSwBase= new AppEspSwBaseEstandarTecnologico();
		mipreSwBase.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		mipreSwBase.setIdVersion(ID_VERSION);
		preswBaseEstandarTecnologico= AppEspSwBaseEstandarTecnologicoDAO.getInstancia().obtenerSwBasePorAplicacion(mipreSwBase);
		
		
		model.addObject("preswBaseEstandarTecnologico",preswBaseEstandarTecnologico);
	
		
		//Pre atencion Lineamientos (obtención de ID)
		preLineamientos  = new AppEspLineamientos();
		AppEspLineamientos miPreLineamientos= new AppEspLineamientos();
		miPreLineamientos.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miPreLineamientos.setIdVersion(ID_VERSION);
		preLineamientos= AppEspLineamientosDAO.getInstancia().obtenerPreAtencionLineamientosPorAplicacion(miPreLineamientos);
		//listas desplegables - post atención lineamientos
		
		
		
	
		
		model.addObject("preLineamientos",preLineamientos);
		
		
		//Información Post Atención
		//Post Atención Software Base
		
		
		swBaseEstandarTecnologico  = new AppEspPostAtencionSwBaseEstandarTecnologico();
		AppEspPostAtencionSwBaseEstandarTecnologico miSwBase= new AppEspPostAtencionSwBaseEstandarTecnologico();
		miSwBase.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miSwBase.setIdVersion(ID_VERSION);
		swBaseEstandarTecnologico= AppEspPostAtencionSwBaseEstandarTecnologicoDAO.getInstancia().obtenerCaracteristicasParticularesPorAplicacion(miSwBase);
		
		
		model.addObject("swBaseEstandarTecnologico",swBaseEstandarTecnologico);
		
		
		//Post atencion Lineamientos (obtención de ID)
		postLineamientos  = new AppEspPostAtencionLineamientos();
		AppEspPostAtencionLineamientos miPostLineamientos= new AppEspPostAtencionLineamientos();
		miPostLineamientos.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miPostLineamientos.setIdVersion(ID_VERSION);
		postLineamientos= AppEspPostAtencionLineamientosDAO.getInstancia().obtenerPostAtencionLineamientosPorAplicacion(miPostLineamientos);
		//listas desplegables - post atención lineamientos
		
		
	
		
		model.addObject("postLineamientos",postLineamientos);
		
		
		
		//Pestaña Información Adicional


		caracteristicasParticulares  = new AppEspCaracteristicasParticulares();
		AppEspCaracteristicasParticulares miCaracteristicasParticulares= new AppEspCaracteristicasParticulares();
		miCaracteristicasParticulares.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miCaracteristicasParticulares.setIdVersion(ID_VERSION);
		caracteristicasParticulares= AppEspCaracteristicasParticularesDAO.getInstancia().obtenerCaracteristicasParticularesPorAplicacion(miCaracteristicasParticulares);
		
		
		
		fuenteOrigen  = new AppEspFuenteOrigen();
		AppEspFuenteOrigen miFuenteOrigen= new AppEspFuenteOrigen();
		miFuenteOrigen.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miFuenteOrigen.setIdVersion(ID_VERSION);
		fuenteOrigen= AppEspFuenteOrigenDAO.getInstancia().obtenerFuenteOrigenPorAplicacion(miFuenteOrigen);
		
	
		bitacoraActualizaciones  = new BitacoraActualizaciones();
		BitacoraActualizaciones miBitacora= new BitacoraActualizaciones();
		miBitacora.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miBitacora.setIdVersion(ID_VERSION);
		bitacoraActualizaciones= BitacoraActualizacionesDAO.getInstancia().obtenerBitacoraActualizacionesPorAplicacion(miBitacora);
		
		
		
		model.addObject("fuenteOrigen",fuenteOrigen);
	
		model.addObject("bitacoraActualizaciones",bitacoraActualizaciones);
		
		model.addObject("caracteristicasParticulares",caracteristicasParticulares);
		
		
		model.addObject("seguridadInformacion",seguridadInformacion);
	
		//Impacto
		impacto = new AppEspImpacto();
		AppEspImpacto miImpacto= new AppEspImpacto();
		miImpacto.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		miImpacto.setIdVersion(ID_VERSION);
		impacto= AppEspImpactoDAO.getInstancia().obtenerImpactoPorAplicacion(miImpacto);
		
		
		
		
	
		
		model.addObject("impacto",impacto);
		
		/*
		nivelEstandar = new AppEspNivelesCumplimientoEstandares();
		AppEspNivelesCumplimientoEstandares nEstandar = new AppEspNivelesCumplimientoEstandares();
		nEstandar.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		nEstandar.setIdVersion(ID_VERSION);
		nivelEstandar = AppEspNivelesCumplimientoEstandaresDAO.getInstancia().obtenerNivelCumplimientoEstandares(nEstandar);
		model.addObject("nivelEstandar",nivelEstandar);
		
	
		nivelLineamiento = new AppEspNivelCumplimientoLineamientos();
		AppEspNivelCumplimientoLineamientos nLineamiento = new AppEspNivelCumplimientoLineamientos();
		nLineamiento.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		nLineamiento.setIdVersion(ID_VERSION);
		nivelLineamiento = AppEspNivelCumplimientoLineamientosDAO.getInstancia().obtenerNivelCumplimientoLineamientos(nLineamiento);
		model.addObject("nivelLineamiento",nivelLineamiento);
		*/
		/*
		nivelCumplimiento = new AppEspNivelCumplimiento();
		AppEspNivelCumplimiento nCumplimiento = new AppEspNivelCumplimiento();
		nCumplimiento.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		nCumplimiento.setIdVersion(ID_VERSION);
		nivelCumplimiento = AppEspNivelCumplimientoDAO.getInstancia().obtenerNivelCumplimiento(nCumplimiento);
		model.addObject("nCumplimiento",nivelCumplimiento);
		
		nivelCumplimientoP = new AppEspNivelCumplimiento();
		AppEspNivelCumplimiento nCumplimientoP = new AppEspNivelCumplimiento();
		nCumplimientoP.setIdAplicacionEspecializada(ID_APLICACION_ESPECIALIZADA);
		nCumplimientoP.setIdVersion(ID_VERSION);
		nivelCumplimientoP = AppEspNivelCumplimientoDAO.getInstancia().obtenerNivelCumplimientoPost(nCumplimientoP);
		model.addObject("nCumplimientoP",nivelCumplimientoP);*/
		
		System.out.println("llegaaaaa");
		return model;
 
	}
	
	@RequestMapping(value = "/LoaddetalleAplicacionesEspecializadas", method = RequestMethod.GET)
	public ModelAndView LoadAplicacionEspecializada(HttpServletRequest request,
			ModelMap mod) throws Exception {

		ArrayList<GerenciaCentral> ListaGerenciaCentral = new ArrayList<GerenciaCentral>();
		ArrayList<Area> ListaArea = new ArrayList<Area>();
		ArrayList<Unidad> ListaUnidad = new ArrayList<Unidad>();
		ArrayList<Division> ListaDivision = new ArrayList<Division>();

		ListaGerenciaCentral = GerenciaCentralDAO.getInstancia()
				.obtenerGerenciaCentral();
		ListaArea = AreaDAO.getInstancia().obtenerArea();
		ListaUnidad = UnidadDAO.getInstancia().obtenerUnidad();
		ListaDivision = DivisionDAO.getInstancia().obtenerDivision();

		ModelAndView model = new ModelAndView(
				"detalleAplicacionesEspecializadas");
		model.addObject("gerencia", ListaGerenciaCentral);
		model.addObject("division", ListaDivision);
		model.addObject("area", ListaArea);
		model.addObject("unidad", ListaUnidad);

		return model;

	}

	@RequestMapping(value = { "/ingresar" }, method = RequestMethod.POST)
	public ModelAndView registrarAplicacionEspecializada(
			HttpServletRequest request, ModelMap mod) throws Exception {
		
		LogAuditoriaController logAuditoria = new LogAuditoriaController();
		LogAuditoria objeto = new LogAuditoria();
		Date fecha = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

		/* Objetos */
		AplicacionEspecializada ae = new AplicacionEspecializada();
		ArrayList<AplicacionEspecializada> listaID = new ArrayList<AplicacionEspecializada>();
		listausuario = new ArrayList<>();
		int ID = 0;
		AplicacionEspecializadaDTO objAppEsp = new AplicacionEspecializadaDTO();
		/* FIN */
		
		ModelAndView model = new ModelAndView("consultaGeneral");

		try
		{
		
		/* ID USUARIO */
		userID.setMatricula(request.getParameter("usuarioSession"));
		listausuario = usuarioDAO.getInstancia().retornaID(userID);
		Iterator<usuario> list = listausuario.iterator();
		while (list.hasNext()) {
			usuario iuserID = list.next();
			ID = iuserID.getIdusuario();
		}
		/* Asignacion de usuario */
		ae.setUsuarioCreacion(ID);
		
		
		if(request.getParameter("motivoCreacionAplicacion") =="")
		{
			ae.setIdMotivoCreacion(-99);
			}
		else
		{
			ae.setIdMotivoCreacion(Integer.parseInt(request.getParameter("motivoCreacionAplicacion")));
			}
		
		
		
		listaID = AplicacionEspecializadaDAO.getInstancia().retornaID(ae);
		Iterator<AplicacionEspecializada> listID = listaID.iterator();
		while (listID.hasNext()) {
			AplicacionEspecializada ids = listID.next();

			objAppEsp.setIdAplicacionEspecializada(ids.getIdAplicacionEspecializada());
			objAppEsp.setIdVersion(ids.getIdVersion());
		}
		
		/** ESTRUCTURA ORGANIZACIONAL **/
		objAppEsp.setIdGerenciaCentral(Integer.parseInt(request.getParameter("gerenciaCentral")));
		if(request.getParameter("division") =="")
		{
			objAppEsp.setIdDivision(-99);
		}
		else
		{
			objAppEsp.setIdDivision(Integer.parseInt(request.getParameter("division")));
		}
		
		if(request.getParameter("area")=="")
		{
			objAppEsp.setIdArea(-99);
		}
		else
		{
			objAppEsp.setIdArea(Integer.parseInt(request.getParameter("area")));
		}
		
		if(request.getParameter("unidad")=="")
		{
			objAppEsp.setIdUnidad(-99);
		}
		else
		{
			objAppEsp.setIdUnidad(Integer.parseInt(request.getParameter("unidad")));
		}
		
		objAppEsp.setCodigoFNA(request.getParameter("codigoFNA"));
		objAppEsp.setCodigoAplicacionEspecializada(request.getParameter("codigoAplicacion"));

		/** INFORMACION GENERAL **/
		objAppEsp.setNombreAplicacionNOIT(request.getParameter("nombreAplicacionNOIT"));
		objAppEsp.setDescripcionAplicacion(request.getParameter("descripcionAplicacion"));
		objAppEsp.setFuncionalidadesAplicacion(request.getParameter("funcionalidadesAplicacion"));
		objAppEsp.setFechaCreacionAplicacion(request.getParameter("fechaCreacionAplicacion"));
		if(request.getParameter("estadoAplicacion")=="")
		{
			objAppEsp.setIdEstadoAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdEstadoAplicacion(Integer.parseInt(request.getParameter("estadoAplicacion")));
		}
		
		
		if(request.getParameter("tipoOperacionProceso") =="")
		{
			objAppEsp.setIdTipoOperacionProceso(-99);
		}
		else
		{
			objAppEsp.setIdTipoOperacionProceso(Integer.parseInt(request.getParameter("tipoOperacionProceso")));
		}
		
		
		if(request.getParameter("frecuenciaOperaciones")=="")
		{
		objAppEsp.setIdFrecuenciaOperaciones(-99);
		}
		else
		{
			objAppEsp.setIdFrecuenciaOperaciones(Integer.parseInt(request.getParameter("frecuenciaOperaciones")));
		}
		if(request.getParameter("cantidadOperaciones") =="")
		{objAppEsp.setIdCantidadOperaciones(-99);}
		else
		{objAppEsp.setIdCantidadOperaciones(Integer.parseInt(request.getParameter("cantidadOperaciones")));}
		
		
		if(request.getParameter("nroEntidadesInternas") ==  "")
		{
		objAppEsp.setNroEntidadesInternas(-99);
		}
		else
		{	
			objAppEsp.setNroEntidadesInternas(Integer.parseInt(request.getParameter("nroEntidadesInternas")));
		}
		
		if(request.getParameter("motivoCreacionAplicacion") =="")
		{
			objAppEsp.setIdMotivoCreacionAplicacion(-99);
			}
		else
		{
			objAppEsp.setIdMotivoCreacionAplicacion(Integer.parseInt(request.getParameter("motivoCreacionAplicacion")));
			}
		
		
		objAppEsp.setMotivoCreacionAplicacionOtros(request.getParameter("motivoCreacionAplicacionOtros"));
		if(request.getParameter("nroFuncionalidadesTransacciones") ==  "")
		{
		objAppEsp.setNroFuncionalidadesTransacciones(-99);
		}
		else
		{
			objAppEsp.setNroFuncionalidadesTransacciones(Integer.parseInt(request.getParameter("nroFuncionalidadesTransacciones")));
		}
		if(request.getParameter("nroReportes") ==  "")
		{
		objAppEsp.setNroReportes(-99);
		}
		else
		{
			objAppEsp.setNroReportes(Integer.parseInt(request.getParameter("nroReportes")));
		}
		if(request.getParameter("nroConsultas") ==  "")
		{
		objAppEsp.setNroConsultas(-99);
		}
		else
		{
			objAppEsp.setNroConsultas(Integer.parseInt(request.getParameter("nroConsultas")));
		}
		if(request.getParameter("nroEntidadesExternas") ==  "")
		{
		objAppEsp.setNroEntidadesExternas(-99);
		}
		else
		{
			objAppEsp.setNroEntidadesExternas(Integer.parseInt(request.getParameter("nroEntidadesExternas")));
		}
		objAppEsp.setObservacionesGenerales(request.getParameter("observacionesGenerales"));

		/** FUNCIONALIDAD **/
		objAppEsp.setFuncionalidad(request.getParameter("funcionalidad"));
		objAppEsp.setDatosEntrada(request.getParameter("datosEntrada"));
		objAppEsp.setProceso(request.getParameter("proceso"));
		objAppEsp.setSalida(request.getParameter("salida"));

		/** DOMINIO **/
		objAppEsp.setFrontUserLiderUsuario(request.getParameter("frontUserLiderUsuario"));
		objAppEsp.setGestorAplicaciones(request.getParameter("gestorAplicaciones"));
		objAppEsp.setEspecialistaAplicaciones(request.getParameter("especialistaAplicaciones"));
		objAppEsp.setBrokerSistemas(request.getParameter("brokerSistemas"));
		objAppEsp.setBrokerNegocios(request.getParameter("brokerNegocios"));
		objAppEsp.setAsesorGUTI(request.getParameter("asesorGUTI"));
		objAppEsp.setArquitectoDominio(request.getParameter("arquitectoDominio"));
		if(request.getParameter("entidadesUsuarias") =="")
		{objAppEsp.setIdEntidadesUsuarias(-99);}
		else
		{objAppEsp.setIdEntidadesUsuarias(Integer.parseInt(request.getParameter("entidadesUsuarias")));}
		
		
		if(request.getParameter("dominio")=="")
		{
			objAppEsp.setIdDominio(-99);
		}
		else
		{
			objAppEsp.setIdDominio(Integer.parseInt(request.getParameter("dominio")));
		}
		
		if(request.getParameter("nroUnidadesUtilizanAplicacion") =="")
		{
			objAppEsp.setNroUnidadesUtilizanAplicacion(-99);
		}
		else
		{
			objAppEsp.setNroUnidadesUtilizanAplicacion(Integer.parseInt(request.getParameter("nroUnidadesUtilizanAplicacion")));
		}
		
		if(request.getParameter("cantidadUsuariosAplicacionTotal") =="")
		{
			objAppEsp.setIdCantidadUsuariosAplicacionTotal(-99);
		}
		else
		{
			objAppEsp.setIdCantidadUsuariosAplicacionTotal(Integer.parseInt(request.getParameter("cantidadUsuariosAplicacionTotal")));
		}
		
		if(request.getParameter("subDominio")=="")
		{
			objAppEsp.setIdSubDominio(-99);
		}
		else
		{
			objAppEsp.setIdSubDominio(Integer.parseInt(request.getParameter("subDominio")));
		}
		
		
		objAppEsp.setNombreUnidad1(request.getParameter("nombreUnidad1"));
		objAppEsp.setNombreUnidad2(request.getParameter("nombreUnidad2"));
		objAppEsp.setNombreUnidad3(request.getParameter("nombreUnidad3"));
		if(request.getParameter("procesoAuditoriaD") =="")
		{
			objAppEsp.setIdProcesoAuditoria(-99);
		}
		else
		{
			objAppEsp.setIdProcesoAuditoria(Integer.parseInt(request.getParameter("procesoAuditoriaD")));
		}
		
		//objAppEsp.setProcesoAuditoria(request.getParameter("procesoAuditoriaD"));
		objAppEsp.setProcesoAuditoriaOtros(request.getParameter("procesoAuditoriaOtros"));
		
		System.out.println("dominio toca proceso clave := " + request.getParameter("dominioTocaProcesoClave"));
		
		if(request.getParameter("dominioTocaProcesoClave")=="")
		{objAppEsp.setIdImpactaProcesoClave(0);}
		else
		{objAppEsp.setIdImpactaProcesoClave(Integer.parseInt(request.getParameter("dominioTocaProcesoClave")));}
		
		
		
		//objAppEsp.setIdProcesoClave(request.getParameter("dominioProcesoClave"));
		System.out.println("dominio proceso clave := " + request.getParameter("dominioProcesoClave"));
		
		if(request.getParameter("dominioProcesoClave") =="" || request.getParameter("dominioProcesoClave") ==null)
		{
			objAppEsp.setIdDomProcesoClave(-99);
			}
		else
		{
			objAppEsp.setIdDomProcesoClave(Integer.parseInt(request.getParameter("dominioProcesoClave")));
			}
		
		
		
		objAppEsp.setNombreProcesoClaveOtros(request.getParameter("nombreProcesoClaveOtros"));
		
		if(request.getParameter("actividadDominio") =="")
		{
			objAppEsp.setActividadDominio(-99);
			}
		else
		{
			objAppEsp.setActividadDominio(Integer.parseInt(request.getParameter("actividadDominio")));
			}
		
		
		objAppEsp.setRelacionConCIF(request.getParameter("relacionConCIF"));

		/** CLASIFICACION DE ACTIVOS **/
		if(request.getParameter("confidencialidad") =="")
		{
			objAppEsp.setIdConfidencialidad(-99);
		}
		else
		{
			objAppEsp.setIdConfidencialidad(Integer.parseInt(request.getParameter("confidencialidad")));
		}
	
		if(request.getParameter("integridad")=="")
		{
			objAppEsp.setIdIntegridad(-99);
		}
		else
		{
			objAppEsp.setIdIntegridad(Integer.parseInt(request.getParameter("integridad")));
		}
	
		if(request.getParameter("disponibilidad")=="")
		{
			objAppEsp.setIdDisponibilidad(-99);
		}
		else
		{
			objAppEsp.setIdDisponibilidad(Integer.parseInt(request.getParameter("disponibilidad")));
		}
		
		if(request.getParameter("privacidad")=="")
		{
			objAppEsp.setIdPrivacidad(-99);
		}
		else
		{
			objAppEsp.setIdPrivacidad(Integer.parseInt(request.getParameter("privacidad")));
		}
		
		if(request.getParameter("clasificacion")=="")
		{
			objAppEsp.setIdClasificacion(-99);
		}
		else
		{
			objAppEsp.setIdClasificacion(Integer.parseInt(request.getParameter("clasificacion")));
		}
		
			objAppEsp.setClasificacionActivosObservacion(request.getParameter("clasificacionActivosObservacion"));
	
		
		if(request.getParameter("criticidadfinal")=="")
		{
			objAppEsp.setIdCriticidadFinal(-99);
		}
		else
		{
			objAppEsp.setIdCriticidadFinal(Integer.parseInt(request.getParameter("criticidadfinal")));
		}
		
		if(request.getParameter("estadoRevisionAplicaciones")=="")
		{
			objAppEsp.setIdEstadoRevisionAplicaciones(-99);
		}
		else
		{
			objAppEsp.setIdEstadoRevisionAplicaciones(Integer.parseInt(request.getParameter("estadoRevisionAplicaciones")));
		}
		
		

		/** CARACTERISTICAS TECNICAS **/
		
		if(request.getParameter("idCategoriaTecnologica") =="")
		{
		objAppEsp.setIdCategoriaTecnologica(-99);
		}
		else
		{
			objAppEsp.setIdCategoriaTecnologica(Integer.parseInt(request.getParameter("idCategoriaTecnologica")));
			
		}
		objAppEsp.setCategoriaTecnologicaOtros(request.getParameter("categoriaTecnologicaOtros"));
		if(request.getParameter("tipoDesarrollo") =="")
		{
			objAppEsp.setIdTiposDesarrollo(-99);
		}
		else
		{
			objAppEsp.setIdTiposDesarrollo(Integer.parseInt(request.getParameter("tipoDesarrollo")));
		}
		
		if(request.getParameter("idUbicacionFisica") =="")
		{
			objAppEsp.setIdUbicacionFisica(-99);
		}
		else
		{
			objAppEsp.setIdUbicacionFisica(Integer.parseInt(request.getParameter("idUbicacionFisica")));
		}
		
		if(request.getParameter("idAmbienteAppNOIT")=="")
		{
			objAppEsp.setIdAmbienteAppNOIT(-99);
		}
		else
		{
			objAppEsp.setIdAmbienteAppNOIT(Integer.parseInt(request.getParameter("idAmbienteAppNOIT")));
		}
		
		
		objAppEsp.setAmbienteAppNOITOtros(request.getParameter("ambienteAppNOITOtros"));
		objAppEsp.setNombreUbicacion(request.getParameter("nombreUbicacion"));
		if(request.getParameter("idInfraestructuraAplicacion") =="")
		{objAppEsp.setIdInfraestructuraAplicacion(-99);}
		else
		{objAppEsp.setIdInfraestructuraAplicacion(Integer.parseInt(request.getParameter("idInfraestructuraAplicacion")));}
		
		if(request.getParameter("esSolucionStandAlone") =="")
		{
			objAppEsp.setEsSolucionStandAlone(-99);
		}
		else
		{
			objAppEsp.setEsSolucionStandAlone(Integer.parseInt(request.getParameter("esSolucionStandAlone")));
		}
		
		
		if(request.getParameter("nroInterfacesConOtrasApp") ==  "")
		{
		objAppEsp.setNroInterfacesConOtrasApp(-99);
		}
		else
		{
			objAppEsp.setNroInterfacesConOtrasApp(Integer.parseInt(request.getParameter("nroInterfacesConOtrasApp")));
		}
		objAppEsp.setNombresInterfaces(request.getParameter("nombresInterfaces"));
		
		if(request.getParameter("idMantenimientoAplicacion") =="")
		{
			objAppEsp.setIdMantenimientoAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdMantenimientoAplicacion(Integer.parseInt(request.getParameter("idMantenimientoAplicacion")));
		}
		
		
		objAppEsp.setMantenimientoNombreProveedor(request.getParameter("mantenimientoNombreProveedor"));
		
		if(request.getParameter("idSoporteAplicacion") =="")
		{
			objAppEsp.setIdSoporteAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdSoporteAplicacion(Integer.parseInt(request.getParameter("idSoporteAplicacion")));
		}
		
		
		objAppEsp.setSoporteNombrePorveedor(request.getParameter("soporteNombrePorveedor"));
		if(request.getParameter("idAcessosAplicacion") == "")
		{
			objAppEsp.setIdAcessosAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdAcessosAplicacion(Integer.parseInt(request.getParameter("idAcessosAplicacion")));	
		}
		
		objAppEsp.setAccesosNombreProveedor(request.getParameter("accesosNombreProveedor"));
		objAppEsp.setNombreServidor(request.getParameter("nombreServidor"));
		objAppEsp.setUbicacionServidor(request.getParameter("ubicacionServidor"));

		/** DATAMART **/
		objAppEsp.setNombreDatamart(request.getParameter("nombreDatamart"));
		if(request.getParameter("cantidadTablas") == "")
		{
			objAppEsp.setCantidadTablas(-99);
		}
		else
		{
			objAppEsp.setCantidadTablas(Integer.parseInt(request.getParameter("cantidadTablas")));
		}
		
		if(request.getParameter("cantidadTablasDescriptivas") =="")
		{
			objAppEsp.setCantidadTablasDescriptivas(-99);
		}
		else
		{
			objAppEsp.setCantidadTablasDescriptivas(Integer.parseInt(request.getParameter("cantidadTablasDescriptivas")));
		}
		
		if(request.getParameter("cantidadTablasHechos")=="")
		{
			objAppEsp.setCantidadTablasHechos(-99);
		}
		else
		{
			objAppEsp.setCantidadTablasHechos(Integer.parseInt(request.getParameter("cantidadTablasHechos")));
		}
		
		if(request.getParameter("idHerramientaExplotacionDatos") =="")
		{objAppEsp.setIdHerramientaExplotacionDatos(-99);}
		else
		{objAppEsp.setIdHerramientaExplotacionDatos(Integer.parseInt(request.getParameter("idHerramientaExplotacionDatos")));}
		
		
		objAppEsp.setHerramientaExplotacionDatosOtros(request.getParameter("herramientaExplotacionDatosOtros"));
		
		if(request.getParameter("cantidadReportes") =="")
		{
			objAppEsp.setCantidadReportes(-99);
		}
		else
		{
			objAppEsp.setCantidadReportes(Integer.parseInt(request.getParameter("cantidadReportes")));
		}
		
		if(request.getParameter("cantidadUsuarios")=="")
		{
			objAppEsp.setCantidadUsuarios(-99);
		}
		else
		{
			objAppEsp.setCantidadUsuarios(Integer.parseInt(request.getParameter("cantidadUsuarios")));
		}
		
		
		objAppEsp.setFrecuencia(request.getParameter("frecuencia"));
		
		objAppEsp.setCantidadEspacioTablespace(request.getParameter("cantidadEspacioTablespace"));

		/** IMPACTOS **/
	
		objAppEsp.setImpactoFinanciero(request.getParameter("impactoFinanciero"));
		objAppEsp.setRentabilidad(request.getParameter("rentabilidad"));
		objAppEsp.setImpactoImagen(request.getParameter("impactoImagen"));
		objAppEsp.setImpactoClientes(request.getParameter("impactoClientes"));
		objAppEsp.setImpactoOperativo(request.getParameter("impactoOperativo"));
		objAppEsp.setImpactoLegal(request.getParameter("impactoLegal"));
		
		if(request.getParameter("idProcesoAuditoriaI") =="")
		{objAppEsp.setIdProcesoAuditoriaI(-99);}
		else
		{objAppEsp.setIdProcesoAuditoriaI(Integer.parseInt(request.getParameter("idProcesoAuditoriaI")));}
		
	//	objAppEsp.setIdTocaProcesoClave(request.getParameter("impactoTocaProcesoClave"));
		
		if(request.getParameter("impactoTocaProcesoClave")=="")
		{objAppEsp.setIdTocaProcesoClave(0);}
		else
		{objAppEsp.setIdTocaProcesoClave(Integer.parseInt(request.getParameter("impactoTocaProcesoClave")));}
		
		
		
		//objAppEsp.setIndicarProcesoClave(request.getParameter("impactoIndicarProcesoClave"));
		
		if(request.getParameter("impactoIndicarProcesoClave") =="" || request.getParameter("impactoIndicarProcesoClave") ==null)
		{
			objAppEsp.setIdImpProcesoClave(-99);
			}
		else
		{
			objAppEsp.setIdImpProcesoClave(Integer.parseInt(request.getParameter("impactoIndicarProcesoClave")));
			}
		
		
		objAppEsp.setOtrosProcesoClave(request.getParameter("otrosImpactoProcesoClave"));
		
		if(request.getParameter("actividadImpacto") =="")
		{objAppEsp.setActividadImpacto(-99);}
		else
		{objAppEsp.setActividadImpacto(Integer.parseInt(request.getParameter("actividadImpacto")));}
		
		
		
		objAppEsp.setCategoriaTecnologica(request.getParameter("categoriaTecnologica"));
		objAppEsp.setNivel_criticidad(request.getParameter("nivelCriticidad"));

		/** ROADMAP **/
		objAppEsp.setRoadmapCortoPlazo(request.getParameter("roadmapCortoPlazo"));
		objAppEsp.setRoadmapLargoPlazo(request.getParameter("roadmapLargoPlazo"));
		if(request.getParameter("idEstadoAtencionRoadmap") =="")
		{
			objAppEsp.setIdEstadoAtencionRoadmap(-99);
		}
		else
		{
			objAppEsp.setIdEstadoAtencionRoadmap(Integer.parseInt(request.getParameter("idEstadoAtencionRoadmap")));
		}
		
		// objAppEsp.setIdEtapaAtencionRoadmap(Integer.parseInt(request.getParameter("idEtapaAtencionRoadmap")));
		if(request.getParameter("fechaInicioPlanificado") == "")
		{
			objAppEsp.setFechaInicioPlanificado("2000-01-01");
		}
		else
		{
			objAppEsp.setFechaInicioPlanificado(request.getParameter("fechaInicioPlanificado"));
		}
		
		if(request.getParameter("fechaCompromiso") =="")
		{
			objAppEsp.setFechaCompromiso("2000-01-01");
		}
		else
		{
			objAppEsp.setFechaCompromiso(request.getParameter("fechaCompromiso"));
		}
		
		
		objAppEsp.setRoadmapEjecutadoActual(request.getParameter("roadmapEjecutadoActual"));

		/** PRE ATENCION **/
		if(request.getParameter("idSwBaseEstandarSistemaOperativoPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarSistemaOperativoPRE")));
		}
		
		objAppEsp.setSwBaseSistemaOperativoOtrosPRE(request.getParameter("swBaseSistemaOperativoOtrosPRE"));
		
		if(request.getParameter("idSwBaseEstandarHeramientaProgramacionPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarHeramientaProgramacionPRE")));
		}
		
		objAppEsp.setSwBaseHerramientaProgramacionOtrosPRE(request.getParameter("swBaseHerramientaProgramacionOtrosPRE"));
		
		if(request.getParameter("idSwBaseEstandarLenguajeProgramacionPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarLenguajeProgramacionPRE")));
		}
		
		objAppEsp.setSwBaseLenguajeProgramacionOtrosPRE(request.getParameter("swBaseLenguajeProgramacionOtrosPRE"));
		
		if(request.getParameter("idSwBaseEstandarGestorBDPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarGestorBDPRE")));
		}
		
		objAppEsp.setSwBaseGestorBDOtrosPRE(request.getParameter("swBaseGestorBDOtrosPRE"));
		if(request.getParameter("idSwBaseEstandarFrameworkPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarFrameworkPRE")));
		}
		
		/****/
		objAppEsp.setSwBaseFrameworkOtrosPRE(request.getParameter("swBaseFrameworkOtrosPRE"));
		objAppEsp.setSwBaseObservacionesAdicionalesPRE(request.getParameter("swBaseObservacionesAdicionalesPRE"));
		if(request.getParameter("idAccesosGestionPrivilegiosSistemasPRE")=="")
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPRE(Integer.parseInt(request.getParameter("idAccesosGestionPrivilegiosSistemasPRE")));
		}
		
		if(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPRE")=="")
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPRE(Integer.parseInt(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPRE")));
		}
		
		if(request.getParameter("idAccesosGestionContrasenasPRE")=="")
		{
			objAppEsp.setIdAccesosGestionContrasenasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionContrasenasPRE(Integer.parseInt(request.getParameter("idAccesosGestionContrasenasPRE")));
		}
		
		if(request.getParameter("idAccesosPoliticaContrasenasPRE")=="")
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPRE(Integer.parseInt(request.getParameter("idAccesosPoliticaContrasenasPRE")));
		}
		
		if(request.getParameter("idAccesosGestionClaves1PRE")=="")
		{
			objAppEsp.setIdAccesosGestionClaves1PRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves1PRE(Integer.parseInt(request.getParameter("idAccesosGestionClaves1PRE")));
		}
		
		if(request.getParameter("idAccesosGestionClaves2PRE")=="")
		{
			objAppEsp.setIdAccesosGestionClaves2PRE(-99);	
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves2PRE(Integer.parseInt(request.getParameter("idAccesosGestionClaves2PRE")));
		}
	
		if(request.getParameter("idAccesosGestionClaves3PRE")=="")
		{
			objAppEsp.setIdAccesosGestionClaves3PRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves3PRE(Integer.parseInt(request.getParameter("idAccesosGestionClaves3PRE")));
		}
		
		if(request.getParameter("idAuditoriaRegistroAuditoriaPRE")=="")
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPRE(Integer.parseInt(request.getParameter("idAuditoriaRegistroAuditoriaPRE")));
		}
		
		if(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPRE")=="")
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPRE(Integer.parseInt(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPRE")));
		}
		
		if(request.getParameter("idAuditoriaRegistroEventosAdministradoresPRE")=="")
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPRE(Integer.parseInt(request.getParameter("idAuditoriaRegistroEventosAdministradoresPRE")));
		}
		
		if(request.getParameter("idAuditoriaConformidadPoliticasPRE")=="")
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPRE(Integer.parseInt(request.getParameter("idAuditoriaConformidadPoliticasPRE")));
		}
		
		if(request.getParameter("idContingenciaPRE")=="")
		{
			objAppEsp.setIdContingenciaPRE(-99);
		}
		else
		{
			objAppEsp.setIdContingenciaPRE(Integer.parseInt(request.getParameter("idContingenciaPRE")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosSwPRE")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPRE(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPRE(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosSwPRE")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosInfraestructuraPRE")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPRE(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPRE(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosInfraestructuraPRE")));
		}
		
		if(request.getParameter("idDocumentacionManejoPRE")=="")
		{
			objAppEsp.setIdDocumentacionManejoPRE(-99);
		}
		else
		{
			objAppEsp.setIdDocumentacionManejoPRE(Integer.parseInt(request.getParameter("idDocumentacionManejoPRE")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPRE")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPRE(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPRE(Integer.parseInt(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPRE")));
		}
	
		if(request.getParameter("idIncidentesCumplimientoGestionParchesPRE")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPRE(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPRE(Integer.parseInt(request.getParameter("idIncidentesCumplimientoGestionParchesPRE")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPRE")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPRE(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPRE(Integer.parseInt(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPRE")));
		}
		
		if(request.getParameter("idIntegridadConfidencialidadDatosPruebaPRE")=="")
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPRE(-99);
		}
		else
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPRE(Integer.parseInt(request.getParameter("idIntegridadConfidencialidadDatosPruebaPRE")));
		}
		
		if(request.getParameter("idRespaldosGestionRespaldoRecuperacionPRE")=="")
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPRE(-99);
		}
		else
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPRE(Integer.parseInt(request.getParameter("idRespaldosGestionRespaldoRecuperacionPRE")));
		}
		

		/** POST ATENCION **/

		if(request.getParameter("idSwBaseEstandarSistemaOperativoPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarSistemaOperativoPOST")));
		}
		
		objAppEsp.setSwBaseSistemaOperativoOtrosPOST(request.getParameter("swBaseSistemaOperativoOtrosPOST"));
		
		if(request.getParameter("idSwBaseEstandarHeramientaProgramacionPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarHeramientaProgramacionPOST")));
		}
		
		objAppEsp.setSwBaseHerramientaProgramacionOtrosPOST(request.getParameter("swBaseHerramientaProgramacionOtrosPOST"));
		
		if(request.getParameter("idSwBaseEstandarLenguajeProgramacionPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarLenguajeProgramacionPOST")));
		}
		
		objAppEsp.setSwBaseLenguajeProgramacionOtrosPOST(request.getParameter("swBaseLenguajeProgramacionOtrosPOST"));
		
		if(request.getParameter("idSwBaseEstandarGestorBDPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarGestorBDPOST")));
		}
		
		objAppEsp.setSwBaseGestorBDOtrosPOST(request.getParameter("swBaseGestorBDOtrosPOST"));
		if(request.getParameter("idSwBaseEstandarFrameworkPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarFrameworkPOST")));
		}
		
		/****/
		objAppEsp.setSwBaseFrameworkOtrosPOST(request.getParameter("swBaseFrameworkOtrosPOST"));
		objAppEsp.setSwBaseObservacionesAdicionalesPOST(request.getParameter("swBaseObservacionesAdicionalesPOST"));
		if(request.getParameter("idAccesosGestionPrivilegiosSistemasPOST")=="")
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPOST(Integer.parseInt(request.getParameter("idAccesosGestionPrivilegiosSistemasPOST")));
		}
		
		if(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPOST")=="")
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPOST(Integer.parseInt(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPOST")));
		}
		
		if(request.getParameter("idAccesosGestionContrasenasPOST")=="")
		{
			objAppEsp.setIdAccesosGestionContrasenasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionContrasenasPOST(Integer.parseInt(request.getParameter("idAccesosGestionContrasenasPOST")));
		}
		
		if(request.getParameter("idAccesosPoliticaContrasenasPOST")=="")
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPOST(Integer.parseInt(request.getParameter("idAccesosPoliticaContrasenasPOST")));
		}
		
		if(request.getParameter("idAccesosGestionClaves1POST")=="")
		{
			objAppEsp.setIdAccesosGestionClaves1POST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves1POST(Integer.parseInt(request.getParameter("idAccesosGestionClaves1POST")));
		}
		
		if(request.getParameter("idAccesosGestionClaves2POST")=="")
		{
			objAppEsp.setIdAccesosGestionClaves2POST(-99);	
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves2POST(Integer.parseInt(request.getParameter("idAccesosGestionClaves2POST")));
		}
	
		if(request.getParameter("idAccesosGestionClaves3POST")=="")
		{
			objAppEsp.setIdAccesosGestionClaves3POST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves3POST(Integer.parseInt(request.getParameter("idAccesosGestionClaves3POST")));
		}
		
		if(request.getParameter("idAuditoriaRegistroAuditoriaPOST")=="")
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPOST(Integer.parseInt(request.getParameter("idAuditoriaRegistroAuditoriaPOST")));
		}
		
		if(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPOST")=="")
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPOST(Integer.parseInt(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPOST")));
		}
		
		if(request.getParameter("idAuditoriaRegistroEventosAdministradoresPOST")=="")
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPOST(Integer.parseInt(request.getParameter("idAuditoriaRegistroEventosAdministradoresPOST")));
		}
		
		if(request.getParameter("idAuditoriaConformidadPoliticasPOST")=="")
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPOST(Integer.parseInt(request.getParameter("idAuditoriaConformidadPoliticasPOST")));
		}
		
		if(request.getParameter("idContingenciaPOST")=="")
		{
			objAppEsp.setIdContingenciaPOST(-99);
		}
		else
		{
			objAppEsp.setIdContingenciaPOST(Integer.parseInt(request.getParameter("idContingenciaPOST")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosSwPOST")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPOST(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPOST(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosSwPOST")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosInfraestructuraPOST")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPOST(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPOST(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosInfraestructuraPOST")));
		}
		
		if(request.getParameter("idDocumentacionManejoPOST")=="")
		{
			objAppEsp.setIdDocumentacionManejoPOST(-99);
		}
		else
		{
			objAppEsp.setIdDocumentacionManejoPOST(Integer.parseInt(request.getParameter("idDocumentacionManejoPOST")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPOST")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPOST(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPOST(Integer.parseInt(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPOST")));
		}
	
		if(request.getParameter("idIncidentesCumplimientoGestionParchesPOST")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPOST(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPOST(Integer.parseInt(request.getParameter("idIncidentesCumplimientoGestionParchesPOST")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPOST")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPOST(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPOST(Integer.parseInt(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPOST")));
		}
		
		if(request.getParameter("idIntegridadConfidencialidadDatosPruebaPOST")=="")
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPOST(-99);
		}
		else
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPOST(Integer.parseInt(request.getParameter("idIntegridadConfidencialidadDatosPruebaPOST")));
		}
		
		if(request.getParameter("idRespaldosGestionRespaldoRecuperacionPOST")=="")
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPOST(-99);
		}
		else
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPOST(Integer.parseInt(request.getParameter("idRespaldosGestionRespaldoRecuperacionPOST")));
		}

		/** INFORMACION ADICIONAL **/

		objAppEsp.setEvaluacionSeguridadInformatica(request.getParameter("evaluacionSeguridadInformatica"));
		objAppEsp.setSeguridadNivelExposicion(request.getParameter("seguridadNivelExposicion"));

		if(request.getParameter("idEscenarioLogueo")=="")
		{objAppEsp.setIdEscenarioLogueo(-99);}
		else
		{objAppEsp.setIdEscenarioLogueo(Integer.parseInt(request.getParameter("idEscenarioLogueo")));}
		
		if(request.getParameter("idImpactoProteccionDatos") =="")
		{objAppEsp.setIdImpactoProteccionDatos(-99);}
		else
		{objAppEsp.setIdImpactoProteccionDatos(Integer.parseInt(request.getParameter("idImpactoProteccionDatos")));}
		
		if(request.getParameter("idImpactoProteccionDatosLevantamientoInformacion")=="")
		{objAppEsp.setIdImpactoProteccionDatosLevantamientoInformacion(-99);}
		else
		{objAppEsp.setIdImpactoProteccionDatosLevantamientoInformacion(Integer.parseInt(request.getParameter("idImpactoProteccionDatosLevantamientoInformacion")));}
		
		
		
		if(request.getParameter("idFuentePeriodo") =="")
		{objAppEsp.setIdFuentePeriodo(-99);}
		else
		{objAppEsp.setIdFuentePeriodo(Integer.parseInt(request.getParameter("idFuentePeriodo")));}
		
		
		objAppEsp.setDescripcionFuente(request.getParameter("descripcionFuente"));

		AplicacionEspecializadaDAO.getInstancia().ingresarAplicacionEspecializada(objAppEsp);
		//AppEspNivelCumplimientoDAO.getInstancia().ingresarNivelCumplimiento(objAppEsp);
		//AppEspNivelCumplimientoDAO.getInstancia().ingresarNivelCumplimientoPost(objAppEsp);

		
		message="Se registró correctamente";

		
		model.addObject("mesajeInfo", message);
		
		objeto.setPagina("insertarAplicacionesEspecializadas.jsp");
		objeto.setObjeto("");
		objeto.setTraza_error("");
		objeto.setTipo("Acceso");
		objeto.setIp(logAuditoria.obtenerIP());
		objeto.setUsuario(request.getParameter("usuarioActual"));
		objeto.setFecha(sdf.format(fecha));
		objeto.setHora(hourFormat.format(fecha));
		logAuditoria.guardarLogAuditoria(objeto);
		
		
		} catch (SQLException ex) {
		//model.addAttribute("mensaje", ex.getMessage());
			model.addObject("mensaje", ex.getMessage());
			
			//Registro log de auditoría
			objeto.setPagina("insertarAplicacionesEspecializadas.jsp");
			objeto.setObjeto("registrarAplicacionEspecializada");
			objeto.setTraza_error(ex.getMessage());
			System.out.println("mostrar pagina:= " + ex.getMessage());
			objeto.setTipo("Error");
			objeto.setIp(logAuditoria.obtenerIP());
			objeto.setUsuario(request.getParameter("usuarioActual"));
			objeto.setFecha(sdf.format(fecha));
			objeto.setHora(hourFormat.format(fecha));
			logAuditoria.guardarLogAuditoria(objeto);
			
		}
		
		
		
		
		return model;
	
		

	}

	@RequestMapping(value = { "/actualizar" }, method = RequestMethod.POST)
	public ModelAndView actualizarAplicacionEspecializada(HttpServletRequest request, ModelMap mod) throws Exception {
		LogAuditoriaController logAuditoria = new LogAuditoriaController();
		LogAuditoria objeto = new LogAuditoria();
		Date fecha = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		
		/* Objetos */
		AplicacionEspecializada ae = new AplicacionEspecializada();
		ArrayList<AplicacionEspecializada> listaIDVER = new ArrayList<AplicacionEspecializada>();
		listausuario = new ArrayList<>();
		int ID = 0;
		AplicacionEspecializadaDTO objAppEsp = new AplicacionEspecializadaDTO();
		/* FIN */
		ModelAndView model = new ModelAndView("consultaGeneral");
		try{
		/* ID USUARIO */
		userID.setMatricula(request.getParameter("usuarioT"));
		listausuario = usuarioDAO.getInstancia().retornaID(userID);
		Iterator<usuario> list = listausuario.iterator();
		while (list.hasNext()) {
			usuario iuserID = list.next();
			ID = iuserID.getIdusuario();
		}

		/* Asignacion de usuario */
		if(request.getParameter("motivoCreacionAplicacion") =="")
		{
			ae.setIdMotivoCreacion(-99);
			}
		else
		{
			ae.setIdMotivoCreacion(Integer.parseInt(request.getParameter("motivoCreacionAplicacion")));
			}
		ae.setUsuarioCreacion(ID);
		ae.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializada")));
		
		listaIDVER = AplicacionEspecializadaDAO.getInstancia().retornaIDVER(ae);
		
		
		
		Iterator<AplicacionEspecializada> listID = listaIDVER.iterator();
		while (listID.hasNext()) {
			AplicacionEspecializada ids = listID.next();		
			objAppEsp.setIdVersion(ids.getIdVersion());
		}
	
		objAppEsp.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializada")));
		
		
		
		/** ESTRUCTURA ORGANIZACIONAL **/
		objAppEsp.setIdGerenciaCentral(Integer.parseInt(request.getParameter("gerenciaCentral")));
		if(request.getParameter("division") =="")
		{
			objAppEsp.setIdDivision(-99);
		}
		else
		{
			objAppEsp.setIdDivision(Integer.parseInt(request.getParameter("division")));
		}
		
		if(request.getParameter("area")=="")
		{
			objAppEsp.setIdArea(-99);
		}
		else
		{
			objAppEsp.setIdArea(Integer.parseInt(request.getParameter("area")));
		}
		
		if(request.getParameter("unidad")=="")
		{
			objAppEsp.setIdUnidad(-99);
		}
		else
		{
			objAppEsp.setIdUnidad(Integer.parseInt(request.getParameter("unidad")));
		}
		
		objAppEsp.setCodigoFNA(request.getParameter("codigoFNA"));
		objAppEsp.setCodigoAplicacionEspecializada(request.getParameter("codigoAplicacion"));

		/** INFORMACION GENERAL **/
		objAppEsp.setNombreAplicacionNOIT(request.getParameter("nombreAplicacionNOIT"));
		objAppEsp.setDescripcionAplicacion(request.getParameter("descripcionAplicacion"));
		objAppEsp.setFuncionalidadesAplicacion(request.getParameter("funcionalidadesAplicacion"));
		objAppEsp.setFechaCreacionAplicacion(request.getParameter("fechaCreacionAplicacion"));
		if(request.getParameter("estadoAplicacion")=="")
		{
			objAppEsp.setIdEstadoAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdEstadoAplicacion(Integer.parseInt(request.getParameter("estadoAplicacion")));
		}
		
		
		if(request.getParameter("tipoOperacionProceso") =="")
		{
			objAppEsp.setIdTipoOperacionProceso(-99);
		}
		else
		{
			objAppEsp.setIdTipoOperacionProceso(Integer.parseInt(request.getParameter("tipoOperacionProceso")));
		}
		
		
		if(request.getParameter("frecuenciaOperaciones")=="")
		{
		objAppEsp.setIdFrecuenciaOperaciones(-99);
		}
		else
		{
			objAppEsp.setIdFrecuenciaOperaciones(Integer.parseInt(request.getParameter("frecuenciaOperaciones")));
		}
		if(request.getParameter("cantidadOperaciones") =="")
		{objAppEsp.setIdCantidadOperaciones(-99);}
		else
		{objAppEsp.setIdCantidadOperaciones(Integer.parseInt(request.getParameter("cantidadOperaciones")));}
		
		
		if(request.getParameter("nroEntidadesInternas") ==  "")
		{
		objAppEsp.setNroEntidadesInternas(-99);
		}
		else
		{	
			objAppEsp.setNroEntidadesInternas(Integer.parseInt(request.getParameter("nroEntidadesInternas")));
		}
		if(request.getParameter("motivoCreacionAplicacion") =="")
		{
			objAppEsp.setIdMotivoCreacionAplicacion(-99);
			}
		else
		{
			objAppEsp.setIdMotivoCreacionAplicacion(Integer.parseInt(request.getParameter("motivoCreacionAplicacion")));
			}
		
		
		objAppEsp.setMotivoCreacionAplicacionOtros(request.getParameter("motivoCreacionAplicacionOtros"));
		if(request.getParameter("nroFuncionalidadesTransacciones") ==  "")
		{
		objAppEsp.setNroFuncionalidadesTransacciones(-99);
		}
		else
		{
			objAppEsp.setNroFuncionalidadesTransacciones(Integer.parseInt(request.getParameter("nroFuncionalidadesTransacciones")));
		}
		if(request.getParameter("nroReportes") ==  "")
		{
		objAppEsp.setNroReportes(-99);
		}
		else
		{
			objAppEsp.setNroReportes(Integer.parseInt(request.getParameter("nroReportes")));
		}
		if(request.getParameter("nroConsultas") ==  "")
		{
		objAppEsp.setNroConsultas(-99);
		}
		else
		{
			objAppEsp.setNroConsultas(Integer.parseInt(request.getParameter("nroConsultas")));
		}
		if(request.getParameter("nroEntidadesExternas") ==  "")
		{
		objAppEsp.setNroEntidadesExternas(-99);
		}
		else
		{
			objAppEsp.setNroEntidadesExternas(Integer.parseInt(request.getParameter("nroEntidadesExternas")));
		}
		objAppEsp.setObservacionesGenerales(request.getParameter("observacionesGenerales"));

		/** FUNCIONALIDAD **/
		objAppEsp.setFuncionalidad(request.getParameter("funcionalidad"));
		objAppEsp.setDatosEntrada(request.getParameter("datosEntrada"));
		objAppEsp.setProceso(request.getParameter("proceso"));
		objAppEsp.setSalida(request.getParameter("salida"));

		/** DOMINIO **/
		objAppEsp.setFrontUserLiderUsuario(request.getParameter("frontUserLiderUsuario"));
		objAppEsp.setGestorAplicaciones(request.getParameter("gestorAplicaciones"));
		objAppEsp.setEspecialistaAplicaciones(request.getParameter("especialistaAplicaciones"));
		objAppEsp.setBrokerSistemas(request.getParameter("brokerSistemas"));
		objAppEsp.setBrokerNegocios(request.getParameter("brokerNegocios"));
		objAppEsp.setAsesorGUTI(request.getParameter("asesorGUTI"));
		objAppEsp.setArquitectoDominio(request.getParameter("arquitectoDominio"));
		if(request.getParameter("entidadesUsuarias") =="")
		{objAppEsp.setIdEntidadesUsuarias(-99);}
		else
		{objAppEsp.setIdEntidadesUsuarias(Integer.parseInt(request.getParameter("entidadesUsuarias")));}
		
		
		if(request.getParameter("dominio")=="")
		{
			objAppEsp.setIdDominio(-99);
		}
		else
		{
			objAppEsp.setIdDominio(Integer.parseInt(request.getParameter("dominio")));
		}
		
		if(request.getParameter("nroUnidadesUtilizanAplicacion") =="")
		{
			objAppEsp.setNroUnidadesUtilizanAplicacion(-99);
		}
		else
		{
			objAppEsp.setNroUnidadesUtilizanAplicacion(Integer.parseInt(request.getParameter("nroUnidadesUtilizanAplicacion")));
		}
		
		if(request.getParameter("cantidadUsuariosAplicacionTotal") =="")
		{
			objAppEsp.setIdCantidadUsuariosAplicacionTotal(-99);
		}
		else
		{
			objAppEsp.setIdCantidadUsuariosAplicacionTotal(Integer.parseInt(request.getParameter("cantidadUsuariosAplicacionTotal")));
		}
		
		if(request.getParameter("subDominio")=="")
		{
			objAppEsp.setIdSubDominio(-99);
		}
		else
		{
			objAppEsp.setIdSubDominio(Integer.parseInt(request.getParameter("subDominio")));
		}
		
		
		objAppEsp.setNombreUnidad1(request.getParameter("nombreUnidad1"));
		objAppEsp.setNombreUnidad2(request.getParameter("nombreUnidad2"));
		objAppEsp.setNombreUnidad3(request.getParameter("nombreUnidad3"));
		if(request.getParameter("procesoAuditoriaD") =="")
		{
			objAppEsp.setIdProcesoAuditoria(-99);
		}
		else
		{
			objAppEsp.setIdProcesoAuditoria(Integer.parseInt(request.getParameter("procesoAuditoriaD")));
		}
		
		//objAppEsp.setProcesoAuditoria(request.getParameter("procesoAuditoriaD"));
		objAppEsp.setProcesoAuditoriaOtros(request.getParameter("procesoAuditoriaOtros"));
		
		//objAppEsp.setTocaProcesoClave(request.getParameter("dominioTocaProcesoClave"));
		if(request.getParameter("dominioTocaProcesoClave")=="")
		{objAppEsp.setIdImpactaProcesoClave(0);}
		else
		{objAppEsp.setIdImpactaProcesoClave(Integer.parseInt(request.getParameter("dominioTocaProcesoClave")));}
		
		
		//objAppEsp.setIdProcesoClave(request.getParameter("dominioProcesoClave"));
		
		if(request.getParameter("dominioProcesoClave") =="" || request.getParameter("dominioProcesoClave") ==null)
		{
			objAppEsp.setIdDomProcesoClave(-99);
			}
		else
		{
			objAppEsp.setIdDomProcesoClave(Integer.parseInt(request.getParameter("dominioProcesoClave")));
			}
		
		
		objAppEsp.setNombreProcesoClaveOtros(request.getParameter("nombreProcesoClaveOtros"));
		
		if(request.getParameter("actividadDominio") =="")
		{
			objAppEsp.setActividadDominio(-99);
			}
		else
		{
			objAppEsp.setActividadDominio(Integer.parseInt(request.getParameter("actividadDominio")));
			}
		
		
		objAppEsp.setRelacionConCIF(request.getParameter("relacionConCIF"));

		/** CLASIFICACION DE ACTIVOS **/
		if(request.getParameter("confidencialidad") =="")
		{
			objAppEsp.setIdConfidencialidad(-99);
		}
		else
		{
			objAppEsp.setIdConfidencialidad(Integer.parseInt(request.getParameter("confidencialidad")));
		}
	
		if(request.getParameter("integridad")=="")
		{
			objAppEsp.setIdIntegridad(-99);
		}
		else
		{
			objAppEsp.setIdIntegridad(Integer.parseInt(request.getParameter("integridad")));
		}
	
		if(request.getParameter("disponibilidad")=="")
		{
			objAppEsp.setIdDisponibilidad(-99);
		}
		else
		{
			objAppEsp.setIdDisponibilidad(Integer.parseInt(request.getParameter("disponibilidad")));
		}
		
		if(request.getParameter("privacidad")=="")
		{
			objAppEsp.setIdPrivacidad(-99);
		}
		else
		{
			objAppEsp.setIdPrivacidad(Integer.parseInt(request.getParameter("privacidad")));
		}
		
		if(request.getParameter("clasificacion")=="")
		{
			objAppEsp.setIdClasificacion(-99);
		}
		else
		{
			objAppEsp.setIdClasificacion(Integer.parseInt(request.getParameter("clasificacion")));
		}
		
			objAppEsp.setClasificacionActivosObservacion(request.getParameter("clasificacionActivosObservacion"));
	
		
		if(request.getParameter("criticidadfinal")=="")
		{
			objAppEsp.setIdCriticidadFinal(-99);
		}
		else
		{
			objAppEsp.setIdCriticidadFinal(Integer.parseInt(request.getParameter("criticidadfinal")));
		}
		
		if(request.getParameter("estadoRevisionAplicaciones")=="")
		{
			objAppEsp.setIdEstadoRevisionAplicaciones(-99);
		}
		else
		{
			objAppEsp.setIdEstadoRevisionAplicaciones(Integer.parseInt(request.getParameter("estadoRevisionAplicaciones")));
		}
		
		
		

		/** CARACTERISTICAS TECNICAS **/
		
		if(request.getParameter("idCategoriaTecnologica") =="")
		{
		objAppEsp.setIdCategoriaTecnologica(-99);
		}
		else
		{
			objAppEsp.setIdCategoriaTecnologica(Integer.parseInt(request.getParameter("idCategoriaTecnologica")));
			
		}
		objAppEsp.setCategoriaTecnologicaOtros(request.getParameter("categoriaTecnologicaOtros"));
		if(request.getParameter("tipoDesarrollo") =="")
		{
			objAppEsp.setIdTiposDesarrollo(-99);
		}
		else
		{
			objAppEsp.setIdTiposDesarrollo(Integer.parseInt(request.getParameter("tipoDesarrollo")));
		}
		
		if(request.getParameter("idUbicacionFisica") =="")
		{
			objAppEsp.setIdUbicacionFisica(-99);
		}
		else
		{
			objAppEsp.setIdUbicacionFisica(Integer.parseInt(request.getParameter("idUbicacionFisica")));
		}
		
		if(request.getParameter("idAmbienteAppNOIT")=="")
		{
			objAppEsp.setIdAmbienteAppNOIT(-99);
		}
		else
		{
			objAppEsp.setIdAmbienteAppNOIT(Integer.parseInt(request.getParameter("idAmbienteAppNOIT")));
		}
		
		
		objAppEsp.setAmbienteAppNOITOtros(request.getParameter("ambienteAppNOITOtros"));
		objAppEsp.setNombreUbicacion(request.getParameter("nombreUbicacion"));
		if(request.getParameter("idInfraestructuraAplicacion") =="")
		{objAppEsp.setIdInfraestructuraAplicacion(-99);}
		else
		{objAppEsp.setIdInfraestructuraAplicacion(Integer.parseInt(request.getParameter("idInfraestructuraAplicacion")));}
		
		if(request.getParameter("esSolucionStandAlone") =="")
		{
			objAppEsp.setEsSolucionStandAlone(-99);
		}
		else
		{
			objAppEsp.setEsSolucionStandAlone(Integer.parseInt(request.getParameter("esSolucionStandAlone")));
		}
		
		
		if(request.getParameter("nroInterfacesConOtrasApp") ==  "")
		{
		objAppEsp.setNroInterfacesConOtrasApp(-99);
		}
		else
		{
			objAppEsp.setNroInterfacesConOtrasApp(Integer.parseInt(request.getParameter("nroInterfacesConOtrasApp")));
		}
		objAppEsp.setNombresInterfaces(request.getParameter("nombresInterfaces"));
		
		if(request.getParameter("idMantenimientoAplicacion") =="")
		{
			objAppEsp.setIdMantenimientoAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdMantenimientoAplicacion(Integer.parseInt(request.getParameter("idMantenimientoAplicacion")));
		}
		
		
		objAppEsp.setMantenimientoNombreProveedor(request.getParameter("mantenimientoNombreProveedor"));
		
		if(request.getParameter("idSoporteAplicacion") =="")
		{
			objAppEsp.setIdSoporteAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdSoporteAplicacion(Integer.parseInt(request.getParameter("idSoporteAplicacion")));
		}
		
		
		objAppEsp.setSoporteNombrePorveedor(request.getParameter("soporteNombrePorveedor"));
		if(request.getParameter("idAcessosAplicacion") == "")
		{
			objAppEsp.setIdAcessosAplicacion(-99);
		}
		else
		{
			objAppEsp.setIdAcessosAplicacion(Integer.parseInt(request.getParameter("idAcessosAplicacion")));	
		}
		
		objAppEsp.setAccesosNombreProveedor(request.getParameter("accesosNombreProveedor"));
		objAppEsp.setNombreServidor(request.getParameter("nombreServidor"));
		objAppEsp.setUbicacionServidor(request.getParameter("ubicacionServidor"));

		/** DATAMART **/
		objAppEsp.setNombreDatamart(request.getParameter("nombreDatamart"));
		if(request.getParameter("cantidadTablas") == "")
		{
			objAppEsp.setCantidadTablas(-99);
		}
		else
		{
			objAppEsp.setCantidadTablas(Integer.parseInt(request.getParameter("cantidadTablas")));
		}
		
		if(request.getParameter("cantidadTablasDescriptivas") =="")
		{
			objAppEsp.setCantidadTablasDescriptivas(-99);
		}
		else
		{
			objAppEsp.setCantidadTablasDescriptivas(Integer.parseInt(request.getParameter("cantidadTablasDescriptivas")));
		}
		
		if(request.getParameter("cantidadTablasHechos")=="")
		{
			objAppEsp.setCantidadTablasHechos(-99);
		}
		else
		{
			objAppEsp.setCantidadTablasHechos(Integer.parseInt(request.getParameter("cantidadTablasHechos")));
		}
		
		if(request.getParameter("idHerramientaExplotacionDatos") =="")
		{objAppEsp.setIdHerramientaExplotacionDatos(-99);}
		else
		{objAppEsp.setIdHerramientaExplotacionDatos(Integer.parseInt(request.getParameter("idHerramientaExplotacionDatos")));}
		
		
		objAppEsp.setHerramientaExplotacionDatosOtros(request.getParameter("herramientaExplotacionDatosOtros"));
		
		if(request.getParameter("cantidadReportes") =="")
		{
			objAppEsp.setCantidadReportes(-99);
		}
		else
		{
			objAppEsp.setCantidadReportes(Integer.parseInt(request.getParameter("cantidadReportes")));
		}
		
		if(request.getParameter("cantidadUsuarios")=="")
		{
			objAppEsp.setCantidadUsuarios(-99);
		}
		else
		{
			objAppEsp.setCantidadUsuarios(Integer.parseInt(request.getParameter("cantidadUsuarios")));
		}
		
		
		objAppEsp.setFrecuencia(request.getParameter("frecuencia"));
		
		objAppEsp.setCantidadEspacioTablespace(request.getParameter("cantidadEspacioTablespace"));

		/** IMPACTOS **/
	
		objAppEsp.setImpactoFinanciero(request.getParameter("impactoFinanciero"));
		objAppEsp.setRentabilidad(request.getParameter("rentabilidad"));
		objAppEsp.setImpactoImagen(request.getParameter("impactoImagen"));
		objAppEsp.setImpactoClientes(request.getParameter("impactoClientes"));
		objAppEsp.setImpactoOperativo(request.getParameter("impactoOperativo"));
		objAppEsp.setImpactoLegal(request.getParameter("impactoLegal"));
		
		if(request.getParameter("idProcesoAuditoriaI") == "")
		{
			objAppEsp.setIdProcesoAuditoriaI(-99);
		}
		else
		{
			objAppEsp.setIdProcesoAuditoriaI(Integer.parseInt(request.getParameter("idProcesoAuditoriaI")));
		}
		
		
	//	objAppEsp.setTocaProcesoClave(request.getParameter("impactoTocaProcesoClave"));
		
		if(request.getParameter("impactoTocaProcesoClave")=="")
		{objAppEsp.setIdTocaProcesoClave(0);}
		else
		{objAppEsp.setIdTocaProcesoClave(Integer.parseInt(request.getParameter("impactoTocaProcesoClave")));}
		
		//objAppEsp.setIndicarProcesoClave(request.getParameter("impactoIndicarProcesoClave"));
		if(request.getParameter("impactoIndicarProcesoClave") =="" || request.getParameter("impactoIndicarProcesoClave") ==null)
		{
			objAppEsp.setIdImpProcesoClave(-99);
			}
		else
		{
			objAppEsp.setIdImpProcesoClave(Integer.parseInt(request.getParameter("impactoIndicarProcesoClave")));
			}
		
		
		objAppEsp.setOtrosProcesoClave(request.getParameter("otrosImpactoProcesoClave"));
		
		if(request.getParameter("actividadImpacto") =="")
		{objAppEsp.setActividadImpacto(-99);}
		else
		{objAppEsp.setActividadImpacto(Integer.parseInt(request.getParameter("actividadImpacto")));}
		
		
		
		objAppEsp.setCategoriaTecnologica(request.getParameter("categoriaTecnologica"));
		objAppEsp.setNivel_criticidad(request.getParameter("nivelCriticidad"));

		/** ROADMAP **/
		objAppEsp.setRoadmapCortoPlazo(request.getParameter("roadmapCortoPlazo"));
		objAppEsp.setRoadmapLargoPlazo(request.getParameter("roadmapLargoPlazo"));
		if(request.getParameter("idEstadoAtencionRoadmap") =="")
		{
			objAppEsp.setIdEstadoAtencionRoadmap(-99);
		}
		else
		{
			objAppEsp.setIdEstadoAtencionRoadmap(Integer.parseInt(request.getParameter("idEstadoAtencionRoadmap")));
		}
		
		// objAppEsp.setIdEtapaAtencionRoadmap(Integer.parseInt(request.getParameter("idEtapaAtencionRoadmap")));
		if(request.getParameter("fechaInicioPlanificado") == "")
		{
			objAppEsp.setFechaInicioPlanificado("2000-01-01");
		}
		else
		{
			objAppEsp.setFechaInicioPlanificado(request.getParameter("fechaInicioPlanificado"));
		}
		
		if(request.getParameter("fechaCompromiso") =="")
		{
			objAppEsp.setFechaCompromiso("2000-01-01");
		}
		else
		{
			objAppEsp.setFechaCompromiso(request.getParameter("fechaCompromiso"));
		}
		
		
		objAppEsp.setRoadmapEjecutadoActual(request.getParameter("roadmapEjecutadoActual"));

		/** PRE ATENCION **/
		if(request.getParameter("idSwBaseEstandarSistemaOperativoPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarSistemaOperativoPRE")));
		}
		
		objAppEsp.setSwBaseSistemaOperativoOtrosPRE(request.getParameter("swBaseSistemaOperativoOtrosPRE"));
		
		if(request.getParameter("idSwBaseEstandarHeramientaProgramacionPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarHeramientaProgramacionPRE")));
		}
		
		objAppEsp.setSwBaseHerramientaProgramacionOtrosPRE(request.getParameter("swBaseHerramientaProgramacionOtrosPRE"));
		
		if(request.getParameter("idSwBaseEstandarLenguajeProgramacionPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarLenguajeProgramacionPRE")));
		}
		
		objAppEsp.setSwBaseLenguajeProgramacionOtrosPRE(request.getParameter("swBaseLenguajeProgramacionOtrosPRE"));
		
		if(request.getParameter("idSwBaseEstandarGestorBDPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarGestorBDPRE")));
		}
		
		objAppEsp.setSwBaseGestorBDOtrosPRE(request.getParameter("swBaseGestorBDOtrosPRE"));
		if(request.getParameter("idSwBaseEstandarFrameworkPRE")=="")
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPRE(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPRE(Integer.parseInt(request.getParameter("idSwBaseEstandarFrameworkPRE")));
		}
		
		/****/
		objAppEsp.setSwBaseFrameworkOtrosPRE(request.getParameter("swBaseFrameworkOtrosPRE"));
		objAppEsp.setSwBaseObservacionesAdicionalesPRE(request.getParameter("swBaseObservacionesAdicionalesPRE"));
		if(request.getParameter("idAccesosGestionPrivilegiosSistemasPRE")=="")
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPRE(Integer.parseInt(request.getParameter("idAccesosGestionPrivilegiosSistemasPRE")));
		}
		
		if(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPRE")=="")
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPRE(Integer.parseInt(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPRE")));
		}
		
		if(request.getParameter("idAccesosGestionContrasenasPRE")=="")
		{
			objAppEsp.setIdAccesosGestionContrasenasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionContrasenasPRE(Integer.parseInt(request.getParameter("idAccesosGestionContrasenasPRE")));
		}
		
		if(request.getParameter("idAccesosPoliticaContrasenasPRE")=="")
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPRE(Integer.parseInt(request.getParameter("idAccesosPoliticaContrasenasPRE")));
		}
		
		if(request.getParameter("idAccesosGestionClaves1PRE")=="")
		{
			objAppEsp.setIdAccesosGestionClaves1PRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves1PRE(Integer.parseInt(request.getParameter("idAccesosGestionClaves1PRE")));
		}
		
		if(request.getParameter("idAccesosGestionClaves2PRE")=="")
		{
			objAppEsp.setIdAccesosGestionClaves2PRE(-99);	
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves2PRE(Integer.parseInt(request.getParameter("idAccesosGestionClaves2PRE")));
		}
	
		if(request.getParameter("idAccesosGestionClaves3PRE")=="")
		{
			objAppEsp.setIdAccesosGestionClaves3PRE(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves3PRE(Integer.parseInt(request.getParameter("idAccesosGestionClaves3PRE")));
		}
		
		if(request.getParameter("idAuditoriaRegistroAuditoriaPRE")=="")
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPRE(Integer.parseInt(request.getParameter("idAuditoriaRegistroAuditoriaPRE")));
		}
		
		if(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPRE")=="")
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPRE(Integer.parseInt(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPRE")));
		}
		
		if(request.getParameter("idAuditoriaRegistroEventosAdministradoresPRE")=="")
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPRE(Integer.parseInt(request.getParameter("idAuditoriaRegistroEventosAdministradoresPRE")));
		}
		
		if(request.getParameter("idAuditoriaConformidadPoliticasPRE")=="")
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPRE(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPRE(Integer.parseInt(request.getParameter("idAuditoriaConformidadPoliticasPRE")));
		}
		
		if(request.getParameter("idContingenciaPRE")=="")
		{
			objAppEsp.setIdContingenciaPRE(-99);
		}
		else
		{
			objAppEsp.setIdContingenciaPRE(Integer.parseInt(request.getParameter("idContingenciaPRE")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosSwPRE")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPRE(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPRE(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosSwPRE")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosInfraestructuraPRE")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPRE(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPRE(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosInfraestructuraPRE")));
		}
		
		if(request.getParameter("idDocumentacionManejoPRE")=="")
		{
			objAppEsp.setIdDocumentacionManejoPRE(-99);
		}
		else
		{
			objAppEsp.setIdDocumentacionManejoPRE(Integer.parseInt(request.getParameter("idDocumentacionManejoPRE")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPRE")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPRE(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPRE(Integer.parseInt(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPRE")));
		}
	
		if(request.getParameter("idIncidentesCumplimientoGestionParchesPRE")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPRE(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPRE(Integer.parseInt(request.getParameter("idIncidentesCumplimientoGestionParchesPRE")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPRE")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPRE(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPRE(Integer.parseInt(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPRE")));
		}
		
		if(request.getParameter("idIntegridadConfidencialidadDatosPruebaPRE")=="")
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPRE(-99);
		}
		else
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPRE(Integer.parseInt(request.getParameter("idIntegridadConfidencialidadDatosPruebaPRE")));
		}
		
		if(request.getParameter("idRespaldosGestionRespaldoRecuperacionPRE")=="")
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPRE(-99);
		}
		else
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPRE(Integer.parseInt(request.getParameter("idRespaldosGestionRespaldoRecuperacionPRE")));
		}
		

		/** POST ATENCION **/

		if(request.getParameter("idSwBaseEstandarSistemaOperativoPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarSistemaOperativoPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarSistemaOperativoPOST")));
		}
		
		objAppEsp.setSwBaseSistemaOperativoOtrosPOST(request.getParameter("swBaseSistemaOperativoOtrosPOST"));
		
		if(request.getParameter("idSwBaseEstandarHeramientaProgramacionPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarHeramientaProgramacionPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarHeramientaProgramacionPOST")));
		}
		
		objAppEsp.setSwBaseHerramientaProgramacionOtrosPOST(request.getParameter("swBaseHerramientaProgramacionOtrosPOST"));
		
		if(request.getParameter("idSwBaseEstandarLenguajeProgramacionPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarLenguajeProgramacionPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarLenguajeProgramacionPOST")));
		}
		
		objAppEsp.setSwBaseLenguajeProgramacionOtrosPOST(request.getParameter("swBaseLenguajeProgramacionOtrosPOST"));
		
		if(request.getParameter("idSwBaseEstandarGestorBDPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarGestorBDPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarGestorBDPOST")));
		}
		
		objAppEsp.setSwBaseGestorBDOtrosPOST(request.getParameter("swBaseGestorBDOtrosPOST"));
		if(request.getParameter("idSwBaseEstandarFrameworkPOST")=="")
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPOST(-99);
		}
		else
		{
			objAppEsp.setIdSwBaseEstandarFrameworkPOST(Integer.parseInt(request.getParameter("idSwBaseEstandarFrameworkPOST")));
		}
		
		/****/
		objAppEsp.setSwBaseFrameworkOtrosPOST(request.getParameter("swBaseFrameworkOtrosPOST"));
		objAppEsp.setSwBaseObservacionesAdicionalesPOST(request.getParameter("swBaseObservacionesAdicionalesPOST"));
		if(request.getParameter("idAccesosGestionPrivilegiosSistemasPOST")=="")
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionPrivilegiosSistemasPOST(Integer.parseInt(request.getParameter("idAccesosGestionPrivilegiosSistemasPOST")));
		}
		
		if(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPOST")=="")
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosRevisionPrivilegiosUsuariosPOST(Integer.parseInt(request.getParameter("idAccesosRevisionPrivilegiosUsuariosPOST")));
		}
		
		if(request.getParameter("idAccesosGestionContrasenasPOST")=="")
		{
			objAppEsp.setIdAccesosGestionContrasenasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionContrasenasPOST(Integer.parseInt(request.getParameter("idAccesosGestionContrasenasPOST")));
		}
		
		if(request.getParameter("idAccesosPoliticaContrasenasPOST")=="")
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosPoliticaContrasenasPOST(Integer.parseInt(request.getParameter("idAccesosPoliticaContrasenasPOST")));
		}
		
		if(request.getParameter("idAccesosGestionClaves1POST")=="")
		{
			objAppEsp.setIdAccesosGestionClaves1POST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves1POST(Integer.parseInt(request.getParameter("idAccesosGestionClaves1POST")));
		}
		
		if(request.getParameter("idAccesosGestionClaves2POST")=="")
		{
			objAppEsp.setIdAccesosGestionClaves2POST(-99);	
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves2POST(Integer.parseInt(request.getParameter("idAccesosGestionClaves2POST")));
		}
	
		if(request.getParameter("idAccesosGestionClaves3POST")=="")
		{
			objAppEsp.setIdAccesosGestionClaves3POST(-99);
		}
		else
		{
			objAppEsp.setIdAccesosGestionClaves3POST(Integer.parseInt(request.getParameter("idAccesosGestionClaves3POST")));
		}
		
		if(request.getParameter("idAuditoriaRegistroAuditoriaPOST")=="")
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroAuditoriaPOST(Integer.parseInt(request.getParameter("idAuditoriaRegistroAuditoriaPOST")));
		}
		
		if(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPOST")=="")
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaProteccionRegistrosAuditoriaPOST(Integer.parseInt(request.getParameter("idAuditoriaProteccionRegistrosAuditoriaPOST")));
		}
		
		if(request.getParameter("idAuditoriaRegistroEventosAdministradoresPOST")=="")
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaRegistroEventosAdministradoresPOST(Integer.parseInt(request.getParameter("idAuditoriaRegistroEventosAdministradoresPOST")));
		}
		
		if(request.getParameter("idAuditoriaConformidadPoliticasPOST")=="")
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPOST(-99);
		}
		else
		{
			objAppEsp.setIdAuditoriaConformidadPoliticasPOST(Integer.parseInt(request.getParameter("idAuditoriaConformidadPoliticasPOST")));
		}
		
		if(request.getParameter("idContingenciaPOST")=="")
		{
			objAppEsp.setIdContingenciaPOST(-99);
		}
		else
		{
			objAppEsp.setIdContingenciaPOST(Integer.parseInt(request.getParameter("idContingenciaPOST")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosSwPOST")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPOST(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosSwPOST(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosSwPOST")));
		}
		
		if(request.getParameter("idControlCambiosProcedimientosInfraestructuraPOST")=="")
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPOST(-99);
		}
		else
		{
			objAppEsp.setIdControlCambiosProcedimientosInfraestructuraPOST(Integer.parseInt(request.getParameter("idControlCambiosProcedimientosInfraestructuraPOST")));
		}
		
		if(request.getParameter("idDocumentacionManejoPOST")=="")
		{
			objAppEsp.setIdDocumentacionManejoPOST(-99);
		}
		else
		{
			objAppEsp.setIdDocumentacionManejoPOST(Integer.parseInt(request.getParameter("idDocumentacionManejoPOST")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPOST")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPOST(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoPoliticasAntivirusPOST(Integer.parseInt(request.getParameter("idIncidentesCumplimientoPoliticasAntivirusPOST")));
		}
	
		if(request.getParameter("idIncidentesCumplimientoGestionParchesPOST")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPOST(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoGestionParchesPOST(Integer.parseInt(request.getParameter("idIncidentesCumplimientoGestionParchesPOST")));
		}
		
		if(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPOST")=="")
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPOST(-99);
		}
		else
		{
			objAppEsp.setIdIncidentesCumplimientoCodigoMaliciosoPOST(Integer.parseInt(request.getParameter("idIncidentesCumplimientoCodigoMaliciosoPOST")));
		}
		
		if(request.getParameter("idIntegridadConfidencialidadDatosPruebaPOST")=="")
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPOST(-99);
		}
		else
		{
			objAppEsp.setIdIntegridadConfidencialidadDatosPruebaPOST(Integer.parseInt(request.getParameter("idIntegridadConfidencialidadDatosPruebaPOST")));
		}
		
		if(request.getParameter("idRespaldosGestionRespaldoRecuperacionPOST")=="")
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPOST(-99);
		}
		else
		{
			objAppEsp.setIdRespaldosGestionRespaldoRecuperacionPOST(Integer.parseInt(request.getParameter("idRespaldosGestionRespaldoRecuperacionPOST")));
		}

		/** INFORMACION ADICIONAL **/

		objAppEsp.setEvaluacionSeguridadInformatica(request.getParameter("evaluacionSeguridadInformatica"));
		objAppEsp.setSeguridadNivelExposicion(request.getParameter("seguridadNivelExposicion"));

		if(request.getParameter("idEscenarioLogueo")=="")
		{objAppEsp.setIdEscenarioLogueo(-99);}
		else
		{objAppEsp.setIdEscenarioLogueo(Integer.parseInt(request.getParameter("idEscenarioLogueo")));}
		
		if(request.getParameter("idImpactoProteccionDatos") =="")
		{objAppEsp.setIdImpactoProteccionDatos(-99);}
		else
		{objAppEsp.setIdImpactoProteccionDatos(Integer.parseInt(request.getParameter("idImpactoProteccionDatos")));}
		
		if(request.getParameter("idImpactoProteccionDatosLevantamientoInformacion")=="")
		{objAppEsp.setIdImpactoProteccionDatosLevantamientoInformacion(-99);}
		else
		{objAppEsp.setIdImpactoProteccionDatosLevantamientoInformacion(Integer.parseInt(request.getParameter("idImpactoProteccionDatosLevantamientoInformacion")));}
		
		
		
		if(request.getParameter("idFuentePeriodo") =="")
		{objAppEsp.setIdFuentePeriodo(-99);}
		else
		{objAppEsp.setIdFuentePeriodo(Integer.parseInt(request.getParameter("idFuentePeriodo")));}
		
		
		objAppEsp.setDescripcionFuente(request.getParameter("descripcionFuente"));

		AplicacionEspecializadaDAO.getInstancia().ingresarAplicacionEspecializada(objAppEsp);
		//AppEspNivelCumplimientoDAO.getInstancia().ingresarNivelCumplimiento(objAppEsp);
		//AppEspNivelCumplimientoDAO.getInstancia().ingresarNivelCumplimientoPost(objAppEsp);

		message="Se actualizó correctamente";
		
		//Registro log de auditoría
		objeto.setPagina("detalleAplicacionesEspecializadas.jsp");
		objeto.setObjeto("");
		objeto.setTraza_error("");
		
		objeto.setTipo("Acceso");
		objeto.setIp(logAuditoria.obtenerIP());
		objeto.setUsuario(request.getParameter("usuarioActual"));
		objeto.setFecha(sdf.format(fecha));
		objeto.setHora(hourFormat.format(fecha));
		logAuditoria.guardarLogAuditoria(objeto);

		
		model.addObject("mesajeInfo", message);
	
	} catch (SQLException ex) {
		//model.addAttribute("mensaje", ex.getMessage());
			model.addObject("mensaje", ex.getMessage());
			
			//Registro log de auditoría
			objeto.setPagina("detalleAplicacionesEspecializadas.jsp");
			objeto.setObjeto("actualizarAplicacionEspecializada");
			objeto.setTraza_error(ex.getMessage());
			System.out.println("mostrar pagina:= " + ex.getMessage());
			objeto.setTipo("Error");
			objeto.setIp(logAuditoria.obtenerIP());
			objeto.setUsuario(request.getParameter("usuarioActual"));
			objeto.setFecha(sdf.format(fecha));
			objeto.setHora(hourFormat.format(fecha));
			logAuditoria.guardarLogAuditoria(objeto);
			
		}
		
		return model;
		

	}
	
	@RequestMapping(value = { "/ExportarConsultaGeneral" }, method = RequestMethod.POST)
	public ModelAndView ExportarConsultaGeneral(HttpServletRequest request,
			ModelMap mod) throws Exception {

		listaAplicaciones = new ArrayList<>();

		ConsultaGeneralAplicacionesDTO aplicaciones = new ConsultaGeneralAplicacionesDTO();
		
		/*
		aplicaciones.setDesGerenciaCentral(request.getParameter("desGerenciaCentral"));
		aplicaciones.setDesDivision(request.getParameter("desDivision"));
		aplicaciones.setDesArea(request.getParameter("desArea"));
		aplicaciones.setDesUnidad(request.getParameter("desUnidad"));
		
		aplicaciones.setCodigoFNA(request.getParameter("codigoFNA"));
		aplicaciones.setCodigoAplicacion(request.getParameter("codigoAplicacion"));
		aplicaciones.setNombreAplicacion(request.getParameter("nombreAplicacion"));
		aplicaciones.setDescripcionAplicacion(request.getParameter("descripcionAplicacion"));
		
		aplicaciones.setFuncionalidadesAplicacion(request.getParameter("funcionalidadesAplicacion"));
		aplicaciones.setEstadoAplicacion(request.getParameter("estadoAplicacion"));
		aplicaciones.setTipoOperacionesProcesa(request.getParameter("tipoOperacionesProcesa"));
		aplicaciones.setFrecuenciaOperacionesProcesa(request.getParameter("frecuenciaOperacionesProcesa"));
		
		aplicaciones.setFuncionalidadesAplicacion(request.getParameter("nroFuncionalidadesTransacciones"));
		aplicaciones.setEstadoAplicacion(request.getParameter("nroReportes"));
		aplicaciones.setTipoOperacionesProcesa(request.getParameter("nroConsultas"));
		aplicaciones.setFrecuenciaOperacionesProcesa(request.getParameter("nroEntidadesExternas"));
		aplicaciones.setTipoOperacionesProcesa(request.getParameter("nroEntidadesInternas"));
		aplicaciones.setFrecuenciaOperacionesProcesa(request.getParameter("observacionesGenerales"));
		
		aplicaciones.setCategoriaTecnologica(request.getParameter("categoriaTecnologica"));
		aplicaciones.setCategoriaTecnologicaOtros(request.getParameter("categoriaTecnologicaOtros"));
		aplicaciones.setTipoOperacionesProcesa(request.getParameter("tipoDesarrollo"));
		aplicaciones.setFrecuenciaOperacionesProcesa(request.getParameter("ubicacionFisica"));
		aplicaciones.setAmbienteAppNOIT(request.getParameter("ambienteAppNOIT"));

		
		aplicaciones.setAmbienteAppNOITOtros(request.getParameter("ambienteAppNOITOtros"));
		aplicaciones.setNombreUbicacion(request.getParameter("nombreUbicacion"));
		aplicaciones.setDescripcionInfraestructuraAplicacion(request.getParameter("descripcionInfraestructuraAplicacion"));
		aplicaciones.setEsSolucionStandAlone(request.getParameter("esSolucionStandAlone"));
		aplicaciones.setNroInterfacesOtrasApp(request.getParameter("nroInterfacesOtrasApp"));

		
		aplicaciones.setNombresInterfaces(request.getParameter("nombresInterfaces"));
		aplicaciones.setDescripcionMantenimientoAplicacion(request.getParameter("descripcionMantenimientoAplicacion"));
		aplicaciones.setMantenimientoNombreProveedor(request.getParameter("mantenimientoNombreProveedor"));
		aplicaciones.setDescripcionSoporteAplicacion(request.getParameter("descripcionSoporteAplicacion"));
		aplicaciones.setSoporteNombrePorveedor(request.getParameter("soporteNombrePorveedor"));
		aplicaciones.setDescripcionAccesosAplicacion(request.getParameter("descripcionAccesosAplicacion"));
		aplicaciones.setAccesosNombreProveedor(request.getParameter("accesosNombreProveedor"));
		
		
		////////
		
		aplicaciones.setNombreServidor(request.getParameter("nombreServidor"));
		aplicaciones.setUbicacionServidor(request.getParameter("ubicacionServidor"));
		aplicaciones.setFrontUserLiderUsuario(request.getParameter("frontUserLiderUsuario"));
		aplicaciones.setGestorAplicaciones(request.getParameter("gestorAplicaciones"));
		aplicaciones.setEspecialistaAplicaciones(request.getParameter("especialistaAplicaciones"));
		
		aplicaciones.setBrokerSistemas(request.getParameter("brokerSistemas"));
		aplicaciones.setBrokerNegocios(request.getParameter("brokerNegocios"));
		aplicaciones.setAsesorGUTI(request.getParameter("asesorGUTI"));
		aplicaciones.setArquitectoDominio(request.getParameter("arquitectoDominio"));
		aplicaciones.setDescripcionEntidadesUsuarias(request.getParameter("descripcionEntidadesUsuarias"));
		
		aplicaciones.setDescripcionDominio(request.getParameter("descripcionDominio"));
		aplicaciones.setDescripcionSubDominio(request.getParameter("descripcionSubDominio"));
		aplicaciones.setNroUnidadesUtilizanAplicacion(request.getParameter("nroUnidadesUtilizanAplicacion"));
		aplicaciones.setNombreUnidad1(request.getParameter("nombreUnidad1"));
		aplicaciones.setNombreUnidad2(request.getParameter("nombreUnidad2"));
		
		aplicaciones.setNombreUnidad3(request.getParameter("nombreUnidad3"));
		aplicaciones.setDescripcionCantidadUsuariosAplicacionTotal(request.getParameter("descripcionCantidadUsuariosAplicacionTotal"));
		aplicaciones.setDescripcionProcesoAuditoria(request.getParameter("descripcionProcesoAuditoria"));
		aplicaciones.setProcesoAuditoriaOtros(request.getParameter("procesoAuditoriaOtros"));
		aplicaciones.setImpactaProcesoClave(request.getParameter("impactaProcesoClave"));
		/////
		
		aplicaciones.setDescripcionProcesoClave(request.getParameter("descripcionProcesoClave"));
		aplicaciones.setNombreProcesoClaveOtros(request.getParameter("nombreProcesoClaveOtros"));
		aplicaciones.setDescripcionActividad(request.getParameter("descripcionActividad"));
		aplicaciones.setRelacionCIF(request.getParameter("relacionCIF"));
		aplicaciones.setDescripcionConfidencialidad(request.getParameter("descripcionConfidencialidad"));
		
		aplicaciones.setDescripcionIntegridad(request.getParameter("descripcionIntegridad"));
		aplicaciones.setDescripcionDisponibilidad(request.getParameter("descripcionDisponibilidad"));
		aplicaciones.setDescripcionPrivacidad(request.getParameter("descripcionPrivacidad"));
		aplicaciones.setClasificacionActivosObservacion(request.getParameter("clasificacionActivosObservacion"));
		aplicaciones.setDescripcionCriticidadFinal(request.getParameter("descripcionCriticidadFinal"));
		
		aplicaciones.setDescripcionEstadoRevisionAplicacion(request.getParameter("descripcionEstadoRevisionAplicacion"));
		aplicaciones.setDescripcionSwBaseEstandarSistemaOperativo(request.getParameter("descripcionSwBaseEstandarSistemaOperativo"));
		aplicaciones.setSwBaseSistemaOperativoOtros(request.getParameter("swBaseSistemaOperativoOtros"));
		aplicaciones.setDescripcionSwBaseEstandarHerramientaProgramacion(request.getParameter("descripcionSwBaseEstandarHerramientaProgramacion"));
		aplicaciones.setSwBaseHerramientaProgramacionOtros(("swBaseHerramientaProgramacionOtros"));
		
		aplicaciones.setDescripcionSwBaseEstandarLenguajeProgramacion(request.getParameter("descripcionSwBaseEstandarLenguajeProgramacion"));
		aplicaciones.setSwBaseLenguajeProgramacionOtros(request.getParameter("swBaseLenguajeProgramacionOtros"));
		aplicaciones.setDecripcionSwBaseEstandarGestorBD(request.getParameter("decripcionSwBaseEstandarGestorBD"));
		aplicaciones.setSwBaseGestorBDOtros(request.getParameter("swBaseGestorBDOtros"));
		aplicaciones.setDescripcionSwBaseEstandarFramework(request.getParameter("descripcionSwBaseEstandarFramework"));
		
		aplicaciones.setSwBaseFrameworkOtros(request.getParameter("swBaseFrameworkOtros"));
		aplicaciones.setSwBaseObservacionesAdicionales(request.getParameter("swBaseObservacionesAdicionales"));
		aplicaciones.setCompatibleWindows7(request.getParameter("compatibleWindows7"));
		aplicaciones.setCompatibleIExplorer8(request.getParameter("compatibleIExplorer8"));
		aplicaciones.setCompatiblePTerminal(request.getParameter("compatiblePTerminal"));
		aplicaciones.setSegurinetActiveDirectory(request.getParameter("segurinetActiveDirectory"));

		aplicaciones.setIdClasificacion(Integer.parseInt(request.getParameter("clasificacion")));
		aplicaciones.setIdCriticidadFinal(Integer.parseInt(request.getParameter("criticidadFinal")));
		aplicaciones.setNivelCumplimiento(Double.parseDouble(request.getParameter("nivelCumplimiento")));
		aplicaciones.setIdEstadoAtencionRoadmap(Integer.parseInt(request.getParameter("estadoRoadmap")));
		aplicaciones.setPostAtencionNivelCumplimiento(Double.parseDouble(request.getParameter("postAtencionNivelCumplimiento")));
	/*	aplicaciones.setProcesoClave(Integer.parseInt(request.getParameter("procesoClave")));*/
		
		listaAplicaciones = ConsultaAplicacionEspecializadaDAO.getInstancia().obtenerInventarioAplicaciones();

		ModelAndView model = new ModelAndView("Auxiliar/ExportaConsultaGeneral");
		model.addObject("listaAplicaciones", listaAplicaciones);

		return model;

	}
	
	@RequestMapping(value = { "/elimina" }, method = RequestMethod.POST)
	public ModelAndView EliminaAplicacionEspecializada(
			HttpServletRequest request, ModelMap mod) throws Exception {

		System.out.print("comienza elimina");

		AplicacionEspecializada ae = new AplicacionEspecializada();
		ae.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacion")));

		System.out.print("idusuaraio:   " + ae.getIdAplicacionEspecializada());
		AplicacionEspecializadaDAO.getInstancia().eliminar(ae);

		ModelAndView model = new ModelAndView("consultaGeneral");

		return model;

	}
	
	@RequestMapping(value = { "/ObtenerSubDominio" }, method = RequestMethod.POST)
	public ModelAndView ObtenerSubDominio(
			HttpServletRequest request, ModelMap mod) throws Exception {

		int iddominio = Integer.parseInt(request.getParameter("iddominio"));
		
		subdominio = new ArrayList<>();
		subdominio = SubDominioDAO.getInstancia().obtenerSubDominioPorDominio(iddominio);

		ModelAndView model = new ModelAndView("Auxiliar/ComboSubDominio");
		model.addObject("subdominio", subdominio);
		
		
		return model;

	}

	public void setMessage(String message) {
		this.message = message;
	}

}
