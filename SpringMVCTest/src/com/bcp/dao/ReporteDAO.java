package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AppEspPostAtencionSwBaseEstandarTecnologico;
import com.bcp.modelo.Reporte;
import com.bcp.modelo.dto.AplicacionEspecializadaDTO;
import com.bcp.modelo.dto.ConsultaGeneralAplicacionesDTO;

public class ReporteDAO {

	private Connection cnn = null;
	private ResultSet rs = null;
	private static ReporteDAO instancia;

	public static ReporteDAO getInstancia() {
		if (instancia == null) {
			instancia = new ReporteDAO();
		}
		return instancia;
	}
	
	public ArrayList<Reporte> buscarReporte(Reporte reporte) throws Exception {
		ArrayList<Reporte> lista = new ArrayList<Reporte>();
		int i = 1;
		try {
			System.out.println("llega al buscar reporte");

			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call reporte_BUSCAR(?,?,?,?)");
			cs.setString(1, reporte.getNombreReporte());
			cs.setString(2, reporte.getEstado());
			cs.setString(3, reporte.getFechaCreacion());
			cs.setString(4, reporte.getMatricula());
			
	
			rs = cs.executeQuery();
			while (rs.next()) {
				Reporte objeto = new Reporte();
				objeto.setNumero(i);
				objeto.setIdReporte(rs.getInt("id_reporte"));
				System.out.println("id de reporte:" + objeto.getIdReporte());

				objeto.setNombreReporte(rs.getString("nombre_reporte"));
				System.out.println("nombre de reporte " + objeto.getNombreReporte());

				objeto.setFechaCreacion(rs.getString("fecha_creacion"));
				objeto.setMatricula(rs.getString("matricula"));
				objeto.setEstado(rs.getString("estado"));
				
				
				lista.add(objeto);
				i++;
			}

			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}
	
	
	
	public Reporte obtenerReportePorId(Reporte info) throws Exception {
    	Reporte objeto = new Reporte();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call reporte_porId__GET(?)");
            
            cs.setInt(1, info.getIdReporte());            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	
            	objeto.setNombreReporte(rs.getString("nombre_reporte"));
            	objeto.setFechaCreacion(rs.getString("fecha_creacion"));
            	objeto.setMatricula(rs.getString("matricula"));
            	objeto.setEstado(rs.getString("estado"));

            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return objeto;
    }
	
	
	public AplicacionEspecializadaDTO obtenerReporteNivelCumplimiento(
			AplicacionEspecializadaDTO aplicaciones) throws Exception {

		//ArrayList<AplicacionEspecializadaDTO> datos = new ArrayList<AplicacionEspecializadaDTO>();
		AplicacionEspecializadaDTO dato = new AplicacionEspecializadaDTO();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call app_esp_Reporte_Cumplimiento_Lineamientos(?,?,?,?,?,?,?)");
			
			
			cs.setString(1, aplicaciones.getCodigoAplicacionEspecializada());
			cs.setInt(2, aplicaciones.getIdEstadoAplicacion());
			cs.setInt(3, aplicaciones.getIdGerenciaCentral());
			cs.setInt(4, aplicaciones.getIdDivision());
			cs.setInt(5, aplicaciones.getIdArea());
			cs.setInt(6, aplicaciones.getIdUnidad());
			cs.setInt(7, aplicaciones.getIdCriticidadFinal());
			
			/*String nivelCump = aplicaciones.getNivelCumplimiento() == -1.0 ? ""
					: String.valueOf(aplicaciones.getNivelCumplimiento());
			cs.setString(6, nivelCump);
			*/
			
			rs = cs.executeQuery();

			
			while (rs.next()) {
				//AplicacionEspecializadaDTO dato = new AplicacionEspecializadaDTO();
				dato.setNivelCumplimientoTotal(rs.getDouble("NIVEL_CUMPLIMIENTO_TOTAL"));
				dato.setNivelCumplimientoEstandaresPorcentaje(rs.getDouble("NIVEL_CUMPLIMIENTO_ESTANDARES_PORCENTAJE"));
				dato.setNivelCumplimientoLineamientosPorcentaje(rs.getDouble("NIVEL_CUMPLIMIENTO_LINEAMIENTOS_PORCENTAJE"));
				//datos.add(dato);
				
			}
			System.out.println("nivel de cumplimiento total" + dato.getNivelCumplimientoTotal());
			cnn.close();
			cs.close();
		} catch (SQLException e) {
			throw e;
		}
		return dato;
	}
	
	
}
