<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

							<table border="1" width="100%" class="tablaGrilla">
								<thead>
									<tr align="center">
										<th>#</th>
										<th>Id Aplicaci�n</th>
										<th>Versi�n</th>
										<th>Fecha de creaci�n</th>
										<th>Usuario de creaci�n</th>
										<th>Motivo de creaci�n</th>
										
									</tr>
								</thead>
								<tbody>
								<c:forEach var="historial" items="${listaHistory}">
																<tr>
																	<td>${historial.numero}</td>
																	<td>${historial.idAplicacionEspecializada}</td>
																	<td>${historial.idversion}</td>
																	<td>${historial.fechacreacion}</td>
																	<td>${historial.usuarioCreacion}</td>
																	<td>${historial.descripcionmotivo}</td>
																
																</tr>
															</c:forEach>

								</tbody>	
								 <tr><td colspan="6"><a style="color: red">${mensajeInfo}</a></td></tr>						
							</table>
						