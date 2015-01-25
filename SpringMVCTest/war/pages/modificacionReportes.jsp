<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<jsp:include page="../masterpage/superior.jsp" />
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
<style>
.selecter {
	width: 200px;
	height: auto;
	margin: 0 0 50px 0;
	border: 1px solid #ccc;
	padding: 10px;
	border-radius: 10px 0 0 10px;
}

.diver {
	
	width: 50px;
	text-align: center
}

.celda {
	height: auto;
	width: 200px;
}


</style>
<div class="cabecera">
	<h2>.:: Registro de Reportes</h2>
	<hr>
</div>
<div class="formulario">
	<form action="<c:url value="/Reporte/modificarReporte" />" method="post" id="formulario">
	<input	type="hidden" id="tipo" name="tipo" value=1>
		<div>
			<table class="tablaDatos">
				<tr>
					
					<td><label>Nombre del Reporte.:</label></td>
						<td><input type="text" name="nombreReporte" id="nombreReporte" style="width: 400px;" value="${listaReporte.nombreReporte}" maxlength="100" required></td>
						<td><label>Estado.:</label></td>
						<td><select name="estado" id="estado" required>
						<option value="">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
						<td><label>Fecha de creación.:</label></td>
						<td><input type="text" style="width:100px; "  name="fechaCreacion"  id="fechaCreacion"  value="${listaReporte.fechaCreacion}"	class="tcal" required ></td>
						<td><label>Usuario de Creación.:</label></td>
						<td><input type="text" name="matricula" maxlength="50" id="matricula" value="${listaReporte.matricula}" disabled="disabled" /></td>
					
					
					
					
					
					
					
				</tr>
			</table>
		</div>
		<hr>
		<div>
			<table width="100%" height="auto" border="0" cellspacing="0"	cellpadding="0">
				<tr>
					<td >
						<fieldset>
							<legend >Filtros del Reporte</legend>
							<table >
								<tr>
									<td >
									<select id="pantallas" name="D3" onchange="ListarFiltro($(this)); return false;">
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
											<select name="filtroDestino" id="filtroDestino" multiple="multiple" size="8" class="filtro" style="min-width: 300px; min-height: 400px;" required>
												<c:forEach var="listValue" items="${datosReporteFiltro}">
													<option value="${listValue.idReporteFiltro}">${listValue.nombreColumna}</option>


												</c:forEach>
											</select>
										</div>
									</td>
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
			
		</div>
		
		<div ><br>
		<table class="tablaBotones">
				<tr>
					<td align="right">
					<input type="submit" name="grabar" value="Grabar"></input>
					<input type="submit" name="regresar" value="Regresar"></input>
					</td>
				</tr>
			</table>
			
			<br>
		</div>
	</form>
</div>
<jsp:include page="../masterpage/inferior.jsp" />