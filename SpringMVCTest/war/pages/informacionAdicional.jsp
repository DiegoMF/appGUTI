<%-- 
    Document   : informacionAdicional
    Created on : 30/10/2014, 10:49:10 AM
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
                <fieldset><legend align="left">Seguridad de la Información</legend>
                    <table>
                    <tr>
                        <td>Evaluación con Seguridad<br> Informática:<br><input tye="text" name="general"></td>
                        <td>Nivel de Exposición al <br>Riesgo(USD):<br><input tye="text" name="general"></td>
                    </tr>
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Características Particulares</legend>
                    <table>
                    <tr>
                        <td>Escenario de<br> Autenticación <br>de Ingreso(Logueo):<br><input tye="text" name="nombre"></td>
                        <td>Impacto en Protección<br> de Datos (Prioridad):<br><input tye="text" name="nombre"></td>
                        <td>Impacto en Protección de Datos (Prioridad)<br> Identificadas en levantamiento de información<br> del área de Cumplimiento Normativo:<br><input tye="text" name="nombre"></td>
                    </tr>
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Fuente de Origen</legend>
                <table>
                    <tr>
                        <td>Fuente:<br><input tye="text" name="nombre"></td>
                        <td>Fecha/Periodo:<br><input tye="text" name="nombre"></td>
                    </tr>                 
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Histórico de Actualizaciones</legend>
                <table>
                    <tr>
                        <td>Fecha de última<br> actualización:<br><input tye="text" name="nombre"></td>
                        <td>Grupo actualizado:<br><br><input tye="text" name="nombre"></td>
                        <td>Campo actualizado:<br><br><input tye="text" name="nombre"></td>
                        <td>Detalle de actualización:<br><br><input tye="text" name="nombre"></td>
                    
                    </tr>                 
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Otros</legend>
                <table>
                    <tr>
                        <td>Fecha 1:<br><input tye="text" name="nombre"></td>
                        <td>Fecha 2:<br><input tye="text" name="nombre"></td>
                        <td>Texto 1:<br><input tye="text" name="nombre"></td>
                        <td>Texto2:<br><input tye="text" name="nombre"></td>
                    
                    </tr>
                    <td>&nbsp;</td>  
                    <tr>
                        <td>Texto 3:<br><input tye="text" name="nombre"></td>
                        <td>Número 1:<br><input tye="text" name="nombre"></td>
                        <td>Número 2:<br><input tye="text" name="nombre"></td>
                        <td>Número 3:<br><input tye="text" name="nombre"></td>
                    </tr> 
                    <td>&nbsp;</td>  
                    <tr>
                        <td>Monto 1:<br><input tye="text" name="nombre"></td>
                        <td>Monto 2:<br><input tye="text" name="nombre"></td>
                    </tr>  
                </table>
                </fieldset>
                </td>
            </tr>
            <td>&nbsp;</td>    
                    <table>
                        <tr>
                            <td colspan="8" style="background-color: #C0C0C0">
                                <input type= "submit" name="grabar" value= "Grabar"></input>
                                <input type= "submit" name="regresar" value= "Regresar"></input>
                            </td>
                        </tr>                  
                    </table>
            
        </table>
        
    </form>
</div>

    </body>
</html>
