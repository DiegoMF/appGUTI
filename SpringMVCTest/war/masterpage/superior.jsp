<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />


<link href="/css/tabs.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery-1.11.1.min.js"></script>

<script src="/js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="/js/jquery-ui-1.10.0.custom.js"></script>

<script src="/js/tcal.js"></script>
<script src="/js/validarCampos.js"></script>

<link rel="stylesheet" href="/css/tcal.css" type="text/css" />
<link rel="stylesheet" href="/css/validationEngine.jquery.css"
	type="text/css" />
<link href="/css/menu.css" rel="stylesheet" type="text/css" />
<link href="/css/layout.css" rel="stylesheet" type="text/css" />
<link href="/css/estiloGeneral.css" rel="stylesheet" type="text/css" />
<link href="/css/custom-theme/jquery-ui-1.10.0.custom.css"
	rel="stylesheet" type="text/css" />

<title>Gesti&oacute;n de Portafolios para Aplicaciones GUTI</title>

<style type="text/css">

.pg-normal {
	color: #0000FF;
	font-weight: normal;
	text-decoration: none;
	cursor: pointer;
}

.pg-selected {
	color: #800080;
	font-weight: bold;
	text-decoration: underline;
	cursor: pointer;
}
</style>

<script type="text/javascript">
function Pager(tableName, itemsPerPage) {
    this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;
     
    this.showRecords = function(from, to) {        
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 1; i < rows.length; i++) {
            if (i < from || i > to)  
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    }
     
    this.showPage = function(pageNumber) {
     if (! this.inited) {
      alert("not inited");
      return;
     }
 
        var oldPageAnchor = document.getElementById('pg'+this.currentPage);
        oldPageAnchor.className = 'pg-normal';
         
        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage);
        newPageAnchor.className = 'pg-selected';
         
        var from = (pageNumber - 1) * itemsPerPage + 1;
        var to = from + itemsPerPage - 1;
        this.showRecords(from, to);
    }   
     
    this.prev = function() {
        if (this.currentPage > 1)
            this.showPage(this.currentPage - 1);
    }
     
    this.next = function() {
        if (this.currentPage < this.pages) {
            this.showPage(this.currentPage + 1);
        }
    }                        
     
    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length - 1); 
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    }
 
    this.showPageNav = function(pagerName, positionId) {
     if (! this.inited) {
      alert("not inited");
      return;
     }
     var element = document.getElementById(positionId);
      
     var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal"> « Anterior </span> | ';
        for (var page = 1; page <= this.pages; page++) 
            pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';
        pagerHtml += '<span onclick="'+pagerName+'.next();" class="pg-normal"> Siguiente »</span>';            
         
        element.innerHTML = pagerHtml;
    }
}
</script>

<script>
	
	$(document).ready(function(){
		
		if ($("#SesionUsuario").text() == ""){
			
			//alert("no estas autenticado, alaos");
			location.href = "/pages/index.jsp";			
		}
		else{}
		
	});
	
	
</script>

</head>
<body>





	<div id="head" align="center">
		<table class="tablageneral">
			<tr>
				<td class="logo"><img alt="logo" src="/images/logo.png" /></td>
				<td class="titulo"><a> Gestión de Portafolio de
						Aplicaciones GUTI </a></td>
				<td class="usuario">
					<table class="usuario">
						<tr>
							<td><input type="hidden" id="usuarioActual"
								name="usuarioActual" value="${sesionusuario}"></td>
							<td>Usuario.: <a id="SesionUsuario"
								style="text-transform: uppercase;">${sesionusuario}</a> | <a
								href="/inicio/SalirUsuario">Cerrar Sesión</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>

	</div>

	       <div id="menu" align="center" class="menu">
             <ul>
                    <li><a href="/pages/consultaGeneral.jsp">Consultas</a>
                          <ul>
                                 <li><a href="/pages/consultaGeneral.jsp">Consulta General</a></li>
                          </ul></li>
                    <li><a href="#">Gestión de Consultas</a>
                          <ul>
                                 <li><a href="/pages/bitacoraConsultas.jsp">Bitacora de
                                              Consultas</a></li>
                                 <li><a href="/Consulta/Load">Registro de Consultas</a></li>
                          </ul></li>
                    <li><a href="#">Gestión de Aplicaciones Especializadas</a>
                          <ul>
                                 <li><a href="/aplicacionEspecializada/load">Registro
                                              Aplicaciones Especializadas</a></li>
                          </ul></li>
                    <li><a href="#">Reportes</a>
                          <ul>
                                 <li><a href="/pages/listaReporteGeneral.jsp">Reporte
                                              General</a></li>
                                 <li><a href="/Reporte/loadCumplimiento">Reporte de Nivel de
                                              Cumplimiento</a></li>
                                 <li><a href="/Reporte/LoadReporteVariacion">Reporte de Variación</a></li>

                          </ul></li>
                    <li><a href="#">Gestión de Reportes</a></li>
                    <li><a href="#">Seguridad</a>
                          <ul>
                                 <li><a href="/pages/consultaUsuario.jsp">Consultas de
                                              Usuarios</a></li>
                                 <li><a href="/pages/mantenimientoUsuario.jsp">Mantenimiento
                                              de Usuarios</a></li>
                                 <li><a href="#">Configuración de Accesos</a></li>
                          </ul></li>
                    <!-- SUBIR EXCEL -->
                    <li><a href="/pages/importExcel/importExcel.jsp">Importar
                                 Excel</a></li>

             </ul>
       </div>

	