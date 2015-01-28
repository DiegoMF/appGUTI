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
import com.bcp.modelo.dto.AplicacionEspecializadaDTO;
import com.bcp.modelo.dto.ConsultaGeneralAplicacionesDTO;
import com.bcp.dao.*;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("ListaFiltroSesion")
@RequestMapping("/Reporte")
public class ReporteController {

	String message;
	ArrayList<Consulta> listaReporte;
	
	@RequestMapping(value = { "/Load" }, method = RequestMethod.GET)
	public ModelAndView load(HttpServletRequest request, ModelMap mod)
			throws Exception {

		ArrayList<Consulta_Seccion> lista = Consulta_SeccionDAO.getInstancia().buscar();
		ModelAndView model = new ModelAndView("creacionReportes");
		model.addObject("reporteSeccionLista", lista);
		

		return model;

	}
	
	@RequestMapping(value="/buscarReporte", method = RequestMethod.POST)
	public ModelAndView buscarReporte(@ModelAttribute("Datos") Consulta reporte) throws Exception {
		System.out.println("llega al controlador");

		listaReporte = new ArrayList<>();
		listaReporte =  ConsultaDAO.getInstancia().buscarReporte(reporte);
		System.out.println("llega al controlador");

		ModelAndView modelo = new ModelAndView("Auxiliar/ListaReporte");
		
		modelo.addObject("listaReporte", listaReporte);
		return modelo;
	}
	
	
	
