<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Reporte General</h2>
    <form>
        <tr>
        <table>
            <td>
                <fieldset><legend align="left">Filtros del Reporte</legend>
                <table>
                    <tr>
                        <td>Unidad:</td>
                        <td><input type="text" name="unidad"/></td>
                    </tr>
                    <tr>
                        <td>Código FNA:</td>
                        <td><input type="text" name="codigoFNA"/></td>
                    </tr>
                    <tr>
                        <td>Código de aplicación:</td>
                        <td><input type="text" name="codigoAplicacion"/></td>
                    </tr>
                </table>
                </fieldset>
            </td>
            <td>
                <fieldset><legend align="left">Criterios de Agrupación</legend>
                <table>
                    <tr>
                        <td><input name="criticidad" type="checkbox"/>Criticidad</td>
                        <td><input name="vigencia" type="checkbox"/>Vigencia</td>
                    </tr>
                </table>
                </fieldset>
            </td>
            <tr height="40px">
                        <td colspan="8" style="background-color: #C0C0C0">
                            <input type= "submit" name="generarReporte" value= "Generar Reporte"></input>
                            <input type= "submit" name="regresar" value= "Regresar"></input>
                        </td>
            </tr>
            
            <td>
                <fieldset><legend align="left">Gráficos</legend>
                <table>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    
                </table>
                </fieldset>
            </td>
            <tr height="40px">
                        <td colspan="8" style="background-color: #C0C0C0">
                            <input type= "submit" name="exportar" value= "Exportar"></input>
                        </td>
            </tr>
        </table>
            
        </tr>
        
        
        
</table>
</form>
    </div>
<jsp:include page="../masterpage/inferior.jsp" />