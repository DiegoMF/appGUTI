package com.bcp.modelo.dto;

public class ExcelfileImpactoClasificacionDTO {

	// IMPACTO Y CLASIFICACION
	/***
	 * 
	 */
	private String impacto_confidencialidad;
	private String impacto_integridad;
	private String impacto_disponibilidad;
	private String impacto_privacidad;

	public String getImpacto_confidencialidad() {
		return impacto_confidencialidad;
	}

	public void setImpacto_confidencialidad(String impacto_confidencialidad) {
		this.impacto_confidencialidad = impacto_confidencialidad;
	}

	public String getImpacto_integridad() {
		return impacto_integridad;
	}

	public void setImpacto_integridad(String impacto_integridad) {
		this.impacto_integridad = impacto_integridad;
	}

	public String getImpacto_disponibilidad() {
		return impacto_disponibilidad;
	}

	public void setImpacto_disponibilidad(String impacto_disponibilidad) {
		this.impacto_disponibilidad = impacto_disponibilidad;
	}

	public String getImpacto_privacidad() {
		return impacto_privacidad;
	}

	public void setImpacto_privacidad(String impacto_privacidad) {
		this.impacto_privacidad = impacto_privacidad;
	}

	/**
	 * 
	 * Envia los datos al DTO
	 * 
	 */

	public void sendDataDTO(int count, String obj) {
		switch (count) {
		case 1:
			impacto_confidencialidad = obj;
			break;
		case 2:
			impacto_integridad = obj;
			break;
		case 3:
			impacto_disponibilidad = obj;
			break;
		case 4:
			impacto_privacidad = obj;
			break;
		default:
			break;
		}
	}
}
