package com.bcp.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bcp.modelo.AccesosRevisionPrivilegiosUsuarios;

public class AccesosRevisionPrivilegiosUsuariosDAO {
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AccesosRevisionPrivilegiosUsuariosDAO instancia;

    public static AccesosRevisionPrivilegiosUsuariosDAO getInstancia() {
        if (instancia == null) {
            instancia = new AccesosRevisionPrivilegiosUsuariosDAO();
        }
        return instancia;
    }
    
    public ArrayList<AccesosRevisionPrivilegiosUsuarios> obtenerAccesosRevisionPrivilegiosUsuarios() throws Exception {
        ArrayList<AccesosRevisionPrivilegiosUsuarios> lista = new ArrayList<AccesosRevisionPrivilegiosUsuarios>();
        try {
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs = cnn.prepareCall("call sp_obtener_accesosRevisionPrivilegiosUsuarios()");
            
            rs = cs.executeQuery();
            while (rs.next()) {
            	AccesosRevisionPrivilegiosUsuarios objeto = new AccesosRevisionPrivilegiosUsuarios();
                objeto.setIdAccesosRevisionPrivilegiosUsuarios(rs.getInt("ID_ACCESOS_REVISION_PRIVILEGIOS_USUARIOS"));
                objeto.setDescripcionAccesosRevisionPrivilegiosUsuarios(rs.getString("DESCRIPCION_ACCESOS_REVISION_PRIVILEGIOS_USUARIOS"));
         
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
