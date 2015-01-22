<jsp:include page="../masterpage/superior.jsp" />

<link href="/css/mensajes.css" rel="stylesheet" type="text/css" />
<link href="/css/password.css" rel="stylesheet" type="text/css" />

<script src="/js/jquery.validationEngine-es.js"></script>
<script src="/js/jquery.validationEngine.js"></script>
<script>
	$(document).ready(function() {

	
		    setTimeout(function() {
		        $(".content").fadeOut(2000);},6000);
	
		
		$("#frmUsuario").validationEngine();
		
		
				$('#rol > option[value="${usuario.idRol}"]').attr('selected', 'selected');
				$('#estado > option[value="${usuario.estado}"]').attr('selected', 'selected');
				
				if( $("#matricula").val()==''){
				//	$("#txtmatricula").removeAttr('disabled')
					$("#matricula").prop('readonly', false);

				}
				
				$('input[type=password]').keyup(function() {
					 // declaramos la variable
					 var pswd = $(this).val();
					 // validamos la longitud de carateres
					if ( pswd.length < 8 ) {
					 $('#length').removeClass('valid').addClass('invalid');
					} else {
					 $('#length').removeClass('invalid').addClass('valid');
					}
					// validamos la letra
					if ( pswd.match(/[A-z]/) ) {
					 $('#letter').removeClass('invalid').addClass('valid');
					} else {
					 $('#letter').removeClass('valid').addClass('invalid');
					}
					if ( pswd.match(/\d/) ) {
						 $('#number').removeClass('invalid').addClass('valid');
						 
						} else {
						 $('#number').removeClass('valid').addClass('invalid');
						}
					if ( pswd.match(/[A-Z]/) ) {
						 $('#capital').removeClass('invalid').addClass('valid');
						} else {
						 $('#capital').removeClass('valid').addClass('invalid');
						}
						//validamos el numero
				
				}).focus(function() {
				    $('#pswd_info').show();
				}).blur(function() {
				    $('#pswd_info').hide();
				});
				
				
				
			});

	function grabarA() {

		 if ($('#idUsuario').val() === '') {
		        
				if ($("#frmUsuario").validationEngine('validate')){
					
					var data = $("#frmUsuario").serialize();
					var url = "/usuario/ingresar";
					
								
					$("#frmUsuario").attr("action", url);
					$("#frmUsuario").submit();
				}
		    }
		    else {
		        
		   
		if ($("#frmUsuario").validationEngine('validate')){
			
		var data = $("#frmUsuario").serialize();
		var url = "/usuario/editar";
		
					
		$("#frmUsuario").attr("action", url);
		$("#frmUsuario").submit();
		}
		    }
	}
	

	
	
	
</script>

<div class="cabecera">
	<h2>.:: Mantenimiento de Usuarios</h2>
	<hr>
</div>

<div class="formulario">

	<form id="frmUsuario" action=""  method="POST"	>

		<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idusuario}" />
		<input type="hidden" id="usuarioActual" name="usuarioActual" value="${sesionusuario}">
		<table  width="100%" height="80%" border="0" cellspacing="0" cellpadding="0">
			<tr height="30px">
				<td>&nbsp;</td>
				<td>Matrícula:</td>
				<td><input type="text" name="matricula" id="matricula" value="${usuario.matricula}" class="validate[required]" maxlength="6" readonly="readonly"/></td>
				<td>Correo:</td>
				<td><input type="text" name="correo" id="txtcorreo"	value="${usuario.correo}" class="validate[required,custom[email]]" maxlength="50"/></td>
				<td>Estado:</td>
				<td><select name="estado" id="estado" class="validate[required]">
						<option value="">Seleccione</option>
						<option value="1">Activo</option>
						<option value="2">Inactivo</option>
				</select></td>

				<td>Rol:</td>
				<td><select name="rol" id="rol" class="validate[required]">
						<option value="">Seleccione</option>
						<option value="1">administrador</option>
						<option value="2">consultor</option>
						<option value="3">supervisor</option>
				</select></td>
				<td>&nbsp;</td>
			</tr>
			<tr height="30px">
				<td>&nbsp;</td>
				<td>Apellido Paterno:</td>
				<td><input type="text" name="apPaterno" id="apPaterno" value="${usuario.apellidoPaterno}" class="validate[required]" maxlength="50"/></td>
				<td>Apellido Materno:</td>
				<td><input type="text" name="apMaterno" id="apMaterno" value="${usuario.apellidoMaterno}" class="validate[required]" maxlength="50" /></td>
				<td>Nombres:</td>
				<td><input type="text" name="nombres" id="nombres" value="${usuario.nombres}" class="validate[required]" maxlength="50"/></td>
				<td>&nbsp;</td>
			</tr>

			<tr height="30px">
				<td>&nbsp;</td>
				<td>Contraseña:</td>
				<td><input type="password" name="Contrasena" id="Contrasena" 	class="validate[required]" value="${usuario.contrasena}" maxlength="8"/></td>
				<td>Re-Contraseña:</td>
				<td><input type="password" name="ReContrasena" id="ReContrasena"   class="validate[required,equals[Contrasena]]" value="${usuario.contrasena}" maxlength="8"/></td>
				<td>

				</td>
				<td></td>
				<td>&nbsp;</td>
			</tr>

			<tr height="20px">
				<td>&nbsp;</td>
				<td colspan="8">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr height="40px">
				<td>&nbsp;</td>
				<td colspan="8" style="background-color: #C0C0C0">
				<input	type="button" value="Grabar" onclick="grabarA(); return false;" />
					<input type="reset" name="limpiar" value="Limpiar"></input></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="50">&nbsp;</td>
			</tr>
		</table>

	</form>
<div id="pswd_info">
 <h4>La contase&ntilde;a debe cumplir los siguientes requisitos:</h4>
 <ul>
 <li id="letter" class="invalid">Debe tener al menos <strong>una letra</strong></li>
 <li id="capital" class="invalid">Debe tener al menos <strong>una letra may&uacute;scula</strong></li>
 <li id="number" class="invalid">Debe tener al menos <strong>un n&uacute;mero</strong></li>
 <li id="length" class="invalid">Debe tener al menos <strong>8 caracteres</strong></li>
 </ul>
</div>

</div>
<div  class="content">
		<a>${mensaje}</a>
</div>

<jsp:include page="../masterpage/inferior.jsp" />