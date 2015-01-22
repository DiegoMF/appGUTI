<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
								<th>Operación</th>
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
									<a href="#"	onclick="eliminar(${listValue.idusuario});">Eliminar</a></td>
								</tr>
							</c:forEach>
							 <tr><td colspan="8"><a style="color: black; font-weight: bold;">Total.: </a><a>${totalRegistro}</a></td></tr>
						</tbody>
						 <tr><td colspan="8"><a style="color: red">${mensajeInfo}</a></td></tr>
					</table>