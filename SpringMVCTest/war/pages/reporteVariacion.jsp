<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="../masterpage/superior.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.validate.js"></script>
<script src="/js/canvasjs.min.js"  type="text/javascript"></script>

<script type="text/javascript">



function buscar() {
	
	
	var url = "/Reporte/generarReporteVariacion";
	var data = $("#reporteNivelCumplimiento").serialize();
	$("#reporteNivelCumplimiento").attr("action", url);
    $.post(url,data, function(resultado){  
        $("#divGraficoReporte").html(resultado);

        var chart = new CanvasJS.Chart("chartContainer",
        		{

        			title:{
        				text: "Site Traffic",
        				fontSize: 30
        			},
                                animationEnabled: true,
        			axisX:{

        				gridColor: "Silver",
        				tickColor: "silver",
        				valueFormatString: "DD/MMM"

        			},                        
                                toolTip:{
                                  shared:true
                                },
        			theme: "theme2",
        			axisY: {
        				gridColor: "Silver",
        				tickColor: "silver"
        			},
        			legend:{
        				verticalAlign: "center",
        				horizontalAlign: "right"
        			},
        			data: [
        			{        
        				type: "line",
        				showInLegend: true,
        				lineThickness: 2,
        				name: "Visits",
        				markerType: "square",
        				color: "#F08080",
        				dataPoints: [
        				{ x: new Date(2010,0,3), y: 650 },
        				{ x: new Date(2010,0,5), y: 700 },
        				{ x: new Date(2010,0,7), y: 710 },
        				{ x: new Date(2010,0,9), y: 658 },
        				{ x: new Date(2010,0,11), y: 734 },
        				{ x: new Date(2010,0,13), y: 963 },
        				{ x: new Date(2010,0,15), y: 847 },
        				{ x: new Date(2010,0,17), y: 853 },
        				{ x: new Date(2010,0,19), y: 869 },
        				{ x: new Date(2010,0,21), y: 943 },
        				{ x: new Date(2010,0,23), y: 970 }
        				]
        			},
        			{        
        				type: "line",
        				showInLegend: true,
        				name: "Unique Visits",
        				color: "#20B2AA",
        				lineThickness: 2,

        				dataPoints: [
        				{ x: new Date(2010,0,3), y: 510 },
        				{ x: new Date(2010,0,5), y: 560 },
        				{ x: new Date(2010,0,7), y: 540 },
        				{ x: new Date(2010,0,9), y: 558 },
        				{ x: new Date(2010,0,11), y: 544 },
        				{ x: new Date(2010,0,13), y: 693 },
        				{ x: new Date(2010,0,15), y: 657 },
        				{ x: new Date(2010,0,17), y: 663 },
        				{ x: new Date(2010,0,19), y: 639 },
        				{ x: new Date(2010,0,21), y: 673 },
        				{ x: new Date(2010,0,23), y: 660 }
        				]
        			}

        			
        			],
                  legend:{
                    cursor:"pointer",
                    itemclick:function(e){
                      if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                      	e.dataSeries.visible = false;
                      }
                      else{
                        e.dataSeries.visible = true;
                      }
                      chart.render();
                    }
                  }
        		});

        chart.render();
      

    
        
        
        
        
        
        
        
        
    });  
	
	
	          


}



</script>

<script>
	$().ready(
			function() {
				
				
				$('#estado > option[value="${listaReporte.estado}"]').attr('selected', 'selected');
				
				$('.agregar').click(
						function() {
							return !$('#fOrigen option:selected').remove().appendTo('#filtroDestino');});
				$('.quitar').click(
						function() {
							return !$('#filtroDestino option:selected').remove().appendTo('#fOrigen');});

				$('.agregarC').click(
						function() {
							return !$('#cOrigen option:selected').remove().appendTo('#columnaDestino');});
				$('.quitarC').click(
						function() {
							return !$('#columnaDestino option:selected').remove().appendTo('#cOrigen');});

				$('.submit').click(function() {
					$('#destino option').prop('selected', 'selected');
				});
			});
</script>
<script>
	function ListarAgrupacion(combo) {

		var idConsulta_Seccion = combo.val();
		var url = "/Reporte/BuscarAgrupacion";
		var data = {"idConsulta_Seccion" : idConsulta_Seccion};
		$.post(url, data, function(resultado) {	$("#divListaAgrupacion").html(resultado);});

	}

	function ListarFiltro(combo) {

		var idConsulta_Seccion = combo.val();
		var url = "/Reporte/BuscarFiltro";
		var data = {"idConsulta_Seccion" : idConsulta_Seccion};	
		$.post(url, data, function(resultado) {	$("#divListaFiltro").html(resultado);});

	}


