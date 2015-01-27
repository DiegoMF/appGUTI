<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="../masterpage/superior.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.validate.js"></script>
<script src="/js/canvasjs.min.js"  type="text/javascript"></script>

<script type="text/javascript">



function buscar() {
	
	
	var url = "/Reporte/buscarReporteNivelCumplimiento";
	var data = $("#reporteNivelCumplimiento").serialize();
	$("#reporteNivelCumplimiento").attr("action", url);
    $.post(url,data, function(resultado){  
        $("#divGraficoReporte").html(resultado);

        
        var nLineamiento = document.getElementById("nCumplimientoLineamientoTotal").value;
    	var noCumpleLineamiento = (100-nLineamiento);
    	//alert(nLineamiento);

    	var chart = new CanvasJS.Chart("chartContainerLineamientos",
    	{
    		
    		legend: {
    			verticalAlign: "bottom",
    			horizontalAlign: "center"
    		},
    		theme: "theme2",
    		width: 320,
    		height: 300,
    		data: [
    		{        
    			type: "pie",
    			indexLabelFontFamily: "Garamond",       
    			indexLabelFontSize: 20,
    			indexLabelFontWeight: "bold",
    			startAngle:0,
    			indexLabelFontColor: "MistyRose",       
    			indexLabelLineColor: "darkgrey", 
    			indexLabelPlacement: "inside", 
    			toolTipContent: "{name}: {y}%",
    			showInLegend: true,			
    			dataPoints: [
    				{  y: nLineamiento,indexLabel: nLineamiento + "%", name: "Cumple", legendMarkerType: "square"},
    				{  y: noCumpleLineamiento,indexLabel: noCumpleLineamiento + "%", name: "No cumple", legendMarkerType: "square"},
    				
    			]
    		}
    		]
    	});
    	chart.render();
    	
    	
    	
    	
    	var nameValue = document.getElementById("nCumplimientoTotal").value;
    	var noCumpleEstandar = (100- nameValue);
    	//alert(nameValue);

    	var chart = new CanvasJS.Chart("chartContainer",
    	{
    		
    		legend: {
    			verticalAlign: "bottom",
    			horizontalAlign: "center"
    		},
    		theme: "theme2",
    		width: 320,
    		height: 300,
    		data: [
    		{        
    			type: "pie",
    			indexLabelFontFamily: "Garamond",       
    			indexLabelFontSize: 20,
    			indexLabelFontWeight: "bold",
    			startAngle:0,
    			indexLabelFontColor: "MistyRose",       
    			indexLabelLineColor: "darkgrey", 
    			indexLabelPlacement: "inside", 
    			toolTipContent: "{name}: {y}%",
    			showInLegend: true,			
    			dataPoints: [
    				{  y: nameValue,indexLabel: nameValue + "%", name: "Cumple", legendMarkerType: "square"},
    				{  y: noCumpleEstandar,indexLabel: noCumpleEstandar + "%", name: "No cumple", legendMarkerType: "square"},
    				
    			]
    		}
    		]
    	});
    	chart.render();
    	
    	
    	
    	var nGeneral = document.getElementById("nCumplimientoGeneral").value;
    	var noCumpleGeneral= (100-nGeneral);
    		
    	//alert(nGeneral);

    	var chart = new CanvasJS.Chart("chartContainerGeneral",
    	{
    		
    		legend: {
    			verticalAlign: "bottom",
    			horizontalAlign: "center"
    		},
    		theme: "theme2",
    		width: 320,
    		height: 300,
    		data: [
    		{        
    			type: "pie",
    			indexLabelFontFamily: "Garamond",       
    			indexLabelFontSize: 20,
    			indexLabelFontWeight: "bold",
    			startAngle:0,
    			indexLabelFontColor: "MistyRose",       
    			indexLabelLineColor: "darkgrey", 
    			indexLabelPlacement: "inside", 
    			toolTipContent: "{name}: {y}%",
    			showInLegend: true,			
    			dataPoints: [
    				{  y: nGeneral,indexLabel: nGeneral + "%", name: "Cumple", legendMarkerType: "square"},
    				{  y: noCumpleGeneral,indexLabel: noCumpleGeneral + "%", name: "No cumple", legendMarkerType: "square"},
    				
    			]
    		}
    		]
    	});
    	chart.render();
        
        
        
        
        
        
        
        
    });  
	
	
	          


}



</script>
	
<body>
<div class="formulario">
				<div class="cabecera">
					<h2>.:: Reporte Nivel de Cumplimiento</h2>
					<hr>
				</div>

	<form action="<c:url value="/Reporte/buscarReporteNivelCumplimiento"/>"  method="POST" id="reporteNivelCumplimiento">
					
				<table class="tablaDatos">
					<tr>
						<td><label>Gerencia Central.:</label></td>
						<td><select name="idGerenciaCentral" id="idGerenciaCentral">
						<option value="0">Seleccione</option>
							<c:forEach items="${gerencia}" var="gerenciaCentral">
						<option
								value="<c:out value="${gerenciaCentral.idGerenciaCentral}" />">
						<c:out
								value="${gerenciaCentral.descripcionGerenciaCentral}" /></option>
						</c:forEach>
						</select></td>
						<td><label>Estado.:</label></td>
						<td><select name="idEstadoAplicacion" id="idEstadoAplicacion">
						<option value="0">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
						<td><label>División.:</label></td>
						<td><select name="idDivision" id="idDivision">
						<option value="0">Seleccione</option>
												<c:forEach items="${division}" var="division">
													<option value="<c:out value="${division.idDivision}" />"><c:out
															value="${division.descripcionDivision}" /></option>
												</c:forEach>
						</select></td>
						<td><label>Criticidad.:</label></td>
						<td><select name="idCriticidad">
						<option value="0">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
					
					</tr>
					<tr>
						<td><label>Area.:</label></td>
						<td><select name="idArea" id="idArea">
						<option value="0">Seleccione</option>
												<c:forEach items="${area}" var="area">
													<option value="<c:out value="${area.idArea}" />"><c:out
															value="${area.descripcionArea}" /></option>
						</c:forEach>
						</select></td>
						<td><label>Código de la Aplicación.:</label></td>
						<td><input type="text" name="codigoAplicacionEspecializada" id="codigoAplicacionEspecializada" style="width: 400px; "></td>
						<td><label>Unidad.:</label></td>
						<td><select name="idUnidad" id="idUnidad">
						<option value="0">Seleccione</option>
												<c:forEach items="${unidad}" var="unidad">
													<option value="<c:out value="${unidad.idUnidad}" />"><c:out
															value="${unidad.descripcionUnidad}" /></option>
												</c:forEach>
						</select></td>
					
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




















