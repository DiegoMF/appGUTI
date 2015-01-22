package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bcp.modelo.AppEspHistorialVersion;;

public class AppEspHistorialVersionDAO {

	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspHistorialVersionDAO instancia;

    public static AppEspHistorialVersionDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspHistorialVersionDAO();
        }
        return instancia;
    }
    
    public ArrayList<AppEspHistorialVersion> ConsultaHistorialVersion(AppEspHistorialVersion evento) throws Exception {
        ArrayList<AppEspHistorialVersion> lista = new ArrayList<AppEspHistorialVersion>();
        try {
        	
        	
            cnn = Conexion.getConexion();
            CallableStatement cs = null;
            cs= cnn.prepareCall("call sp_obtener_historico_version_aplicaciones_BUSCAR(?,?,?)");
			cs.setInt(1, evento.getIdAplicacionEspecializada());	
				
			cs.setString(2, evento.getFechaCreacionDesde());	
			cs.setString(3, evento.getFechaCreacionHasta());
			
			
			int i = 1;
            rs = cs.executeQuery();
            while (rs.next()) {
            	AppEspHistorialVersion objeto = new AppEspHistorialVersion();
            	objeto.setNumero(i);
            	objeto.setIdAplicacionEspecializada(rs.getInt("id_aplicacion_especializada"));
            	objeto.setIdversion(rs.getString("ID_VERSION"));
            	objeto.setFechacreacion(rs.getString("FECHA_CREACION_REGISTRO"));
            	objeto.setUsuarioCreacion(rs.getString("MATRICULA"));
            	objeto.setDescripcionmotivo(rs.getString("DESCRIPCION_MOTIVO_CREACION_APLICACION"));
                        
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
    
    
}