	@RequestMapping(value="/verReporte", method = RequestMethod.POST)
	public ModelAndView modificarReporte(HttpServletRequest request, ModelMap mod, HttpSession sesion) throws Exception{
		
		Consulta datosGeneralesReporte;
		ArrayList<ConsultaFiltro> datosReporteFiltro;
		ArrayList<ConsultaColumnaColumna> datosReporteAgrupacion;
		
		ModelAndView modelo = new ModelAndView("modificacionReportes");
		
		//Carga de datos generales
		datosGeneralesReporte = new Consulta();
		Consulta miReporte= new Consulta();
		miReporte.setIdReporte(Integer.parseInt(request.getParameter("idReporte1")));
		datosGeneralesReporte= ConsultaDAO.getInstancia().obtenerReportePorId(miReporte);
		
		
		//Carga de listas desplegables
		ArrayList<Consulta_Seccion> lista = Consulta_SeccionDAO.getInstancia().buscar();
	
		//Carga de filtros
		
		datosReporteFiltro = new ArrayList<>();
		datosReporteFiltro = ConsultaFiltroDAO.getInstancia().obtenerFiltrosPorIdReporte(miReporte);
		
		
		//Carga de agrupaciones
		datosReporteAgrupacion = new ArrayList<>();
		datosReporteAgrupacion = ConsultaColumnaColumnaDAO.getInstancia().obtenerAgrupacionporIdReporte(miReporte);
		
		
		/*ArrayList<String> listaFiltros = new ArrayList<String>();
		
	
		
		for (int i=0;i<datosReporteFiltro.size(); i++){
			System.out.println("cantidad " + datosReporteFiltro.size());
			datosReporteFiltro.get(i).getIdReporteFiltro();
			System.out.println("dato " + datosReporteFiltro.get(i).getIdReporteFiltro());
			
			listaFiltros.add(String.valueOf(datosReporteFiltro.get(i).getIdReporteFiltro()));
			//listaFiltros.set(datosReporteFiltro.get(i).getIdReporteFiltro());
			//listaFiltros.add();
			//System.out.println("dato " + datosReporteFiltro.get(i).getNombreColumna().toString());
		
		}
		
		System.out.println("dato " + datosReporteFiltro.size());
		System.out.println("valo 11 " + listaFiltros.get(1));
		System.out.println("tamaño lista string " + listaFiltros.size());
		
		for (int i=0;i<listaFiltros.size(); i++){
			miReporte.setFiltroDestino(listaFiltros);
	
					
		
		}
		
		System.out.println("tamaño lista string (11) " + miReporte.getFiltroDestino().get(1));
		
	*/

		modelo.addObject("listaReporte", datosGeneralesReporte);
		modelo.addObject("reporteSeccionLista", lista);
		modelo.addObject("datosReporteFiltro",datosReporteFiltro);
		modelo.addObject("datosReporteAgrupacion",datosReporteAgrupacion);
		
	//	modelo.addObject("miReporte",miReporte);
		
		return modelo;
	}
	
	
	@RequestMapping(value="/modificarReporte", method = RequestMethod.POST)
	public ModelAndView modificarConsultaForm(@ModelAttribute("listaReporte") Consulta consulta,HttpServletRequest request) throws Exception {
		System.out.println("llega al controlador de grabar reporte");
		int id_consulta = 0;
		ModelAndView modelo = new ModelAndView("creacionReportes");
	
		Consulta objeto = new Consulta();
	
		ArrayList<String> listaColumnas = new ArrayList<String>();
		
		ArrayList<String> listaFiltros = new ArrayList<String>();
		
		try
		{
			
		if 	(consulta.getColumnaDestino() != null && consulta.getFiltroDestino() != null){
		
		listaColumnas = consulta.getColumnaDestino();
		System.out.println("columna destino" + consulta.getColumnaDestino());
		listaFiltros = consulta.getFiltroDestino();
		System.out.println("6");
		
		System.out.println("lista filtro cantidad" + listaFiltros.size());
		System.out.println("lista agrupacion cantidad" + listaColumnas.size());

		
			
		//if 	(listaFiltros.size()!=0 || listaColumnas.size()!=0){
			System.out.println("7");
		
		
		id_consulta = Consulta_ColumnaDAO.getInstancia().modificarConsultaReporte(consulta);
		System.out.println("modificar consulta");
		
		for (int i=0;i<listaFiltros.size(); i++){
			System.out.println("9"+listaFiltros.size());
			objeto.setIdConsulta(id_consulta);
			objeto.setIdConsultaFiltro(Integer.parseInt(listaFiltros.get(i)));
			Consulta_ColumnaDAO.getInstancia().ingresarFiltro(objeto);
			System.out.println("inserto filtro");
		
		}
	
		for (int i=0;i<listaColumnas.size(); i++){
			System.out.println("10"+listaColumnas.size());

			objeto.setIdConsulta(id_consulta);
			objeto.setIdConsultaColumna(Integer.parseInt(listaColumnas.get(i)));
			Consulta_ColumnaDAO.getInstancia().ingresarColumna(objeto);
			System.out.println("inserto columna");
		
		}
		
		System.out.println("se registró correctamente");

		message="Se registró correctamente";

		
		modelo.addObject("mesajeInfo", message);
		
		}else {
			System.out.println("Ingresar valores");
		}
		
		} catch (SQLException ex) {
			//model.addAttribute("mensaje", ex.getMessage());
				modelo.addObject("mensaje", ex.getMessage());
				
		}
		
		return modelo;
	}
	
	
	
	
	@RequestMapping(value = { "/BuscarFiltro" }, method = RequestMethod.POST)
	public ModelAndView BuscarFiltro(HttpServletRequest request, ModelMap mod, HttpSession sesion)
			throws Exception {
		System.out.println("llega al buscar filtro reporte");

		ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia().buscar(Integer.parseInt(request.getParameter("idConsulta_Seccion")));
		
		ModelAndView model = new ModelAndView("Auxiliar/ListaReporteFiltro");
		model.addObject("listaReporteFiltro", lista);

		return model;
		
	}
	
	
	@RequestMapping(value = { "/BuscarAgrupacion" }, method = RequestMethod.POST)
	public ModelAndView BuscarAgrupacion(HttpServletRequest request, ModelMap mod, HttpSession sesion)
			throws Exception {
				
		ArrayList<Consulta_Columna> lista = Consulta_ColumnaDAO.getInstancia().buscar(Integer.parseInt(request.getParameter("idConsulta_Seccion")));
		
		ModelAndView model = new ModelAndView("Auxiliar/ListaReporteAgrupacion");
		model.addObject("listaReporteAgrupacion", lista);

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

	}*/

