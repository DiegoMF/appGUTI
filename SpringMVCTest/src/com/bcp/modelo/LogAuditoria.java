package com.bcp.modelo;

public class LogAuditoria {
	private int idLogAuditoria;
	private String pagina;
	private String objeto;
	private String traza_error;
	private String tipo;
	private String ip;
	private String usuario;
	private String fecha;
	private String hora;
	
	public int getIdLogAuditoria() {
		return idLogAuditoria;
	}
	public void setIdLogAuditoria(int idLogAuditoria) {
		this.idLogAuditoria = idLogAuditoria;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public String getTraza_error() {
		return traza_error;
	}
	public void setTraza_error(String traza_error) {
		this.traza_error = traza_error;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
