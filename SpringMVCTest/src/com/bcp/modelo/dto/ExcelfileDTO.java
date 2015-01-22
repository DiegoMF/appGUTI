package com.bcp.modelo.dto;

public class ExcelfileDTO {

	// ESTRUCTURA ORGANIZACIONAL
	/***
	 * app_esp_estructura_organizacional
	 */
	private String estructura_gerenciaCentral;
	private String estructura_division;
	private String estructura_area;
	private String estructura_unidad;

	public String getEstructura_gerenciaCentral() {
		return estructura_gerenciaCentral;
	}

	public void setEstructura_gerenciaCentral(String estructura_gerenciaCentral) {
		this.estructura_gerenciaCentral = estructura_gerenciaCentral;
	}

	public String getEstructura_division() {
		return estructura_division;
	}

	public void setEstructura_division(String estructura_division) {
		this.estructura_division = estructura_division;
	}

	public String getEstructura_area() {
		return estructura_area;
	}

	public void setEstructura_area(String estructura_area) {
		this.estructura_area = estructura_area;
	}

	public String getEstructura_unidad() {
		return estructura_unidad;
	}

	public void setEstructura_unidad(String estructura_unidad) {
		this.estructura_unidad = estructura_unidad;
	}

	// INFORMACION GENERAL
	/***
	 * app_esp_informacion_general
	 */
	private String informacion_nombreAplicacion;
	private String informacion_descripcionAplicacion;
	private String informacion_funcionalidades;
	private String informacion_estado;
	private String informacion_tipoOperacion;
	private String informacion_frecuenciaOperacion;
	private String informacion_cantidadOperacion;
	private String informacion_fechaCreacion;
	private String informacion_motivoCreacion;
	private String informacion_motivoCreacionOtros;
	private int informacion_numeroFuncionalidades;
	private int informacion_numeroReportes;
	private int informacion_numeroConsultas;
	private int informacion_numeroEntidadesExternas;
	private int informacion_numeroEntidadesInternas;
	private String informacion_observacionesGenerales;

	public String getInformacion_nombreAplicacion() {
		return informacion_nombreAplicacion;
	}

	public void setInformacion_nombreAplicacion(
			String informacion_nombreAplicacion) {
		this.informacion_nombreAplicacion = informacion_nombreAplicacion;
	}

	public String getInformacion_descripcionAplicacion() {
		return informacion_descripcionAplicacion;
	}

	public void setInformacion_descripcionAplicacion(
			String informacion_descripcionAplicacion) {
		this.informacion_descripcionAplicacion = informacion_descripcionAplicacion;
	}

	public String getInformacion_funcionalidades() {
		return informacion_funcionalidades;
	}

	public void setInformacion_funcionalidades(
			String informacion_funcionalidades) {
		this.informacion_funcionalidades = informacion_funcionalidades;
	}

	public String getInformacion_estado() {
		return informacion_estado;
	}

	public void setInformacion_estado(String informacion_estado) {
		this.informacion_estado = informacion_estado;
	}

	public String getInformacion_tipoOperacion() {
		return informacion_tipoOperacion;
	}

	public void setInformacion_tipoOperacion(String informacion_tipoOperacion) {
		this.informacion_tipoOperacion = informacion_tipoOperacion;
	}

	public String getInformacion_frecuenciaOperacion() {
		return informacion_frecuenciaOperacion;
	}

	public void setInformacion_frecuenciaOperacion(
			String informacion_frecuenciaOperacion) {
		this.informacion_frecuenciaOperacion = informacion_frecuenciaOperacion;
	}

	public String getInformacion_cantidadOperacion() {
		return informacion_cantidadOperacion;
	}

	public void setInformacion_cantidadOperacion(
			String informacion_cantidadOperacion) {
		this.informacion_cantidadOperacion = informacion_cantidadOperacion;
	}

	public String getInformacion_fechaCreacion() {
		return informacion_fechaCreacion;
	}

	public void setInformacion_fechaCreacion(String informacion_fechaCreacion) {
		this.informacion_fechaCreacion = informacion_fechaCreacion;
	}

	public String getInformacion_motivoCreacion() {
		return informacion_motivoCreacion;
	}

	public void setInformacion_motivoCreacion(String informacion_motivoCreacion) {
		this.informacion_motivoCreacion = informacion_motivoCreacion;
	}

	public String getInformacion_motivoCreacionOtros() {
		return informacion_motivoCreacionOtros;
	}

