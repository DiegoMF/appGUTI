package com.bcp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.bcp.dao.usuarioDAO;
import com.bcp.modelo.usuario;

import java.util.Map;

@Controller
@SessionAttributes("sesionusuario")
@RequestMapping("/inicio")
public class loginController {

	private Map session;

	public final Map getSession() {
		return session;
	}

	public final void setSession(Map session) {
		this.session = session;
	}

	public final String getMatricula() {
		return matricula;
	}

	public final void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	String matricula;
	ArrayList<usuario> listausuario = new ArrayList<>();
	usuario user = new usuario();

	public final usuario getUser() {
		return user;
	}

	public final void setUser(usuario user) {
		this.user = user;
	}

	public ArrayList<usuario> getListausuario() {
		System.out.println("lista");
		return listausuario;
	}

	public void setListausuario(ArrayList<usuario> listausuario) {
		System.out.println("lista2");
		this.listausuario = listausuario;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView loginUsuario(HttpServletRequest request,
			ModelAndView mod) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		System.out.println("controlador login");
		listausuario = new ArrayList<>();

		user.setMatricula(request.getParameter("Matricula"));
		
		user.setContrasena(request.getParameter("Contrasena"));
		
		//String password = "123456";
		
		//user.setContrasena( passwordEncoder.encode(request.getParameter("Contrasena")));
		
		
		listausuario = usuarioDAO.getInstancia().obtenerLogin(user);

		if (listausuario.size() > 0) {
			System.out.println("entrada lista");

			mod = new ModelAndView("consultaGeneral");
			mod.addObject("sesionusuario", user.getMatricula());
			return mod;

		} else {
			mod = new ModelAndView("index");
			mod.addObject("mensaje","usuario o contraseña invalidos. Intente otra vez");
			return mod;
		}
	}

	@RequestMapping(value =  "/SalirUsuario" , method = RequestMethod.GET)
	public ModelAndView SalirUsuario(HttpServletRequest request,
			ModelAndView mod) throws Exception {

			
		mod = new ModelAndView("index");
		mod.addObject("sesionusuario", "");
		return mod;

	}
	
	
	
	
	

}
