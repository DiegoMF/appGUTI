package com.bcp.modelo.dto;

public class ExcelfileStandarDTO {

	// SOFTWARE BASE
	/***
	 * 
	 */
	private String software_nombreAplicacion;
	private String software_sistemaOperativo;
	private String software_sistemaOperativoOtros;
	private String software_herramientasProgramacion;
	private String software_herramientasProgramacionOtros;
	private String software_leguajeProgramacion;
	private String software_leguajeProgramacionOtros;
	private String software_gestorBD;
	private String software_gestorBDOtros;
	private String software_framework;
	private String software_frameworkOtros;
	private String software_observaciones;

	public String getSoftware_nombreAplicacion() {
		return software_nombreAplicacion;
	}

	public void setSoftware_nombreAplicacion(String software_nombreAplicacion) {
		this.software_nombreAplicacion = software_nombreAplicacion;
	}

	public String getSoftware_sistemaOperativo() {
		return software_sistemaOperativo;
	}

	public void setSoftware_sistemaOperativo(String software_sistemaOperativo) {
		this.software_sistemaOperativo = software_sistemaOperativo;
	}

	public String getSoftware_sistemaOperativoOtros() {
		return software_sistemaOperativoOtros;
	}

	public void setSoftware_sistemaOperativoOtros(
			String software_sistemaOperativoOtros) {
		this.software_sistemaOperativoOtros = software_sistemaOperativoOtros;
	}

	public String getSoftware_herramientasProgramacion() {
		return software_herramientasProgramacion;
	}

	public void setSoftware_herramientasProgramacion(
			String software_herramientasProgramacion) {
		this.software_herramientasProgramacion = software_herramientasProgramacion;
	}

	public String getSoftware_herramientasProgramacionOtros() {
		return software_herramientasProgramacionOtros;
	}

	public void setSoftware_herramientasProgramacionOtros(
			String software_herramientasProgramacionOtros) {
		this.software_herramientasProgramacionOtros = software_herramientasProgramacionOtros;
	}

	public String getSoftware_leguajeProgramacion() {
		return software_leguajeProgramacion;
	}

	public void setSoftware_leguajeProgramacion(
			String software_leguajeProgramacion) {
		this.software_leguajeProgramacion = software_leguajeProgramacion;
	}

	public String getSoftware_leguajeProgramacionOtros() {
		return software_leguajeProgramacionOtros;
	}

	public void setSoftware_leguajeProgramacionOtros(
			String software_leguajeProgramacionOtros) {
		this.software_leguajeProgramacionOtros = software_leguajeProgramacionOtros;
	}
	
	public String getSoftware_gestorBD() {
		return software_gestorBD;
	}

	public void setSoftware_gestorBD(String software_gestorBD) {
		this.software_gestorBD = software_gestorBD;
	}

	public String getSoftware_gestorBDOtros() {
		return software_gestorBDOtros;
	}

	public void setSoftware_gestorBDOtros(String software_gestorBDOtros) {
		this.software_gestorBDOtros = software_gestorBDOtros;
	}

	public String getSoftware_framework() {
		return software_framework;
	}

	public void setSoftware_framework(String software_framework) {
		this.software_framework = software_framework;
	}

	public String getSoftware_frameworkOtros() {
		return software_frameworkOtros;
	}

	public void setSoftware_frameworkOtros(String software_frameworkOtros) {
		this.software_frameworkOtros = software_frameworkOtros;
	}

	public String getSoftware_observaciones() {
		return software_observaciones;
	}

	public void setSoftware_observaciones(String software_observaciones) {
		this.software_observaciones = software_observaciones;
	}

	// COMPATIBILIDAD
	/***
	 * 
	 */
	private String compatibilidad_windows7;
	private String compatibilidad_windows8;
	private String compatibilidad_pTerminal;
	private String compatibilidad_activeDirectory;

	public String getCompatibilidad_windows7() {
		return compatibilidad_windows7;
	}

	public void setCompatibilidad_windows7(String compatibilidad_windows7) {
		this.compatibilidad_windows7 = compatibilidad_windows7;
	}

	public String getCompatibilidad_windows8() {
		return compatibilidad_windows8;
	}

	public void setCompatibilidad_windows8(String compatibilidad_windows8) {
		this.compatibilidad_windows8 = compatibilidad_windows8;
	}

	public String getCompatibilidad_pTerminal() {
		return compatibilidad_pTerminal;
	}

	public void setCompatibilidad_pTerminal(String compatibilidad_pTerminal) {
		this.compatibilidad_pTerminal = compatibilidad_pTerminal;
	}

	public String getCompatibilidad_activeDirectory() {
		return compatibilidad_activeDirectory;
	}

	public void setCompatibilidad_activeDirectory(
			String compatibilidad_activeDirectory) {
		this.compatibilidad_activeDirectory = compatibilidad_activeDirectory;
	}

	/**
	 * 
	 * Envia los datos al DTO
	 * 
	 */

	public void sendDataDTO(int count, String obj) {
		switch (count) {

		case 1:
			software_nombreAplicacion = obj;
			break;
		case 2:
			software_sistemaOperativo = obj;
			break;
		case 3:
			software_sistemaOperativoOtros = obj;
			break;
		case 4:
			software_herramientasProgramacion = obj;
			break;
		case 5:
			software_herramientasProgramacionOtros = obj;
			break;
		case 6:
			software_leguajeProgramacion = obj;
			break;
		case 7:
			software_leguajeProgramacionOtros = obj;
			break;
		case 8:
			software_gestorBD = obj;
			break;
		case 9:
			software_gestorBDOtros = obj;
			break;
		case 10:
			software_framework = obj;
			break;
		case 11:
			software_frameworkOtros = obj;
			break;
		case 12:
			software_observaciones = obj;
			break;

		/**********************************************/

		case 13:
			compatibilidad_windows7 = obj;
			break;
		case 14:
			compatibilidad_windows8 = obj;
			break;
		case 15:
			compatibilidad_pTerminal = obj;
			break;
		case 16:
			compatibilidad_activeDirectory = obj;
			break;
		default:
			break;
		}
	}
}
