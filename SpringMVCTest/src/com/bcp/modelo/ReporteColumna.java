package com.bcp.modelo;

public class ReporteColumna {
	private int idReporteColumna;
	private String descripcion;
	private String tabla;
	private Boolean foraneo;
	private int idReporteSeccion;
	private String tablaSeccion;
	private String columnaForanea;
	private String descripcionForanea;
	public int getIdReporteColumna() {
		return idReporteColumna;
	}
	public void setIdReporteColumna(int idReporteColumna) {
		this.idReporteColumna = idReporteColumna;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdReporteSeccion() {
		return idReporteSeccion;
	}
	public void setIdReporteSeccion(int idReporteSeccion) {
		this.idReporteSeccion = idReporteSeccion;
	}
	public String getTablaSeccion() {
		return tablaSeccion;
	}
	public void setTablaSeccion(String tablaSeccion) {
		this.tablaSeccion = tablaSeccion;
	}
	public String getColumnaForanea() {
		return columnaForanea;
	}
	public void setColumnaForanea(String columnaForanea) {
		this.columnaForanea = columnaForanea;
	}
	public String getDescripcionForanea() {
		return descripcionForanea;
	}
	public void setDescripcionForanea(String descripcionForanea) {
		this.descripcionForanea = descripcionForanea;
	}
	public Boolean getForaneo() {
		return foraneo;
	}
	public void setForaneo(Boolean foraneo) {
		this.foraneo = foraneo;
	}
	
	
	

}
