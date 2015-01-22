package com.bcp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bcp.modelo.usuario;



public class usuarioDAO {
	 private Connection cnn = null;
	    private ResultSet rs = null;
	    private static usuarioDAO instancia;

	    public static usuarioDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new usuarioDAO();
	        }
	        return instancia;
	    }
	    
	    
	    public ArrayList<usuario> retornaID(usuario usuario) throws Exception {
			 ArrayList<usuario> lista = new ArrayList<usuario>();
			 try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_BUSCAR_ID(?)");
	           
	            cs.setString(1,usuario.getMatricula());
	            
	            
	            //cs.execute();
	           
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	usuario objeto = new usuario();
	               
	                objeto.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
	                
	                lista.add(objeto);
	            }

	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return lista;
	    }
	        
	    public ArrayList<usuario> obtenerLogin(usuario usuario) throws Exception {
	    	
	    	 ArrayList<usuario> lista = new ArrayList<usuario>();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_BUSCAR_LOGIN(?,?)");
	            
	            cs.setString(1, usuario.getMatricula());
	            cs.setString(2, usuario.getContrasena());
	        
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	usuario objeto = new usuario();
	                objeto.setMatricula(rs.getString("matricula"));
	                objeto.setEstado(rs.getInt("estado"));
	                lista.add(objeto);
	            }
	            
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return lista;
	    }
	    
	    
	    
	    public void ingresar(usuario objeto) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_INSERT(?,?,?,?,?,?,?,?)");
	            cs.setString(1, objeto.getApellidoPaterno());
	            cs.setString(2, objeto.getApellidoMaterno());
	            cs.setString(3, objeto.getNombres());
	            cs.setString(4, objeto.getCorreo());
	            cs.setInt(5, objeto.getIdRol());
	            cs.setString(6, objeto.getMatricula());
	            cs.setInt(7, objeto.getEstado());
	            cs.setString(8, objeto.getContrasena());
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	    
		
	    public int validarMatricula(usuario usuario) throws Exception{
	    	int existe=0;
	    	 try {
	    		 cnn = Conexion.getConexion();
		            CallableStatement cs = null;
		            cs = cnn.prepareCall("call seguridad_usuario_validar(?)");
		            cs.setString(1, usuario.getMatricula());
		            rs = cs.executeQuery();
		            while (rs.next()) {
		            	existe = rs.getInt("existe");		                
		            }
		            
		            
		            cnn.close();
		            cs.close();
	    		 
	    } catch (SQLException ex) {
            throw ex;
        }
	    	 return existe;
	    }
	    
	    
	    public void editar(usuario objeto) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_UPDATE(?,?,?,?,?,?,?,?,?)");
	            cs.setInt(1, objeto.getIdusuario());
	            cs.setString(2, objeto.getApellidoPaterno());
	            cs.setString(3, objeto.getApellidoMaterno());
	            cs.setString(4, objeto.getNombres());
	            cs.setString(5, objeto.getCorreo());
	            cs.setInt(6, objeto.getIdRol());
	            cs.setString(7, objeto.getMatricula());
	            cs.setInt(8, objeto.getEstado());
	            cs.setString(9, objeto.getContrasena());
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }
	    
	    
	    public ArrayList<usuario> buscar(usuario usuario) throws Exception {
	        ArrayList<usuario> lista = new ArrayList<usuario>();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_LIST(?,?,?,?,?,?)");
	            cs.setString(1, usuario.getApellidoPaterno());
	            cs.setString(2, usuario.getApellidoMaterno());
	            cs.setString(3, usuario.getNombres());
	            cs.setString(4, usuario.getMatricula());
	            cs.setInt(5, usuario.getIdRol());
	            cs.setInt(6, usuario.getEstado());
	            rs = cs.executeQuery();
	            while (rs.next()) {
	                usuario objeto = new usuario();
	                objeto.setIdusuario(rs.getInt("ID_SEGURIDAD_USUARIO"));
	                objeto.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
	                objeto.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
	                objeto.setNombres(rs.getString("NOMBRES"));
	                objeto.setCorreo(rs.getString("CORREO_ELECTRONICO"));
	                objeto.setIdRol(rs.getInt("ID_SEGURIDAD_ROL"));
	                objeto.setMatricula(rs.getString("matricula"));
	                objeto.setEstadoDescripcion(rs.getString("estado_descripcion"));
	                objeto.setDRol(rs.getString("descripcion_seguridad_rol"));
	                lista.add(objeto);
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return lista;
	    }
	    
	    public usuario obtener(usuario usuario) throws Exception {
	    	usuario objeto = new usuario();
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_GET(?)");
	            cs.setInt(1, usuario.getIdusuario());
	           
	            rs = cs.executeQuery();
	            while (rs.next()) {	                
	                objeto.setIdusuario(rs.getInt("ID_SEGURIDAD_USUARIO"));
	                objeto.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
	                objeto.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
	                objeto.setNombres(rs.getString("NOMBRES"));
	                objeto.setCorreo(rs.getString("CORREO_ELECTRONICO"));
	                objeto.setIdRol(rs.getInt("ID_SEGURIDAD_ROL"));
	                objeto.setMatricula(rs.getString("matricula"));
	                objeto.setEstado(rs.getInt("estado"));
	               
	            }
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	        return objeto;
	    }
	    
	    
	    public void eliminar(usuario objeto) throws Exception {
	        try {
	            cnn = Conexion.getConexion();
	            CallableStatement cs = null;
	            cs = cnn.prepareCall("call seguridad_usuario_DELETE(?)");
	            cs.setInt(1, objeto.getIdusuario());
	            
	            cs.execute();
	            cnn.close();
	            cs.close();
	        } catch (SQLException ex) {
	            throw ex;
	        }
	    }

	    public int validaContrasena(usuario usuario) throws Exception{
	    	
	    	int existe=0;
	    	 try {
	    		 cnn = Conexion.getConexion();
		            CallableStatement cs = null;
		            cs = cnn.prepareCall("call seguridad_usuario_validarContrasena(?)");
		            cs.setString(1, usuario.getContrasena());
		            rs = cs.executeQuery();
		            while (rs.next()) {
		            	existe = rs.getInt("existe");                
		            }
		            
		            
		            cnn.close();
		            cs.close();
	    		 
	    } catch (SQLException ex) {
           throw ex;
       }
	    	 return existe;
	    }
	    	
	    	
	    






	    
	    /*
	    public List<MantenimientoUsuarioDTO> obtenerUsuarios(usuario usuario) throws Exception{
	    	
	    	List<MantenimientoUsuarioDTO> datos = new ArrayList<MantenimientoUsuarioDTO>();
	    	try{
	    		cnn = Conexion.getConexion();
	    		CallableStatement cs = null;
	            cs = cnn.prepareCall("call sp_consulta_usuario(?,?,?)");
	            cs.setString(1, usuario.getApellidoPaterno());
	            cs.setString(2, usuario.getApellidoMaterno());
	            cs.setString(3, usuario.getNombres());
	            rs = cs.executeQuery();
	    		
	    		while(rs.next()){
	    			MantenimientoUsuarioDTO dato = new MantenimientoUsuarioDTO();
	    			dato.setMatricula(rs.getString(1));
	    			dato.setApellidoPaterno(rs.getString(2));
	    			dato.setApellidoMaterno(rs.getString(3));
	    			dato.setNombres(rs.getString(4));
	    			dato.setRol(rs.getString(5));
	    			dato.setEstado(rs.getString(6));

	    			datos.add(dato);
	    		}
	    		cs.close();
	    		rs.close();
	    	} catch (SQLException ex) {
	               throw ex;
	        }
	    	return datos;
	    }
	    */
	    
	    
	    
	/*    public List<MantenimientoUsuarioDTO> obtenerUsuariosa(){
	    	
	    	List<MantenimientoUsuarioDTO> datos = new ArrayList<MantenimientoUsuarioDTO>();
	    	try{

	    		cnn = Conexion.getConexion();

	    		String sql = "select u.matricula, u.apellido_paterno, u.apellido_materno, u.nombres, r.descripcion_seguridad_rol, u.estado " + 
	    		"from seguridad_usuario u " +
	    		"inner join seguridad_rol r " + 
	    		"on u.id_seguridad_rol = r.id_seguridad_rol";

	    		PreparedStatement pst = cnn.prepareStatement(sql);

	    		ResultSet rs = pst.executeQuery();

	    		

	    		while(rs.next()){
	    			MantenimientoUsuarioDTO dato = new MantenimientoUsuarioDTO();
	    			dato.setMatricula(rs.getString(1));
	    			dato.setApellidoPaterno(rs.getString(2));
	    			dato.setApellidoMaterno(rs.getString(3));
	    			dato.setNombres(rs.getString(4));
	    			dato.setRol(rs.getString(5));
	    			dato.setEstado(rs.getString(6));

	    			datos.add(dato);
	    		}

	    		pst.close();
	    		rs.close();
	    	} catch (SQLException ex) {
	               throw ex;
	        }
	    	return datos;
	    }*/
	    
}
