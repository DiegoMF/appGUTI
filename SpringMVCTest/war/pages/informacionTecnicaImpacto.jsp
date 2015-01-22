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
                <fieldset><legend align="left">Características Técnicas</legend>
                    <table>
                    <tr>
                        <td>Categoría Tecnológica:<br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Otros</option></select></td>
                        <td>Categoría Tecnológica(Otros):<br> <input tye="text" name="general"></td>
                        <td>Tipo de desarrollo: <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Tipo</option></select></td>
                        <td>Ubicación Física: <br><input tye="text" name="general"></td>
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Ambiente AppNoIT:<br> <select name="area">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="area">Otros</option></select></td>
                       <td>Ambiente AppNoIT (otros):<br> <input tye="text" name="division"></td>
                       <td>Nombre de la Ubicación: <br><input tye="text" name="general"></td>
                       <td>Infraestructura de la aplicación: <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Infraestructura</option></select></td>
        
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>¿La solución es <br>stand alone?:<br><br> <select name="area">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="area">Si</option>
                            <option value="area">No</option></select></td>
                       <td>¿Cuántas interfaces tienen con otras<br> aplicaciones,servicios web, servicios en host,<br> sistemas BD externas, DWH?:<br> <input tye="text" name="division"></td>
                       <td>¿Cuáles son esas <br>interfaces?<br> <br><input tye="text" name="general"></td>
                       <td>¿Quién da mantenimiento a<br> la aplicación?:<br> <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Proveedor</option></select></td>
        
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                       <td>¿Quién da mantenimiento<br> a la aplicación?: <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Proveedor</option></select></td>
                        <td>Si seleccionó el proveedor, indicar<br> el nombre del proveedor:<br> <input tye="text" name="division"></td>
                       <td>¿Quién realiza el soporte a <br>la aplicación?: <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Proveedor</option></select></td>
                        <td>Si seleccionó el proveedor, indicar<br> el nombre del proveedor:<br> <input tye="text" name="division"></td>
        
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                      <td>¿Quién brinda los accesos<br> a la aplicación?: <br><select name="unidad">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="unidad">Proveedor</option></select></td>
                        <td>Si seleccionó el proveedor, indicar<br> el nombre del proveedor:<br> <input tye="text" name="division"></td>
                       <td>Nombre del<br> servidor: <br><input tye="text" name="general"></td>
                       <td>Ubicación del<br> servidor:<br> <input tye="text" name="division"></td>
        
                    </tr>
                  
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Datamart</legend>
                    <table>
                    <tr>
                        <td>Nombre<br> Datamart:<br><input tye="text" name="nombre"></td>
                        <td>¿Cuántas tablas<br> tiene?:<br><input tye="text" name="descripción"></td>
                        <td>¿Cuántas tablas descriptivas <br>(lookups) tiene?:<br><input tye="text" name="descripción"></td>
                        <td>¿Cuántas tablas de<br> hechos (facts) tiene?:<br><input tye="text" name="descripción"></td> 
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Herramientas de explotación <br>que utiliza:<br><input tye="text" name="nombre"></td>
                        <td>Herramientas de explotación que utiliza<br> (en caso de haber elegido "Otros")<br><input tye="text" name="descripción"></td>
                        <td>¿Cuántos reportes <br>genera?:<br><input tye="text" name="descripción"></td>
                        <td>¿Cuántos usuarios<br> tienen accesos?:<br><input tye="text" name="descripción"></td>
                     </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Frecuencia:<br><input tye="text" name="descripción"></td>
                        <td>Cantidad de espacio en tablespace:<br><input tye="text" name="descripción"></td>
                
                    </tr>
                    
                </table>
                </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                <fieldset><legend align="left">Impactos</legend>
                    <table>
                    <tr>
                        <td>Impacto Financiero:<br><input tye="text" name="nombre"></td>
                        <td>Rentabilidad:<br><input tye="text" name="descripción"></td>
                        <td>Impacto en la imagen:<br><input tye="text" name="descripción"></td>
                        <td>Impacto en los clientes:<br><input tye="text" name="descripción"></td>
         
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Impacto Operativo:<br><input tye="text" name="nombre"></td>
                        <td>Impacto Legal:<br><input tye="text" name="descripción"></td>
                        <td>Proceso de Auditoría:<br><input tye="text" name="descripción"></td>
                        <td>¿Toca algún proceso clave?:<br><input tye="text" name="descripción"></td>
         
                    </tr>
                    <td>&nbsp;</td>
                    <tr>
                        <td>Indicar Proceso <br>Clave:<br><input tye="text" name="nombre"></td>
                        <td>En caso de haber elegido<br> "Otros" indicar proceso clave:<br><input tye="text" name="descripción"></td>
                        <td>Actividad:<br><br><input tye="text" name="descripción"></td>
                        <td>Categoría<br> tecnológica:<br><input tye="text" name="descripción"></td>
         
                    </tr> 
                    <td>&nbsp;</td>
                    <tr>
                        <td>Nivel de criticidad:<br><input tye="text" name="nombre"></td>
                       
                    </tr> 
                </table>
                </fieldset>
                </td>
            </tr>
            
            
                  
                </table>
                </fieldset>
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