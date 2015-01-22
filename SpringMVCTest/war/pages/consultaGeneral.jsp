<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<jsp:include page="../masterpage/superior.jsp" />

<script>

$(document).ready(function(){ 
	

	
});
function buscar() {
	
	
	var url = "/aplicacionEspecializada/buscar";
	var data = $("#consultaGeneral").serialize();
    $.post(url,data, function(resultado){  
        $("#divListaConsultaGeneral").html(resultado);
        
    });  
	
	           
}

function exportar() {
	
	
	var url = "/aplicacionEspecializada/ExportarConsultaGeneral";
	var data = $("#consultaGeneral").serialize();
	$("#consultaGeneral").attr("action", url);
	$("#consultaGeneral").submit();
		           
}


function verdetalle(idusuario){
	
	var data = $("#formusuario").serialize();
	var url = "/aplicacionEspecializada/load";
	
	$("#idusuario").val(idusuario);
	
	$("#consultaGeneral").attr("action", url);
	$("#consultaGeneral").submit();
}

function eliminar(idAplicacion){
	
	$( "#divEliminarUsuario" ).dialog({
        height: 'auto',
        modal: true,
        buttons: {
            "Si": function() {
            	var url = "/aplicacionEspecializada/elimina";
            	var data = {"idAplicacion":idAplicacion};
            	
            	$.post(url,data, function(){  
            		buscar();	        	            
    	        });  
            	
            	$( this ).dialog( "close" );
            	
            },
            "No": function() {
                $( this ).dialog( "close" );
            }
        }
    });
	
			
}

			

</script>

<div class="cabecera">
	<h2>.:: Consulta General</h2>
	<hr>
</div>

<div class="formulario">
    
    	<form method="POST" action="<c:url value="/aplicacionEspecializada/buscar"/>" id="consultaGeneral">
        <table bgcolor="#FFFFFF" width="100%" height="80%" border="0" cellspacing="0" cellpadding="0">
            
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Código de Aplicación</td>
                <td><input type="text" name="codigoAplicacion" id="txtCodigoAplicacion"/> </td>
                <td>Nivel de cumplimiento:</td>
                <td><input type="text" name="nivelCumplimiento" id="txtNivelCumplimiento" /> </td>
                <td>Estado:</td>
                <td> 
                    <select name="estadoAplicacion" id=estadoAplicacion>
                        <option value="0">Seleccione</option>
                        <option value="1">Vigente</option>
                        <option value="2">No vigente</option>
                        <option value="3">En desarrollo</option>
                    </select>
                </td>
            </tr>
            <td>&nbsp;</td>
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Estado de Atención de Roadmap:</td>
                <td> 
                      <select name="estadoRoadmap" id="estadoRoadmap">
                        <option value="0">Seleccione</option>
                        <option value="1">En proceso</option>
                        <option value="2">Pendiente de planificación</option>
                        <option value="4">Cerrado</option>
                        <option value="3">Eliminado Administrativamente</option>
                        
                    </select>
                </td>
                <td>Nombre de Aplicación:</td>
                <td><input type="text" name="nombreAplicacion" id="txtNombreAplicacion"/> </td>
                <td>Post Atención Nivel de Cumplimiento:</td>
                <td><input type="text" name="postAtencionNivelCumplimiento" id="txtPostAtencion" /> </td>
                
            </tr>
        
            
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Clasificación:</td>
                <td> 
                    <select name="clasificacion" id="clasificacion">
                        <option value="0">Seleccione</option>
                        <option value="1">Público</option>
                        <option value="2">Restringido</option>
                        <option value="3">Uso interno</option>
                        <option value="4">#N/A</option>
                        <option value="5">Unidad levantada con plantilla antigua</option>
                    </select>
                    
                </td>
                <td>Criticidad Final:</td>
                <td> 
                    <select name="criticidadFinal" id="clasificacion">
                         <option value="0">Seleccione</option>
                        <option value="1">Crítico</option>
                        <option value="2">No crítico</option>
                    </select>
                    
                </td>
                <td>¿Toca algún proceso clave?: </td>
                <!--   <input name="procesoClave" type="radio" value="Si"/>Si
                <input name="procesoClave" type="radio" value="No"/>No -->
                <td>
                <select name="procesoClave" id="procesoClave">
                        <option value="0">Seleccione</option>
                        <option value="1">Si</option>
                        <option value="2">No</option>
                    </select>
                </td>
              
                
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0">
                <input	type="button" value="Buscar" onclick="buscar(); return false;" />
                    
                    <input type= "reset" name="limpiar" value= "Limpiar"></input>
		</td>
                <td>&nbsp;</td>
            </tr>
            <td>&nbsp;</td>
            <tr>
                <td>&nbsp;</td>
                <td colspan="8">
                <div id="divListaConsultaGeneral">
                    <table border="1" width="100%" class="tablaGrilla">
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
                                <td><a href="/aplicacionEspecializada/verDetalle&ID_APLICACION_ESPECIALIZADA=${listValue.idAplicacion}&ID_VERSION=${listValue.idVersion}">Ver</a>
                                <a href="#"	onclick="eliminar(${listValue.idAplicacion});">Eliminar</a>
                                </td>
                            
                                
                            </tr>
                          </c:forEach>
                                

                        </tbody>
                        <tr><td colspan="11"><a style="color: red">${mesajeInfo}</a></td></tr>
                    </table>
                   </div>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0" align="right">
                    <input	type="button" value="Exportar" onclick="exportar(); return false;" />
                <td>&nbsp;</td>
            </tr>
            <tr>
               <td colspan="50">&nbsp;</td>
            </tr>
        </table>
    </form>
</div>




<div id="divEliminarUsuario" style="display: none;" title="Confirmación">
    ¿Estás seguro de eliminar la aplicación?
</div>

<div id="divMensaje" style="display: none;" title="BCP - Gestion de Portafolio">
    <p><label id="lblMensaje"></label></p>
</div>
<jsp:include page="../masterpage/inferior.jsp" />