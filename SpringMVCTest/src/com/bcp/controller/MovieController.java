package com.bcp.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.modelo.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.bcp.dao.*;

@Controller
@RequestMapping("/usuario")
public class MovieController {

	// DI via Spring
	String message;
	String matricula;
	ArrayList<usuario> listausuario = new ArrayList<>();
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public ArrayList<usuario> getListausuario() {
		System.out.println("lista");
		return listausuario;
	}

	public void setListausuario(ArrayList<usuario> listausuario) {
		System.out.println("lista2");
		this.listausuario = listausuario;
	}

	@RequestMapping(value = { "/load" }, method = RequestMethod.POST)
	public ModelAndView load(HttpServletRequest request, ModelMap mod)
			throws Exception {

		usuario user = new usuario();
		user.setIdusuario(Integer.parseInt(request.getParameter("idUsuario")));

		user = usuarioDAO.getInstancia().obtener(user);

		ModelAndView model = new ModelAndView("mantenimientoUsuario");
		model.addObject("usuario", user);

		return model;

	}

	@RequestMapping(value = { "/buscar" }, method = RequestMethod.POST)
	public ModelAndView getUsuarios(HttpServletRequest request, ModelMap mod)
			throws Exception {
		System.out.println("entra buscar");
		listausuario = new ArrayList<>();

		usuario user = new usuario();
		user.setApellidoMaterno(request.getParameter("apMaterno"));

		user.setApellidoPaterno(request.getParameter("apPaterno"));

		user.setNombres(request.getParameter("nombres"));

		user.setMatricula(request.getParameter("matricula"));

		if (request.getParameter("rol") == "") {
			user.setIdRol(-99);
		} else {
			user.setIdRol(Integer.parseInt(request.getParameter("rol")));
		}

		if (request.getParameter("estado") == "") {
			user.setEstado(-99);
		} else {
			user.setEstado(Integer.parseInt(request.getParameter("estado")));
		}

		listausuario = usuarioDAO.getInstancia().buscar(user);

		if (listausuario.size() == 0) {
			message = "No se encontraron registros.";
			ModelAndView model = new ModelAndView("Auxiliar/ListaUsuario");
			model.addObject("mensajeInfo", message);

			return model;
		} else {
			int totalRegistro = listausuario.size();
			ModelAndView model = new ModelAndView("Auxiliar/ListaUsuario");
			model.addObject("listausuario", listausuario);
			model.addObject("totalRegistro", totalRegistro);
			return model;
		}

	}
	
	@RequestMapping(value = { "/ingresar" }, method = RequestMethod.POST)
	public String IngresarUsuario(HttpServletRequest request,ModelMap model) throws Exception {
		
		LogAuditoriaController logAuditoria = new LogAuditoriaController();
		LogAuditoria objeto = new LogAuditoria();
		Date fecha = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {
			

			usuario user = new usuario();
			user.setApellidoPaterno(request.getParameter("apPaterno"));
			user.setApellidoMaterno(request.getParameter("apMaterno"));
			user.setNombres(request.getParameter("nombres"));		
			user.setCorreo(request.getParameter("correo"));
			user.setEstado(Integer.parseInt(request.getParameter("estado")));
			user.setIdRol(Integer.parseInt(request.getParameter("rol")));
			user.setMatricula(request.getParameter("matricula"));
			user.setContrasena(request.getParameter("Contrasena"));

			if (usuarioDAO.getInstancia().validarMatricula(user) == 0) {
				
				usuarioDAO.getInstancia().ingresar(user);
				model.addAttribute("mensaje", "Se ingresó correctamente");
				//Registro log de auditoría
				objeto.setPagina("MantenimientoUsuario.jsp");
				objeto.setObjeto("");
				objeto.setTraza_error("");
				objeto.setTipo("Acceso");
				objeto.setIp(logAuditoria.obtenerIP());
				objeto.setUsuario(request.getParameter("usuarioActual"));
				objeto.setFecha(sdf.format(fecha));
				objeto.setHora(hourFormat.format(fecha));
				logAuditoria.guardarLogAuditoria(objeto);
				
			} else {

				model.addAttribute("mensaje", "El usuario ya existe");
			}

		} catch (SQLException ex) {
			model.addAttribute("mensaje", ex.getMessage());
			
			//Registro log de auditoría
			objeto.setPagina("MantenimientoUsuario.jsp");
			objeto.setObjeto("IngresarUsuario");
			objeto.setTraza_error(ex.getMessage());
			System.out.println("mostrar pagina:= " + ex.getMessage());
			objeto.setTipo("Error");
			objeto.setIp(logAuditoria.obtenerIP());
			objeto.setUsuario(request.getParameter("usuarioActual"));
			objeto.setFecha(sdf.format(fecha));
			objeto.setHora(hourFormat.format(fecha));
			logAuditoria.guardarLogAuditoria(objeto);
			
		}

		return "consultaUsuario";

	}

