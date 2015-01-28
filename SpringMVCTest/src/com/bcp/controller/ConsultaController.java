package com.bcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bcp.modelo.*;
import com.bcp.dao.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("ListaFiltroSesion")
@RequestMapping("/Consulta")
public class ConsultaController {

	ArrayList<Consulta> listaConsulta;
	String message;

	@RequestMapping(value = { "/Load" }, method = RequestMethod.POST)
	public ModelAndView load(HttpServletRequest request, ModelMap mod)
			throws Exception {

		ArrayList<Consulta_Seccion> lista = Consulta_SeccionDAO.getInstancia().buscar();
		
		ModelAndView model = new ModelAndView("creacionConsultas");
		model.addObject("ListaConsulta_Seccion", lista);

		return model;

	}
	
	@RequestMapping(value = { "/Nuevo" }, method = RequestMethod.GET)
	public ModelAndView nuevo(HttpServletRequest request, ModelMap mod)
			throws Exception {

		ArrayList<Consulta_Seccion> lista = Consulta_SeccionDAO.getInstancia().buscar();
		ModelAndView model = new ModelAndView("creacionConsultas");
		model.addObject("ListaConsulta_Seccion", lista);

		return model;

	}

	@RequestMapping(value = "/listaFiltro", method = RequestMethod.POST)
	public ModelAndView listarFiltro(@ModelAttribute("listaConsulta") Consulta consulta)
			throws Exception {

		ArrayList<Consulta_Columna> listaDestino = null;

		if (consulta.getComboFiltro() != null
				&& consulta.getComboFiltro().compareTo("") != 0) {
			ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO
					.getInstancia().buscar(
							Integer.parseInt(consulta.getComboFiltro()));

			if (consulta.getFiltroDestino() != null) {
				if (consulta.getFiltroDestino().size() != 0) {
					listaDestino = new ArrayList<Consulta_Columna>();
					listaDestino.addAll(lista);

					for (Consulta_Columna cltLista : lista) {
						for (int i = 0; i < consulta.getFiltroDestino().size(); i++) {
							int value = Integer.parseInt(consulta
									.getFiltroDestino().get(i));

							if (cltLista.getIdConsulta_Columna() == value) {
								listaDestino.remove(cltLista);
								break;
							}
						}
					}
				} else {
					listaDestino = new ArrayList<Consulta_Columna>();
					listaDestino.addAll(lista);
				}
			} else {
				listaDestino = new ArrayList<Consulta_Columna>();
				listaDestino.addAll(lista);
			}

		} else {
			listaDestino = new ArrayList<Consulta_Columna>();
		}

		ModelAndView modelo = new ModelAndView("Auxiliar/ListaConsulta_Filtro");
		modelo.addObject("ListaConsulta_Filtro", listaDestino);

		return modelo;
	}

	@RequestMapping(value = "/listaFiltro2", method = RequestMethod.POST)
	public ModelAndView listarFiltro2(
			@ModelAttribute("listaConsulta") Consulta consulta)
			throws Exception {

		ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia()
				.buscar(Integer.parseInt(consulta.getComboFiltro()));

		ArrayList<Consulta_Columna> listaDestino = null;

		if (consulta.getFiltroDestino() != null) {
			if (consulta.getFiltroDestino().size() != 0) {
				listaDestino = new ArrayList<Consulta_Columna>();
				listaDestino.addAll(lista);

				for (Consulta_Columna cltLista : lista) {
					for (int i = 0; i < consulta.getFiltroDestino().size(); i++) {
						int value = Integer.parseInt(consulta
								.getFiltroDestino().get(i));

						if (cltLista.getIdConsulta_Columna() == value) {
							listaDestino.remove(cltLista);
							break;
						}
					}
				}
			} else {
				listaDestino = new ArrayList<Consulta_Columna>();
				listaDestino.addAll(lista);
			}
		} else {
			listaDestino = new ArrayList<Consulta_Columna>();
			listaDestino.addAll(lista);
		}

		ModelAndView modelo = new ModelAndView("Auxiliar/ListaConsulta_Filtro");
		modelo.addObject("ListaConsulta_Filtro", listaDestino);

		return modelo;
	}