	public void setInformacion_motivoCreacionOtros(
			String informacion_motivoCreacionOtros) {
		this.informacion_motivoCreacionOtros = informacion_motivoCreacionOtros;
	}

	public int getInformacion_numeroFuncionalidades() {
		return informacion_numeroFuncionalidades;
	}

	public void setInformacion_numeroFuncionalidades(
			int informacion_numeroFuncionalidades) {
		this.informacion_numeroFuncionalidades = informacion_numeroFuncionalidades;
	}

	public int getInformacion_numeroReportes() {
		return informacion_numeroReportes;
	}

	public void setInformacion_numeroReportes(int informacion_numeroReportes) {
		this.informacion_numeroReportes = informacion_numeroReportes;
	}

	public int getInformacion_numeroConsultas() {
		return informacion_numeroConsultas;
	}

	public void setInformacion_numeroConsultas(int informacion_numeroConsultas) {
		this.informacion_numeroConsultas = informacion_numeroConsultas;
	}

	public int getInformacion_numeroEntidadesExternas() {
		return informacion_numeroEntidadesExternas;
	}

	public void setInformacion_numeroEntidadesExternas(
			int informacion_numeroEntidadesExternas) {
		this.informacion_numeroEntidadesExternas = informacion_numeroEntidadesExternas;
	}

	public int getInformacion_numeroEntidadesInternas() {
		return informacion_numeroEntidadesInternas;
	}

	public void setInformacion_numeroEntidadesInternas(
			int informacion_numeroEntidadesInternas) {
		this.informacion_numeroEntidadesInternas = informacion_numeroEntidadesInternas;
	}

	public String getInformacion_observacionesGenerales() {
		return informacion_observacionesGenerales;
	}

	public void setInformacion_observacionesGenerales(
			String informacion_observacionesGenerales) {
		this.informacion_observacionesGenerales = informacion_observacionesGenerales;
	}

	// CARACTERISTICAS TECNICAS
	/***
	 * app_esp_caracteristicas_tecnicas
	 */
	private String caracteristica_categoriaTecnologica;
	private String caracteristica_tipoDesarrollo;
	private String caracteristica_ubicacionFisica;
	private String caracteristica_ambienteAppNoIT;
	private String caracteristica_nombreUbicacion;
	private String caracteristica_infraestructuraAplicacion;
	private String caracteristica_standAlone;
	private int caracteristica_numeroInterfaces;
	private String caracteristica_nombreInterfaces;
	private String caracteristica_mantenimientoAplicacion;
	private String caracteristica_nombreProveedorMantenimiento;
	private String caracteristica_soporteAplicacion;
	private String caracteristica_nombreProveedorSoporte;
	private String caracteristica_accesoAplicacion;
	private String caracteristica_nombreProveedorAcceso;
	private String caracteristica_nombreServidor;
	private String caracteristica_ubicacionServidor;

	public String getCaracteristica_categoriaTecnologica() {
		return caracteristica_categoriaTecnologica;
	}

	public void setCaracteristica_categoriaTecnologica(
			String caracteristica_categoriaTecnologica) {
		this.caracteristica_categoriaTecnologica = caracteristica_categoriaTecnologica;
	}

	public String getCaracteristica_tipoDesarrollo() {
		return caracteristica_tipoDesarrollo;
	}

	public void setCaracteristica_tipoDesarrollo(
			String caracteristica_tipoDesarrollo) {
		this.caracteristica_tipoDesarrollo = caracteristica_tipoDesarrollo;
	}

	public String getCaracteristica_ubicacionFisica() {
		return caracteristica_ubicacionFisica;
	}

	public void setCaracteristica_ubicacionFisica(
			String caracteristica_ubicacionFisica) {
		this.caracteristica_ubicacionFisica = caracteristica_ubicacionFisica;
	}

	public String getCaracteristica_ambienteAppNoIT() {
		return caracteristica_ambienteAppNoIT;
	}

	public void setCaracteristica_ambienteAppNoIT(
			String caracteristica_ambienteAppNoIT) {
		this.caracteristica_ambienteAppNoIT = caracteristica_ambienteAppNoIT;
	}

	public String getCaracteristica_nombreUbicacion() {
		return caracteristica_nombreUbicacion;
	}

	public void setCaracteristica_nombreUbicacion(
			String caracteristica_nombreUbicacion) {
		this.caracteristica_nombreUbicacion = caracteristica_nombreUbicacion;
	}