</script>
	
<body>
<div class="formulario">
				<div class="cabecera">
					<h2>.:: Reporte Nivel de Cumplimiento</h2>
					<hr>
				</div>

	<form action="<c:url value="/Reporte/generarReporteVariacion"/>"  method="POST" id="reporteNivelCumplimiento">
					
				<table class="tablaDatos">
					<tr>
					<td >
						<fieldset>
							<legend >Base del Reporte</legend>
							<table >
								<tr>
									<td >
									<select id="comboFiltro" name="comboFiltro" onchange="ListarFiltro($(this)); return false;">
											<option value="">Seleccione</option>
											<c:forEach var="listValue" items="${reporteSeccionLista}">
												<option value="${listValue.idConsulta_Seccion}">${listValue.descripcion}</option>
											</c:forEach>
									</select>
								</td>
									<td >&nbsp;</td>
									<td ><label>Filtros.:</label></td>
								</tr>
								<tr>
									<td style="min-width: 300px; ">
										<div id="divListaFiltro">
											<select name="fOrigen" id="fOrigen"	multiple="multiple" class="filtro" style="min-width: 300px; min-height: 400px;"></select>
										</div>
									</td>
									<td >
										<div class="diver">
											<input type="button" class="agregar izq" value="&raquo;&raquo;"><br> <input	type="button" class="quitar der" value="&laquo;&laquo;">
										</div>
									</td>
									<td style="min-width: 300px; ">
										<div id="divListaFiltroSeleccionado">
											<select name="filtroDestino" id="filtroDestino" multiple="multiple" size="8" class="filtro" style="min-width: 300px; min-height: 400px;"></select>
										</div>
									</td>
								</tr>
							</table>
						</fieldset>

					</td>
					<td>
						<fieldset>
							<legend >Rango de Tiempo</legend>
							<table  >
								<tr>
									<td>Periodo:</td>
									<td ><select id="comboColumna" name="comboColumna" onchange="ListaAgrupacion(); return false;">
											<option value="">Seleccione</option>
											<c:forEach var="listValue" items="${listaReporteFiltro}">
												<option value="${listValue.idConsulta_Columna}">${listValue.Descripcion}</option>
											</c:forEach>
									</select></td>
				
								</tr>
								
							</table>
						</fieldset>
					</td>
					<td>
						<fieldset>
							<legend >Criterios de Agrupación</legend>
							<table  >
								<tr>
									<td ><select id="pantallas" name="D3" onchange="ListarAgrupacion($(this)); return false;">
											<option value="">Seleccione</option>
											<c:forEach var="listValue" items="${reporteSeccionLista}">
												<option value="${listValue.idConsulta_Seccion}">${listValue.descripcion}</option>
											</c:forEach>
									</select></td>
									<td >&nbsp;</td>
									<td ><label>Agrupaciones.:</label></td>
								</tr>
								<tr>
									<td style="min-width: 300px; ">
										<div id="divListaAgrupacion">
											<select name="cOrigen" id="cOrigen" multiple="multiple" class="filtro" style="min-width: 300px; min-height: 400px;"></select>
										</div>
									</td>
									<td>
										<div class="">
											<input type="button" class="agregarC izq" value="&raquo;&raquo;"><br> 
											<input type="button" class="quitarC der" value="&laquo;&laquo;">
										</div>
									</td>
									<td style="min-width: 300px; ">
									<div id="divListaAgrupacionSeleccionado">
									<select name="columnaDestino" id="columnaDestino" multiple="multiple" size="8" class="filtro" style="min-width: 300px; min-height: 400px;" required>
										<c:forEach var="listValue" items="${datosReporteAgrupacion}">
													<option value="${listValue.idConsultaColumnaColumna}">${listValue.nombreColumna}</option>


										</c:forEach>
									</select>
									</div>
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
					</tr>
				</table>
	
				<hr>
				&nbsp; &nbsp; &nbsp; &nbsp;

				<table class="tablaBotones">
					<tr>
						<td><input	type="button" value="Generar Reporte" onclick="buscar(); return false;" />
						 <input type="button" value="Regresar" 	onclick="nuevo(); return false;" />
						 <input type="reset" name="limpiar" value="Limpiar"></input></td>
					</tr>
				</table>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<div id="divGraficoReporte">
					<table  border="1" width="100%" class="tablaGrilla">
					
						<tr><td colspan="5"><a style="color: red">${mensajeInfo}</a></td></tr>
					</table>
				</div>
				</form>
			</div>
</body>

<jsp:include page="../masterpage/inferior.jsp" />




















