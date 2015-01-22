package com.bcp.modelo.dto;

public class AplicacionEspecializadaDTO {

	
	/**APLICACION ESPECIALIZADA*/
	private int numero;
	private int idAplicacionEspecializada;
	private int idVersion;
	private String fechaCreacionRegistro;
	private String usuarioCreacion;
	private int versionActual;
	private String estadoVersion;
	private int idMotivoCreacion;
	//private String motivoCreacion;
	
	
	
	/**ESTRUCTURA ORGANIZACIONAL**/
	private int idGerenciaCentral;
	private int idDivision;
	private int idArea;
	private int idUnidad;
	private String codigoFNA;
	private String codigoAplicacionEspecializada;
	
	
	/**INFORMACION GENERAL**/

	private String nombreAplicacionNOIT;
	private String descripcionAplicacion;
	private String funcionalidadesAplicacion;
	private int idEstadoAplicacion;
	private int idTipoOperacionProceso;
	private int idFrecuenciaOperaciones;
	private int idCantidadOperaciones;
	private String fechaCreacionAplicacion; //Date fechaCreacionAplicacion
	private int idMotivoCreacionAplicacion;
	private String motivoCreacionAplicacionOtros;
	private int nroFuncionalidadesTransacciones;
	private int nroReportes;
	private int nroConsultas;
	private int nroEntidadesExternas;
	private int nroEntidadesInternas;
	private String observacionesGenerales;
	
	/**FUNCIONALIDAD**/
	private String funcionalidad;
	private String datosEntrada;
	private String proceso;
	private String salida;
	
	/**DOMINIO**/
	private String frontUserLiderUsuario;
	private String gestorAplicaciones;
	private String especialistaAplicaciones;
	private String brokerSistemas;
	private String brokerNegocios;
	private String asesorGUTI;
	private String arquitectoDominio;
	private int idEntidadesUsuarias;
	private int idDominio;
	private int idSubDominio;
	private int nroUnidadesUtilizanAplicacion;
	private String nombreUnidad1;
	private String nombreUnidad2;
	private String nombreUnidad3;
	private int idCantidadUsuariosAplicacionTotal;
	private int idProcesoAuditoria;
	private String procesoAuditoriaOtros;
	//private String idProcesoClave;
	private int idImpactaProcesoClave;
	private int idDomProcesoClave;
	private String nombreProcesoClaveOtros;
	private int actividadDominio;
	private String relacionConCIF;
	
	/**CLASIFICACION DE ACTIVOS**/
	private int idConfidencialidad;
	private int idIntegridad;
	private int idDisponibilidad;
	private int idPrivacidad;
	private int idClasificacion;
	private String clasificacionActivosObservacion;
	private int idCriticidadFinal;
	private int idEstadoRevisionAplicaciones;
	private String estadoRevisionAplicaciones;
	
	/**CARACTERISTICAS TECNICAS**/
	private int idCategoriaTecnologica;
	private String categoriaTecnologicaOtros;
	private int idTiposDesarrollo;
	private int idUbicacionFisica;
	private int idAmbienteAppNOIT;
	private String ambienteAppNOITOtros;
	private String nombreUbicacion;
	private int idInfraestructuraAplicacion;
	private int esSolucionStandAlone;
	private int nroInterfacesConOtrasApp;
	private String nombresInterfaces;
	private int idMantenimientoAplicacion;
	private String mantenimientoNombreProveedor;
	private int idSoporteAplicacion;
	private String soporteNombrePorveedor;
	private int idAcessosAplicacion;
	private String accesosNombreProveedor;
	private String nombreServidor;
	private String ubicacionServidor;
	
	/**DATAMART**/
	private String nombreDatamart;
	private String frecuencia;
	private int cantidadTablas;
	private int cantidadTablasDescriptivas;
	private int cantidadTablasHechos;
	private int idHerramientaExplotacionDatos;
	private String herramientaExplotacionDatosOtros;
	private int cantidadReportes;
	private int cantidadUsuarios;
	private String cantidadEspacioTablespace;
	
	/**IMPACTO**/
	private String impactoFinanciero;
	private String rentabilidad;
	private String impactoImagen;
	private String impactoClientes;
	private String impactoOperativo;
	private String impactoLegal;
	private int idProcesoAuditoriaI;
	private int idTocaProcesoClave;
	private int idImpProcesoClave;
	//private String indicarProcesoClave;
	private String otrosProcesoClave;
	private int actividadImpacto;
	private String categoriaTecnologica;
	private String nivel_criticidad;
	
	/**ROADMAP**/
	private String roadmapCortoPlazo;
	private String roadmapLargoPlazo;
	private int idEstadoAtencionRoadmap;
	private int idEtapaAtencionRoadmap;
	private String fechaInicioPlanificado;
	private String fechaCompromiso;
	private String roadmapEjecutadoActual;
	private String trackAtencion;
	
	/**PRE ATENCION**/
	private int idSwBaseEstandarSistemaOperativoPRE;
	private String swBaseSistemaOperativoOtrosPRE;
	private int idSwBaseEstandarHeramientaProgramacionPRE;
	private String swBaseHerramientaProgramacionOtrosPRE;
	private int idSwBaseEstandarLenguajeProgramacionPRE;
	private String swBaseLenguajeProgramacionOtrosPRE;
	private int idSwBaseEstandarGestorBDPRE;
	private String swBaseGestorBDOtrosPRE;
	private int idSwBaseEstandarFrameworkPRE;/****/
	private String swBaseFrameworkOtrosPRE;
	private String swBaseObservacionesAdicionalesPRE;
	
	private int idAccesosGestionPrivilegiosSistemasPRE;
	private int idAccesosRevisionPrivilegiosUsuariosPRE;
	private int idAccesosGestionContrasenasPRE;
	private int idAccesosPoliticaContrasenasPRE;
	private int idAccesosGestionClaves1PRE;
	private int idAccesosGestionClaves2PRE;
	private int idAccesosGestionClaves3PRE;
	private int idAuditoriaRegistroAuditoriaPRE;
	private int idAuditoriaProteccionRegistrosAuditoriaPRE;
	private int idAuditoriaRegistroEventosAdministradoresPRE;
	private int idAuditoriaConformidadPoliticasPRE;
	private int idContingenciaPRE;
	private int idControlCambiosProcedimientosSwPRE;
	private int idControlCambiosProcedimientosInfraestructuraPRE;
	private int idDocumentacionManejoPRE;
	private int idIncidentesCumplimientoPoliticasAntivirusPRE;
	private int idIncidentesCumplimientoGestionParchesPRE;
	private int idIncidentesCumplimientoCodigoMaliciosoPRE;
	private int idIntegridadConfidencialidadDatosPruebaPRE;
	private int idRespaldosGestionRespaldoRecuperacionPRE;
	
	/**POST ATENCION**/ /*&&*/ 
	private int idSwBaseEstandarSistemaOperativoPOST;
	private String swBaseSistemaOperativoOtrosPOST;
	private int idSwBaseEstandarHeramientaProgramacionPOST;
	private String swBaseHerramientaProgramacionOtrosPOST;
	private int idSwBaseEstandarLenguajeProgramacionPOST;
	private String swBaseLenguajeProgramacionOtrosPOST;
	private int idSwBaseEstandarGestorBDPOST;
	private String swBaseGestorBDOtrosPOST;
	private int idSwBaseEstandarFrameworkPOST;/****/
	private String swBaseFrameworkOtrosPOST;
	private String swBaseObservacionesAdicionalesPOST;
	
