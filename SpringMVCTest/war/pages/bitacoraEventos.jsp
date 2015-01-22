<%-- 
    Document   : bitacoraEventos
    Created on : 30/10/2014, 10:50:03 AM
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
                    <fieldset><legend align="left">Filtro de Eventos</legend>
                    <table>
                    <tr>
                       
                        <td>Fecha de creación:<br><input tye="text" name="fechaCreacion"></td>
                        <td>Usuario de creación:<br><input tye="text" name="usuarioCreacion"></td>
                        <td>Estado: <br><select name="estado">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="activo">Activo</option>
                            <option value="inactivo">Inactivo</option></select></td>

                    </tr>
                    <td>&nbsp;</td>    
                    <table>
                        <tr>
                            <td colspan="8" style="background-color: #C0C0C0">
                                <input type= "submit" name="buscar" value= "Buscar"></input>
                                <input type= "submit" name="limpiar" value= "Limpiar"></input>
                            </td>
                        </tr>                  
                    </table>
                </table>
                </fieldset>
                </td>
            </tr>
            
            <tr>
                <td>
                    <fieldset><legend align="left">Eventos</legend>
                    <table>
                        <tr>
                            <td>&nbsp;</td>
                            <td colspan="8">
                                <table border="1" width="100%">
                                    <thead>
                                        <tr align="center">
                                            <td>#</td>
                                            <td>Fecha de creación</td>
                                            <td>Usuario de creación</td>
                                            <td>Estado</td>
                                            <td>Descripción del evento</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>25/06/2014</td>
                                            <td>s32459</td>
                                            <td>Activo</td>
                                            <td>Descripción 001</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>25/06/2014</td>
                                            <td>s32459</td>
                                            <td>Activo</td>
                                            <td>Descripción 002</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>25/06/2014</td>
                                            <td>s32459</td>
                                            <td>Activo</td>
                                            <td>Descripción 003</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                    </fieldset>
                </td>
            </tr>
            
            
        </table>
        
    </form>
</div>

    </body>
</html>
