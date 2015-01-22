<%-- 
    Document   : informacionPreAtencion
    Created on : 30/10/2014, 09:49:27 AM
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
                <fieldset><legend align="left">Post Atención - Software Base - Estándares Tecnológicos</legend>
                    <table>
                    <tr>
                        <td>Estándar-<br>Sistema <br>Operativo: <br><select name="estandarso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                            <td>Estándar -<br>Sistema Operativo <br>(En caso haber elegido "Otros"): <br><input tye="text" name="general"></td>
                        <td>Estándar -<br>Herramientas <br>de Programación:<br><select name="estandarhp">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td>Estándar-Herramientas de<br> Programación(En caso haber <br>elegido "Otros") :<br><input tye="text" name="general"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Lenguaje de <br>Programación :<br><select name="estandarso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td>Lenguaje de Programación<br> (En caso haber elegido "Otros"): <br><input tye="text" name="general"></td>
                        <td>Estándar-<br>Gestor de Base de Datos :<br><select name="estandarhp">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td>Estándar-Gestor de Base de Datos<br> (En caso haber elegido "Otros"): <br><input tye="text" name="general"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Estándar - <br>Framework :<br><select name="estandarso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td>Estándar - Framework <br>(En caso haber elegido "Otros"): <br><input tye="text" name="general"></td>
                        <td>Observaciones <br>Adicionales :<br><input tye="text" name="general"></td>
                    </tr>
                  
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Post Atención - Lineamiento</legend>
                    <table>
                    <tr>
                        <td>ACCESOS - Gestión de<br> privilegios en los sistemas:<br><input tye="text" name="nombre"></td>
                        <td>ACCESOS - Revisión de<br> los privilegios de los usuarios:<br><input tye="text" name="nombre"></td>
                        <td>ACCESOS - <br>Gestión de contraseñas:<br><input tye="text" name="nombre"></td>
                        <td>ACCESOS - <br>Política de contraseñas:<br><input tye="text" name="nombre"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>ACCESOS - <br>Gestión de claves:<br><br><input tye="text" name="nombre"></td>
                        <td>AUDITORIA - <br>Registro de auditorías:<br><br><input tye="text" name="nombre"></td>
                        <td>AUDITORIA - Protección de<br> los registros de auditoría:<br><br><input tye="text" name="nombre"></td>
                        <td>AUDITORIA - Registro de eventos<br> de los administradores de los sistemas,<br> o administradores de seguridad:<br><input tye="text" name="nombre"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>AUDITORIA -<br> Conformidad con las políticas<br> de seguridad y los estándares:<br><input tye="text" name="nombre"></td>
                        <td>CONTINGENCIA - <br>Contingencia:<br><br><input tye="text" name="nombre"></td>
                        <td>CONTROL DE CAMBIOS - <br>Procedimientos de control de <br>cambios de Software:<br><input tye="text" name="nombre"></td>
                        <td>CONTROL DE CAMBIOS - <br>Procedimientos de control de <br>cambios de Infraestructura:<br><input tye="text" name="nombre"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>DOCUMENTACION - <br>Manejo de <br>documentación:<br> <input tye="text" name="nConsultas"></td>
                        <td>INCIDENTES -<br> Cumplimiento de las políticas<br> de antivirus de la organización:<br> <input tye="text" name="nEntidadesExternas"></td>
                        <td>INCIDENTES - <br>Cumplimiento de los controles <br>contra código malicioso: <br><input tye="text" name="nEntidadesInternas"></td>
                        <td>INCIDENTES - <br>Cumplimiento con las políticas<br> de gestión de parches:<br> <input tye="text" name="observacionesGenerales"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>INTEGRIDAD Y <br>CONFIDENCIALIDAD -<br> Protección de datos de prueba:<br> <input tye="text" name="nConsultas"></td>
                        <td>RESPALDOS - <br>Gestión de respaldo y<br> recuperación:<br> <input tye="text" name="nEntidadesExternas"></td>
                    </tr>
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Post Atención - Cumplimiento de Lineamientos</legend>
                    <table>
                    <tr>
                        <td>&nbsp;</td>
                            <td colspan="8">
                                <table border="1" width="100%">
                                    <thead>
                                        <tr align="center">
                                            <td>#</td>
                                            <td>Nombre de Lineamiento</td>
                                            <td>% del Nivel de Cumplimiento</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Lineamiento 001</td>
                                            <td>Porcentaje 001</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Lineamiento 002</td>
                                            <td>Porcentaje 002</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Lineamiento 003</td>
                                            <td>Porcentaje 003</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </td>
                    </tr>                  
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Post Atención - Cumplimiento de Estándares</legend>
                    <table>
                    <tr>
                        <td>&nbsp;</td>
                            <td colspan="8">
                                <table border="1" width="100%">
                                    <thead>
                                        <tr align="center">
                                            <td>#</td>
                                            <td>Nombre de Estándar</td>
                                            <td>% del Nivel de Cumplimiento</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Estándar 001</td>
                                            <td>Porcentaje 001</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Estándar 002</td>
                                            <td>Porcentaje 002</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Estándar 003</td>
                                            <td>Porcentaje 003</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </td>
                    </tr>                  
                </table>
                </fieldset>
                </td>
            </tr>
            
            
            <td>&nbsp;</td>    
                    <table>
                        <tr>
                            <td colspan="8" style="background-color: #C0C0C0">
                                <input type= "submit" name="calcular" value= "Calcular"></input>
                                <input type= "submit" name="verGrafico" value= "Ver Gráfico"></input>
                                <input type= "submit" name="exportar" value= "Exportar"></input>
                                <input type= "submit" name="guardar" value= "Guardar"></input>
                            </td>
                        </tr>                  
                    </table>
            
        </table>
        
    </form>
</div>

    </body>
</html>