	@RequestMapping(value = "/listaColumna", method = RequestMethod.POST)
	public ModelAndView listarColumnas(
			@ModelAttribute("listaConsulta") Consulta consulta)
			throws Exception {

		ArrayList<Consulta_Columna> listaDestino = null;

		if (consulta.getComboFiltro() != null
				&& consulta.getComboFiltro().compareTo("") != 0) {
			ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia().buscar(Integer.parseInt(consulta.getComboColumna()));

			if (consulta.getColumnaDestino() != null) {
				if (consulta.getColumnaDestino().size() != 0) {
					listaDestino = new ArrayList<Consulta_Columna>();
					listaDestino.addAll(lista);

					for (Consulta_Columna cltLista : lista) {
						for (int i = 0; i < consulta.getColumnaDestino().size(); i++) {
							int value = Integer.parseInt(consulta
									.getColumnaDestino().get(i));

							if (cltLista.getIdConsulta_Columna() == value) {
								listaDestino.remove(cltLista);
								break;
							}
						}
					}
				} else {
					listaDestino = new ArrayList<Consulta_Columna>();
					listaDestino.addAll(lista);
				}
			} else {
				listaDestino = new ArrayList<Consulta_Columna>();
				listaDestino.addAll(lista);
			}

		} else {
			listaDestino = new ArrayList<Consulta_Columna>();
		}

		ModelAndView modelo = new ModelAndView("Auxiliar/ListaConsulta_Columna");
		modelo.addObject("ListaConsulta_Columna", listaDestino);

		return modelo;
	}

	@RequestMapping(value = { "/BuscarColumna" }, method = RequestMethod.POST)
	public ModelAndView BuscarColumna(HttpServletRequest request, ModelMap mod)
			throws Exception {

		ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia()
				.buscar(Integer.parseInt(request
						.getParameter("idConsulta_Seccion")));
		ArrayList<Consulta_Columna> listaOrigen = new ArrayList<Consulta_Columna>();
		ArrayList<Consulta_Columna> listaDestino = new ArrayList<Consulta_Columna>();
		String datos = request.getParameter("filtroDestino");

		char[] aCaracteres = datos.toCharArray();

		ModelAndView model = new ModelAndView("Auxiliar/ListaConsulta_Columna");
		model.addObject("ListaConsulta_Columna", listaOrigen);

		return model;

	}

	@RequestMapping(value = { "/BuscarFiltro" }, method = RequestMethod.POST)
	public ModelAndView BuscarFiltro(HttpServletRequest request, ModelMap mod,
			HttpSession sesion) throws Exception {

		ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia()
				.buscar(Integer.parseInt(request
						.getParameter("idConsulta_Seccion")));

		ModelAndView model = new ModelAndView("Auxiliar/ListaConsulta_Filtro");
		model.addObject("ListaConsulta_Filtro", lista);

		return model;

	}

	@RequestMapping(value = { "/AgregarColumna" }, method = RequestMethod.POST)
	public ModelAndView AgregarColumna(HttpServletRequest request,
			ModelMap mod, HttpSession sesion) throws Exception {

		Consulta_Columna filtro = new Consulta_Columna();
		filtro.setIdConsulta_Columna(Integer.parseInt(request
				.getParameter("idConsulta_Seccion")));
		filtro.setDescripcion(request.getParameter("Descripcion"));

		ArrayList<Consulta_Columna> ListaConsulta_Columna = new ArrayList<>();

		if (sesion.getAttribute("ListaFiltroSesion") != null) {
			ListaConsulta_Columna = (ArrayList<Consulta_Columna>) sesion
					.getAttribute("ListaFiltroSesion");
		}

		ListaConsulta_Columna.add(filtro);
		sesion.setAttribute("ListaFiltroSesion", ListaConsulta_Columna);
		ModelAndView model = new ModelAndView("Auxiliar/ListaConsulta_Columna");
		model.addObject("ListaConsulta_Columna", ListaConsulta_Columna);
		return model;

	}