	public String getCaracteristica_infraestructuraAplicacion() {
		return caracteristica_infraestructuraAplicacion;
	}

	public void setCaracteristica_infraestructuraAplicacion(
			String caracteristica_infraestructuraAplicacion) {
		this.caracteristica_infraestructuraAplicacion = caracteristica_infraestructuraAplicacion;
	}

	public String getCaracteristica_standAlone() {
		return caracteristica_standAlone;
	}

	public void setCaracteristica_standAlone(String caracteristica_standAlone) {
		this.caracteristica_standAlone = caracteristica_standAlone;
	}

	public int getCaracteristica_numeroInterfaces() {
		return caracteristica_numeroInterfaces;
	}

	public void setCaracteristica_numeroInterfaces(
			int caracteristica_numeroInterfaces) {
		this.caracteristica_numeroInterfaces = caracteristica_numeroInterfaces;
	}

	public String getCaracteristica_nombreInterfaces() {
		return caracteristica_nombreInterfaces;
	}

	public void setCaracteristica_nombreInterfaces(
			String caracteristica_nombreInterfaces) {
		this.caracteristica_nombreInterfaces = caracteristica_nombreInterfaces;
	}

	public String getCaracteristica_mantenimientoAplicacion() {
		return caracteristica_mantenimientoAplicacion;
	}

	public void setCaracteristica_mantenimientoAplicacion(
			String caracteristica_mantenimientoAplicacion) {
		this.caracteristica_mantenimientoAplicacion = caracteristica_mantenimientoAplicacion;
	}

	public String getCaracteristica_nombreProveedorMantenimiento() {
		return caracteristica_nombreProveedorMantenimiento;
	}

	public void setCaracteristica_nombreProveedorMantenimiento(
			String caracteristica_nombreProveedorMantenimiento) {
		this.caracteristica_nombreProveedorMantenimiento = caracteristica_nombreProveedorMantenimiento;
	}

	public String getCaracteristica_soporteAplicacion() {
		return caracteristica_soporteAplicacion;
	}

	public void setCaracteristica_soporteAplicacion(
			String caracteristica_soporteAplicacion) {
		this.caracteristica_soporteAplicacion = caracteristica_soporteAplicacion;
	}

	public String getCaracteristica_nombreProveedorSoporte() {
		return caracteristica_nombreProveedorSoporte;
	}

	public void setCaracteristica_nombreProveedorSoporte(
			String caracteristica_nombreProveedorSoporte) {
		this.caracteristica_nombreProveedorSoporte = caracteristica_nombreProveedorSoporte;
	}

	public String getCaracteristica_accesoAplicacion() {
		return caracteristica_accesoAplicacion;
	}

	public void setCaracteristica_accesoAplicacion(
			String caracteristica_accesoAplicacion) {
		this.caracteristica_accesoAplicacion = caracteristica_accesoAplicacion;
	}

	public String getCaracteristica_nombreProveedorAcceso() {
		return caracteristica_nombreProveedorAcceso;
	}

	public void setCaracteristica_nombreProveedorAcceso(
			String caracteristica_nombreProveedorAcceso) {
		this.caracteristica_nombreProveedorAcceso = caracteristica_nombreProveedorAcceso;
	}

	public String getCaracteristica_nombreServidor() {
		return caracteristica_nombreServidor;
	}

	public void setCaracteristica_nombreServidor(
			String caracteristica_nombreServidor) {
		this.caracteristica_nombreServidor = caracteristica_nombreServidor;
	}

	public String getCaracteristica_ubicacionServidor() {
		return caracteristica_ubicacionServidor;
	}

	public void setCaracteristica_ubicacionServidor(
			String caracteristica_ubicacionServidor) {
		this.caracteristica_ubicacionServidor = caracteristica_ubicacionServidor;
	}

	// DOMINIO
	private String dominio_usuarioAplicacion;
	private String dominio_gestorAplicacion;
	private String dominio_especialistaAplicacion;
	private String dominio_brokerSistemas;
	private String dominio_brokerNegocio;
	private String dominio_asesorGUTI;
	private String dominio_entidadUsuario;
	private String dominio_nombreDominio;
	private String dominio_nombreSUBDominio;
	private int dominio_numeroUnidadesAplicacion;
	private String dominio_nombreUnidad1;
	private String dominio_nombreUnidad2;
	private String dominio_nombreUnidad3;
	private String dominio_usuariosTotalAplicacion;
	private String dominio_procesoAuditoria;
	private String dominio_procesoAuditoriaOtros;
	private String dominio_procesoClave;
	private String dominio_nombreProcesoClave;
	private String dominio_nombreProcesoClaveOtros;
	private String dominio_actividad;
	private String dominio_CIF;

