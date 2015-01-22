<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<jsp:include page="../masterpage/superior.jsp" />
<script>
	$().ready(
			function() {
				$('.agregar').click(
						function() {
							return !$('#fOrigen option:selected').remove().appendTo('#filtroDestino');});
				$('.quitar').click(
						function() {
							ListarFiltro2();
							return !$('#filtroDestino option:selected').remove();});	

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
	
	function ListarFiltro2() {
// 		var nLineamiento = document.getElementById("filtroDestino").value;
// 		alert(nLineamiento);
		var data = $("#formulario").serialize();
		var url = "/Consulta/listaFiltro2";
		$.post(url, data, function(resultado) {	$("#divListaFiltro").html(resultado);});

	}
</script>
<script>

function ListarFiltro() {

	var data = $("#formulario").serialize();
	var url = "/Consulta/listaFiltro";
	$.post(url, data, function(resultado) {	$("#divListaFiltro").html(resultado);});

}

	function ListarColumna() {

		var data = $("#formulario").serialize();
		var url = "/Consulta/listaColumna";
		$.post(url,data,  function(resultado) {	$("#divListaColumna").html(resultado);});

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
	<h2>.:: Registro de Consultas</h2>
	<hr>
</div>
<div class="formulario">
	<form action="<c:url value="/Consulta/grabarConsulta" />" method="post" id="formulario">
		<div>
			<table width="50%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="celda"><label style="text-align: right;">Nombre consulta.:&nbsp;</label></td>
					<td class="celda"><input type="text" id="nombreConsulta" name="nombreConsulta" size="60" /></td>
					<td class="celda"><label style="text-align: right;">Predeterminado.:&nbsp;</label></td>
					<td class="celda"><input id="predeterminado" name="predeterminado" type="checkbox" value="1" />Si</td>
					<td class="celda"><label style="text-align: right;">Estado.:&nbsp;</label></td>
					<td class="celda"><select name="estado"><option value="activo">Activo</option><option value="inactivo">Inactivo</option></select></td>
				</tr>
			</table>
		</div>
		<hr>
		<div>
			<table width="100%" height="auto" border="0" cellspacing="0"	cellpadding="0">
				<tr>
					<td >
						<fieldset>
							<legend >Filtros de Consulta</legend>
							<table >
								<tr>
									<td >
									<select id="comboFiltro" name="comboFiltro" onchange="ListarFiltro(); return false;">
											<option value="">Seleccione</option>
											<c:forEach var="listValue" items="${ListaConsulta_Seccion}">
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
							<legend >Columnas de Consulta</legend>
							<table  >
								<tr>
									<td ><select id="comboColumna" name="comboColumna" onchange="ListarColumna(); return false;">
											<option value="">Seleccione</option>
											<c:forEach var="listValue" items="${ListaConsulta_Seccion}">
												<option value="${listValue.idConsulta_Seccion}">${listValue.descripcion}</option>
											</c:forEach>
									</select></td>
									<td >&nbsp;</td>
									<td ><label>Columnas.:</label></td>
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