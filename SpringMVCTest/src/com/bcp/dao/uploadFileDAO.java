package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Types;
import java.util.List;

import com.bcp.modelo.dto.ExcelfileDTO;
import com.bcp.modelo.dto.ExcelfileDatamartDTO;
import com.bcp.modelo.dto.ExcelfileImpactoClasificacionDTO;
import com.bcp.modelo.dto.ExcelfileLineamientoDTO;
import com.bcp.modelo.dto.ExcelfileStandarDTO;

public class uploadFileDAO {
	
	private Connection con = null;
//    private ResultSet rs = null;
    private static uploadFileDAO instancia;
    
    public static uploadFileDAO getInstancia() {
        if (instancia == null) {
            instancia = new uploadFileDAO();
        }
        return instancia;
    }
    
    public String insertDataFileUpload(List<ExcelfileDTO> list, 
    		List<ExcelfileStandarDTO> excelfileStandarDTOList,
    		List<ExcelfileLineamientoDTO> excelfileLineamientoDTOList,
    		List<ExcelfileDatamartDTO> excelfileDatamartDTOList,
    		List<ExcelfileImpactoClasificacionDTO> excelfileImpactoDTOList) throws Exception{
    	
    	CallableStatement cs = null;
    	String result = "";
    	try {
        	con = Conexion.getConexion();
        	        	
        	result = insertExcelfileGeneralDTO(cs, result, con, list);
        	result = insertExcelfileStandarDTO(cs, result, con, excelfileStandarDTOList);
        	result = insertExcelfileLineamientoDTO(cs, result, con, excelfileLineamientoDTOList);
        	result = insertExcelfileDatamartDTO(cs, result, con, excelfileDatamartDTOList);
        	result = insertExcelfileImpactoClasificacionDTO(cs, result, con, excelfileImpactoDTOList);
    		
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
			con.close();			
		}
    	return result;
    }

