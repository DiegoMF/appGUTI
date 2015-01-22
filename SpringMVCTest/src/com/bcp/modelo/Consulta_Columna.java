package com.bcp.modelo;

import java.util.ArrayList;

public class Consulta_Columna {

	private int idConsulta_Columna;
	private String Descripcion;
	private String Tabla;
	private Boolean Foraneo;
	private int idConsulta_Seccion;
	private ArrayList<String> filtroDestino;
	private ArrayList<String> columnaDestino;

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


	
}
