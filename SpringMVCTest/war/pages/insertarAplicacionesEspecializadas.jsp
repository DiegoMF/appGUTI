<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="../masterpage/superior.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.validate.js"></script>


<html>
<head>
<script>
	$(document).ready(function() {
		
		
		$("#frmAppEsp").validate();
		
						
						$('.pestana').hide().eq(0).show();
						$('.tabs li').click(function(e)
						{
							e.preventDefault();
							$('.pestana').hide();
							$('.tabs li').removeClass("selected");
							var id = $(this).find("a").attr("href");
							$(id).fadeToggle();
							$(this).addClass("selected");
						});

					});

	function cambiarSubDominio(combo){

		if (combo.val() == -1){
			$("#motivoCreacionAplicacionOtros").prop('disabled', false);
			
		}
		else{
			$("#motivoCreacionAplicacionOtros").prop('disabled', true);
			$("#motivoCreacionAplicacionOtros").val("");

		}
	}
	
	
	function activarCantidadUnidadesUtilizanAplicacion(combo){
		if( combo.val() == 1){
			//$("#nombreUnidad1").removeAttr('disabled');
			$("#nombreUnidad1").prop('disabled', false);
			$("#nombreUnidad2").prop('disabled', true);
			$("#nombreUnidad3").prop('disabled', true);
			//alert("selec 1");
		}
		if( combo.val() == 2){
			$("#nombreUnidad1").prop('disabled', false);
			$("#nombreUnidad2").prop('disabled', false);
			$("#nombreUnidad3").prop('disabled', true);
			//alert("selec 2");
		}
		if( combo.val() == 3){
			$("#nombreUnidad1").prop('disabled', false);
			$("#nombreUnidad2").prop('disabled', false);
			$("#nombreUnidad3").prop('disabled', false);
			//alert("selec 3");
		}
		if( combo.val() == 0){
			$("#nombreUnidad1").prop('disabled', true);
			$("#nombreUnidad2").prop('disabled', true);
			$("#nombreUnidad3").prop('disabled', true);
			//alert("selec 4");
		}
		
		
	}
	

	
	function cambiarMotivo(combo){

		if (combo.val() == -1){
			$("#motivoCreacionAplicacionOtros").prop('disabled', false);
			
		}
		else{
			$("#motivoCreacionAplicacionOtros").prop('disabled', true);
			$("#motivoCreacionAplicacionOtros").val("");

		}
	}
	
	function dominioTocaPC(combo){

		if (combo.val() == 1){
			$("#dominioProcesoClave").prop('disabled', false);
		
		}
		else{
			$("#dominioProcesoClave").prop('disabled', true);
			$("#dominioProcesoClave").val(0);
			$("#nombreProcesoClaveOtros").prop('disabled', true);
			$("#nombreProcesoClaveOtros").val("");

		}
	}
	
	function cambiarProcesoAuditoria(combo){
		
		if (combo.val() == -1){
			$("#procesoAuditoriaOtros").prop('disabled', false);
			
		}
		else{
			$("#procesoAuditoriaOtros").prop('disabled', true);
			$("#procesoAuditoriaOtros").val("");
		}
	}
	
	function cambiarDominioProcesoClave(combo){
		
		if (combo.val() == -1){
			
			$("#nombreProcesoClaveOtros").prop('disabled', false);
		}
		else{
			$("#nombreProcesoClaveOtros").prop('disabled', true);
			$("#nombreProcesoClaveOtros").val("");
		}
	}
	
	
	function cambiarCategoriaTecnologica(combo){
		
		if (combo.val() == -1){
			
			$("#categoriaTecnologicaOtros").prop('disabled', false);
		}
		else{
			$("#categoriaTecnologicaOtros").prop('disabled', true);
			$("#categoriaTecnologicaOtros").val("");
		}
	}
	
	function cambiarCategoriaTecnologica(combo){
		
		if (combo.val() == -1){
			
			$("#categoriaTecnologicaOtros").prop('disabled', false);
		}
		else{
			$("#categoriaTecnologicaOtros").prop('disabled', true);
			$("#categoriaTecnologicaOtros").val("");

		}
	}
	
	function cambiarAppNoIT(combo){
		
		if (combo.val() == -1){
			
			$("#ambienteAppNoIT").prop('disabled', false);
		}
		else{
			$("#ambienteAppNoIT").prop('disabled', true);
			$("#ambienteAppNoIT").val("");

		}
	}
	
	function cambiarMantenimientoAplicacion(combo){
		
		if (combo.val() == -1){
			
			$("#mantenimientoNombreProveedor").prop('disabled', false);
		}
		else{
			$("#mantenimientoNombreProveedor").prop('disabled', true);
			$("#mantenimientoNombreProveedor").val("");

		}
	}
	
	function cambiarSoporteAplicacion(combo){
		
		if (combo.val() == -1){
			
			$("#soporteNombrePorveedor").prop('disabled', false);
		}
		else{
			$("#soporteNombrePorveedor").prop('disabled', true);
			$("#soporteNombrePorveedor").val("");

		}
	}
	
	function cambiarAccesoAplicacion(combo){
		
		if (combo.val() == -1){
			
			$("#accesosNombreProveedor").prop('disabled', false);
		}
		else{
			$("#accesosNombreProveedor").prop('disabled', true);
			$("#accesosNombreProveedor").val("");

		}
	}
	
	function cambiarHerramientaExplotacion(combo){
		
		if (combo.val() == -1){
			$("#herramientaExplotacionDatosOtros").prop('disabled', false);
		}
		else{
			$("#herramientaExplotacionDatosOtros").prop('disabled', true);
			$("#herramientaExplotacionDatosOtros").val("");

		}
	}
	
	
	function impactoTocaPC(combo){

		if (combo.val() == 1){
			$("#impactoIndicarProcesoClave").prop('disabled', false);
		
		}
		else{
			$("#impactoIndicarProcesoClave").prop('disabled', true);
			$("#impactoIndicarProcesoClave").val(0);
			$("#otrosImpactoProcesoClave").prop('disabled', true);
			$("#otrosImpactoProcesoClave").val("");

		}
	}
	
	function cambiarImpactoPC(combo){
		
		if (combo.val() == -1){
			
			$("#otrosImpactoProcesoClave").prop('disabled', false);
		}
		else{
			$("#otrosImpactoProcesoClave").prop('disabled', true);
			$("#otrosImpactoProcesoClave").val("");

		}
	}


	function cambiarEstandarSistemaOperativo(combo){

		
		if (combo.val() == -1){
			
			$("#swBaseSistemaOperativoOtrosPRE").prop('disabled', false);
		}
		else{
			$("#swBaseSistemaOperativoOtrosPRE").prop('disabled', true);
			$("#swBaseSistemaOperativoOtrosPRE").val("");

		}
	}
	
	
	function cambiarEstandarHerramientaProgramacion(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseHerramientaProgramacionOtrosPRE").prop('disabled', false);
		}
		else{
			$("#swBaseHerramientaProgramacionOtrosPRE").prop('disabled', true);
			$("#swBaseHerramientaProgramacionOtrosPRE").val("");

		}
	}
	
	function cambiarEstandarLenguajeProgramacion(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseLenguajeProgramacionOtrosPRE").prop('disabled', false);
		}
		else{
			$("#swBaseLenguajeProgramacionOtrosPRE").prop('disabled', true);
			$("#swBaseLenguajeProgramacionOtrosPRE").val("");

		}
	}
	function cambiarEstandarGestorBaseDatos(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseGestorBDOtrosPRE").prop('disabled', false);
		}
		else{
			$("#swBaseGestorBDOtrosPRE").prop('disabled', true);
			$("#swBaseGestorBDOtrosPRE").val("");

		}
	}
	
	function cambiarEstandarFramework(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseFrameworkOtrosPRE").prop('disabled', false);
		}
		else{
			$("#swBaseFrameworkOtrosPRE").prop('disabled', true);
			$("#swBaseFrameworkOtrosPRE").val("");

		}
	}
	
	function cambiarEstandarSistemaOperativoPOST(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseSistemaOperativoOtrosPOST").prop('disabled', false);
		}
		else{
			$("#swBaseSistemaOperativoOtrosPOST").prop('disabled', true);
			$("#swBaseSistemaOperativoOtrosPOST").val("");

		}
	}
	
	
	function cambiarEstandarHerramientaProgramacionPOST(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseHerramientaProgramacionOtrosPOST").prop('disabled', false);
		}
		else{
			$("#swBaseHerramientaProgramacionOtrosPOST").prop('disabled', true);
			$("#swBaseHerramientaProgramacionOtrosPOST").val("");

		}
	}
	
	function cambiarEstandarLenguajeProgramacionPOST(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseLenguajeProgramacionOtrosPOST").prop('disabled', false);
		}
		else{
			$("#swBaseLenguajeProgramacionOtrosPOST").prop('disabled', true);
			$("#swBaseLenguajeProgramacionOtrosPOST").val("");

		}
	}
	function cambiarEstandarGestorBaseDatosPOST(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseGestorBDOtrosPOST").prop('disabled', false);
		}
		else{
			$("#swBaseGestorBDOtrosPOST").prop('disabled', true);
			$("#swBaseGestorBDOtrosPOST").val("");

		}
	}
	
	function cambiarEstandarFrameworkPOST(combo){
		
		if (combo.val() == -1){
			
			$("#swBaseFrameworkOtrosPOST").prop('disabled', false);
		}
		else{
			$("#swBaseFrameworkOtrosPOST").prop('disabled', true);
			$("#swBaseFrameworkOtrosPOST").val("");

		}
	}
	
	function ObtenerSubDominio(cbodominio){
		//alert(cbodominio.val());
		
		var url = "/aplicacionEspecializada/ObtenerSubDominio";
		var data = {"iddominio":cbodominio.val()}
		
		$.post(url, data, function(resultado){
			$("#divComboSubDominio").html(resultado);
		})
	}
	
</script>

<script>

function modificar(a){
	
	
	var data = $("#formevento").serialize();
	var url = "/aplicacionEspecializadaBitacora/load";
	
	$("#IdBitacoraEventos").val(a);
	
	$("#formevento").attr("action", url);
	$("#formevento").submit();
	
}



