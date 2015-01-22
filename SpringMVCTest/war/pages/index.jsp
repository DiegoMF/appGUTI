<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>


<link href="/css/estiloGeneral.css" rel="stylesheet" type="text/css" />
<link href="/css/forms.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="/js/validaciones.js"></script>
<link href="/css/mensajes.css" rel="stylesheet" type="text/css" />




	<div id="head" align="center">
		<table class="tablageneral">
			
			<tr>
				<td class="logo"><img alt="logo" src="/images/logo.png" /></td>
				<td class="titulo"><a> Gesti&oacute;n de Portafolio de Aplicaciones GUTI </a></td>
				
			</tr>
		</table>

	</div>
	<div>
		<table class="tablageneral" align="center">
			<tr>
				<td class="tituloMenu" align="center"><a></a><br /></td>
			</tr>

		</table>
	</div>
	<div id="login" class="formulario">
		<table align="center">
			<tr>
				<td>


					<h2 align="center">Ingrese Usuario</h2>

					<form method="POST" action="<c:url value="/inicio/login" />" >
						<table>
							<tr>
								<td>Matr&iacute;cula.:</td>
								<td><input id="txtmatricula" name="Matricula"  maxlength="6" type="text" /></td>
						
							</tr>
							<tr>
								<td>Contrase&ntilde;a.:</td>
								<td><input id="txtpassword" name="Contrasena"  maxlength="10"type="password" /></td>
							</tr>
							<tr>
								<td colspan="2" style="color: red">${mensaje}</td>
								
							</tr>
							
								
						</table>
						<hr>
					
						<input type="submit" value="Ingresar"  onclick="return validate();" />
						
					</form>
				</td>

			</tr>

		</table>

	</div>
<jsp:include page="../masterpage/inferior.jsp" />

