<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<jsp:include page="../masterpage/superior.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/jquery.validate.js"></script>

<script >



function nuevo() {location.href = "/Reporte/Load";}


function buscar() {
			var url = "/Reporte/buscarReporte";
				var data = $("#formulario").serialize();

	        $.post(url,data, function(resultado){$("#divListaReporte").html(resultado);});  

		}
		
function modificar(idReporte){
	
	var data = $("#formulario").serialize();
	var url = "/Reporte/verReporte";
	
	$("#idReporte").val(idReporte);
	
	$("#formulario").attr("action", url);
	$("#formulario").submit();
}


		
</script>

<body>
<div class="formulario">
				<div class="cabecera">
					<h2>.:: Lista de Reporte General</h2>
					<hr>
				</div>

	<form action=""  method="post" id="formulario">
	<input type="hidden" name="idReporte1" id="idReporte" value="${Reporte.idReporte}"/>
				<table class="tablaDatos">
					<tr>
						<td><label>Nombres del Reporte General.:</label></td>
						<td><input type="text" name="nombreReporte" id="nombreReporte" style="width: 400px; "></td>
						<td><label>Estado.:</label></td>
						<td><select name="estado">
						<option value="">Seleccionar</option>
						<option value="activo">Activo</option>
						<option value="inactivo">Inactivo</option>
						</select></td>
						<td><label>Fecha de creación.:</label></td>
						<td><input type="text" style="width:100px; "  name="fechaCreacion"  id="fechaCreacion"	class="tcal" required></td>
						<td><label>Usuario de Creación.:</label></td>
						<td><input type="text" name="matricula" maxlength="50" id="matricula"/></td>
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
				<div id="divListaReporte">
					<table  border="1" width="100%" class="tablaGrilla">
						<thead>
							<tr align="center">
								<th>#</th>
								<th>Nombres de reporte general</th>
								<th>Fecha de creación</th>
								<th>Usuario de creación</th>
								<th>Estado</th>							
								<th></th>
							</tr>
						</thead>
						<tbody>		
							<c:forEach var="listValue" items="${listaReporte}">
								<tr>
									<td>${listValue.numero}</td>
									<td>${listValue.nombreReporte}</td>
									<td>${listValue.fechaCreacion}</td>
									<td>${listValue.matricula}</td>
									<td>${listValue.estado}</td>
									<td>
								
									<a href="#"	onclick="modificar(${listValue.idReporte});  return false;">Modificar</a>
									
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