	private int idAccesosGestionPrivilegiosSistemasPOST;
	private int idAccesosRevisionPrivilegiosUsuariosPOST;
	private int idAccesosGestionContrasenasPOST;
	private int idAccesosPoliticaContrasenasPOST;
	private int idAccesosGestionClaves1POST;
	private int idAccesosGestionClaves2POST;
	private int idAccesosGestionClaves3POST;
	private int idAuditoriaRegistroAuditoriaPOST;
	private int idAuditoriaProteccionRegistrosAuditoriaPOST;
	private int idAuditoriaRegistroEventosAdministradoresPOST;
	private int idAuditoriaConformidadPoliticasPOST;
	private int idContingenciaPOST;
	private int idControlCambiosProcedimientosSwPOST;
	private int idControlCambiosProcedimientosInfraestructuraPOST;
	private int idDocumentacionManejoPOST;
	private int idIncidentesCumplimientoPoliticasAntivirusPOST;
	private int idIncidentesCumplimientoGestionParchesPOST;
	private int idIncidentesCumplimientoCodigoMaliciosoPOST;
	private int idIntegridadConfidencialidadDatosPruebaPOST;
	private int idRespaldosGestionRespaldoRecuperacionPOST;
	
	
	
	/**SEGURIDAD DE LA INFORMACION**/
	private String evaluacionSeguridadInformatica;
	private String seguridadNivelExposicion;
	
	/**CARACTERISTICAS PARTICULARES**/
	private int idEscenarioLogueo;
	private int idImpactoProteccionDatos;
	private int idImpactoProteccionDatosLevantamientoInformacion;
	
	/**FUENTE DE ORIGEN**/
	private int idFuentePeriodo;
	private String descripcionFuente;
	
	/**HISTORIAL**/
	private String descripcionHistorial;
	
