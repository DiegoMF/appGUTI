package com.bcp.modelo;

public class AppEspNivelCumplimiento {
	
	private int idAplicacionEspecializada;
	private int idVersion;
	
	private String descripcionEstandarSistemaOperativo;
	private Double nivelCumplimientoSistemaOperativo;
	private int puntuacionSistemaOperativo;
	private Double calculoSistemaOperativo;
	private String descripcionEstandarHerramientaProgramacion;
	private Double nivelCumplimientoHerramientaProgramacion;
	private int puntuacionHerramientaProgramacion;
	private Double calculoHerramientaProgramacion;
	private String descripcionEstandarGestorBD;
	private Double nivelCumplimientoEstandarGestorBD;
	private int puntuacionGestorBD;
	private Double calculoGestorBD;
	private String descripcionFramework;
	private Double nivelCumplimientoFramework;
	private int puntuacionFramework;
	private Double calculoFramework;
	private Double total;
	
	
	private Double nivelCumplimientoAccesos;
	private Double nivelCumplimientoAuditoria;
	private Double nivelCumplimientoContingencia;
    private Double nivelCumplimientoControlCambios;
	private Double nivelCumplimientoDocumentacion;
    private Double nivelCumplimientoIncidentes;
    private Double nivelCumplimientoIntegridadConfidencialidad;
    private Double nivelCumplimientoRespaldos;
    private Double nivelCumplimientoTotal;
    
