package com.bcp.modelo;

public class AppEspInformacionPlanRoadmap {
	private int idAplicacionEspecializada;
	private int idVersion;
	private String roadmapCortoPlazo;
	private String roadmapLargoPlazo;
	private int idEstadoAtencionRoadmap;
	private int idEtapaAtencionRoadmap;
	//Date
	private String fechaInicioPlanificado;
	private String fechaCompromiso;
	private String roadmapEjecutadoActual;
	private String trackAtencion;
	public int getIdAplicacionEspecializada() {
		return idAplicacionEspecializada;
	}
	public void setIdAplicacionEspecializada(int idAplicacionEspecializada) {
		this.idAplicacionEspecializada = idAplicacionEspecializada;
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
	public String getFechaCompromiso() {
		return fechaCompromiso;
	}
	public void setFechaCompromiso(String fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}
	public String getFechaInicioPlanificado() {
		return fechaInicioPlanificado;
	}
	public void setFechaInicioPlanificado(String fechaInicioPlanificado) {
		this.fechaInicioPlanificado = fechaInicioPlanificado;
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
	public int getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}
	
	

}
