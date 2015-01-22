<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Reporte de Nivel de Cumplimiento</h2>
    <form>
        <table bgcolor="#FFFFFF" width="1265" height="65%" border="0" cellspacing="0" cellpadding="0">
            <tr height="40px">
                <td>&nbsp;</td>
                <td >Gerencia General:</td>
                <td><input type="text" name="matricula" /></td>
            
                <td>Estado:</td>
                <td> 
                    <select name="estado">
                        <option value="activo">Activo</option>
                        <option value="inactivo">Inactivo</option>
                    </select>
                </td>
            
                <td >División</td>
                <td><input type="text" name="matricula" /></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td >Criticidad:</td>
                <td><input type="text" name="matricula" /></td>
                <td>Área:</td>
                <td><input type="text" name="apPaterno" /></td>
                <td>Código de Aplicación:</td>
                <td><input type="text" name="apMaterno" /></td>
                <td>&nbsp;</td>
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Unidad:</td>
                <td><input type="text" name="nombres" /></td>
            </tr>
          
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0">
                    <input type= "submit" name="generarReporte" value= "Generar Reporte"></input>
                    <input type= "submit" name="regresar" value= "Regresar"></input>
                </td>
            </tr>
            
            <tr height="500px">  </tr>
              
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0">
                    <input type= "submit" name="exportar" value= "Exportar"></input>
                </td>
            </tr>
            
            <tr height="10px">  </tr>
    
        </table>
    </form>
</div>
<jsp:include page="../masterpage/inferior.jsp" />