    private Double nivelCumplimientoFinal;
    
    
	
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
	public String getDescripcionEstandarSistemaOperativo() {
		return descripcionEstandarSistemaOperativo;
	}
	public void setDescripcionEstandarSistemaOperativo(
			String descripcionEstandarSistemaOperativo) {
		this.descripcionEstandarSistemaOperativo = descripcionEstandarSistemaOperativo;
	}
	public Double getNivelCumplimientoSistemaOperativo() {
		return nivelCumplimientoSistemaOperativo;
	}
	public void setNivelCumplimientoSistemaOperativo(
			Double nivelCumplimientoSistemaOperativo) {
		this.nivelCumplimientoSistemaOperativo = nivelCumplimientoSistemaOperativo;
	}
	public int getPuntuacionSistemaOperativo() {
		return puntuacionSistemaOperativo;
	}
	public void setPuntuacionSistemaOperativo(int puntuacionSistemaOperativo) {
		this.puntuacionSistemaOperativo = puntuacionSistemaOperativo;
	}
	public Double getCalculoSistemaOperativo() {
		return calculoSistemaOperativo;
	}
	public void setCalculoSistemaOperativo(Double calculoSistemaOperativo) {
		this.calculoSistemaOperativo = calculoSistemaOperativo;
	}
	public String getDescripcionEstandarHerramientaProgramacion() {
		return descripcionEstandarHerramientaProgramacion;
	}
	public void setDescripcionEstandarHerramientaProgramacion(
			String descripcionEstandarHerramientaProgramacion) {
		this.descripcionEstandarHerramientaProgramacion = descripcionEstandarHerramientaProgramacion;
	}
	public Double getNivelCumplimientoHerramientaProgramacion() {
		return nivelCumplimientoHerramientaProgramacion;
	}
	public void setNivelCumplimientoHerramientaProgramacion(
			Double nivelCumplimientoHerramientaProgramacion) {
		this.nivelCumplimientoHerramientaProgramacion = nivelCumplimientoHerramientaProgramacion;
	}
	public int getPuntuacionHerramientaProgramacion() {
		return puntuacionHerramientaProgramacion;
	}
	public void setPuntuacionHerramientaProgramacion(
			int puntuacionHerramientaProgramacion) {
		this.puntuacionHerramientaProgramacion = puntuacionHerramientaProgramacion;
	}
	public Double getCalculoHerramientaProgramacion() {
		return calculoHerramientaProgramacion;
	}
	public void setCalculoHerramientaProgramacion(
			Double calculoHerramientaProgramacion) {
		this.calculoHerramientaProgramacion = calculoHerramientaProgramacion;
	}
	public String getDescripcionEstandarGestorBD() {
		return descripcionEstandarGestorBD;
	}
	public void setDescripcionEstandarGestorBD(
			String descripcionEstandarGestorBD) {
		this.descripcionEstandarGestorBD = descripcionEstandarGestorBD;
	}
	public Double getNivelCumplimientoEstandarGestorBD() {
		return nivelCumplimientoEstandarGestorBD;
	}
	public void setNivelCumplimientoEstandarGestorBD(
			Double nivelCumplimientoEstandarGestorBD) {
		this.nivelCumplimientoEstandarGestorBD = nivelCumplimientoEstandarGestorBD;
	}
	public int getPuntuacionGestorBD() {
		return puntuacionGestorBD;
	}
	public void setPuntuacionGestorBD(int puntuacionGestorBD) {
		this.puntuacionGestorBD = puntuacionGestorBD;
	}
	public Double getCalculoGestorBD() {
		return calculoGestorBD;
	}
	public void setCalculoGestorBD(Double calculoGestorBD) {
		this.calculoGestorBD = calculoGestorBD;
	}
	public String getDescripcionFramework() {
		return descripcionFramework;
	}
	public void setDescripcionFramework(String descripcionFramework) {
		this.descripcionFramework = descripcionFramework;
	}
	public Double getNivelCumplimientoFramework() {
		return nivelCumplimientoFramework;
	}
	public void setNivelCumplimientoFramework(Double nivelCumplimientoFramework) {
		this.nivelCumplimientoFramework = nivelCumplimientoFramework;
	}
	public int getPuntuacionFramework() {
		return puntuacionFramework;
	}
	public void setPuntuacionFramework(int puntuacionFramework) {
		this.puntuacionFramework = puntuacionFramework;
	}
	public Double getCalculoFramework() {
		return calculoFramework;
	}
	public void setCalculoFramework(Double calculoFramework) {
		this.calculoFramework = calculoFramework;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
	public Double getNivelCumplimientoAuditoria() {
		return nivelCumplimientoAuditoria;
	}
	public void setNivelCumplimientoAuditoria(Double nivelCumplimientoAuditoria) {
		this.nivelCumplimientoAuditoria = nivelCumplimientoAuditoria;
	}
	public Double getNivelCumplimientoContingencia() {
		return nivelCumplimientoContingencia;
	}
	public void setNivelCumplimientoContingencia(
			Double nivelCumplimientoContingencia) {
		this.nivelCumplimientoContingencia = nivelCumplimientoContingencia;
	}
	public Double getNivelCumplimientoControlCambios() {
		return nivelCumplimientoControlCambios;
	}
	public void setNivelCumplimientoControlCambios(
			Double nivelCumplimientoControlCambios) {
		this.nivelCumplimientoControlCambios = nivelCumplimientoControlCambios;
	}
	public Double getNivelCumplimientoDocumentacion() {
		return nivelCumplimientoDocumentacion;
	}
	public void setNivelCumplimientoDocumentacion(
			Double nivelCumplimientoDocumentacion) {
		this.nivelCumplimientoDocumentacion = nivelCumplimientoDocumentacion;
	}
	public Double getNivelCumplimientoIncidentes() {
		return nivelCumplimientoIncidentes;
	}
	public void setNivelCumplimientoIncidentes(
			Double nivelCumplimientoIncidentes) {
		this.nivelCumplimientoIncidentes = nivelCumplimientoIncidentes;
	}
	public Double getNivelCumplimientoIntegridadConfidencialidad() {
		return nivelCumplimientoIntegridadConfidencialidad;
	}
	public void setNivelCumplimientoIntegridadConfidencialidad(
			Double nivelCumplimientoIntegridadConfidencialidad) {
		this.nivelCumplimientoIntegridadConfidencialidad = nivelCumplimientoIntegridadConfidencialidad;
	}
	public Double getNivelCumplimientoRespaldos() {
		return nivelCumplimientoRespaldos;
	}
	public void setNivelCumplimientoRespaldos(Double nivelCumplimientoRespaldos) {
		this.nivelCumplimientoRespaldos = nivelCumplimientoRespaldos;
	}
	public Double getNivelCumplimientoTotal() {
		return nivelCumplimientoTotal;
	}
	public void setNivelCumplimientoTotal(Double nivelCumplimientoTotal) {
		this.nivelCumplimientoTotal = nivelCumplimientoTotal;
	}
	public Double getNivelCumplimientoAccesos() {
		return nivelCumplimientoAccesos;
	}
	public void setNivelCumplimientoAccesos(Double nivelCumplimientoAccesos) {
		this.nivelCumplimientoAccesos = nivelCumplimientoAccesos;
	}
	public Double getNivelCumplimientoFinal() {
		return nivelCumplimientoFinal;
	}
	public void setNivelCumplimientoFinal(Double nivelCumplimientoFinal) {
		this.nivelCumplimientoFinal = nivelCumplimientoFinal;
	}
    

}
