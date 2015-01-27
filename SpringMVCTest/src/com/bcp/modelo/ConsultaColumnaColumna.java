package com.bcp.modelo;

public class ConsultaColumnaColumna {
	private int idConsultaColumnaColumna;
	private int idConsultaColumna;
	private String nombreColumna;
	private int idConsulta;
	
	private int idConsulta_Columna;
	

	private String Descripcion;
	private String Tabla;
	private boolean Foraneo;

	private String TablaSeccion;
	
	private String ColumnaForanea;
	private String DescripcionForanea;
	
	
	public int getIdConsulta_Columna() {
		return idConsulta_Columna;
	}
	public void setIdConsulta_Columna(int idConsulta_Columna) {
		this.idConsulta_Columna = idConsulta_Columna;
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
	public int getIdConsultaColumnaColumna() {
		return idConsultaColumnaColumna;
	}
	public void setIdConsultaColumnaColumna(int idConsultaColumnaColumna) {
		this.idConsultaColumnaColumna = idConsultaColumnaColumna;
	}
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
	public String getNombreColumna() {
		return nombreColumna;
	}
	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
	
	
	

}
