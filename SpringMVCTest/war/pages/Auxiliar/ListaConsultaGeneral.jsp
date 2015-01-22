<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="results" border="1" width="100%" class="tablaGrilla">
	<thead>
		<tr align="center">
			<th>#</th>
			<th>Código Aplicación</th>
			<th>Nombre Aplicación</th>
			<th>Estado</th>
			<th>Proceso Clave</th>
			<th>Clasificación</th>
			<th>Criticidad Final</th>
			<th>Nivel de Cumplimiento</th>
			<th>Estado de atención de Roadmap</th>
			<th>Post Atención- Nivel de Cumplimiento</th>
			<th>Detalle</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listValue" items="${listaAplicaciones}">
			<tr>
				<td>${listValue.numero}</td>
				<td>${listValue.codigoAplicacion}</td>
				<td>${listValue.nombreAplicacion}</td>
				<td>${listValue.estadoAplicacion}</td>
				<td>${listValue.procesoClave}</td>
				<td>${listValue.clasificacion}</td>
				<td>${listValue.criticidadFinal}</td>
				<td>${listValue.nivelCumplimiento}</td>
				<td>${listValue.estadoAtencionRoadmap}</td>
				<td>${listValue.postAtencionNivelCumplimiento}</td>
				<td><a
					href="/aplicacionEspecializada/verDetalle&ID_APLICACION_ESPECIALIZADA=${listValue.idAplicacion}&ID_VERSION=${listValue.idVersion}">Ver</a>
					<a href="#" onclick="eliminar(${listValue.idAplicacion});">Eliminar</a>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tr>
		<td colspan="11"><a style="color: red">${mensajeInfo}</a></td>
	</tr>
</table>
<div id="pageNavPosition"></div>
<script type="text/javascript"><!--                    
        var pager = new Pager('results', 30); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>