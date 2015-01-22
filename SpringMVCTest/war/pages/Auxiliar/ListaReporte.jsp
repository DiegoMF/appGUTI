<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
					<table  border="1" width="100%" class="tablaGrilla">
						<thead>
							<tr align="center">
								<th>#</th>
								<th>Nombre de reporte general</th>
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
						<tr><td colspan="5"><a style="color: red">${mensajeInfo}</a></td></tr>
					</table>
	