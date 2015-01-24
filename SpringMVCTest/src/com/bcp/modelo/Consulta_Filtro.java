package com.bcp.modelo;

public class Consulta_Filtro {
	int idConsulta_Filtro;

	public final int getIdConsulta_Filtro() {
		return idConsulta_Filtro;
	}

	public final void setIdConsulta_Filtro(int idConsulta_Filtro) {
		this.idConsulta_Filtro = idConsulta_Filtro;
	}

	public final int getIdConsulta_Columna() {
		return idConsulta_Columna;
	}

	public final void setIdConsulta_Columna(int idConsulta_Columna) {
		this.idConsulta_Columna = idConsulta_Columna;
	}

	public final int getIdConsulta() {
		return idConsulta;
	}

	public final void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public final String getDescripcion() {
		return Descripcion;
	}

	public final void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public final String getTabla() {
		return Tabla;
	}

	public final void setTabla(String tabla) {
		Tabla = tabla;
	}

	public final boolean isForaneo() {
		return Foraneo;
	}

	public final void setForaneo(boolean foraneo) {
		Foraneo = foraneo;
	}

	int idConsulta_Columna;
	int idConsulta;

	String Descripcion;
	String Tabla;
	boolean Foraneo;

	String TablaSeccion;
	
	String ColumnaForanea;
	String DescripcionForanea;

	public final String getTablaSeccion() {
		return TablaSeccion;
	}

	public final void setTablaSeccion(String tablaSeccion) {
		TablaSeccion = tablaSeccion;
	}

	public final String getColumnaForanea() {
		return ColumnaForanea;
	}

	public final void setColumnaForanea(String columnaForanea) {
		ColumnaForanea = columnaForanea;
	}

	public final String getDescripcionForanea() {
		return DescripcionForanea;
	}

	public final void setDescripcionForanea(String descripcionForanea) {
		DescripcionForanea = descripcionForanea;
	}

	

}
