<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<table border="1" width="100%" class="tablaGrilla">
								<thead>
									<tr align="center">
										<th>#</th>
										<th>Descripci�n del Evento</th>
										<th>Fecha Creaci�n</th>
										<th>Usuario de creaci�n</th>
										<th>Estado</th>
										<th>Operaci�n</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="listValue" items="${listaEvento}">
										<tr>
											<td>${listValue.numero}</td>

											<td>${listValue.descripcionEvento}</td>
											<td>${listValue.fechaCreacion}</td>
											<td>${listValue.matriculaUsuario}</td>
											<td>${listValue.estadoEvento}</td>
											<td><a href="#"	onclick="modificarE(${listValue.idBitacoraEventos});  return false;">Modificar</a>
												<a href="#"	onclick="eliminarE(${listValue.idBitacoraEventos},${listValue.idAplicacionEspecializada});">Eliminar</a>
												
											</td>
										</tr>
									</c:forEach>
									
								</tbody>
								<tr><td colspan="6"><a style="color: red">${mensajeEvento}</a></td></tr>
							</table>