	@RequestMapping(value = {"/editar"}, method = RequestMethod.POST)
	public String EditarUsuario(HttpServletRequest request,	ModelMap model) throws Exception {
		
		LogAuditoriaController logAuditoria = new LogAuditoriaController();
		LogAuditoria objeto = new LogAuditoria();
		Date fecha = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {

			usuario user = new usuario();

			user.setIdusuario(Integer.parseInt(request.getParameter("idUsuario")));
			user.setApellidoPaterno(request.getParameter("apPaterno"));
			user.setApellidoMaterno(request.getParameter("apMaterno"));
			user.setNombres(request.getParameter("nombres"));		
			user.setCorreo(request.getParameter("correo"));
			user.setEstado(Integer.parseInt(request.getParameter("estado")));
			user.setIdRol(Integer.parseInt(request.getParameter("rol")));
			user.setMatricula(request.getParameter("matricula"));
			user.setContrasena(request.getParameter("Contrasena"));	
			
			
			if(usuarioDAO.getInstancia().validaContrasena(user) == 0)
			{
				usuarioDAO.getInstancia().editar(user);
				model.addAttribute("mensaje", "Se actualizó correctamente");
				
				//Registro log de auditoría
				objeto.setPagina("MantenimientoUsuario.jsp");
				objeto.setObjeto("");
				objeto.setTraza_error("");
				objeto.setTipo("Acceso");
				objeto.setIp(logAuditoria.obtenerIP());
				objeto.setUsuario(request.getParameter("usuarioActual"));
				objeto.setFecha(sdf.format(fecha));
				objeto.setHora(hourFormat.format(fecha));
				logAuditoria.guardarLogAuditoria(objeto);
				
			}
		else {

			model.addAttribute("mensaje", "La contraseña no debe ser igual a una contraseña anterior");
			return "mantenimientoUsuario";
		}
			
			
			

		} catch (Exception ex) {
			model.addAttribute("mensaje", ex.getMessage());
			
			
			//Registro log de auditoría
			objeto.setPagina("MantenimientoUsuario.jsp");
			objeto.setObjeto("EditarUsuario");
			objeto.setTraza_error(ex.getMessage());
			System.out.println("mostrar pagina:= " + ex.getMessage());
			objeto.setTipo("Error");
			objeto.setIp(logAuditoria.obtenerIP());
			objeto.setUsuario(request.getParameter("usuarioActual"));
			objeto.setFecha(sdf.format(fecha));
			objeto.setHora(hourFormat.format(fecha));
			logAuditoria.guardarLogAuditoria(objeto);

		}

		// return to jsp page, configured in mvc-dispatcher-servlet.xml, view
		// resolver
		return "consultaUsuario";

	}

	@RequestMapping(value = { "/elimina" }, method = RequestMethod.POST)
	public ModelAndView EliminaUsuario(HttpServletRequest request, ModelMap mod)
			throws Exception {

		

		usuario user = new usuario();
		user.setIdusuario(Integer.parseInt(request.getParameter("idUsuario")));

		System.out.print("idusuaraio:   " + user.getIdusuario());
		usuarioDAO.getInstancia().eliminar(user);

		ModelAndView model = new ModelAndView("consultaUsuario");

		return model;

	}

	public void setMessage(String message) {
		this.message = message;
	}

}