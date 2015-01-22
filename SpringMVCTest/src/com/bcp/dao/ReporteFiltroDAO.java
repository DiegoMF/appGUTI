package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.Reporte;
import com.bcp.modelo.ReporteFiltro;

public class ReporteFiltroDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ReporteFiltroDAO instancia;

    public static ReporteFiltroDAO getInstancia() {
        if (instancia == null) {
            instancia = new ReporteFiltroDAO();
        }
        return instancia;
    }
    
    public ArrayList<ReporteFiltro> obtenerFiltrosPorIdReporte(Reporte info) throws Exception {
    	ArrayList<ReporteFiltro> lista = new ArrayList<ReporteFiltro>();
		//ReporteFiltro objeto = new ReporteFiltro();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call reporteFiltro_porIdReporte_GET(?)");
            
            cs.setInt(1, info.getIdReporte());
            
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ReporteFiltro objeto = new ReporteFiltro();
            	objeto.setIdReporte(rs.getInt("id_reporte"));
				System.out.println("id reporte filtro" + objeto.getIdReporte());

            	objeto.setIdReporteColumna(rs.getInt("id_reporte_columna"));
            	objeto.setNombreColumna(rs.getString("descripcion"));
				System.out.println("nombre columna: " + objeto.getNombreColumna());

            	objeto.setIdReporteFiltro(rs.getInt("id_reporte_filtro"));
              
            	lista.add(objeto);
            }
            cnn.close();
            cs.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }

}
