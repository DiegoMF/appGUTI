var _ModalPopupBackgroundID = 'backgroundPopup_XYZ_20110418_Custom';

function MensajeError(codigo) {
    var msg = document.getElementById(codigo);
    jQuery.flash.error(codigo, (msg != null) ? msg.value : "");
}

function MensajeAdvertencia(codigo) {
    var msg = document.getElementById(codigo);
    jQuery.flash.warn(codigo, (msg != null) ? msg.value : "");
}

function MensajeInformacion(codigo) {
    var msg = document.getElementById(codigo);
    jQuery.flash.success(codigo, (msg != null) ? msg.value : "");
}

var TipoSeguimiento = { "error": 0, "warn": 1, "logs": 2 };

function Seguimiento(valor, tipo, validar) {
    if (window.console) {
        var EscribeConsola = (validar) ? validar : document.getElementById('EscribeConsola'); ;

        if (EscribeConsola == "true" || EscribeConsola.value == "true") {
            switch (tipo) {
                case TipoSeguimiento.error:
                    console.error(valor);
                    break;
                case TipoSeguimiento.warn:
                    console.warn(valor);
                    break;
                case TipoSeguimiento.logs:
                    console.log(valor);
                    break;
                default:
                    console.info(valor);
            }
        }
    }
}

function ShowModalPopup(modalPopupId) {
    var isIe6 = (navigator.appVersion.toLowerCase().indexOf('msie 6') > 0);
    var popupId = "#" + modalPopupId;
    var popupMarginTop = $(popupId).height() / 2;
    var popupMarginLeft = $(popupId).width() / 2;
    $(popupId).css({'left': '50%','z-index': 9999});
    if (isIe6) {
            $(popupId).css({
            'top': $(document).scrollTop(),
            'margin-top': $(window).height() / 2 - popupMarginTop,
            'margin-left': -popupMarginLeft,
            'display': 'block',
            'position': 'absolute'
        });
        ReplaceSelectsWithSpans();
    }
    else {
        $(popupId).css({
            'top': '50%',
            'margin-top': -popupMarginTop,
            'margin-left': -popupMarginLeft,
            'display': 'block',
            'position': 'fixed'
        });
    }
    var backgroundSelector = $('<div id="' + _ModalPopupBackgroundID + '" ></div>');
    backgroundSelector.appendTo('body');
    backgroundSelector.css({
        'width': $(document).width(),
        'height': $(document).height(),
        'display': 'none',
        'background-color': '#555555',
        'position': 'absolute',
        'top': 0,
        'left': 0,
        'z-index': 9990
    });

    backgroundSelector.fadeTo('fast', 0.8);
}
function HideModalPopup(modalPopupId) {
    var isIe6 = (navigator.appVersion.toLowerCase().indexOf('msie 6') > 0);
    $("#" + modalPopupId).css('display', 'none');
    $("#" + _ModalPopupBackgroundID).remove();
    if (isIe6) {
        RemoveSelectSpans();
    }
}
function ReplaceSelectsWithSpans() {
    var selects = document.getElementsByTagName('select');
    for (var i = 0; i < selects.length; i++) {
        var select = selects[i];
        $(select).addClass("selectHidden");
    }
}
function RemoveSelectSpans() {
    var selects = document.getElementsByTagName('select');

    for (var i = 0; i < selects.length; i++) {
        var select = selects[i];
        $(select).removeClass("selectHidden");
    }
}


jQuery.Flash = function (element) {
    this.element = $(element);
    this.timeout = undefined;
    var content = $('<div class="yui-t1 doc4" style="padding: 20px"></div>');

    content.append('<div style="float: left;padding: 20px 10px 20px 0px;"><i id="B296-32F456740905" class=""></i><div>');

    content.append('<span class="yui-b"><label></label></span>');
    content.append('<span class="yui-main"><div class="yui-b"><span></span></span></span>');
    content.append('<span style="clear: both;">  </div>');

    this.element.hide()
        .click(function () { jQuery.flash.hide(); })
        .hover(function () { jQuery.flash.onOver(); }, function () { jQuery.flash.onLeave(); })
        .append(content);
};

jQuery.Flash.version = 1.1;

jQuery.Flash.prototype.onOver = function () {
    this.element.addClass('over');
};

jQuery.Flash.prototype.onLeave = function () {
    this.element.removeClass('over');

    if (this.element.hasClass('expired')) this.hide();
};

jQuery.Flash.prototype.onTimeout = function () {
    this.element.addClass('expired');
    if (!this.element.hasClass('over')) this.hide();
};