	@RequestMapping(value = "/grabarConsulta", method = RequestMethod.POST)
	public ModelAndView submitConsultaForm(	@ModelAttribute("listaConsulta") Consulta consulta)	throws Exception {

		int idConsulta = 0;

		if(consulta.getFiltroDestino().size() > 0 &&consulta.getColumnaDestino().size() > 0 )
		{
			idConsulta = Consulta_ColumnaDAO.getInstancia().ingresarConsulta(consulta);
			consulta.setIdConsulta(idConsulta);	
			Consulta_ColumnaDAO.getInstancia().ingresarFiltro(consulta);
			Consulta_ColumnaDAO.getInstancia().ingresarColumna(consulta);
		}
		else
		{
			
			ArrayList<Consulta_Seccion> lista = Consulta_SeccionDAO.getInstancia().buscar();
			message = "Debe ingresar al menos un filtro o una columna.";
			
			ModelAndView model = new ModelAndView("creacionConsultas");
			model.addObject("ListaConsulta_Seccion", lista);
			model.addObject("mensajeInfo", message);
			return model;
		}
		
		ModelAndView modelo = new ModelAndView("creacionConsultas");
		message = "Consulta registrada correctamente.";
		modelo.addObject("mensajeInfo", message);
		return modelo;
	}

	@RequestMapping(value = "/buscarConsulta", method = RequestMethod.POST)
	public ModelAndView buscarConsulta(
			@ModelAttribute("Datos") Consulta consulta) throws Exception {

		listaConsulta = new ArrayList<>();
		listaConsulta = Consulta_ColumnaDAO.getInstancia().buscarConsulta(consulta);

		
		if(listaConsulta.size() < 1)
		{
			
			
		ModelAndView modelo = new ModelAndView("Auxiliar/ListaConsulta");
		message = "No se encontró registros.";
		modelo.addObject("mensajeInfo", message);
		return modelo;
		}
		else
		{
		ModelAndView modelo = new ModelAndView("Auxiliar/ListaConsulta");

		modelo.addObject("listaConsulta", listaConsulta);
		return modelo;
		}
	
	}

	@RequestMapping(value = "/modificarConsulta", method = RequestMethod.POST)
	public ModelAndView modificarConsulta(
			@ModelAttribute("Consulta") Consulta consulta) throws Exception {

		Consulta objConsulta = new Consulta();

		ModelAndView modelo = new ModelAndView("creacionConsultas");

		modelo.addObject("listaConsulta", listaConsulta);
		return modelo;
	}