	private String insertExcelfileGeneralDTO(CallableStatement cs, String result,
			Connection con, List<ExcelfileDTO> list) throws SQLException {

		for (ExcelfileDTO excel : list) {

			try {
				cs = con.prepareCall("call sp_insert_excel_general_temp_table("
						+ "?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?);");

				cs.setString(1, excel.getEstructura_gerenciaCentral());
				cs.setString(2, excel.getEstructura_division());
				cs.setString(3, excel.getEstructura_area());
				cs.setString(4, excel.getEstructura_unidad());

				cs.setString(5, excel.getInformacion_nombreAplicacion());
				cs.setString(6, excel.getInformacion_descripcionAplicacion());
				cs.setString(7, excel.getInformacion_funcionalidades());
				cs.setString(8, excel.getInformacion_estado());
				cs.setString(9, excel.getInformacion_tipoOperacion());
				cs.setString(10, excel.getInformacion_frecuenciaOperacion());
				cs.setString(11, excel.getInformacion_cantidadOperacion());
				cs.setString(12, excel.getInformacion_fechaCreacion());
				cs.setString(13, excel.getInformacion_motivoCreacion());
				cs.setString(14, excel.getInformacion_motivoCreacionOtros());
				cs.setInt(15, excel.getInformacion_numeroFuncionalidades());
				cs.setInt(16, excel.getInformacion_numeroReportes());
				cs.setInt(17, excel.getInformacion_numeroConsultas());
				cs.setInt(18, excel.getInformacion_numeroEntidadesExternas());
				cs.setInt(19, excel.getInformacion_numeroEntidadesInternas());
				cs.setString(20, excel.getInformacion_observacionesGenerales());

				cs.setString(21, excel.getCaracteristica_categoriaTecnologica());
				cs.setString(22, excel.getCaracteristica_tipoDesarrollo());
				cs.setString(23, excel.getCaracteristica_ubicacionFisica());
				cs.setString(24, excel.getCaracteristica_ambienteAppNoIT());
				cs.setString(25, excel.getCaracteristica_nombreUbicacion());
				cs.setString(26,
						excel.getCaracteristica_infraestructuraAplicacion());
				cs.setString(27, excel.getCaracteristica_standAlone());
				cs.setInt(28, excel.getCaracteristica_numeroInterfaces());
				cs.setString(29, excel.getCaracteristica_nombreInterfaces());
				cs.setString(30,
						excel.getCaracteristica_mantenimientoAplicacion());
				cs.setString(31,
						excel.getCaracteristica_nombreProveedorMantenimiento());
				cs.setString(32, excel.getCaracteristica_soporteAplicacion());
				cs.setString(33,
						excel.getCaracteristica_nombreProveedorSoporte());
				cs.setString(34, excel.getCaracteristica_accesoAplicacion());
				cs.setString(35,
						excel.getCaracteristica_nombreProveedorAcceso());
				cs.setString(36, excel.getCaracteristica_nombreServidor());
				cs.setString(37, excel.getCaracteristica_ubicacionServidor());

				cs.setString(38, excel.getDominio_usuarioAplicacion());
				cs.setString(39, excel.getDominio_gestorAplicacion());
				cs.setString(40, excel.getDominio_especialistaAplicacion());
				cs.setString(41, excel.getDominio_brokerSistemas());
				cs.setString(42, excel.getDominio_brokerNegocio());
				cs.setString(43, excel.getDominio_asesorGUTI());
				cs.setString(44, excel.getDominio_entidadUsuario());
				cs.setString(45, excel.getDominio_nombreDominio());
				cs.setString(46, excel.getDominio_nombreSUBDominio());
				cs.setInt(47, excel.getDominio_numeroUnidadesAplicacion());
				cs.setString(48, excel.getDominio_nombreUnidad1());
				cs.setString(49, excel.getDominio_nombreUnidad2());
				cs.setString(50, excel.getDominio_nombreUnidad3());
				cs.setString(51, excel.getDominio_usuariosTotalAplicacion());
				cs.setString(52, excel.getDominio_procesoAuditoria());
				cs.setString(53, excel.getDominio_procesoAuditoriaOtros());
				cs.setString(54, excel.getDominio_procesoClave());
				cs.setString(55, excel.getDominio_nombreProcesoClave());
				cs.setString(56, excel.getDominio_nombreProcesoClaveOtros());
				cs.setString(57, excel.getDominio_actividad());
				cs.setString(58, excel.getDominio_CIF());

				cs.setString(59, excel.getEvaluacion_confidencialidad());
				cs.setString(60, excel.getEvaluacion_integridad());
				cs.setString(61, excel.getEvaluacion_disponibilidad());
				cs.setString(62, excel.getEvaluacion_privacidad());
				cs.setString(63, excel.getEvaluacion_clasificacion());
				cs.setString(64, excel.getEvaluacion_observacion());
				cs.setString(65, excel.getEvaluacion_criticidadFinal());

				// cs.registerOutParameter(8, Types.VARCHAR);
				System.out.println("Executing stored procedure...");

				cs.execute();
				result = "1";// cs.getString("output");
			} catch (SQLException sql) {
				throw sql;
			} finally {
				cs.close();
			}
		}
		return result;
	}