	public String getDominio_usuarioAplicacion() {
		return dominio_usuarioAplicacion;
	}

	public void setDominio_usuarioAplicacion(String dominio_usuarioAplicacion) {
		this.dominio_usuarioAplicacion = dominio_usuarioAplicacion;
	}

	public String getDominio_gestorAplicacion() {
		return dominio_gestorAplicacion;
	}

	public void setDominio_gestorAplicacion(String dominio_gestorAplicacion) {
		this.dominio_gestorAplicacion = dominio_gestorAplicacion;
	}

	public String getDominio_especialistaAplicacion() {
		return dominio_especialistaAplicacion;
	}

	public void setDominio_especialistaAplicacion(
			String dominio_especialistaAplicacion) {
		this.dominio_especialistaAplicacion = dominio_especialistaAplicacion;
	}

	public String getDominio_brokerSistemas() {
		return dominio_brokerSistemas;
	}

	public void setDominio_brokerSistemas(String dominio_brokerSistemas) {
		this.dominio_brokerSistemas = dominio_brokerSistemas;
	}

	public String getDominio_brokerNegocio() {
		return dominio_brokerNegocio;
	}

	public void setDominio_brokerNegocio(String dominio_brokerNegocio) {
		this.dominio_brokerNegocio = dominio_brokerNegocio;
	}

	public String getDominio_asesorGUTI() {
		return dominio_asesorGUTI;
	}

	public void setDominio_asesorGUTI(String dominio_asesorGUTI) {
		this.dominio_asesorGUTI = dominio_asesorGUTI;
	}

	public String getDominio_entidadUsuario() {
		return dominio_entidadUsuario;
	}

	public void setDominio_entidadUsuario(String dominio_entidadUsuario) {
		this.dominio_entidadUsuario = dominio_entidadUsuario;
	}

	public String getDominio_nombreDominio() {
		return dominio_nombreDominio;
	}

	public void setDominio_nombreDominio(String dominio_nombreDominio) {
		this.dominio_nombreDominio = dominio_nombreDominio;
	}

	public String getDominio_nombreSUBDominio() {
		return dominio_nombreSUBDominio;
	}

	public void setDominio_nombreSUBDominio(String dominio_nombreSUBDominio) {
		this.dominio_nombreSUBDominio = dominio_nombreSUBDominio;
	}

	public int getDominio_numeroUnidadesAplicacion() {
		return dominio_numeroUnidadesAplicacion;
	}

	public void setDominio_numeroUnidadesAplicacion(
			int dominio_numeroUnidadesAplicacion) {
		this.dominio_numeroUnidadesAplicacion = dominio_numeroUnidadesAplicacion;
	}

	public String getDominio_nombreUnidad1() {
		return dominio_nombreUnidad1;
	}

	public void setDominio_nombreUnidad1(String dominio_nombreUnidad1) {
		this.dominio_nombreUnidad1 = dominio_nombreUnidad1;
	}

	public String getDominio_nombreUnidad2() {
		return dominio_nombreUnidad2;
	}

	public void setDominio_nombreUnidad2(String dominio_nombreUnidad2) {
		this.dominio_nombreUnidad2 = dominio_nombreUnidad2;
	}

	public String getDominio_nombreUnidad3() {
		return dominio_nombreUnidad3;
	}

	public void setDominio_nombreUnidad3(String dominio_nombreUnidad3) {
		this.dominio_nombreUnidad3 = dominio_nombreUnidad3;
	}

	public String getDominio_usuariosTotalAplicacion() {
		return dominio_usuariosTotalAplicacion;
	}

	public void setDominio_usuariosTotalAplicacion(
			String dominio_usuariosTotalAplicacion) {
		this.dominio_usuariosTotalAplicacion = dominio_usuariosTotalAplicacion;
	}

	public String getDominio_procesoAuditoria() {
		return dominio_procesoAuditoria;
	}

	public void setDominio_procesoAuditoria(String dominio_procesoAuditoria) {
		this.dominio_procesoAuditoria = dominio_procesoAuditoria;
	}

