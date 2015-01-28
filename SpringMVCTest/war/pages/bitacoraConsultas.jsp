<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<jsp:include page="../masterpage/superior.jsp" />


<script >

function nuevo() {location.href = "/Consulta/Nuevo";}

function buscar() {
			var url = "/Consulta/buscarConsulta";
				var data = $("#formulario").serialize();
				
	        $.post(url,data, function(resultado){$("#divListaConsulta").html(resultado);});  
           
		}
		
		function modificar(idconsulta){
			
			var data = $("#formulario").serialize();
			var url = "/Consulta/Load";
			
			$("#idconsulta").val(idconsulta);
			
			$("#formulario").attr("action", url);
			$("#formulario").submit();
		}
</script>

<body>
<div class="formulario">
				<div class="cabecera">
					<h2>.:: Bitacora de Consultas</h2>
					<hr>
				</div>

	<form action=""  method="post" id="formulario">
	<input type="hidden" name="idconsulta" id="idconsulta"/>
				<table class="tablaDatos">
					<tr>
						<td><label>Nombre de Consulta.:</label></td>
						<td><input type="text" name="nombreConsulta" id="nombreConsulta" style="width: 400px; "></td>
						<td><label>Estado.:</label></td>
						<td><select name="estado">
						<option value="">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
					</tr>
				</table>
	
				<hr>
				&nbsp; &nbsp; &nbsp; &nbsp;

				<table class="tablaBotones">
					<tr>
						<td><input	type="button" value="Buscar" onclick="buscar(); return false;" />
						 <input type="button" value="Nuevo" 	onclick="nuevo(); return false;" />
						 <input type="reset" name="limpiar" value="Limpiar"></input></td>
					</tr>
				</table>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<div id="divListaConsulta">
					<table  border="1" width="100%" class="tablaGrilla">
						<thead>
							<tr align="center">
								<th>#</th>
								<th>Nombre Consulta</th>
								<th>Predeterminado</th>
								<th>Estado</th>							
								<th></th>
							</tr>
						</thead>
						<tbody>		
							<c:forEach var="listValue" items="${listaConsulta}">
								<tr>
									<td>${listValue.numero}</td>
									<td>${listValue.nombreConsulta}</td>
									<td>${listValue.strPredeterminado}</td>
									<td>${listValue.estado}</td>
									<td>
								
									<a href="#"	onclick="modificar(${listValue.id_consulta});  return false;">Modificar</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</form>
			</div>
</body>
</html>
<jsp:include page="../masterpage/inferior.jsp" />