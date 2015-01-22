package com.bcp.modelo;

public class AplicacionEspecializada {
	private int numero;
	private int idAplicacionEspecializada;
	private int idVersion;
	private String fechaCreacionRegistro;
	//private Date fechaCreacionRegistro;
	private int usuarioCreacion;
	private String matriculaUsuario;
	private int versionActual;
	private String estadoVersion;
	private String motivoCreacion;
	private int idMotivoCreacion;
	
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getMotivoCreacion() {
		return motivoCreacion;
	}
	public void setMotivoCreacion(String motivoCreacion) {
		this.motivoCreacion = motivoCreacion;
	}
	public int getIdMotivoCreacion() {
		return idMotivoCreacion;
	}
	public void setIdMotivoCreacion(int idMotivoCreacion) {
		this.idMotivoCreacion = idMotivoCreacion;
	}
	public int getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(int usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getMatriculaUsuario() {
		return matriculaUsuario;
	}
	public void setMatriculaUsuario(String matriculaUsuario) {
		this.matriculaUsuario = matriculaUsuario;
	}
	
	

	
}
