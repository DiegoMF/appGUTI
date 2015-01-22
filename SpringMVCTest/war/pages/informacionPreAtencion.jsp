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
                <fieldset><legend align="left">Pre Atención - Software Base - Estándares Tecnológicos</legend>
                    <table>
                        
                    <tr>
                        <td>Estándar-Sistema Operativo:</td>
                        <td><select name="estandarso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td><input tye="text" name="general"   readonly></td>
                    </tr>
                    <tr>
                        <td>Estándar - Herramientas de Programación :</td>
                        <td><select name="estandarhp">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td><input tye="text" name="general"></td>
                    </tr>
                    <tr>
                        <td>Lenguaje de Programación:</td>
                        <td><select name="estandarso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td><input tye="text" name="general"></td>
                    </tr>
                    <tr>
                        <td>Estándar - Gestor de Base de Datos:</td>
                        <td><select name="estandarhp">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td><input tye="text" name="general"></td>
                    </tr>
                    <tr>
                        <td>Estándar - Framework: </td>
                        <td> <select name="estandarso">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="otros">Otros</option></select></td>
                        <td><input tye="text" name="general"></td>
                        
                    </tr>
                    
                    
                    <tr>
                        <td>ObservacionesAdicionales: </td><td><input tye="text" name="general"></td>
                    </tr>
                    
                 
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Pre Atención - Lineamiento</legend>
                    <table>
                    <tr>
                        <td>ACCESOS - Gestión de privilegios en los sistemas:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>ACCESOS - Revisión de los privilegios de los usuarios:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>ACCESOS - Gestión de contraseñas:</td>
                        <td> <input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>ACCESOS - Política de contraseñas:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>ACCESOS - Gestión de claves:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>AUDITORIA - Registro de auditorías:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>AUDITORIA - Protección de los registros de auditoría:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>AUDITORIA - Registro de eventos de los administradores de los sistemas, o administradores de seguridad:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>AUDITORIA - Conformidad con las políticas de seguridad y los estándares:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>CONTINGENCIA - Contingencia:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>CONTROL DE CAMBIOS - Procedimientos de control de cambios de Software:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>CONTROL DE CAMBIOS - Procedimientos de control de cambios de Infraestructura:</td>
                        <td><input tye="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>DOCUMENTACION - Manejo de documentación:</td>
                        <td><input tye="text" name="nConsultas"></td>
                    </tr>
                    <tr>
                        <td>INCIDENTES - Cumplimiento de las políticas de antivirus de la organización:</td>
                        <td><input tye="text" name="nEntidadesExternas"></td>
                    </tr>
                    <tr>
                        <td>INCIDENTES - Cumplimiento de los controles contra código malicioso: </td>
                        <td><input tye="text" name="nEntidadesInternas"></td>
                    </tr>
                    <tr>
                        <td>INCIDENTES - Cumplimiento con las políticas de gestión de parches:</td>
                        <td><input tye="text" name="observacionesGenerales"></td>
                    </tr>
                    <tr>
                        <td>INTEGRIDAD Y CONFIDENCIALIDAD - Protección de datos de prueba:</td>
                        <td><input tye="text" name="nConsultas"></td>
                    </tr>
                    <tr>
                        <td>RESPALDOS - Gestión de respaldo y recuperación:</td>
                        <td><input tye="text" name="nEntidadesExternas"></td>
                    </tr>
                </table>
                </fieldset>
                </td>
            </tr>
            
            <tr>
                <td>
                <fieldset><legend align="left">Pre Atención - Cumplimiento de Lineamientos</legend>
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
                <fieldset><legend align="left">Pre Atención - Cumplimiento de Estándares</legend>
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
                                <input type= "submit" name="verGracfico" value= "Ver gráfico"></input>
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
