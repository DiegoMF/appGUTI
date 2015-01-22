package com.bcp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.dao.AppEspBitacoraDAO;
import com.bcp.dao.usuarioDAO;
import com.bcp.modelo.AppEspBitacora;
import com.bcp.modelo.LogAuditoria;
import com.bcp.modelo.usuario;

@Controller
@RequestMapping("/aplicacionEspecializadaBitacora")
public class AppEspBitacoraController {

	ArrayList<AppEspBitacora> listaEvento = new ArrayList<>();
	String message;
	public ArrayList<AppEspBitacora> getListaUsuario() {

		System.out.println("entra a: getListaUsuario");
		return listaEvento;
	}
	
	ArrayList<usuario> listausuario = new ArrayList<>();
	usuario userID = new usuario();

	public final usuario getUser() {
		return userID;
	}

	public final void setUser(usuario user) {
		this.userID = user;
	}

	public void setListaUsuario(ArrayList<AppEspBitacora> listaEventos) {
		System.out.println("entra a: listaEventos");
		this.listaEvento = listaEventos;
	}

	@RequestMapping(value = { "/load" }, method = RequestMethod.POST)
	public ModelAndView cargaBitacoraEventos(HttpServletRequest request, ModelMap mod)	throws Exception {

		AppEspBitacora bitacora = new AppEspBitacora();

		bitacora.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaE")));
		bitacora.setIdBitacoraEventos(Integer.parseInt(request.getParameter("IdBitacoraEventos")));
		bitacora = AppEspBitacoraDAO.getInstancia().obtener(bitacora);
		System.out.println("id.: " + bitacora.getDescripcionEvento());
		ModelAndView model = new ModelAndView("actualizarBitacoraEventos");
		model.addObject("evento", bitacora);

		return model;

	}

	@RequestMapping(value = { "/nuevo" }, method = RequestMethod.POST)
	public ModelAndView nuevoBitacoraEventos(HttpServletRequest request, ModelMap mod)
			throws Exception {

		AppEspBitacora bitacora = new AppEspBitacora();

		bitacora.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaE")));

		bitacora = AppEspBitacoraDAO.getInstancia().obtenerNuevo(bitacora);
		
		ModelAndView model = new ModelAndView("registrarBitacoraEventos");
		model.addObject("evento", bitacora);

		return model;

	}
	
	@RequestMapping(value = "/consultaBitacoraEventos", method = RequestMethod.POST)
	public ModelAndView consultaBitacoraEventos(HttpServletRequest request,	ModelMap mod) throws Exception {
		System.out.print("entrar consulta");
		listaEvento = new ArrayList<>();

		AppEspBitacora bitacora = new AppEspBitacora();
		
	
		bitacora.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaE")));

		
		
		bitacora.setMatriculaUsuario(request.getParameter("matriculaUsuario"));

		bitacora.setEstadoEvento(request.getParameter("estadoEvento"));

		bitacora.setFechaCreacionDesde(request.getParameter("fechaDesde"));

		bitacora.setFechaCreacionHasta(request.getParameter("fechaHasta"));

		listaEvento = AppEspBitacoraDAO.getInstancia().consultaBitacoraEventos(
				bitacora);

		if (listaEvento.size() == 0) {
			
			message = "No se encontraron datos.";
			ModelAndView model = new ModelAndView("Auxiliar/ListaBitacoraEventos");
			model.addObject("mensajeEvento", message);
			return model;
		} else {

			ModelAndView model = new ModelAndView("Auxiliar/ListaBitacoraEventos");
			model.addObject("listaEvento", listaEvento);
			return model;
		}


	}

	@RequestMapping(value = "/registrarBitacoraEvento", method = RequestMethod.POST)
	public String registarBitacoraEventos(HttpServletRequest request,
			ModelMap mod, ModelMap model) throws Exception {
		
		LogAuditoriaController logAuditoria = new LogAuditoriaController();
		LogAuditoria objeto = new LogAuditoria();
		Date fecha = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {

			AppEspBitacora AppEsp = new AppEspBitacora();
			int ID = 0;

				AppEsp.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaE")));

				AppEsp.setDescripcionEvento(request.getParameter("descripcionEvento"));
				
				/* ID USUARIO */
				userID.setMatricula(request.getParameter("idUsuarioE"));
				listausuario = usuarioDAO.getInstancia().retornaID(userID);
				Iterator<usuario> list = listausuario.iterator();
				while (list.hasNext()) {
					usuario iuserID = list.next();
					ID = iuserID.getIdusuario();
				}
				
				AppEsp.setUsuarioCreacion(ID);
				AppEsp.setEstadoEvento(request.getParameter("estadoEvento"));

				AppEspBitacoraDAO.getInstancia().ingresarEvento(AppEsp);
				
				model.addAttribute("mensajeBitacora","Se registró correctamente");
				
				//Registro log de auditoría
				objeto.setPagina("registrarBitacoraEventos.jsp");
				objeto.setObjeto("");
				objeto.setTraza_error("");
				objeto.setTipo("Acceso");
				objeto.setIp(logAuditoria.obtenerIP());
				objeto.setUsuario(request.getParameter("idUsuarioE"));
				objeto.setFecha(sdf.format(fecha));
				objeto.setHora(hourFormat.format(fecha));
				logAuditoria.guardarLogAuditoria(objeto);
		

		} catch (Exception ex) {
			model.addAttribute("mensajeBitacora", ex.getMessage());
			//Registro log de auditoría
			objeto.setPagina("registrarBitacoraEventos.jsp");
			objeto.setObjeto("registrarBitacoraEventos");
			objeto.setTraza_error(ex.getMessage());
			System.out.println("mostrar pagina:= " + ex.getMessage());
			objeto.setTipo("Error");
			objeto.setIp(logAuditoria.obtenerIP());
			objeto.setUsuario(request.getParameter("idUsuarioE"));
			objeto.setFecha(sdf.format(fecha));
			objeto.setHora(hourFormat.format(fecha));
			logAuditoria.guardarLogAuditoria(objeto);

		}
	
		return "registrarBitacoraEventos";

	}
	
