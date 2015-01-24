<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<select name="cOrigen" id="cOrigen" multiple="multiple" class="filtro"
	style="min-width: 300px; min-height: 400px;">
	<c:forEach var="listValue" items="${listaReporteAgrupacion}">
		<option value="${listValue.idConsulta_Columna}">${listValue.descripcion}</option>
	</c:forEach>
</select>