jQuery.Flash.prototype.show = function () {
    this.element.fadeIn(500);
    if (this.element.hasClass('error'))
        this.timeout = window.setTimeout(function () { jQuery.flash.onTimeout(); }, 10000);
    else
        this.timeout = window.setTimeout(function () { jQuery.flash.onTimeout(); }, 7000);
};

jQuery.Flash.prototype.hide = function () {
    if (this.timeout) {
        clearTimeout(this.timeout);
        this.timeout = undefined;
    }

    this.element.fadeOut(500).removeClass('expired').removeClass('over');
};

jQuery.Flash.prototype.ocultar = function () {
    if (this.timeout) {
        clearTimeout(this.timeout);
        this.timeout = undefined;
    }

    this.element.fadeOut(500).removeClass('expired').removeClass('over');
};

jQuery.Flash.prototype.message = function (klass, label, message) {
    this.element.removeClass('expired');

    $("#B296-32F456740905").addClass("fa " + ObtenerIcono(klass) + " fa-2x");

    if (this.element.is(":visible")) {
        if (this.timeout) {
            clearTimeout(this.timeout);
            this.timeout = undefined;
        }

        this.element.fadeOut(500, function () { jQuery.flash.message(klass, label, message); });
        return;
    }

    this.element.attr('class', klass);
    this.element.find('.yui-b span').text(message);
    this.element.find('.yui-b label').text(label);

    this.show();
};

function ObtenerIcono(tipoAlerta) {
    switch (tipoAlerta) {
        case 'subtle':
            return "fa-comments-o";
        case 'error':
            return "fa-times-circle";
        case 'failure':
            return "fa-ban";
        case 'warning':
            return "fa-exclamation-triangle";
        case 'information':
            return "fa-info-circle";
        case 'success':
            return "fa-check-circle";
        default:
            return "fa-check";
    }
}

jQuery.Flash.prototype.subtle = function (label, message) { this.message('subtle', label, message); };
jQuery.Flash.prototype.error = function (label, message) { this.message('error', label, message); };
jQuery.Flash.prototype.failure = function (label, message) { this.message('failure', label, message); };
jQuery.Flash.prototype.fail = function (label, message) { this.message('failure', label, message); };
jQuery.Flash.prototype.warning = function (label, message) { this.message('warning', label, message); };
jQuery.Flash.prototype.warn = function (label, message) { this.message('warning', label, message); };
jQuery.Flash.prototype.information = function (label, message) { this.message('information', label, message); };
jQuery.Flash.prototype.info = function (label, message) { this.message('information', label, message); };
jQuery.Flash.prototype.success = function (label, message) { this.message('success', label, message); };

$(function () { jQuery.flash = new jQuery.Flash('#flash'); });
$(document).ready(CargaInicialClasesJqueryFlash);

function CargaInicialClasesJqueryFlash() {
    $('#btnImgSalir').click(function () {
        var r = window.confirm("¿Esta seguro de Salir?", "Salir");
        if (r == true) {
            CerrarVentana();
        } 
    });
    CargaClasesJqueryFlash();
}

function CargaClasesJqueryFlash() {
}


/* Creación: [27/04/2014] - Guillermo Ponce Contreras - TCS
*  Función : Cambia el contenido del control a mayusculas */
function Mayusculas(control) {
    control.value = control.value.toUpperCase();
}

/* Creación: [12/08/2014] - Guillermo Ponce Contreras - TCS
*  Función : Valida que se ingerse solo números  */
function ValidaNumeros() {
    if (event.keyCode < 48 || event.keyCode > 57)
        event.returnValue = false;
}

/* Creación: [12/08/2014] - Dajsé Céspedes Salas - TCS
*  Función : Elimina todos los caracteres que no sean números  */
function RescatarNumeros(control) {
    var outputVal = control.value.replace(/[^0-9]/g, "");
    if (control.value != outputVal) {
        control.value = outputVal;
    }
}

/* Creación: [03/04/2014] - Gilmar Zapana Mansilla - TCS
*  Función : Obtiene si la fecha en formato dd/mm/aaaa es válida. Toma en cuenta años bisiestos */
function EsFechaValida(fecha) {
    var dia = parseInt(fecha.substring(0, 2), 10);
    var mes = parseInt(fecha.substring(3, 5), 10);
    var anho = parseInt(fecha.substring(6, 10), 10);

    return mes > 0 && mes < 13 && anho > 0 && anho < 32768 && dia > 0 && dia <= (new Date(anho, mes, 0)).getDate();
}