package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Types;
import java.util.List;

import com.bcp.modelo.dto.ExcelfileDTO;

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
    
    public String insertDataFileUpload(List<ExcelfileDTO> list) throws Exception{
    	
    	CallableStatement cs = null;
    	String result = "";
    	try {
    		con = Conexion.getConexion();
    		for(ExcelfileDTO excel : list){
    			
    			cs = con.prepareCall("call sp_insert_excel_upload_temp_table("
    			+ "?,?,?,?,"
    			+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
    			+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
    			+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
    			+ "?,?,?,?,?,?,?);");

    			cs.setString(1,excel.getEstructura_gerenciaCentral()); 
    			cs.setString(2,excel.getEstructura_division()); 
    			cs.setString(3,excel.getEstructura_area()); 
    			cs.setString(4,excel.getEstructura_unidad());
    			
    			cs.setString(5,excel.getInformacion_nombreAplicacion()); 
    			cs.setString(6,excel.getInformacion_descripcionAplicacion()); 
    			cs.setString(7,excel.getInformacion_funcionalidades());
    			cs.setString(8,excel.getInformacion_estado()); 
    			cs.setString(9,excel.getInformacion_tipoOperacion()); 
    			cs.setString(10,excel.getInformacion_frecuenciaOperacion()); 
    			cs.setString(11,excel.getInformacion_cantidadOperacion()); 
    			cs.setString(12,excel.getInformacion_fechaCreacion());
    			cs.setString(13,excel.getInformacion_motivoCreacion()); 
    			cs.setString(14,excel.getInformacion_motivoCreacionOtros()); 
    			cs.setInt(15,excel.getInformacion_numeroFuncionalidades()); 
    			cs.setInt(16,excel.getInformacion_numeroReportes());
    			cs.setInt(17,excel.getInformacion_numeroConsultas()); 
    			cs.setInt(18,excel.getInformacion_numeroEntidadesExternas()); 
    			cs.setInt(19,excel.getInformacion_numeroEntidadesInternas()); 
    			cs.setString(20,excel.getInformacion_observacionesGenerales()); 
    			
    			cs.setString(21,excel.getCaracteristica_categoriaTecnologica()); 
    			cs.setString(22,excel.getCaracteristica_tipoDesarrollo()); 
    			cs.setString(23,excel.getCaracteristica_ubicacionFisica()); 
    			cs.setString(24,excel.getCaracteristica_ambienteAppNoIT()); 
    			cs.setString(25,excel.getCaracteristica_nombreUbicacion()); 
    			cs.setString(26,excel.getCaracteristica_infraestructuraAplicacion()); 
    			cs.setString(27,excel.getCaracteristica_standAlone()); 
    			cs.setInt(28,excel.getCaracteristica_numeroInterfaces()); 
    			cs.setString(29,excel.getCaracteristica_nombreInterfaces()); 
    			cs.setString(30,excel.getCaracteristica_mantenimientoAplicacion()); 
    			cs.setString(31,excel.getCaracteristica_nombreProveedorMantenimiento()); 
    			cs.setString(32,excel.getCaracteristica_soporteAplicacion()); 
    			cs.setString(33,excel.getCaracteristica_nombreProveedorSoporte()); 
    			cs.setString(34,excel.getCaracteristica_accesoAplicacion()); 
    			cs.setString(35,excel.getCaracteristica_nombreProveedorAcceso()); 
    			cs.setString(36,excel.getCaracteristica_nombreServidor()); 
    			cs.setString(37,excel.getCaracteristica_ubicacionServidor());
    			
    			cs.setString(38,excel.getDominio_usuarioAplicacion()); 
    			cs.setString(39,excel.getDominio_gestorAplicacion()); 
    			cs.setString(40,excel.getDominio_especialistaAplicacion()); 
    			cs.setString(41,excel.getDominio_brokerSistemas()); 
    			cs.setString(42,excel.getDominio_brokerNegocio()); 
    			cs.setString(43,excel.getDominio_asesorGUTI()); 
    			cs.setString(44,excel.getDominio_entidadUsuario()); 
    			cs.setString(45,excel.getDominio_nombreDominio()); 
    			cs.setString(46,excel.getDominio_nombreSUBDominio()); 
    			cs.setInt(47,excel.getDominio_numeroUnidadesAplicacion()); 
    			cs.setString(48,excel.getDominio_nombreUnidad1()); 
    			cs.setString(49,excel.getDominio_nombreUnidad2()); 
    			cs.setString(50,excel.getDominio_nombreUnidad3()); 
    			cs.setString(51,excel.getDominio_usuariosTotalAplicacion()); 
    			cs.setString(52,excel.getDominio_procesoAuditoria()); 
    			cs.setString(53,excel.getDominio_procesoAuditoriaOtros()); 
    			cs.setString(54,excel.getDominio_procesoClave()); 
    			cs.setString(55,excel.getDominio_nombreProcesoClave()); 
    			cs.setString(56,excel.getDominio_nombreProcesoClaveOtros()); 
    			cs.setString(57,excel.getDominio_actividad()); 
    			cs.setString(58,excel.getDominio_CIF());
    			
    			cs.setString(59,excel.getEvaluacion_confidencialidad()); 
    			cs.setString(60,excel.getEvaluacion_integridad()); 
    			cs.setString(61,excel.getEvaluacion_disponibilidad()); 
    			cs.setString(62,excel.getEvaluacion_privacidad()); 
    			cs.setString(63,excel.getEvaluacion_clasificacion()); 
    			cs.setString(64,excel.getEvaluacion_observacion()); 
    			cs.setString(65,excel.getEvaluacion_criticidadFinal()); 
 
        		//cs.registerOutParameter(8, Types.VARCHAR); 
        		System.out.println("Executing stored procedure..." );
                
        		cs.execute();                
                result = "1";//cs.getString("output");
    		}
		} catch (SQLException sql) {
			sql.printStackTrace();
		} finally {
			con.close();
			cs.close();
		}
    	return result;
    }

}