	@RequestMapping(value = { "/ConsultaGeneral" })
	public ModelAndView ConsultaGeneral(HttpServletRequest request, ModelMap mod)
			throws Exception {

		int consulta = ConsultaDAO.getInstancia().ObtenerConsultaPredeterminada();

		if (request.getParameter("valor") != null) {
			consulta = Integer.parseInt(request.getParameter("valor"));
		}

		ArrayList<ConsultaFiltro> lista = ConsultaFiltroDAO.getInstancia()
				.obtener(consulta);
		String html = "<table>";

		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i).isForaneo()) {

				html = html
						+ "<tr><td>"
						+ lista.get(i).getDescripcion().toString()
						+ ": </td><td><select name=\""
						+ lista.get(i).getColumnaForanea().toString()
						+ "\">"
						+ ConsultaFiltroDAO.getInstancia().listarcombos(
								"select "
										+ lista.get(i).getColumnaForanea()
												.toString()
										+ ","
										+ lista.get(i).getDescripcionForanea()
												.toString() + " from "
										+ lista.get(i).getTabla().toString())
						+ "</select></td></tr>";

			} else {

				html = html + "<tr><td>"
						+ lista.get(i).getDescripcion().toString()
						+ ": </td><td><input type=\"text\" name=\""
						+ lista.get(i).getColumnaForanea().toString()
						+ "\" /></td></tr>";

			}

		}

		html = html
				+ "<tr style=\"background-color: #C0C0C0\"><td><input	type=\"button\" value=\"Buscar\" onclick=\"buscar(); return false;\" /></td><td><input type= \"reset\" name=\"limpiar\" value= \"Limpiar\"></td></tr></table>";

		ArrayList<ConsultaColumnaColumna> listacolumna = ConsultaColumnaColumnaDAO
				.getInstancia().obtener(consulta);

		String consulta2 = "select ";

		for (int i = 0; i < listacolumna.size(); i++) {

			if (listacolumna.get(i).getDescripcionResultado() != ""
					&& listacolumna.get(i).getDescripcionResultado() != null) {

				consulta2 = consulta2
						+ listacolumna.get(i).getDescripcionResultado()
								.toString() + ",";
			}
		}

		consulta2 = consulta2.substring(0, consulta2.length() - 1)
				+ " from d_aplicacion_especializada";

		String html2 = ConsultaFiltroDAO.getInstancia().listarResultado(
				consulta2);
		// String html2 = "";

		ModelAndView model = new ModelAndView("consultaGeneral");
		model.addObject("filtro", html);
		model.addObject("resultado", html2);

		return model;

	}

	@RequestMapping(value = { "/BuscarConsultaGeneral" })
	public ModelAndView BuscarConsultaGeneral(HttpServletRequest request,
			ModelMap mod) throws Exception {

		int consulta = ConsultaDAO.getInstancia().ObtenerConsultaPredeterminada();

		ArrayList<ConsultaFiltro> lista = new ArrayList<ConsultaFiltro>();

		Map m = request.getParameterMap();
		Set s = m.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();
			String key = entry.getKey();
			String[] value = entry.getValue();
			ConsultaFiltro entidad = new ConsultaFiltro();
			entidad.setDescripcionForanea(key);
			System.out.println("Key is " + key + "<br>");
			if (value.length > 1) {
				for (int i = 0; i < value.length; i++) {
					
					System.out.println("<li>" + value[i].toString() + "</li><br>");
				}
			} else
				entidad.setValor(value[0].toString());
				System.out.println("Value is " + value[0].toString() + "<br>");
			System.out.println("-------------------<br>");
			lista.add(entidad);
		}

		ArrayList<ConsultaColumnaColumna> listacolumna = ConsultaColumnaColumnaDAO
				.getInstancia().obtener(consulta);

		String consulta2 = "select ";

		for (int i = 0; i < listacolumna.size(); i++) {

			if (listacolumna.get(i).getDescripcionResultado() != ""
					&& listacolumna.get(i).getDescripcionResultado() != null) {

				consulta2 = consulta2
						+ listacolumna.get(i).getDescripcionResultado()
								.toString() + ",";
			}
		}

		consulta2 = consulta2.substring(0, consulta2.length() - 1)	+ " from d_aplicacion_especializada" ;
		consulta2 = consulta2 + " where ";
		
		for (int i = 0; i < lista.size(); i++){
			
			
			consulta2 = consulta2 + lista.get(i).getDescripcionForanea() + " = " + lista.get(i).getValor();
			
			if (i < lista.size() -1 ){
			consulta2 = consulta2 + " and ";
			}
		}
		

		String html2 = ConsultaFiltroDAO.getInstancia().listarResultado(consulta2);
		// String html2 = "";

		ModelAndView model = new ModelAndView("Auxiliar/ListaConsultaResultado");
		model.addObject("resultado", html2);

		return model;

	}
}