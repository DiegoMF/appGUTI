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
@RequestMapping("/Reporte")
public class ReporteController {

	ArrayList<Reporte> listaReporte;
	
	@RequestMapping(value = { "/Load" }, method = RequestMethod.GET)
	public ModelAndView load(HttpServletRequest request, ModelMap mod)
			throws Exception {

		ArrayList<ReporteSeccion> lista = ReporteSeccionDAO.getInstancia().buscar();
		ModelAndView model = new ModelAndView("creacionReportes");
		model.addObject("reporteSeccionLista", lista);

		return model;

	}
	
	@RequestMapping(value="/buscarReporte", method = RequestMethod.POST)
	public ModelAndView buscarReporte(@ModelAttribute("Datos") Reporte reporte) throws Exception {
		System.out.println("llega al controlador");

		listaReporte = new ArrayList<>();
		listaReporte =  ReporteDAO.getInstancia().buscarReporte(reporte);
		System.out.println("llega al controlador");

		ModelAndView modelo = new ModelAndView("Auxiliar/ListaReporte");
		
		modelo.addObject("listaReporte", listaReporte);
		return modelo;
	}
	
	
	
	@RequestMapping(value="/modificarReporte", method = RequestMethod.POST)
	public ModelAndView modificarReporte(HttpServletRequest request, ModelMap mod, HttpSession sesion) throws Exception{
		
		Reporte datosGeneralesReporte;
		ArrayList<ReporteFiltro> datosReporteFiltro;
		
		ModelAndView modelo = new ModelAndView("creacionReportes");
		
		//Carga de datos generales
		datosGeneralesReporte = new Reporte();
		Reporte miReporte= new Reporte();
		miReporte.setIdReporte(Integer.parseInt(request.getParameter("idReporte1")));
		datosGeneralesReporte= ReporteDAO.getInstancia().obtenerReportePorId(miReporte);
		
		
		//Carga de listas desplegables
		ArrayList<ReporteSeccion> lista = ReporteSeccionDAO.getInstancia().buscar();
	
		//Carga de filtros
		
		datosReporteFiltro = new ArrayList<>();
		datosReporteFiltro = ReporteFiltroDAO.getInstancia().obtenerFiltrosPorIdReporte(miReporte);
		
		
		
		modelo.addObject("listaReporte", datosGeneralesReporte);
		modelo.addObject("reporteSeccionLista", lista);
		modelo.addObject("datosReporteFiltro",datosReporteFiltro);
		
		return modelo;
	}
	
	@RequestMapping(value = { "/BuscarFiltro" }, method = RequestMethod.POST)
	public ModelAndView BuscarFiltro(HttpServletRequest request, ModelMap mod, HttpSession sesion)
			throws Exception {
		System.out.println("llega al buscar filtro reporte");

		ArrayList<ReporteColumna> lista = ReporteColumnaDAO.getInstancia().buscar(Integer.parseInt(request.getParameter("idReporteSeccion")));
		
		ModelAndView model = new ModelAndView("Auxiliar/ListaReporteFiltro");
		model.addObject("listaReporteFiltro", lista);

		return model;

	}
	
	
	@RequestMapping(value = { "/BuscarAgrupacion" }, method = RequestMethod.POST)
	public ModelAndView BuscarAgrupacion(HttpServletRequest request, ModelMap mod, HttpSession sesion)
			throws Exception {
				
		ArrayList<ReporteColumna> lista = ReporteColumnaDAO.getInstancia().buscar(Integer.parseInt(request.getParameter("idReporteSeccion")));
		
		ModelAndView model = new ModelAndView("Auxiliar/ListaReporteAgrupacion");
		model.addObject("ListaReporteAgrupacion", lista);

		return model;

	}
	
	/*
	
	
	
	@RequestMapping(value = { "/BuscarFiltro" }, method = RequestMethod.POST)
	public ModelAndView BuscarFiltro(HttpServletRequest request, ModelMap mod, HttpSession sesion)
			throws Exception {
				
		ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia().buscar(Integer.parseInt(request.getParameter("idConsulta_Seccion")));
		
		ModelAndView model = new ModelAndView("Auxiliar/ListaConsulta_Filtro");
		model.addObject("ListaConsulta_Filtro", lista);

		return model;

	}
	
	@RequestMapping(value = { "/AgregarColumna" }, method = RequestMethod.POST)
	public ModelAndView AgregarColumna(HttpServletRequest request, ModelMap mod, HttpSession sesion) throws Exception {
				
		Consulta_Columna filtro = new Consulta_Columna();
		filtro.setIdConsulta_Columna(Integer.parseInt(request.getParameter("idConsulta_Seccion")));
		filtro.setDescripcion(request.getParameter("Descripcion"));	
		
		ArrayList<Consulta_Columna> ListaConsulta_Columna = new ArrayList<>();
		
		if (sesion.getAttribute("ListaFiltroSesion")!= null){
			ListaConsulta_Columna = (ArrayList<Consulta_Columna>)sesion.getAttribute("ListaFiltroSesion");
		}	
		
		ListaConsulta_Columna.add(filtro);
		sesion.setAttribute("ListaFiltroSesion", ListaConsulta_Columna);	
		ModelAndView model = new ModelAndView("Auxiliar/ListaConsulta_Columna");
		model.addObject("ListaConsulta_Columna", ListaConsulta_Columna);
		return model;

	}

	@RequestMapping(value="/grabarConsulta", method = RequestMethod.POST)
	public ModelAndView submitConsultaForm(@ModelAttribute("listaConsulta") Consulta consulta) throws Exception {
		
		int id_consulta = 0;
		
		
		id_consulta = Consulta_ColumnaDAO.getInstancia().ingresarConsulta(consulta);
		Consulta objeto = new Consulta();
		
		ArrayList<String> listaColumnas = new ArrayList<String>();
		ArrayList<String> listaFiltros = new ArrayList<String>();
		
		listaColumnas = consulta.getColumnaDestino();
		listaFiltros = consulta.getFiltroDestino();
		
	for (int i=0;i<listaFiltros.size(); i++){
			
			objeto.setId_consulta(id_consulta);
			objeto.setId_consulta_filtro(Integer.parseInt(listaFiltros.get(i)));
			Consulta_ColumnaDAO.getInstancia().ingresarFiltro(objeto);
		
		}
	
		for (int i=0;i<listaColumnas.size(); i++){
			
			objeto.setId_consulta(id_consulta);
			objeto.setId_consulta_columna(Integer.parseInt(listaColumnas.get(i)));
			Consulta_ColumnaDAO.getInstancia().ingresarColumna(objeto);
		
		}
	

	
		
		ModelAndView modelo = new ModelAndView("bitacoraConsultas");
		
		return modelo;
	}
	*/
	
	
	/*@RequestMapping(value="/modificarConsulta", method = RequestMethod.POST)
	public ModelAndView modificarConsulta(@ModelAttribute("Consulta") Consulta consulta) throws Exception{
		
		Consulta objConsulta = new Consulta();
		
		
		ModelAndView modelo = new ModelAndView("creacionConsultas");
		
		modelo.addObject("listaConsulta", listaConsulta);
		return modelo;
	}*/
}
