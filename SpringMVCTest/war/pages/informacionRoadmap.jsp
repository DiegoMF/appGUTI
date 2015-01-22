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
                <fieldset><legend align="left">Información plan de Roadmap</legend>
                    <table>
                    <tr>
                        <td>Roadmap Corto Plazo:<br> <input tye="text" name="general"></td>
                        
                        <td>Roadmap Largo Plazo: <br><input tye="text" name="general"></td>
                        <td>Estado Atención de Roadmap:<br> <input tye="text" name="general"></td>
                        <td>Fecha inicio planificado:<br> <input tye="text" name="general"></td>
                    </tr>
                    
                    <tr>
                        <td>Fecha de compromiso:<br> <input tye="text" name="general"></td>
                        
                        <td>Roadmap ejecutado actual:<br><input tye="text" name="general"></td>
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
                                <input type= "submit" name="limpiar" value= "Regresar"></input>
                            </td>
                        </tr>                  
                    </table>
            
        </table>
        
    </form>
</div>

    </body>
</html>
