package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bcp.modelo.AppEspBitacora;

public class AppEspBitacoraDAO {
	
	private Connection cnn = null;
    private ResultSet rs = null;
    private static AppEspBitacoraDAO instancia;

    public static AppEspBitacoraDAO getInstancia() {
        if (instancia == null) {
            instancia = new AppEspBitacoraDAO();
        }
        return instancia;
    }
    
	

	public ArrayList<AppEspBitacora> consultaBitacoraEventos(AppEspBitacora evento) throws Exception {
	        ArrayList<AppEspBitacora> lista = new ArrayList<AppEspBitacora>();
	        try {
	        	
	        	
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs= cnn.prepareCall("call app_esp_bitacora_eventos_BUSCAR(?,?,?,?,?)");
				cs.setInt(1, evento.getIdAplicacionEspecializada());	
				cs.setString(2, evento.getMatriculaUsuario());
				cs.setString(3, evento.getEstadoEvento());	
				cs.setString(4, evento.getFechaCreacionDesde());	
				cs.setString(5, evento.getFechaCreacionHasta());
				
				
				int i = 1;
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	AppEspBitacora objeto = new AppEspBitacora();
	            	objeto.setNumero(i);
	            	objeto.setIdAplicacionEspecializada(rs.getInt("id_aplicacion_especializada"));
	            	objeto.setIdBitacoraEventos(rs.getInt("id_bitacora_eventos"));
	            	objeto.setDescripcionEvento(rs.getString("DESCRIPCION_EVENTO"));
	            	objeto.setFechaCreacion(rs.getString("FECHA_CREACION"));
	            	objeto.setMatriculaUsuario(rs.getString("MATRICULA"));
	            	objeto.setEstadoEvento(rs.getString("ESTADO_EVENTO"));
	            
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
	
	 public void ingresarEvento(AppEspBitacora evento) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call app_esp_bitacora_eventos_INSERTAR(?,?,?,?)");
	            cs.setInt(1, evento.getIdAplicacionEspecializada());
	            cs.setString(2, evento.getDescripcionEvento());
	            cs.setInt(3, evento.getUsuarioCreacion());
	            cs.setString(4, evento.getEstadoEvento());
	       
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	    
	 public void actualizarEvento(AppEspBitacora evento) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call app_esp_bitacora_eventos_UPDATE(?,?,?,?,?)");
	            cs.setInt(1, evento.getIdAplicacionEspecializada());
	            cs.setInt(2, evento.getIdBitacoraEventos());
	            cs.setString(3, evento.getDescripcionEvento());
	           
	            cs.setInt(4, evento.getUsuarioModificacion());
	            cs.setString(5, evento.getEstadoEvento());
	       
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	 
	 public void eliminarEvento(AppEspBitacora evento) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call app_esp_bitacora_eventos_DELETE(?,?,?)");
	            cs.setInt(1, evento.getIdAplicacionEspecializada());
	            cs.setInt(2, evento.getIdBitacoraEventos());
	            cs.setInt(3, evento.getUsuarioModificacion());
	            
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	 
	 public AppEspBitacora obtener(AppEspBitacora evento) throws Exception {
		 AppEspBitacora objeto = new AppEspBitacora();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call app_esp_bitacora_eventos_GET_EVENTO(?,?)");
	            cs.setInt(1, evento.getIdAplicacionEspecializada());
	            cs.setInt(2, evento.getIdBitacoraEventos());
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {	   
	            	objeto.setIdAplicacionEspecializada(rs.getInt("id_aplicacion_especializada"));
	            	objeto.setIdBitacoraEventos(rs.getInt("id_bitacora_eventos"));
	            	objeto.setCodigoAplicacionEspecializada(rs.getString("codigo_aplicacion_especializada"));
	            	objeto.setNombreAplicacionNOIT(rs.getString("nombre_aplicacion_noit"));
	            	objeto.setDescripcionEvento(rs.getString("descripcion_evento"));
	            	
	            	objeto.setEstadoEvento(rs.getString("estado_evento"));
	            	
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return objeto;
	    }
	 
	 public AppEspBitacora obtenerNuevo(AppEspBitacora evento) throws Exception {
		 AppEspBitacora objeto = new AppEspBitacora();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call app_esp_bitacora_eventos_GET(?)");
	            cs.setInt(1, evento.getIdAplicacionEspecializada());
	           
	            rs = cs.executeQuery();
	            while (rs.next()) {	   
	            	objeto.setIdAplicacionEspecializada(rs.getInt("id_aplicacion_especializada"));
	            	
	            	objeto.setCodigoAplicacionEspecializada(rs.getString("codigo_aplicacion_especializada"));
	            	objeto.setNombreAplicacionNOIT(rs.getString("nombre_aplicacion_noit"));
	           
	            	
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return objeto;
	    }
	   
}
