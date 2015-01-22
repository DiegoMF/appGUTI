package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.ImpactoProteccionDatosLevantamientoInformacion;

public class ImpactoProteccionDatosLevantamientoInformacionDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static ImpactoProteccionDatosLevantamientoInformacionDAO instancia;

    public static ImpactoProteccionDatosLevantamientoInformacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new ImpactoProteccionDatosLevantamientoInformacionDAO();
        }
        return instancia;
    }
    
    public ArrayList<ImpactoProteccionDatosLevantamientoInformacion> obtenerImpactoLevantamiento() throws Exception {
        ArrayList<ImpactoProteccionDatosLevantamientoInformacion> lista = new ArrayList<ImpactoProteccionDatosLevantamientoInformacion>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_impacto_proteccion_datos_levantamiento_informacion()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	ImpactoProteccionDatosLevantamientoInformacion objeto = new ImpactoProteccionDatosLevantamientoInformacion();
                objeto.setIdImpactoProteccionDatosLevantamientoInformacion(rs.getInt("ID_IMPACTO_PROTECCION_DATOS_LEVANTAMIENTO_INFORMACION"));
                objeto.setDescripcionImpactoProteccionDatosLevantamientoInformacion(rs.getString("DESCRIPCION_IMPACTO_PROTECCION_DATOS_LEVANTAMIENTO_INFORMACION"));
         
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
