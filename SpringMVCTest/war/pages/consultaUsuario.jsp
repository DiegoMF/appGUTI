<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../masterpage/superior.jsp" />


<script>


		function nuevo() {

			location.href = "/pages/mantenimientoUsuario.jsp";
			
		}
		
		
		function buscar() {
			
			
			var url = "/usuario/buscar";
			var data = $("#formusuario").serialize();
	        $.post(url,data, function(resultado){  
	            $("#divListaUsuario").html(resultado);
	            
	        });  
			
			           
		}
		
		function verdetalle(idusuario){
			
			var data = $("#formusuario").serialize();
			var url = "/usuario/load";
			
			$("#idusuario").val(idusuario);
			
			$("#formusuario").attr("action", url);
			$("#formusuario").submit();
		}
		
		function eliminar(idusuario){
			
			$( "#divEliminarUsuario" ).dialog({
	            height: 'auto',
	            modal: true,
	            buttons: {
	                "Si": function() {
	                	var url = "/usuario/elimina";
	                	var data = {"idUsuario":idusuario};
	                	$.post(url,data, function(){  
	                		buscar();	        	            
	        	        });  
	                	
	                	$( this ).dialog( "close" );
	                	
	                },
	                "No": function() {
	                    $( this ).dialog( "close" );
	                }
	            }
	        });
			
					
		}
		
</script>

<div class="cabecera">
	<h2>.:: Consulta de Usuarios</h2>
	<hr>
</div>

<div class="formulario">
	
	<form method="POST" action="<c:url value="/usuario/buscar"/>" id="formusuario">
	<input type="hidden" name="idUsuario" id="idusuario"/>
		<table bgcolor="#FFFFFF" width="100%" height="65%" border="0"
			cellspacing="0" cellpadding="0">
			<tr height="40px">
				<td>&nbsp;</td>
				<td>Matrícula:</td>
				<td><input type="text" name="matricula" id="txtmatricula" /></td>

				<td>Estado:</td>
				<td><select name="estado" id="ESTADO">
						<option value="">Seleccione</option>
						<option value="1">Activo</option>
						<option value="2">Inactivo</option>
				</select></td>

				<td>Rol:</td>
				<td><select name="rol" id="ID_SEGURIDAD_ROL">
						<option value="">Seleccione</option>
						<option value="1">administrador</option>
						<option value="2">consultor</option>
						<option value="3">supervisor</option>
				</select></td>
				<td>&nbsp;</td>
			</tr>
			<tr height="20px">
				<td>&nbsp;</td>
				<td>Apellido Paterno:</td>
				<td><input type="text" name="apPaterno" id="txtapellidopaterno" /></td>
				<td>Apellido Materno:</td>
				<td><input type="text" name="apMaterno" id="txtapellidomaterno" /></td>
				<td>Nombres:</td>
				<td><input type="text" name="nombres" id="txtnombres" /></td>
			</tr>
			</table>
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			<table class="tablaBotones">
			<tr>
				<td  >
				<input	type="button" value="Buscar" onclick="buscar(); return false;" />
					<input type="button" name="btnNuevo" value="Nuevo" id="btnNuevo" onclick="nuevo();"></input>
					 <input	type="reset" name="limpiar" value="Limpiar"></input>
				</td>
			</tr>
		
			
			</table>
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
		
		<div id="divListaUsuario">
					<table border="1" width="100%" class="tablaGrilla">
						<thead>
							<tr align="center">
								<th>#</th>
								<th>Matricula</th>
								<th>Apellido Paterno</th>
								<th>Apellido Materno</th>
								<th>Nombres</th>
								<th>Rol</th>
								<th>Estado</th>
								<th>Operacion</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listValue" items="${listausuario}"
								varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${listValue.matricula}</td>
									<td>${listValue.apellidoPaterno}</td>
									<td>${listValue.apellidoMaterno}</td>
									<td>${listValue.nombres}</td>
									<td>${listValue.DRol}</td>
									<td>${listValue.estadoDescripcion}</td>
									<td>
									<a href="#"	onclick="verdetalle(${listValue.idusuario});">Modificar</a>
									<a href="#"	onclick="eliminar(${listValue.idusuario});">Eliminar</a>
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
			
	</form>
</div>


<h2>${mensaje}</h2>


<div id="divEliminarUsuario" style="display: none;" title="Confirmación">
    ¿Estás seguro de eliminar el Usuario?
</div>

<div id="divMensaje" style="display: none;" title="BCP - Gestion de Portafolio">
    <p><label id="lblMensaje"></label></p>
</div>






<jsp:include page="../masterpage/inferior.jsp" />