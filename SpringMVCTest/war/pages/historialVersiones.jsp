<%-- 
    Document   : historialVersiones
    Created on : 30/10/2014, 10:49:53 AM
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
                    <fieldset><legend align="left">Filtro de Versiones</legend>
                    <table>
                    <tr>
                        <td>Código de versión:<br><input tye="text" name="codigoVersion"></td>
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
                    <fieldset><legend align="left">Versiones</legend>
                    <table>
                        <tr>
                            <td>&nbsp;</td>
                            <td colspan="8">
                                <table border="1" width="100%">
                                    <thead>
                                        <tr align="center">
                                            <td>#</td>
                                            <td>Código de versión</td>
                                            <td>Fecha de creación</td>
                                            <td>Usuario de creación</td>
                                            <td>Motivo de creación</td>
                                            <td>Estado</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Código 001</td>
                                            <td>25/06/2014</td>
                                            <td>s32459</td>
                                            <td>Motivo 001</td>
                                            <td>Activo</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Código 002</td>
                                            <td>25/06/2014</td>
                                            <td>s32459</td>
                                            <td>Motivo 002</td>
                                            <td>Activo</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Código 003</td>
                                            <td>25/06/2014</td>
                                            <td>s32459</td>
                                            <td>Motivo 003</td>
                                            <td>Activo</td>
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
