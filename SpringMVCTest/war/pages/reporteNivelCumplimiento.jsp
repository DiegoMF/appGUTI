<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<jsp:include page="../masterpage/superior.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.validate.js"></script>
<script src="/js/canvasjs.min.js"  type="text/javascript"></script>

<script type="text/javascript">
window.onload = function () {
	//var nLineamiento = document.getElementById("nCumplimientoLineamientoTotal").value;
	//var noCumpleLineamiento = (100-nLineamiento);
	//alert(nLineamiento);

	var chart = new CanvasJS.Chart("chartContainerLineamientos",
	{
		title:{
			text: "Nivel de cumplimiento - Lineamientos",
			fontFamily: "Lucida Grande",
			fontSize:15
			
		},
                animationEnabled: true,
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
				{  y: 10,indexLabel:  "10 %", name: "Cumple", legendMarkerType: "square"},
				{  y: 90,indexLabel:  + "90 %", name: "No cumple", legendMarkerType: "square"},
				
			]
		}
		]
	});
	chart.render();
	
	
	
	
	//var nameValue = document.getElementById("nCumplimientoTotal").value;
	//var noCumpleEstandar = (100- nameValue);
	//alert(nameValue);

	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Nivel de cumplimiento - Estándares Tecnológicos",
			fontFamily: "Lucida Grande",
			fontSize:15
			
		},
                animationEnabled: true,
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
				{  y: 15,indexLabel:  "15%", name: "Cumple", legendMarkerType: "square"},
				{  y: 75,indexLabel: "75%", name: "No cumple", legendMarkerType: "square"},
				
			]
		}
		]
	});
	chart.render();
	
	
	
	//var nGeneral = document.getElementById("nCumplimientoGeneral").value;
	//var noCumpleGeneral= (100-nGeneral);
		
	//alert(nGeneral);

	var chart = new CanvasJS.Chart("chartContainerGeneral",
	{
		title:{
			text: "Nivel de cumplimiento General",
			fontFamily: "Lucida Grande",
			fontSize:15
			
		},
                animationEnabled: true,
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
				{  y: 90,indexLabel:   "90%", name: "Cumple", legendMarkerType: "square"},
				{  y: 10,indexLabel:   "10%", name: "No cumple", legendMarkerType: "square"},
				
			]
		}
		]
	});
	chart.render();
}
</script>
	
<body>
<div class="formulario">
				<div class="cabecera">
					<h2>.:: Reporte Nivel de Cumplimiento</h2>
					<hr>
				</div>

	<form action=""  method="post" id="formulario">
				<table class="tablaDatos">
					<tr>
						<td><label>Gerencia Central.:</label></td>
						<td><select name="idGerenciaCentral" id="idGerenciaCentral">
						<option value="">Seleccione</option>
							<c:forEach items="${gerencia}" var="gerenciaCentral">
						<option
								value="<c:out value="${gerenciaCentral.idGerenciaCentral}" />">
						<c:out
								value="${gerenciaCentral.descripcionGerenciaCentral}" /></option>
						</c:forEach>
						</select></td>
						<td><label>Estado.:</label></td>
						<td><select name="idEstadoAplicacion" id="idEstadoAplicacion">
						<option value="">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
						<td><label>División.:</label></td>
						<td><select name="idDivision" id="idDivision">
						<option value="">Seleccione</option>
												<c:forEach items="${division}" var="division">
													<option value="<c:out value="${division.idDivision}" />"><c:out
															value="${division.descripcionDivision}" /></option>
												</c:forEach>
						</select></td>
						<td><label>Criticidad.:</label></td>
						<td><select name="idCriticidad">
						<option value="">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
					
					</tr>
					<tr>
						<td><label>Area.:</label></td>
						<td><select name="idArea" id="idArea">
						<option value="">Seleccione</option>
												<c:forEach items="${area}" var="area">
													<option value="<c:out value="${area.idArea}" />"><c:out
															value="${area.descripcionArea}" /></option>
						</c:forEach>
						</select></td>
						<td><label>Código de la Aplicación.:</label></td>
						<td><input type="text" name="codigoAplicacionEspecializada" id="codigoAplicacionEspecializada" style="width: 400px; "></td>
						<td><label>Unidad.:</label></td>
						<td><select name="idUnidad" id="idUnidad">
						<option value="">Seleccione</option>
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
						<tr>
								<td>
									<fieldset >
										<legend align="left">Graficos</legend>
										<table>
											<tr>
												<td>
												</td>
												<td>
													<div id="chartContainer" style="height: 300px; width: 100%;"></div>
												</td>
												<td>
												</td>
												<td>
												</td>
												<td>
													<div id="chartContainerGeneral" style="height: 300px; width: 100%;"></div>
												</td>
												<td>
												</td>
												<td>
												</td>
												<td>
													<div id="chartContainerLineamientos" style="height: 300px; width: 100%;"></div>
												</td>
												<td>
												</td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
						<tr><td colspan="5"><a style="color: red">${mensajeInfo}</a></td></tr>
					</table>
				</div>
				</form>
			</div>
</body>
</html>
<jsp:include page="../masterpage/inferior.jsp" />




















