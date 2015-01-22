/**
 * Función que inicializa nuestra pantalla
 * @return
 */
function carga() {
	$("#j_username").focus();
}

/**
 * Función que valida si los datos ingresados en la forma son correctos
 * @return true si los datos son correctos, false si hay datos requeridos nulos
 */
function validate() {
	user = $("#txtmatricula");
	password = $("#txtpassword");
	if(user.val() == '') {
		alert("Ingresa el usuario");
		user.focus();
		return false;
	} else if(password.val() == '') {
		alert("Ingresa la contraseña");
		password.focus();
		return false;
	} else {
		return true;
	}
}

function showError(error) {
	alert(error);
	if(error == 'null' || error == "null" || error == null) {
		return;
	}
	limite = 0;
	while(error.length > limite) {
		for(var i = 0; i < 100; i++) {
			document.write(error.charAt(limite));
			limite++;
			if(limite >= error.length) {
				break;
			}
		}
		document.write("<br>");
	}
}