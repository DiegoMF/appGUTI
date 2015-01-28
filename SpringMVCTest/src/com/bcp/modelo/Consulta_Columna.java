package com.bcp.modelo;

import java.util.ArrayList;

public class Consulta_Columna {

	private int idConsulta_Columna;
	private String Descripcion;
	private String Tabla;
	private Boolean Foraneo;
	private int idConsulta_Seccion;
	private String TablaSeccion;
	private String ColumnaForanea;
	private String DescripcionForanea;
	private String DescripcionResultado;
	
	private ArrayList<String> filtroDestino;
	private ArrayList<String> columnaDestino;
	private String DescripcionResultado;

	public final String getDescripcionResultado() {
		return DescripcionResultado;
	}

	public final void setDescripcionResultado(String descripcionResultado) {
		DescripcionResultado = descripcionResultado;
	}

	public final int getIdConsulta_Columna() {
		return idConsulta_Columna;
	}

	public final void setIdConsulta_Columna(int idConsulta_Columna) {
		this.idConsulta_Columna = idConsulta_Columna;
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

	public final Boolean getForaneo() {
		return Foraneo;
	}

	public final void setForaneo(Boolean foraneo) {
		Foraneo = foraneo;
	}

	public final int getIdConsulta_Seccion() {
		return idConsulta_Seccion;
	}

	public final void setIdConsulta_Seccion(int idConsulta_Seccion) {
		this.idConsulta_Seccion = idConsulta_Seccion;
	}



	public ArrayList<String> getFiltroDestino() {
		return filtroDestino;
	}

	public void setFiltroDestino(ArrayList<String> filtroDestino) {
		this.filtroDestino = filtroDestino;
	}

	public ArrayList<String> getColumnaDestino() {
		return columnaDestino;
	}

	public void setColumnaDestino(ArrayList<String> columnaDestino) {
		this.columnaDestino = columnaDestino;
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

	public String getDescripcionResultado() {
		return DescripcionResultado;
	}

	public void setDescripcionResultado(String descripcionResultado) {
		DescripcionResultado = descripcionResultado;
	}


	
}