	/**BITACORA DE EVENTOS**/
	private int idBitacoraEventos;
	private String descripcionEvento;
	private String fechaCreacionEvento;
	private String fechaCreacionDesde;
	private String fechaCreacionHasta;
	private String estadoEvento;
	
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdAplicacionEspecializada() {
		return idAplicacionEspecializada;
	}
	public void setIdAplicacionEspecializada(int idAplicacionEspecializada) {
		this.idAplicacionEspecializada = idAplicacionEspecializada;
	}
	public int getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}
	public String getFechaCreacionRegistro() {
		return fechaCreacionRegistro;
	}
	public void setFechaCreacionRegistro(String fechaCreacionRegistro) {
		this.fechaCreacionRegistro = fechaCreacionRegistro;
	}

	public String getNombreAplicacionNOIT() {
		return nombreAplicacionNOIT;
	}
	public void setNombreAplicacionNOIT(String nombreAplicacionNOIT) {
		this.nombreAplicacionNOIT = nombreAplicacionNOIT;
	}
	public String getDescripcionAplicacion() {
		return descripcionAplicacion;
	}
	public void setDescripcionAplicacion(String descripcionAplicacion) {
		this.descripcionAplicacion = descripcionAplicacion;
	}
	public String getFuncionalidadesAplicacion() {
		return funcionalidadesAplicacion;
	}
	public void setFuncionalidadesAplicacion(String funcionalidadesAplicacion) {
		this.funcionalidadesAplicacion = funcionalidadesAplicacion;
	}
	public int getIdEstadoAplicacion() {
		return idEstadoAplicacion;
	}
	public void setIdEstadoAplicacion(int idEstadoAplicacion) {
		this.idEstadoAplicacion = idEstadoAplicacion;
	}
	public int getIdTipoOperacionProceso() {
		return idTipoOperacionProceso;
	}
	public void setIdTipoOperacionProceso(int idTipoOperacionProceso) {
		this.idTipoOperacionProceso = idTipoOperacionProceso;
	}
	public int getIdFrecuenciaOperaciones() {
		return idFrecuenciaOperaciones;
	}
	public void setIdFrecuenciaOperaciones(int idFrecuenciaOperaciones) {
		this.idFrecuenciaOperaciones = idFrecuenciaOperaciones;
	}
	public int getIdCantidadOperaciones() {
		return idCantidadOperaciones;
	}
	public void setIdCantidadOperaciones(int idCantidadOperaciones) {
		this.idCantidadOperaciones = idCantidadOperaciones;
	}
	public String getFechaCreacionAplicacion() {
		return fechaCreacionAplicacion;
	}
	public void setFechaCreacionAplicacion(String fechaCreacionAplicacion) {
		this.fechaCreacionAplicacion = fechaCreacionAplicacion;
	}
	public int getIdMotivoCreacionAplicacion() {
		return idMotivoCreacionAplicacion;
	}
	public void setIdMotivoCreacionAplicacion(int idMotivoCreacionAplicacion) {
		this.idMotivoCreacionAplicacion = idMotivoCreacionAplicacion;
	}
	public String getMotivoCreacionAplicacionOtros() {
		return motivoCreacionAplicacionOtros;
	}
	public void setMotivoCreacionAplicacionOtros(
			String motivoCreacionAplicacionOtros) {
		this.motivoCreacionAplicacionOtros = motivoCreacionAplicacionOtros;
	}
	public int getNroFuncionalidadesTransacciones() {
		return nroFuncionalidadesTransacciones;
	}
	public void setNroFuncionalidadesTransacciones(
			int nroFuncionalidadesTransacciones) {
		this.nroFuncionalidadesTransacciones = nroFuncionalidadesTransacciones;
	}
	public int getNroReportes() {
		return nroReportes;
	}
	public void setNroReportes(int nroReportes) {
		this.nroReportes = nroReportes;
	}
	public int getNroConsultas() {
		return nroConsultas;
	}
	public void setNroConsultas(int nroConsultas) {
		this.nroConsultas = nroConsultas;
	}
	public int getNroEntidadesExternas() {
		return nroEntidadesExternas;
	}
	public void setNroEntidadesExternas(int nroEntidadesExternas) {
		this.nroEntidadesExternas = nroEntidadesExternas;
	}
	public int getNroEntidadesInternas() {
		return nroEntidadesInternas;
	}
	public void setNroEntidadesInternas(int nroEntidadesInternas) {
		this.nroEntidadesInternas = nroEntidadesInternas;
	}
	public String getObservacionesGenerales() {
		return observacionesGenerales;
	}
	public void setObservacionesGenerales(String observacionesGenerales) {
		this.observacionesGenerales = observacionesGenerales;
	}
	
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public int getVersionActual() {
		return versionActual;
	}
	public void setVersionActual(int versionActual) {
		this.versionActual = versionActual;
	}
	public String getEstadoVersion() {
		return estadoVersion;
	}
	public void setEstadoVersion(String estadoVersion) {
		this.estadoVersion = estadoVersion;
	}

	public int getIdGerenciaCentral() {
		return idGerenciaCentral;
	}
	public void setIdGerenciaCentral(int idGerenciaCentral) {
		this.idGerenciaCentral = idGerenciaCentral;
	}
	public int getIdDivision() {
		return idDivision;
	}
	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
	}
	public int getIdArea() {
		return idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	public int getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}
	public String getCodigoFNA() {
		return codigoFNA;
	}
	public void setCodigoFNA(String codigoFNA) {
		this.codigoFNA = codigoFNA;
	}
	public String getCodigoAplicacionEspecializada() {
		return codigoAplicacionEspecializada;
	}
	public void setCodigoAplicacionEspecializada(
			String codigoAplicacionEspecializada) {
		this.codigoAplicacionEspecializada = codigoAplicacionEspecializada;
	}
	public String getFuncionalidad() {
		return funcionalidad;
	}
	public void setFuncionalidad(String funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
	public String getDatosEntrada() {
		return datosEntrada;
	}
	public void setDatosEntrada(String datosEntrada) {
		this.datosEntrada = datosEntrada;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public String getFrontUserLiderUsuario() {
		return frontUserLiderUsuario;
	}
	public void setFrontUserLiderUsuario(String frontUserLiderUsuario) {
		this.frontUserLiderUsuario = frontUserLiderUsuario;
	}
	public String getGestorAplicaciones() {
		return gestorAplicaciones;
	}
	public void setGestorAplicaciones(String gestorAplicaciones) {
		this.gestorAplicaciones = gestorAplicaciones;
	}
	public String getEspecialistaAplicaciones() {
		return especialistaAplicaciones;
	}
	public void setEspecialistaAplicaciones(String especialistaAplicaciones) {
		this.especialistaAplicaciones = especialistaAplicaciones;
	}
	public String getBrokerSistemas() {
		return brokerSistemas;
	}
	public void setBrokerSistemas(String brokerSistemas) {
		this.brokerSistemas = brokerSistemas;
	}
	public String getBrokerNegocios() {
		return brokerNegocios;
	}
	public void setBrokerNegocios(String brokerNegocios) {
		this.brokerNegocios = brokerNegocios;
	}
	public String getAsesorGUTI() {
		return asesorGUTI;
	}
	public void setAsesorGUTI(String asesorGUTI) {
		this.asesorGUTI = asesorGUTI;
	}
	public String getArquitectoDominio() {
		return arquitectoDominio;
	}
	public void setArquitectoDominio(String arquitectoDominio) {
		this.arquitectoDominio = arquitectoDominio;
	}
	public int getIdEntidadesUsuarias() {
		return idEntidadesUsuarias;
	}
	public void setIdEntidadesUsuarias(int idEntidadesUsuarias) {
		this.idEntidadesUsuarias = idEntidadesUsuarias;
	}
	public int getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(int idDominio) {
		this.idDominio = idDominio;
	}
	public int getIdSubDominio() {
		return idSubDominio;
	}
	public void setIdSubDominio(int idSubDominio) {
		this.idSubDominio = idSubDominio;
	}
	public int getNroUnidadesUtilizanAplicacion() {
		return nroUnidadesUtilizanAplicacion;
	}
	public void setNroUnidadesUtilizanAplicacion(int nroUnidadesUtilizanAplicacion) {
		this.nroUnidadesUtilizanAplicacion = nroUnidadesUtilizanAplicacion;
	}
	public String getNombreUnidad1() {
		return nombreUnidad1;
	}
	public void setNombreUnidad1(String nombreUnidad1) {
		this.nombreUnidad1 = nombreUnidad1;
	}
	public String getNombreUnidad2() {
		return nombreUnidad2;
	}
	public void setNombreUnidad2(String nombreUnidad2) {
		this.nombreUnidad2 = nombreUnidad2;
	}
	public String getNombreUnidad3() {
		return nombreUnidad3;
	}
	public void setNombreUnidad3(String nombreUnidad3) {
		this.nombreUnidad3 = nombreUnidad3;
	}
	public int getIdCantidadUsuariosAplicacionTotal() {
		return idCantidadUsuariosAplicacionTotal;
	}
	public void setIdCantidadUsuariosAplicacionTotal(
			int idCantidadUsuariosAplicacionTotal) {
		this.idCantidadUsuariosAplicacionTotal = idCantidadUsuariosAplicacionTotal;
	}
	public int getIdProcesoAuditoria() {
		return idProcesoAuditoria;
	}
	public void setIdProcesoAuditoria(int idProcesoAuditoria) {
		this.idProcesoAuditoria = idProcesoAuditoria;
	}
	public String getProcesoAuditoriaOtros() {
		return procesoAuditoriaOtros;
	}
	public void setProcesoAuditoriaOtros(String procesoAuditoriaOtros) {
		this.procesoAuditoriaOtros = procesoAuditoriaOtros;
	}


	public String getNombreProcesoClaveOtros() {
		return nombreProcesoClaveOtros;
	}
	public void setNombreProcesoClaveOtros(String nombreProcesoClaveOtros) {
		this.nombreProcesoClaveOtros = nombreProcesoClaveOtros;
	}
	
	public String getRelacionConCIF() {
		return relacionConCIF;
	}
	public void setRelacionConCIF(String relacionConCIF) {
		this.relacionConCIF = relacionConCIF;
	}

	


	public String getClasificacionActivosObservacion() {
		return clasificacionActivosObservacion;
	}
	public void setClasificacionActivosObservacion(
			String clasificacionActivosObservacion) {
		this.clasificacionActivosObservacion = clasificacionActivosObservacion;
	}
	public int getIdCategoriaTecnologica() {
		return idCategoriaTecnologica;
	}
	public void setIdCategoriaTecnologica(int idCategoriaTecnologica) {
		this.idCategoriaTecnologica = idCategoriaTecnologica;
	}
	public String getCategoriaTecnologicaOtros() {
		return categoriaTecnologicaOtros;
	}
	public void setCategoriaTecnologicaOtros(String categoriaTecnologicaOtros) {
		this.categoriaTecnologicaOtros = categoriaTecnologicaOtros;
	}
	public int getIdTiposDesarrollo() {
		return idTiposDesarrollo;
	}
	public void setIdTiposDesarrollo(int idTiposDesarrollo) {
		this.idTiposDesarrollo = idTiposDesarrollo;
	}
	public int getIdUbicacionFisica() {
		return idUbicacionFisica;
	}
	public void setIdUbicacionFisica(int idUbicacionFisica) {
		this.idUbicacionFisica = idUbicacionFisica;
	}
	public int getIdAmbienteAppNOIT() {
		return idAmbienteAppNOIT;
	}
	public void setIdAmbienteAppNOIT(int idAmbienteAppNOIT) {
		this.idAmbienteAppNOIT = idAmbienteAppNOIT;
	}
	public String getAmbienteAppNOITOtros() {
		return ambienteAppNOITOtros;
	}
	public void setAmbienteAppNOITOtros(String ambienteAppNOITOtros) {
		this.ambienteAppNOITOtros = ambienteAppNOITOtros;
	}
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	public int getIdInfraestructuraAplicacion() {
		return idInfraestructuraAplicacion;
	}
	public void setIdInfraestructuraAplicacion(int idInfraestructuraAplicacion) {
		this.idInfraestructuraAplicacion = idInfraestructuraAplicacion;
	}
	public int getEsSolucionStandAlone() {
		return esSolucionStandAlone;
	}
	public void setEsSolucionStandAlone(int esSolucionStandAlone) {
		this.esSolucionStandAlone = esSolucionStandAlone;
	}
	public int getNroInterfacesConOtrasApp() {
		return nroInterfacesConOtrasApp;
	}
	public void setNroInterfacesConOtrasApp(int nroInterfacesConOtrasApp) {
		this.nroInterfacesConOtrasApp = nroInterfacesConOtrasApp;
	}
	public String getNombresInterfaces() {
		return nombresInterfaces;
	}
	public void setNombresInterfaces(String nombresInterfaces) {
		this.nombresInterfaces = nombresInterfaces;
	}
	public int getIdMantenimientoAplicacion() {
		return idMantenimientoAplicacion;
	}
	public void setIdMantenimientoAplicacion(int idMantenimientoAplicacion) {
		this.idMantenimientoAplicacion = idMantenimientoAplicacion;
	}
	public String getMantenimientoNombreProveedor() {
		return mantenimientoNombreProveedor;
	}
	public void setMantenimientoNombreProveedor(String mantenimientoNombreProveedor) {
		this.mantenimientoNombreProveedor = mantenimientoNombreProveedor;
	}
	public int getIdSoporteAplicacion() {
		return idSoporteAplicacion;
	}
	public void setIdSoporteAplicacion(int idSoporteAplicacion) {
		this.idSoporteAplicacion = idSoporteAplicacion;
	}
	public String getSoporteNombrePorveedor() {
		return soporteNombrePorveedor;
	}
	public void setSoporteNombrePorveedor(String soporteNombrePorveedor) {
		this.soporteNombrePorveedor = soporteNombrePorveedor;
	}
	public int getIdAcessosAplicacion() {
		return idAcessosAplicacion;
	}
	public void setIdAcessosAplicacion(int idAcessosAplicacion) {
		this.idAcessosAplicacion = idAcessosAplicacion;
	}
	public String getAccesosNombreProveedor() {
		return accesosNombreProveedor;
	}
	public void setAccesosNombreProveedor(String accesosNombreProveedor) {
		this.accesosNombreProveedor = accesosNombreProveedor;
	}
	public String getNombreServidor() {
		return nombreServidor;
	}
	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}
	public String getUbicacionServidor() {
		return ubicacionServidor;
	}
	public void setUbicacionServidor(String ubicacionServidor) {
		this.ubicacionServidor = ubicacionServidor;
	}
	public String getNombreDatamart() {
		return nombreDatamart;
	}
	public void setNombreDatamart(String nombreDatamart) {
		this.nombreDatamart = nombreDatamart;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public int getCantidadTablas() {
		return cantidadTablas;
	}
	public void setCantidadTablas(int cantidadTablas) {
		this.cantidadTablas = cantidadTablas;
	}
	public int getCantidadTablasDescriptivas() {
		return cantidadTablasDescriptivas;
	}
	public void setCantidadTablasDescriptivas(int cantidadTablasDescriptivas) {
		this.cantidadTablasDescriptivas = cantidadTablasDescriptivas;
	}
	public int getCantidadTablasHechos() {
		return cantidadTablasHechos;
	}
	public void setCantidadTablasHechos(int cantidadTablasHechos) {
		this.cantidadTablasHechos = cantidadTablasHechos;
	}
	public int getIdHerramientaExplotacionDatos() {
		return idHerramientaExplotacionDatos;
	}
	public void setIdHerramientaExplotacionDatos(int idHerramientaExplotacionDatos) {
		this.idHerramientaExplotacionDatos = idHerramientaExplotacionDatos;
	}
	public String getHerramientaExplotacionDatosOtros() {
		return herramientaExplotacionDatosOtros;
	}
	public void setHerramientaExplotacionDatosOtros(
			String herramientaExplotacionDatosOtros) {
		this.herramientaExplotacionDatosOtros = herramientaExplotacionDatosOtros;
	}
	public int getCantidadReportes() {
		return cantidadReportes;
	}
	public void setCantidadReportes(int cantidadReportes) {
		this.cantidadReportes = cantidadReportes;
	}
	public int getCantidadUsuarios() {
		return cantidadUsuarios;
	}
	public void setCantidadUsuarios(int cantidadUsuarios) {
		this.cantidadUsuarios = cantidadUsuarios;
	}
	public String getCantidadEspacioTablespace() {
		return cantidadEspacioTablespace;
	}
	public void setCantidadEspacioTablespace(String cantidadEspacioTablespace) {
		this.cantidadEspacioTablespace = cantidadEspacioTablespace;
	}
	public String getImpactoFinanciero() {
		return impactoFinanciero;
	}
	public void setImpactoFinanciero(String impactoFinanciero) {
		this.impactoFinanciero = impactoFinanciero;
	}
	public String getRentabilidad() {
		return rentabilidad;
	}
	public void setRentabilidad(String rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	public String getImpactoImagen() {
		return impactoImagen;
	}
	public void setImpactoImagen(String impactoImagen) {
		this.impactoImagen = impactoImagen;
	}
	public String getImpactoClientes() {
		return impactoClientes;
	}
	public void setImpactoClientes(String impactoClientes) {
		this.impactoClientes = impactoClientes;
	}
	public String getImpactoOperativo() {
		return impactoOperativo;
	}
	public void setImpactoOperativo(String impactoOperativo) {
		this.impactoOperativo = impactoOperativo;
	}
	public String getImpactoLegal() {
		return impactoLegal;
	}
	public void setImpactoLegal(String impactoLegal) {
		this.impactoLegal = impactoLegal;
	}
	
	
	/*public String getIndicarProcesoClave() {
		return indicarProcesoClave;
	}
	public void setIndicarProcesoClave(String indicarProcesoClave) {
		this.indicarProcesoClave = indicarProcesoClave;
	}*/
	public String getOtrosProcesoClave() {
		return otrosProcesoClave;
	}
	public void setOtrosProcesoClave(String otrosProcesoClave) {
		this.otrosProcesoClave = otrosProcesoClave;
	}
	
	public String getCategoriaTecnologica() {
		return categoriaTecnologica;
	}
	public void setCategoriaTecnologica(String categoriaTecnologica) {
		this.categoriaTecnologica = categoriaTecnologica;
	}
	public String getNivel_criticidad() {
		return nivel_criticidad;
	}
	public void setNivel_criticidad(String nivel_criticidad) {
		this.nivel_criticidad = nivel_criticidad;
	}
	public String getRoadmapCortoPlazo() {
		return roadmapCortoPlazo;
	}
	public void setRoadmapCortoPlazo(String roadmapCortoPlazo) {
		this.roadmapCortoPlazo = roadmapCortoPlazo;
	}
	public String getRoadmapLargoPlazo() {
		return roadmapLargoPlazo;
	}
	public void setRoadmapLargoPlazo(String roadmapLargoPlazo) {
		this.roadmapLargoPlazo = roadmapLargoPlazo;
	}
	public int getIdEstadoAtencionRoadmap() {
		return idEstadoAtencionRoadmap;
	}
	public void setIdEstadoAtencionRoadmap(int idEstadoAtencionRoadmap) {
		this.idEstadoAtencionRoadmap = idEstadoAtencionRoadmap;
	}
	public int getIdEtapaAtencionRoadmap() {
		return idEtapaAtencionRoadmap;
	}
	public void setIdEtapaAtencionRoadmap(int idEtapaAtencionRoadmap) {
		this.idEtapaAtencionRoadmap = idEtapaAtencionRoadmap;
	}
	public String getFechaInicioPlanificado() {
		return fechaInicioPlanificado;
	}
	public void setFechaInicioPlanificado(String fechaInicioPlanificado) {
		this.fechaInicioPlanificado = fechaInicioPlanificado;
	}
	public String getFechaCompromiso() {
		return fechaCompromiso;
	}
	public void setFechaCompromiso(String fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}
	public String getRoadmapEjecutadoActual() {
		return roadmapEjecutadoActual;
	}
	public void setRoadmapEjecutadoActual(String roadmapEjecutadoActual) {
		this.roadmapEjecutadoActual = roadmapEjecutadoActual;
	}
	public String getTrackAtencion() {
		return trackAtencion;
	}
	public void setTrackAtencion(String trackAtencion) {
		this.trackAtencion = trackAtencion;
	}
	
	public String getEvaluacionSeguridadInformatica() {
		return evaluacionSeguridadInformatica;
	}
	public void setEvaluacionSeguridadInformatica(
			String evaluacionSeguridadInformatica) {
		this.evaluacionSeguridadInformatica = evaluacionSeguridadInformatica;
	}
	public String getSeguridadNivelExposicion() {
		return seguridadNivelExposicion;
	}
	public void setSeguridadNivelExposicion(String seguridadNivelExposicion) {
		this.seguridadNivelExposicion = seguridadNivelExposicion;
	}
	public int getIdEscenarioLogueo() {
		return idEscenarioLogueo;
	}
	public void setIdEscenarioLogueo(int idEscenarioLogueo) {
		this.idEscenarioLogueo = idEscenarioLogueo;
	}
	public int getIdImpactoProteccionDatos() {
		return idImpactoProteccionDatos;
	}
	public void setIdImpactoProteccionDatos(int idImpactoProteccionDatos) {
		this.idImpactoProteccionDatos = idImpactoProteccionDatos;
	}
	public int getIdImpactoProteccionDatosLevantamientoInformacion() {
		return idImpactoProteccionDatosLevantamientoInformacion;
	}
	public void setIdImpactoProteccionDatosLevantamientoInformacion(
			int idImpactoProteccionDatosLevantamientoInformacion) {
		this.idImpactoProteccionDatosLevantamientoInformacion = idImpactoProteccionDatosLevantamientoInformacion;
	}
	public int getIdFuentePeriodo() {
		return idFuentePeriodo;
	}
	public void setIdFuentePeriodo(int idFuentePeriodo) {
		this.idFuentePeriodo = idFuentePeriodo;
	}
	public String getDescripcionFuente() {
		return descripcionFuente;
	}
	public void setDescripcionFuente(String descripcionFuente) {
		this.descripcionFuente = descripcionFuente;
	}
	public String getDescripcionHistorial() {
		return descripcionHistorial;
	}
	public void setDescripcionHistorial(String descripcionHistorial) {
		this.descripcionHistorial = descripcionHistorial;
	}
	public int getIdBitacoraEventos() {
		return idBitacoraEventos;
	}
	public void setIdBitacoraEventos(int idBitacoraEventos) {
		this.idBitacoraEventos = idBitacoraEventos;
	}
	public String getDescripcionEvento() {
		return descripcionEvento;
	}
	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public String getFechaCreacionDesde() {
		return fechaCreacionDesde;
	}
	public void setFechaCreacionDesde(String fechaCreacionDesde) {
		this.fechaCreacionDesde = fechaCreacionDesde;
	}
	public String getFechaCreacionHasta() {
		return fechaCreacionHasta;
	}
	public void setFechaCreacionHasta(String fechaCreacionHasta) {
		this.fechaCreacionHasta = fechaCreacionHasta;
	}
	public String getEstadoEvento() {
		return estadoEvento;
	}
	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}
	public String getFechaCreacionEvento() {
		return fechaCreacionEvento;
	}
	public void setFechaCreacionEvento(String fechaCreacionEvento) {
		this.fechaCreacionEvento = fechaCreacionEvento;
	}
	public int getIdIntegridad() {
		return idIntegridad;
	}
	public void setIdIntegridad(int idIntegridad) {
		this.idIntegridad = idIntegridad;
	}
	public int getIdConfidencialidad() {
		return idConfidencialidad;
	}
	public void setIdConfidencialidad(int idConfidencialidad) {
		this.idConfidencialidad = idConfidencialidad;
	}
	public int getIdDisponibilidad() {
		return idDisponibilidad;
	}
	public void setIdDisponibilidad(int idDisponibilidad) {
		this.idDisponibilidad = idDisponibilidad;
	}
	public int getIdPrivacidad() {
		return idPrivacidad;
	}
	public void setIdPrivacidad(int idPrivacidad) {
		this.idPrivacidad = idPrivacidad;
	}
	public int getIdClasificacion() {
		return idClasificacion;
	}
	public void setIdClasificacion(int idClasificacion) {
		this.idClasificacion = idClasificacion;
	}
	public String getEstadoRevisionAplicaciones() {
		return estadoRevisionAplicaciones;
	}
	public void setEstadoRevisionAplicaciones(String estadoRevisionAplicaciones) {
		this.estadoRevisionAplicaciones = estadoRevisionAplicaciones;
	}

	public int getIdCriticidadFinal() {
		return idCriticidadFinal;
	}
	public void setIdCriticidadFinal(int idCriticidadFinal) {
		this.idCriticidadFinal = idCriticidadFinal;
	}
	public int getIdSwBaseEstandarSistemaOperativoPRE() {
		return idSwBaseEstandarSistemaOperativoPRE;
	}
	public void setIdSwBaseEstandarSistemaOperativoPRE(
			int idSwBaseEstandarSistemaOperativoPRE) {
		this.idSwBaseEstandarSistemaOperativoPRE = idSwBaseEstandarSistemaOperativoPRE;
	}
	public String getSwBaseSistemaOperativoOtrosPRE() {
		return swBaseSistemaOperativoOtrosPRE;
	}
	public void setSwBaseSistemaOperativoOtrosPRE(
			String swBaseSistemaOperativoOtrosPRE) {
		this.swBaseSistemaOperativoOtrosPRE = swBaseSistemaOperativoOtrosPRE;
	}
	public int getIdSwBaseEstandarHeramientaProgramacionPRE() {
		return idSwBaseEstandarHeramientaProgramacionPRE;
	}
	public void setIdSwBaseEstandarHeramientaProgramacionPRE(
			int idSwBaseEstandarHeramientaProgramacionPRE) {
		this.idSwBaseEstandarHeramientaProgramacionPRE = idSwBaseEstandarHeramientaProgramacionPRE;
	}
	public String getSwBaseHerramientaProgramacionOtrosPRE() {
		return swBaseHerramientaProgramacionOtrosPRE;
	}
	public void setSwBaseHerramientaProgramacionOtrosPRE(
			String swBaseHerramientaProgramacionOtrosPRE) {
		this.swBaseHerramientaProgramacionOtrosPRE = swBaseHerramientaProgramacionOtrosPRE;
	}
	public int getIdSwBaseEstandarLenguajeProgramacionPRE() {
		return idSwBaseEstandarLenguajeProgramacionPRE;
	}
	public void setIdSwBaseEstandarLenguajeProgramacionPRE(
			int idSwBaseEstandarLenguajeProgramacionPRE) {
		this.idSwBaseEstandarLenguajeProgramacionPRE = idSwBaseEstandarLenguajeProgramacionPRE;
	}
	public String getSwBaseLenguajeProgramacionOtrosPRE() {
		return swBaseLenguajeProgramacionOtrosPRE;
	}
	public void setSwBaseLenguajeProgramacionOtrosPRE(
			String swBaseLenguajeProgramacionOtrosPRE) {
		this.swBaseLenguajeProgramacionOtrosPRE = swBaseLenguajeProgramacionOtrosPRE;
	}
	public int getIdSwBaseEstandarGestorBDPRE() {
		return idSwBaseEstandarGestorBDPRE;
	}
	public void setIdSwBaseEstandarGestorBDPRE(int idSwBaseEstandarGestorBDPRE) {
		this.idSwBaseEstandarGestorBDPRE = idSwBaseEstandarGestorBDPRE;
	}
	public String getSwBaseGestorBDOtrosPRE() {
		return swBaseGestorBDOtrosPRE;
	}
	public void setSwBaseGestorBDOtrosPRE(String swBaseGestorBDOtrosPRE) {
		this.swBaseGestorBDOtrosPRE = swBaseGestorBDOtrosPRE;
	}
	public int getIdSwBaseEstandarFrameworkPRE() {
		return idSwBaseEstandarFrameworkPRE;
	}
	public void setIdSwBaseEstandarFrameworkPRE(int idSwBaseEstandarFrameworkPRE) {
		this.idSwBaseEstandarFrameworkPRE = idSwBaseEstandarFrameworkPRE;
	}
	public String getSwBaseFrameworkOtrosPRE() {
		return swBaseFrameworkOtrosPRE;
	}
	public void setSwBaseFrameworkOtrosPRE(String swBaseFrameworkOtrosPRE) {
		this.swBaseFrameworkOtrosPRE = swBaseFrameworkOtrosPRE;
	}
	public String getSwBaseObservacionesAdicionalesPRE() {
		return swBaseObservacionesAdicionalesPRE;
	}
	public void setSwBaseObservacionesAdicionalesPRE(
			String swBaseObservacionesAdicionalesPRE) {
		this.swBaseObservacionesAdicionalesPRE = swBaseObservacionesAdicionalesPRE;
	}
	public int getIdAccesosGestionPrivilegiosSistemasPRE() {
		return idAccesosGestionPrivilegiosSistemasPRE;
	}
	public void setIdAccesosGestionPrivilegiosSistemasPRE(
			int idAccesosGestionPrivilegiosSistemasPRE) {
		this.idAccesosGestionPrivilegiosSistemasPRE = idAccesosGestionPrivilegiosSistemasPRE;
	}
	public int getIdAccesosRevisionPrivilegiosUsuariosPRE() {
		return idAccesosRevisionPrivilegiosUsuariosPRE;
	}
	public void setIdAccesosRevisionPrivilegiosUsuariosPRE(
			int idAccesosRevisionPrivilegiosUsuariosPRE) {
		this.idAccesosRevisionPrivilegiosUsuariosPRE = idAccesosRevisionPrivilegiosUsuariosPRE;
	}
	public int getIdAccesosGestionContrasenasPRE() {
		return idAccesosGestionContrasenasPRE;
	}
	public void setIdAccesosGestionContrasenasPRE(int idAccesosGestionContrasenasPRE) {
		this.idAccesosGestionContrasenasPRE = idAccesosGestionContrasenasPRE;
	}
	public int getIdAccesosPoliticaContrasenasPRE() {
		return idAccesosPoliticaContrasenasPRE;
	}
	public void setIdAccesosPoliticaContrasenasPRE(
			int idAccesosPoliticaContrasenasPRE) {
		this.idAccesosPoliticaContrasenasPRE = idAccesosPoliticaContrasenasPRE;
	}
	public int getIdAccesosGestionClaves1PRE() {
		return idAccesosGestionClaves1PRE;
	}
	public void setIdAccesosGestionClaves1PRE(int idAccesosGestionClaves1PRE) {
		this.idAccesosGestionClaves1PRE = idAccesosGestionClaves1PRE;
	}
	public int getIdAccesosGestionClaves2PRE() {
		return idAccesosGestionClaves2PRE;
	}
	public void setIdAccesosGestionClaves2PRE(int idAccesosGestionClaves2PRE) {
		this.idAccesosGestionClaves2PRE = idAccesosGestionClaves2PRE;
	}
	public int getIdAccesosGestionClaves3PRE() {
		return idAccesosGestionClaves3PRE;
	}
	public void setIdAccesosGestionClaves3PRE(int idAccesosGestionClaves3PRE) {
		this.idAccesosGestionClaves3PRE = idAccesosGestionClaves3PRE;
	}
	public int getIdAuditoriaRegistroAuditoriaPRE() {
		return idAuditoriaRegistroAuditoriaPRE;
	}
	public void setIdAuditoriaRegistroAuditoriaPRE(
			int idAuditoriaRegistroAuditoriaPRE) {
		this.idAuditoriaRegistroAuditoriaPRE = idAuditoriaRegistroAuditoriaPRE;
	}
	public int getIdAuditoriaProteccionRegistrosAuditoriaPRE() {
		return idAuditoriaProteccionRegistrosAuditoriaPRE;
	}
	public void setIdAuditoriaProteccionRegistrosAuditoriaPRE(
			int idAuditoriaProteccionRegistrosAuditoriaPRE) {
		this.idAuditoriaProteccionRegistrosAuditoriaPRE = idAuditoriaProteccionRegistrosAuditoriaPRE;
	}
	public int getIdAuditoriaRegistroEventosAdministradoresPRE() {
		return idAuditoriaRegistroEventosAdministradoresPRE;
	}
	public void setIdAuditoriaRegistroEventosAdministradoresPRE(
			int idAuditoriaRegistroEventosAdministradoresPRE) {
		this.idAuditoriaRegistroEventosAdministradoresPRE = idAuditoriaRegistroEventosAdministradoresPRE;
	}
	public int getIdAuditoriaConformidadPoliticasPRE() {
		return idAuditoriaConformidadPoliticasPRE;
	}
	public void setIdAuditoriaConformidadPoliticasPRE(
			int idAuditoriaConformidadPoliticasPRE) {
		this.idAuditoriaConformidadPoliticasPRE = idAuditoriaConformidadPoliticasPRE;
	}
	public int getIdContingenciaPRE() {
		return idContingenciaPRE;
	}
	public void setIdContingenciaPRE(int idContingenciaPRE) {
		this.idContingenciaPRE = idContingenciaPRE;
	}
	public int getIdControlCambiosProcedimientosSwPRE() {
		return idControlCambiosProcedimientosSwPRE;
	}
	public void setIdControlCambiosProcedimientosSwPRE(
			int idControlCambiosProcedimientosSwPRE) {
		this.idControlCambiosProcedimientosSwPRE = idControlCambiosProcedimientosSwPRE;
	}
	public int getIdControlCambiosProcedimientosInfraestructuraPRE() {
		return idControlCambiosProcedimientosInfraestructuraPRE;
	}
	public void setIdControlCambiosProcedimientosInfraestructuraPRE(
			int idControlCambiosProcedimientosInfraestructuraPRE) {
		this.idControlCambiosProcedimientosInfraestructuraPRE = idControlCambiosProcedimientosInfraestructuraPRE;
	}
	public int getIdDocumentacionManejoPRE() {
		return idDocumentacionManejoPRE;
	}
	public void setIdDocumentacionManejoPRE(int idDocumentacionManejoPRE) {
		this.idDocumentacionManejoPRE = idDocumentacionManejoPRE;
	}
	public int getIdIncidentesCumplimientoPoliticasAntivirusPRE() {
		return idIncidentesCumplimientoPoliticasAntivirusPRE;
	}
	public void setIdIncidentesCumplimientoPoliticasAntivirusPRE(
			int idIncidentesCumplimientoPoliticasAntivirusPRE) {
		this.idIncidentesCumplimientoPoliticasAntivirusPRE = idIncidentesCumplimientoPoliticasAntivirusPRE;
	}
	public int getIdIncidentesCumplimientoGestionParchesPRE() {
		return idIncidentesCumplimientoGestionParchesPRE;
	}
	public void setIdIncidentesCumplimientoGestionParchesPRE(
			int idIncidentesCumplimientoGestionParchesPRE) {
		this.idIncidentesCumplimientoGestionParchesPRE = idIncidentesCumplimientoGestionParchesPRE;
	}
	public int getIdIncidentesCumplimientoCodigoMaliciosoPRE() {
		return idIncidentesCumplimientoCodigoMaliciosoPRE;
	}
	public void setIdIncidentesCumplimientoCodigoMaliciosoPRE(
			int idIncidentesCumplimientoCodigoMaliciosoPRE) {
		this.idIncidentesCumplimientoCodigoMaliciosoPRE = idIncidentesCumplimientoCodigoMaliciosoPRE;
	}
	public int getIdIntegridadConfidencialidadDatosPruebaPRE() {
		return idIntegridadConfidencialidadDatosPruebaPRE;
	}
	public void setIdIntegridadConfidencialidadDatosPruebaPRE(
			int idIntegridadConfidencialidadDatosPruebaPRE) {
		this.idIntegridadConfidencialidadDatosPruebaPRE = idIntegridadConfidencialidadDatosPruebaPRE;
	}
	public int getIdRespaldosGestionRespaldoRecuperacionPRE() {
		return idRespaldosGestionRespaldoRecuperacionPRE;
	}
	public void setIdRespaldosGestionRespaldoRecuperacionPRE(
			int idRespaldosGestionRespaldoRecuperacionPRE) {
		this.idRespaldosGestionRespaldoRecuperacionPRE = idRespaldosGestionRespaldoRecuperacionPRE;
	}
	public int getIdSwBaseEstandarSistemaOperativoPOST() {
		return idSwBaseEstandarSistemaOperativoPOST;
	}
	public void setIdSwBaseEstandarSistemaOperativoPOST(
			int idSwBaseEstandarSistemaOperativoPOST) {
		this.idSwBaseEstandarSistemaOperativoPOST = idSwBaseEstandarSistemaOperativoPOST;
	}
	public String getSwBaseSistemaOperativoOtrosPOST() {
		return swBaseSistemaOperativoOtrosPOST;
	}
	public void setSwBaseSistemaOperativoOtrosPOST(
			String swBaseSistemaOperativoOtrosPOST) {
		this.swBaseSistemaOperativoOtrosPOST = swBaseSistemaOperativoOtrosPOST;
	}
	public int getIdSwBaseEstandarHeramientaProgramacionPOST() {
		return idSwBaseEstandarHeramientaProgramacionPOST;
	}
	public void setIdSwBaseEstandarHeramientaProgramacionPOST(
			int idSwBaseEstandarHeramientaProgramacionPOST) {
		this.idSwBaseEstandarHeramientaProgramacionPOST = idSwBaseEstandarHeramientaProgramacionPOST;
	}
	public String getSwBaseHerramientaProgramacionOtrosPOST() {
		return swBaseHerramientaProgramacionOtrosPOST;
	}
	public void setSwBaseHerramientaProgramacionOtrosPOST(
			String swBaseHerramientaProgramacionOtrosPOST) {
		this.swBaseHerramientaProgramacionOtrosPOST = swBaseHerramientaProgramacionOtrosPOST;
	}
	public int getIdSwBaseEstandarLenguajeProgramacionPOST() {
		return idSwBaseEstandarLenguajeProgramacionPOST;
	}
	public void setIdSwBaseEstandarLenguajeProgramacionPOST(
			int idSwBaseEstandarLenguajeProgramacionPOST) {
		this.idSwBaseEstandarLenguajeProgramacionPOST = idSwBaseEstandarLenguajeProgramacionPOST;
	}
	public String getSwBaseLenguajeProgramacionOtrosPOST() {
		return swBaseLenguajeProgramacionOtrosPOST;
	}
	public void setSwBaseLenguajeProgramacionOtrosPOST(
			String swBaseLenguajeProgramacionOtrosPOST) {
		this.swBaseLenguajeProgramacionOtrosPOST = swBaseLenguajeProgramacionOtrosPOST;
	}
	public int getIdSwBaseEstandarGestorBDPOST() {
		return idSwBaseEstandarGestorBDPOST;
	}
	public void setIdSwBaseEstandarGestorBDPOST(int idSwBaseEstandarGestorBDPOST) {
		this.idSwBaseEstandarGestorBDPOST = idSwBaseEstandarGestorBDPOST;
	}
	public String getSwBaseGestorBDOtrosPOST() {
		return swBaseGestorBDOtrosPOST;
	}
	public void setSwBaseGestorBDOtrosPOST(String swBaseGestorBDOtrosPOST) {
		this.swBaseGestorBDOtrosPOST = swBaseGestorBDOtrosPOST;
	}
	public int getIdSwBaseEstandarFrameworkPOST() {
		return idSwBaseEstandarFrameworkPOST;
	}
	public void setIdSwBaseEstandarFrameworkPOST(int idSwBaseEstandarFrameworkPOST) {
		this.idSwBaseEstandarFrameworkPOST = idSwBaseEstandarFrameworkPOST;
	}
	public String getSwBaseFrameworkOtrosPOST() {
		return swBaseFrameworkOtrosPOST;
	}
	public void setSwBaseFrameworkOtrosPOST(String swBaseFrameworkOtrosPOST) {
		this.swBaseFrameworkOtrosPOST = swBaseFrameworkOtrosPOST;
	}
	public String getSwBaseObservacionesAdicionalesPOST() {
		return swBaseObservacionesAdicionalesPOST;
	}
	public void setSwBaseObservacionesAdicionalesPOST(
			String swBaseObservacionesAdicionalesPOST) {
		this.swBaseObservacionesAdicionalesPOST = swBaseObservacionesAdicionalesPOST;
	}
	public int getIdAccesosGestionPrivilegiosSistemasPOST() {
		return idAccesosGestionPrivilegiosSistemasPOST;
	}
	public void setIdAccesosGestionPrivilegiosSistemasPOST(
			int idAccesosGestionPrivilegiosSistemasPOST) {
		this.idAccesosGestionPrivilegiosSistemasPOST = idAccesosGestionPrivilegiosSistemasPOST;
	}
	public int getIdAccesosRevisionPrivilegiosUsuariosPOST() {
		return idAccesosRevisionPrivilegiosUsuariosPOST;
	}
	public void setIdAccesosRevisionPrivilegiosUsuariosPOST(
			int idAccesosRevisionPrivilegiosUsuariosPOST) {
		this.idAccesosRevisionPrivilegiosUsuariosPOST = idAccesosRevisionPrivilegiosUsuariosPOST;
	}
	public int getIdAccesosGestionContrasenasPOST() {
		return idAccesosGestionContrasenasPOST;
	}
	public void setIdAccesosGestionContrasenasPOST(
			int idAccesosGestionContrasenasPOST) {
		this.idAccesosGestionContrasenasPOST = idAccesosGestionContrasenasPOST;
	}
	public int getIdAccesosPoliticaContrasenasPOST() {
		return idAccesosPoliticaContrasenasPOST;
	}
	public void setIdAccesosPoliticaContrasenasPOST(
			int idAccesosPoliticaContrasenasPOST) {
		this.idAccesosPoliticaContrasenasPOST = idAccesosPoliticaContrasenasPOST;
	}
	public int getIdAccesosGestionClaves1POST() {
		return idAccesosGestionClaves1POST;
	}
	public void setIdAccesosGestionClaves1POST(int idAccesosGestionClaves1POST) {
		this.idAccesosGestionClaves1POST = idAccesosGestionClaves1POST;
	}
	public int getIdAccesosGestionClaves2POST() {
		return idAccesosGestionClaves2POST;
	}
	public void setIdAccesosGestionClaves2POST(int idAccesosGestionClaves2POST) {
		this.idAccesosGestionClaves2POST = idAccesosGestionClaves2POST;
	}
	public int getIdAccesosGestionClaves3POST() {
		return idAccesosGestionClaves3POST;
	}
	public void setIdAccesosGestionClaves3POST(int idAccesosGestionClaves3POST) {
		this.idAccesosGestionClaves3POST = idAccesosGestionClaves3POST;
	}
	public int getIdAuditoriaRegistroAuditoriaPOST() {
		return idAuditoriaRegistroAuditoriaPOST;
	}
	public void setIdAuditoriaRegistroAuditoriaPOST(
			int idAuditoriaRegistroAuditoriaPOST) {
		this.idAuditoriaRegistroAuditoriaPOST = idAuditoriaRegistroAuditoriaPOST;
	}
	public int getIdAuditoriaProteccionRegistrosAuditoriaPOST() {
		return idAuditoriaProteccionRegistrosAuditoriaPOST;
	}
	public void setIdAuditoriaProteccionRegistrosAuditoriaPOST(
			int idAuditoriaProteccionRegistrosAuditoriaPOST) {
		this.idAuditoriaProteccionRegistrosAuditoriaPOST = idAuditoriaProteccionRegistrosAuditoriaPOST;
	}
	public int getIdAuditoriaRegistroEventosAdministradoresPOST() {
		return idAuditoriaRegistroEventosAdministradoresPOST;
	}
	public void setIdAuditoriaRegistroEventosAdministradoresPOST(
			int idAuditoriaRegistroEventosAdministradoresPOST) {
		this.idAuditoriaRegistroEventosAdministradoresPOST = idAuditoriaRegistroEventosAdministradoresPOST;
	}
	public int getIdAuditoriaConformidadPoliticasPOST() {
		return idAuditoriaConformidadPoliticasPOST;
	}
	public void setIdAuditoriaConformidadPoliticasPOST(
			int idAuditoriaConformidadPoliticasPOST) {
		this.idAuditoriaConformidadPoliticasPOST = idAuditoriaConformidadPoliticasPOST;
	}
	public int getIdContingenciaPOST() {
		return idContingenciaPOST;
	}
	public void setIdContingenciaPOST(int idContingenciaPOST) {
		this.idContingenciaPOST = idContingenciaPOST;
	}
	public int getIdControlCambiosProcedimientosSwPOST() {
		return idControlCambiosProcedimientosSwPOST;
	}
	public void setIdControlCambiosProcedimientosSwPOST(
			int idControlCambiosProcedimientosSwPOST) {
		this.idControlCambiosProcedimientosSwPOST = idControlCambiosProcedimientosSwPOST;
	}
	public int getIdControlCambiosProcedimientosInfraestructuraPOST() {
		return idControlCambiosProcedimientosInfraestructuraPOST;
	}
	public void setIdControlCambiosProcedimientosInfraestructuraPOST(
			int idControlCambiosProcedimientosInfraestructuraPOST) {
		this.idControlCambiosProcedimientosInfraestructuraPOST = idControlCambiosProcedimientosInfraestructuraPOST;
	}
	public int getIdDocumentacionManejoPOST() {
		return idDocumentacionManejoPOST;
	}
	public void setIdDocumentacionManejoPOST(int idDocumentacionManejoPOST) {
		this.idDocumentacionManejoPOST = idDocumentacionManejoPOST;
	}
	public int getIdIncidentesCumplimientoPoliticasAntivirusPOST() {
		return idIncidentesCumplimientoPoliticasAntivirusPOST;
	}
	public void setIdIncidentesCumplimientoPoliticasAntivirusPOST(
			int idIncidentesCumplimientoPoliticasAntivirusPOST) {
		this.idIncidentesCumplimientoPoliticasAntivirusPOST = idIncidentesCumplimientoPoliticasAntivirusPOST;
	}
	public int getIdIncidentesCumplimientoGestionParchesPOST() {
		return idIncidentesCumplimientoGestionParchesPOST;
	}
	public void setIdIncidentesCumplimientoGestionParchesPOST(
			int idIncidentesCumplimientoGestionParchesPOST) {
		this.idIncidentesCumplimientoGestionParchesPOST = idIncidentesCumplimientoGestionParchesPOST;
	}
	public int getIdIncidentesCumplimientoCodigoMaliciosoPOST() {
		return idIncidentesCumplimientoCodigoMaliciosoPOST;
	}
	public void setIdIncidentesCumplimientoCodigoMaliciosoPOST(
			int idIncidentesCumplimientoCodigoMaliciosoPOST) {
		this.idIncidentesCumplimientoCodigoMaliciosoPOST = idIncidentesCumplimientoCodigoMaliciosoPOST;
	}
	public int getIdIntegridadConfidencialidadDatosPruebaPOST() {
		return idIntegridadConfidencialidadDatosPruebaPOST;
	}
	public void setIdIntegridadConfidencialidadDatosPruebaPOST(
			int idIntegridadConfidencialidadDatosPruebaPOST) {
		this.idIntegridadConfidencialidadDatosPruebaPOST = idIntegridadConfidencialidadDatosPruebaPOST;
	}
	public int getIdRespaldosGestionRespaldoRecuperacionPOST() {
		return idRespaldosGestionRespaldoRecuperacionPOST;
	}
	public void setIdRespaldosGestionRespaldoRecuperacionPOST(
			int idRespaldosGestionRespaldoRecuperacionPOST) {
		this.idRespaldosGestionRespaldoRecuperacionPOST = idRespaldosGestionRespaldoRecuperacionPOST;
	}
	
	public int getActividadImpacto() {
		return actividadImpacto;
	}
	public void setActividadImpacto(int actividadImpacto) {
		this.actividadImpacto = actividadImpacto;
	}
	public int getActividadDominio() {
		return actividadDominio;
	}
	public void setActividadDominio(int actividadDominio) {
		this.actividadDominio = actividadDominio;
	}
	public int getIdProcesoAuditoriaI() {
		return idProcesoAuditoriaI;
	}
	public void setIdProcesoAuditoriaI(int idProcesoAuditoriaI) {
		this.idProcesoAuditoriaI = idProcesoAuditoriaI;
	}
	public int getIdEstadoRevisionAplicaciones() {
		return idEstadoRevisionAplicaciones;
	}
	public void setIdEstadoRevisionAplicaciones(int idEstadoRevisionAplicaciones) {
		this.idEstadoRevisionAplicaciones = idEstadoRevisionAplicaciones;
	}
	public int getIdMotivoCreacion() {
		return idMotivoCreacion;
	}
	public void setIdMotivoCreacion(int idMotivoCreacion) {
		this.idMotivoCreacion = idMotivoCreacion;
	}
	public int getIdTocaProcesoClave() {
		return idTocaProcesoClave;
	}
	public void setIdTocaProcesoClave(int idTocaProcesoClave) {
		this.idTocaProcesoClave = idTocaProcesoClave;
	}
	public int getIdImpactaProcesoClave() {
		return idImpactaProcesoClave;
	}
	public void setIdImpactaProcesoClave(int idImpactaProcesoClave) {
		this.idImpactaProcesoClave = idImpactaProcesoClave;
	}
	/*public String getIdProcesoClave() {
		return idProcesoClave;
	}
	public void setIdProcesoClave(String idProcesoClave) {
		this.idProcesoClave = idProcesoClave;
	}*/
	public int getIdDomProcesoClave() {
		return idDomProcesoClave;
	}
	public void setIdDomProcesoClave(int idDomProcesoClave) {
		this.idDomProcesoClave = idDomProcesoClave;
	}
	public int getIdImpProcesoClave() {
		return idImpProcesoClave;
	}
	public void setIdImpProcesoClave(int idImpProcesoClave) {
		this.idImpProcesoClave = idImpProcesoClave;
	}
	
}
