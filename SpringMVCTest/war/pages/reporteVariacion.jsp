<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="../masterpage/superior.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.validate.js"></script>
<script src="/js/canvasjs.min.js"  type="text/javascript"></script>

<script type="text/javascript">



function buscar() {
	
	var cadena = "";
	var cantidad = 0;
	$("#filtroDestino option").each(function(index){cantidad++;});
	$("#filtroDestino option").each(function(index){   
		
		if (index < cantidad - 1){
			cadena = cadena +('SELECT 0 as idConsulta_filtro, c.idConsulta_Columna, 0 as idConsulta, c.Descripcion, c.Tabla, c.Foraneo,c.TablaSeccion,c.ColumnaForanea,c.DescripcionForanea FROM consulta_columna c WHERE c.idConsulta_Columna = '+ $(this).val() +' UNION ');	
		}
		else{
			cadena = cadena +('SELECT 0 as idConsulta_filtro, c.idConsulta_Columna, 0 as idConsulta, c.Descripcion, c.Tabla, c.Foraneo,c.TablaSeccion,c.ColumnaForanea,c.DescripcionForanea FROM consulta_columna c WHERE c.idConsulta_Columna = '+ $(this).val() +';');
		}
		
	});
	

	var url = "/Reporte/GenerarFiltroReporte";
	var data = {"consulta":cadena};
	
    $.post(url,data, function(resultado){  
        $("#divFiltro").html(resultado);
    });
	

}

function buscargrafico(){
	
	var url = "/Reporte/generarReporteVariacion";
	var data = $("#reporteNivelCumplimiento").serialize();
	$("#reporteNivelCumplimiento").attr("action", url);
    $.post(url,data, function(resultado){  
        $("#divGraficoReporte").html(resultado);

        var chart = new CanvasJS.Chart("chartContainer",
        		{

        			
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
			$('.agregar').click(
					function() {
						return !$('#fOrigen option:selected').remove().appendTo('#filtroDestino');});
			$('.quitar').click(
					function() {
						$('#filtroDestino option:selected').remove();
						$('#filtroDestino option').prop('selected', 'selected');
						ListarFiltro2()
						;
						return ;});
			$('.agregarC').click(						
					function() {							
						return !$('#cOrigen option:selected').remove().appendTo('#columnaDestino');});
			$('.quitarC').click(
					function() {
						$('#columnaDestino option:selected').remove();
						$('#columnaDestino option').prop('selected', 'selected');
						ListarColumna()
						;
						return ;});
						
			$('.submit').click(function() {
				$('#destino option').prop('selected', 'selected');
			});
		});

function ListarFiltro2() {
	var data = $("#formulario").serialize();
	var url = "/Reporte/listaFiltro2";
	$.post(url, data, function(resultado) {	$("#divListaFiltro").html(resultado);});
}
</script>
<script>
function ListarFiltro() {
	var data = $("#formulario").serialize();
	var url = "/Reporte/listaFiltro";
	$.post(url, data, function(resultado) {	$("#divListaFiltro").html(resultado);});
}
	function ListarColumna() {
		var data = $("#formulario").serialize();
		var url = "/Reporte/listaColumna";
		$.post(url,data,  function(resultado) {	$("#divListaColumna").html(resultado);});
	}


</script>
	
<body>
<div class="formulario">
				<div class="cabecera">
					<h2>.:: Reporte de Variación </h2>
					<hr>
				</div>

	<form action="<c:url value="/Reporte/generarReporteVariacion"/>"  method="POST" id="formulario">
					
				<table class="tablaDatos" width="100%">
					<tr>
					<td width="40%">
						<fieldset width="100%">
							<legend >Base del Reporte</legend>
							<table width="100%">
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
					<td width="20%">
						<fieldset width="100%">
							<legend >Rango de Tiempo</legend>
							<table width="100%">
								<tr>
									<td>Periodo:</td>
									<td ><select id="periodo" name="periodo" onchange="Periodo(); return false;">
											<option value="0">Seleccione</option>
											<option value="1">Anual</option>
											<option value="2">Semestral</option>
											<option value="3">Trimestral</option>
											<option value="4">Mensual</option>
										
									</select></td>
				
								</tr>
								
							</table>
						</fieldset>
					</td>
					<td width="40%">
						<fieldset>
							<legend >Criterios de Agrupación</legend>
							<table  >
								<tr>
									<td ><select id="comboColumna" name="comboColumna" onchange="ListarColumna(); return false;">
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
										<div id="divListaColumna">
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
									<div id="divListaColumnaSeleccionado">
									<select name="columnaDestino" id="columnaDestino" multiple="multiple" size="8" class="filtro" style="min-width: 300px; min-height: 400px;"></select>
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
						<td><input	type="button" value="Buscar" onclick="buscar(); return false;" />
						 <input type="button" value="Regresar" 	onclick="nuevo(); return false;" />
						 <input type="reset" name="limpiar" value="Limpiar"></input></td>
					</tr>
				</table>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<table width="100%">
					<tr>
						<td width="25%" id="divFiltro"></td>
						<td width="75%" id="divGraficoReporte"></td>
					</tr>
				</table>
					<table  border="1" width="100%" class="tablaGrilla">
					
						<tr><td colspan="5"><a style="color: red">${mensajeInfo}</a></td></tr>
					</table>
				</div>
				</form>
			</div>
			
			
			
			
			
</body>

<jsp:include page="../masterpage/inferior.jsp" />




