	public String getDominio_procesoAuditoriaOtros() {
		return dominio_procesoAuditoriaOtros;
	}

	public void setDominio_procesoAuditoriaOtros(
			String dominio_procesoAuditoriaOtros) {
		this.dominio_procesoAuditoriaOtros = dominio_procesoAuditoriaOtros;
	}

	public String getDominio_procesoClave() {
		return dominio_procesoClave;
	}

	public void setDominio_procesoClave(String dominio_procesoClave) {
		this.dominio_procesoClave = dominio_procesoClave;
	}

	public String getDominio_nombreProcesoClave() {
		return dominio_nombreProcesoClave;
	}

	public void setDominio_nombreProcesoClave(String dominio_nombreProcesoClave) {
		this.dominio_nombreProcesoClave = dominio_nombreProcesoClave;
	}

	public String getDominio_nombreProcesoClaveOtros() {
		return dominio_nombreProcesoClaveOtros;
	}

	public void setDominio_nombreProcesoClaveOtros(
			String dominio_nombreProcesoClaveOtros) {
		this.dominio_nombreProcesoClaveOtros = dominio_nombreProcesoClaveOtros;
	}

	public String getDominio_actividad() {
		return dominio_actividad;
	}

	public void setDominio_actividad(String dominio_actividad) {
		this.dominio_actividad = dominio_actividad;
	}

	public String getDominio_CIF() {
		return dominio_CIF;
	}

	public void setDominio_CIF(String dominio_CIF) {
		this.dominio_CIF = dominio_CIF;
	}

	// EVALUACION Y CLASIFICACION DE LOS ACTIVOS DE INFORMACION
	/**
	 * app_esp_dominio
	 */
	private String evaluacion_confidencialidad;
	private String evaluacion_integridad;
	private String evaluacion_disponibilidad;
	private String evaluacion_privacidad;
	private String evaluacion_clasificacion;
	private String evaluacion_observacion;
	private String evaluacion_criticidadFinal;

	public String getEvaluacion_confidencialidad() {
		return evaluacion_confidencialidad;
	}

	public void setEvaluacion_confidencialidad(
			String evaluacion_confidencialidad) {
		this.evaluacion_confidencialidad = evaluacion_confidencialidad;
	}

	public String getEvaluacion_integridad() {
		return evaluacion_integridad;
	}

	public void setEvaluacion_integridad(String evaluacion_integridad) {
		this.evaluacion_integridad = evaluacion_integridad;
	}

	public String getEvaluacion_disponibilidad() {
		return evaluacion_disponibilidad;
	}

	public void setEvaluacion_disponibilidad(String evaluacion_disponibilidad) {
		this.evaluacion_disponibilidad = evaluacion_disponibilidad;
	}

	public String getEvaluacion_privacidad() {
		return evaluacion_privacidad;
	}

	public void setEvaluacion_privacidad(String evaluacion_privacidad) {
		this.evaluacion_privacidad = evaluacion_privacidad;
	}

	public String getEvaluacion_clasificacion() {
		return evaluacion_clasificacion;
	}

	public void setEvaluacion_clasificacion(String evaluacion_clasificacion) {
		this.evaluacion_clasificacion = evaluacion_clasificacion;
	}

	public String getEvaluacion_observacion() {
		return evaluacion_observacion;
	}

	public void setEvaluacion_observacion(String evaluacion_observacion) {
		this.evaluacion_observacion = evaluacion_observacion;
	}

	public String getEvaluacion_criticidadFinal() {
		return evaluacion_criticidadFinal;
	}

	public void setEvaluacion_criticidadFinal(String evaluacion_criticidadFinal) {
		this.evaluacion_criticidadFinal = evaluacion_criticidadFinal;
	}

	/**
	 * 
	 * Envia los datos al DTO
	 * 
	 */