	@RequestMapping(value = "/actualizarBitacoraEvento", method = RequestMethod.POST)
	public String actualizaBitacoraEventos(HttpServletRequest request,
			ModelMap mod, ModelMap model) throws Exception {
		
		LogAuditoriaController logAuditoria = new LogAuditoriaController();
		LogAuditoria objeto = new LogAuditoria();
		Date fecha = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {

			AppEspBitacora AppEsp = new AppEspBitacora();
			int ID = 0;


				AppEsp.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaE")));
				
				AppEsp.setIdBitacoraEventos(Integer.parseInt(request.getParameter("idBitacoraEventos")));

				AppEsp.setDescripcionEvento(request.getParameter("descripcionEvento"));
				
				/* ID USUARIO */
				userID.setMatricula(request.getParameter("idUsuarioE"));
				listausuario = usuarioDAO.getInstancia().retornaID(userID);
				Iterator<usuario> list = listausuario.iterator();
				while (list.hasNext()) {
					usuario iuserID = list.next();
					ID = iuserID.getIdusuario();
				}
					
				
				AppEsp.setUsuarioCreacion(ID);
				
				AppEsp.setEstadoEvento(request.getParameter("estadoEvento"));

				AppEspBitacoraDAO.getInstancia().actualizarEvento(AppEsp);
				
				model.addAttribute("mensajeBitacora","Se actualizó correctamente");
				
				//Registro log de auditoría
				objeto.setPagina("actualizarBitacoraEventos.jsp");
				objeto.setObjeto("");
				objeto.setTraza_error("");
				objeto.setTipo("Acceso");
				objeto.setIp(logAuditoria.obtenerIP());
				objeto.setUsuario(request.getParameter("idUsuarioE"));
				objeto.setFecha(sdf.format(fecha));
				objeto.setHora(hourFormat.format(fecha));
				logAuditoria.guardarLogAuditoria(objeto);
		

		} catch (Exception ex) {
			model.addAttribute("mensajeBitacora", ex.getMessage());
			
			objeto.setPagina("actualizarBitacoraEventos.jsp");
			objeto.setObjeto("actualizaBitacoraEventos");
			objeto.setTraza_error(ex.getMessage());
			System.out.println("mostrar pagina:= " + ex.getMessage());
			objeto.setTipo("Error");
			objeto.setIp(logAuditoria.obtenerIP());
			objeto.setUsuario(request.getParameter("idUsuarioE"));
			objeto.setFecha(sdf.format(fecha));
			objeto.setHora(hourFormat.format(fecha));
			logAuditoria.guardarLogAuditoria(objeto);

		}
	
		return "registrarBitacoraEventos";

	}
	
	@RequestMapping(value = {"/elimina"}, method = RequestMethod.POST)
	public ModelAndView eliminaBitacoraEventos(HttpServletRequest request,ModelMap mod) throws Exception {

		

		AppEspBitacora AppEsp = new AppEspBitacora();
		int ID = 0;
		
		AppEsp.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaE")));

		AppEsp.setIdBitacoraEventos(Integer.parseInt(request.getParameter("IdBitacoraEventos")));
		
		/* ID USUARIO */
		userID.setMatricula(request.getParameter("idUsuarioE"));
		listausuario = usuarioDAO.getInstancia().retornaID(userID);
		Iterator<usuario> list = listausuario.iterator();
		while (list.hasNext()) {
			usuario iuserID = list.next();
			ID = iuserID.getIdusuario();
		}
			
		AppEsp.setUsuarioCreacion(ID);		
		
		AppEspBitacoraDAO.getInstancia().eliminarEvento(AppEsp);
		
		
		AppEsp.setMatriculaUsuario(request.getParameter("matriculaUsuario"));

		AppEsp.setEstadoEvento(request.getParameter("estadoEvento"));

		AppEsp.setFechaCreacionDesde(request.getParameter("fechaDesde"));

		AppEsp.setFechaCreacionHasta(request.getParameter("fechaHasta"));

		listaEvento = AppEspBitacoraDAO.getInstancia().consultaBitacoraEventos(AppEsp);
		
		message =  "Se eliminó correctamente.";
		
		
		ModelAndView model = new ModelAndView("Auxiliar/ListaBitacoraEventos");
		model.addObject("listaEvento", listaEvento);
		model.addObject("mensajeEvento", message);
	
		
		return model;

	}
}
