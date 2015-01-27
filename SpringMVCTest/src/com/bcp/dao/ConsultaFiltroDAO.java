package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.*;

public class ConsultaFiltroDAO {

	private Connection cnn = null;
	private ResultSet rs = null;
	private static ConsultaFiltroDAO instancia;

	public static ConsultaFiltroDAO getInstancia() {
		if (instancia == null) {
			instancia = new ConsultaFiltroDAO();
		}
		return instancia;
	}
    public ArrayList<ConsultaFiltro> obtenerFiltrosPorIdReporte(Consulta info) throws Exception {
    	ArrayList<ConsultaFiltro> lista = new ArrayList<ConsultaFiltro>();
		//ReporteFiltro objeto = new ReporteFiltro();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call reporteFiltro_porIdReporte_GET(?)");
            
            cs.setInt(1, info.getIdReporte());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ConsultaFiltro objeto = new ConsultaFiltro();
            	/*objeto.setIdReporte(rs.getInt("idConsulta"));
				System.out.println("id reporte filtro" + objeto.getIdReporte());

            	objeto.setIdReporteColumna(rs.getInt("idConsulta_columna"));
            	*/
            	objeto.setNombreColumna(rs.getString("descripcion"));
				/*System.out.println("nombre columna: " + objeto.getNombreColumna());*/

            	objeto.setIdReporteFiltro(rs.getInt("idConsulta_filtro"));
              
            	lista.add(objeto);
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }
	public ArrayList<ConsultaFiltro> obtener(int idConsulta) throws Exception {
		ArrayList<ConsultaFiltro> lista = new ArrayList<ConsultaFiltro>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall("call consulta_filtro_GET_BY_Consulta(?)");
			cs.setInt(1, idConsulta);
			rs = cs.executeQuery();
			while (rs.next()) {
				ConsultaFiltro objeto = new ConsultaFiltro();

				objeto.setIdConsultaFiltro(rs.getInt("idConsulta_filtro"));
				objeto.setIdConsultaColumna(rs.getInt("idConsulta_columna"));
				objeto.setIdConsulta(rs.getInt("idConsulta"));
				objeto.setDescripcion(rs.getString("Descripcion"));
				objeto.setTabla(rs.getString("tabla"));
				objeto.setForaneo(rs.getBoolean("foraneo"));
				objeto.setTablaSeccion(rs.getString("TablaSeccion"));
				objeto.setColumnaForanea(rs.getString("ColumnaForanea"));
				objeto.setDescripcionForanea(rs.getString("DescripcionForanea"));
				lista.add(objeto);
			}

			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}

	public ArrayList<String> listarcombos(String consulta) throws Exception {
		ArrayList<String> lista = new ArrayList<String>();
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall(consulta);

			rs = cs.executeQuery();
			while (rs.next()) {
				String fila = "";

				fila = "<option value=\"" + rs.getString(1) + "\">"
						+ rs.getString(2) + "</option>";

				lista.add(fila);
			}

			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}

	public String listarResultado(String consulta) throws Exception {
		String fila = "<table>";
		try {
			cnn = Conexion.getConexion();
			CallableStatement cs = null;
			cs = cnn.prepareCall(consulta);

			rs = cs.executeQuery();

			int cont = 0;

			while (rs.next()) {

				int tamaño = rs.getMetaData().getColumnCount();

				if (cont == 0) {
					fila = fila + "<thead>";
					for (int i = 1; i <= tamaño; i++) {

						fila = fila + "<th>"
								+ rs.getMetaData().getColumnLabel(i) + "</th>";

					}
					fila = fila + "</thead><tbody>";
				}

				fila = fila + "<tr>";

				for (int i = 1; i <= tamaño; i++) {

					fila = fila + "<td>" + rs.getString(i) + "</td>";

				}
				fila = fila + "</tr>";

				cont++;
			}
			fila = fila + "</tbody></table>";
			cnn.close();
			cs.close();
		} catch (SQLException ex) {
			throw ex;
		}
		return fila;
	}

}