	public void sendDataDTO(int count, String obj) {
		switch (count) {
		case 1:
			 estructura_gerenciaCentral = obj;
			break;
		case 2:
			 estructura_division = obj;
			break;
		case 3:
			 estructura_area = obj;
			break;
		case 4:
			estructura_unidad = obj;
			break;
			
		/**********************************************/
			
		case 5:
			informacion_nombreAplicacion = obj;
			break;
		case 6:
			 informacion_descripcionAplicacion = obj;
			break;
		case 7:
			 informacion_funcionalidades = obj;
			break;
		case 8:
			 informacion_estado = obj;
			break;
		case 9:
			 informacion_tipoOperacion = obj;
			break;
		case 10:
			 informacion_frecuenciaOperacion = obj;
			break;
		case 11:
			 informacion_cantidadOperacion = obj;
			break;
		case 12:
			 informacion_fechaCreacion = obj;
			break;
		case 13:
			 informacion_motivoCreacion = obj;
			break;
		case 14:
			 informacion_motivoCreacionOtros = obj;
			break;
		case 15:
			 informacion_numeroFuncionalidades = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 16:
			 informacion_numeroReportes = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 17:
			 informacion_numeroConsultas = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 18:
			 informacion_numeroEntidadesExternas = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 19:
			 informacion_numeroEntidadesInternas = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 20:
			 informacion_observacionesGenerales = obj;
			break;

		/**********************************************/

		case 21:
			 caracteristica_categoriaTecnologica = obj;
			break;
		case 22:
			 caracteristica_tipoDesarrollo = obj;
			break;
		case 23:
			 caracteristica_ubicacionFisica = obj;
			break;
		case 24:
			 caracteristica_ambienteAppNoIT = obj;
			break;
		case 25:
			 caracteristica_nombreUbicacion = obj;
			break;
		case 26:
			 caracteristica_infraestructuraAplicacion = obj;
			break;
		case 27:
			 caracteristica_standAlone = obj;
			break;
		case 28:
			 caracteristica_numeroInterfaces = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 29:
			 caracteristica_nombreInterfaces = obj;
			break;
		case 30:
			 caracteristica_mantenimientoAplicacion = obj;
			break;
		case 31:
			 caracteristica_nombreProveedorMantenimiento = obj;
			break;
		case 32:
			 caracteristica_soporteAplicacion = obj;
			break;
		case 33:
			 caracteristica_nombreProveedorSoporte = obj;
			break;
		case 34:
			 caracteristica_accesoAplicacion = obj;
			break;
		case 35:
			 caracteristica_nombreProveedorAcceso = obj;
			break;
		case 36:
			 caracteristica_nombreServidor = obj;
			break;
		case 37:
			 caracteristica_ubicacionServidor = obj;
			break;
		
		/**********************************************/
			
		case 38:
			 dominio_usuarioAplicacion = obj;
			break;
		case 39:
			 dominio_gestorAplicacion = obj;
			break;
		case 40:
			 dominio_especialistaAplicacion = obj;
			break;
		case 41:
			 dominio_brokerSistemas = obj;
			break;
		case 42:
			 dominio_brokerNegocio = obj;
			break;
		case 43:
			 dominio_asesorGUTI = obj;
			break;
		case 44:
			 dominio_entidadUsuario = obj;
			break;
		case 45:
			 dominio_nombreDominio = obj;
			break;
		case 46:
			 dominio_nombreSUBDominio = obj;
			break;
		case 47:
			 dominio_numeroUnidadesAplicacion = obj==null || obj.equals("")?0:Integer.parseInt(obj);
			break;
		case 48:
			 dominio_nombreUnidad1 = obj;
			break;
		case 49:
			 dominio_nombreUnidad2 = obj;
			break;
		case 50:
			 dominio_nombreUnidad3 = obj;
			break;
		case 51:
			 dominio_usuariosTotalAplicacion = obj;
			break;
		case 52:
			 dominio_procesoAuditoria = obj;
			break;
		case 53:
			 dominio_procesoAuditoriaOtros = obj;
			break;
		case 54:
			 dominio_procesoClave = obj;
			break;
		case 55:
			 dominio_nombreProcesoClave = obj;
			break;
		case 56:
			 dominio_nombreProcesoClaveOtros = obj;
			break;
		case 57:
			 dominio_actividad = obj;
			break;
		case 58:
			 dominio_CIF = obj;
			break;
			
		/**********************************************/
			
		case 59:
			 evaluacion_confidencialidad = obj;
			break;
		case 60:
			 evaluacion_integridad = obj;
			break;
		case 61:
			 evaluacion_disponibilidad = obj;
			break;
		case 62:
			 evaluacion_privacidad = obj;
			break;
		case 63:
			 evaluacion_clasificacion = obj;
			break;
		case 64:
			 evaluacion_observacion = obj;
			break;
//		case 65:
//			 evaluacion_criticidadFinal = obj;
//			break;
		case 67:
			 evaluacion_criticidadFinal = obj;
			break;
		default:
			break;
		}
	}
}
