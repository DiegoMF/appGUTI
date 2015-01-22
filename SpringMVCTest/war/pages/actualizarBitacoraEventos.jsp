

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../masterpage/superior.jsp" />
<link href="/css/forms.css" rel="stylesheet" type="text/css" />
<link href="/css/layout.css" rel="stylesheet" type="text/css" />
<link href="/css/estiloGeneral.css" rel="stylesheet" type="text/css" />
<link href="/css/tables.css" rel="stylesheet" type="text/css" />
<script >
$(document)
.ready(
		function() {
			
$("#btnRegresar")
.click(
		function(e) {

			location.href = "/pages/consultaGeneral.jsp";
			e.preventDefault();
		});

});
</script>
    		<div class="formulario">
<div class="cabecera">
					<h2>.:: Modificar de Eventos</h2>
					<hr>
				</div>

			<form method="POST" action="<c:url value="/aplicacionEspecializadaBitacora/actualizarBitacoraEvento" />" >
				
	<input type="hidden" id="idAplicacionEspecializadaE" name ="idAplicacionEspecializadaE" value="${evento.idAplicacionEspecializada}" />
	<input type="hidden" id="idBitacoraEventos" name="idBitacoraEventos" value="${evento.idBitacoraEventos}" />
	<input	type="hidden" name="idUsuarioE" id="idUsuarioE"	value="${sesionusuario}" />
				<div>
				<fieldset>
						<legend align="left">Datos de la Aplicación</legend>
					<table class="tablaDatos">
						<tr>
					
							<td><label>Codigo Aplicación.:</label></td>
								<td>${evento.codigoAplicacionEspecializada}</td>

								<td><label>Nombre Aplicación.:</label></td>
								<td>${evento.nombreAplicacionNOIT}</td>
						
						</tr>
					</table>
</fieldset>
				</div>
			
				&nbsp;
				&nbsp;
				&nbsp;
				&nbsp;
				<div>

					<fieldset>
						<legend align="left">Datos del Evento</legend>
						<table>
							<tr>
								<td>Descripción del Evento.:</td> 
								<td><input type="text"  name="descripcionEvento" id="descripcionEvento"  value="${evento.descripcionEvento}"></td>
								<td>Estado.:</td> 
								<td><select name="estadoEvento" id="estadoEvento">
										
										<option value="1">Activo</option>
										<option value="2">Inactivo</option>
								</select>
								</td>
							</tr>
						
						</table>
					</fieldset>
				</div>
				&nbsp;
				&nbsp;
				&nbsp;
				&nbsp;
				<div>

					<table class="tablaBotones">
						<tr>
							<td><input type="submit" name="btnGrabar" value="Grabar"	id="btnGrabar" />
							<input type="reset" name="limpiar"		value="Limpiar" /> 
							<input type="button" name="btnRegresar"	value="Regresar" id="btnRegresar"/></td>
						</tr>
					</table>


				</div>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
				

			</form>
			<div>
			<a>${mensajeBitacora}</a>
			</div>
		</div>
  
<jsp:include page="../masterpage/inferior.jsp" />
