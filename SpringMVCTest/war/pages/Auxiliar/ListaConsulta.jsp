<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
					<table border="1" width="100%" class="tablaGrilla">
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
									<td><a href="#"	onclick="modificar(${listValue.idConsulta});  return false;">Modificar</a>

								</tr>
							</c:forEach>
						</tbody>
					<tr><td colspan="5"><a style="color: red">${mensajeInfo}</a></td></tr>
					</table>
	
	