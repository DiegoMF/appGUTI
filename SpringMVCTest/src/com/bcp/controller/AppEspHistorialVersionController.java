package com.bcp.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.dao.AppEspHistorialVersionDAO;
import com.bcp.modelo.AppEspHistorialVersion;;

@Controller
@RequestMapping("/aplicacionEspecializadaHistorial")

public class AppEspHistorialVersionController {
	
	ArrayList<AppEspHistorialVersion> listaHistorial = new ArrayList<>();
	String message;
	
	@RequestMapping(value = "/ConsultaHistorialVersion", method = RequestMethod.POST)
	public ModelAndView ConsultaHistorialVersion(HttpServletRequest request,	ModelMap mod) throws Exception {
		System.out.print("entrar consulta");
		listaHistorial = new ArrayList<>();

		AppEspHistorialVersion HistorialVersion = new AppEspHistorialVersion();
		
		
		
			
		
			HistorialVersion.setIdAplicacionEspecializada(Integer.parseInt(request.getParameter("idAplicacionEspecializadaH")));
	
		HistorialVersion.setFechaCreacionDesde(request.getParameter("fechaDesde"));

		HistorialVersion.setFechaCreacionHasta(request.getParameter("fechaHasta"));

		listaHistorial = AppEspHistorialVersionDAO.getInstancia().ConsultaHistorialVersion(HistorialVersion);
			

		if (listaHistorial.size() == 0) {
			ModelAndView model = new ModelAndView("Auxiliar/ListaHistorialVersiones");
			message="No se encontraron registros.";
			model.addObject("mensajeInfo", message);
			return model;
		} else {

			ModelAndView model = new ModelAndView("Auxiliar/ListaHistorialVersiones");
			model.addObject("listaHistory", listaHistorial);
			return model;
		}


	}
}