function nuevo() {

	
	var data = $("#formevento").serialize();
	var url = "/aplicacionEspecializadaBitacora/nuevo";
	
	$("#IdAplicacionEspecializada").val(${listValue.idAplicacionEspecializada});
	
	$("#formevento").attr("action", url);
	$("#formevento").submit();
	
	
}
		
		
		function buscar() {
			
			var url = "/aplicacionEspecializadaBitacora/consultaBitacoraEventos";
			var data = $("#formevento").serialize();
	        $.post(url,data, function(resultado){  
	            $("#divListaEvento").html(resultado);
	            
	        });  
		}

		function grabarA() {

			 if ($('#fechaCreacionAplicacion').val() === '') {
			        alert('Debe ingresar una fecha creación');
			    }
			    else {
			        
			   
			if ($("#frmAppEsp").validationEngine('validate')){
				
			var data = $("#frmAppEsp").serialize();
			var url = "/aplicacionEspecializada/ingresar";
			
						
			$("#frmAppEsp").attr("action", url);
			$("#frmAppEsp").submit();
			}
			    }
		}
		
		function eliminar(idAplicacionEspecializada){
		
			$( "#divEliminarUsuario" ).dialog({
	            height: 'auto',
	            modal: true,
	            buttons: {
	                "Continuar": function() {
	                	var url = "/aplicacionEspecializadaBitacora/elimina";
	                	var data = {"idAplicacionEspecializada":idAplicacionEspecializada};
	                	
	                	$.post(url,data, function(){  
	                		buscar();	        	            
	        	        });  
	                	
	                	$( this ).dialog( "close" );
	                	
	                },
	                "Cancelar": function() {
	                    $( this ).dialog( "close" );
	                }
	            }
	        });
			
					
		}
</script>

