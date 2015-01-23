package com.bcp.modelo.dto;

public class ExcelfileDatamartDTO {

	// DATAMART
	/***
	 * 
	 */
	private String datamart_nombre;
	private String datamart_numeroTablas;
	private String datamart_numeroTablasDescriptivas;
	private String datamart_numeroTablasFacts;
	private String datamart_herramientasExplotacion;
	private String datamart_herramientasExplotacionOtros;
	private String datamart_cantidadEspacio;

	public String getDatamart_nombre() {
		return datamart_nombre;
	}

	public void setDatamart_nombre(String datamart_nombre) {
		this.datamart_nombre = datamart_nombre;
	}

	public String getDatamart_numeroTablas() {
		return datamart_numeroTablas;
	}

	public void setDatamart_numeroTablas(String datamart_numeroTablas) {
		this.datamart_numeroTablas = datamart_numeroTablas;
	}

	public String getDatamart_numeroTablasDescriptivas() {
		return datamart_numeroTablasDescriptivas;
	}

	public void setDatamart_numeroTablasDescriptivas(
			String datamart_numeroTablasDescriptivas) {
		this.datamart_numeroTablasDescriptivas = datamart_numeroTablasDescriptivas;
	}

	public String getDatamart_numeroTablasFacts() {
		return datamart_numeroTablasFacts;
	}

	public void setDatamart_numeroTablasFacts(String datamart_numeroTablasFacts) {
		this.datamart_numeroTablasFacts = datamart_numeroTablasFacts;
	}

	public String getDatamart_herramientasExplotacion() {
		return datamart_herramientasExplotacion;
	}

	public void setDatamart_herramientasExplotacion(
			String datamart_herramientasExplotacion) {
		this.datamart_herramientasExplotacion = datamart_herramientasExplotacion;
	}

	public String getDatamart_herramientasExplotacionOtros() {
		return datamart_herramientasExplotacionOtros;
	}

	public void setDatamart_herramientasExplotacionOtros(
			String datamart_herramientasExplotacionOtros) {
		this.datamart_herramientasExplotacionOtros = datamart_herramientasExplotacionOtros;
	}

	public String getDatamart_cantidadEspacio() {
		return datamart_cantidadEspacio;
	}

	public void setDatamart_cantidadEspacio(String datamart_cantidadEspacio) {
		this.datamart_cantidadEspacio = datamart_cantidadEspacio;
	}

	/**
	 * 
	 * Envia los datos al DTO
	 * 
	 */

	public void sendDataDTO(int count, String obj) {
		switch (count) {
		case 1:
			datamart_nombre = obj;
			break;
		case 2:
			datamart_numeroTablas = obj;
			break;
		case 3:
			datamart_numeroTablasDescriptivas = obj;
			break;
		case 4:
			datamart_numeroTablasFacts = obj;
			break;
		case 5:
			datamart_herramientasExplotacion = obj;
			break;
		case 6:
			datamart_herramientasExplotacionOtros = obj;
			break;
		case 7:
			datamart_cantidadEspacio = obj;
			break;
		default:
			break;
		}
	}
}