	@RequestMapping(value="/grabarReporte", method = RequestMethod.POST)
	public ModelAndView submitConsultaForm(@ModelAttribute("listaReporte") Consulta consulta,HttpServletRequest request) throws Exception {
		System.out.println("llega al controlador de grabar reporte");
		int id_consulta = 0;
		ModelAndView modelo = new ModelAndView("creacionReportes");
	
		Consulta objeto = new Consulta();
	
		ArrayList<String> listaColumnas = new ArrayList<String>();
		
		ArrayList<String> listaFiltros = new ArrayList<String>();
		
		try
		{
			
		if 	(consulta.getColumnaDestino() != null && consulta.getFiltroDestino() != null){
		
		listaColumnas = consulta.getColumnaDestino();
		System.out.println("columna destino" + consulta.getColumnaDestino());
		listaFiltros = consulta.getFiltroDestino();
		System.out.println("6");
		
		System.out.println("lista filtro cantidad" + listaFiltros.size());
		System.out.println("lista agrupacion cantidad" + listaColumnas.size());

		
			
		//if 	(listaFiltros.size()!=0 || listaColumnas.size()!=0){
			System.out.println("7");
		
		
		id_consulta = Consulta_ColumnaDAO.getInstancia().ingresarConsultaReporte(consulta);
		System.out.println("8");
		
		for (int i=0;i<listaFiltros.size(); i++){
			System.out.println("9");
			objeto.setIdConsulta(id_consulta);
			objeto.setIdConsultaFiltro(Integer.parseInt(listaFiltros.get(i)));
			Consulta_ColumnaDAO.getInstancia().ingresarFiltro(objeto);
		
		}
	
		for (int i=0;i<listaColumnas.size(); i++){
			
			objeto.setIdConsulta(id_consulta);
			objeto.setIdConsultaColumna(Integer.parseInt(listaColumnas.get(i)));
			Consulta_ColumnaDAO.getInstancia().ingresarColumna(objeto);
		
		}
	
		message="Se registró correctamente";
		
		
		modelo.addObject("mesajeInfo", message);
		
		}else {
			System.out.println("Ingresar valores");
		}
		
		} catch (SQLException ex) {
			//model.addAttribute("mensaje", ex.getMessage());
				modelo.addObject("mensaje", ex.getMessage());
				
		}
		
		return modelo;
	}
	

	
	@RequestMapping(value = { "/loadCumplimiento" }, method = RequestMethod.GET)
	public ModelAndView loadReporteNivelCumplimiento(HttpServletRequest request, ModelMap mod) throws Exception {
	
		ArrayList<GerenciaCentral> gerencia;
		ArrayList<Unidad> unidad;
		ArrayList<Division> division;
		ArrayList<Area> area;
		ArrayList<EstadoAplicacion> estado;
		ArrayList<CriticidadFinal> criticidadfinal;
		
		System.out.println("Entra al load");
		gerencia = new ArrayList<>();
		gerencia = GerenciaCentralDAO.getInstancia().obtenerGerenciaCentral();
		unidad = new ArrayList<>();
		unidad = UnidadDAO.getInstancia().obtenerUnidad();
		division = new ArrayList<>();
		division = DivisionDAO.getInstancia().obtenerDivision();
		area = new ArrayList<>();
		area = AreaDAO.getInstancia().obtenerArea();
		
		estado = new ArrayList<>();
		estado = EstadoAplicacionDAO.getInstancia().obtenerEstadoAplicacion();
		
		criticidadfinal = new ArrayList<>();
		criticidadfinal = CriticidadFinalDAO.getInstancia().obtenerCriticidadFinal();
		
		
		
		System.out.println("Antes de llamar a la vista");
		ModelAndView model = new ModelAndView("reporteNivelCumplimiento");
		System.out.println("Despues de llamar a la vista");
		
		model.addObject("gerencia", gerencia);
		model.addObject("unidad", unidad);
		model.addObject("division", division);
		model.addObject("area", area);
		model.addObject("estado", estado);
		model.addObject("criticidadfinal", criticidadfinal);

		return model;
	}
	
	
	@RequestMapping(value = { "/buscarReporteNivelCumplimiento" }, method = RequestMethod.POST)
	public ModelAndView getAplicaciones(HttpServletRequest request, ModelMap mod)
			throws Exception {

		AplicacionEspecializadaDTO listaFiltros = new AplicacionEspecializadaDTO();

		AplicacionEspecializadaDTO filtros = new AplicacionEspecializadaDTO();
		
		filtros.setIdGerenciaCentral(Integer.parseInt(request.getParameter("idGerenciaCentral")));
		filtros.setIdDivision(Integer.parseInt(request.getParameter("idDivision")));
		filtros.setIdEstadoAplicacion(Integer.parseInt(request.getParameter("idEstadoAplicacion")));
		filtros.setIdCriticidadFinal(Integer.parseInt(request.getParameter("idCriticidadFinal")));
		filtros.setIdArea(Integer.parseInt(request.getParameter("idArea")));
		filtros.setIdUnidad(Integer.parseInt(request.getParameter("idUnidad")));
		filtros.setCodigoAplicacionEspecializada(request.getParameter("codigoAplicacionEspecializada"));
	
		listaFiltros = ReporteDAO.getInstancia().obtenerReporteNivelCumplimiento(filtros);
		
		ModelAndView model = new ModelAndView("Auxiliar/GraficoNivelCumplimiento");
	
		model.addObject("listaFiltros", listaFiltros);
		
		return model;
		
		

	}

	
	@RequestMapping(value = { "/generarReporteVariacion" }, method = RequestMethod.POST)
	public ModelAndView getReporteVariacion(HttpServletRequest request, ModelMap mod)
			throws Exception {

		AplicacionEspecializadaDTO listaFiltros = new AplicacionEspecializadaDTO();

		AplicacionEspecializadaDTO filtros = new AplicacionEspecializadaDTO();
		
		/*filtros.setIdGerenciaCentral(Integer.parseInt(request.getParameter("idGerenciaCentral")));
		filtros.setIdDivision(Integer.parseInt(request.getParameter("idDivision")));
		filtros.setIdEstadoAplicacion(Integer.parseInt(request.getParameter("idEstadoAplicacion")));
		filtros.setIdCriticidadFinal(Integer.parseInt(request.getParameter("idCriticidadFinal")));
		filtros.setIdArea(Integer.parseInt(request.getParameter("idArea")));
		filtros.setIdUnidad(Integer.parseInt(request.getParameter("idUnidad")));
		filtros.setCodigoAplicacionEspecializada(request.getParameter("codigoAplicacionEspecializada"));
	
		listaFiltros = ReporteDAO.getInstancia().obtenerReporteNivelCumplimiento(filtros);*/
		
		ModelAndView model = new ModelAndView("Auxiliar/GraficoReporteVariacion");
	
		model.addObject("listaFiltros", listaFiltros);
		
		return model;
		
		

	}
	
	


	
	@RequestMapping(value = { "/LoadReporteVariacion" }, method = RequestMethod.GET)
	public ModelAndView loadReporteVariacion(HttpServletRequest request, ModelMap mod)
			throws Exception {

		ArrayList<Consulta_Seccion> lista = Consulta_SeccionDAO.getInstancia().buscar();
		ModelAndView model = new ModelAndView("reporteVariacion");
		model.addObject("reporteSeccionLista", lista);
		

		return model;

	}
	
}