</head>
<body>



		<ul class="tabs">
			<li class="selected"><a href="#tabs-1">Información General</a></li>
			<li><a href="#tabs-2">Info. Técnica e Impacto</a></li>
			<li><a href="#tabs-3">Info. Roadmap</a></li>
			<li><a href="#tabs-4">Info. Preatención</a></li>
			<li><a href="#tabs-5">Info. Postatención</a></li>
			<li><a href="#tabs-6">Info. Adicional</a></li>

		</ul>
	
		<form method="POST"	action="<c:url value="/aplicacionEspecializada/ingresar" />" id="frmAppEsp">
		<input type="hidden" id="usuarioActual" name="usuarioActual" value="${sesionusuario}">
			<div class="pestana" id="tabs-1">
				<div class="formulario">
					<div class="cabecera">
						<h2>.:: Información General</h2>
						<hr>
					</div>
			
						<table style="width: 100%" class="tablaDatos">
							<tr>
								<td>
									<fieldset>
										<legend align="left">Estructura organizacional</legend>
										<table>
											<tr>
												<td>Gerencia central.:</td>
												<td><select name="gerenciaCentral"	 id="cbxGerenciaCentral" required>
														<option  value="">Seleccione</option>
														<c:forEach items="${gerencia}" var="gerenciaCentral">
															<option
																value="<c:out value="${gerenciaCentral.idGerenciaCentral}" />">
																<c:out	value="${gerenciaCentral.descripcionGerenciaCentral}" /></option>
														</c:forEach>
												</select></td>
												<td>Unidad.:</td>
												<td><select name="unidad" id="cbxUnidad" required>
														<option value="">Seleccione</option>
														<c:forEach items="${unidad}" var="unidad">
															<option value="<c:out value="${unidad.idUnidad}" />"><c:out
																	value="${unidad.descripcionUnidad}" /></option>
														</c:forEach>
												</select></td>
												<td>División.:</td>
												<td><select name="division" id="cbxDivision">
														<option value="">Seleccione</option>
														<c:forEach items="${division}" var="division">
															<option value="<c:out value="${division.idDivision}" />"><c:out
																	value="${division.descripcionDivision}" /></option>
														</c:forEach>
												</select></td>

												<td>Área.:</td>
												<td><select name="area" id="cbxArea">
														<option value="">Seleccione</option>
														<c:forEach items="${area}" var="area">
															<option value="<c:out value="${area.idArea}" />"><c:out
																	value="${area.descripcionArea}" /></option>
														</c:forEach>
												</select></td>
												
											</tr>

											<tr>

												<td>Código FNA.:</td>
												<td><input type="text" name="codigoFNA"
													value="${lista.codigoFNA}" maxlength="45"></td>
												<td>Código de aplicación.:</td>
												<td><input type="text" name="codigoAplicacion" 
													value="${lista.codigoAplicacionEspecializada}"
													maxlength="45" required/></td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>

											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Información general</legend>
										<table>

											<tr>
												<td>Nombre.:</td>
												<td><input type="text" name="nombreAplicacionNOIT" value="${listaInfo.nombreAplicacionNOIT}" maxlength="250" required></td>
												<td>Descripción.:</td>
												<td><input type="text" name="descripcionAplicacion" value="${listaInfo.descripcionAplicacion}" maxlength="2000" required></td>
												<td>Funcionalidades.:</td>
												<td><input type="text" name="funcionalidadesAplicacion"	value="${listaInfo.funcionalidadesAplicacion}"	maxlength="2000" required></td>
												<td>Fecha de creación.:</td>
												<td><input type="text" style="width:100px; "  name="fechaCreacionAplicacion"  id="fechaCreacionAplicacion"	class="tcal" value="${listaInfo.fechaCreacionAplicacion}" required></td>

											</tr>

											<tr>

												<td>Estado.:</td>
												<td><select id="estadoAplicacion" name="estadoAplicacion" required>
														<option value="">Seleccione</option>
														<c:forEach items="${estadoAplicacion}"
															var="estadoAplicacion">
															<option
																value="<c:out value="${estadoAplicacion.idEstadoAplicacion}" />"><c:out
																	value="${estadoAplicacion.descripcionEstadoAplicacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Motivo de creación.:</td>
												<td><select onchange="cambiarMotivo($(this));" 
													name="motivoCreacionAplicacion" id="motivoCreacionAplicacion" required>
														<option value="">Seleccione</option>
														<c:forEach items="${motivoCreacionAplicacion}"	var="motivo">
															<option
																value="<c:out value="${motivo.idMotivoCreacionAplicacion}" />">
																<c:out
																	value="${motivo.descripcionMotivoCreacionAplicacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="motivoCreacionAplicacionOtros"
													id="motivoCreacionAplicacionOtros"
													value="${listaInfo.motivoCreacionAplicacionOtros}"
													maxlength="2000" disabled=”disabled” /></td>
												<td>Cantidad de operaciones.:</td>
												<td><select name="cantidadOperaciones"	id="cbxCantidadOperaciones">
														<option value="">Seleccione</option>
														<c:forEach items="${cantidadOperaciones}" var="cantidad">
															<option	value="<c:out value="${cantidad.idCantidadOperaciones}" />"><c:out
																	value="${cantidad.descripcionCantidadOperaciones}" /></option>
														</c:forEach>
												</select></td>
											</tr>

											<tr>
												<td>N° de entidades internas.:</td>
												<td><input type="text" name="nroEntidadesInternas" onkeypress="SoloNumeros();"	style="width:100px; "		value="${listaInfo.nroEntidadesInternas}"></td>
												<td>Tipo de operaciones que procesa.:</td>
												<td><select name="tipoOperacionProceso"
													id="cbxTipoOperacionProceso">
														<option value="">Seleccione</option>
														<c:forEach items="${tipoOperacionProceso}" var="tipo">
															<option
																value="<c:out value="${tipo.idTipoOperacionProceso}" />"><c:out
																	value="${tipo.descripcionTipoOperacionProceso}" /></option>
														</c:forEach>
												</select></td>
												<td>Frecuencia de las operaciones que procesa.:</td>
												<td><select name="frecuenciaOperaciones" id="frecuenciaOperaciones">
														<option value="">Seleccione</option>
														<c:forEach items="${frecuenciaOperaciones}"
															var="frecuencia">
															<option
																value="<c:out value="${frecuencia.idFrecuenciaOperaciones}" />"><c:out
																	value="${frecuencia.descripcionFrecuenciaOperaciones}" /></option>
														</c:forEach>
												</select></td>
												
												<td>N° de funcionalidades transaccionales.:</td>
												<td><input type="text" onkeypress="SoloNumeros();" style="width:100px; "
													name="nroFuncionalidadesTransacciones"
													value="${listaInfo.nroFuncionalidadesTransacciones}"></td>
											</tr>

											<tr>
												<td>N° de reportes.:</td>
												<td><input type="text" name="nroReportes" onkeypress="SoloNumeros();" style="width:100px; "
													value="${listaInfo.nroReportes}"></td>
												<td>N° de consultas.:</td>
												<td><input type="text" name="nroConsultas" onkeypress="SoloNumeros();" style="width:100px; "
													value="${listaInfo.nroConsultas}"></td>
												<td>N° de entidades externas.:</td>
												<td><input type="text" name="nroEntidadesExternas" onkeypress="SoloNumeros();" style="width:100px; "
													value="${listaInfo.nroEntidadesExternas}"></td>
												<td>Observaciones generales.:</td>
												<td><input type="text" name="observacionesGenerales" 	value="${listaInfo.observacionesGenerales}"
													maxlength="2000"></td>
											</tr> 
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Funcionalidad</legend>
										<table>
											<tr>
												<td>Funcionalidad.:</td>
												<td><input type="text" name="funcionalidad"
													value="${funcionalidad.funcionalidad}" maxlength="2000"></td>
												<td>Datos de entrada.:</td>
												<td><input type="text" name="datosEntrada"
													value="${funcionalidad.datosEntrada}" maxlength="2000"></td>
												<td>Proceso.:</td>
												<td><input type="text" name="proceso"
													value="${funcionalidad.proceso}" maxlength="2000"></td>
												<td>Salida.:</td>
												<td><input type="text" name="salida"
													value="${funcionalidad.salida}" maxlength="2000"></td>

											</tr>

										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Dominio</legend>
										<table>
											<tr>
												<td>Front user - Lider usuario de la aplicación.:</td>
												<td><input type="text" name="frontUserLiderUsuario"
													maxlength="250"
													value="<c:out value="${dominio.frontUserLiderUsuario}"/>"></td>
												<td>Gestor de aplicaciones de usuario TI.:</td>
												<td><input type="text" name="gestorAplicaciones"
													maxlength="250"
													value="<c:out value="${dominio.gestorAplicaciones}"/>"></td>
												<td>Especialista de la aplicacion de usuario TI.:</td>
												<td><input type="text" name="especialistaAplicaciones"
													maxlength="250"
													value="<c:out value="${dominio.especialistaAplicaciones}"/>"></td>
												<td>Broker de sistemas.:</td>
												<td><input type="text" name="brokerSistemas"
													maxlength="250"
													value="<c:out value="${dominio.brokerSistemas}"/>"></td>
											</tr>

											<tr>

												<td>Broker de negocio.:</td>
												<td><input type="text" name="brokerNegocios"
													maxlength="250"
													value="<c:out value="${dominio.brokerNegocios}"/>"></td>
												<td>Asesor GUTI.:</td>
												<td><input type="text" name="asesorGUTI"
													maxlength="250"
													value="<c:out value="${dominio.asesorGUTI}"/>"></td>
												<td>Arquitecto de dominio.:</td>
												<td><input type="text" name="arquitectoDominio"
													maxlength="250"
													value="<c:out value= "${dominio.arquitectoDominio}" />"></td>
												<td>Entidades usuarias.:</td>
												<td><select name="entidadesUsuarias"
													id="cbxEntidadesUsuarias">
														<option value="">Seleccione</option>
														<c:forEach items="${entidadesUsuarias}"
															var="entidadesUsuarias">
															<option
																value="<c:out value="${entidadesUsuarias.idEntidadesUsuarias}" />"><c:out
																	value="${entidadesUsuarias.descripcionEntidadesUsuarias}" /></option>
														</c:forEach>
												</select></td>
											</tr>

											<tr>
												<td>¿Cuántos usuarios utilizan la aplicación en
													total?.:</td>
												<td><select name="cantidadUsuariosAplicacionTotal"
													id="cbxCantidadUsuariosTotal">
														<option value="">Seleccione</option>
														<c:forEach items="${cuap}" var="cuap">
															<option
																value="<c:out value="${cuap.idCantidadUsuariosAplicacionTotal}" />"><c:out
																	value="${cuap.descripcionCantidadUsuariosAplicacionTotal}" /></option>
														</c:forEach>
												</select></td>
												<td>Dominio.:</td>
												<td><select name="dominio"
													onchange="ObtenerSubDominio($(this)); return false;"
													id="cbxDominio">
														<option value="">Seleccione</option>
														<c:forEach items="${cdominio}" var="dominio">
															<option value="<c:out value="${dominio.idDominio}" />"><c:out
																	value="${dominio.descripcionDominio}" /></option>
														</c:forEach>
												</select></td>
												<td>Subdominio.:</td>
												<td>
													<div id="divComboSubDominio">
														<select name="subDominio" id="subDominio">
															<option value="">Seleccione</option>
															<c:forEach items="${subdominio}" var="subdominio">
																<option
																	value="<c:out value="${subdominio.idSubDominio}" />"><c:out
																		value="${subdominio.descripcionSubDominio}" /></option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td>¿Cuántas unidades utilizan la aplicación?.:</td>
												<td><select
													onchange="activarCantidadUnidadesUtilizanAplicacion($(this));"
													name="nroUnidadesUtilizanAplicacion"
													id="cbxNroUnidadesUtilizanAplicacion" >
														<option value="">Seleccione</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
												</select>
												</td>
											</tr>

											<tr>
												<td>Nombre de la unidad 1.:</td>
												<td><input type="text" name="nombreUnidad1"
													id="nombreUnidad1" maxlength="50"
													value="<c:out value="${dominio.nombreUnidad1}" />"
													disabled="disabled"></td>
												<td>Nombre de la unidad 2.:</td>
												<td><input type="text" name="nombreUnidad2"
													id="nombreUnidad2" maxlength="50"
													value="<c:out value="${dominio.nombreUnidad2}" />"
													disabled="disabled"></td>
												<td>Nombre de la unidad 3.:</td>
												<td><input type="text" name="nombreUnidad3"
													id="nombreUnidad3" maxlength="50"
													value="<c:out value="${dominio.nombreUnidad3}" />"
													disabled="disabled"></td>
												<td>Proceso de auditoría.:</td>
												<td><select
													onchange="cambiarProcesoAuditoria($(this));" name="procesoAuditoriaD"
													id="cbxProcesoAuditoria">
														<option value="">Seleccione</option>
														<c:forEach items="${procesoAuditoria}"
															var="procesoAuditoria">
															<option
																value="<c:out value="${procesoAuditoria.idProcesoAuditoria}" />"><c:out
																	value="${procesoAuditoria.descripcionProcesoAuditoria}" /></option>
														</c:forEach>
												</select></td>

											</tr>

											<tr>


												<td>Otros.:</td>
												<td><input type="text" name="procesoAuditoriaOtros"
													maxlength="50" id="procesoAuditoriaOtros"
													disabled=”disabled”
													value="<c:out value="${dominio.procesoAuditoriaOtros}"/>">
												</td>
												<td>¿Toca algún proceso clave?.:</td>
												<td><select onchange="dominioTocaPC($(this));"
													name="dominioTocaProcesoClave" id="dominioTocaProcesoClave">
														<option value="">Seleccione</option>
														<option value="1">Si</option>
														<option value="2">No</option>
												</select> <%--<input
													type="text" name="impactaProcesoClave" maxlength="2"
													value="<c:out value="${dominio.impactaProcesoClave}"/>"> --%>
												</td>
												<td>Indicar proceso clave.:</td>
												<td><select
													onchange="cambiarDominioProcesoClave($(this));"
													name="dominioProcesoClave" id="dominioProcesoClave"
													disabled="disabled">
														<option value="">Seleccione</option>
														<c:forEach items="${procesoClave}" var="procesoClave">
															<option
																value="<c:out value="${procesoClave.idProcesoClave}" />"><c:out
																	value="${procesoClave.descripcionProcesoClave}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="nombreProcesoClaveOtros"
													maxlength="50" disabled=”disabled”
													id="nombreProcesoClaveOtros"
													value="<c:out value="${dominio.nombreProcesoClaveOtros}"/>"></td>
											</tr>

											<tr>

												<td>Actividad:</td>
												<td><select name="actividadDominio"
													id="actividadDominio">
														<option value="">Seleccione</option>
														<c:forEach items="${dominioActividad}"
															var="dominioActividad">
															<option
																value="<c:out value="${dominioActividad.idActividad}" />"><c:out
																	value="${dominioActividad.descripcionActividad}" /></option>
														</c:forEach>
												</select></td>
												<td>Relación con CIF:</td>
												<td><input type="text" name="relacionConCIF"
													maxlength="50"
													value="<c:out value="${dominio.relacionConCIF}"/>"></td>
											</tr>


										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Clasificación de activos</legend>
										<table>
											<tr>
												<td>Confidencialidad.:</td>
												<td><select name="confidencialidad"
													id="cbxConfidencialidad">
														<option value="">Seleccione</option>
														<c:forEach items="${confidencialidad}"
															var="confidencialidad">
															<option
																value="<c:out value="${confidencialidad.idConfidencialidad}" />"><c:out
																	value="${confidencialidad.decripcionConfidencialidad}" /></option>
														</c:forEach>
												</select></td>
												<td>Integridad.:</td>
												<td><select name="integridad" id="cbxIntegridad">
														<option value="">Seleccione</option>
														<c:forEach items="${integridad}" var="integridad">
															<option
																value="<c:out value="${integridad.idIntegridad}" />"><c:out
																	value="${integridad.descripcionIntegridad}" /></option>
														</c:forEach>
												</select></td>
												<td>Disponibilidad.:</td>
												<td><select name="disponibilidad"
													id="cbxDisponibilidad">
														<option value="">Seleccione</option>
														<c:forEach items="${disponibilidad}" var="disponibilidad">
															<option
																value="<c:out value="${disponibilidad.idDisponibilidad}" />"><c:out
																	value="${disponibilidad.descripcionDisponibilidad}" /></option>
														</c:forEach>
												</select></td>
												<td>Privacidad.:</td>
												<td><select name="privacidad" id="cbxPrivacidad">
														<option value="">Seleccione</option>
														<c:forEach items="${privacidad}" var="privacidad">
															<option
																value="<c:out value="${privacidad.idPrivacidad}" />"><c:out
																	value="${privacidad.descripcionPrivacidad}" /></option>
														</c:forEach>
												</select></td>
											</tr>

											<tr>
												<td>Clasificación.:</td>
												<td><select name="clasificacion" id="cbxClasificacion">
														<option value="">Seleccione</option>
														<c:forEach items="${clasificacion}" var="clasificacion">
															<option
																value="<c:out value="${clasificacion.idClasificacion}" />"><c:out
																	value="${clasificacion.descripcionClasificacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Observación.:</td>
												<td><input type="text"
													name="clasificacionActivosObservacion" maxlength="250"
													value="<c:out value="${clasifActivos.clasificacionActivosObservacion}"/>"></td>
												<td>Criticidad final.:</td>
												<td><select name="criticidadfinal"
													id="cbxCriticidadFinal">
														<option value="">Seleccione</option>
														<c:forEach items="${criticidadfinal}"
															var="criticidadfinal">
															<option
																value="<c:out value="${criticidadfinal.idCriticidadFinal}" />"><c:out
																	value="${criticidadfinal.descripcionCriticidadFinal}" /></option>
														</c:forEach>
												</select></td>
												<td>Estado de revisión de las aplicaciones.:</td>
												<td><select name="estadoRevisionAplicaciones"
													id="estadoRevisionAplicaciones">
														<option value="">Seleccione</option>
														<c:forEach items="${estadoRevision}" var="estadoRevision">
															<option
																value="<c:out value="${estadoRevision.idEstadoRevisionAplicacion}" />"><c:out
																	value="${estadoRevision.descripcionEstadoRevisionAplicacion}" /></option>
														</c:forEach>
												</select>
											</tr>


										</table>
									</fieldset>
								</td>
							</tr>

							<tr>
								<td>
									<div class="formularioBoton">

										<input type="reset" name="limpiar" value="Limpiar"></input>
									</div>
								</td>
							</tr>
						</table>

				
				</div>
			</div>
			<div class="pestana" id="tabs-2">
				<div class="formulario">
					<div class="cabecera">
						<h2>.:: Información Técnica e Impacto</h2>
						<hr>
					</div>
					
						<table style="width: 100%" class="tablaDatos">
							<tr>
								<td>
									<fieldset>
										<legend align="left">Características técnicas</legend>
										<table>

											<tr>
												<td>Categoría tecnológica.:</td>
												<td><select		onchange="cambiarCategoriaTecnologica($(this));"
													name="idCategoriaTecnologica" id="idCategoriaTecnologica">
														<option value="">Seleccione</option>
														<c:forEach items="${categoriaTecnologica}" var="categoria">
															<option
																value="<c:out value="${categoria.idCategoriaTecnologica}" />"><c:out
																	value="${categoria.descripcionCategoriaTecnologica}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="categoriaTecnologicaOtros"
													id="categoriaTecnologicaOtros" maxlength="50"
													disabled=”disabled”
													value="${listaCaracteristicas.categoriaTecnologicaOtros}" /></td>
												<td>Tipo de desarrollo.:</td>
												<td><select name="tipoDesarrollo"
													id="cbxTipoDesarrollo">
														<option value="">Seleccione</option>
														<c:forEach items="${tipoDesarrollo}" var="tipoDesarrollo">
															<option
																value="<c:out value="${tipoDesarrollo.idTipoDesarrollo}" />"><c:out
																	value="${tipoDesarrollo.descripcionTipoDesarrollo}" /></option>
														</c:forEach>
												</select></td>
												<td>Ubicación física.:</td>
												<td><select name="idUbicacionFisica"
													id="cbxUbicacionFisica">
														<option value="">Seleccione</option>
														<c:forEach items="${ubicacionFisica}"
															var="ubicacionFisica">
															<option
																value="<c:out value="${ubicacionFisica.idUbicacionFisica}" />"><c:out
																	value="${ubicacionFisica.descripcionUbicacionFisica}" /></option>
														</c:forEach>
												</select></td>

											</tr>
											<tr>
												<td>Ambiente AppNoIT.:</td>
												<td><select onchange="cambiarAppNoIT($(this));"
													name="idAmbienteAppNOIT" id="cbxAmbienteAppNoIT">
														<option value="">Seleccione</option>
														<c:forEach items="${ambiente}" var="ambiente">
															<option
																value="<c:out value="${ambiente.idAmbienteAppNoIT}" />"><c:out
																	value="${ambiente.descripcionAmbienteAppNoIT}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="ambienteAppNOITOtros"
													id="ambienteAppNoIT"
													value="${listaCaracteristicas.ambienteAppNOITOtros}"
													maxlength="50" disabled=”disabled” /></td>
												<td>Nombre de la ubicación.:</td>
												<td><input type="text" name="nombreUbicacion"
													value="${listaCaracteristicas.nombreUbicacion}"
													maxlength="50" /></td>
												<td>Infraestructura de la aplicación.:</td>
												<td><select name="idInfraestructuraAplicacion"
													id="idInfraestructuraAplicacion">
														<option value="">Seleccione</option>
														<c:forEach items="${infraestructuraAplicacion}"
															var="infraestructuraAplicacion">
															<option
																value="<c:out value="${infraestructuraAplicacion.idInfraestructuraAplicacion}" />"><c:out
																	value="${infraestructuraAplicacion.descripcionInfraestructuraAplicacion}" /></option>
														</c:forEach>
												</select></td>

											</tr>

											<td>&nbsp;</td>
											<tr>
												<td>¿La solución es stand alone?.:</td>
												<td><select name="esSolucionStandAlone">
														<option value="">Seleccione</option>
														<option value="1">Si</option>
														<option value="2">No</option>
												</select></td>
												<td>¿Cuántas interfaces tienen con otras aplicaciones,
													servicios web, servicios en host, sistemas BD externas,
													DWH?.:</td>
												<td><input type="text" name="nroInterfacesConOtrasApp" style="width: 100px;" onkeypress="SoloNumeros();"
													value="${listValue.nroInterfacesConOtrasApp}"></td>
												<td>¿Cuáles son esas interfaces?.:</td>
												<td><input type="text" name="nombresInterfaces" style="width: 100px;" onkeypress="SoloNumeros();"
													value="${listaCaracteristicas.nombresInterfaces}"
													maxlength="250" /></td>
												<td>¿Quién da mantenimiento a la aplicación?.:</td>
												<td><select
													onchange="cambiarMantenimientoAplicacion($(this));" 
													name="idMantenimientoAplicacion"
													id="cbxMantenimientoAplicacion">
														<option value="">Seleccione</option>
														<c:forEach items="${mantenimientoAplicacion}"
															var="mantenimientoAplicacion">
															<option
																value="<c:out value="${mantenimientoAplicacion.idMantenimientoAplicacion}" />"><c:out
																	value="${mantenimientoAplicacion.descripcionMantenimientoAplicacion}" /></option>
														</c:forEach>
												</select></td>

											</tr>
											<tr>

												<td>Indicar el nombre del proveedor.:</td>
												<td><input type="text"
													name="mantenimientoNombreProveedor"
													id="mantenimientoNombreProveedor"
													value="${listaCaracteristicas.mantenimientoNombreProveedor}"
													maxlength="50" disabled=”disabled” /></td>
												<td>¿Quién realiza el soporte a la aplicación?:</td>
												<td><select
													onchange="cambiarSoporteAplicacion($(this));"
													name="idSoporteAplicacion" id="cbxSoporteAplicacion">
														<option value="">Seleccione</option>
														<c:forEach items="${soporteAplicacion}"
															var="soporteAplicacion">
															<option
																value="<c:out value="${soporteAplicacion.idSoporteAplicacion}" />"><c:out
																	value="${soporteAplicacion.descripcionSoporteAplicacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Indicar el nombre del proveedor.:</td>
												<td><input type="text" name="soporteNombrePorveedor"
													id="soporteNombrePorveedor"
													value="${listaCaracteristicas.soporteNombrePorveedor}"
													maxlength="50" disabled=”disabled” /></td>
												<td>¿Quién brinda los accesos a la aplicación?.:</td>
												<td><select
													onchange="cambiarAccesoAplicacion($(this));"
													name="idAcessosAplicacion" id="cbxAccesosAplicacion">
														<option value="">Seleccione</option>
														<c:forEach items="${accesosAplicacion}"
															var="accesosAplicacion">
															<option
																value="<c:out value="${accesosAplicacion.idAccesosAplicacion}" />"><c:out
																	value="${accesosAplicacion.descripcionAccesosAplicacion}" /></option>
														</c:forEach>
												</select></td>

											</tr>
											<tr>

												<td>Indicar el nombre del proveedor.:</td>
												<td><input type="text" name="accesosNombreProveedor"
													id="accesosNombreProveedor"
													value="${listaCaracteristicas.accesosNombreProveedor}"
													maxlength="50" disabled=”disabled” /></td>
												<td>Nombre del servidor:</td>
												<td><input type="text" name="nombreServidor"
													value="${listaCaracteristicas.nombreServidor}"
													maxlength="50" /></td>
												<td>Ubicación del servidor:</td>
												<td><input type="text" name="ubicacionServidor"
													value="${listaCaracteristicas.ubicacionServidor}"
													maxlength="250"></td>

											</tr>

										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Datamart</legend>
										<table>

											<tr>
												<td>Nombre datamart.:</td>
												<td><input type="text" name="nombreDatamart"
													maxlength="50"
													value="<c:out value="${listaDatamart.nombreDatamart}"/>">
												</td>
												<td>¿Cuántas tablas tiene?.:</td>
												<td><input type="text" name="cantidadTablas" onkeypress="SoloNumeros();" style="width:100px; "
													value="<c:out value="${listaDatamart.cantidadTablas}"/>">
												</td>
												<td>¿Cuántas tablas descriptivas (lookups) tiene?.:</td>
												<td><input type="text"
													name="cantidadTablasDescriptivas" onkeypress="SoloNumeros();" style="width:100px; "
													value="<c:out value="${listaDatamart.cantidadTablasDescriptivas}"/>">
												</td>
												<td>¿Cuántas tablas de hechos (facts) tiene?.:</td>
												<td><input type="text" name="cantidadTablasHechos" onkeypress="SoloNumeros();" style="width:100px; "
													value="<c:out value="${listaDatamart.cantidadTablasHechos}"/>">
												</td>
											</tr>
											<tr>
												<td>Herramientas de explotación que utiliza.:</td>
												<td><select
													onchange="cambiarHerramientaExplotacion($(this));"
													name="idHerramientaExplotacionDatos"
													id="idHerramientaExplotacionDatos">
														<option value="">Seleccione</option>
														<c:forEach items="${herramienta}" var="herramienta">
															<option
																value="<c:out value="${herramienta.idHerramientaExplotacionDatos}" />">
																<c:out
																	value="${herramienta.descripcionHerramientaExplotacionDatos}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="herramientaExplotacionDatosOtros"
													id="herramientaExplotacionDatosOtros" maxlength="50"
													value="<c:out value="${listaDatamart.herramientaExplotacionDatosOtros}"/>"
													disabled="disabled" /></td>
												<td>¿Cuántos reportes genera?.:</td>
												<td><input type="text" name="cantidadReportes" onkeypress="SoloNumeros();" style="width:100px; "
													value="<c:out value="${listaDatamart.cantidadReportes}"/>">
												</td>
												<td>¿Cuántos usuarios tienen accesos?.:</td>
												<td><input type="text" name="cantidadUsuarios" onkeypress="SoloNumeros();" style="width:100px; "
													value="<c:out value="${listaDatamart.cantidadUsuarios}"/>">
												</td>
											</tr>
											<tr>
												<td>Frecuencia.:</td>
												<td><input type="text" name="frecuencia" maxlength="50" onkeypress="SoloNumeros();" style="width:100px; "
													value="<c:out value="${listaDatamart.frecuencia}" />">
												</td>
												<td>Cantidad de espacio en tablespace.:</td>
												<td><input type="text" name="cantidadEspacioTablespace" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="50"
													value="<c:out value="${listaDatamart.cantidadEspacioTablespace}"/>">
												</td>

											</tr>


										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Impactos</legend>
										<table>
											<tr>
												<td>Impacto financiero.:</td>
												<td><input type="text" name="impactoFinanciero" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.impactoFinanciero}" />">
												</td>
												<td>Rentabilidad.:</td>
												<td><input type="text" name="rentabilidad" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.rentabilidad}" />">
												</td>
												<td>Impacto en la imagen.:</td>
												<td><input type="text" name="impactoImagen" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.impactoImagen}" />">
												</td>
												<td>Impacto en los clientes.:</td>
												<td><input type="text" name="impactoClientes" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.impactoClientes}" />">
												</td>
											</tr>
											<tr>
												<td>Impacto operativo.:</td>
												<td><input type="text" name="impactoOperativo" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.impactoOperativo}" />">
												</td>
												<td>Impacto legal.:</td>
												<td><input type="text" name="impactoLegal" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.impactoLegal}" />">
												</td>
												<td>Proceso de auditoría.:</td>
												
													<td><select name="idProcesoAuditoriaI"
													id="idProcesoAuditoriaI">
														<option value="">Seleccione</option>
														<c:forEach items="${procesoAuditoria}"
															var="procesoAuditoria">
															<option
																value="<c:out value="${procesoAuditoria.idProcesoAuditoria}" />"><c:out
																	value="${procesoAuditoria.descripcionProcesoAuditoria}" /></option>
														</c:forEach>
												</select></td>
											
												<td>¿Toca algún proceso clave?.:</td>

												<td><select onchange="impactoTocaPC($(this));"
													name="impactoTocaProcesoClave" id="impactoTocaProcesoClave">
														<option value="">Seleccione</option>
														<option value="1">Si</option>
														<option value="2">No</option>
												</select> <%-- <td><input type="text"
													name="tocaProcesoClave" maxlength="250"
													value="<c:out value="${impacto.tocaProcesoClave}" />">
												</td>--%>
											</tr>
											<tr>
												<td>Indicar proceso clave.:</td>
												<td><select onchange="cambiarImpactoPC($(this));"
													name="impactoIndicarProcesoClave"
													id="impactoIndicarProcesoClave" disabled="disabled">
														<option value="">Seleccione</option>
														<c:forEach items="${impactoProcesoClave}"
															var="impactoProcesoClave">
															<option
																value="<c:out value="${impactoProcesoClave.idProcesoClave}" />">
																<c:out
																	value="${impactoProcesoClave.descripcionProcesoClave}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="otrosImpactoProcesoClave"
													id="otrosImpactoProcesoClave" maxlength="250"
													value="<c:out value="${impacto.otrosProcesoClave}"/>"
													disabled="disabled" /></td>
												<td>Actividad.:</td>
												<td><select name="actividadImpacto"
													id="actividadImpacto">
														<option value="">Seleccione</option>
														<c:forEach items="${impactoActividad}"
															var="impactoActividad">
															<option
																value="<c:out value="${impactoActividad.idActividad}" />"><c:out
																	value="${impactoActividad.descripcionActividad}" /></option>
														</c:forEach>
												</select></td>
												<td>Categoría tecnológica.:</td>
												<td><input type="text" name="categoriaTecnologica" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.categoriaTecnologica}" />">
												</td>
											</tr>
											<tr>
												<td>Nivel de criticidad.:</td>
												<td><input type="text" name="nivelCriticidad" onkeypress="SoloNumeros();" style="width:100px; "
													maxlength="250"
													value="<c:out value="${impacto.nivel_criticidad}" />">
												</td>

											</tr>
										</table>
									</fieldset>
								</td>
							</tr>

							<tr>
								<td>
							<div class="formularioBoton" align="right">

								<input type="reset" name="limpiar" value="Limpiar"></input>
							</div>
						</td>
							</tr>
						

						</table>

				
				</div>
			</div>
			<div class="pestana" id="tabs-3">
				<div class="formulario">
					<div class="cabecera">
						<h2>.:: Información Roadmap</h2>
						<hr>
					</div>
			
						<table style="width: 100%" class="tablaDatos">
							<tr>
								<td>
									<fieldset>
										<legend align="left">Información plan de Roadmap</legend>
										<table>

											<tr>
												<td>Roadmap corto plazo.:</td>
												<td><input type="text" name="roadmapCortoPlazo"
													value="${listaInformacionPlanRoadmap.roadmapCortoPlazo}"
													maxlength="250" /></td>
												<td>Roadmap largo plazo.:</td>
												<td><input type="text" name="roadmapLargoPlazo"
													value="${listaInformacionPlanRoadmap.roadmapLargoPlazo}"
													maxlength="250" /></td>
												<td>Estado atención de Roadmap.:</td>
												<td><select name="idEstadoAtencionRoadmap"
													id="cbxEstadoAtencionRoadmap">
														<option value="">Seleccione</option>
														<c:forEach items="${estadoAtencionRoadmap}"
															var="estadoAtencionRoadmap">
															<option
																value="<c:out value="${estadoAtencionRoadmap.idEstadoAtencionRoadmap}" />">
																<c:out
																	value="${estadoAtencionRoadmap.descripcionEstadoAtencionRoadmap}" />
															</option>
														</c:forEach>
												</select></td>
												<td>Fecha inicio planificado.:</td>
												<td><input type="text" class="tcal"
													name="fechaInicioPlanificado"
													value="${listaInformacionPlanRoadmap.fechaInicioPlanificado}"
													maxlength="250" /></td>

											</tr>
											<tr>
												<td>Fecha de compromiso.:</td>
												<td><input type="text" class="tcal"
													name="fechaCompromiso"
													value="${listaInformacionPlanRoadmap.fechaCompromiso}"
													maxlength="250" /></td>
												<td>Roadmap ejecutado actual.:</td>
												<td><input type="text" name="roadmapEjecutadoActual"
													value="${listaInformacionPlanRoadmap.roadmapEjecutadoActual}"
													maxlength="250" /></td>
											</tr>

										</table>
									</fieldset>
								</td>
							</tr>

						<tr>
						<td>
							<div class="formularioBoton" align="right">

								<input type="reset" name="limpiar" value="Limpiar"></input>
							</div>
						</td>
					</tr>
					</table>
				</div>
			</div>
			<div class="pestana" id="tabs-4">
				<div class="formulario">
					<div class="cabecera">
						<h2>.:: Información de Pre Atención</h2>
						<hr>
					</div>
			
						<table style="width: 100%" class="tablaDatos">
							<tr>
								<td>
									<fieldset>
										<legend align="left">Pre atención - Software base -
											Estándares tecnológicos</legend>
										<table>
											<tr>
												<td>Estándar - Sistema operativo.:</td>
												<td><select
													onchange="cambiarEstandarSistemaOperativo($(this));"
													name="idSwBaseEstandarSistemaOperativoPRE"
													id="idSwBaseEstandarSistemaOperativoPRE">
														<option value="">Seleccione</option>
														<c:forEach items="${presistemaOperativo}"
															var="presistemaOperativo">
															<option
																value="<c:out value="${presistemaOperativo.idSwBaseEstandarSistemaOperativo}" />"><c:out
																	value="${presistemaOperativo.descripcionSwBaseEstandarSistemaOperativo}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="swBaseSistemaOperativoOtrosPRE"
													id="swBaseSistemaOperativoOtrosPRE" maxlength="50"
													disabled=”disabled”
													value="${preswBaseEstandarTecnologico.swBaseSistemaOperativoOtros}" />
												</td>
												</tr>
												<tr>
												<td>Estándar - Herramientas de programación.:</td>
												<td><select
													onchange="cambiarEstandarHerramientaProgramacion($(this));"
													name="idSwBaseEstandarHeramientaProgramacionPRE"
													id="idSwBaseEstandarHeramientaProgramacionPRE">
														<option value="">Seleccione</option>
														<c:forEach items="${preherramientaProgramacion}"
															var="preherramientaProgramacion">
															<option
																value="<c:out value="${preherramientaProgramacion.idSwBaseEstandarHerramientaProgramacion}" />"><c:out
																	value="${preherramientaProgramacion.descripcionSwBaseEstandarHerramientaProgramacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="swBaseHerramientaProgramacionOtrosPRE"
													id="swBaseHerramientaProgramacionOtrosPRE"
													value="${preswBaseEstandarTecnologico.swBaseHerramientaProgramacionOtros}"
													maxlength="50" disabled=”disabled” /></td>
											</tr>
											<tr>
												<td>Lenguaje de programación.:</td>
												<td><select
													onchange="cambiarEstandarLenguajeProgramacion($(this));"
													name="idSwBaseEstandarLenguajeProgramacionPRE"
													id="cbxPreLenguajeProgramacion">
														<option value="">Seleccione</option>
														<c:forEach items="${prelenguajeProgramacion}"
															var="prelenguajeProgramacion">
															<option
																value="<c:out value="${prelenguajeProgramacion.idSwBaseEstandarLenguajeProgramacion}" />"><c:out
																	value="${prelenguajeProgramacion.descripcionSwBaseEstandarLenguajeProgramacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="swBaseLenguajeProgramacionOtrosPRE"
													id="swBaseLenguajeProgramacionOtrosPRE"
													value="${preswBaseEstandarTecnologico.swBaseLenguajeProgramacionOtros}"
													maxlength="50" disabled=”disabled” /></td>
												<td>Estándar - Gestor de base de datos.:</td>
												<td><select
													onchange="cambiarEstandarGestorBaseDatos($(this));"
													name="idSwBaseEstandarGestorBDPRE" id="cbxPreGestorBD">
														<option value="">Seleccione</option>
														<c:forEach items="${pregestorBD}" var="pregestorBD">
															<option
																value="<c:out value="${pregestorBD.idSwBaseEstandarGestorBD}" />"><c:out
																	value="${pregestorBD.descripcionSwBaseEstandarGestorBD}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="swBaseGestorBDOtrosPRE"
													id="swBaseGestorBDOtrosPRE"
													value="${preswBaseEstandarTecnologico.swBaseGestorBDOtros}"
													maxlength="50" disabled=”disabled” /></td>
											</tr>
											<tr>
												<td>Estándar - Framework.:</td>
												<td><select
													onchange="cambiarEstandarFramework($(this));"
													name="idSwBaseEstandarFrameworkPRE" id="cbxPreFramework">
														<option value="">Seleccione</option>
														<c:forEach items="${preframework}" var="preframework">
															<option
																value="<c:out value="${preframework.idSwBaseEstandarFramework}" />"><c:out
																	value="${preframework.descripcionSwBaseEstandarFramework}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="swBaseFrameworkOtrosPRE"
													id="swBaseFrameworkOtrosPRE"
													value="${preswBaseEstandarTecnologico.swBaseFrameworkOtros}"
													maxlength="50" disabled=”disabled” /></td>
												<td>Observaciones adicionales.:</td>
												<td><input type="text"
													name="swBaseObservacionesAdicionalesPRE"
													value="${preswBaseEstandarTecnologico.swBaseObservacionesAdicionales}"
													maxlength="50" /></td>
											</tr>

										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Pre Atención - Lineamiento</legend>
										<table>
											<tr>
												<td>Accesos - Gestión de privilegios en los sistemas.:</td>
												<td><select
													name="idAccesosGestionPrivilegiosSistemasPRE"
													id="cbxPreGestionPrivilegios">}
														<option value="">Seleccione</option>
														<c:forEach items="${preagps}" var="preagps">
															<option
																value="<c:out value="${preagps.idAccesosGestionPrivilegiosSistemas}" />"><c:out
																	value="${preagps.descripcionAccesosGestionPrivilegiosSistemas}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Revisión de los privilegios de los
													usuarios.:</td>
												<td><select
													name="idAccesosRevisionPrivilegiosUsuariosPRE"
													id="cbxPreRevisionPrivilegios">
														<option value="">Seleccione</option>
														<c:forEach items="${prearpu}" var="prearpu">
															<option
																value="<c:out value="${prearpu.idAccesosRevisionPrivilegiosUsuarios}" />"><c:out
																	value="${prearpu.descripcionAccesosRevisionPrivilegiosUsuarios}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Gestión de contraseñas.:</td>
												<td><select name="idAccesosGestionContrasenasPRE"
													id="cbxPreGestionContrasenas">
														<option value="">Seleccione</option>
														<c:forEach items="${preagc}" var="preagc">
															<option
																value="<c:out value="${preagc.idAccesosGestionContrasenas}" />"><c:out
																	value="${preagc.descripcionAccesosGestionContrasenas}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Política de contraseñas.:</td>
												<td><select name="idAccesosPoliticaContrasenasPRE"
													id="cbxPrePoliticaContrasenas">
														<option value="">Seleccione</option>
														<c:forEach items="${preapc}" var="preapc">
															<option
																value="<c:out value="${preapc.idAccesosPoliticaContrasenas}" />"><c:out
																	value="${preapc.descripcionAccesosPoliticaContrasenas}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>

												<td>Accesos - Gestión de claves 1.:</td>
												<td><select name="idAccesosGestionClaves1PRE"
													id="cbxPreGestionClaves1">
														<option value="">Seleccione</option>
														<c:forEach items="${preagc1}" var="preagc1">
															<option
																value="<c:out value="${preagc1.idAccesosGestionClaves1}" />"><c:out
																	value="${preagc1.descripcionAccesosGestionClaves1}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Gestión de claves 2.:</td>
												<td><select name="idAccesosGestionClaves2PRE"
													id="cbxPreGestionClaves2">
														<option value="">Seleccione</option>
														<c:forEach items="${preagc2}" var="preagc2">
															<option
																value="<c:out value="${preagc2.idAccesosGestionClaves2}" />"><c:out
																	value="${preagc2.descripcionAccesosGestionClaves2}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Gestión de claves 3.:</td>
												<td><select name="idAccesosGestionClaves3PRE"
													id="cbxPreGestionClaves3">
														<option value="">Seleccione</option>
														<c:forEach items="${preagc3}" var="preagc3">
															<option
																value="<c:out value="${preagc3.idAccesosGestionClaves3}" />"><c:out
																	value="${preagc3.descripcionAccesosGestionClaves3}" /></option>
														</c:forEach>
												</select></td>
												<td>Auditoría - Registro de auditorías.:</td>
												<td><select name="idAuditoriaRegistroAuditoriaPRE"
													id="cbxPreRegistroAuditorias">
														<option value="">Seleccione</option>
														<c:forEach items="${preregistroAuditoria}"
															var="preregistroAuditoria">
															<option
																value="<c:out value="${preregistroAuditoria.idAuditoriaRegistroAuditoria}" />"><c:out
																	value="${preregistroAuditoria.descripcionAuditoriaRegistroAuditoria}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>

												<td>Auditoría - Protección de los registros de
													auditoría.:</td>
												<td><select
													name="idAuditoriaProteccionRegistrosAuditoriaPRE"
													id="cbxPreProteccionRegistros">
														<option value="">Seleccione</option>
														<c:forEach items="${preproteccionRegistros}"
															var="preproteccionRegistros">
															<option
																value="<c:out value="${preproteccionRegistros.idAuditoriaProteccionRegistrosAuditoria}" />"><c:out
																	value="${preproteccionRegistros.descripcionAuditoriaProteccionRegistrosAuditoria}" /></option>
														</c:forEach>
												</select></td>
												<td>Auditoría - Registro de eventos de los
													administradores de los sistemas o administradores de
													seguridad.:</td>
												<td><select
													name="idAuditoriaRegistroEventosAdministradoresPRE"
													id="cbxPreRegistroEventos">
														<option value="">Seleccione</option>
														<c:forEach items="${preregistroEventos}"
															var="preregistroEventos">
															<option
																value="<c:out value="${preregistroEventos.idAuditoriaRegistroEventosAdministradores}" />"><c:out
																	value="${preregistroEventos.descripcionAuditoriaRegistroEventosAdministradores}" /></option>
														</c:forEach>
												</select></td>
												<td>Auditoría - Conformidad con las políticas de
													seguridad y los estándares.:</td>
												<td><select name="idAuditoriaConformidadPoliticasPRE"
													id="cbxPreConformidadPoliticas">
														<option value="">Seleccione</option>
														<c:forEach items="${preconformidadPoliticas}"
															var="preconformidadPoliticas">
															<option
																value="<c:out value="${preconformidadPoliticas.idAuditoriaConformidadPoliticas}" />"><c:out
																	value="${preconformidadPoliticas.descripcionAuditoriaConformidadPoliticas}" /></option>
														</c:forEach>
												</select></td>
												<td>Contingencia:</td>
												<td><select name="idContingenciaPRE"
													id="cbxPreContingencia">
														<option value="">Seleccione</option>
														<c:forEach items="${precontingencia}"
															var="precontingencia">
															<option
																value="<c:out value="${precontingencia.idContingencia}" />"><c:out
																	value="${precontingencia.descripcionContingencia}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>
												<td>Control de cambios - Procedimientos de control de
													cambios de software.:</td>
												<td><select name="idControlCambiosProcedimientosSwPRE"
													id="cbxPreProcedimientosSw">
														<option value="">Seleccione</option>
														<c:forEach items="${preprocedimientosSw}"
															var="preprocedimientosSw">
															<option
																value="<c:out value="${preprocedimientosSw.idControlCambiosProcedimientosSw}" />"><c:out
																	value="${preprocedimientosSw.descripcionControlCambiosProcedimientosSw}" /></option>
														</c:forEach>
												</select></td>
												<td>Control de cambios - Procedimientos de control de
													cambios de infraestructura.:</td>
												<td><select
													name="idControlCambiosProcedimientosInfraestructuraPRE"
													id="cbxPreProcedimientoInfraestructura">
														<option value="">Seleccione</option>
														<c:forEach items="${preprocedimientoInfraestructura}"
															var="preprocedimientoInfraestructura">
															<option
																value="<c:out value="${preprocedimientoInfraestructura.idControlCambiosProcedimientosInfraestructura}" />"><c:out
																	value="${preprocedimientoInfraestructura.descripcionControlCambiosProcedimientosInfraestructura}" /></option>
														</c:forEach>
												</select></td>
												<td>Documentación- Manejo de documentación.:</td>
												<td><select name="idDocumentacionManejoPRE"
													id="cbxPreDocumentacionManejo">
														<option value="">Seleccione</option>
														<c:forEach items="${predocumentacionManejo}"
															var="predocumentacionManejo">
															<option
																value="<c:out value="${predocumentacionManejo.idDocumentacionManejo}" />"><c:out
																	value="${predocumentacionManejo.descripcionDocumentacionManejo}" /></option>
														</c:forEach>
												</select></td>
												<td>Incidentes - Cumplimiento de las políticas<br>
													de antivirus de la organización.:
												</td>
												<td><select
													name="idIncidentesCumplimientoPoliticasAntivirusPRE"
													id="cbxPrePoliticasAntivirus">
														<option value="">Seleccione</option>
														<c:forEach items="${prepoliticasAntivirus}"
															var="prepoliticasAntivirus">
															<option
																value="<c:out value="${prepoliticasAntivirus.idIncidentesCumplimientoPoliticasAntivirus}" />"><c:out
																	value="${prepoliticasAntivirus.descripcionIncidentesCumplimientoPoliticasAntivirus}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>

												<td>Incidentes - Cumplimiento de los controles contra
													código malicioso.:</td>
												<td><select
													name="idIncidentesCumplimientoCodigoMaliciosoPRE"
													id="cbxPreCumplimientoCodigoMalicioso">
														<option value="">Seleccione</option>
														<c:forEach items="${precumplimientoCodigoMalicioso}"
															var="precumplimientoCodigoMalicioso">
															<option
																value="<c:out value="${precumplimientoCodigoMalicioso.idIncidentesCumplimientoCodigoMalicioso}" />"><c:out
																	value="${precumplimientoCodigoMalicioso.descripcionIncidentesCumplimientoCodigoMalicioso}" /></option>
														</c:forEach>
												</select></td>
												<td>Incidentes - Cumplimiento con las políticas de
													gestión de parches.:</td>
												<td><select
													name="idIncidentesCumplimientoGestionParchesPRE"
													id="cbxPreGestionParches">
														<option value="">Seleccione</option>
														<c:forEach items="${pregestionParches}"
															var="pregestionParches">
															<option
																value="<c:out value="${pregestionParches.idIncidentesCumplimientoGestionParches}" />"><c:out
																	value="${pregestionParches.descripcionIncidentesCumplimientoGestionParches}" /></option>
														</c:forEach>
												</select></td>
												<td>Integridad y confidencialidad Protección de datos
													de prueba.:</td>
												<td><select
													name="idIntegridadConfidencialidadDatosPruebaPRE"
													id="cbxPreDatosPrueba">
														<option value="">Seleccione</option>
														<c:forEach items="${predatosPrueba}" var="predatosPrueba">
															<option
																value="<c:out value="${predatosPrueba.idIntegridadConfidencialidadDatosPrueba}" />"><c:out
																	value="${predatosPrueba.descripcionIntegridadConfidencialidadDatosPrueba}" /></option>
														</c:forEach>
												</select></td>
												<td>Respaldos - Gestión de respaldo y recuperación.:</td>
												<td><select
													name=idRespaldosGestionRespaldoRecuperacionPRE
													id="cbxPreRespaldoRecuperacion">
														<option value="">Seleccione</option>
														<c:forEach items="${prerespaldoRecuperacion}"
															var="prerespaldoRecuperacion">
															<option
																value="<c:out value="${prerespaldoRecuperacion.idRespaldosGestionRespaldoRecuperacion}" />"><c:out
																	value="${prerespaldoRecuperacion.descripcionRespaldosGestionRespaldoRecuperacion}" /></option>
														</c:forEach>
												</select></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Comentarios</legend>
										<table>
											<tr>
												<td>Observaciones.:</td>
												<td><TEXTAREA COLS=130 ROWS=5 name="observaciones" id="observaciones"></TEXTAREA></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
								<td>

							<div class="formularioBoton" align="right">

								 <input
									type="reset" name="Limpiar" value="Limpiar"></input>
							</div>

								</td>
							</tr>

						</table>

				
				</div>
			</div>
			<div class="pestana" id="tabs-5">
				<div class="formulario">
					<div class="cabecera">
						<h2>.:: Información de Post Atención</h2>
						<hr>
					</div>

						<table style="width: 100%" class="tablaDatos">
							<tr>
								<td>
									<fieldset>
										<legend align="left">Post Atención - Software Base -
											Estándares Tecnológicos</legend>
										<table>
											<tr>
												<td>Estándar - Sistema operativo.:</td>
												<td><select
													onchange="cambiarEstandarSistemaOperativoPOST($(this));"
													name="idSwBaseEstandarSistemaOperativoPOST"
													id="cbxSistemaOperativo">
														<option value="">Seleccione</option>
														<c:forEach items="${sistemaOperativo}"
															var="sistemaOperativo">
															<option
																value="<c:out value="${sistemaOperativo.idSwBaseEstandarSistemaOperativo}" />"><c:out
																	value="${sistemaOperativo.descripcionSwBaseEstandarSistemaOperativo}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="swBaseSistemaOperativoOtrosPOST"
													id="swBaseSistemaOperativoOtrosPOST" maxlength="50"
													value="${swBaseEstandarTecnologico.swBaseSistemaOperativoOtros}"
													disabled=”disabled”></td>
												<td>Estándar - Herramientas de programación.:</td>
												<td><select
													onchange="cambiarEstandarHerramientaProgramacionPOST($(this));"
													name="idSwBaseEstandarHeramientaProgramacionPOST"
													id="cbxHerramientaProgramacion">
														<option value="">Seleccione</option>
														<c:forEach items="${herramientaProgramacion}"
															var="herramientaProgramacion">
															<option
																value="<c:out value="${herramientaProgramacion.idSwBaseEstandarHerramientaProgramacion}" />"><c:out
																	value="${herramientaProgramacion.descripcionSwBaseEstandarHerramientaProgramacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="swBaseHerramientaProgramacionOtrosPOST"
													id="swBaseHerramientaProgramacionOtrosPOST"
													value="${swBaseEstandarTecnologico.swBaseHerramientaProgramacionOtros}"
													maxlength="50" disabled=”disabled” /></td>
											</tr>
											<tr>
												<td>Lenguaje de programación.:</td>
												<td><select
													onchange="cambiarEstandarLenguajeProgramacionPOST($(this));"
													name="idSwBaseEstandarLenguajeProgramacionPOST"
													id="cbxLenguajeProgramacion">
														<option value="">Seleccione</option>
														<c:forEach items="${lenguajeProgramacion}"
															var="lenguajeProgramacion">
															<option
																value="<c:out value="${lenguajeProgramacion.idSwBaseEstandarLenguajeProgramacion}" />"><c:out
																	value="${lenguajeProgramacion.descripcionSwBaseEstandarLenguajeProgramacion}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text"
													name="swBaseLenguajeProgramacionOtrosPOST"
													id="swBaseLenguajeProgramacionOtrosPOST"
													value="${swBaseEstandarTecnologico.swBaseLenguajeProgramacionOtros}"
													maxlength="50" disabled=”disabled” /></td>
												<td>Estándar - Gestor de base de datos.:</td>
												<td><select
													onchange="cambiarEstandarGestorBaseDatosPOST($(this));"
													name="idSwBaseEstandarGestorBDPOST" id="cbxGestorBD">
														<option value="">Seleccione</option>
														<c:forEach items="${gestorBD}" var="gestorBD">
															<option
																value="<c:out value="${gestorBD.idSwBaseEstandarGestorBD}" />"><c:out
																	value="${gestorBD.descripcionSwBaseEstandarGestorBD}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="swBaseGestorBDOtrosPOST"
													id="swBaseGestorBDOtrosPOST"
													value="${swBaseEstandarTecnologico.swBaseGestorBDOtros}"
													maxlength="50" disabled=”disabled” /></td>
											</tr>
											<tr>
												<td>Estándar - Framework.:</td>
												<td><select
													onchange="cambiarEstandarFrameworkPOST($(this));"
													name="idSwBaseEstandarFrameworkPOST" id="cbxFramework">
														<option value="">Seleccione</option>
														<c:forEach items="${framework}" var="framework">
															<option
																value="<c:out value="${framework.idSwBaseEstandarFramework}" />"><c:out
																	value="${framework.descripcionSwBaseEstandarFramework}" /></option>
														</c:forEach>
												</select></td>
												<td>Otros.:</td>
												<td><input type="text" name="swBaseFrameworkOtrosPOST"
													id="swBaseFrameworkOtrosPOST"
													value="${swBaseEstandarTecnologico.swBaseFrameworkOtros}"
													maxlength="50" disabled=”disabled” /></td>
												<td>Observaciones adicionales.:</td>
												<td><input type="text"
													name="swBaseObservacionesAdicionalesPOST"
													value="${swBaseEstandarTecnologico.swBaseObservacionesAdicionales}">
												</td>
											</tr>

										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Post atención - lineamiento</legend>
										<table>
											<tr>
												<td>Accesos - Gestión de privilegios en los sistemas.:</td>
												<td><select
													name="idAccesosGestionPrivilegiosSistemasPOST"
													id="cbxGestionPrivilegios">
														<option value="">Seleccione</option>
														<c:forEach items="${agps}" var="agps">
															<option
																value="<c:out value="${agps.idAccesosGestionPrivilegiosSistemas}" />"><c:out
																	value="${agps.descripcionAccesosGestionPrivilegiosSistemas}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Revisión de los privilegios de los
													usuarios.:</td>
												<td><select
													name="idAccesosRevisionPrivilegiosUsuariosPOST"
													id="cbxRevisionPrivilegios">
														<option value="">Seleccione</option>
														<c:forEach items="${arpu}" var="arpu">
															<option
																value="<c:out value="${arpu.idAccesosRevisionPrivilegiosUsuarios}" />"><c:out
																	value="${arpu.descripcionAccesosRevisionPrivilegiosUsuarios}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Gestión de contraseñas.:</td>
												<td><select name="idAccesosGestionContrasenasPOST"
													id="cbxGestionContrasenas">
														<option value="">Seleccione</option>
														<c:forEach items="${agc}" var="agc">
															<option
																value="<c:out value="${agc.idAccesosGestionContrasenas}" />"><c:out
																	value="${agc.descripcionAccesosGestionContrasenas}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Política de contraseñas.:</td>
												<td><select name="idAccesosPoliticaContrasenasPOST"
													id="cbxPoliticaContrasenas">
														<option value="">Seleccione</option>
														<c:forEach items="${apc}" var="apc">
															<option
																value="<c:out value="${apc.idAccesosPoliticaContrasenas}" />"><c:out
																	value="${apc.descripcionAccesosPoliticaContrasenas}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>

												<td>Accesos - Gestión de claves 1.:</td>
												<td><select name="idAccesosGestionClaves1POST"
													id="cbxGestionClaves1">
														<option value="">Seleccione</option>
														<c:forEach items="${agc1}" var="agc1">
															<option
																value="<c:out value="${agc1.idAccesosGestionClaves1}" />"><c:out
																	value="${agc1.descripcionAccesosGestionClaves1}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Gestión de claves 2.:</td>
												<td><select name="idAccesosGestionClaves2POST"
													id="cbxGestionClaves2">
														<option value="">Seleccione</option>
														<c:forEach items="${agc2}" var="agc2">
															<option
																value="<c:out value="${agc2.idAccesosGestionClaves2}" />"><c:out
																	value="${agc2.descripcionAccesosGestionClaves2}" /></option>
														</c:forEach>
												</select></td>
												<td>Accesos - Gestión de claves 3.:</td>
												<td><select name="idAccesosGestionClaves3POST"
													id="cbxGestionClaves3">
														<option value="">Seleccione</option>
														<c:forEach items="${agc3}" var="agc3">
															<option
																value="<c:out value="${agc3.idAccesosGestionClaves3}" />"><c:out
																	value="${agc3.descripcionAccesosGestionClaves3}" /></option>
														</c:forEach>
												</select></td>
												<td>Auditoría - Registro de auditorías.:</td>
												<td><select name="idAuditoriaRegistroAuditoriaPOST"
													id="cbxRegistroAuditorias">
														<option value="">Seleccione</option>
														<c:forEach items="${registroAuditoria}"
															var="registroAuditoria">
															<option
																value="<c:out value="${registroAuditoria.idAuditoriaRegistroAuditoria}" />"><c:out
																	value="${registroAuditoria.descripcionAuditoriaRegistroAuditoria}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>

												<td>Auditoría - Protección de los registros de
													auditoría.:</td>
												<td><select
													name="idAuditoriaProteccionRegistrosAuditoriaPOST"
													id="cbxProteccionRegistros">
														<option value="">Seleccione</option>
														<c:forEach items="${proteccionRegistros}"
															var="proteccionRegistros">
															<option
																value="<c:out value="${proteccionRegistros.idAuditoriaProteccionRegistrosAuditoria}" />"><c:out
																	value="${proteccionRegistros.descripcionAuditoriaProteccionRegistrosAuditoria}" /></option>
														</c:forEach>
												</select></td>
												<td>Auditoría - Registro de eventos de los
													administradores de los sistemas o administradores de
													seguridad.:</td>
												<td><select
													name="idAuditoriaRegistroEventosAdministradoresPOST"
													id="cbxRegistroEventos">
														<option value="">Seleccione</option>
														<c:forEach items="${registroEventos}"
															var="registroEventos">
															<option
																value="<c:out value="${registroEventos.idAuditoriaRegistroEventosAdministradores}" />"><c:out
																	value="${registroEventos.descripcionAuditoriaRegistroEventosAdministradores}" /></option>
														</c:forEach>
												</select></td>
												<td>Auditoría - Conformidad con las políticas de
													seguridad y los estándares.:</td>
												<td><select name="idAuditoriaConformidadPoliticasPOST"
													id="cbxConformidadPoliticas">
														<option value="">Seleccione</option>
														<c:forEach items="${conformidadPoliticas}"
															var="conformidadPoliticas">
															<option
																value="<c:out value="${conformidadPoliticas.idAuditoriaConformidadPoliticas}" />"><c:out
																	value="${conformidadPoliticas.descripcionAuditoriaConformidadPoliticas}" /></option>
														</c:forEach>
												</select></td>
												<td>Contingencia.:</td>
												<td><select name="idContingenciaPOST"
													id="cbxContingencia">
														<option value="">Seleccione</option>
														<c:forEach items="${contingencia}" var="contingencia">
															<option
																value="<c:out value="${contingencia.idContingencia}" />"><c:out
																	value="${contingencia.descripcionContingencia}" /></option>
														</c:forEach>
												</select></td>

											</tr>

											<tr>
												<td>Control de cambios - Procedimientos de control de
													cambios de software.:</td>
												<td><select name="idControlCambiosProcedimientosSwPOST"
													id="cbxProcedimientosSw">
														<option value="">Seleccione</option>
														<c:forEach items="${procedimientosSw}"
															var="procedimientosSw">
															<option
																value="<c:out value="${procedimientosSw.idControlCambiosProcedimientosSw}" />"><c:out
																	value="${procedimientosSw.descripcionControlCambiosProcedimientosSw}" /></option>
														</c:forEach>
												</select></td>
												<td>Control de cambios - Procedimientos de control de
													cambios de infraestructura.:</td>
												<td><select
													name="idControlCambiosProcedimientosInfraestructuraPOST"
													id="cbxProcedimientoInfraestructura">
														<option value="">Seleccione</option>
														<c:forEach items="${procedimientoInfraestructura}"
															var="procedimientoInfraestructura">
															<option
																value="<c:out value="${procedimientoInfraestructura.idControlCambiosProcedimientosInfraestructura}" />"><c:out
																	value="${procedimientoInfraestructura.descripcionControlCambiosProcedimientosInfraestructura}" /></option>
														</c:forEach>
												</select></td>
												<td>Documentación - Manejo de documentación.:</td>
												<td><select name="idDocumentacionManejoPOST"
													id="cbxDocumentacionManejo">
														<option value="">Seleccione</option>
														<c:forEach items="${documentacionManejo}"
															var="documentacionManejo">
															<option
																value="<c:out value="${documentacionManejo.idDocumentacionManejo}" />"><c:out
																	value="${documentacionManejo.descripcionDocumentacionManejo}" /></option>
														</c:forEach>
												</select></td>
												<td>Incidentes - Cumplimiento de las políticas de
													antivirus de la organización.:</td>
												<td><select
													name="idIncidentesCumplimientoPoliticasAntivirusPOST"
													id="cbxPoliticasAntivirus">
														<option value="">Seleccione</option>
														<c:forEach items="${politicasAntivirus}"
															var="politicasAntivirus">
															<option
																value="<c:out value="${politicasAntivirus.idIncidentesCumplimientoPoliticasAntivirus}" />"><c:out
																	value="${politicasAntivirus.descripcionIncidentesCumplimientoPoliticasAntivirus}" /></option>
														</c:forEach>
												</select></td>
											</tr>

											<tr>

												<td>Incidentes - Cumplimiento de los controles contra
													código malicioso.:</td>
												<td><select
													name="idIncidentesCumplimientoCodigoMaliciosoPOST"
													id="cbxCumplimientoCodigoMalicioso">
														<option value="">Seleccione</option>
														<c:forEach items="${cumplimientoCodigoMalicioso}"
															var="cumplimientoCodigoMalicioso">
															<option
																value="<c:out value="${cumplimientoCodigoMalicioso.idIncidentesCumplimientoCodigoMalicioso}" />"><c:out
																	value="${cumplimientoCodigoMalicioso.descripcionIncidentesCumplimientoCodigoMalicioso}" /></option>
														</c:forEach>
												</select></td>
												<td>Incidentes - Cumplimiento con las políticas de
													gestión de parches.:</td>
												<td><select
													name="idIncidentesCumplimientoGestionParchesPOST"
													id="cbxGestionParches">
														<option value="">Seleccione</option>
														<c:forEach items="${gestionParches}" var="gestionParches">
															<option
																value="<c:out value="${gestionParches.idIncidentesCumplimientoGestionParches}" />"><c:out
																	value="${gestionParches.descripcionIncidentesCumplimientoGestionParches}" /></option>
														</c:forEach>
												</select></td>
												<td>Integridad y confidencialidad - Protección de datos
													de prueba.:</td>
												<td><select
													name="idIntegridadConfidencialidadDatosPruebaPOST"
													id="cbxDatosPrueba">
														<option value="">Seleccione</option>
														<c:forEach items="${datosPrueba}" var="datosPrueba">
															<option
																value="<c:out value="${datosPrueba.idIntegridadConfidencialidadDatosPrueba}" />"><c:out
																	value="${datosPrueba.descripcionIntegridadConfidencialidadDatosPrueba}" /></option>
														</c:forEach>
												</select></td>
												<td>Respaldos - Gestión de respaldo y recuperación.:</td>
												<td><select
													name="idRespaldosGestionRespaldoRecuperacionPOST"
													id="cbxRespaldoRecuperacion">
														<option value="">Seleccione</option>
														<c:forEach items="${respaldoRecuperacion}"
															var="respaldoRecuperacion">
															<option
																value="<c:out value="${respaldoRecuperacion.idRespaldosGestionRespaldoRecuperacion}" />"><c:out
																	value="${respaldoRecuperacion.descripcionRespaldosGestionRespaldoRecuperacion}" /></option>
														</c:forEach>
												</select></td>
											</tr>

										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Comentarios</legend>
										<table>
											<tr>
												<td>Observaciones.:</td>
												<td><TEXTAREA COLS=130 ROWS=5 name="observacionesPost" id="observacionesPost"></TEXTAREA></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>

							<tr>
								<td>

							<div class="formularioBoton" align="right">

								 <input
									type="reset" name="Limpiar" value="Limpiar"></input>
							</div>

								</td>
							</tr>


				</table>
				</div>
			</div>
			<div class="pestana" id="tabs-6">
				<div class="formulario">
					<div class="cabecera">
						<h2>.:: Información Adicional</h2>
						<hr>
					</div>
			
						<table style="width: 100%" class="tablaDatos">
							<tr>
								<td>
									<fieldset>
										<legend align="left">Seguridad de la información</legend>
										<table>
											<tr>
												<td>Evaluación con seguridad informática.:</td>
												<td><input type="text"
													name="evaluacionSeguridadInformatica"
													value="${seguridadInformacion.evaluacionSeguridadInformatica}"
													maxlength="250" /></td>
												<td>Nivel de Exposición al Riesgo(USD).:</td>
												<td><input type="text" name="seguridadNivelExposicion"
													value="${seguridadInformacion.idSeguridadNivelExposicion}"
													maxlength="50" /></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Características Particulares</legend>
										<table>
											<tr>
												<td>Escenario de Autenticación de Ingreso(Logueo).:</td>
												<td><select name="idEscenarioLogueo"
													id="cbxEscenarioLogueo">
														<option value="">Seleccione</option>
														<c:forEach items="${escenarioLogueo}"
															var="escenarioLogueo">
															<option
																value="<c:out value="${escenarioLogueo.idEscenarioLogueo}" />"><c:out
																	value="${escenarioLogueo.descripcionEscenarioLogueo}" /></option>
														</c:forEach>
												</select></td>
												<td>Impacto en Protección de Datos (Prioridad).:</td>
												<td><select name="idImpactoProteccionDatos"
													id="cbxImpactoProteccion">
														<option value="">Seleccione</option>
														<c:forEach items="${impactoProteccion}"
															var="impactoProteccion">
															<option
																value="<c:out value="${impactoProteccion.idImpactoProteccionDatos}" />"><c:out
																	value="${impactoProteccion.descripcionImpactoProteccionDatos}" /></option>
														</c:forEach>
												</select></td>
												<td>Impacto en Protección de Datos (Prioridad)-
													Identificadas en levantamiento de información del área de
													Cumplimiento Normativo.:</td>
												<td><select
													name="idImpactoProteccionDatosLevantamientoInformacion"
													id="cbxImpactoLevantamiento">
														<option value="">Seleccione</option>
														<c:forEach items="${impactoLevantamiento}"
															var="impactoLevantamiento">
															<option
																value="<c:out value="${impactoLevantamiento.idImpactoProteccionDatosLevantamientoInformacion}" />"><c:out
																	value="${impactoLevantamiento.descripcionImpactoProteccionDatosLevantamientoInformacion}" /></option>
														</c:forEach>
												</select></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend align="left">Fuente de origen</legend>
										<table>
											<tr>
												<td>Fuente.:</td>
												<td><select name="idFuentePeriodo"
													id="cbxFuentePeriodo">
														<option value="">Seleccione</option>
														<c:forEach items="${fuentePeriodo}" var="fuentePeriodo">
															<option
																value="<c:out value="${fuentePeriodo.idFuentePeriodo}" />"><c:out
																	value="${fuentePeriodo.descripcionFuentePeriodo}" /></option>
														</c:forEach>
												</select></td>
												<td>Descripción fuente.:</td>
												<td><input type="text" name="descripcionFuente"
													value="${fuenteOrigen.descripcionFuente}"></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>

							<tr>
							<td>

							<div class="formularioBoton" align="right">
								<input type="reset" name="Limpiar" value="Limpiar"></input>
							</div>

								</td>
							</tr>



				</table>
			</div>



		</div>
		
		<div class="formulario">

			<table class="tablaBotones">
				<tr>
					<td align="right">
					<input	type="button" name="btnExportar" value="Exportar" id="btnExportar" onclick="exportar(); return false;" /></input>
					<input type="submit" name="btnGrabar" value="Grabar" 	 id="btnGrabar">
					
						</td>
				</tr>
			</table>
	

	</div>
</form>
<div>
<a>${mesajeError}</a>
</div>

</body>

</html>
<jsp:include page="../masterpage/inferior.jsp" />