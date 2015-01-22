package com.bcp.modelo;



public class AppEspBitacora {
	private int numero;
	private int idAplicacionEspecializada;
	private int idBitacoraEventos;
	private String descripcionEvento;
	private String fechaCreacion;
	private String fechaCreacionDesde;
	private String fechaCreacionHasta;
	private int usuarioCreacion;
	private int usuarioModificacion;
	private String matriculaUsuario;
	private String fechaModificacion;
	private String estadoEvento;
	
	private String nombreAplicacionNOIT;
	private String codigoAplicacionEspecializada;
	
	
	public int getIdAplicacionEspecializada() {
		return idAplicacionEspecializada;
	}

	public void setIdAplicacionEspecializada(int idAplicacionEspecializada) {
		this.idAplicacionEspecializada = idAplicacionEspecializada;
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




	public String getEstadoEvento() {
		return estadoEvento;
	}

	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFechaCreacionHasta() {
		return fechaCreacionHasta;
	}

	public void setFechaCreacionHasta(String fechaCreacionHasta) {
		this.fechaCreacionHasta = fechaCreacionHasta;
	}

	public String getFechaCreacionDesde() {
		return fechaCreacionDesde;
	}

	public void setFechaCreacionDesde(String fechaCreacionDesde) {
		this.fechaCreacionDesde = fechaCreacionDesde;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombreAplicacionNOIT() {
		return nombreAplicacionNOIT;
	}

	public void setNombreAplicacionNOIT(String nombreAplicacionNOIT) {
		this.nombreAplicacionNOIT = nombreAplicacionNOIT;
	}

	public String getCodigoAplicacionEspecializada() {
		return codigoAplicacionEspecializada;
	}

	public void setCodigoAplicacionEspecializada(
			String codigoAplicacionEspecializada) {
		this.codigoAplicacionEspecializada = codigoAplicacionEspecializada;
	}

	public AppEspBitacora()
	{
		this.fechaCreacionDesde = "2000/01/01";
		this.fechaCreacionHasta = "2050/01/01";
		this.idBitacoraEventos = 0;
	}



	public int getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(int usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public int getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(int usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMatriculaUsuario() {
		return matriculaUsuario;
	}

	public void setMatriculaUsuario(String matriculaUsuario) {
		this.matriculaUsuario = matriculaUsuario;
	}
}
