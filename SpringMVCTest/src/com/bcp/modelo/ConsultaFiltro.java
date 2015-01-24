package com.bcp.modelo;

public class ConsultaFiltro {
	private int idReporteFiltro;
	private int idReporteColumna;
	private String nombreColumna;
	private int idReporte;
	
	
	private int idConsultaColumna;
	private int idConsultaFiltro;
	private int idConsulta;

	private String Descripcion;
	private String Tabla;
	private boolean Foraneo;

	public int getIdConsultaColumna() {
		return idConsultaColumna;
	}
	public void setIdConsultaColumna(int idConsultaColumna) {
		this.idConsultaColumna = idConsultaColumna;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getTabla() {
		return Tabla;
	}
	public void setTabla(String tabla) {
		Tabla = tabla;
	}
	public boolean isForaneo() {
		return Foraneo;
	}
	public void setForaneo(boolean foraneo) {
		Foraneo = foraneo;
	}
	public String getTablaSeccion() {
		return TablaSeccion;
	}
	public void setTablaSeccion(String tablaSeccion) {
		TablaSeccion = tablaSeccion;
	}
	public String getColumnaForanea() {
		return ColumnaForanea;
	}
	public void setColumnaForanea(String columnaForanea) {
		ColumnaForanea = columnaForanea;
	}
	public String getDescripcionForanea() {
		return DescripcionForanea;
	}
	public void setDescripcionForanea(String descripcionForanea) {
		DescripcionForanea = descripcionForanea;
	}
	private String TablaSeccion;
	
	private String ColumnaForanea;
	private String DescripcionForanea;
	
	
	public int getIdReporteFiltro() {
		return idReporteFiltro;
	}
	public void setIdReporteFiltro(int idReporteFiltro) {
		this.idReporteFiltro = idReporteFiltro;
	}
	public int getIdReporteColumna() {
		return idReporteColumna;
	}
	public void setIdReporteColumna(int idReporteColumna) {
		this.idReporteColumna = idReporteColumna;
	}
	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	public String getNombreColumna() {
		return nombreColumna;
	}
	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
	public int getIdConsultaFiltro() {
		return idConsultaFiltro;
	}
	public void setIdConsultaFiltro(int idConsultaFiltro) {
		this.idConsultaFiltro = idConsultaFiltro;
	}
	
	

}
