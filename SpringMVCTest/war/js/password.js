/*$(document).ready(function() {
 $('input[type=password]').keyup(function() {
 // keyup code
 }).focus(function() {
 $('#pswd_info').show();
 }).blur(function() {
 $('#pswd_info').hide();
 });
 });*/

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
	l/validamos la letra mayuscula
	if ( pswd.match(/[A-Z]/) ) {
	 $('#capital').removeClass('invalid').addClass('valid');
	} else {
	 $('#capital').removeClass('valid').addClass('invalid');
	}
	//validamos el numero
	if ( pswd.match(/d/) ) {
	 $('#number').removeClass('invalid').addClass('valid');
	} else {
	 $('#number').removeClass('valid').addClass('invalid');
	}