	private String insertExcelfileStandarDTO(CallableStatement cs,
			String result, Connection con, List<ExcelfileStandarDTO> list)
			throws SQLException {

		for (ExcelfileStandarDTO excel : list) {

			try {
				cs = con.prepareCall("call sp_insert_excel_standar_temp_table("
						+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

				cs.setString(1, excel.getSoftware_nombreAplicacion());
				cs.setString(2, excel.getSoftware_sistemaOperativo());
				cs.setString(3, excel.getSoftware_sistemaOperativoOtros());
				cs.setString(4, excel.getSoftware_herramientasProgramacion());
				cs.setString(5,
						excel.getSoftware_herramientasProgramacionOtros());
				cs.setString(6, excel.getSoftware_leguajeProgramacion());
				cs.setString(7, excel.getSoftware_leguajeProgramacionOtros());
				cs.setString(8, excel.getSoftware_gestorBD());
				cs.setString(9, excel.getSoftware_gestorBDOtros());
				cs.setString(10, excel.getSoftware_framework());
				cs.setString(11, excel.getSoftware_frameworkOtros());
				cs.setString(12, excel.getSoftware_observaciones());
				cs.setString(13, excel.getCompatibilidad_windows7());
				cs.setString(14, excel.getCompatibilidad_windows8());
				cs.setString(15, excel.getCompatibilidad_pTerminal());
				cs.setString(16, excel.getCompatibilidad_activeDirectory());

				// cs.registerOutParameter(8, Types.VARCHAR);
				System.out.println("Executing stored procedure 2...");

				cs.execute();
				result = "1";// cs.getString("output");
			} catch (SQLException sql) {
				throw sql;
			} finally {
				cs.close();
			}
		}

		return result;
	}

	private String insertExcelfileLineamientoDTO(CallableStatement cs,
			String result, Connection con, List<ExcelfileLineamientoDTO> list)
			throws SQLException {

		for (ExcelfileLineamientoDTO excel : list) {

			try {
				cs = con.prepareCall("call sp_insert_excel_lineamiento_temp_table("
						+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

				cs.setString(1, excel.getLineamiento_nombreAplicacion());
				cs.setString(2, excel.getLineamiento_privilegioSistema());
				cs.setString(3, excel.getLineamiento_privilegioUsuario());
				cs.setString(4, excel.getLineamiento_gestionContraseña());
				cs.setString(5, excel.getLineamiento_politicaContraseña());
				cs.setString(6, excel.getLineamiento_gestionClaves());
				cs.setString(7, excel.getLineamiento_gestionClaves2());
				cs.setString(8, excel.getLineamiento_gestionClaves3());
				cs.setString(9, excel.getLineamiento_registroAuditoria());
				cs.setString(10, excel.getLineamiento_proteccionAuditoria());
				cs.setString(11, excel.getLineamiento_registroEventos());
				cs.setString(12, excel.getLineamiento_conformidadPoliticas());
				cs.setString(13, excel.getLineamiento_contingencia());
				cs.setString(14, excel.getLineamiento_controlCambiosSoftware());
				cs.setString(15,
						excel.getLineamiento_controlCambiosInfraestructura());
				cs.setString(16, excel.getLineamiento_manejoDocumentacion());
				cs.setString(17, excel.getLineamiento_antivirusOrganizacion());
				cs.setString(18, excel.getLineamiento_codigoMalicioso());
				cs.setString(19, excel.getLineamiento_gestionParches());
				cs.setString(20, excel.getLineamiento_datosPrueba());
				cs.setString(21, excel.getLineamiento_respaldoRecuperacion());

				// cs.registerOutParameter(8, Types.VARCHAR);
				System.out.println("Executing stored procedure 3...");

				cs.execute();
				result = "1";// cs.getString("output");
			} catch (SQLException sql) {
				throw sql;
			} finally {
				cs.close();
			}
		}
		return result;
	}

	private String insertExcelfileDatamartDTO(CallableStatement cs,
			String result, Connection con, List<ExcelfileDatamartDTO> list)
			throws SQLException {

		for (ExcelfileDatamartDTO excel : list) {

			try {
				cs = con.prepareCall("call sp_insert_excel_datamart_temp_table("
						+ "?,?,?,?,?,?,?);");

				cs.setString(1, excel.getDatamart_nombre());
				cs.setString(2, excel.getDatamart_numeroTablas());
				cs.setString(3, excel.getDatamart_numeroTablasDescriptivas());
				cs.setString(4, excel.getDatamart_numeroTablasFacts());
				cs.setString(5, excel.getDatamart_herramientasExplotacion());
				cs.setString(6,
						excel.getDatamart_herramientasExplotacionOtros());
				cs.setString(7, excel.getDatamart_cantidadEspacio());

				// cs.registerOutParameter(8, Types.VARCHAR);
				System.out.println("Executing stored procedure 4...");

				cs.execute();
				result = "1";// cs.getString("output");
			} catch (SQLException sql) {
				throw sql;
			} finally {
				cs.close();
			}
		}
		return result;
	}

	private String insertExcelfileImpactoClasificacionDTO(CallableStatement cs,
			String result, Connection con,
			List<ExcelfileImpactoClasificacionDTO> list) throws SQLException {

		for (ExcelfileImpactoClasificacionDTO excel : list) {

			try {
				cs = con.prepareCall("call sp_insert_excel_impacto_temp_table("
						+ "?,?,?,?);");

				cs.setString(1, excel.getImpacto_confidencialidad());
				cs.setString(2, excel.getImpacto_integridad());
				cs.setString(3, excel.getImpacto_disponibilidad());
				cs.setString(4, excel.getImpacto_privacidad());

				// cs.registerOutParameter(8, Types.VARCHAR);
				System.out.println("Executing stored procedure 5...");

				cs.execute();
				result = "1";// cs.getString("output");
			} catch (SQLException sql) {
				throw sql;
			} finally {
				cs.close();
			}
		}
		return result;
	}

}
