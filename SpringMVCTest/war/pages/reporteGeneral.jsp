

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<jsp:include page="../masterpage/superior.jsp" />


<div class="cabecera">
	<h2>.:: Reporte General</h2>
	<hr>
</div>
<div class="formulario">
	<form action="<c:url value="/Consulta/grabarConsulta" />" method="post" id="formulario">

		<div>
			<table width="100%">
				<tr>
					<td>Reporte.:</td>
					<td>
						<select name="idReporte" id="idReporte">
							<option value="">Seleccione</option>
							<c:forEach items="${area}" var="area">
								<option value="<c:out value="${area.idArea}" />"><c:out value="${area.descripcionArea}" /></option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<table width="100%" height="auto" border="0" cellspacing="0"	cellpadding="0">
				<tr>
					<td >
						<fieldset>
							<legend >Filtros del Reporte</legend>
							<table >
							
                    				<tr>
                        				<td>${filtro}</td>
                       
                    				</tr>
                    
               				
							</table>
						</fieldset>

					</td>
					<td>
						<fieldset>
							<legend >Criterios de Agrupación</legend>
							<table>
                    			<tr>
                        			<td>${checks}</td>
                       
                    			</tr>
                			</table>
						</fieldset>
					</td>
					</tr>
			</table>
		</div>
		<div ><br>
		<table class="tablaBotones">
				<tr>
					<td align="right">
					<input type="submit" name="grabar" value="Grabar"></input>
					<input type="submit" name="regresar" value="Regresar"></input>
					</td>
				</tr>
			</table>
			
			<br>
		</div>
		
		<div ><br>
		<table width="100%" class="grafico">
				<tr>
					<td>
						<fieldset>
							<legend >Grafico</legend>
							<table>
                    			<tr>
                        			<td></td>
                       
                    			</tr>
                			</table>
						</fieldset>
					</td>
				</tr>
			</table>
			
			<br>
		</div>
		
		
		<div ><br>
			<table width="100%" class="btnExportar">
				 <tr height="40px">
                        <td colspan="8" style="background-color: #C0C0C0">
                            <input type= "submit" name="exportar" value= "Exportar"></input>
                        </td>
            	</tr>
			</table>

		</div>
	</form>
</div>
<jsp:include page="../masterpage/inferior.jsp" />









