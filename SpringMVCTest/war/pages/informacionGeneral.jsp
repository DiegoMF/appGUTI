<%-- 
    Document   : informacionGeneral
    Created on : 29/10/2014, 03:27:53 PM
    Author     : fbelesbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
<div class="formulario">
    <form>
        <table>
            <tr>
                <td>
                <fieldset><legend align="left">Estructura Organizacional</legend>
                    <table>
                    <tr>
                        <td>Gerencia Central:<br> <input tye="text" name="general"></td>
                        <td>Unidad: <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Unidad</option></select></td>
                        <td>Código FNA: <br><input tye="text" name="general"></td>
                        <td>Código Aplicación:<br> <input tye="text" name="general"></td>
                    </tr>
                    
                    <tr>
                        <td>División:<br> <input tye="text" name="division"></td>
                        <td>Área:<br> <select name="area">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="area">Área</option></select></td>
                    </tr>
                  
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Información General</legend>
                    <table>
                    <tr>
                        <td>Nombre:<br><input tye="text" name="nombre"></td>
                        <td>Descripción:<br><input tye="text" name="descripción"></td>
                        <td>Funcionalidades:<br><select name="funcionalidades">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="funcionalidad">Funcionalidad</option></select></td>
                        <td>Fecha de Creación:<br><input tye="date" name="general"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Estado:<br><br><select name="estado">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Estado</option></select></td>
                        <td>Tipo de operaciones<br> que procesa:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Tipo</option></select></td>
                        <td>Frecuencia de las operaciones que procesa:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Frecuencia</option></select></td>
                        <td>Cantidad de<br> operaciones:<br><select name="cantidadOperaciones">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="cantidad">Cantidad</option></select></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Motivo de<br> creación:<br><select name="mCreacion">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="motivo">Motivo</option>
                            <option value="otros">Otros</option></select></td>
                        <td>Motivo de Creación<br>(Otros):<br><input tye="text" name="mCreaciónOtros"></td>
                        <td>N° de funcionalidades transaccionales: <br><input tye="text" name="funcionalidadesTransaccionales"></td>
                        <td>N°<br> de reportes:<br> <input tye="text" name="nReportes"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>N° de Consultas:<br> <input tye="text" name="nConsultas"></td>
                        <td>N° de Entidades Externas:<br> <input tye="text" name="nEntidadesExternas"></td>
                        <td>N° de Entidades Internas: <br><input tye="text" name="nEntidadesInternas"></td>
                        <td>Observaciones Generales:<br> <input tye="text" name="observacionesGenerales"></td>
                    </tr>
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Funcionalidad</legend>
                    <table>
                    <tr>
                        <td>Funcionalidad:<br><select name="funcionalidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Funcionalidad</option></select></td>
                        <td>Datos de Entrada:<br><select name="datosEntrada">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Dato</option></select></td>
                        <td>Proceso:<br><select name="proceso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Proceso</option></select></td>
                        <td>Salida:<br><select name="salida">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="cantidad">Salida</option></select></td>
                    </tr>                  
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Dominio</legend>
                    <table>
                    <tr>
                        <td>Front User- Lider usuario de la aplicación:<br><select name="fuser">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Front-User</option></select></td>
                        <td>Gestor de aplicaciones de Usuario TI:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Gestor</option></select></td>
                        <td>Especialista de la aplicacion de Usuarios TI:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Especialista</option></select></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Broker de Negocio:<br><select name="estado">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Broker</option></select></td>
                        <td>Broker de Sistemas:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Broker</option></select></td>
                        <td>Asesor GUTI:<br><select name="asesor">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Asesor</option></select></td>
                        
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Dominio:<br><select name="dominio">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Dominio</option></select></td>
                        <td>Subdominio:<br><select name="subdominio">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Subdominio</option></select></td>
                        
                        <td>¿Cuántas unidades utilizan la aplicación?:<br> <input tye="text" name="nConsultas"></td>
                        <td>¿Cuántos usuarios utilizan la aplicación EN TOTAL?:<br> <input tye="text" name="nConsultas"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Nombre de la unidad 1:<br> <input tye="text" name="nConsultas"></td>
                        <td>Nombre de la unidad 2:<br> <input tye="text" name="nConsultas"></td>
                        <td>Nombre de la unidad 3:<br> <input tye="text" name="nConsultas"></td>
                        <td>Proceso de Auditoría:<br><select name="procesoAuditoria">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="proceso">Proceso</option>
                            <option value="otros">Otros</option></select></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Procesos de Auditoría(En caso haber elegido "Otros":<br> <input tye="text" name="procesoAuditoriaOtros"></td>
                        <td>¿Toca algún proceso clave:?<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="si">Si</option>
                            <option value="no">No</option></select></td>
                        <td>Indicar Proceso Clave:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="proceso">Proceso</option>
                            <option value="otros">Otros</option></select></td>
                        <td>Procesos Clave (En caso haber elegido "Otros":<br> <input tye="text" name="procesoClaveOtros"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        
                        <td>Entidades Usuarias:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Entidad</option></select></td>
                        <td>Especialista de la aplicación de Usuarios TI:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Especialista</option></select></td>
                        <td>Gestor de aplicaciones de Usuarios TI:<br><select name="cantidadOperaciones">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="cantidad">Gestor</option></select></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Actividad:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Actividad</option></select></td>
                        <td>Relación con CIF:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Relación</option></select></td>
                        <td>¿Toca algún proceso clave?:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Si</option>
                            <option value="frecuencia">No</option></select></td>
                    </tr>
            </tr>
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Clasificación de Activos</legend>
                    <table>
                    <tr>
                        <td>Confidencialidad:<br><select name="estado">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Confidencialidad</option></select></td>
                        <td>Integridad:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Integridad</option></select></td>
                        <td>Disponibilidad:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Disponibilidad</option></select></td>
                        <td>Privacidad:<br><select name="cantidadOperaciones">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="cantidad">Privacidad</option></select></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Clasificación:<br><select name="estado">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="estado">Clasificación</option></select></td>
                        <td>Observación:<br><select name="tOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="tipo">Observación</option></select></td>
                        <td>Criticidad Final:<br><select name="fOperacionProcesa">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="frecuencia">Criticidad</option></select></td>
                        <td>Estado de Revision de las Aplicaciones:<br><select name="cantidadOperaciones">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="cantidad">Estado</option></select></td>
                    </tr> 
                </table>
                </fieldset>
                </td>
            </tr>
            <td>&nbsp;</td>    
                    <table>
                        <tr>
                            <td colspan="8" style="background-color: #C0C0C0">
                                <input type= "submit" name="grabar" value= "Nuevo"></input>
                                <input type= "submit" name="limpiar" value= "Buscar"></input>
                                <input type= "submit" name="grabar" value= "Grabar"></input>
                                <input type= "submit" name="limpiar" value= "Eliminar"></input>
                                <input type= "submit" name="limpiar" value= "Regresar"></input>
                            </td>
                        </tr>                  
                    </table>
            
        </table>
        
    </form>
</div>

    </body>
</html>
