package com.bcp.modelo;


import java.util.ArrayList;

public class Consulta {

	
	private int numero;
	private int idConsulta;
	private String nombreConsulta;
	private Byte predeterminado;
	private String strPredeterminado;
	private String estado;
	
	private ArrayList<String> SelectList;
	private ArrayList<String> fOrigen;
	private int idConsultaColumna;
	private ArrayList<String> filtroDestino;
	
	private ArrayList<String> cOrigen;
	private int idConsultaFiltro;
	private ArrayList<String> columnaDestino;
	
	private String comboColumna;
	private String comboFiltro;
	
	private int idReporte;
	private String nombreReporte;
	private String fechaCreacion;
	private int usuarioCreacion;
	private String matricula;
	
	private Boolean tipo;
	
	
	

	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	public String getNombreReporte() {
		return nombreReporte;
	}
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(int usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Boolean getTipo() {
		return tipo;
	}
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	public String getComboColumna() {
		return comboColumna;
	}
	public void setComboColumna(String comboColumna) {
		this.comboColumna = comboColumna;
	}
	public String getComboFiltro() {
		return comboFiltro;
	}
	public void setComboFiltro(String comboFiltro) {
		this.comboFiltro = comboFiltro;
	}
	public String getNombreConsulta() {
		return nombreConsulta;
	}
	public void setNombreConsulta(String nombreConsulta) {
		this.nombreConsulta = nombreConsulta;
	}
	public Byte getPredeterminado() {
		return predeterminado;
	}
	public void setPredeterminado(Byte predeterminado) {
		this.predeterminado = predeterminado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ArrayList<String> getSelectList() {
		return SelectList;
	}
	public void setSelectList(ArrayList<String> selectList) {
		SelectList = selectList;
	}
	public ArrayList<String> getFiltroDestino() {
		return filtroDestino;
	}
	public void setFiltroDestino(ArrayList<String> filtroDestino) {
		this.filtroDestino = filtroDestino;
	}
	public ArrayList<String> getcOrigen() {
		return cOrigen;
	}
	public void setcOrigen(ArrayList<String> cOrigen) {
		this.cOrigen = cOrigen;
	}
	public ArrayList<String> getColumnaDestino() {
		return columnaDestino;
	}
	public void setColumnaDestino(ArrayList<String> columnaDestino) {
		this.columnaDestino = columnaDestino;
	}
	public ArrayList<String> getfOrigen() {
		return fOrigen;
	}
	public void setfOrigen(ArrayList<String> fOrigen) {
		this.fOrigen = fOrigen;
	}



	public String getStrPredeterminado() {
		return strPredeterminado;
	}
	public void setStrPredeterminado(String strPredeterminado) {
		this.strPredeterminado = strPredeterminado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdConsultaColumna() {
		return idConsultaColumna;
	}
	public void setIdConsultaColumna(int idConsultaColumna) {
		this.idConsultaColumna = idConsultaColumna;
	}
	public int getIdConsultaFiltro() {
		return idConsultaFiltro;
	}
	public void setIdConsultaFiltro(int idConsultaFiltro) {
		this.idConsultaFiltro = idConsultaFiltro;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	
	
}
