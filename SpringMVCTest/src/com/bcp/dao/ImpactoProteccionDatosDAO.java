package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.ImpactoProteccionDatos;


public class ImpactoProteccionDatosDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ImpactoProteccionDatosDAO instancia;

    public static ImpactoProteccionDatosDAO getInstancia() {
        if (instancia == null) {
            instancia = new ImpactoProteccionDatosDAO();
        }
        return instancia;
    }
    
    public ArrayList<ImpactoProteccionDatos> obtenerImpacto() throws Exception {
        ArrayList<ImpactoProteccionDatos> lista = new ArrayList<ImpactoProteccionDatos>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_impacto_proteccion_datos()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ImpactoProteccionDatos objeto = new ImpactoProteccionDatos();
                objeto.setIdImpactoProteccionDatos(rs.getInt("ID_IMPACTO_PROTECCION_DATOS"));
                objeto.setDescripcionImpactoProteccionDatos(rs.getString("DESCRIPCION_IMPACTO_PROTECCION_DATOS"));
         
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
