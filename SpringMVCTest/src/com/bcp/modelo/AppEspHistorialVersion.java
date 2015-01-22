package com.bcp.modelo;

public class AppEspHistorialVersion {

	private int numero;
	private int idAplicacionEspecializada;
	private String usuarioCreacion;
	private String fechaCreacionDesde;
	private String fechaCreacionHasta;

	private String idversion;
	private String fechacreacion;
	private String descripcionmotivo;

	
	public int getIdAplicacionEspecializada() {
		return idAplicacionEspecializada;
	}
	public void setIdAplicacionEspecializada(int idAplicacionEspecializada) {
		this.idAplicacionEspecializada = idAplicacionEspecializada;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getIdversion() {
		return idversion;
	}
	public void setIdversion(String idversion) {
		this.idversion = idversion;
	}
	public String getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getDescripcionmotivo() {
		return descripcionmotivo;
	}
	public void setDescripcionmotivo(String descripcionmotivo) {
		this.descripcionmotivo = descripcionmotivo;
	}
	
}
