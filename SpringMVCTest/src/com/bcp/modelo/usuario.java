package com.bcp.modelo;

public class usuario {

	private String Matricula;
	private int idRol;
	private int idusuario;
	private String ApellidoPaterno;
	private String ApellidoMaterno;
	private String Nombres;
	private String Rol;
	private String EstadoDescripcion;
	private int Estado;
	private String Correo;
	private String DRol;
	private String Contrasena;
	
	
	public final String getContrasena() {
		return Contrasena;
	}
	public final void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	public final String getReContrasena() {
		return ReContrasena;
	}
	public final void setReContrasena(String reContrasena) {
		ReContrasena = reContrasena;
	}

	private String ReContrasena;
	
	
	public final String getDRol() {
		return DRol;
	}
	public final void setDRol(String dRol) {
		DRol = dRol;
	}
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}
	/*public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}*/
	
	public final String getCorreo() {
		return Correo;
	}
	public final void setCorreo(String correo) {
		Correo = correo;
	}
	public final int getIdRol() {
		return idRol;
	}
	public final void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public final int getIdusuario() {
		return idusuario;
	}
	public final void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
	
	
	public usuario(String apellidopaterno, String apellidomaterno, String nombre, String correo, int rol){
		this.ApellidoPaterno = apellidopaterno;
		this.ApellidoMaterno = apellidomaterno;
		this.Nombres = nombre;
		this.Correo = correo;
		this.idRol = rol;
		
	}
	
	public usuario(){
		
		this.ApellidoPaterno = "";
		this.ApellidoMaterno = "";
		this.Nombres = "";
		this.Correo = "";
		this.idRol = 0;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public String getEstadoDescripcion() {
		return EstadoDescripcion;
	}
	public void setEstadoDescripcion(String estadoDescripcion) {
		EstadoDescripcion = estadoDescripcion;
	}
	
	
}
