package com.bcp.modelo;

public class AppEspSeguridadInformacion {
	private int idAplicacionEspecializada;
	private int idVersion;
	private int idSeguridadNivelExposicion;
	private String evaluacionSeguridadInformatica;
	private String seguridadNivelExposicion;
	
	public int getIdAplicacionEspecializada() {
		return idAplicacionEspecializada;
	}
	public void setIdAplicacionEspecializada(int idAplicacionEspecializada) {
		this.idAplicacionEspecializada = idAplicacionEspecializada;
	}
	public String getEvaluacionSeguridadInformatica() {
		return evaluacionSeguridadInformatica;
	}
	public void setEvaluacionSeguridadInformatica(
			String evaluacionSeguridadInformatica) {
		this.evaluacionSeguridadInformatica = evaluacionSeguridadInformatica;
	}

	public int getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}
	public String getSeguridadNivelExposicion() {
		return seguridadNivelExposicion;
	}
	public void setSeguridadNivelExposicion(String seguridadNivelExposicion) {
		this.seguridadNivelExposicion = seguridadNivelExposicion;
	}
	public int getIdSeguridadNivelExposicion() {
		return idSeguridadNivelExposicion;
	}
	public void setIdSeguridadNivelExposicion(int idSeguridadNivelExposicion) {
		this.idSeguridadNivelExposicion = idSeguridadNivelExposicion;
	}
	
	

}
