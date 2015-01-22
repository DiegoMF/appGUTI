package com.bcp.modelo;

public class BitacoraActualizaciones {
	private int idAplicacionEspecializada;
	private int idVersion;
	private String fechaActualizacion;
	//fecha es tipo DATE
	private int idGrupoInventario;
	private int idCampoInventario;
	private String detalleActualizacion;
	public int getIdAplicacionEspecializada() {
		return idAplicacionEspecializada;
	}
	public void setIdAplicacionEspecializada(int idAplicacionEspecializada) {
		this.idAplicacionEspecializada = idAplicacionEspecializada;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public int getIdGrupoInventario() {
		return idGrupoInventario;
	}
	public void setIdGrupoInventario(int idGrupoInventario) {
		this.idGrupoInventario = idGrupoInventario;
	}
	public int getIdCampoInventario() {
		return idCampoInventario;
	}
	public void setIdCampoInventario(int idCampoInventario) {
		this.idCampoInventario = idCampoInventario;
	}
	public String getDetalleActualizacion() {
		return detalleActualizacion;
	}
	public void setDetalleActualizacion(String detalleActualizacion) {
		this.detalleActualizacion = detalleActualizacion;
	}
	public int getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}
	
	

}
